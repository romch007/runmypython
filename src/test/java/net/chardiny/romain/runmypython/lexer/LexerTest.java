package net.chardiny.romain.runmypython.lexer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import net.chardiny.romain.runmypython.lexer.tokens.Token;
import net.chardiny.romain.runmypython.lexer.tokens.TokenType;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LexerTest {
    @Test
    public void shouldLexBasicStuff() {
        String input = "m = p";
        Lexer l = new Lexer(input);
        List<Token> result = l.tokenize();
        assertEquals(result.get(0).getType(), TokenType.IDENTIFIER);
        assertEquals(result.get(1).getType(), TokenType.EQUAL);
        assertEquals(result.get(2).getType(), TokenType.IDENTIFIER);
        assertEquals(result.get(3).getType(), TokenType.END_OF_STREAM);
    }
}
