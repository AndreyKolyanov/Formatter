package ru.andrewkolyanov.machine.tables;

import ru.andrewkolyanov.machine.acts.IAct;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * an interface to the machine output table
 */
public interface IOutputTable {
    /**
     *
     * @return output table
     * @throws TableException if is error
     */
    List<List<Integer>> getTable() throws TableException;

    /**
     *
     * @return table of acts
     * @throws TableException if is error
     */
    Map<Integer, IAct> getActs() throws TableException;
}
