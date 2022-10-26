package net.chardiny.romain.runmypython.parser;

import net.chardiny.romain.runmypython.lexer.TokenType;

public class InvalidTokenException extends Exception {
    public InvalidTokenException(TokenType expected, TokenType found) {
        super(String.format("expected %s but found %s", expected.toString(), found.toString()));
    }
}
