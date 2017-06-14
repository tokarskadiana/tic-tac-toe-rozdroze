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

    public void init(Cell[][] cells) {
        this.cells = cells;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public boolean hasWon(Cell cell) {
        boolean hasWon = checkRow(cell);
        if(!hasWon) hasWon = checkCol(cell);
        if(!hasWon) {
            if((cell.getRow() == cell.getCol()) ||
                    (cell.getCol() == -1 * cell.getRow() + (getCells().length-1))) hasWon = checkDiagonal(cell);
        }
        return hasWon;
    }

    public boolean isDraw() {
        boolean isDraw = true;
        for (int i = 0; i < getCells().length; i++) {
            if (!isDraw) break;
            for (int j = 0; j < getCells()[i].length; j++) {
                if (getCells()[i][j].getContent() == Seed.EMPTY) {
                    isDraw = false;
                    break;
                }
            }
        }
        return isDraw;
    }

    private boolean checkDiagonal(Cell cell) {
        boolean hasWon = true;
        for(int n = 0; n < getCells().length; n++){
            if(getCells()[n][n].getContent() != cell.getContent()) hasWon = false;
            if(getCells()[n][-1*n+(getCells().length-1)].getContent() != cell.getContent()){
                hasWon = false;
            }
        }
        return hasWon;
    }

    public void setCellByUserMove(Cell cell) {
        for (int i = 0; i < getCells().length; i++) {
            for (int j = 0; j < getCells()[i].length; j++) {
                if (i == cell.getRow() && j == cell.getCol()) {
                    getCells()[i][j].setContent(cell.getContent());
                }
            }
        }
    }

    private boolean checkCol(Cell cell) {
        boolean hasWon = true;
        int col = cell.getCol();
        Seed cellContent = cell.getContent();
        for (int row = 0; row < getCells().length; row++) {
            if (getCells()[row][col].getContent() != cellContent) {
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
        for (int col = 0; col < getCells()[row].length; col++) {
            if (getCells()[row][col].getContent() != cellContent) {
                hasWon = false;
            }
        }
        return hasWon;
    }
}
