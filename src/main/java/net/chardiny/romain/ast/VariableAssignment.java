package net.chardiny.romain.ast;

public record VariableAssignment(VariableName lvalue, Expression rvalue) implements Node {

    @Override
    public void execute() {
        System.out.println("assigning variable :)");
    }
}
