package net.chardiny.romain.runmypython.ast;

public record VariableAssignment(VariableName lvalue, Expression rvalue) implements Node {

    @Override
    public void execute() {
        System.out.println("assigning variable :)");
    }

    @Override
    public String printDebug() {
        return String.format("VariableAssignment(%s = %s)", this.lvalue.printDebug(), this.rvalue.printDebug());
    }
}
