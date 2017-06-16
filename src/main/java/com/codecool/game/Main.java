package com.codecool.game;

/**
 * Created by diana on 13.06.17.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        GameController gameController = new GameController(game, new UserInterface(game));
        gameController.runGame();
    }
}
