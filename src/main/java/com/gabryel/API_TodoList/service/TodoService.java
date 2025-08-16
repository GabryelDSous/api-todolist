package com.gabryel.API_TodoList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabryel.API_TodoList.dto.TodoRequestDTO;
import com.gabryel.API_TodoList.dto.TodoResponseDTO;
import com.gabryel.API_TodoList.entity.TodoEntity;
import com.gabryel.API_TodoList.exception.TodoExiste;
import com.gabryel.API_TodoList.mapper.TodoMapper;
import com.gabryel.API_TodoList.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;
	
	public TodoResponseDTO create(TodoRequestDTO dto) {
		List<TodoEntity> todoExisting = repository.findByNomeTarefaContainingIgnoreCase(dto.getNomeTarefa());
		if(!todoExisting.isEmpty())
			throw new TodoExiste("Uma Tarefa com esse nome ja existe!");
		
		TodoEntity create = TodoMapper.toEntity(dto);
		TodoEntity saved = repository.save(create);
		
		return TodoMapper.toDTO(saved);
	}
}
