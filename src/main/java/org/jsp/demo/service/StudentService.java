package org.jsp.demo.service;

import java.util.List;

import org.jsp.demo.dao.StudentDao;
import org.jsp.demo.dto.Student;
import org.jsp.demo.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PostMapping;

@Service
public class StudentService
{
	
	@Autowired
	StudentDao dao;
	
//	@PostMapping
	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student s)
	{
		double percentage=(s.getMathematics()+s.getScience()+s.getSocialscience())/3.0;
		s.setPercentage(percentage);
		if(s.getMathematics()<35 || s.getScience()<35 ||s.getSocialscience()<35)
			s.setResult("fail");
		else
		{
			if(percentage<60)
				s.setResult("SecondClass");
			else if(percentage<85)
				s.setResult("FirstClass");
			else
				s.setResult("Distinction");
		}
		
		ResponseStructure<Student> structure=new ResponseStructure<>();
		structure.setMessage("Datd Saved Successfuly");
		structure.setStatusCode(HttpStatus.CREATED.value());
		structure.setData(dao.saveStudent(s));
		
		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.CREATED);
//		return new ResponseEntity<Student>("Account is Created");
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchAll() 
	{
			List<Student> lst=dao.fetchAll();
			if(lst.isEmpty())
			{
				ResponseStructure<List<Student>> structure=new ResponseStructure<>();
				structure.setMessage("Data not found");
				structure.setStatusCode(HttpStatus.NOT_FOUND.value());
				structure.setData(null);
				return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
			}
			else
			{
				ResponseStructure<List<Student>> structure=new ResponseStructure<>();
				structure.setMessage("Data found");
				structure.setStatusCode(HttpStatus.FOUND.value());
				structure.setData(lst);
				return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);		
			}
	}

	public ResponseEntity<ResponseStructure<Student>> fetchById(int id) 
	{
		Student std=dao.FetchById(id);
		if(std==null)
		{
			ResponseStructure<Student> structure=new ResponseStructure<>();
			structure.setMessage("Data not found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.NOT_FOUND);
		}
		else
		{
			ResponseStructure<Student> structure=new ResponseStructure<>();
			structure.setMessage("Datd found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(std);
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.FOUND);	
		}
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByName(String name)
	{
		List<Student> lst=dao.fetchByName(name);
				
			if(lst.isEmpty())
			{
				ResponseStructure<List<Student>> structure=new ResponseStructure<>();
				structure.setMessage("Data not found");
				structure.setStatusCode(HttpStatus.NOT_FOUND.value());
				structure.setData(null);
				return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
			}
			else
			{
				ResponseStructure<List<Student>> structure=new ResponseStructure<>();
				structure.setMessage("Data found");
				structure.setStatusCode(HttpStatus.FOUND.value());
				structure.setData(lst);
				return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);		
			}
		
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByMobile(long mobile) 
	{
		List<Student> lst=dao.fetchByMobile(mobile);
		
		if(lst.isEmpty())
		{
			ResponseStructure<List<Student>> structure=new ResponseStructure<>();
			structure.setMessage("Data not found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
		}
		else
		{
			ResponseStructure<List<Student>> structure=new ResponseStructure<>();
			structure.setMessage("Data found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(lst);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);		
		}
	
	}

	
	public ResponseEntity<ResponseStructure<List<Student>>> saveAll(List<Student> list) 
	{
		for(Student s:list)
		{
			double percentage=(s.getMathematics()+s.getScience()+s.getSocialscience())/3.0;
			s.setPercentage(percentage);
			if(s.getMathematics()<35 || s.getScience()<35 ||s.getSocialscience()<35|percentage<35)
				s.setResult("fail");
			else
			{
				if(percentage<60)
					s.setResult("SecondClass");
				else if(percentage<85)
					s.setResult("FirstClass");
				else
					s.setResult("Distinction");
			}
		}
		ResponseStructure<List<Student>> structure=new ResponseStructure<>();
		structure.setMessage("All Data Saved Successfuly");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		structure.setData(dao.saveStudent(list));
		
		return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.ACCEPTED);		

	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByResult(String result) 
	{
		List<Student> std=dao.fetchByResult(result);
		if(std.isEmpty())
		{
			ResponseStructure<List<Student>> structure=new ResponseStructure<>();
			structure.setMessage("Data not found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
		}
		else
		{
			ResponseStructure<List<Student>> structure=new ResponseStructure<>();
			structure.setMessage("Datd found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(std);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);	
		}
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByMaxPercentage() 
	{
		List<Student> std=dao.fetchByMaxPercentage();
		if(std==null)
		{
			ResponseStructure<List<Student>> structure=new ResponseStructure<>();
			structure.setMessage("Data not found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
		}
		else
		{
			ResponseStructure<List<Student>> structure=new ResponseStructure<>();
			structure.setMessage("Datd found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(std);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);	
		}
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByGreaterThan(double percentage) 
	{
		List<Student> std=dao.fetchBYGreaterThan(percentage);
		if(std==null)
		{
			ResponseStructure<List<Student>> structure=new ResponseStructure<>();
			structure.setMessage("Data not found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
		}
		else
		{
			ResponseStructure<List<Student>> structure=new ResponseStructure<>();
			structure.setMessage("Datd found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(std);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);	
		}
	}

	public ResponseEntity<ResponseStructure<List<Student>>> fetchByLessThan(double percentage)
	{
		List<Student> std=dao.fetchByLessThan(percentage);
		if(std==null)
		{
			ResponseStructure<List<Student>> structure=new ResponseStructure<>();
			structure.setMessage("Data not found");
			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setData(null);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
		}
		else
		{
			ResponseStructure<List<Student>> structure=new ResponseStructure<>();
			structure.setMessage("Datd found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setData(std);
			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);	
		}
	}

	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student s) 
	{
		double percentage=(s.getMathematics()+s.getScience()+s.getSocialscience())/3.0;
		s.setPercentage(percentage);
		if(s.getMathematics()<35 || s.getScience()<35 ||s.getSocialscience()<35||percentage<35)
			s.setResult("fail");
		else
		{
			if(percentage<60)
				s.setResult("SecondClass");
			else if(percentage<85)
				s.setResult("FirstClass");
			else
				s.setResult("Distinction");
		}
		
		ResponseStructure<Student> structure=new ResponseStructure<>();
		structure.setMessage("Datd updated Successfuly");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		structure.setData(dao.saveStudent(s));
		
		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Student>> deleteStudent(int id) 
	{
		Student std=dao.FetchById(id);
		ResponseStructure<Student> structure=new ResponseStructure<>();

		if(std==null)
		{
			structure.setMessage("Data not found");
			structure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			structure.setData(null);
		}
		else
		{
			dao.delete(std);
			structure.setMessage("Data Deleted Successfully");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			structure.setData(std);
		}
		return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.ACCEPTED);	

	}

//	public ResponseEntity<ResponseStructure<List<Student>>> fetchByBetween(double percentage)
//	{
//		List<Student> std=dao.fetchBYBetween(percentage);
//		if(std==null)
//		{
//			ResponseStructure<List<Student>> structure=new ResponseStructure<>();
//			structure.setMessage("Data not found");
//			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
//			structure.setData(null);
//			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
//		}
//		else
//		{
//			ResponseStructure<List<Student>> structure=new ResponseStructure<>();
//			structure.setMessage("Datd found");
//			structure.setStatusCode(HttpStatus.FOUND.value());
//			structure.setData(std);
//			return new ResponseEntity<ResponseStructure<List<Student>>>(structure,HttpStatus.FOUND);	
//		}
//	}
	
}
