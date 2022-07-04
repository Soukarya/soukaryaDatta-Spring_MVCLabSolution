package com.greatlearning.spring.springmvcorm.lab5.student.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.spring.springmvcorm.lab5.student.dao.StudentDao;
import com.greatlearning.spring.springmvcorm.lab5.student.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private SessionFactory factory;
	
	private Session session;
	
	@Autowired
	public StudentDaoImpl(SessionFactory factory){
		this.factory = factory;
		
		if(this.factory != null) {
			try {
				this.session = factory.getCurrentSession();
			}catch(HibernateException e) {
				this.session = factory.openSession();
			}
		}
	}

	@Override
	public void save(Student s) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(s);
		tx.commit();
	}

	@Override
	public void delete(int id) {
		Transaction tx = session.beginTransaction();
		Student temp = session.get(Student.class, id);
		session.delete(temp);
		tx.commit();
	}

	@Override
	public Student read(int id) {
		Student student = (Student) session.get(Student.class,id);
		return student;
	}

	@Override
	public List<Student> readAll() {
		List<Student> students = session.createQuery("from Student",Student.class).list();
		return students;
	}

	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}
