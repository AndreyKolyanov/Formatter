package ru.andrewkolyanov.output;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class OutputTests {

    IWriter writer;
    @Test
    public void testOutput() throws WritingException{
        writer = new StringWriter();
        writer.printLine("hello");
        writer.printLine("world");
        writer.write();
        assertEquals("output failed", "hello\nworld\n", writer.getLines());
    }

    @Test
    public void testOutput2() throws WritingException, IOException {
        File tmp = File.createTempFile("out", null);
        writer = new FileWriter(tmp.getAbsolutePath());
        writer.printLine("hello");
        writer.printLine("world");
        assertEquals("output failed", "hello\nworld\n", writer.getLines());
    }
}
