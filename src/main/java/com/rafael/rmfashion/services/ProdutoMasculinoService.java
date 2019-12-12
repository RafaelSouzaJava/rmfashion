package com.rafael.rmfashion.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.rafael.rmfashion.domain.CategoriaMasculino;
import com.rafael.rmfashion.domain.ProdutoMasculino;
import com.rafael.rmfashion.dto.ProdutoMasculinoDTO;
import com.rafael.rmfashion.dto.ProdutoMasculinoNewDTO;
import com.rafael.rmfashion.repositories.ProdutoMasculinoRepository;
import com.rafael.rmfashion.services.exceptions.DataIntegrityException;
import com.rafael.rmfashion.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoMasculinoService {
	
	@Autowired
	private ProdutoMasculinoRepository produtoMasculinorepository;
	


	public ProdutoMasculino buscar(Integer id) {
		Optional<ProdutoMasculino> obj = produtoMasculinorepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Produto Feminino Não Encontrado! Id: " +id + ", Tipo: "+ProdutoMasculino.class.getName()));
	}
	
	@Transactional
	public ProdutoMasculino insert(ProdutoMasculino obj) {
		obj.setId(null);
		return produtoMasculinorepository.save(obj);
	}
	
	public ProdutoMasculino update(ProdutoMasculino obj) {
		ProdutoMasculino newObj = buscar(obj.getId());
		updateProduto(newObj, obj);
		return produtoMasculinorepository.save(newObj);
	}
	
	public void delete(Integer id) {
		buscar(id);
		try {
			produtoMasculinorepository.deleteById(id);
		} 
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é Possivel excluir um Produto que tenha pedidos");
		}
	}
	
	public List<ProdutoMasculino> buscarTodos(){
		return produtoMasculinorepository.findAll();
	}
	
	public ProdutoMasculino fromDTO(ProdutoMasculinoDTO objDto) {
		return new ProdutoMasculino(objDto.getId(),objDto.getNome(),objDto.getTamanho(),objDto.getCor(),objDto.getPreco());
	}
	
	public ProdutoMasculino fromDTO(ProdutoMasculinoNewDTO objDto) {
		ProdutoMasculino produtoMaculino = new ProdutoMasculino(null, objDto.getNome(), objDto.getTamanho(), objDto.getCor(), objDto.getPreco());
		CategoriaMasculino catMasc = new CategoriaMasculino(objDto.getCategoriaMasculinoId(), null);	
		produtoMaculino.getCategoriasMasculino().add(catMasc);
		return produtoMaculino;
	}
	
		
	
	private void updateProduto(ProdutoMasculino newObj, ProdutoMasculino obj) {
		if (obj.getNome() != null) {
			newObj.setNome(obj.getNome());
		}
		if (obj.getCor() != null) {
			newObj.setCor(obj.getCor());
		}
		if (obj.getTamanho() != null) {
			newObj.setTamanho(obj.getTamanho());
		}
		if (obj.getPreco() != null) {
			newObj.setPreco(obj.getPreco());
		}
	}
}
