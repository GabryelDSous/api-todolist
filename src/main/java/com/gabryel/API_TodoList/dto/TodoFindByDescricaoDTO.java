package com.gabryel.API_TodoList.dto;

import jakarta.validation.constraints.NotBlank;

public class TodoFindByDescricaoDTO {
	
	@NotBlank
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
