package com.rafael.rmfashion.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ProdutoVariadoNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 4, max= 80, message = "O tamanho deve ser entre 4 a 80 caracteres")
	private String nome;	
	private Double preco;
	
	private Integer variadoId;
	
	public ProdutoVariadoNewDTO() {		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getVariadoId() {
		return variadoId;
	}

	public void setVariadoId(Integer variadoId) {
		this.variadoId = variadoId;
	}



}
