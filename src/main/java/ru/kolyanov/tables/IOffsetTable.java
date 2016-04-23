package ru.kolyanov.tables;

/**
 * interface for OffsetTable classes
 */
public interface IOffsetTable {
    /**
     * method for calculate offset
     * @param string string with defining symbol
     * @return new offset
     * @throws OffsetException if it is impossible to calculate the indentation
     */
    String calculateOffset(final String string) throws OffsetException;
}
