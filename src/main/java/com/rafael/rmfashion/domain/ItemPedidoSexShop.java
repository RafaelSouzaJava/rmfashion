package com.rafael.rmfashion.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedidoSexShop implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private ItemPedidoSexShopPK id = new ItemPedidoSexShopPK();
	
	private Double desconto;
	private Integer quantidade;
	private Double preco;
	
	public ItemPedidoSexShop() {		
	}

	public ItemPedidoSexShop(Pedido pedido, ProdutoSexShop produtoSexShop, Double desconto, Integer quantidade, Double preco) {
		super();
		id.setPedido(pedido);
		id.setProdutoSexShop(produtoSexShop);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public double getSubTotal() {
		return (preco - desconto) * quantidade;
	}
	
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public ProdutoSexShop getProdutoSexShop() {
		return id.getProdutoSexShop();
	}
	
	public void setProdutoSexShop(ProdutoSexShop produtoSexShop) {
		id.setProdutoSexShop(produtoSexShop);
	}

	public ItemPedidoSexShopPK getId() {
		return id;
	}

	public void setId(ItemPedidoSexShopPK id) {
		this.id = id;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
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
		ItemPedidoSexShop other = (ItemPedidoSexShop) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}