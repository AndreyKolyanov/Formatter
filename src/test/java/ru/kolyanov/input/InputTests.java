package ru.kolyanov.input;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InputTests {

    IReader stringReader;
    @Test(expected = ReaderException.class)
    public void testInput() throws ReaderException {
        stringReader  = new StringReader("qw");
        assertEquals("input failed", stringReader.getSymbol(), 'q');
        assertEquals("input failed", stringReader.getSymbol(), 'w');
        assertEquals("input failed", stringReader.getSymbol(), 'e');
    }

    @Test(expected = ReaderException.class)
    public void testInput2() throws ReaderException {
        stringReader  = new StringReader(null);
        assertEquals("input failed", stringReader.getSymbol(), 'q');
        assertEquals("input failed", stringReader.getSymbol(), 'w');
        assertEquals("input failed", stringReader.getSymbol(), 'e');
    }

    @Test(expected = ReaderException.class)
    public void testInput3() throws ReaderException {
        stringReader  = new FileReader("//");
        assertEquals("input failed", stringReader.getSymbol(), 'q');
        assertEquals("input failed", stringReader.getSymbol(), 'w');
        assertEquals("input failed", stringReader.getSymbol(), 'e');
    }
}
