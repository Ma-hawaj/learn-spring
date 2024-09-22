package com.mahmood.learn_spring.gamingapp02.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    private final GameConsole game;

    public GameRunner(@Qualifier("Pacman") GameConsole game) {
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
