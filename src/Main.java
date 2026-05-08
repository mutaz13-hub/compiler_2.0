
import AST.Python.*;
import Visitor.HTMLVisitor;
import antlrHTML.HTMLLexer;
import antlrHTML.HTMLParser;
import antlrPython.*;
import Visitor.PythonVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTree;

import org.antlr.v4.runtime.CommonTokenStream;


import java.io.IOException;
import java.util.Scanner;

import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("you want Python or HTML");
        System.out.println("1:Python"+"\n"+"2:HTML");
        int chose = scanner.nextInt();
        if (chose == 1) {
            String source = "test/app.py";
            CharStream charStream = CharStreams.fromFileName(source);
            PythonLexer lexer = new PythonLexer(charStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            PythonParser parser = new PythonParser(tokens);
            ParseTree tree = parser.root();
            PythonVisitor pythonVisitor = new PythonVisitor();
            Program program = (Program) pythonVisitor.visit(tree);

            System.out.println(program);
            pythonVisitor.getSymbolTable().printTable();

            String htmlSymbolTable = pythonVisitor.getSymbolTable().getSymbolTableAsHtml();

            try (PrintWriter out = new PrintWriter("python_symbol_table.html")) {
                out.println(htmlSymbolTable);
            }
            System.out.println("Python symbol table generated to python_symbol_table.html");

        }
        else if (chose == 2){
            String source = "test/products.html";
            CharStream charStream = CharStreams.fromFileName(source);
            HTMLLexer lexer = new HTMLLexer(charStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            HTMLParser parser = new HTMLParser(tokens);
            ParseTree tree = parser.root();
            HTMLVisitor htmlVisitor = new HTMLVisitor();
            AST.HTML.Program program = (AST.HTML.Program) htmlVisitor.visit(tree);

            System.out.println(program);
            htmlVisitor.htmlSymbolTable.printTable();

            // Generate and save HTML symbol table
            String htmlSymbolTable = htmlVisitor.htmlSymbolTable.getSymbolTableAsHtml();
            try (PrintWriter out = new PrintWriter("html_symbol_table.html")) {
                out.println(htmlSymbolTable);
            }
            System.out.println("HTML symbol table generated to html_symbol_table.html");


        }
    }
}
