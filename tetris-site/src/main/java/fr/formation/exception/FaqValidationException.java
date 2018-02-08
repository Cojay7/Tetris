package fr.formation.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="L'ajout d'une question n'a pas pu être validé")
public class FaqValidationException extends RuntimeException {
		private static final long serialVersionUID = 1L;

	}

