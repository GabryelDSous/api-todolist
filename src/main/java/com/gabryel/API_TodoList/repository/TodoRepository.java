package com.gabryel.API_TodoList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabryel.API_TodoList.entity.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long>{
	List<TodoEntity> findByNomeTarefaContainingIgnoreCase(String nome);
	List<TodoEntity> findByDescricaoIgnoreCase(String descricao);
	List<TodoEntity> findByPrioridade(int prioridade);
	List<TodoEntity> findByRealizado(Boolean realizado);
}
