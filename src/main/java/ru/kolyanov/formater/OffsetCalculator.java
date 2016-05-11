package ru.kolyanov.formater;

import ru.kolyanov.tables.IOffsetTable;
import ru.kolyanov.tables.OffsetException;

import java.util.Arrays;
import java.util.Map;

public class OffsetCalculator {

    private Integer currentNestingLevel;
    private Map<Character, Integer> offsetTable;
    private Map<Character, Integer> nestingLevel;
    private Integer offsetLength;

    /**
     * constructor
     * @param offsetTable info about offset
     */
    public OffsetCalculator(final IOffsetTable offsetTable) {
        this.offsetTable = offsetTable.getOffsetTable();
        this.nestingLevel = offsetTable.getNestingLevelTable();
        this.offsetLength = offsetTable.getBaseOffset();
        this.currentNestingLevel = 0;
    }

    /**
     * method for calculate offset
     * @param inputString string with defining symbol
     * @return string with new offset
     * @throws OffsetException if it is impossible to calculate the indentation
     */
    public String calculateOffset(final String inputString) throws OffsetException {
        int currentOffset = 0;
        String string = inputString.trim();
        char symbol = string.charAt(string.length() - 1);
        if (nestingLevel.containsKey(symbol)) {
            currentNestingLevel += nestingLevel.get(symbol);
        }
        if (offsetTable.containsKey(symbol)) {
            currentOffset = (currentNestingLevel * offsetLength)
                    - (nestingLevel.get(symbol) * offsetTable.get(symbol));
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
