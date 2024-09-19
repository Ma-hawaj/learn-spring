package com.mahmood.learn_spring.gamingapp02;

import com.mahmood.learn_spring.gamingapp02.game.GameConsole;
import com.mahmood.learn_spring.gamingapp02.game.GameRunner;
import com.mahmood.learn_spring.gamingapp02.game.MarioGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GameConsole game(){
        return new MarioGame();
    }

    @Bean
    public GameRunner runner(GameConsole game){
        return new GameRunner(game);
    }

}
