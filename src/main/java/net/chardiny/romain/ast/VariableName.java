package net.chardiny.romain.ast;

public class VariableName implements Expression {
    private final String name;

    public VariableName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
