package fr.formation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Login et/ou Mot de passe incorrect(s)")
public class ConnexionException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}