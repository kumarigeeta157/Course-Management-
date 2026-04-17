package com.example.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cms.Repository.UserRepository;
import com.example.cms.entity.User;
import com.example.cms.entity.User.Role;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public Optional<User> getById(Long id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

	@Override
	public User add(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public void delete(Long id) {
		userRepo.deleteById(id);
		
	}

	@Override
	public List<User> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return userRepo.findByFirstName(firstName);
	}

	@Override
	public List<User> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return userRepo.findByLastName(lastName);
	}

	@Override
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password);
    }
	
	 @Override
	  public Optional<User> findByUsernameAndRoleAndPassword(String username, Role role, String password) {
		 
	    return userRepo.findByUsernameAndRoleAndPassword(username, role, password);
	  }
	

}

