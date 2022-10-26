package net.chardiny.romain;

import net.chardiny.romain.lexer.Lexer;
import net.chardiny.romain.lexer.Token;

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

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("No file provided");
            return;
        }

        String fileContent = null;
        try {
            fileContent = readFile(args[1]);
        } catch (IOException e) {
            System.out.println("Error opening the file: " + e.getMessage());
            return;
        }

        Lexer lexer = new Lexer(fileContent);
        List<Token> tokens = lexer.tokenize();
    }
}