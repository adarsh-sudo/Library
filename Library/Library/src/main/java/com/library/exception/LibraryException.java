package com.library.exception;

public class LibraryException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3819316720492022061L;

	/**
	 * 
	 */
	public LibraryException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public LibraryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public LibraryException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public LibraryException(String message) {
		super(message);

	}

	/**
	 * @param cause
	 */
	public LibraryException(Throwable cause) {
		super(cause);
	}
	
	

	
	
}
