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

	    private static final Logger logger = LogManager.getLogger(UserService.class);

	    public User registerUser(User user) {
	        logger.debug("Saving user to the database: {}", user.getEmail());
	        return userRepository.save(user);
	    }

	    public Optional<User> findByEmail(String email) {
	        logger.debug("Checking if email exists: {}", email);
	        return userRepository.findByEmail(email);
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
