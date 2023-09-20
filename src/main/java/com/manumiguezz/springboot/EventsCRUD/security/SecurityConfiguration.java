package com.manumiguezz.springboot.EventsCRUD.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(configurer ->
                configurer .anyRequest().authenticated())
                .formLogin(form ->
                        form
                                .loginPage("/LoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                );

        return httpSecurity.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails manuel = User.builder()
                .username("manuel miguez")
                .password("{noop}testing")
                .roles("DEV", "WORKER", "PUBLIC")
                .build();

        UserDetails bianca = User.builder()
                .username("bianca lauria")
                .password("{noop}testing")
                .roles("WORKER", "PUBLIC")
                .build();

        UserDetails javier = User.builder()
                .username("javi pucheta")
                .password("{noop}testing")
                .roles("PUBLIC")
                .build();

        return new InMemoryUserDetailsManager(manuel, bianca, javier);
    }
}
