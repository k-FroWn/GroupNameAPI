package com.example.groupnameapi;

import com.example.groupnameapi.classes.UserF;
import com.example.groupnameapi.controller.DbInteraction.DBUser;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @PostConstruct
    protected void doItFirst() {

    }

    @Bean
    InMemoryUserDetailsManager inMemoryUserDetailsManager () {
        List<UserDetails> userDetailsList = new ArrayList<>();

        userDetailsList.add(User.withUsername("ethan").password(passwordEncoder().encode("hunt"))
                .roles("ADMIN").build());

        for (UserF u : DBUser.selectAllUsers()) {
            userDetailsList.add(User.withUsername(u.getUsername()).password(passwordEncoder().encode(u.getPassword()))
                    .roles(u.getRole()).build());
        }

        return new InMemoryUserDetailsManager(userDetailsList);

    }

    @Bean
    PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                //.requestMatchers("/index.html").permitAll()
                //.requestMatchers("/create.html").permitAll()
                //.requestMatchers("/accounts/login.html").permitAll()
                .requestMatchers("/users/**").permitAll()
                .anyRequest().authenticated()).httpBasic(Customizer.withDefaults());

        http.sessionManagement((sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)));
        http.csrf(csrf -> csrf.disable());
        http.cors();

        return http.build();


    }
}
