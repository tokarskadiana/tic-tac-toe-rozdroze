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

    public boolean hasWon(Cell cell) {
        boolean hasWon = checkRow(cell);
        if(!hasWon) hasWon = checkCol(cell);
        if(!hasWon) hasWon = checkDiagonal(cell);
        return hasWon;
    }

    private boolean checkDiagonal(Cell cell) {
        boolean hasWon = true;
        return hasWon;
    }

    private boolean checkCol(Cell cell) {
        boolean hasWon = true;
        int col = cell.getCol();
        Seed cellContent = cell.getContent();
        for (int row = 0; row < cells.length; row++) {
            if (cells[row][col].getContent() != cellContent) {
                hasWon = false;
                break;
            }
        }
        return hasWon;
    }

    private boolean checkRow(Cell cell) {
        boolean hasWon = true;
        int row = cell.getRow();
        Seed cellContent = cell.getContent();
        for (int col = 0; col < cells[row].length; col++) {
            if (cells[row][col].getContent() != cellContent) {
                hasWon = false;
                break;
            }
        }
        return hasWon;
    }

    public boolean isDraw() {
        boolean isDraw = true;
        for (int i = 0; i < cells.length; i++) {
            if (!isDraw) break;
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].getContent() == Seed.EMPTY) {
                    isDraw = false;
                    break;
                }
            }
        }
        return isDraw;
    }
}
