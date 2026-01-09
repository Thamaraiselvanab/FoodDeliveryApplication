package com.tap.DAO;

import java.util.List;

import com.tap.model.User;

public interface UserDAO {

	public int addUser(User user);
	public User getUser(int id);
	public void updateUser(User user);
	public void deleteUser(int id);
	public List<User> getAllUser();
	public User getUserByEmail(String email);

}
