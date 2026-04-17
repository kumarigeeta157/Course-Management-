package com.example.cms.service;

import java.util.List;
import java.util.Optional;

import com.example.cms.entity.User;
import com.example.cms.entity.User.Role;

public interface UserService {
	
	public List<User> getAll();
	public Optional<User> getById(Long id);
	public User add(User user);
	public User update(User user);
	public void delete(Long id);
	
	public List<User> findByFirstName(String firstName);
	public List<User> findByLastName(String lastName);
	public Optional<User> findByUsernameAndPassword(String username, String password); // New method
	public Optional<User> findByUsernameAndRoleAndPassword(String username, Role role, String password);
	 
	 
}

