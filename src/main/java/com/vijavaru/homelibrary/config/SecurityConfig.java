package com.vijavaru.homelibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       /* http
                .csrf(AbstractHttpConfigurer::disable // Disable CSRF protection (only for demonstration; not recommended for production)
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/api/books").permitAll() // Permit all POST requests to /api/books
                        .requestMatchers(HttpMethod.GET, "/api/books").permitAll() // Permit all GET requests to /api/books
                        .anyRequest().authenticated() // Require authentication for other requests
                );

        return http.build();*/
        http
                .csrf(AbstractHttpConfigurer::disable // Disable CSRF protection (only for demonstration; not recommended for production)
                )
                .authorizeHttpRequests(authorize ->
                        authorize.anyRequest().permitAll() // Require authentication for other requests
                );

        return http.build();
    }
}
