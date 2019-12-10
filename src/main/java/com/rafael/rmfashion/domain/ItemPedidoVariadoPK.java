package com.rafael.rmfashion.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPedidoVariadoPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;	
	
	@ManyToOne
	@JoinColumn(name = "produtoVariado_id")
	private ProdutoVariado produtoVariado;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public ProdutoVariado getProdutoVariado() {
		return produtoVariado;
	}

	public void setProdutoVariado(ProdutoVariado produtoVariado) {
		this.produtoVariado = produtoVariado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produtoVariado == null) ? 0 : produtoVariado.hashCode());
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
		ItemPedidoVariadoPK other = (ItemPedidoVariadoPK) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produtoVariado == null) {
			if (other.produtoVariado != null)
				return false;
		} else if (!produtoVariado.equals(other.produtoVariado))
			return false;
		return true;
	}

	
	
}
