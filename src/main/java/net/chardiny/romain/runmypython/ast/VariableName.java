package net.chardiny.romain.runmypython.ast;

public record VariableName(String name) implements Expression {
    @Override
    public String printDebug() {
        return String.format("VariableName(%s)", this.name);
    }
}
