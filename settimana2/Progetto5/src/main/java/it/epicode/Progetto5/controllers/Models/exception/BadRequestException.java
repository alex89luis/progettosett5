package it.epicode.Progetto5.controllers.Models.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

public class BadRequestException extends ApiValidationException {
	private static final long serialVersionUID = 1L;

	public BadRequestException(List<ObjectError> errors) {
		super(errors, HttpStatus.BAD_REQUEST, "Bad request");
	}

}
