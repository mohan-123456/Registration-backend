package com.telusko.regapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.telusko.regapp.User;
import com.telusko.regapp.repository.UserRepository;

@Service
public class UserService {

	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    public User registerUser(User user) {
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        return userRepository.save(user);
	    }

	    public Optional<User> findByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }

		public boolean existsByUsername(String username) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean existsByEmail(String email) {
			// TODO Auto-generated method stub
			return false;
		}

		
}