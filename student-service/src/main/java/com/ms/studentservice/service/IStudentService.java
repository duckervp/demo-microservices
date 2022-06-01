package com.ms.studentservice.service;

import java.util.List;

import com.ms.studentservice.domain.Student;

public interface IStudentService {
	List<Student> findAll();
	List<Student> findByMajor(long majorId);
	Student findById(long id);
}
