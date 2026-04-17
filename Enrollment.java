package com.example.cms.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {

	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	private User student;

	@ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
	private Course course;
	
	@Column(name = "enrollment_date")
	private LocalDateTime enrollmentDate;
}

