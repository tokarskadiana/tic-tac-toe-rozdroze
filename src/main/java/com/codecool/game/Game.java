package com.codecool.game;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game {

    private Board board;
    private GameState currentState;
    private Seed currentPlayer;

    public void initGame() {
        board = new Board();
        board.init();
        currentState = GameState.PLAYING;
        currentPlayer = choseRandomPlayer();
    }

    public void updateGameState(Seed seed, int row, int col) {
    }

    private Seed choseRandomPlayer() {
        List<Seed> seeds = Arrays.asList(Seed.CROSS, Seed.NOUGHT);
        return seeds.get(new Random().nextInt(seeds.size()));
    }

    public Seed getCurrentPlayer() {
        return currentPlayer;
    }

    public GameState getCurrentState() {
        return currentState;
    }
}
