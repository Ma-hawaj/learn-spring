package com.mahmood.learn_spring;

import com.mahmood.learn_spring.game.GameRunner;
import com.mahmood.learn_spring.game.MarioGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {

        var game = new MarioGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
