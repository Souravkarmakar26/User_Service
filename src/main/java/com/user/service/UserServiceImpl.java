package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.User;
@Service
public class UserServiceImpl implements  UserService{
	
	
	//fake  user list
	List<User> usersList =  List.of(
			new User(123, "Kundan", "995712357"),
			new User(124, "Rohit", "774681234")
			);

	@Override
	public User getUser(Long id) {
		return usersList.stream().filter(user -> user.getUserId()==(id)).findAny().orElse(null);
	}

}
