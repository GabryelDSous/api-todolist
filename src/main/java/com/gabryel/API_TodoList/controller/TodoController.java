package com.gabryel.API_TodoList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabryel.API_TodoList.dto.TodoRequestDTO;
import com.gabryel.API_TodoList.dto.TodoResponseDTO;
import com.gabryel.API_TodoList.service.TodoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private TodoService service;
	
	@PostMapping
	public ResponseEntity<TodoResponseDTO> create(@RequestBody @Valid TodoRequestDTO dto){
		TodoResponseDTO create = service.create(dto);
		return ResponseEntity.ok(create);
	}
}
