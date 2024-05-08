package com.library.validation;

import com.library.dto.StudentDTO;
import com.library.exception.LibraryException;

public class LibraryValidator {
	
    public static void validate(StudentDTO studentDTO) throws LibraryException
    {
	if (Boolean.FALSE.equals(validatePhoneNo(studentDTO.getPhoneNumber())))
	    throw new LibraryException("Validator.INVALID_PHONENO");

    }

    public static Boolean validatePhoneNo(Integer integer)
    {

	return integer.toString().matches("[6-9]{1}\\d{9}");

    }

	/**
	 * 
	 */
	private LibraryValidator() {
	}

}
