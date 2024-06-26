package com.example.demo;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;


/* 
 
@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigureAdapter
{
	@SuppressWarnings("deprecation")
	@Bean
	@Override
	protected UserDetailsService userDetailsService()            	//HERE WE CAN DIRECTLY HARDCODE THE USER AND PASSWORD
	{
		List<UserDetails> users = new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder()
				.username("Nishanth")
				.password("Root@123")
				.roles("USER")
				.build());
		
		return new InMemoryUserDetailsManager(users);
	
	}
	
}

*/


@Configuration                                                  //STORE THE USER DETAILS IN DATABASES FOR AUTHENTICATION PURPOSE
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigureAdapter
{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());   //IT WILL WORK IF YOUR PASSWORD IS PLANE TEXT
		
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());         //DECRYPT YOUR PASSWORD IT WILL NOT WORK IF YOUR PASSWORD IS PLANE TEXT
		
		return provider;
	}

}











