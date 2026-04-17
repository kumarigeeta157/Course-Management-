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

import com.example.cms.entity.Enrollment;
import com.example.cms.service.EnrollmentService;

@RestController
@RequestMapping("/cms/api")
@CrossOrigin
public class EnrollmentRestController {
	@Autowired
	private EnrollmentService enrollService;
	
	@GetMapping("/enrollments")
	public List<Enrollment> getAllEnrollment(){
		return enrollService.getAll();
	}
	@GetMapping("/enrollments/{id}")
	public Optional<Enrollment> getEnrollmentById(@PathVariable("id") Long eid){
		return enrollService.getId(eid);
	}
	@PostMapping("/enrollments")
	public Enrollment addEnrollment(@RequestBody Enrollment enroll) {
		return enrollService.save(enroll);
	}
	@PutMapping("/enrollments")
	public Enrollment updateEnrollment(@RequestBody Enrollment enroll) {
		return enrollService.update(enroll);
	}
	@DeleteMapping("/enrollments/{id}")
	public String deleteEnrollment(@PathVariable("id") Long eid) {
		enrollService.deleteById(eid);
		return "Enrollment with id " + eid + " deleted Sucessfully";
	}
	
	@GetMapping("/enrollments/user/{userId}")
	public List<Enrollment> getEnrollmentsByUserId(@PathVariable("userId") Long userId) {
	    return enrollService.getEnrollmentsByUserId(userId); // ✅ Correct method name
	}

	
	
}

