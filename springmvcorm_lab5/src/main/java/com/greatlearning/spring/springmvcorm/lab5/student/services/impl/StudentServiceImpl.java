package com.greatlearning.spring.springmvcorm.lab5.student.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.spring.springmvcorm.lab5.student.dao.StudentDao;
import com.greatlearning.spring.springmvcorm.lab5.student.entity.Student;
import com.greatlearning.spring.springmvcorm.lab5.student.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao dao;

	public StudentDao getDao() {
		return dao;
	}

	public void setDao(StudentDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional
	public void save(Student student) {
		dao.save(student);
	}

	@Override
	public Student read(int id) {
		return dao.read(id);
	}

	@Override
	public List<Student> readAll() {
		return dao.readAll();
	}

	@Override
	@Transactional
	public void delete(int id) {
		dao.delete(id);
	}
		
}
