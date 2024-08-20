package com.oauth.demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
           http.csrf(AbstractHttpConfigurer::disable)
                   .authorizeHttpRequests(authorizeRequests ->
                           authorizeRequests.anyRequest().authenticated())
//                   .formLogin(Customizer.withDefaults());
//                   .formLogin(form ->form.defaultSuccessUrl("/hello" , true));
                   .oauth2Login(oauth2 ->
                           oauth2.defaultSuccessUrl("http://localhost:5173/dashboard" , true));

        return http.build();
    }
}





