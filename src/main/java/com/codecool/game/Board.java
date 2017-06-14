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
        boolean diagonal1 = true;
        boolean diagonal2 = true;
        for(int n = 0; n < getCells().length; n++){
            if(getCells()[n][n].getContent() != cell.getContent()) diagonal1 = false;
            if(getCells()[n][-1*n+(getCells().length-1)].getContent() != cell.getContent()){
                diagonal2 = false;
            }
        }
        return (diagonal1 || diagonal2);
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
