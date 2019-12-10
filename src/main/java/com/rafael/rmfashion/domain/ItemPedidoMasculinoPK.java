package com.rafael.rmfashion.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPedidoMasculinoPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "produtoMasculino_id")
	private ProdutoMasculino produtoMasculino;	

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}	

	public ProdutoMasculino getProdutoMasculino() {
		return produtoMasculino;
	}

	public void setProdutoMasculino(ProdutoMasculino produtoMasculino) {
		this.produtoMasculino = produtoMasculino;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produtoMasculino == null) ? 0 : produtoMasculino.hashCode());
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
		ItemPedidoMasculinoPK other = (ItemPedidoMasculinoPK) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produtoMasculino == null) {
			if (other.produtoMasculino != null)
				return false;
		} else if (!produtoMasculino.equals(other.produtoMasculino))
			return false;
		return true;
	}	

		

}
