package com.example.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * @author ganraviteja
 *
 *
 *	this class is used to handle the exception that occurs at controller level.
 *	The @ControllerAdvice is an annotation, to handle the exceptions globally.
 */

@ControllerAdvice
@RestController
public class CustomisedResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	/**
	 * The @ExceptionHandler is an annotation used to handle the specific exceptions and sending the custom 
	 * responses to the client.
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest)  {
		 
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), webRequest.getDescription(false));
		 
		 return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleAllExceptions(UserNotFoundException ex, WebRequest webRequest)  {
		 
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), webRequest.getDescription(false));
		 
		 return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
