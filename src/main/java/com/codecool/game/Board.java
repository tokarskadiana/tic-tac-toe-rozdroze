package com.codecool.game;

public class Board {
    private Cell[][] cells;

    public void init() {
        // new implementation for test purposes
//        int rows = 3;
//        int cols = 3;
//        cells = new Cell[rows][cols];
//        int row = 0;
//        int col = 0;
//        for (Cell[] line : cells) {
//            for (Cell cell : line) {
//                cell = new Cell(row, col);
//            }
//        }
        Cell[] firstRow = {new Cell(0, 0), new Cell(0, 1), new Cell(0, 2)};
        Cell[] secondRow = {new Cell(1, 0), new Cell(1, 1), new Cell(1, 2)};
        Cell[] thirdRow = {new Cell(2, 0), new Cell(2, 1), new Cell(2, 2)};
        cells = new Cell[][]{firstRow, secondRow, thirdRow};
    }

    public Cell[][] getCells() {
        return cells;
    }
}
