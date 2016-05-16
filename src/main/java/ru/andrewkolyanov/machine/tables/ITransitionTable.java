package ru.andrewkolyanov.machine.tables;

import java.util.ArrayList;
import java.util.List;

/**
 * an interface to the machine tables
 */
public interface ITransitionTable {
    /**
     *
     * @return transition table
     * @throws TableException if is error
     */
    List<List<Character>> getTable() throws TableException;

    /**
     *
     * @return the begin state of machine
     * @throws TableException if is error
     */
    List<Character> getBeginState() throws TableException;
    /**
     *
     * @return the final states of machine
     * @throws TableException if is error
     */
    List<Integer> getFinalState() throws TableException;

    /**
     *
     * @return alphabet of machine
     * @throws TableException if is error
     */
    List<Character> getAlphabet() throws TableException;
}
