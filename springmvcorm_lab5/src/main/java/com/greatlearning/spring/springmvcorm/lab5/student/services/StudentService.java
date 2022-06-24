package com.greatlearning.spring.springmvcorm.lab5.student.services;

import java.util.List;

import com.greatlearning.spring.springmvcorm.lab5.student.entity.Student;

public interface StudentService {

	void save(Student student);
	Student read(int id);
	List<Student> readAll();
	void delete(int id);
}
