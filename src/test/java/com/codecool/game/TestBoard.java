package com.codecool.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TestBoard {
    private Cell[][] cells;
    private Cell cell;

    @BeforeEach
    public void setUp() {
        cell = mock(Cell.class);
        Cell[] row = {cell, cell, cell};
        Cell[][] cells = {row, row, row};
    }

    @Nested
    @DisplayName("when CROSS has won")
    class WhenCrossHasWon {
        @BeforeEach
        public void setUp() {
            assertTrue(hasWon(cell));
        }

        @DisplayName("every cell in row must be CROSS if CROSS wins in row")
        @Test
        public void testIfCrossHasWonInRow() {
            for (Cell cell : cells[cell.getRow()]) {
                assertEquals(Seed.CROSS, cell.getContent());
            }
        }

        @DisplayName("every cell in column must be CROSS if CROSS wins in column")
        @Test
        public void testIfCrossHasWonInColumn() {
            for (Cell cell : cells[cell.getRow()]) {
                assertEquals(Seed.CROSS, cell.getContent());
            }
            for (int row = 0; row < 3; row++) {
                assertEquals(Seed.CROSS, cells[row][cell.getCol()].getContent());
            }
        }
    }

    @Nested
    @DisplayName("when there is a tie")
    class WhenThereIsATie {

        @BeforeEach
        public void setUp() {
            cell = mock(Cell.class);
            Cell[] row = {cell, cell, cell};
            Cell[][] cells = {row, row, row};
            when(cell.getContent())
                    .thenReturn(Seed.CROSS)
                    .thenReturn(Seed.NOUGHT);
            cells[0][0] = cell;
            cells[0][1] = cell;
            cells[0][2] = cell;
            cells[1][0] = cell;
            cells[1][1] = cell;
            cells[1][1] = cell;
            cells[2][0] = cell;
            cells[2][1] = cell;
            cells[2][2] = cell;
        }

        @DisplayName("isDraw must return true")
        @Test
        public void testIfIsDrawReturnsTrue() {
            assertTrue(isDraw());
        }

        @DisplayName("hasWon for CROSS must return false")
        @Test
        public void testIfCrossHasWonReturnsFalse() {
            when(cell.getContent())
                    .thenReturn(Seed.CROSS);
            assertFalse(hasWon(cell));
        }

        @DisplayName("hasWon for NOUGHT must return false")
        @Test
        public void testIfNoughtHasWonReturnsFalse() {
            when(cell.getContent())
                    .thenReturn(Seed.NOUGHT);
            assertFalse(hasWon(cell));
        }

        @DisplayName("every cell must be NOT empty")
        @Test
        public void testIfEveryCellIsNOTEmpty() {
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    assertNotEquals("Seed.EMPTY", cells[i][j].getContent());
                }
            }
            for (Cell[] row : cells) {
                for (Cell cell : row) {
                    assertNotEquals("Seed.EMPTY", cell.getContent());
                }
            }
        }
    }
}
