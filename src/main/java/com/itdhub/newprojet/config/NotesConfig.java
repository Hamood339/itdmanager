package com.itdhub.newprojet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class NotesConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .dispatcherTypeMatchers(HttpMethod.valueOf("/api/notes/mes-notes")).authenticated()
            .anyRequest().denyAll()
            .and();
            //.formLogin()
           // .and()
           // .csrf().disable();
        return http.build();
    }
}
