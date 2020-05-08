package com.customProduct.customProduct.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;


@Configuration
public class SecurityConfig {
   
	@Order(1)
	public static class App1ConfigurationAdapter extends WebSecurityConfigurerAdapter  {
	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.antMatcher("/api/getproductdetails")
	            .authorizeRequests().anyRequest().hasRole("USER")
	            .and().httpBasic().authenticationEntryPoint(authenticationEntryPoint());
	    } 
	    @Bean
	    public  AuthenticationEntryPoint authenticationEntryPoint(){
	        BasicAuthenticationEntryPoint entryPoint = 
	          new BasicAuthenticationEntryPoint();
	        entryPoint.setRealmName("admin realm");
	        return entryPoint;
	    }
	}
	
	@Order(2)
	public static class App2ConfigurationAdapter extends WebSecurityConfigurerAdapter {
	 
		 @Override
		    protected void configure(HttpSecurity http) throws Exception {
		        http.antMatcher("/api/getconfigdetails")
		            .authorizeRequests().anyRequest().hasRole("ADMIN")
		            .and().httpBasic().authenticationEntryPoint(authenticationEntryPointS());
		    }
		 @Bean
		    public  AuthenticationEntryPoint authenticationEntryPointS(){
		        BasicAuthenticationEntryPoint entryPoint = 
		          new BasicAuthenticationEntryPoint();
		        entryPoint.setRealmName("user realm");
		        return entryPoint;
		    }
		 
	}
	 
}