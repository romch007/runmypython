package net.chardiny.romain.parser;

import net.chardiny.romain.lexer.TokenType;

public class InvalidTokenException extends Exception {
    public InvalidTokenException(TokenType expected, TokenType found) {
        super("expected" + expected.toString() + " but found " + found.toString());
    }
}
