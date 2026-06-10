
import AST.Python.*;
import Visitor.HTMLVisitor;
import antlrHTML.HTMLLexer;
import antlrHTML.HTMLParser;
import antlrPython.*;
import Visitor.PythonVisitor;
import Visitor.PythonSemanticAnalyzer;
import Visitor.HTMLVisitor;
import Visitor.HTMLSemanticAnalyzer;
import AST.HTML.HtmlDocumentNode;
import AST.Python.Program;
import SymbolTable.SemanticError;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;

import org.antlr.v4.runtime.CommonTokenStream;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("you want Python or HTML");
        System.out.println("1:Python"+"\n"+"2:HTML");
        int chose = 0;
        if (scanner.hasNextInt()) {
            chose = scanner.nextInt();
        }
        scanner.nextLine(); // consume the rest of the line

        if (chose == 1) {
            System.out.println("Enter Python file path (default: test/app.py):");
            String source = scanner.nextLine().trim();
            if (source.isEmpty()) source = "test/app.py";
            CharStream charStream = CharStreams.fromFileName(source);
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
        }
        else if (chose == 2) {
            System.out.println("Enter HTML file path (default: test/products.html):");
            String source = scanner.nextLine().trim();
            if (source.isEmpty()) source = "test/products.html";
            CharStream charStream = CharStreams.fromFileName(source);
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
        }
    }
}
