package com.ms.studentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ms.studentservice.domain.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long>{
	@Query("SELECT s FROM Student s WHERE s.majorId = ?1")
	List<Student> findByMajorId(long id);
}
