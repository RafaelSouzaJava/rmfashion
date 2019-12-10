package com.rafael.rmfashion.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.rafael.rmfashion.domain.CategoriaFeminino;
import com.rafael.rmfashion.domain.ProdutoFeminino;
import com.rafael.rmfashion.dto.ProdutoFemininoDTO;
import com.rafael.rmfashion.dto.ProdutoFemininoNewDTO;
import com.rafael.rmfashion.repositories.ProdutoFemininoRepository;
import com.rafael.rmfashion.services.exceptions.DataIntegrityException;
import com.rafael.rmfashion.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoFemininoService {
	
	@Autowired
	private ProdutoFemininoRepository repository;
	
	
	

	public ProdutoFeminino buscar(Integer id) {
		Optional<ProdutoFeminino> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Produto Feminino Não Encontrado! Id: " +id + ", Tipo: "+ProdutoFeminino.class.getName()));
	}
	
	@Transactional
	public ProdutoFeminino insert(ProdutoFeminino obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public ProdutoFeminino update(ProdutoFeminino obj) {
		ProdutoFeminino newObj = buscar(obj.getId());
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
	
	public List<ProdutoFeminino> buscarTodos(){
		return repository.findAll();
	}
	
	public ProdutoFeminino fromDTO(ProdutoFemininoDTO objDto) {
		return new ProdutoFeminino(objDto.getId(),objDto.getNome(),objDto.getTamanho(),objDto.getCor(),objDto.getPreco());
	}
	
	public ProdutoFeminino fromDTO(ProdutoFemininoNewDTO objDto) {
		ProdutoFeminino produtoFeminino = new ProdutoFeminino(null, objDto.getNome(), objDto.getTamanho(), objDto.getCor(), objDto.getPreco());
		CategoriaFeminino catMasc = new CategoriaFeminino(objDto.getCategoriaFemininoId(), null);	
		produtoFeminino.getCategoriasFeminino().add(catMasc);
		return produtoFeminino;
	}
	
	
	
	
	private void updateProduto(ProdutoFeminino newObj, ProdutoFeminino obj) {
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
