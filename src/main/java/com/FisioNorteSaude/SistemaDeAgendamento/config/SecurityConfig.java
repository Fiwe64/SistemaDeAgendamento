package com.FisioNorteSaude.SistemaDeAgendamento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilita o CSRF (Cross-Site Request Forgery) para o console H2
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable())) // Permite o uso de frames para o H2
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
