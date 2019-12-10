package com.rafael.rmfashion.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.rafael.rmfashion.domain.CategoriaSexShop;
import com.rafael.rmfashion.domain.ProdutoSexShop;
import com.rafael.rmfashion.dto.ProdutoSexShopDTO;
import com.rafael.rmfashion.dto.ProdutoSexShopNewDTO;
import com.rafael.rmfashion.repositories.ProdutoSexShopRepository;
import com.rafael.rmfashion.services.exceptions.DataIntegrityException;
import com.rafael.rmfashion.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoSexShopService {
	
	@Autowired
	private ProdutoSexShopRepository repository;

	public ProdutoSexShop buscar(Integer id) {
		Optional<ProdutoSexShop> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Produto Feminino Não Encontrado! Id: " +id + ", Tipo: "+ProdutoSexShop.class.getName()));
	}
	
	@Transactional
	public ProdutoSexShop insert(ProdutoSexShop obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public ProdutoSexShop update(ProdutoSexShop obj) {
		ProdutoSexShop newObj =buscar(obj.getId());
		updateProduto(newObj, obj);
		return repository.save(newObj);
	}
	
	public void delete(Integer id) {
		buscar(id);
		try {
			repository.deleteById(id);
		} 
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é Possivel excluir um Produto que tenha pedidos");
		}
	}
	
	public List<ProdutoSexShop> buscarTodos(){
		return repository.findAll();
	}
	
	public ProdutoSexShop fromDTO(ProdutoSexShopDTO objDto) {
		return new ProdutoSexShop(objDto.getId(),objDto.getNome(),objDto.getPreco());
	}
	
	public ProdutoSexShop fromDTO(ProdutoSexShopNewDTO objDto) {
		ProdutoSexShop produtoSexShop = new ProdutoSexShop(null, objDto.getNome(), objDto.getPreco());
		CategoriaSexShop catMasc = new CategoriaSexShop(objDto.getCategoriaSexShopId(), null);
		produtoSexShop.getCategoriaSexShop().add(catMasc);
		return produtoSexShop;
	}
	
	private void updateProduto(ProdutoSexShop newObj, ProdutoSexShop obj) {
		if (obj.getNome() != null) {
			newObj.setNome(obj.getNome());
		}		
		if (obj.getPreco() != null) {
			newObj.setPreco(obj.getPreco());
		}
	}
}
