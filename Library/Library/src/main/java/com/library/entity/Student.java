
package com.library.entity;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
    @Id
	private Integer idCardNumber;
	private String name;
	private String email;
	private Integer phoneNumber;
	private LocalDate dateOfBorrow;
	
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "student_book",
               joinColumns = @JoinColumn(name = "id_card_number"),
               inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books = new ArrayList<>();
	

	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
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


}
