package net.chardiny.romain.runmypython.ast;

public record NumberLiteral(int content) implements Expression {
    @Override
    public String printDebug() {
        return String.format("NumberLiteral(%d)", this.content);
    }
}
