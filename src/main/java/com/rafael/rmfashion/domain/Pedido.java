package com.rafael.rmfashion.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date instante;
	
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
	private Pagamento pagamento;
	
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "endereco_de_entrega_id")
	private Endereco enderecoDeEntrega;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedidoFeminino> itensfeminino = new HashSet<>();
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedidoMasculino> itensmasculino = new HashSet<>();
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedidoVariado> itensvariado = new HashSet<>();
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedidoSexShop> itenssexshop = new HashSet<>();
	
	public Pedido() {		
	}

	public Pedido(Integer id, Date instante, Cliente cliente, Endereco enderecoDeEntrega) {
		super();
		this.id = id;
		this.instante = instante;		
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
	
	public double getValorTotal() {
		double soma1 =0;
		double soma2 = 0;
		double soma3 = 0;
		double soma4 = 0;
		double total = 0;
		for (ItemPedidoFeminino ip1 : itensfeminino) {
			soma1 = soma1 + ip1.getSubTotal();
		}
		for (ItemPedidoMasculino ip2 : itensmasculino) {
			soma2 = soma2 + ip2.getSubTotal();
		}
		for (ItemPedidoVariado ip3 : itensvariado) {
			soma3 = soma3 + ip3.getSubTotal();
		}
		for (ItemPedidoSexShop ip4 : itenssexshop) {
			soma4 = soma4 + ip4.getSubTotal();
		}
		total = soma1 + soma2 + soma3 + soma4;
		return total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}

	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
	
	public Set<ItemPedidoFeminino> getItensFeminino() {
		return itensfeminino;
	}

	public void setItensFeminino(Set<ItemPedidoFeminino> itensFeminino) {
		this.itensfeminino = itensFeminino;
	}

	public Set<ItemPedidoMasculino> getItensMasculino() {
		return itensmasculino;
	}

	public void setItensMasculino(Set<ItemPedidoMasculino> itensmasculino) {
		this.itensmasculino = itensmasculino;
	}

	public Set<ItemPedidoVariado> getItensVariado() {
		return itensvariado;
	}

	public void setItensvariado(Set<ItemPedidoVariado> itensvariado) {
		this.itensvariado = itensvariado;
	}

	public Set<ItemPedidoSexShop> getItensSexshop() {
		return itenssexshop;
	}

	public void setItenssexShop(Set<ItemPedidoSexShop> itenssexshop) {
		this.itenssexshop = itenssexshop;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
