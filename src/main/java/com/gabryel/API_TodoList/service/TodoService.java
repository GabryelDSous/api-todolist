package com.gabryel.API_TodoList.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabryel.API_TodoList.dto.TodoFindByNameDTO;
import com.gabryel.API_TodoList.dto.TodoRequestDTO;
import com.gabryel.API_TodoList.dto.TodoResponseDTO;
import com.gabryel.API_TodoList.entity.TodoEntity;
import com.gabryel.API_TodoList.exception.TodoNotExistingException;
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
	
	public List<TodoResponseDTO> findByName(TodoFindByNameDTO dtoNome){
		List<TodoEntity> todoExisting = repository.findByNomeTarefaContainingIgnoreCase(dtoNome.getNome());
		if(todoExisting.isEmpty())
			throw new TodoNotExistingException("Tarefa com o nome '" + dtoNome.getNome() + "' não existe! Verifique se o nome foi digitado corretamente.");
		Collections.sort(todoExisting, Comparator.comparing(TodoEntity::getPrioridade).reversed());
		return todoExisting
				.stream()
				.map(TodoMapper::toDTO)
				.toList();
	}
	
	// TODO:
	/*
	public List<TodoResponseDTO> findByDescricao(){
		
	}
	*/
}
