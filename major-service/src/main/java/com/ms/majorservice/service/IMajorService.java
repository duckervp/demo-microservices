package com.ms.majorservice.service;

import java.util.List;

import com.ms.majorservice.domain.Major;

public interface IMajorService {
	List<Major> findAll();
	List<Major> findByNameLike(String name);
	Major findById(long id);
	Major findByCode(String code);
}
