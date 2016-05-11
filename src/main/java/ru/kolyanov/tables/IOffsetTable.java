package ru.kolyanov.tables;

import java.util.Map;

public interface IOffsetTable {
    /**
     * returning ofset table
     * @return offset table
     */
    Map<Character, Integer> getOffsetTable();

    /**
     * returning info about nesting level
     * @return info about nesting level
     */
    Map<Character, Integer> getNestingLevelTable();

    /**
     * getter base offset
     * @return base offset
     */
    Integer getBaseOffset();
}
