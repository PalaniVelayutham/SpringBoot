package com.customProduct.customProduct.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.customProduct.customProduct.exception.ResourceNotFoundException;

@Configuration
public class MultipleEntryPointsSecurityConfig {
 
    @Bean
    public UserDetailsService userDetailsService() throws ResourceNotFoundException {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
          .withUsername("user")
          .password(encoder().encode("userPass"))
          .roles("USER").build());
        manager.createUser(User
          .withUsername("admin")
          .password(encoder().encode("adminPass"))
          .roles("ADMIN").build());
        return manager;
    }
     
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}