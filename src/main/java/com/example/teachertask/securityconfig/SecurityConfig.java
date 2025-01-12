package com.example.teachertask.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
        @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .cors().and()
                    .authorizeRequests()
//                    .requestMatchers("/api/auth/signup").permitAll()
//                    .requestMatchers("/api/auth/addadmin").hasAnyAuthority("ADMIN")
//                    .requestMatchers("/api/users/**").hasAnyAuthority("ADMIN")

                    .anyRequest().permitAll();
            //Token validate yazmaliyam.

            return http.build();
        }
}
