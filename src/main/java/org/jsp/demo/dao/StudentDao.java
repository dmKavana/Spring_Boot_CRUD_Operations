package org.jsp.demo.dao;


import java.util.List;

import org.jsp.demo.dto.Student;
import org.jsp.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao 
{
	@Autowired 
	StudentRepository sr;
	
	public Student saveStudent(Student s)
	{
		return sr.save(s);		
	}

	public List<Student> fetchAll() 
	{
		return sr.findAll();
	}
	
	public Student FetchById(int id)
	{
		return sr.findById(id).orElse(null);	
	}

	public List<Student> fetchByName(String name)
	{
		return sr.findByName(name);
	}

	public List<Student> fetchByMobile(long mobile) 
	{
		// TODO Auto-generated method stub
		return sr.findByMobile(mobile);
	}

	public List<Student> saveStudent(List<Student> list)
	{
		return sr.saveAll(list);
	}

	public List<Student> fetchByResult(String result) 
	{
		// TODO Auto-generated method stub
		return sr.findByResult(result);
	}

	public List<Student> fetchByMaxPercentage() 
	{
		// TODO Auto-generated method stub
		return sr.findByMaxPercentage();
	}

	public List<Student> fetchBYGreaterThan(double percentage) 
	{
		// TODO Auto-generated method stub
		return sr.findByGreaterThan(percentage);
	}

	public List<Student> fetchByLessThan(double percentage) 
	{
		// TODO Auto-generated method stub
		return sr.findByLessThan(percentage);
	}

	public void delete(Student std)
	{
		sr.delete(std);;
		// TODO Auto-generated method stub
		
	}

//	public List<Student> fetchBYBetween(double percentage) 
//	{
//		// TODO Auto-generated method stub
//		return sr.findByBetween(percentage);
//	}

}

