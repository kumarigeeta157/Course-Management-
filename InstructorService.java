package com.example.cms.service;

import java.util.List;
import java.util.Optional;

import com.example.cms.entity.Instructor;

public interface InstructorService {
	public List<Instructor> getAll();
	public Optional<Instructor> getId(Long id);
	public Instructor save(Instructor instructor);
	public Instructor update(Instructor instructor);
	public void delete(Long id);
}


