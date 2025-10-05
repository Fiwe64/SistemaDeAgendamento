package com.FisioNorteSaude.SistemaDeAgendamento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod; // Importar
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        // Permite a requisição pre-flight de CORS
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        // Permite acesso aos seus endpoints
                        .requestMatchers("/h2-console/**", "/clients/**", "/professionals/**", "/appointments/**").permitAll()
                        // Qualquer outra requisição precisa ser autenticada (boa prática)
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}