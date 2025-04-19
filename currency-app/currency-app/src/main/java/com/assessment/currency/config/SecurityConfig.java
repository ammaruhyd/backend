package com.assessment.currency.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // ❌ Fully disables CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").authenticated() // ✅ Protect /api/**
                        .anyRequest().permitAll()                   // 🌐 Allow everything else
                )
                .httpBasic(Customizer.withDefaults()); // ✅ Basic Auth

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")                  // 🔐 Username
                .password("{noop}password")        // 🔐 Password (plain text for demo)
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
