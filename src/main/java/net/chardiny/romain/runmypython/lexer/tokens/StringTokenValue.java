package net.chardiny.romain.runmypython.lexer.tokens;

public class StringTokenValue extends TokenValue {
    private final String value;

    public StringTokenValue(String value) { this.value = value; }

    public String getValue() {
        return value;
    }
}
