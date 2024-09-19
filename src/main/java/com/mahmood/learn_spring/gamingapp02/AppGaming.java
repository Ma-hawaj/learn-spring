package com.mahmood.learn_spring.gamingapp02;

import com.mahmood.learn_spring.gamingapp02.game.GameConsole;
import com.mahmood.learn_spring.gamingapp02.game.GameRunner;
import com.mahmood.learn_spring.gamingapp02.game.MarioGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppGaming {

    @Bean
    public GameConsole game(){
        return new MarioGame();
    }

    @Bean
    public GameRunner runner(GameConsole game){
        return new GameRunner(game);
    }

    public static void main(String[] args) {

//        var game = new MarioGame();
//        var gameRunner = new GameRunner(game);
//        gameRunner.run();

        try(var context =
                    new AnnotationConfigApplicationContext
                            (AppGaming.class)){


            context.getBean(GameConsole.class).up();

            context.getBean(GameRunner.class).run();
        }
    }
}
