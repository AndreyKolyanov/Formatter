package ru.kolyanov.output;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OutputTests {

    StringWriter writer;
    @Test
    public void testOutput() throws WritingException{
        writer = new StringWriter();
        writer.printLine("hello");
        writer.printLine("world");
        assertEquals("output failed", "hello\nworld\n", writer.getLines());
    }
}
