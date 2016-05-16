package ru.andrewkolyanov.machine;

public class IndentCounter {

    private Integer indent;

    public IndentCounter() {
        this.indent = 0;
    }

    public Integer getIndent() {
        return indent;
    }

    public void setIndent(Integer indent) {
        this.indent = indent;
    }
}
