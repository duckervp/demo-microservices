package com.ms.studentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ms.studentservice.domain.Major;
import com.ms.studentservice.domain.Student;
import com.ms.studentservice.service.IStudentService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	private RestTemplate restTemplate;
	
	private EurekaClient eurekaClient;
	
	private IStudentService studentService;
	
	@Value("${service.majorservice.name}")
	private String majorServiceName;

    
    @Autowired
    public StudentController(RestTemplate restTemplate, EurekaClient eurekaClient, IStudentService studentService) {
		this.restTemplate = restTemplate;
		this.eurekaClient = eurekaClient;
		this.studentService = studentService;
	}

	@GetMapping()
    public List<Student> findAll() {
    	return this.studentService.findAll();
    }
	
    
    @GetMapping("/{id}")
    public Student findById(@PathVariable long id) {
    	return this.studentService.findById(id);
    }    
    
    @GetMapping("/q")
    public List<Student> findByMajor(@RequestParam(required = false) String majorCode) {
    	Application application = eurekaClient.getApplication(majorServiceName);
    	InstanceInfo info = application.getInstances().get(0);
    	String url = String.format("http://%s:%d/api/majors/q?code=%s", info.getIPAddr(), info.getPort(), majorCode);
    	Major major = restTemplate.getForObject(url, Major.class);
    	return this.studentService.findByMajor(major.getId());
    }
}
