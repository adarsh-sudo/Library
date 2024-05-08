package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.library.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	
	public List<Book> findByBookName(String bookName);
	public List<Book> findByAuthor(String author);
	
	@Query("select b from Book b where bookName=?1 and author=?2")
	public List<Book> getBookDetails(String bookName , String author);
	
	public Book findByBookId(Integer bookId);
	
	
	
	
	
	
	

}
