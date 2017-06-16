package com.codecool.game;

public class GameController {

    Game game;
    UserInterface ui;

    public GameController(Game game, UserInterface ui) {
        this.game = game;
        this.ui = ui;
    }

    public void runGame() {
        game.initGame();
        ui.displayFirstPlayer();
        do {
            ui.printBoard();
            int[] userMove = ui.getUserMove();
            System.out.println(userMove[0]);
            System.out.println(userMove[1]);
            game.updateGameState(game.getCurrentPlayer(), userMove[0], userMove[1]);
        } while (game.getCurrentState() == GameState.PLAYING);
        ui.printBoard();
        ui.displayWinner(game.getCurrentPlayer());
    }
}
