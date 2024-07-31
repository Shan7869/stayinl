package com.stayinn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stayinn.entity.User;
import com.stayinn.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByUsername(username);
		System.out.println("shan"+user.get().getUsername());
		System.out.println("pass"+user.get().getUsername());
		if(!user.isPresent()) {
		            throw new UsernameNotFoundException("User not found");
		        }
System.out.println(new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), List.of(new SimpleGrantedAuthority(user.get().getRole()))).toString());
			return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), List.of(new SimpleGrantedAuthority(user.get().getRole())));
		
	}

}
