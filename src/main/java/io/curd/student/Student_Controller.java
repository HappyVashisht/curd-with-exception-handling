package io.curd.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Student_Controller {
	
	@Autowired
	private StudentService studentservice;
	
	@RequestMapping("/student")
	public List<Student> getAllStudent()
	{
		return studentservice.getAllStudent();
	}
	
	@RequestMapping("/student/{id}")
	public Optional<Student> getStudent(@PathVariable String id)
	{
		return studentservice.getStudent(id);
	}
	
	@PostMapping(value="/student")
	public void addStudent(@RequestBody Student student)
	{
		studentservice.addStudent(student);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/student/{id}")
	public void updateStudent(@RequestBody Student student, @PathVariable String id)
	{
		studentservice.updateStudent(student,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/student/{id}")
	public void deleteStudent(@PathVariable String id)
	{
		studentservice.deleteStudent(id);
	}
	

}
