package com.codecool.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGameState {
    @Test
    public void testIfClassIsEnum() {
        assertTrue(GameState.class.isEnum());
    }

    @Test
    public void testIfPlayingExists() {
        assertNotNull(GameState.valueOf("PLAYING"));
    }

    @Test
    public void testIfDrawExists() {
        assertNotNull(GameState.valueOf("DRAW"));
    }

    @Test
    public void testIfCrossWonExists() {
        assertNotNull(GameState.valueOf("CROSS_WON"));
    }

    @Test
    public void testIfNoughtWonExists() {
        assertNotNull(GameState.valueOf("NOUGHT_WON"));
    }
}
