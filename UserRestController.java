package com.example.cms.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cms.entity.User;
import com.example.cms.entity.User.Role;
import com.example.cms.service.UserService;

@RestController
@RequestMapping("/cms/api")
@CrossOrigin
public class UserRestController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
	    // Log the incoming data
	    System.out.println("Received username: " + user.getUsername());
	    System.out.println("Received role: " + user.getRole()); // Log role
	    System.out.println("Received password: " + user.getPassword());

	    // Assuming the service checks the credentials based on username, role, and password
	    Optional<User> existingUser = userService.findByUsernameAndRoleAndPassword(
	            user.getUsername(), user.getRole(), user.getPassword());

	    if (existingUser.isPresent()) {
	        return ResponseEntity.ok(existingUser.get()); // Return user data with 200 OK status
	    } else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                             .body("Invalid login credentials"); // Return 401 Unauthorized
	    }
	}

	
	@GetMapping("/users")
	public List<User> getAllUser(){
		return userService.getAll();
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long uid) {
		return userService.getById(uid);
	}
	
	@GetMapping("/users/firstname/{firstname}")
	public List<User> getUserByFirstName(@PathVariable("firstname") String firstName) {
		return userService.findByFirstName(firstName);
	}
	@GetMapping("/users/lastname/{lastname}")
	public List<User> getUserByLastName(@PathVariable("lastname") String lastName){
		return userService.findByLastName(lastName);
	}
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return userService.add(user);
	}
	@PutMapping("/users/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User user) {
	    User existingUser = userService.getById(id).orElseThrow(() -> new RuntimeException("User not found"));
	    
	    existingUser.setFirstName(user.getFirstName());
	    existingUser.setLastName(user.getLastName());
	    existingUser.setEmail(user.getEmail());

	    return userService.update(existingUser);
	}

	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable("id") Long uid) {
		userService.delete(uid);
		return "User deleted Sucessfully with Id Number"+uid;
	}
	
	
	
	
}
