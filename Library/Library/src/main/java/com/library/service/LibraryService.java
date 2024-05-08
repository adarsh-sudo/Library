package com.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.dto.BookDTO;
import com.library.dto.StudentDTO;
import com.library.dto.StudentDisplayDTO;
import com.library.exception.LibraryException;

@Service
public interface LibraryService {
	
	public List<BookDTO> getBookDetailsByBookName(String bookName) throws LibraryException;
	public List<BookDTO> getBookDetailsByAuthor(String author) throws LibraryException;
	public StudentDTO addStudent(StudentDTO studentDTO) throws LibraryException; 
	public BookDTO addBook(BookDTO bookDTO) throws LibraryException;
	public List<StudentDisplayDTO> getStudents(Integer idCardNumber) throws LibraryException;
	

}
