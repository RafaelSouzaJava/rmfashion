package com.rafael.rmfashion.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ProdutoFemininoNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max= 80, message = "O tamanho deve ser entre 5 a 80 caracteres")
	private String nome;
	private String tamanho;
	private String cor;
	private Double preco;
	
	private Integer categoriaFemininoId;
	
	public ProdutoFemininoNewDTO() {		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getCategoriaFemininoId() {
		return categoriaFemininoId;
	}

	public void setCategoriaFemininoId(Integer categoriaFemininoId) {
		this.categoriaFemininoId = categoriaFemininoId;
	}

}
