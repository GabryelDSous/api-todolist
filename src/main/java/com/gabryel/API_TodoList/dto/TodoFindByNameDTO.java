package com.gabryel.API_TodoList.dto;

import jakarta.validation.constraints.NotBlank;

public class TodoFindByNameDTO {
	
	@NotBlank
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
