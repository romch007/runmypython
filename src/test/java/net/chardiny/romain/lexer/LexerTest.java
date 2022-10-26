package net.chardiny.romain.lexer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.List;

public class LexerTest {
    @Test
    public void shouldLexBasicStuff() {
        String input = "m = p";
        Lexer l = new Lexer(input);
        List<Token> result = l.tokenize();
        assertEquals(result.get(0).getType(), TokenType.IDENTIFIER);
        assertEquals(result.get(0).getValue(), "m");
        assertEquals(result.get(1).getType(), TokenType.EQUAL);
        assertEquals(result.get(2).getType(), TokenType.IDENTIFIER);
        assertEquals(result.get(2).getValue(), "p");
        assertEquals(result.get(3).getType(), TokenType.END_OF_STREAM);
    }
}
