package net.chardiny.romain.runmypython;

import net.chardiny.romain.runmypython.ast.Node;
import net.chardiny.romain.runmypython.lexer.Lexer;
import net.chardiny.romain.runmypython.lexer.Token;
import net.chardiny.romain.runmypython.parser.InvalidTokenException;
import net.chardiny.romain.runmypython.parser.Parser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static String readFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        return Files.readString(path, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("No file provided");
            return;
        }

        String fileContent = null;
        try {
            fileContent = readFile(args[0]);
        } catch (IOException e) {
            System.out.println("Error opening the file: " + e.getMessage());
            return;
        }

        Lexer lexer = new Lexer(fileContent);
        List<Token> tokens = lexer.tokenize();
        Parser parser = new Parser(tokens);
        List<Node> topNodes = null;
        try {
            topNodes = parser.parse();
        } catch (InvalidTokenException e) {
            System.out.println("invalid token: " + e.getMessage());
            return;
        }

        System.out.println("AST:");
        for (Node node : topNodes)
            System.out.println(node.printDebug());

        System.out.println("EXECUTION:");
        for (Node node : topNodes)
            node.execute();
    }
}