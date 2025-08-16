package com.gabryel.API_TodoList.exception;

public class TodoNotExistingException extends RuntimeException{
	public TodoNotExistingException(String message) {
		super(message);
	}
}
