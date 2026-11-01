package com.jsp.securityexample.security;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final PasswordEncoder passwordEncoder;
//    @Bean
//    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
//
//
//
//        UserDetails user1= User.withUsername("karthik")
//                .password(passwordEncoder.encode("Karthik123$")).roles("admin").build();
//
//        UserDetails user2= User.withUsername("Someone")
//                .password("Pass123$").roles("admin").build();
//
//        return new InMemoryUserDetailsManager(user1,user2);
//    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
      http.csrf(csrf -> csrf.disable())
          .authorizeHttpRequests(auth -> auth
              .requestMatchers("/users/signup","/users/signin").permitAll()
              .requestMatchers("/error").permitAll()
              .anyRequest().authenticated())
          .httpBasic(Customizer.withDefaults());
      return http.build();
    }
}
