package com.rafael.rmfashion.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProdutoFeminino implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String tamanho;
	private String cor;
	
	private Double preco;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "PRODUTO_CATEGORIAFEMININO",
	joinColumns = @JoinColumn(name = "produtofemino_id"),
	inverseJoinColumns = @JoinColumn(name = "categoriafeminino_id")
			)
	private List<CategoriaFeminino> categoriasFeminino = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.produtoFeminino")
	private Set<ItemPedidoFeminino> itensFeminino = new HashSet<>();	
	
	public ProdutoFeminino() {		
	}

	public ProdutoFeminino(Integer id, String nome, String tamanho, String cor, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.tamanho = tamanho;
		this.cor = cor;
		this.preco = preco;		
	}
	
	@JsonIgnore
	public List<Pedido> getPedidos(){
		List<Pedido> lista = new ArrayList<>();
		for (ItemPedidoFeminino x : itensFeminino) {
			lista.add(x.getPedido());
		}
		return lista;
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

	public List<CategoriaFeminino> getCategoriasFeminino() {
		return categoriasFeminino;
	}

	public void setCategoriasFeminino(List<CategoriaFeminino> categoriasFeminino) {
		this.categoriasFeminino = categoriasFeminino;
	}
	
	@JsonIgnore
	public Set<ItemPedidoFeminino> getItensfeminino() {
		return itensFeminino;
	}

	public void setItensfeminino(Set<ItemPedidoFeminino> itensfeminino) {
		this.itensFeminino = itensfeminino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoFeminino other = (ProdutoFeminino) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
