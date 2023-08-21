package com.moriset.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moriset.user.model.User;
import com.moriset.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private  UserRepository userRepository;

	@Override
	public User getUserById(Integer id) {
		
		return userRepository.findById(id).get();
	}

	@Override
	public User saveUser(User user) {
	
		return userRepository.save(user);
	}

}
