package net.chardiny.romain.runmypython.interpreter;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StackContextTest {
    @Test
    public void shouldFindVariableInStackFrames() {
        String content = "content";
        String variableName = "global_variable";

        StackContext stackContext = new StackContext();
        stackContext.pushNewFrame();
        stackContext.insertElement(variableName, content);
        stackContext.pushNewFrame();



        String value = null;

        try {
            value = stackContext.findElement(variableName);
        } catch (UndefinedReferenceException e) {
            fail("Undefined Reference was raised");
        }

        assertEquals(content, value);
    }

    @Test
    public void shouldDiscardStackFrames() {
        String variableName = "global_variable";

        StackContext stackContext = new StackContext();
        stackContext.pushNewFrame();
        stackContext.insertElement(variableName, "fazfe");
        stackContext.popNewFrame();

        assertThrows(UndefinedReferenceException.class, () -> {
            String value = stackContext.findElement(variableName);
        });
    }
}
