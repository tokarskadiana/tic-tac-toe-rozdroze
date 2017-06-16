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
        public void testEveryCellHasCorrectCoordinates() {
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    assertCoordinatesAreEquals(i, j,
                            cells[i][j].getRow(), cells[i][j].getCol());
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
            when(cell.getRow()).thenReturn(1);
            when(cell.getCol()).thenReturn(1);
            when(cell.getContent()).thenReturn(Seed.CROSS);
        }

        @DisplayName("every cell in row must be CROSS if CROSS wins in row")
        @Test
        public void testIfCrossHasWonInRow() {
            Cell[][] cells = new Cell[3][3];
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    Cell c = mock(Cell.class);
                    cells[i][j] = c;
                    when(c.getRow()).thenReturn(i);
                    when(c.getCol()).thenReturn(j);
                    if ((i == 1 && j == 0) || (i == 1 && j == 1) || (i == 1 && j == 2)) {
                        when(c.getContent()).thenReturn(Seed.CROSS);
                    } else {
                        when(c.getContent()).thenReturn(Seed.EMPTY);
                    }
                }
            }
            board.init(cells);
            assertTrue(board.hasWon(cell));
        }

        @DisplayName("every cell in column must be CROSS if CROSS wins in column")
        @Test
        public void testIfCrossHasWonInColumn() {
            Cell[][] cells = new Cell[3][3];
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    Cell c = mock(Cell.class);
                    cells[i][j] = c;
                    when(c.getRow()).thenReturn(i);
                    when(c.getCol()).thenReturn(j);
                    if ((i == 0 && j == 1) || (i == 1 && j == 1) || (i == 2 && j == 1)) {
                        when(c.getContent()).thenReturn(Seed.CROSS);
                    } else {
                        when(c.getContent()).thenReturn(Seed.EMPTY);
                    }
                }
            }
            board.init(cells);
            assertTrue(board.hasWon(cell));
        }

        @DisplayName("every cell diagonally must be CROSS if CROSS wins diagonally")
        @Test
        public void testIfCrossHasWonDiagonally() {
            Cell[][] cells = new Cell[3][3];
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    Cell c = mock(Cell.class);
                    cells[i][j] = c;
                    when(c.getRow()).thenReturn(i);
                    when(c.getCol()).thenReturn(j);
                    if ((i == 0 && j == 0) || (i == 1 && j == 1) || (i == 2 && j == 2)) {
                        when(c.getContent()).thenReturn(Seed.CROSS);
                    } else {
                        when(c.getContent()).thenReturn(Seed.EMPTY);
                    }
                }
            }
            board.init(cells);
            assertTrue(board.hasWon(cell));
        }
    }

    @Nested
    @DisplayName("when there is a tie")
    class WhenThereIsATie {
        private Cell[][] cells;

        @BeforeEach
        public void setUp() {
            cells = new Cell[3][3];
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    Cell c = mock(Cell.class);
                    cells[i][j] = c;
                    when(c.getRow()).thenReturn(i);
                    when(c.getCol()).thenReturn(j);
                    if ((i == 0 && j == 2) || (i == 1 && j == 0) || (i == 2 && j == 1) || (i == 2 && j == 2)) {
                        when(c.getContent()).thenReturn(Seed.NOUGHT);
                    } else {
                        when(c.getContent()).thenReturn(Seed.CROSS);
                    }
                }
            }
            board.init(cells);
        }

        @DisplayName("isDraw must return true")
        @Test
        public void testIfIsDrawReturnsTrue() {
            assertTrue(board.isDraw());
        }

        @DisplayName("hasWon for CROSS must return false")
        @Test
        public void testIfCrossHasWonReturnsFalse() {
            assertFalse(board.hasWon(cells[1][1]));
        }

        @DisplayName("hasWon for NOUGHT must return false")
        @Test
        public void testIfNoughtHasWonReturnsFalse() {
            assertFalse(board.hasWon(cells[0][2]));
        }

        @DisplayName("every cell must be NOT empty")
        @Test
        public void testIfEveryCellIsNOTEmpty() {
            for (Cell[] row : board.getCells()) {
                for (Cell cell : row) {
                    assertNotEquals(Seed.EMPTY, cell.getContent());
                }
            }
        }
    }
}
