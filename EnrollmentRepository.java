package com.example.cms.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cms.entity.Enrollment;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
	List<Enrollment> findByStudent_Id(Long id); // ✅ Uses 'student' field in Enrollment

}	
   

