package ru.kolyanov.input;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class InputTests {

    IReader stringReader;
    @Test(expected = ReaderException.class)
    public void testInput() throws ReaderException, IOException {
        stringReader  = new StringReader("qw");
        stringReader.close();
        assertEquals("input failed", stringReader.getSymbol(), 'q');
        assertEquals("input failed", stringReader.getSymbol(), 'w');
        assertEquals("input failed", stringReader.getSymbol(), 'e');
    }

    @Test(expected = ReaderException.class)
    public void testInput2() throws ReaderException, IOException {
        stringReader  = new StringReader(null);
        stringReader.close();
        assertEquals("input failed", stringReader.getSymbol(), 'q');
        assertEquals("input failed", stringReader.getSymbol(), 'w');
        assertEquals("input failed", stringReader.getSymbol(), 'e');
    }

    @Test(expected = ReaderException.class)
    public void testInput3() throws ReaderException, IOException {
        stringReader  = new FileReader("//");
        stringReader.close();
        assertEquals("input failed", stringReader.getSymbol(), 'q');
        assertEquals("input failed", stringReader.getSymbol(), 'w');
        assertEquals("input failed", stringReader.getSymbol(), 'e');
    }

    @Test(expected = ReaderException.class)
    public void testInput4() throws ReaderException, IOException {
        File tmp = File.createTempFile("data", null);
        stringReader  = new FileReader(tmp.getAbsolutePath());
        stringReader.close();
        assertEquals("input failed", stringReader.getSymbol(), 'q');
        assertEquals("input failed", stringReader.getSymbol(), 'w');
        assertEquals("input failed", stringReader.getSymbol(), 'e');

    }
}
