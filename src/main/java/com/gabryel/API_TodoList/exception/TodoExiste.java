package com.gabryel.API_TodoList.exception;

public class TodoExiste extends RuntimeException{
	public TodoExiste(String message) {
		super(message);
	}
}
