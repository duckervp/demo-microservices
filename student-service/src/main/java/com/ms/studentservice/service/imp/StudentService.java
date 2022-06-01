package com.ms.studentservice.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.studentservice.domain.Student;
import com.ms.studentservice.repository.IStudentRepository;
import com.ms.studentservice.service.IStudentService;

@Service
public class StudentService implements IStudentService{
	private final IStudentRepository studentRepository;
	
	@Autowired
	public StudentService(IStudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public List<Student> findByMajor(long majorId) {
		return studentRepository.findByMajorId(majorId);
	}

	@Override
	public Student findById(long id) {
		return studentRepository.findById(id).orElse(null);
	}
	
}
