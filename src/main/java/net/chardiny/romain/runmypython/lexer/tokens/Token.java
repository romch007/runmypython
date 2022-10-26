package net.chardiny.romain.runmypython.lexer.tokens;

public class Token {
    private TokenType type;
    private TokenValue value;

    public Token() {
    }

    public TokenType getType() {
        return this.type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public TokenValue getValue() {
        return this.value;
    }

    public void setValue(TokenValue value) {
        this.value = value;
    }
}