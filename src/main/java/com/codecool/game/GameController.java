package com.codecool.game;

public class GameController {

    Game game;
    UserInterface ui;

    public GameController(Game game, UserInterface ui) {
        this.game = game;
        this.ui = ui;
    }

    public void runGame() {
        boolean isPlay = false;
        do {
        playRound();
            if (ui.getUserDecisionToPlayAgain().toLowerCase().equals("y")) {
                isPlay = true;
            }
        } while (isPlay);
    }

    private void playRound() {
        game.initGame();
        ui.displayFirstPlayer();
        do {
            ui.printBoard();
            int[] userMove = new int[0];
            boolean isValidInput = false;
            do {
                try {
                    userMove = game.validateUserMove(ui.getUserMove());
                    isValidInput = true;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (!isValidInput);
            try {
                game.updateGameState(game.getCurrentPlayer(), userMove[0], userMove[1]);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (game.getCurrentState() == GameState.PLAYING);
        ui.printBoard();
        ui.displayWinner(game.getCurrentPlayer());
    }
}
