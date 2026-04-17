package com.example.cms.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username",unique = true,nullable = false)
	private String username;
	
	@Column(name="email",nullable = false,unique = true)
	private String email;
	
	@Column(name="first_name")
	private String firstName;
	
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	@Column(name="date_joined")
	private LocalDateTime dateJoined;
	
	 @Column(name = "last_login")
	private LocalDateTime lastLogin;
	
	public enum Role{
		STUDENT,
		INSTRUCTOR,
		ADMIN
	}
}
