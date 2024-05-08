package com.library.dto;

import java.time.LocalDate;
import java.util.List;

import com.library.entity.Student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class StudentDTO {


	@NotNull(message = "{student.idcardnumber.notpresent}")
	private Integer idCardNumber;
	@NotNull(message = "{student.name.notpresent}")
	private String name;
	@NotNull(message = "{student.email.notpresent}")
	@Email(message = "{student.email.invalid}")
	private String email;
	@NotNull(message = "{student.phonenumber.notpresent}")
	private Integer phoneNumber;
	@NotNull(message = "{student.dateofborrow.notpresent}")
	private LocalDate dateOfBorrow;
	
	
	private List<Integer> bookIds;
	

	/**
	 * 
	 */
	public StudentDTO() {
		super();
	}
	@SuppressWarnings("unused")
	private StudentDTO(Integer idCardNumber, String name,String email,Integer phoneNumber,LocalDate dateOfBorrow, List<Integer> bookIds) {
		this.idCardNumber = idCardNumber;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBorrow = dateOfBorrow;
		this.bookIds = bookIds;
	}


	public Integer getIdCardNumber() {
		return idCardNumber;
	}
	public void setIdCardNumber(Integer idCardNumber) {
		this.idCardNumber = idCardNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getDateOfBorrow() {
		return dateOfBorrow;
	}
	public void setDateOfBorrow(LocalDate dateOfBorrow) {
		this.dateOfBorrow = dateOfBorrow;
	}
	
	public StudentDTO prepareDTO(Student student)
	{
		
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setDateOfBorrow(student.getDateOfBorrow());
		studentDTO.setEmail(student.getEmail());
		studentDTO.setIdCardNumber(student.getIdCardNumber());
		studentDTO.setName(student.getName());
		studentDTO.setPhoneNumber(student.getPhoneNumber());
		
		return studentDTO;
		
		
	}
	
	
	public Student prepareEntity(StudentDTO studentDTO)
	{
		Student student = new Student();
		student.setDateOfBorrow(studentDTO.getDateOfBorrow());
		student.setEmail(studentDTO.getEmail());
		student.setIdCardNumber(studentDTO.getIdCardNumber());
		student.setName(studentDTO.getName());
		student.setPhoneNumber(studentDTO.getPhoneNumber());
		
		return student;
		
		
	}
	public List<Integer> getBookIds() {
		return bookIds;
	}
	public void setBookIds(List<Integer> bookIds) {
		this.bookIds = bookIds;
	}


	
}
