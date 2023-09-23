package com.manumiguezz.springboot.EventsCRUD.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider (UserDetailsService userService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager
                .setUsersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?");

        jdbcUserDetailsManager
                .setAuthoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?");
        return jdbcUserDetailsManager;
    }

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

}
