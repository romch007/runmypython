package net.chardiny.romain.runmypython.parser;

import net.chardiny.romain.runmypython.lexer.tokens.TokenType;

public class InvalidTokenException extends Exception {
    public InvalidTokenException(String message) {
        super(message);
    }

    public InvalidTokenException(TokenType expected, TokenType found) {
        super(String.format("expected %s but found %s", expected.toString(), found.toString()));
    }
}
