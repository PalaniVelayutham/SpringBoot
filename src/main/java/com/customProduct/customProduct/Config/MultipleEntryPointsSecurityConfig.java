package com.customProduct.customProduct.Config;

import org.springframework.beans.factory.annotation.Value;
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
 
	@Value("${productuser}")
	private String productuser;
	@Value("${productpassword}")
	private String productpassword;
	@Value("${productrole}")
	private String productrole;
	
	
	@Value("${configuser}")
	private String configuser;
	@Value("${configpassword}")
	private String configpassword;
	@Value("${configrole}")
	private String configrole;
	
    @Bean
    public UserDetailsService userDetailsService() throws ResourceNotFoundException {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User
          .withUsername(productuser)
          .password(encoder().encode(productpassword))
          .roles(productrole).build());
        manager.createUser(User
          .withUsername(configuser)
          .password(encoder().encode(configpassword))
          .roles(configrole).build());
        return manager;
    }
     
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}