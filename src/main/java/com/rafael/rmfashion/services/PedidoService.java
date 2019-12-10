package com.rafael.rmfashion.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.rmfashion.domain.ItemPedidoFeminino;
import com.rafael.rmfashion.domain.ItemPedidoMasculino;
import com.rafael.rmfashion.domain.ItemPedidoSexShop;
import com.rafael.rmfashion.domain.ItemPedidoVariado;
import com.rafael.rmfashion.domain.PagamentoComBoleto;
import com.rafael.rmfashion.domain.Pedido;
import com.rafael.rmfashion.domain.enums.EstadoPagamento;
import com.rafael.rmfashion.repositories.ItemPedidoFemininoRepository;
import com.rafael.rmfashion.repositories.ItemPedidoMasculinoRepository;
import com.rafael.rmfashion.repositories.ItemPedidoSexShopRepository;
import com.rafael.rmfashion.repositories.ItemPedidoVariadoRepository;
import com.rafael.rmfashion.repositories.PagamentoRepository;
import com.rafael.rmfashion.repositories.PedidoRepository;
import com.rafael.rmfashion.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoFemininoService produtoFemininoService;
	
	@Autowired 
	private ProdutoMasculinoService produtoMasculinoService;
	
	@Autowired
	private ProdutoSexShopService produtoSexShopService;
	
	@Autowired
	private ProdutoVariadoService produtoVariadoService;
	
	@Autowired
	private ItemPedidoFemininoRepository itemPedidoFemininoRepository;	
	
	@Autowired
	private ItemPedidoMasculinoRepository itemPedidoMasculinoRepository;
	
	@Autowired
	private ItemPedidoSexShopRepository itemPedidoSexShopRepository;
	
	@Autowired
	private ItemPedidoVariadoRepository itemPedidoVariadoRepository;

	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Pedido Não Encontrado! Id: " +id + ", Tipo: "+Pedido.class.getName()));
	}
	
	@Transactional
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preemcherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repository.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		for(ItemPedidoFeminino ip1 : obj.getItensFeminino()) {
			ip1.setDesconto(0.0);
			ip1.setProdutoFeminino(produtoFemininoService.buscar(ip1.getProdutoFeminino().getId()));
			ip1.setPreco(ip1.getProdutoFeminino().getPreco());
			ip1.setPedido(obj);
		}
		for(ItemPedidoMasculino ip2 : obj.getItensMasculino()) {
			ip2.setDesconto(0.0);
			ip2.setProdutoMasculino(produtoMasculinoService.buscar(ip2.getProdutoMasculino().getId()));
			ip2.setPreco(ip2.getProdutoMasculino().getPreco());
			ip2.setPedido(obj);
		}
		for(ItemPedidoSexShop ip3 : obj.getItensSexshop()) {
			ip3.setDesconto(0.0);
			ip3.setProdutoSexShop(produtoSexShopService.buscar(ip3.getProdutoSexShop().getId()));
			ip3.setPreco(ip3.getProdutoSexShop().getPreco());
			ip3.setPedido(obj);
		}
		for(ItemPedidoVariado ip4 : obj.getItensVariado()) {
			ip4.setDesconto(0.0);
			ip4.setProdutoVariado(produtoVariadoService.buscar(ip4.getProdutoVariado().getId()));
			ip4.setPreco(ip4.getProdutoVariado().getPreco());
			ip4.setPedido(obj);
		}
		itemPedidoFemininoRepository.saveAll(obj.getItensFeminino());
		itemPedidoMasculinoRepository.saveAll(obj.getItensMasculino());
		itemPedidoSexShopRepository.saveAll(obj.getItensSexshop());
		itemPedidoVariadoRepository.saveAll(obj.getItensVariado());
		return obj;
	}
}
