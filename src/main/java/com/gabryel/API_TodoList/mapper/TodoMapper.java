package com.gabryel.API_TodoList.mapper;

import com.gabryel.API_TodoList.dto.TodoRequestDTO;
import com.gabryel.API_TodoList.dto.TodoResponseDTO;
import com.gabryel.API_TodoList.entity.TodoEntity;

public class TodoMapper {

	public static TodoEntity toEntity(TodoRequestDTO dto) {
		
		TodoEntity entity = new TodoEntity();
		entity.setNomeTarefa(dto.getNomeTarefa());
		entity.setDescricao(dto.getDescricao());
		entity.setPrioridade(dto.getPrioridade());
		entity.setRealizado(dto.isRealizado());
		
		return entity;
	}
	
	public static TodoResponseDTO toDTO(TodoEntity entity) {
		TodoResponseDTO dto = new TodoResponseDTO();
		dto.setId(entity.getId());
		dto.setNomeTarefa(entity.getNomeTarefa());
		dto.setDescricao(entity.getDescricao());
		dto.setPrioridade(entity.getPrioridade());
		dto.setRealizado(entity.isRealizado());
		
		return dto;
	}
}
