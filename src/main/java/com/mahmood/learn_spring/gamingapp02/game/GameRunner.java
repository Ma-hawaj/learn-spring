package com.mahmood.learn_spring.gamingapp02.game;

public class GameRunner {
    private final GameConsole game;

    public GameRunner(GameConsole game) {
        this.game = game;
    }

    public void run() {
        System.out.println("Running ....");

        game.up();
        game.down();
        game.left();
        game.right();
    }
}
