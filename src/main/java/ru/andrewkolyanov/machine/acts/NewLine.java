package ru.andrewkolyanov.machine.acts;

import ru.andrewkolyanov.machine.Machine;

import java.util.Arrays;

/**
 * perform a newline
 */
public class NewLine implements IAct {

    private char indentSymbol;

    /**
     * constructor
     * @param indentSymbol symbol to indent
     */
    public NewLine(final char indentSymbol) {
        this.indentSymbol = indentSymbol;
    }

    @Override
    public String perform(final char symbol, final int currentIndent) throws ActException {
        return "\n" + makeIndent(currentIndent) + symbol;
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
