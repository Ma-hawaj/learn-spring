package com.mahmood.firstrestapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        // Authenticate all requests
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        // enable basic auth instead of the default sign in page
        // this is a popup that asks for credentials
        http.httpBasic(Customizer.withDefaults());

        // CSRF -> POST, PUT
        http.csrf().disable();

        return http.build();
    }
}
