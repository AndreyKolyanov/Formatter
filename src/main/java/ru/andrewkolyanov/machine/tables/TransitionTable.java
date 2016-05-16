package ru.andrewkolyanov.machine.tables;

import java.util.ArrayList;
import java.util.List;

public class TransitionTable implements ITransitionTable {

    private List<List<Character>> mTable;
    private List<Character> beginState;
    private List<Integer> finalState;
    private List<Character> alphabet;

    public TransitionTable() {
        ArrayList<Character> colOne = new ArrayList<>();
        colOne.add('{');
        colOne.add('s');
        colOne.add(null);
        colOne.add('}');
        colOne.add('\n');

        ArrayList<Character> colTwo = new ArrayList<>();
        colTwo.add('{');
        colTwo.add('s');
        colTwo.add(';');
        colTwo.add(null);
        colTwo.add('\n');

        ArrayList<Character> colThree = new ArrayList<>();
        colThree.add('{');
        colThree.add('s');
        colThree.add(null);
        colThree.add('}');
        colThree.add('\n');

        ArrayList<Character> colFour = new ArrayList<>();
        colFour.add('{');
        colFour.add('s');
        colFour.add(null);
        colFour.add('}');
        colFour.add('\n');

        ArrayList<Character> colFive = new ArrayList<>();
        colFive.add('{');
        colFive.add('s');
        colFive.add(';');
        colFive.add('}');
        colFive.add('\n');

        finalState = new ArrayList<>();
        finalState.add(3);
        finalState.add(4);

        beginState = new ArrayList<>();
        beginState.add('{');
        beginState.add('s');
        beginState.add(null);
        beginState.add(null);
        beginState.add('\n');

        mTable = new ArrayList<>();
        mTable.add(colOne);
        mTable.add(colTwo);
        mTable.add(colThree);
        mTable.add(colFour);
        mTable.add(colFive);

        this.alphabet  = new ArrayList<>();
        alphabet.add('s');
        alphabet.add('{');
        alphabet.add(';');
        alphabet.add('}');
        alphabet.add('\n');
    }

    @Override
    public List<Character> getAlphabet() throws TableException {
        return alphabet;
    }

    @Override
    public List<List<Character>> getTable() {
        return mTable;
    }

    @Override
    public List<Character> getBeginState() {
        return beginState;
    }

    @Override
    public List<Integer> getFinalState() {
        return finalState;
    }
}
