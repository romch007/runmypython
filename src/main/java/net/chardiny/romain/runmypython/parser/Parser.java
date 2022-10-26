package net.chardiny.romain.runmypython.parser;

import net.chardiny.romain.runmypython.ast.Node;
import net.chardiny.romain.runmypython.ast.VariableAssignment;
import net.chardiny.romain.runmypython.ast.VariableName;
import net.chardiny.romain.runmypython.lexer.Token;
import net.chardiny.romain.runmypython.lexer.TokenType;

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
        Token token = this.peek(1);
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
        Token lvalueToken = this.expect(this.advance(), TokenType.IDENTIFIER);
        this.expect(this.advance(), TokenType.EQUAL);
        Token rvalueToken = this.expect(this.advance(), TokenType.IDENTIFIER);

        VariableName lvalue = new VariableName(lvalueToken.getValue());
        VariableName rvalue = new VariableName(rvalueToken.getValue());

        return new VariableAssignment(lvalue, rvalue);
    }
}
