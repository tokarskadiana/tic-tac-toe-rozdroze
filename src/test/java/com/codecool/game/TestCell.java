package com.codecool.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestCell {

    private Cell cell;

    @BeforeEach
    public void setup() {
        cell = new Cell(1, 1);
    }

    @Test
    public void testDefaultContentIsEmpty() {
        assertEquals(Seed.EMPTY, cell.getContent());
    }

    @Test
    public void testIfSetContentSetsNewValue() {
        cell.setContent(Seed.CROSS);
        assertEquals(Seed.CROSS, cell.getContent());
    }

    @Test
    public void testClearMethodSetContentToEmpty() {
        cell.setContent(Seed.CROSS);
        cell.clear();
        assertEquals(Seed.EMPTY, cell.getContent());
    }
}
