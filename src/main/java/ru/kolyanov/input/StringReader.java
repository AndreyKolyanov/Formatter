package ru.kolyanov.input;

public class StringReader implements IReader {

    char[] string;
    int nextSymbol;

    public StringReader(String string){
        this.string = string.toCharArray();
        this.nextSymbol = 0;
    }

    public char getSymbol() {
        char symbol = string[nextSymbol];
        nextSymbol++;
        return symbol;
    }
}
