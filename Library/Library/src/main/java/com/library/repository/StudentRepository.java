package com.library.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.library.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{
	
	
    @Query("select s from Student s where idCardNumber = ?1" )
	public List<Student> getStudentDetails(Integer idCardNumber);
    
    @Query("select s from Student s where idCardNumber = ?1" )
    public List<Student> getById(Integer idCardNumber);
	

}
