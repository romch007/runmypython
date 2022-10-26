package net.chardiny.romain.ast;

public class VariableAssignment implements Node {
    private final VariableName lvalue;
    private final Expression rvalue;

    public VariableAssignment(VariableName lvalue, Expression rvalue) {
        this.lvalue = lvalue;
        this.rvalue = rvalue;
    }

    @Override
    public void execute() {
        System.out.println("assigning variable :)");
    }

    public VariableName getLvalue() {
        return lvalue;
    }

    public Expression getRvalue() {
        return rvalue;
    }
}
