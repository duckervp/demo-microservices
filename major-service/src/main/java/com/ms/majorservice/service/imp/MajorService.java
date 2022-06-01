package com.ms.majorservice.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.majorservice.domain.Major;
import com.ms.majorservice.repository.IMajorRepository;
import com.ms.majorservice.service.IMajorService;

@Service
public class MajorService implements IMajorService {
	private IMajorRepository majorRepository;

	@Autowired
	public MajorService(IMajorRepository majorRepository) {
		this.majorRepository = majorRepository;
	}

	@Override
	public List<Major> findAll() {
		return majorRepository.findAll();
	}

	@Override
	public List<Major> findByNameLike(String name) {
		return majorRepository.findByNameLike(name);
	}

	@Override
	public Major findById(long id) {
		return majorRepository.findById(id).orElse(null);
	}

	@Override
	public Major findByCode(String code) {
		return majorRepository.findByCode(code).orElse(null);
	}
}
