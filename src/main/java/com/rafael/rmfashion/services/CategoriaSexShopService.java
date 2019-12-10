package com.rafael.rmfashion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rafael.rmfashion.domain.CategoriaSexShop;
import com.rafael.rmfashion.dto.CategoriaSexShopDTO;
import com.rafael.rmfashion.repositories.CategoriaSexShopRepository;
import com.rafael.rmfashion.services.exceptions.DataIntegrityException;
import com.rafael.rmfashion.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaSexShopService {
	
	@Autowired
	private CategoriaSexShopRepository repository;

	public CategoriaSexShop buscar(Integer id) {
		Optional<CategoriaSexShop> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria SexShop Não Encontrado! Id: " +id + ", Tipo: "+CategoriaSexShop.class.getName()));
	}
	
	public CategoriaSexShop insert(CategoriaSexShop obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public CategoriaSexShop update(CategoriaSexShop obj) {
		CategoriaSexShop newObj = buscar(obj.getId());
		updateProduto(newObj, obj);
		return repository.save(newObj);
	}
	
	public void delete(Integer id) {
		buscar(id);
		try {
			repository.deleteById(id);
		} 
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é Possivel excluir uma Categoria que tenha Produtos");
		}
	}	

	public List<CategoriaSexShop> buscarTodos(){
		return repository.findAll();
	}
	
	public Page<CategoriaSexShop> buscaPagina(Integer pagina, Integer linhasPorPagina, String ordenarPor, String direcao) {
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordenarPor);
		return repository.findAll(pageRequest);
	}
	
	public CategoriaSexShop fromDTO(CategoriaSexShopDTO objDto) {
		return new CategoriaSexShop(objDto.getId(), objDto.getNome());
	}
	
	private void updateProduto(CategoriaSexShop newObj, CategoriaSexShop obj) {
		if (obj.getNome() != null) {
			newObj.setNome(obj.getNome());
		}	
	}
	
}
