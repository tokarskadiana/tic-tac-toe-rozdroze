package com.codecool.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TestBoard {
    private Cell[][] cells;
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
        board.init();
    }

    @Nested
    @DisplayName("Test init method")
    class TestInitMethod {

        @BeforeEach
        public void setup() {
            cells = board.getCells();
        }

        @Test
        public void testCellsIsNullBeforeInit() {
            Board board = new Board();
            Cell[][] cells = board.getCells();
            assertNull(cells);
        }

        @Test
        public void testInitCreateCellsArray() {
            Cell cell = mock(Cell.class);
            Cell[] row = {cell, cell, cell};
            Cell[][] mockedCells = {row, row, row};
            assertTrue(Arrays.equals(mockedCells, cells));
        }

        @Test
        public void testEveryCellHasCorrectCoordinates() {
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    assertCoordinatesAreEquals(i + 1, cells[i][j].getRow(),
                            j + 1, cells[i][j].getCol());
                }
            }
        }

        private void assertCoordinatesAreEquals(int expectedRow, int expectedCol,
                                                int actualRow, int actualCol) {
            assertEquals(expectedRow, actualRow);
            assertEquals(expectedCol, actualCol);
        }
    }

    @Nested
    @DisplayName("when CROSS has won in row")
    class WhenCrossHasWonInRow {
        private Cell cell;

        @BeforeEach
        public void setUp() {
            cell = mock(Cell.class);
            Cell[] row = {cell, cell, cell};
            Cell[][] cells = {row, row, row};
            when(cell.getContent())
                    .thenReturn(Seed.CROSS);

        }

        @DisplayName("every cell in row must be CROSS if CROSS wins in row")
        @Test
        public void testIfCrossHasWonInRow() {
            cells[1][0] = cell;
            cells[1][1] = cell;
            cells[1][2] = cell;
            assertTrue(board.hasWon(cell));
        }

        @DisplayName("every cell in column must be CROSS if CROSS wins in column")
        @Test
        public void testIfCrossHasWonInColumn() {
            cells[0][2] = cell;
            cells[1][2] = cell;
            cells[2][2] = cell;
            assertTrue(board.hasWon(cell));
        }

        @DisplayName("every cell diagonally must be CROSS if CROSS wins diagonally")
        @Test
        public void testIfCrossHasWonDiagonally() {
            cells[0][2] = cell;
            cells[1][1] = cell;
            cells[2][0] = cell;
            assertTrue(board.hasWon(cell));
        }
    }

    @Nested
    @DisplayName("when there is a tie")
    class WhenThereIsATie {
        private Cell cell;

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
            assertTrue(board.isDraw());
        }

        @DisplayName("hasWon for CROSS must return false")
        @Test
        public void testIfCrossHasWonReturnsFalse() {
            when(cell.getContent())
                    .thenReturn(Seed.CROSS);
            assertFalse(board.hasWon(cell));
        }

        @DisplayName("hasWon for NOUGHT must return false")
        @Test
        public void testIfNoughtHasWonReturnsFalse() {
            when(cell.getContent())
                    .thenReturn(Seed.NOUGHT);
            assertFalse(board.hasWon(cell));
        }

        @DisplayName("every cell must be NOT empty")
        @Test
        public void testIfEveryCellIsNOTEmpty() {
            for (Cell[] row : cells) {
                for (Cell cell : row) {
                    assertNotEquals("Seed.EMPTY", cell.getContent());
                }
            }
        }
    }
}
