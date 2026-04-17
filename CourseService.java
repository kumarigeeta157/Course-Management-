package com.example.cms.service;

import java.util.List;
import java.util.Optional;

import com.example.cms.entity.Course;



public interface CourseService {
	public List<Course> getAll();
	public Optional<Course> getId(Long id);
	public Course save(Course course);
	public Course update(Course course);
	public void deleteById(Long id);
	public List<Course> getCourseByInstructor(Long instructorId);
	
}


