package com.gabryel.API_TodoList.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TodoNotExistingException.class)
	public ResponseEntity<ErrorMessage> handleReposityEmptyException(TodoNotExistingException ex, HttpServletRequest request){
		ErrorMessage error = new ErrorMessage(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST.value(),
				"Conflict",
				ex.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(TodoExiste.class)
	public ResponseEntity<ErrorMessage> handleTodoExisteException(TodoExiste ex, HttpServletRequest request){
		ErrorMessage error = new ErrorMessage(
				LocalDateTime.now(),
				HttpStatus.CONFLICT.value(),
				"Conflict",
				ex.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request){
		String message = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(error -> error.getField() + ": " + error.getDefaultMessage())
				.collect(Collectors.joining(", "));
		
		ErrorMessage error = new ErrorMessage(
				LocalDateTime.now(), 
				HttpStatus.BAD_REQUEST.value(), 
				"Bad Request", 
				message,
				request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
