package com.learn.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<NotFoundResponse> handleException(NotFoundException exc) {
		NotFoundResponse error = new NotFoundResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage("Incident not found " + exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<NotFoundResponse> handleException(Exception exc) {

		NotFoundResponse error = new NotFoundResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
