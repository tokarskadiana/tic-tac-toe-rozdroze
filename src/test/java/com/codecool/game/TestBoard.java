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

    @Nested
    @DisplayName("Test init method")
    class TestInitMethod {

        Cell[][] cells;

        @BeforeEach
        public void setup(){
            Board board = new Board();
            board.init();
            cells = board.getCells();
        }

        @Test
        public void testCellsIsNullBeforeInit() {
            Board board = new Board();
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
            for (int i = 0; i <cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    assertCoordinatesAreEquals(i+1, cells[i][j].getRow(),
                            j+1, cells[i][j].getCol());
                }
            }
        }

        private void assertCoordinatesAreEquals(int expectedRow, int expectedCol,
                                                int actualRow, int actualCol) {
            assertEquals(expectedRow, actualRow);
            assertEquals(expectedCol, actualCol);
        }
    }
}