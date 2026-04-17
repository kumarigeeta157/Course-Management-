package com.example.cms.service;

import java.util.List;
import java.util.Optional;

import com.example.cms.entity.Enrollment;



public interface EnrollmentService {
	public List<Enrollment> getAll();
	public Optional<Enrollment> getId(Long id);
	public Enrollment save(Enrollment enroll);
	public Enrollment update(Enrollment enroll);
	public void deleteById(Long id);
	List<Enrollment> getEnrollmentsByUserId(Long id);

}


