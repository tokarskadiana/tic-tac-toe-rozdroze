package com.codecool.game;

public class Board {

    private Cell[][] cells;

    public void init() {
        cells = new Cell[3][3];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Cell cell = new Cell(i, j);
                cells[i][j] = cell;
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public boolean hasWon(Cell cell) {
        boolean hasWon = checkRow(cell);
        if(!hasWon) hasWon = checkCol(cell);
        if((!hasWon || cell.getRow() == cell.getCol()) ||
                (cell.getCol() == -1 * cell.getRow() + (cells.length-1))) {
            hasWon = checkDiagonal(cell);
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

    private boolean checkDiagonal(Cell cell) {
        boolean hasWon = true;
        for(int n = 0; n < cells.length; n++){
            if(cells[n][n].getContent() != cell.getContent()) hasWon = false;
            if(cells[n][-1*n+(cells.length-1)].getContent() != cell.getContent()){
                hasWon = false;
            }
        }
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
}
