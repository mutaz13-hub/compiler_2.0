
import AST.Python.*;
import Visitor.HTMLVisitor;
import antlrHTML.HTMLLexer;
import antlrHTML.HTMLParser;
import antlrPython.*;
import Visitor.PythonVisitor;
import Visitor.PythonSemanticAnalyzer;
import Visitor.HTMLVisitor;
import Visitor.HTMLSemanticAnalyzer;
import Generator.PythonCodeGenerator;
import Generator.HTMLCodeGenerator;
import AST.HTML.HtmlDocumentNode;
import AST.Python.Program;
import SymbolTable.SemanticError;
import Interpreter.PythonDataExtractor;
import Jinja.JinjaParser;
import Jinja.JinjaProgram;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;

import org.antlr.v4.runtime.CommonTokenStream;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import java.io.PrintWriter;

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
        List<File> candidates = new java.util.ArrayList<>();
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
        System.out.println("you want Python or HTML or Full Pipeline (Python data -> Jinja -> HTML)");
        System.out.println("1:Python" + "\n" + "2:HTML" + "\n" + "3:Full Pipeline");
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

            System.out.println("\n--- Semantic Analysis ---");
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

            System.out.println("\n--- Code Generation ---");
            PythonCodeGenerator generator = new PythonCodeGenerator();
            generator.generate(program);
            String generatedCode = generator.getGeneratedCode();
            System.out.println("Generated Python Code:");
            System.out.println("-----------------------");
            System.out.println(generatedCode);
            System.out.println("-----------------------");
            
            System.out.println("Do you want to save the generated code? (y/n)");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                try (FileWriter writer = new FileWriter("generated_app.py")) {
                    writer.write(generatedCode);
                    System.out.println("Code saved to generated_app.py");
                }
            }
        }
        else if (chose == 2) {
            System.out.println("Enter HTML file path (default: test/products.html):");
            String source = scanner.nextLine().trim();
            if (source.isEmpty()) source = "test/products.html";
            File htmlFile = resolveInputFile(source);
            CharStream charStream = CharStreams.fromFileName(htmlFile.getPath());
            HTMLLexer htmlLexer = new HTMLLexer(charStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(htmlLexer);
            HTMLParser htmlParser = new HTMLParser(commonTokenStream);

            HTMLVisitor htmlVisitor = new HTMLVisitor();

            HtmlDocumentNode program = (HtmlDocumentNode) htmlVisitor.visit(htmlParser.htmlDocument());

            System.out.println(program);
            htmlVisitor.getSymbolTable().printTable();

            System.out.println("\n--- Semantic Analysis ---");
            HTMLSemanticAnalyzer analyzer = new HTMLSemanticAnalyzer();
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

            System.out.println("\n--- Code Generation ---");
            HTMLCodeGenerator generator = new HTMLCodeGenerator();
            generator.generate(program);
            String generatedCode = generator.getGeneratedCode();
            System.out.println("Generated HTML Code:");
            System.out.println("-----------------------");
            System.out.println(generatedCode);
            System.out.println("-----------------------");

            System.out.println("Do you want to save the generated code? (y/n)");
            if (scanner.nextLine().equalsIgnoreCase("y")) {
                try (FileWriter writer = new FileWriter("generated_page.html")) {
                    writer.write(generatedCode);
                    System.out.println("Code saved to generated_page.html");
                }
            }
        }
        else if (chose == 3) {
            // Full pipeline: Flask/Python data file -> Python AST -> extracted
            // data -> Jinja template -> Jinja AST -> rendered HTML written to
            // output/, matching the project's required architecture
            // (Python data array fed into the Jinja tree, per the assignment
            // brief and the team's pipeline diagram).
            System.out.println("Enter Python data file path (default: test/simple_products.py):");
            String pySource = scanner.nextLine().trim();
            if (pySource.isEmpty()) pySource = "test/simple_products.py";

            System.out.println("Enter Jinja template path (default: templates/index.jinja):");
            String jinjaSource = scanner.nextLine().trim();
            if (jinjaSource.isEmpty()) jinjaSource = "templates/index.jinja";

            // --- Stage 1: Python file -> Python AST (reusing the existing pipeline) ---
            File pyDataFile = resolveInputFile(pySource);
            CharStream charStream = CharStreams.fromFileName(pyDataFile.getPath());
            PythonLexer pythonLexer = new PythonLexer(charStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(pythonLexer);
            PythonParser pythonParser = new PythonParser(commonTokenStream);
            PythonVisitor pythonVisitor = new PythonVisitor();
            Program program = (Program) pythonVisitor.visit(pythonParser.root());

            System.out.println("\n--- Python AST ---");
            System.out.println(program);

            System.out.println("\n--- Semantic Analysis (Python) ---");
            PythonSemanticAnalyzer pyAnalyzer = new PythonSemanticAnalyzer();
            pyAnalyzer.analyze(program);
            List<SemanticError> pyErrors = pyAnalyzer.getErrors();
            if (pyErrors.isEmpty()) {
                System.out.println("No semantic errors found.");
            } else {
                System.out.println("Found " + pyErrors.size() + " semantic error(s):");
                for (SemanticError error : pyErrors) System.out.println(error);
            }

            // --- Stage 2: extract literal data from the Python AST ("Python VM" step) ---
            PythonDataExtractor extractor = new PythonDataExtractor();
            extractor.extract(program);
            Map<String, Object> data = extractor.getGlobals();

            System.out.println("\n--- Extracted Data (passed into the Jinja tree) ---");
            if (data.isEmpty()) {
                System.out.println("(no top-level literal assignments found)");
            } else {
                for (Map.Entry<String, Object> e : data.entrySet()) {
                    System.out.println("  " + e.getKey() + " = " + e.getValue());
                }
            }

            // --- Stage 3: Jinja template -> Jinja AST ---
            File jinjaFile = resolveInputFile(jinjaSource);
            String templateText = new String(Files.readAllBytes(jinjaFile.toPath()));
            JinjaParser jinjaParser = new JinjaParser();
            JinjaProgram jinjaProgram = jinjaParser.parse(templateText);

            System.out.println("\n--- Jinja AST ---");
            jinjaProgram.print(0);

            // --- Stage 4: render Jinja AST against the extracted data -> HTML ---
            StringBuilder rendered = new StringBuilder();
            jinjaProgram.render(data, rendered);

            new File("output").mkdirs();
            String outName = "output/" + baseName(jinjaSource) + ".html";
            try (FileWriter writer = new FileWriter(outName)) {
                writer.write(rendered.toString());
            }

            System.out.println("\n--- Rendered HTML ---");
            System.out.println("-----------------------");
            System.out.println(rendered.toString());
            System.out.println("-----------------------");
            System.out.println("Saved to " + outName);
        }
    }

    private static String baseName(String path) {
        String name = new File(path).getName();
        int dot = name.lastIndexOf('.');
        return dot > 0 ? name.substring(0, dot) : name;
    }
}
