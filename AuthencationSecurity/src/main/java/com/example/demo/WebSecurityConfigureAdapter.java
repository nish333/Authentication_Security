package com.example.demo;
  
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.security.core.userdetails.UserDetailsService;
 
  
@Configuration

public class WebSecurityConfigureAdapter {
  
	@Bean 
	protected UserDetailsService userDetailsService() 
	{ 
		return null;

	}
  
 }
 
