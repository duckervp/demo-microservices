package com.ms.studentservice.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
    private long id;
    
    @Column(name = "code")
    private String code;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "majorId")
    private long majorId;
    
    @Column(name = "dob")
    private Timestamp dob;

	public Student() {
	}

	public Student(long id, String code, String name, long majorId, Timestamp dob) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.majorId = majorId;
		this.dob = dob;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMajorId() {
		return majorId;
	}

	public void setMajorId(long majorId) {
		this.majorId = majorId;
	}

	public Timestamp getDob() {
		return dob;
	}

	public void setDob(Timestamp dob) {
		this.dob = dob;
	}
    
}
