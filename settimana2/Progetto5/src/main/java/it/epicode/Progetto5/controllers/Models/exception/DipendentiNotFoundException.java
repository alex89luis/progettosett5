package it.epicode.Progetto5.controllers.Models.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

public class DipendentiNotFoundException extends ApiValidationException {
	private static final long serialVersionUID = 1L;

	public DipendentiNotFoundException(List<ObjectError> errors) {
		super(errors, HttpStatus.NOT_FOUND, "Utente non trovato");
	}

}
