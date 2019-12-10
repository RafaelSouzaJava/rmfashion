package com.rafael.rmfashion.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.rafael.rmfashion.domain.ProdutoMasculino;

public class ProdutoMasculinoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 5, max= 80, message = "O tamanho deve ser entre 5 a 80 caracteres")
	private String nome;
	private String tamanho;
	private String cor;	
	private Double preco;	
	

	public ProdutoMasculinoDTO() {		
	}
	
	public ProdutoMasculinoDTO(ProdutoMasculino obj) {
		id = obj.getId();
		nome = obj.getNome();
		tamanho = obj.getTamanho();
		cor = obj.getCor();
		preco = obj.getPreco();			
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}
