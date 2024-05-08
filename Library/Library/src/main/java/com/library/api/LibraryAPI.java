package com.library.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.dto.BookDTO;
import com.library.dto.StudentDTO;
import com.library.dto.StudentDisplayDTO;
import com.library.exception.LibraryException;
import com.library.service.LibraryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/lib")
@Validated
public class LibraryAPI {
	
	@Autowired
	private LibraryService libraryService;
	
	
	
	@GetMapping(value = "/bookName/{bookName}")
	public ResponseEntity<List<BookDTO>> getBookDetailsByBookName(@PathVariable String bookName) throws LibraryException
	{
		return new ResponseEntity<>(libraryService.getBookDetailsByBookName(bookName) , HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/author/{author}")
	public ResponseEntity<List<BookDTO>> getBookDetailsByAuthor(@PathVariable String author) throws LibraryException
	{
		
		return new ResponseEntity<>(libraryService.getBookDetailsByAuthor(author), HttpStatus.OK);
	}
	
	
	
	@PostMapping(value = "/addStudent")
	public ResponseEntity<StudentDTO> addStudent(@RequestBody @Valid StudentDTO studentDTO) throws LibraryException
	{
		
		return new ResponseEntity<>(libraryService.addStudent(studentDTO), HttpStatus.CREATED) ;
		
	}
	
	
	@PostMapping(value = "/addbook")
	public ResponseEntity<BookDTO> addBook(@RequestBody @Valid BookDTO bookDTO) throws LibraryException
	{
		
		return new ResponseEntity<>(libraryService.addBook(bookDTO), HttpStatus.CREATED) ;
		
	}
	
	
	@GetMapping(value = "/students/{idCardNumber}")
	public ResponseEntity<List<StudentDisplayDTO>> getStudents(@PathVariable Integer idCardNumber) throws LibraryException
	{
		
		return new ResponseEntity<>(libraryService.getStudents(idCardNumber), HttpStatus.OK);
	}
	
	
	

}
