package ru.kolyanov.tables;

import java.util.Map;

public interface IOffsetTable {

    Map<Character, Integer> getOffsetTable();

    Map<Character, Integer> getNestingLevelTable();
}
