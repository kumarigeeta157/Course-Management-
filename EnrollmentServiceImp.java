package com.example.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cms.Repository.EnrollmentRepository;
import com.example.cms.entity.Enrollment;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class EnrollmentServiceImp implements EnrollmentService {
	
	@Autowired
	private EnrollmentRepository enrollmentRepo;
	
	@Override
	public List<Enrollment> getAll() {
		// TODO Auto-generated method stub
		return enrollmentRepo.findAll();
	}

	
	@Override
	public Optional<Enrollment> getId(Long id) {
		// TODO Auto-generated method stub
		return enrollmentRepo.findById(id);
	}

	@Override
	public Enrollment save(Enrollment enroll) {
		// TODO Auto-generated method stub
		return enrollmentRepo.save(enroll);
	}

	@Override
	public Enrollment update(Enrollment enroll) {
		// TODO Auto-generated method stub
		return enrollmentRepo.save(enroll);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		enrollmentRepo.deleteById(id);
		
	}


	@Override
	public List<Enrollment> getEnrollmentsByUserId(Long id) {
	    return enrollmentRepo.findByStudent_Id(id);
	}


}

