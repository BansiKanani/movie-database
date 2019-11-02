package com.brk.mdb.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brk.mdb.models.User;
import com.brk.mdb.repositories.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public void insertUser(User u) {
		userRepository.save(u);
		System.out.println("User saved -> Name : " + u.getName() + " ID : " + u.getId());
	}
	 
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public List<User> getByName(String name) {
		return userRepository.findByName(name);
	}

	
}
