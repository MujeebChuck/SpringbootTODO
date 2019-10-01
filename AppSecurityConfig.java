package io.javaproject.springbootstarter.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
	
	//Creating an object of UserDetailsService
	@Autowired
	private UserDetailsService userDetailsService;
	//How this class will interact with DAO so lets implements the userDetailService class
	
	@Bean
	public AuthenticationProvider AuthProvider() {
		//To connect to DB we have DataAccessObject DAO. 
		// Controller - connects to  Service layer & Service Layer connects to Database layer DAO
		//In this case Configuration talking to service & Service talking to DAO
		// So we need a Service class 
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
		
	

}
