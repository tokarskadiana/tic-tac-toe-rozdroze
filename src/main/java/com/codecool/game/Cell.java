package com.codecool.game;

public class Cell {
    private int row;
    private int col;
    private Seed content;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        content = Seed.EMPTY;
    }

    public Seed getContent() {
        return content;
    }

    public void setContent(Seed content) {
        this.content = content;
    }

    public void clear() {
        setContent(Seed.EMPTY);
    }
}
