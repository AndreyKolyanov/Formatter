package ru.kolyanov.tables;

import java.util.HashMap;
import java.util.Map;

/**
 * class describe tables for offsets
 */
public class FixedOffsetTable implements IOffsetTable {

    /**
     * the constant equals length base offset
     */
    public static final int BASE_OFFSET_LENGTH = 4;

    private HashMap<Character, Integer> nestingLevel;
    private HashMap<Character, Integer> table;
    /**
     * constructor creating nestingLevel
     */
    public FixedOffsetTable() {
        nestingLevel = new HashMap<>();
        nestingLevel.put('{', 1);
        nestingLevel.put('}', -1);
        nestingLevel.put(';', 0);

        table = new HashMap<>();
        table.put(';', BASE_OFFSET_LENGTH);
        table.put('{', BASE_OFFSET_LENGTH);
        table.put('}', 0);
    }

    @Override
    public Map<Character, Integer> getOffsetTable() {
        return table;
    }

    @Override
    public Map<Character, Integer> getNestingLevelTable() {
        return nestingLevel;
    }

    @Override
    public Integer getBaseOffset() {
        return BASE_OFFSET_LENGTH;
    }

}
