package com.library.dto;

import com.library.entity.Book;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class BookDTO {
	
	
	
	private Integer bookId;
	
	@NotNull(message = "book.bookname.notpresent")
	private String bookName;
	@NotNull(message = "book.author.notpresent")
	private String author;
	@NotNull(message = "book.quantity.notpresent")
	@Min(value = 1 , message = "book.quantity.invalid")
	private Long quantity;
	
	private Long remQuantity;
	
	
	

	public BookDTO() {
		super();
	
	}
	
	

	@SuppressWarnings("unused")
	private BookDTO(Integer bookId,String bookName, String author,Long quantity, Long remQuantity) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.quantity = quantity;
		this.remQuantity = remQuantity;
	}


	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getRemQuantity() {
		return remQuantity;
	}
	public void setRemQuantity(Long remQuantity) {
		this.remQuantity = remQuantity;
	}
	
	public BookDTO prepareDTO(Book book)
	{
		BookDTO bookDTO =  new BookDTO();
		bookDTO.setAuthor(book.getAuthor());
		bookDTO.setBookName(book.getBookName());
		bookDTO.setQuantity(book.getQuantity());
		bookDTO.setRemQuantity(book.getQuantity());
		bookDTO.setBookId(book.getBookId());
		
		return bookDTO;
	}
	
	public Book prepareEntity(BookDTO bookDTO)
	{
		Book book =  new Book();
		book.setAuthor(bookDTO.getAuthor());
		book.setBookName(bookDTO.getBookName());
		book.setQuantity(bookDTO.getQuantity());
		
		return book;
	}
	

}
