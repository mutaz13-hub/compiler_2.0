
import AST.Python.*;
import Visitor.HTMLVisitor;
import antlrHTML.HTMLLexer;
import antlrHTML.HTMLParser;
import antlrPython.*;
import Visitor.PythonVisitor;
import Visitor.PythonSemanticAnalyzer;
import Visitor.HTMLSemanticAnalyzer;
import AST.HTML.HtmlDocumentNode;
import AST.Python.Program;
import SymbolTable.SemanticError;
import Interpreter.PythonDataExtractor;
import Jinja.JinjaParser;
import Jinja.JinjaProgram;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import org.antlr.v4.runtime.CommonTokenStream;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    /**
     * Resolves a user-typed file path robustly and fails with a clear,
     * actionable message instead of a raw stack trace.
     *
     * The typical cause of "NoSuchFileException: test\app.py" is that the
     * JVM's working directory isn't the project root - e.g. running from
     * IntelliJ with a run-configuration "Working directory" pointed
     * elsewhere, or launching `java` from a different folder on Windows.
     * Relative paths like "test/app.py" are resolved against whatever that
     * working directory happens to be, not against wherever Main.java or
     * the source files physically live.
     *
     * This tries the path as typed, then a couple of sensible fallbacks
     * relative to where the running .class/.jar actually is, before giving
     * up with a message that shows exactly what was tried.
     */
    private static File resolveInputFile(String typedPath) {
        List<File> candidates = new ArrayList<>();
        candidates.add(new File(typedPath));

        try {
            File codeSource = new File(Main.class.getProtectionDomain()
                    .getCodeSource().getLocation().toURI());
            // codeSource is usually .../build (classes dir) or a jar file;
            // the project root is typically its parent.
            File nearRoot = codeSource.isDirectory() ? codeSource.getParentFile() : codeSource.getParentFile();
            if (nearRoot != null) {
                candidates.add(new File(nearRoot, typedPath));
            }
        } catch (Exception ignored) {
            // Best-effort only - fall through to the plain candidates below.
        }

        for (File f : candidates) {
            if (f.isFile()) return f;
        }

        StringBuilder msg = new StringBuilder();
        msg.append("Could not find file: ").append(typedPath).append("\n");
        msg.append("Current working directory: ").append(new File(".").getAbsolutePath()).append("\n");
        msg.append("Tried:\n");
        for (File f : candidates) {
            msg.append("  - ").append(f.getAbsolutePath()).append("\n");
        }
        msg.append("Either type the full path to the file, or run the program from the project's root folder (the one containing the 'test' and 'templates' directories).");
        System.err.println(msg);
        System.exit(1);
        return null; // unreachable
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1: Python Semantic Check" + "\n" + "2: HTML + Jinja + CSS Semantic Check" + "\n" + "3: Code Generation (Full Site)");
        int chose = 0;
        if (scanner.hasNextInt()) {
            chose = scanner.nextInt();
        }
        scanner.nextLine(); // consume the rest of the line

        if (chose == 1) {
            System.out.println("Enter Python file path (default: test/app.py):");
            String source = scanner.nextLine().trim();
            if (source.isEmpty()) source = "test/app.py";
            File pyFile = resolveInputFile(source);
            CharStream charStream = CharStreams.fromFileName(pyFile.getPath());
            PythonLexer pythonLexer = new PythonLexer(charStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(pythonLexer);
            PythonParser pythonParser = new PythonParser(commonTokenStream);

            PythonVisitor pythonVisitor = new PythonVisitor();
            Program program = (Program) pythonVisitor.visit(pythonParser.root());

            System.out.println(program);
            pythonVisitor.getSymbolTable().printTable();

            System.out.println("\n--- Semantic Analysis (Python) ---");
            PythonSemanticAnalyzer analyzer = new PythonSemanticAnalyzer();
            analyzer.analyze(program);
            List<SemanticError> errors = analyzer.getErrors();
            if (errors.isEmpty()) {
                System.out.println("No semantic errors found.");
            } else {
                System.out.println("Found " + errors.size() + " semantic error(s):");
                for (SemanticError error : errors) {
                    System.out.println(error);
                }
            }
        }
        else if (chose == 2) {
            System.out.println("Enter HTML/Jinja file path (default: test/products.html):");
            String source = scanner.nextLine().trim();
            if (source.isEmpty()) source = "test/products.html";
            File htmlFile = resolveInputFile(source);

            // --- HTML ---
            CharStream charStream = CharStreams.fromFileName(htmlFile.getPath());
            HTMLLexer htmlLexer = new HTMLLexer(charStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(htmlLexer);
            HTMLParser htmlParser = new HTMLParser(commonTokenStream);
            HTMLVisitor htmlVisitor = new HTMLVisitor();
            HtmlDocumentNode htmlDoc = (HtmlDocumentNode) htmlVisitor.visit(htmlParser.htmlDocument());

            System.out.println(htmlDoc);
            htmlVisitor.getSymbolTable().printTable();

            System.out.println("\n--- Semantic Analysis (HTML) ---");
            HTMLSemanticAnalyzer htmlAnalyzer = new HTMLSemanticAnalyzer();
            htmlAnalyzer.analyze(htmlDoc);
            List<SemanticError> htmlErrors = htmlAnalyzer.getErrors();
            if (htmlErrors.isEmpty()) {
                System.out.println("No semantic errors found.");
            } else {
                System.out.println("Found " + htmlErrors.size() + " semantic error(s):");
                for (SemanticError error : htmlErrors) System.out.println(error);
            }

            // --- CSS: any <style> blocks embedded in the HTML ---
            List<AST.HTML.StyleNode> styleNodes = new ArrayList<>();
            for (AST.HTML.Program el : htmlDoc.getElements()) {
                collectStyleNodes(el, styleNodes);
            }

            System.out.println("\n--- Semantic Analysis (CSS) ---");
            if (styleNodes.isEmpty()) {
                System.out.println("No embedded <style> blocks found.");
            } else {
                int i = 1;
                for (AST.HTML.StyleNode styleNode : styleNodes) {
                    System.out.println("[style block " + i + " of " + styleNodes.size() + "]");
                    String cssBody = stripStyleTags(styleNode.getBody());
                    try {
                        CharStream cssCharStream = CharStreams.fromString(cssBody);
                        antlrCSS.CSSLexer cssLexer = new antlrCSS.CSSLexer(cssCharStream);
                        CommonTokenStream cssTokens = new CommonTokenStream(cssLexer);
                        antlrCSS.CSSParser cssParser = new antlrCSS.CSSParser(cssTokens);
                        Visitor.CSSVisitor cssVisitor = new Visitor.CSSVisitor();
                        AST.CSS.CSSProgram cssProgram = cssVisitor.visitProgram(cssParser.stylesheet());

                        Visitor.CSSSemanticAnalyzer cssAnalyzer = new Visitor.CSSSemanticAnalyzer();
                        cssAnalyzer.analyze(cssProgram);
                        List<SemanticError> cssErrors = cssAnalyzer.getErrors();
                        if (cssErrors.isEmpty()) {
                            System.out.println("No semantic errors found.");
                        } else {
                            for (SemanticError error : cssErrors) System.out.println(error);
                        }
                    } catch (Exception e) {
                        System.out.println("Could not parse this <style> block: " + e.getMessage());
                    }
                    i++;
                }
            }

            // --- Jinja: the file's {{ }} / {% %} tags, checked against real
            // data when a sibling products_data.json is available ---
            System.out.println("\n--- Semantic Analysis (Jinja) ---");
            String templateText = new String(Files.readAllBytes(htmlFile.toPath()), StandardCharsets.UTF_8);
            JinjaParser jinjaParser = new JinjaParser();
            JinjaProgram jinjaProgram = jinjaParser.parse(templateText);

            Map<String, Object> jinjaContext = new HashMap<>();
            jinjaContext.put("products", loadProductsJsonNear(htmlFile, null));
            jinjaContext.put("product", null);
            jinjaContext.put("show_add", false);

            Visitor.JinjaSemanticAnalyzer jinjaAnalyzer = new Visitor.JinjaSemanticAnalyzer();
            jinjaAnalyzer.analyze(jinjaProgram, jinjaContext);
            List<SemanticError> jinjaErrors = jinjaAnalyzer.getErrors();
            if (jinjaErrors.isEmpty()) {
                System.out.println("No semantic errors found.");
            } else {
                System.out.println("Found " + jinjaErrors.size() + " semantic error(s):");
                for (SemanticError error : jinjaErrors) System.out.println(error);
            }
        }
        else if (chose == 3) {
            // Generates a working static site from a Flask app.py + its
            // products.html template (which has {% if/elif/else %} +
            // {% for %} Jinja blocks mixed directly into the HTML, rendered
            // via render_template_string at runtime instead of separate
            // template files):
            //   output/            <- index.html, product_detail.html,
            //                         add_product.html (generated, one per
            //                         real Flask route) + app.py,
            //                         products.html, products_data.json
            //                         (copied verbatim so the real Flask
            //                         app keeps working unmodified)
            //   compiler_output/   <- ast_python.json, ast_jinja.json,
            //                         semantic_report.txt, generation_log.txt
            List<String> log = new ArrayList<>();
            log.add("Generation started.");

            System.out.println("Enter Python (Flask) file path (default: test/app.py):");
            String pySource = scanner.nextLine().trim();
            if (pySource.isEmpty()) pySource = "test/app.py";

            System.out.println("Enter HTML/Jinja template file path (default: test/products.html):");
            String htmlSource = scanner.nextLine().trim();
            if (htmlSource.isEmpty()) htmlSource = "test/products.html";

            File pyFile = resolveInputFile(pySource);
            File templateFile = resolveInputFile(htmlSource);

            // --- Python: parse + semantic analysis (report only - does not block generation) ---
            CharStream pyCharStream = CharStreams.fromFileName(pyFile.getPath());
            PythonLexer pyLexer = new PythonLexer(pyCharStream);
            CommonTokenStream pyTokens = new CommonTokenStream(pyLexer);
            PythonParser pyParser = new PythonParser(pyTokens);
            PythonVisitor pyVisitor = new PythonVisitor();
            Program pyProgram = (Program) pyVisitor.visit(pyParser.root());
            log.add("Parsed Python file: " + pyFile.getPath());

            PythonSemanticAnalyzer pyAnalyzer = new PythonSemanticAnalyzer();
            pyAnalyzer.analyze(pyProgram);
            log.add("Python semantic analysis: " + pyAnalyzer.getErrors().size() + " error(s).");

            // --- Data: products_data.json next to the Python file is the
            // real data this Flask app serves at runtime (app.py reads it
            // via load_products()); fall back to a top-level literal
            // Python assignment (e.g. webapp_products.py-style files) if
            // there's no JSON file to read. ---
            List<Object> products = loadProductsJsonNear(pyFile, log);
            if (products.isEmpty()) {
                PythonDataExtractor extractor = new PythonDataExtractor();
                extractor.extract(pyProgram);
                Object literalProducts = extractor.getGlobals().get("products");
                if (literalProducts instanceof List) {
                    @SuppressWarnings("unchecked")
                    List<Object> asList = (List<Object>) literalProducts;
                    products = asList;
                    log.add("No usable products_data.json - fell back to a literal 'products' assignment found in " + pyFile.getPath());
                }
            }

            // --- Jinja: parse the template once, render it against 3
            // different contexts matching the 3 real Flask routes that
            // serve this template (index, product_detail, add_product). ---
            String templateText = new String(Files.readAllBytes(templateFile.toPath()), StandardCharsets.UTF_8);
            JinjaParser jinjaParser = new JinjaParser();
            JinjaProgram jinjaTree = jinjaParser.parse(templateText);
            log.add("Parsed Jinja/HTML template: " + templateFile.getPath());

            Map<String, Object> indexContext = new HashMap<>();
            indexContext.put("products", products);
            indexContext.put("product", null);
            indexContext.put("show_add", false);

            Map<String, Object> detailContext = new HashMap<>();
            detailContext.put("products", new ArrayList<>());
            detailContext.put("show_add", false);
            if (!products.isEmpty()) {
                detailContext.put("product", products.get(0));
                log.add("product_detail.html rendered using the first product as a representative example (static generation has no per-URL routing).");
            } else {
                detailContext.put("product", null);
                log.add("WARNING: no products available - product_detail.html rendered with no 'product' in context.");
            }

            Map<String, Object> addContext = new HashMap<>();
            addContext.put("products", new ArrayList<>());
            addContext.put("product", null);
            addContext.put("show_add", true);

            new File("output").mkdirs();
            new File("compiler_output").mkdirs();

            StringBuilder semanticReport = new StringBuilder();
            semanticReport.append("=== Python Semantic Analysis (").append(pyFile.getPath()).append(") ===\n");
            if (pyAnalyzer.getErrors().isEmpty()) {
                semanticReport.append("No semantic errors found.\n");
            } else {
                for (SemanticError e : pyAnalyzer.getErrors()) semanticReport.append(e).append("\n");
            }

            renderPage(jinjaTree, indexContext, "output/index.html", "index (products grid)", semanticReport, log);
            renderPage(jinjaTree, detailContext, "output/product_detail.html", "product_detail", semanticReport, log);
            renderPage(jinjaTree, addContext, "output/add_product.html", "add_product (form)", semanticReport, log);

            // --- Companion files that keep the real Flask app runnable, copied verbatim ---
            copyCompanionFile(pyFile.getPath(), "output/" + pyFile.getName(), log);
            copyCompanionFile(templateFile.getPath(), "output/" + templateFile.getName(), log);
            File dataFile = new File(pyFile.getParentFile() != null ? pyFile.getParentFile() : new File("."), "products_data.json");
            if (dataFile.isFile()) {
                copyCompanionFile(dataFile.getPath(), "output/products_data.json", log);
            }

            // --- compiler_output/: analysis + generation artifacts ---
            String pythonAstJson = Util.JsonExporter.toJson(pyProgram);
            try (FileWriter w = new FileWriter("compiler_output/ast_python.json")) { w.write(pythonAstJson); }
            log.add("Wrote compiler_output/ast_python.json");

            String jinjaAstJson = Util.JsonExporter.toJson(jinjaTree);
            try (FileWriter w = new FileWriter("compiler_output/ast_jinja.json")) { w.write(jinjaAstJson); }
            log.add("Wrote compiler_output/ast_jinja.json");

            try (FileWriter w = new FileWriter("compiler_output/semantic_report.txt")) { w.write(semanticReport.toString()); }
            log.add("Wrote compiler_output/semantic_report.txt");

            try (FileWriter w = new FileWriter("compiler_output/generation_log.txt")) {
                for (String entry : log) w.write(entry + "\n");
                w.write("Generation finished.\n");
            }

            System.out.println("\nGenerated:");
            System.out.println("  output/index.html, output/product_detail.html, output/add_product.html");
            System.out.println("  output/" + pyFile.getName() + ", output/" + templateFile.getName()
                    + (dataFile.isFile() ? ", output/products_data.json" : "") + " (copied, unmodified)");
            System.out.println("  compiler_output/ast_python.json, ast_jinja.json, semantic_report.txt, generation_log.txt");
            System.out.println("\nTo run the real site: cd output && python " + pyFile.getName());
        }
    }

    /** Parses one Jinja/HTML template once and renders it against N different contexts (see below) - this call handles one context. */
    private static void renderPage(JinjaProgram tree, Map<String, Object> context, String outPath, String label, StringBuilder semanticReport, List<String> log) throws IOException {
        Visitor.JinjaSemanticAnalyzer analyzer = new Visitor.JinjaSemanticAnalyzer();
        analyzer.analyze(tree, context);
        semanticReport.append("\n=== Jinja Semantic Analysis (").append(label).append(" -> ").append(outPath).append(") ===\n");
        if (analyzer.getErrors().isEmpty()) {
            semanticReport.append("No semantic errors found.\n");
        } else {
            for (SemanticError e : analyzer.getErrors()) semanticReport.append(e).append("\n");
        }

        StringBuilder rendered = new StringBuilder();
        tree.render(context, rendered);
        try (FileWriter writer = new FileWriter(outPath)) {
            writer.write(rendered.toString());
        }
        log.add("Rendered " + label + " -> " + outPath + " (" + analyzer.getErrors().size() + " semantic error(s))");
    }

    /** Recursively collects every <style> block nested anywhere in the HTML element tree. */
    private static void collectStyleNodes(AST.HTML.Program node, List<AST.HTML.StyleNode> out) {
        if (node instanceof AST.HTML.StyleNode) {
            out.add((AST.HTML.StyleNode) node);
        } else if (node instanceof AST.HTML.TagElementNode) {
            for (AST.HTML.Program child : ((AST.HTML.TagElementNode) node).getChildren()) {
                collectStyleNodes(child, out);
            }
        }
    }

    /** A StyleNode's body is the raw text of the whole `<style ...> ... </style>` element; strip the tags so what's left is parseable CSS. */
    private static String stripStyleTags(String raw) {
        String body = raw.replaceFirst("(?is)^<style[^>]*>", "");
        body = body.replaceFirst("(?is)</style>\\s*$", "");
        return body;
    }

    /** Loads a sibling products_data.json (same directory as anchorFile) into a list of Java objects, or an empty list if it's missing/unreadable. */
    private static List<Object> loadProductsJsonNear(File anchorFile, List<String> log) {
        File dir = anchorFile.getParentFile();
        File jsonFile = new File(dir != null ? dir : new File("."), "products_data.json");
        if (!jsonFile.isFile()) {
            if (log != null) log.add("No products_data.json found next to " + anchorFile.getPath() + " - using an empty product list.");
            return new ArrayList<>();
        }
        try {
            String text = new String(Files.readAllBytes(jsonFile.toPath()), StandardCharsets.UTF_8);
            Object parsed = Util.SimpleJsonParser.parse(text);
            if (parsed instanceof List) {
                @SuppressWarnings("unchecked")
                List<Object> list = (List<Object>) parsed;
                if (log != null) log.add("Loaded " + list.size() + " product(s) from " + jsonFile.getPath());
                return list;
            }
        } catch (Exception e) {
            if (log != null) log.add("WARNING: failed to parse " + jsonFile.getPath() + " (" + e.getMessage() + ") - using an empty product list.");
        }
        return new ArrayList<>();
    }

    /** Copies a file byte-for-byte with no processing - companion files aren't analyzed or generated, just kept working. */
    private static void copyCompanionFile(String srcPath, String destPath, List<String> log) {
        try {
            File src = resolveInputFile(srcPath);
            Files.copy(src.toPath(), new File(destPath).toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            log.add("Copied " + srcPath + " -> " + destPath + " (unmodified)");
        } catch (Exception e) {
            log.add("WARNING: could not copy " + srcPath + " -> " + destPath + " (" + e.getMessage() + ")");
        }
    }
}
