package ru.kolyanov.formater;


import java.util.HashMap;
import java.util.Map;

/**
 * class provide hash table for formater data
 */
public class Table {

    private Map<Character, String> table;

    /**
     * constructor inti table
     */
    Table() {
        table = new HashMap<Character, String>();
        table.put('{', "\n    ");
        table.put('}', "\n");
        table.put(';', "\n    ");
    }

    /**
     * method encoding
     * @param c key
     * @return adding to string
     */

    public String encode(final Character c) {
        String str = table.get(c);
        if (str != null) {
            return str;
        } else {
            return "";
        }
    }
}
