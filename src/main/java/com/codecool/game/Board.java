package com.codecool.game;

public class Board {

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
        for (int row = 0; row < cells.lenght; row++) {
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
        for (int col = 0; col < cells[row].lenght; col++) {
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
            if(!isDraw) break;
            for (int j = 0; j < cells[i].length; j++) {
                if (cells[i][j].getContent() == Seed.EMPTY){
                 isDraw = false;
                 break;
                }
            }
        }
        return isDraw;
    }
}
