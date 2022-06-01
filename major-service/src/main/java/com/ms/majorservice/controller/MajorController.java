package com.ms.majorservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ms.majorservice.domain.Major;
import com.ms.majorservice.service.IMajorService;

@RestController
@RequestMapping("/api/majors")
public class MajorController {
	private IMajorService majorService;
	
	@Autowired
	public MajorController(IMajorService majorService) {
		this.majorService = majorService;
	}
	
	@GetMapping()
	public List<Major> findAll() {
		return majorService.findAll();
	}
	
	@GetMapping("/{id}")
	public Major findById(@PathVariable long id) {
		return majorService.findById(id);
	}
	
	@GetMapping("/q")
	public Major findByCode(@RequestParam String code) {
		return majorService.findByCode(code);
	}
	
	@GetMapping("/qs")
	public List<Major> findByNameLike(@RequestParam String name) {
		return majorService.findByNameLike(name);
	}
}
