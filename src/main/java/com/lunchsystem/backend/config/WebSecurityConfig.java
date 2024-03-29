package com.lunchsystem.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/products").permitAll()
                .requestMatchers(HttpMethod.POST, "/products/add").permitAll()
                .requestMatchers(HttpMethod.POST, "/category/add").permitAll()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/*").permitAll()
                .anyRequest().authenticated();
        http
                .formLogin().disable();

        return http.build();
    }
}
