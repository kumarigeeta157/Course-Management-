package com.example.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cms.Repository.CourseRepository;
import com.example.cms.Repository.InstructorRepository;
import com.example.cms.entity.Course;
import com.example.cms.entity.Instructor;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class CourseServiceImp implements CourseService {

	@Autowired
	private CourseRepository courseRepo;
	

	@Autowired 
	private InstructorRepository instructorRepo;
		
	@Override
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		return courseRepo.findAll();
	}

	@Override
	public Optional<Course> getId(Long id) {
		// TODO Auto-generated method stub
		return courseRepo.findById(id);
	}

	@Override public Course save(Course course) { 
		Instructor instructor = course.getInstructor(); 
		if (instructor != null) { 
			instructor = instructorRepo.findById(instructor.getId()) .orElseThrow(()
					-> new IllegalArgumentException("Instructor not found")); 
			course.setInstructor(instructor); 
			} 
		return courseRepo.save(course); }


	@Override
	public Course update(Course course) {
		// TODO Auto-generated method stub
		return courseRepo.save(course);
	}

	@Override
	public void deleteById(Long id) {
		courseRepo.deleteById(id);
		
	}

	@Override
	public List<Course> getCourseByInstructor(Long instructorId) {
		// TODO Auto-generated method stub
		return courseRepo.findByInstructorId(instructorId);
	}
	

}

