package com.moriset.user.service;



import com.moriset.user.model.User;

public interface UserService {
	public  User getUserById(Integer id);

	public User saveUser(User user);

}
