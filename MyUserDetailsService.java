package io.javaproject.springbootstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.javaproject.springbootstarter.Repository.UserPrincipal;
import io.javaproject.springbootstarter.Repository.UserRepository;
import io.javaproject.springbootstarter.model.User;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     //How do you get the UserName just by creating a Repository name UserRepository
		
	User user = userRepository.findByUserName(username);
	  if(user==null) 
		  throw new UsernameNotFoundException ("User 404");
		  	
		return new UserPrincipal(user);
	}

}
