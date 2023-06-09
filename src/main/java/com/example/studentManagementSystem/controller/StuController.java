package com.example.studentManagementSystem.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.studentManagementSystem.repository.StudentRepository;
import com.example.studentManagementSystem.exception.ResourceNotFoundExceptionHandling;
import com.example.studentManagementSystem.model.Student;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class StuController {

	@Autowired
	private StudentRepository stuRepository;
	
	//get All student's list
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return stuRepository.findAll();
	}

	//register a new student in the system
	@PostMapping("/students")
	public Student registerStudent(@RequestBody Student student) {
		return stuRepository.save(student);
	}
	
	//get particular student Info by Id
	@GetMapping("/students/{stuId}")
	public ResponseEntity<Student> getStudentInfoById(@PathVariable Long stuId){
		Student student = stuRepository.findById(stuId).orElseThrow(() -> new ResourceNotFoundExceptionHandling("Student is not registred with id: "+ stuId));
		
		return ResponseEntity.ok(student);
	}
	
	//Update the student Info
	@PutMapping("students/{stuId}")
	public ResponseEntity<Student> updateStudentInfoById(@PathVariable Long stuId, @RequestBody Student updatedStuInfo){
		Student student = stuRepository.findById(stuId).orElseThrow(() -> new ResourceNotFoundExceptionHandling("Student is not registred with id: "+ stuId));
		
		student.setfName(updatedStuInfo.getfName());
		student.setlName(updatedStuInfo.getlName());
		student.setEmail(updatedStuInfo.getEmail());
		student.setClassName(updatedStuInfo.getClassName());
		student.setContact(updatedStuInfo.getContact());
		
		Student updatedStudent = stuRepository.save(student);
		return ResponseEntity.ok(updatedStudent);
	}
	
	//delete student info from DB
	@DeleteMapping("/students/{stuId}")
	public ResponseEntity<Map<String, Boolean>> deleteStuInfo(@PathVariable Long stuId){
		Student student = stuRepository.findById(stuId).orElseThrow(() -> new ResourceNotFoundExceptionHandling("Student is not registred with id: "+ stuId));
		
		stuRepository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted Info", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
	}
}
