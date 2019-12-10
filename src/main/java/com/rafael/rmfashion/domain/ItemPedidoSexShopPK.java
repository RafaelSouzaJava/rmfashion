package com.rafael.rmfashion.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemPedidoSexShopPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "produtoSexShop_id")
	private ProdutoSexShop produtoSexShop;

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}	

	public ProdutoSexShop getProdutoSexShop() {
		return produtoSexShop;
	}

	public void setProdutoSexShop(ProdutoSexShop produtoSexShop) {
		this.produtoSexShop = produtoSexShop;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produtoSexShop == null) ? 0 : produtoSexShop.hashCode());
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
		ItemPedidoSexShopPK other = (ItemPedidoSexShopPK) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produtoSexShop == null) {
			if (other.produtoSexShop != null)
				return false;
		} else if (!produtoSexShop.equals(other.produtoSexShop))
			return false;
		return true;
	}

		
}
