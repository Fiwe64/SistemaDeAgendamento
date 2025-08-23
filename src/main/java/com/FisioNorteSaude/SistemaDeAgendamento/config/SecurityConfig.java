package com.FisioNorteSaude.SistemaDeAgendamento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers
                        .frameOptions(FrameOptionsConfig::disable)
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/h2-console/**", "/clients/**").permitAll()
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}