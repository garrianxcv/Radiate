package com.tts.Radiate.service;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.tts.Radiate.model.Role;
import com.tts.Radiate.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.tts.Radiate.repository.RoleRepository;
import com.tts.Radiate.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    UserService(UserRepository userRepository,RoleRepository roleRepository,BCryptPasswordEncoder bCryptPasswordEncoder){
    	this.userRepository = userRepository;
    	this.roleRepository = roleRepository;
    	this.bCryptPasswordEncoder = bCryptPasswordEncoder;
   	
    }
	
    public User findByFirstname(String firstName) {
        return userRepository.findByFirstName(firstName);
    }
    
    public User findByLastName(String lastName) {
    	return userRepository.findByLastName(lastName);
    }
        
    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }
        
    public void save(User user) {
        userRepository.save(user);
    }
	
    
    public User saveNewUser(User user) {
    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    	user.setActive(1);
    	Role userRole = roleRepository.findByRole("USER");
    	user.setRole(new HashSet<Role>(Arrays.asList(userRole)));
    	return userRepository.save(user);
    }
    
    
    public User getLoggedInUser() {
    	String loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
    	return findByFirstname(loggedInUser);
    }
	
	
}
