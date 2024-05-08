package com.library.dto;

import java.time.LocalDate;
import java.util.List;

import com.library.entity.Book;
import com.library.entity.Student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class StudentDisplayDTO {

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

	private List<Book> books;

	@SuppressWarnings("unused")
	private StudentDisplayDTO(Integer idCardNumber, String name, String email, Integer phoneNumber,
			LocalDate dateOfBorrow, List<Book> books) {
		this.idCardNumber = idCardNumber;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBorrow = dateOfBorrow;
		this.setBooks(books);
	}

	/**
	 * 
	 */
	public StudentDisplayDTO() {
		super();
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

	public StudentDisplayDTO prepareDTO(Student student) {

		StudentDisplayDTO studentDisplayDTO = new StudentDisplayDTO();
		studentDisplayDTO.setDateOfBorrow(student.getDateOfBorrow());
		studentDisplayDTO.setEmail(student.getEmail());
		studentDisplayDTO.setIdCardNumber(student.getIdCardNumber());
		studentDisplayDTO.setName(student.getName());
		studentDisplayDTO.setPhoneNumber(student.getPhoneNumber());
		
		

		return studentDisplayDTO;

	}

	public Student prepareEntity(StudentDTO studentDTO) {
		Student student = new Student();
		student.setDateOfBorrow(studentDTO.getDateOfBorrow());
		student.setEmail(studentDTO.getEmail());
		student.setIdCardNumber(studentDTO.getIdCardNumber());
		student.setName(studentDTO.getName());
		student.setPhoneNumber(studentDTO.getPhoneNumber());

		return student;

	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}