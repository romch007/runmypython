package net.chardiny.romain.lexer;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private int currentPosition = 0;
    private int lineStartPosition = 0;
    private String input;

    public Lexer(String input) {
        this.input = input;
    }

    private char peek(int advance) {
        return this.input.charAt(this.currentPosition + advance);
    }

    private char peek() {
        return this.peek(1);
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();

        for (; ; ) {

            Token token = new Token();

            if (this.currentPosition >= this.input.length()) {
                token.setType(TokenType.END_OF_STREAM);
                tokens.add(token);
                break;
            }

            char c = this.peek(0);

            switch (c) {
                case ' ':
                case '\t':
                case '\r':
                    break;
                case '\n':
                    token.setType(TokenType.NEWLINE);
                    break;
                case '=':
                    token.setType(TokenType.EQUAL);
                    break;
                case '(':
                    token.setType(TokenType.OPEN_PARENTHESIS);
                    break;
                case ')':
                    token.setType(TokenType.CLOSE_PARENTHESIS);
                    break;
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                    int nameStart = 0;

                    while (this.currentPosition + 1 < this.input.length() && Character.isAlphabetic(this.peek()))
                        this.currentPosition++;

                    String name = this.input.substring(this.currentPosition, this.currentPosition + nameStart + 1);
                    token.setType(TokenType.IDENTIFIER);
                    token.setValue(name);
                    break;
                // Store name
            }

            if (token.getType() != null)
                tokens.add(token);

            this.currentPosition++;
        }

        return tokens;
    }

}
