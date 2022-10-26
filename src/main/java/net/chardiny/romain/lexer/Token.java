package net.chardiny.romain.lexer;

public class Token {
    private TokenType type;
    private String value;

    public Token() {
    }

    public TokenType getType() {
        return this.type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}