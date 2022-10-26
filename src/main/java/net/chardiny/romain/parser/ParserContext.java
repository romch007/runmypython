package net.chardiny.romain.parser;

import net.chardiny.romain.lexer.Token;

import java.util.List;

public class ParserContext {
    public int index;
    private final List<Token> tokens;

    public ParserContext(int index, List<Token> tokens) {
        this.index = index;
        this.tokens = tokens;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Token> getTokens() {
        return tokens;
    }
}

