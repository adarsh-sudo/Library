package com.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.dto.BookDTO;
import com.library.dto.StudentDTO;
import com.library.dto.StudentDisplayDTO;
import com.library.entity.Book;
import com.library.entity.Student;
import com.library.exception.LibraryException;
import com.library.repository.BookRepository;
import com.library.repository.StudentRepository;


@Service("libraryService")
@Transactional
public class LibraryServiceImplementation implements LibraryService{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	
///////////////// GET BOOK DETAILS FULL LIST FROM BOOK NAME ////////////////////////////////////
	
	@Override
	public List<BookDTO> getBookDetailsByBookName(String bookName) throws LibraryException
	{
		List<Book> books = bookRepository.findByBookName(bookName);
		if(books.isEmpty())
			throw new LibraryException("");
		List<BookDTO> bookDTOs = new ArrayList<>();
		books.stream().forEach(x -> bookDTOs.add(new BookDTO().prepareDTO(x)));
		
		return bookDTOs;
		
	}
	
	
	
///////////////// GET BOOK DETAILS FULL LIST FROM AUTHOR NAME ////////////////////////////////////
	
	@Override
	public List<BookDTO> getBookDetailsByAuthor(String author) throws LibraryException
	{
		
		List<Book> books = bookRepository.findByAuthor(author);
		if(books.isEmpty())
			throw new LibraryException("");
		List<BookDTO> bookDTOs = new ArrayList<>();
		books.stream().forEach(x -> bookDTOs.add(new BookDTO().prepareDTO(x)));
		
		return bookDTOs;
		
		
	}
	
////////////////////////////////////////////////   ADD BOOKS  ////////////////////////////////////

	@Override
	public BookDTO addBook(BookDTO bookDTO) throws LibraryException
{
		Book books = bookRepository.getBookDetails(bookDTO.getBookName(), bookDTO.getAuthor());
		
		Book book = new Book();
		if (books != null) {
			book = books;
			book.setQuantity(book.getQuantity()+bookDTO.getQuantity());
			book.setRemQuantity(book.getRemQuantity()+bookDTO.getQuantity());
			bookDTO.setRemQuantity(book.getRemQuantity());
			bookDTO.setQuantity(book.getQuantity());
			bookDTO.setBookId(book.getBookId());
			
		}
		else
		{
		
			book = new BookDTO().prepareEntity(bookDTO);
			book.setRemQuantity(bookDTO.getQuantity());
			//bookRepository.save(book);
			Integer id = bookRepository.save(book).getBookId();
			bookDTO.setRemQuantity(book.getRemQuantity());
			bookDTO.setBookId(id);
		}
		
	
		
		return bookDTO;
		
	}
	
	
//////////////////////////////////////////// ADD STUDENTS  ////////////////////////////////////
	
	@Override
	public StudentDTO addStudent(StudentDTO studentDTO) throws LibraryException {
		
	
		
			
        Optional<Student> studentOptional = studentRepository.findById(studentDTO.getIdCardNumber());

        
        
        if (studentOptional.isPresent()) {
        
            Student student = studentOptional.get();
            List<Book> booksToAdd = (List<Book>) bookRepository.findAllById(studentDTO.getBookIds());
            List<Integer> integers = new ArrayList<>();
            
            booksToAdd.stream()
                .filter(book -> book.getRemQuantity() > 0)
                .forEach(book -> {
                    student.getBooks().add(book);
                    book.setRemQuantity(book.getRemQuantity() - 1);
                    integers.add(book.getBookId());
                });

            // Save the student
            studentRepository.save(student);
            
            
            // Save all updated books
            bookRepository.saveAll(booksToAdd);
            
            StudentDTO studentDTO2 = new StudentDTO().prepareDTO(student);
            studentDTO2.setBookIds(integers);
            
            return studentDTO2;

        } else {
        	
            Student student = new StudentDTO().prepareEntity(studentDTO);
            List<Book> booksToAdd = (List<Book>) bookRepository.findAllById(studentDTO.getBookIds());
            List<Integer> integers = new ArrayList<>();

            booksToAdd.stream()
                .filter(book -> book.getRemQuantity() > 0)
                .forEach(book -> {
                    student.getBooks().add(book);
                    book.setRemQuantity(book.getRemQuantity() - 1);
                    integers.add(book.getBookId());
                });
            
            

            // Save the student
            studentRepository.save(student);
            
            // Save all updated books
            bookRepository.saveAll(booksToAdd);
            
            StudentDTO studentDTO2 = new StudentDTO().prepareDTO(student);
            studentDTO2.setBookIds(integers);
           
            
            return studentDTO2;
        }
        
		
		
	}
	
	
	///////////////// GET STUDENTS FULL LIST ////////////////////////////////////
	
	@Override
	public List<StudentDisplayDTO> getStudents(Integer idCardNumber) throws LibraryException
	{
		List<Student> students =  (List<Student>) studentRepository.findAll();
		
		List<StudentDisplayDTO> studentDisplayDTOs =  new ArrayList<>();
		for(Student s : students)
		{
			StudentDisplayDTO studentDisplayDTO = new StudentDisplayDTO().prepareDTO(s);
			studentDisplayDTO.setBooks(s.getBooks());
			studentDisplayDTOs.add(studentDisplayDTO);
		}
		
		
		
		return studentDisplayDTOs;
		
		
		
		
	}
}
