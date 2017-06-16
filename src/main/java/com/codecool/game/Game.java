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

    public void updateGameState(Seed seed, int row, int col) throws IllegalArgumentException {
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

    public int[] validateUserMove (String userInput) throws IllegalArgumentException {
        if (userInput.matches("^\\d{2}$")) {
            String[] tmp = userInput.split("");
            int row = Integer.valueOf(tmp[0]) - 1;  // one-based system
            int col = Integer.valueOf(tmp[1]) - 1;
            if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                return new int[]{row, col};
            }
        }
        throw new IllegalArgumentException("Wrong input. Try again! :)");
    }

    private void setCurrentState(GameState currentState) {
        this.currentState = currentState;
    }

    private Seed chooseRandomPlayer() {
        List<Seed> seeds = Arrays.asList(Seed.CROSS, Seed.NOUGHT);
        return seeds.get(new Random().nextInt(seeds.size()));
    }
}
