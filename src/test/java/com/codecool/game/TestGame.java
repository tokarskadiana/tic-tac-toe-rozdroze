package com.codecool.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestGame {
    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    @Test
    public void testBoardIsNullBeforeGameInit() {
        assertNull(game.getBoard());
    }

    @Test
    public void testIfInitGameCallsInitBoard() {
        game.initGame();
        assertNotNull(game.getBoard().getCells());
    }

    @Test
    public void testIfGetCurrentStateReturnsCurrentState() {
        game.initGame();
        assertEquals(GameState.PLAYING, game.getCurrentState());
    }

    @Test
    public void testIfCurrentPlayerIsRandom1() {
        game.initGame();
        assertEquals(Seed.CROSS, game.getCurrentPlayer());
    }

    @Test
    public void testIfCurrentPlayerIsRandom2() {
        game.initGame();
        assertEquals(Seed.NOUGHT, game.getCurrentPlayer());
    }

    @Test
    public void testIfCurrentPlayerIsNotEmpty() {
        game.initGame();
        assertNotEquals(Seed.EMPTY, game.getCurrentPlayer());
    }
}
