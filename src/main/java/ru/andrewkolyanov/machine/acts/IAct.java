package ru.andrewkolyanov.machine.acts;

/**
 * The interface describes the actions to be taken in any way, such as adding padding, a newline, etc.
 */
public interface IAct {
    /**
     * Performs action returns the result string
     * @return result string
     * @throws ActException action is impossible
     * @param symbol symbol on which the action is
     */
    String perform(char symbol, int currentIndent) throws ActException;
}
