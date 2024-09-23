package com.mahmood.firstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {
    // Usually will use LDAP or DataBase
    // Currently will use in memory DataBase

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager(){

        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username("ma.hawaj")
                .password("mah")
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // since we are configuring the filter chain we need to reconfigure the defaults also

        // This enables auth on all requests
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        // Configure the default from login
        http.formLogin(Customizer.withDefaults());

        // this to allow accessing the h2 console
        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();

    }
}
