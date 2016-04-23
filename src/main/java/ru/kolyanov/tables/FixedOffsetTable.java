package ru.kolyanov.tables;

import java.util.Arrays;
import java.util.HashMap;

/**
 * class describe tables for offsets
 */
public class FixedOffsetTable implements IOffsetTable {

    /**
     * the constant equals length base offset
     */
    public static final int BASE_OFFSET_LENGTH = 4;
    private int currentNestingLevel;

    private HashMap<Character, Integer> nestingLevel;
    private HashMap<Character, Integer> table;
    /**
     * constructor creating nestingLevel
     */
    public FixedOffsetTable() {
        nestingLevel = new HashMap<Character, Integer>();
        nestingLevel.put('{', 1);
        nestingLevel.put('}', -1);
        nestingLevel.put(';', 0);

        table = new HashMap<Character, Integer>();
        table.put(';', BASE_OFFSET_LENGTH);
        table.put('{', BASE_OFFSET_LENGTH);
        table.put('}', 0);

        currentNestingLevel = 0;
    }

    /**
     * method for calculate offset
     * @param string string with defining symbol
     * @return new offset
     * @throws OffsetException if it is impossible to calculate the indentation
     */
    public String calculateOffset(final String string) throws OffsetException {
        int currentOffset = 0;
        char symbol = string.charAt(string.length() - 1);
        if (nestingLevel.containsKey(symbol)) {
            currentNestingLevel += nestingLevel.get(symbol);
        }
        if (table.containsKey(symbol)) {
            currentOffset = (currentNestingLevel * BASE_OFFSET_LENGTH)
                    - (nestingLevel.get(symbol) * table.get(symbol));
        }
        return (makeOffset(currentOffset)) + string;
    }

    private String makeOffset(final int offset) throws OffsetException {
        try {
            char[] array = new char[offset];
            Arrays.fill(array, ' ');
            return new String(array);
        } catch (NegativeArraySizeException e) {
            throw new OffsetException(e);
        }
    }
}
