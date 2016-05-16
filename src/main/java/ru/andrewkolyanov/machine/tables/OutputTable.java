package ru.andrewkolyanov.machine.tables;

import ru.andrewkolyanov.machine.IndentCounter;
import ru.andrewkolyanov.machine.acts.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputTable implements IOutputTable {

    private List<List<Integer>> table;
    private Map<Integer, IAct> acts;

    public OutputTable(final IndentCounter indentCounter) {
        ArrayList<Integer> colOne = new ArrayList<>();
        colOne.add(1);
        colOne.add(2);
        colOne.add(3);
        colOne.add(null);
        colOne.add(2);

        ArrayList<Integer> colTwo = new ArrayList<>();
        colTwo.add(1);
        colTwo.add(2);
        colTwo.add(3);
        colTwo.add(3);
        colTwo.add(2);

        ArrayList<Integer> colThree = new ArrayList<>();
        colThree.add(null);
        colThree.add(2);
        colThree.add(3);
        colThree.add(null);
        colThree.add(2);

        ArrayList<Integer> colFour = new ArrayList<>();
        colFour.add(3);
        colFour.add(null);
        colFour.add(4);
        colFour.add(4);
        colFour.add(2);

        ArrayList<Integer> colFive = new ArrayList<>();
        colFive.add(2);
        colFive.add(2);
        colFive.add(2);
        colFive.add(2);
        colFive.add(2);

        table = new ArrayList<>();
        table.add(colOne);
        table.add(colTwo);
        table.add(colThree);
        table.add(colFour);
        table.add(colFive);

        acts = new HashMap<>();
        acts.put(1, new IncreaseIndent(' ', 4, indentCounter));
        acts.put(2, new Nothing());
        acts.put(3, new NewLine(' '));
        acts.put(4, new DecreaseIndent(' ', 4, indentCounter));

    }

    @Override
    public List<List<Integer>> getTable() {
        return table;
    }

    @Override
    public Map<Integer, IAct> getActs() throws TableException {
        return acts;
    }
}
