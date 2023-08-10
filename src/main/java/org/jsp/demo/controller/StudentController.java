package org.jsp.demo.controller;

import java.util.List;


import org.jsp.demo.dto.Student;
import org.jsp.demo.helper.ResponseStructure;
import org.jsp.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
//@RequestMapping("/students")
//for response and controller when we use the RestController no need to use @ResponseBody .
public class StudentController 
{

	@Autowired
	StudentService service;
	
//	Single data save
	@PostMapping("/students")
//	RequestBody is used to loading the values into to the object
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student)
	{
		return service.saveStudent(student);
	}
	
//	for multiple data save
	@PostMapping("/students/multiple")
	public ResponseEntity<ResponseStructure<List<Student>>> saveAll(@RequestBody List<Student> list)
	{
		return service.saveAll(list);
		
	}
	
//	Fetch all the sutdent details
	@GetMapping("/students")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchAll()
	{
		return service.fetchAll();	
	}
	
//	Fetching the student data by using id of student
	@GetMapping("students/fetchById/{id}")
	public ResponseEntity<ResponseStructure<Student>> fetchById(@PathVariable int id)
	{
		return service.fetchById(id);
	}
	
//	Fetching the student data by using name
	@GetMapping("students/fetchByName/{name}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByName(@PathVariable String name)
	{
		return service.fetchByName(name);
		
	}
	
//	Fetching the student data by using id of student other way
	@GetMapping("students/fetchById")
	public ResponseEntity<ResponseStructure<Student>> fetchById2(@RequestParam int id)
	{
		return service.fetchById(id);
	}
	
//	Fetch data by using mobile number
	@GetMapping("students/fetchByMobile/{mobile}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByMobile(@PathVariable long mobile)
	{
		return service.fetchByMobile(mobile);
		
	}
	
//	Based on MaximumPercentage fetch the student details
	@GetMapping("students/fetchByMaxPercentage")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByMaxPercentage()
	{
		return service.fetchByMaxPercentage();	
	}
	
// Based on the result fetch the student data
	@GetMapping("/students/result/{result}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchBYResult(@PathVariable String result)
	{
		return service.fetchByResult(result);
	}
	
// List the student whose percentage is greaterthan 80
	@GetMapping("/students/greaterthan/{percentage}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchByGreaterThan(@PathVariable double percentage)
	{
		return service.fetchByGreaterThan(percentage);
		
	}
	
// List the student whose percentage is lessthan 80
	@GetMapping("students/lessthan/{percentage}")
	public ResponseEntity<ResponseStructure<List<Student>>> fetchBYLessThan(@PathVariable double percentage)
	{
		return service.fetchByLessThan(percentage);
		
	}
	
//	@GetMapping("students/between/{percentage}")
//	public ResponseEntity<ResponseStructure<List<Student>>> fetchByBetween(@PathVariable double percentage)
//	{
//		return service.fetchByBetween(percentage);
//		
//	}
	
//	Update the student details
	@PutMapping("/students/update")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student)
	{
		return service.updateStudent(student);
	}
	
//	delete the student details
	@DeleteMapping("/students/delete/{id}")
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@PathVariable int id)
	{
		return service.deleteStudent(id);
	}
	
	
}

