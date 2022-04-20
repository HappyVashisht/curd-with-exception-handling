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
		if(students.isEmpty())
		{
			throw new EmptyInputException("1","No student is present in database");
		}
		return students;
	}

	public Optional<Student> getStudent(String id) {
		Optional<Student> x=studentRepository.findById(id);
		if(x.isEmpty())
		{
			throw new EmptyInputException("5","Id is not present in database");
		}
		return studentRepository.findById(id);
	}

	public void addStudent(Student student) {
//		studentRepository.save(student);
		if(student.getName().isEmpty() || student.getName().length()==0 || student.getId().isEmpty() || student.getId().length()==0 || student.getMarks().isEmpty() || student.getMarks().length()==0) {
			throw new EmptyInputException("2","Please provide all parameter");
		}
		studentRepository.save(student);
	}

	public void updateStudent(Student student, String id) {
		Optional<Student> x=studentRepository.findById(id);
		if(x.isEmpty())
		{
			throw new EmptyInputException("3","Id is not present in database");
		}
		studentRepository.save(student);
	}

	public void deleteStudent(String id) {
		Optional<Student> x=studentRepository.findById(id);
		if(x.isEmpty())
		{
			throw new EmptyInputException("4","Id is not present in database");
		}
		studentRepository.deleteById(id);
	}

}
