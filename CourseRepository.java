package com.example.cms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cms.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> findByInstructorId(Long instructorId);
}
 
