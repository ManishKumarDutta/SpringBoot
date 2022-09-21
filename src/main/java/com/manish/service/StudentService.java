package com.manish.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manish.model.Student;
import com.manish.repo.StudentRepository;
 
@Service
public class StudentService {
	
	@Autowired
	private StudentRepository demoRepository;

	public com.manish.model.Student getStudentInfo(Integer rollNo) {
		
		Optional<Student> optional = demoRepository.findById(rollNo);
		Student student = new Student();
		
		if(optional.isPresent()) {
			if(optional.get().getRollNo() == rollNo) {
				student.setRollNo(optional.get().getRollNo());
				student.setName(optional.get().getName());
			}
		} else {
			student.setRollNo(0);
			student.setName("No student with this Roll Number");
		}
		return student;
	}

	public Student saveStudent(Student student) {
		return demoRepository.save(student);
	}

	public Student updateStudent(Student student) {
		
		Optional<Student> optional = demoRepository.findById(student.getRollNo());
		if(optional.isEmpty()) {
			return student;
		}
		return demoRepository.save(student);
	}

	public String deleteStudent(Integer rollNo) {
		try {
			demoRepository.deleteById(rollNo);
		} catch (Exception ex) {
			return "Deletion failed";
		}
		return "Deletion successful";
	}
}
