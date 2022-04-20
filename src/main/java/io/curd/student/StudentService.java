package io.curd.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getAllStudent() {
		List<Student> students=new ArrayList<>();
		studentRepository.findAll().forEach(students::add);
		return students;
	}

	public Optional<Student> getStudent(String id) {
		return studentRepository.findById(id);
	}

	public void addStudent(Student student) {
		studentRepository.save(student);
		
	}

	public void updateStudent(Student student, String id) {
		studentRepository.save(student);
	}

	public void deleteStudent(String id) {
		studentRepository.deleteById(id);
	}

}
