package com.greatlearning.spring.springmvcorm.lab5.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.spring.springmvcorm.lab5.student.entity.Student;
import com.greatlearning.spring.springmvcorm.lab5.student.services.StudentService;

@Controller
@RequestMapping(path="students")
public class StudentController {

	@Autowired
	private StudentService service;
	
	
	public StudentService getService() {
		return service;
	}

	public void setService(StudentService service) {
		this.service = service;
	}

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String showHomePage() {
		return "index";
	}
	
	@RequestMapping(path="/list")
	public String listStudents(Model model) {
		List<Student> students = service.readAll();
		model.addAttribute("students", students);
		return "list-students";
	}
	
	@RequestMapping(path="/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Student student = new Student();
		model.addAttribute("student", student);
		return "student-form";
	}
	
	@RequestMapping(path="/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		
		Student student = service.read(id);
		model.addAttribute("student", student);
		return "student-form";
	}
	
	@PostMapping(path="/save")
	public String save(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam(name="department") String department, @RequestParam("country") String country) {
		Student student;
		if(id!=0) {
			student = service.read(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		}else {
			student = new Student(name,department,country);
		}
		service.save(student);
		return "redirect:/students/list";
	}
	
	@RequestMapping(path="/delete")
	public String delete(@RequestParam("studentId") int id) {
		service.delete(id);
		return "redirect:/students/list";
	}
	
}
