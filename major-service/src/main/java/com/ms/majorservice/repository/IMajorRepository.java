package com.ms.majorservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ms.majorservice.domain.Major;

@Repository
public interface IMajorRepository extends JpaRepository<Major, Long> {
	@Query("SELECT m FROM Major m WHERE m.code = ?1")
	Optional<Major> findByCode(String code);
	
	@Query("SELECT m FROM Major m WHERE m.name LIKE %?1%")
	List<Major> findByNameLike(String name);
}

