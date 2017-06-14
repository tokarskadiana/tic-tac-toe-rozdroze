package com.codecool.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {

    private Game game;
    private Map<Seed, String> seedAsString;

    public UserInterface(Game game) {
        this.game = game;
        this.seedAsString = seedsToSting();
    }

    public void displayFirstPlayer() {
        System.out.println(String.format(
                "Player '%s' will be the first player this round!",
                seedAsString.get(game.getCurrentPlayer())));
    }

    public void printBoard() {
        Cell[][] cells = game.getBoard().getCells();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (j == cells[i].length-1){
                    sb.append(seedAsString.get(cells[i][j].getContent()));
                    sb.append("%n");
                } else {
                    sb.append(seedAsString.get(cells[i][j].getContent()));
                    sb.append("|");
                }
            }
            if (i < cells.length-1) {
                sb.append("-----%n");
            }
        }
        System.out.println(String.format(sb.toString()));
    }

    public int[] getUserMove() {
        System.out.println(
                String.format("Player '%s', enter your move (row[1-3], column[1-3]): ",
                        seedAsString.get(game.getCurrentPlayer())));
        String userMove = new Scanner(System. in).nextLine();
        int row = Integer.valueOf(userMove.toCharArray()[0]);
        int col = Integer.valueOf(userMove.toCharArray()[1]);
        return  new int[]{row, col};
    }

    private Map<Seed, String> seedsToSting() {
        Map<Seed, String> seedAsString = new HashMap<>();
        seedAsString.put(Seed.CROSS, "X");
        seedAsString.put(Seed.NOUGHT, "O");
        seedAsString.put(Seed.EMPTY, " ");
        return  seedAsString;
    }
}
