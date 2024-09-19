package com.mahmood.learn_spring.gamingapp02;

import com.mahmood.learn_spring.gamingapp02.game.GameRunner;
import com.mahmood.learn_spring.gamingapp02.game.MarioGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {

        var game = new MarioGame();
        var gameRunner = new GameRunner(game);
        gameRunner.run();
    }
}
