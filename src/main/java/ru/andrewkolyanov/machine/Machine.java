package ru.andrewkolyanov.machine;

import ru.andrewkolyanov.input.IReader;
import ru.andrewkolyanov.input.ReaderException;
import ru.andrewkolyanov.machine.acts.*;
import ru.andrewkolyanov.machine.tables.IOutputTable;
import ru.andrewkolyanov.machine.tables.ITransitionTable;
import ru.andrewkolyanov.machine.tables.TableException;
import ru.andrewkolyanov.output.IWriter;
import ru.andrewkolyanov.output.WritingException;

import java.util.*;

public class Machine {

    //TODO разгрести бардак, отрефакторить код!!!
    private List<List<Integer>> outputTable;
    private List<List<Character>> mTable;
    private List<Character> state;
    private List<Integer> finalStates;
    private List<Character> alphabet;
    private Map<Integer, IAct> acts;
    private int current;
    private int next;
    private IndentCounter indentCounter;

    public Machine(final ITransitionTable transitionTable, final IOutputTable outputTable, IndentCounter indentCounter) throws FormattingException {
        try {
            this.outputTable = outputTable.getTable();
            this.acts = outputTable.getActs();
            this.mTable = transitionTable.getTable();
            this.state = transitionTable.getBeginState();
            this.finalStates = transitionTable.getFinalState();
            this.alphabet = transitionTable.getAlphabet();
        } catch (TableException e) {
            throw new FormattingException(e);
        }
        current = 1;
        next = 0;
        this.indentCounter = indentCounter;
    }

    public void format(final IReader reader, final IWriter writer) throws FormattingException {
        try {
            char symbol = (char) reader.getSymbol();
            char clearSymbol = checkSymbol(symbol);
            next = state.indexOf(clearSymbol);
            state = mTable.get(next);
            output(current, next, symbol, writer);
            current = next;
            format(reader, writer);
        } catch (ReaderException e) {
            try {
                finalStates.get(finalStates.indexOf(current));
            } catch (ArrayIndexOutOfBoundsException e1) {
                throw new FormattingException(e1);
            }
        } catch (WritingException | ArrayIndexOutOfBoundsException e) {
            throw new FormattingException(e);
        }
    }

    private void output(final int of, final int at, final char sym, final IWriter writer) throws WritingException, FormattingException {
        List<Integer> col = outputTable.get(at);
        System.out.println(of + " -> " + at + " Sym: " + (int) sym);
        int act = col.get(of);
        try {
            writer.printLine(acts.get(act).perform(sym, indentCounter.getIndent()));
        } catch (ActException e) {
            throw new FormattingException(e);
        }
    }

    private char checkSymbol(final char symbol) {
        try {
            return alphabet.get(alphabet.indexOf(symbol));
        } catch (ArrayIndexOutOfBoundsException e) {
            return 's';
        }
    }
}
