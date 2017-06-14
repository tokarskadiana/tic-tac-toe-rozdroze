package com.codecool.game;

public class Board {
    private Cell[][] cells;

    public void init() {
        Cell[] firstRow = {new Cell(0, 0), new Cell(0, 1), new Cell(0, 2)};
        Cell[] secondRow = {new Cell(1, 0), new Cell(1, 1), new Cell(1, 2)};
        Cell[] thirdRow = {new Cell(2, 0), new Cell(2, 1), new Cell(2, 2)};
        cells = new Cell[][]{firstRow, secondRow, thirdRow};
    }

    public Cell[][] getCells() {
        return cells;
    }
}
