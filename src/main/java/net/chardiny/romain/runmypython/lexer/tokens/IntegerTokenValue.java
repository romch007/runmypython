package net.chardiny.romain.runmypython.lexer.tokens;

public class IntegerTokenValue extends TokenValue {
    private final int value;

    public IntegerTokenValue(int value) { this.value = value; }

    public int getValue() {
        return value;
    }
}
