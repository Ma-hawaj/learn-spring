package com.mahmood.learn_spring.gamingapp02;

import com.mahmood.learn_spring.gamingapp02.game.GameConsole;
import com.mahmood.learn_spring.gamingapp02.game.GameRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppGaming {
    public static void main(String[] args) {

//        var game = new MarioGame();
//        var gameRunner = new GameRunner(game);
//        gameRunner.run();

        try(var context =
                    new AnnotationConfigApplicationContext
                            (GamingConfiguration.class)){


            context.getBean(GameConsole.class).up();

            context.getBean(GameRunner.class).run();
        }
    }
}
