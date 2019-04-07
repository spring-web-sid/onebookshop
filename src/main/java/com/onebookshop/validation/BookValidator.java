package com.onebookshop.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.onebookshop.form.BookForm;

public class BookValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return 	BookForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		errors.rejectValue("name", "Please enter name of the book");
		errors.rejectValue("author", "Please enter name of author the book");
		errors.rejectValue("standard", "Please enter class the book is applicable for");
		errors.rejectValue("description", "Please provide some useful description");
		errors.rejectValue("basePrice", "Please enter price of the book");
		
	}

}
