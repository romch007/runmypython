package net.chardiny.romain.runmypython.interpreter;

public class UndefinedReferenceException extends Exception {
    public UndefinedReferenceException(String referenceName) {
        super(String.format("undefined reference to '%s'", referenceName));
    }
}
