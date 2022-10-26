package net.chardiny.romain.runmypython.parser;

import net.chardiny.romain.runmypython.ast.*;
import net.chardiny.romain.runmypython.lexer.tokens.IntegerTokenValue;
import net.chardiny.romain.runmypython.lexer.tokens.StringTokenValue;
import net.chardiny.romain.runmypython.lexer.tokens.Token;
import net.chardiny.romain.runmypython.lexer.tokens.TokenType;

import java.util.*;

public class Parser {
    private final ParserContext context;

    public Parser(List<Token> tokens) {
        context = new ParserContext(0, tokens);
    }

    private Token advance() {
        Token token = this.peek();
        this.context.index++;
        return token;
    }

    private void consume(int count) {
        this.context.index += count;
    }

    private void consume() {
        this.consume(1);
    }

    private Token peek(int advance) {
        return this.context.getTokens().get(context.index + advance);
    }

    private Token peek() {
        return this.peek(0);
    }

    private Token expect(Token token, TokenType tokenType) throws InvalidTokenException {
        if (token.getType() != tokenType)
            throw new InvalidTokenException(tokenType, token.getType());
        return token;
    }

    private Token expect(TokenType tokenType) throws InvalidTokenException {
        Token token = this.peek();
        this.expect(token, tokenType);
        return token;
    }

    public List<Node> parse() throws InvalidTokenException {
        List<Node> topNodes = new ArrayList<>();

        do {
            Token currentToken = this.peek();
            Node parsedExpression = this.parseVariableAssignment();
            topNodes.add(parsedExpression);
        } while (this.advance().getType() == TokenType.NEWLINE);

        return topNodes;
    }

    private VariableAssignment parseVariableAssignment() throws InvalidTokenException {
        VariableName lvalue = this.parseVariableName();
        this.expect(this.advance(), TokenType.EQUAL);
        Expression rvalue = this.parseExpression();

        return new VariableAssignment(lvalue, rvalue);
    }

    private Expression parseExpression() throws InvalidTokenException {
        Token token = this.peek();
        return switch (token.getType()) {
            case IDENTIFIER -> this.parseVariableName();
            case NUMBER_LITERAL -> this.parseNumberLiteral();
            default -> throw new InvalidTokenException("invalid expression");
        };
    }

    private VariableName parseVariableName() throws InvalidTokenException {
        Token token = this.expect(this.advance(), TokenType.IDENTIFIER);
        return new VariableName(((StringTokenValue) token.getValue()).getValue());
    }

    private NumberLiteral parseNumberLiteral() throws InvalidTokenException {
       Token token = this.expect(this.advance(), TokenType.NUMBER_LITERAL);
       return new NumberLiteral(((IntegerTokenValue) token.getValue()).getValue());
    }
}
