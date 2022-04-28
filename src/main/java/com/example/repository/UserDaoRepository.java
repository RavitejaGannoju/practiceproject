package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public class UserDaoRepository {

	private static List<User> users = new ArrayList<User>();
	
	private static int userCount;
	
	static {
		users.add(new User(1, "ravi"));
		users.add(new User(2, "teja"));
		users.add(new User(3, "shiv"));
		
		userCount = users.size();
	}
	
	public List<User> getAllUsers() {
		return users;
	}
	
	public boolean saveUser(@NotNull User user) {
		
		user.setUserId(++userCount);
		return users.add(user);
	}
	
	public User getUser(int userId) {
		User user = null;
		
		/*
		 * users.forEach( (userRecord) -> { if(userId == userRecord.getUserId()) { user
		 * = userRecord; } });
		 */
		
		for(User userRecord : users) {
			if(userId == userRecord.getUserId()) {
				user = userRecord;
			}
		}
		
		return user;
	}
	
	public void deleteUser(int userId) {
		User user = getUser(userId);
		users.remove(user);
	}
}
