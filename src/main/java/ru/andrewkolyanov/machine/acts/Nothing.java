package ru.andrewkolyanov.machine.acts;

/**
 * doing nothing
 */
public class Nothing implements IAct {

    @Override
    public String perform(final char symbol, final int currentIndent) throws ActException {
        return String.valueOf(symbol);
    }
}
