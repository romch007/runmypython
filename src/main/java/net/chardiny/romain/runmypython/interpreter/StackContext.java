package net.chardiny.romain.runmypython.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;

public class StackContext {
    private final Deque<HashMap<String, String>> frames = new ArrayDeque<>();

    public StackContext() {}

    public String findElement(String name) throws UndefinedReferenceException {
       Iterator<HashMap<String, String>> it = this.frames.descendingIterator();
       while (it.hasNext()) {
           HashMap<String, String> currentFrame = it.next();
           if (currentFrame.containsKey(name))
               return currentFrame.get(name);
       }
       throw new UndefinedReferenceException(name);
    }

    public void insertElement(String name, String element) {
        this.frames.getLast().put(name, element);
    }

    public void pushNewFrame() {
        this.frames.push(new HashMap<>());
    }

    public void popNewFrame() {
        this.frames.pop();
    }
}
