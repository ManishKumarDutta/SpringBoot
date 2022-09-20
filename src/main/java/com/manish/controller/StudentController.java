package com.manish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manish.model.Student;
import com.manish.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	
	@Autowired
	StudentService demoService;
	
	@GetMapping(value = "/getStudent/{rollNo}")
	public Student getStudentInfo(@PathVariable("rollNo") Integer rollNumber) {
		Student student = demoService.getStudentInfo(rollNumber);
		return student;
	}
	
	@PostMapping(value = "/saveStudent/")
	public Student saveStudent(@RequestBody Student student) {
		
		return demoService.saveStudent(student);
	}
}