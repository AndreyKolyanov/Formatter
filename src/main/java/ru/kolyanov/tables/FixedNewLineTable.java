package ru.kolyanov.tables;


import java.util.HashSet;
import java.util.Set;

/**
 * class provide hash newLineSet for formatter data
 */
public class FixedNewLineTable implements INewLineTable {


    private Set<Character> newLineSet;
    /**
     * constructor init newLineSet
     */
    public FixedNewLineTable() {
        newLineSet = new HashSet<Character>();
        newLineSet.add('{');
        newLineSet.add('}');
        newLineSet.add(';');
    }

    /**
     * method encoding
     * @param symbol key
     * @return adding to string
     */
    public Boolean get(final Character symbol) {
        return newLineSet.contains(symbol);
    }
}
