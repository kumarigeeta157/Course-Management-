package com.example.cms.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cms.entity.Instructor;
import com.example.cms.service.InstructorService;

@CrossOrigin
@RestController
@RequestMapping("/cms/api")
public class InstructorRestController {
	@Autowired 
	private InstructorService instructorService;
	@GetMapping("/instructors")
	public List<Instructor> getAllInstructor(){
		return instructorService.getAll();
	}
	
	@GetMapping("/instructors/{id}")
	public Optional<Instructor> getInstructorById(@PathVariable("id") Long iid){
		return instructorService.getId(iid);
	}
	
	@PostMapping("/instructors")
	public Instructor addInstructor(@RequestBody Instructor instructor) {
		return instructorService.save(instructor);
	}
	@PutMapping("/instructors")
	public Instructor updateInstructor(@RequestBody Instructor instructor) {
		return instructorService.update(instructor);
	}
	@DeleteMapping("/instructors/{id}")
	public String deleteInstructor(@PathVariable("id") Long iid) {
		instructorService.delete(iid);
		return "Instructor with id " + iid + " Deleted Sucessfully";
	}
	
	
}

