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
        currentPlayer = chooseRandomPlayer();
    }

    public void updateGameState(Seed seed, int row, int col) {
        Cell cell = board.applyUserMove(seed, row, col);
        if (board.hasWon(cell)) {
            if (seed == Seed.CROSS) setCurrentState(GameState.CROSS_WON);
            else if (seed == Seed.NOUGHT) setCurrentState(GameState.NOUGHT_WON);
        } else if (board.isDraw()) setCurrentState(GameState.DRAW);
        else setCurrentPlayer();
    }

    public Seed getCurrentPlayer() {
        return currentPlayer;
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public Board getBoard() {
        return board;
    }

    public void setCurrentPlayer() {
        if (getCurrentPlayer() == Seed.CROSS) {
            this.currentPlayer = Seed.NOUGHT;
        } else {
            this.currentPlayer = Seed.CROSS;
        }
    }

    private void setCurrentState(GameState currentState) {
        this.currentState = currentState;
    }

    private Seed chooseRandomPlayer() {
        List<Seed> seeds = Arrays.asList(Seed.CROSS, Seed.NOUGHT);
        return seeds.get(new Random().nextInt(seeds.size()));
    }
}
