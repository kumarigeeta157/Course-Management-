package com.example.cms.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cms.entity.User;
import com.example.cms.entity.User.Role;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByFirstName(String firstname);
	Optional<User> findByUsernameAndPassword(String username, String password);
	Optional<User> findByUsernameAndRoleAndPassword(String username, String role, String password);
	List<User> findByLastName(String lastname);
	Optional<User> findByUsernameAndRoleAndPassword(String username, Role role, String password);
	
}

