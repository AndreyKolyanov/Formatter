package ru.andrewkolyanov.machine.acts;

import ru.andrewkolyanov.machine.IndentCounter;
import ru.andrewkolyanov.machine.Machine;

import java.util.Arrays;

/**
 * increases the indentation and newline
 */
public class IncreaseIndent implements IAct {

    private char indentSymbol;
    private int indentLength;
    private IndentCounter indentCounter;

    /**
     * constructor
     * @param indentSymbol symbol to indent
     * @param indentLength quantity
     */
    public IncreaseIndent(final char indentSymbol, final int indentLength, IndentCounter indentCounter) {
        this.indentSymbol = indentSymbol;
        this.indentLength = indentLength;
        this.indentCounter = indentCounter;
    }

    @Override
    public String perform(final char symbol, final int currentIndent) throws ActException {
        indentCounter.setIndent(currentIndent + indentLength);
        return  '\n' + makeIndent(indentCounter.getIndent())  + symbol;
    }

    private String makeIndent(final int offset) throws ActException {
        try {
            char[] array = new char[offset];
            Arrays.fill(array, indentSymbol);
            return new String(array);
        } catch (NegativeArraySizeException e) {
            throw new ActException(e);
        }
    }
}
