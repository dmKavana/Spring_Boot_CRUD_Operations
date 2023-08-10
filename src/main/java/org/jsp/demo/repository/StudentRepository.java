package org.jsp.demo.repository;

import java.util.List;


import org.jsp.demo.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer>
{

	List<Student> findByName(String name);

	List<Student> findByMobile(long mobile);

	List<Student> findByResult(String result);

	@Query("select x from Student x where percentage=(select max(percentage) from Student)")
	List<Student> findByMaxPercentage();
	
	@Query("select x from Student x where percentage>80")
	List<Student> findByGreaterThan(double percentage);

	@Query("select x from Student x where percentage<80")
	List<Student> findByLessThan(double percentage);


//	@Query("select x from Student x where percentage ")
//	List<Student> findByBetween(double percentage);
	
}
