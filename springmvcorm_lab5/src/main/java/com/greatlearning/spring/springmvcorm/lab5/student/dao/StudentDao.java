package com.greatlearning.spring.springmvcorm.lab5.student.dao;

import java.util.List;

import com.greatlearning.spring.springmvcorm.lab5.student.entity.Student;

public interface StudentDao {

	void save(Student s);
	void delete(int id);
	Student read(int id);
	List<Student> readAll();
}
