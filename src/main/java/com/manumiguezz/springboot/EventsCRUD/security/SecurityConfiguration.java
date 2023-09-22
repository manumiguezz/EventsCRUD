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
                configurer
                        .requestMatchers("/").hasRole("PUBLIC")

                        .requestMatchers("/worker-events").hasRole("WORKER")
                        .requestMatchers("/events/list-events").hasRole("WORKER")
                        .requestMatchers("/events/event-form").hasRole("WORKER")
                        .requestMatchers("events/**").hasRole("WORKER")

                        .requestMatchers("/user-roles").hasRole("DEV")
                        .requestMatchers("dev/**").hasRole("DEV")

                        .anyRequest().authenticated())
                .formLogin(form ->
                        form
                                .loginPage("/LoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout ->
                        logout.permitAll()
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied"));


        return httpSecurity.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails manuel = User.builder()
                .username("Manuel Miguez")
                .password("{noop}testing")
                .roles("DEV", "WORKER", "PUBLIC")
                .build();

        UserDetails bianca = User.builder()
                .username("Bianca Lauria")
                .password("{noop}testing")
                .roles("WORKER", "PUBLIC")
                .build();

        UserDetails javier = User.builder()
                .username("Javi Pucheta")
                .password("{noop}testing")
                .roles("PUBLIC")
                .build();

        return new InMemoryUserDetailsManager(manuel, bianca, javier);
    }
}
