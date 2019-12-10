package com.rafael.rmfashion.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPedidoFemininoPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	
	@ManyToOne
	@JoinColumn(name = "produtofeminino_id")
	private ProdutoFeminino produtoFeminino;	
	

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	public ProdutoFeminino getProdutoFeminino() {
		return produtoFeminino;
	}

	public void setProdutoFeminino(ProdutoFeminino produtoFeminino) {
		this.produtoFeminino = produtoFeminino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produtoFeminino == null) ? 0 : produtoFeminino.hashCode());
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
		ItemPedidoFemininoPK other = (ItemPedidoFemininoPK) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produtoFeminino == null) {
			if (other.produtoFeminino != null)
				return false;
		} else if (!produtoFeminino.equals(other.produtoFeminino))
			return false;
		return true;
	}	

		
	
}
