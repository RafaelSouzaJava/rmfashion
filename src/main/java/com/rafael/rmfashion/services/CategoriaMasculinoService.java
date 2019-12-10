package com.rafael.rmfashion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rafael.rmfashion.domain.CategoriaMasculino;
import com.rafael.rmfashion.domain.ProdutoMasculino;
import com.rafael.rmfashion.dto.CategoriaMasculinoDTO;
import com.rafael.rmfashion.dto.ProdutoMasculinoNewDTO;
import com.rafael.rmfashion.repositories.CategoriaMasculinoRepository;
import com.rafael.rmfashion.services.exceptions.DataIntegrityException;
import com.rafael.rmfashion.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaMasculinoService {
	
	@Autowired
	private CategoriaMasculinoRepository repository;

	public CategoriaMasculino buscar(Integer id) {
		Optional<CategoriaMasculino> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria Masculino Não Encontrado! Id: " +id + ", Tipo: "+CategoriaMasculino.class.getName()));
	}
	
	public CategoriaMasculino insert(CategoriaMasculino obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public CategoriaMasculino update(CategoriaMasculino obj) {
		CategoriaMasculino newObj = buscar(obj.getId());
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

	public List<CategoriaMasculino> buscarTodos(){
		return repository.findAll();
	}
	
	public Page<CategoriaMasculino> buscaPagina(Integer pagina, Integer linhasPorPagina, String ordenarPor, String direcao) {
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordenarPor);
		return repository.findAll(pageRequest);
	}
	
	public CategoriaMasculino fromDTO(CategoriaMasculinoDTO objDto) {
		return new CategoriaMasculino(objDto.getId(), objDto.getNome());
	}
	
	public ProdutoMasculino fromDTO(ProdutoMasculinoNewDTO objDto) {
		ProdutoMasculino produtoMaculino = new ProdutoMasculino(null, objDto.getNome(), objDto.getTamanho(), objDto.getCor(), objDto.getPreco());
		CategoriaMasculino catMasc = new CategoriaMasculino(objDto.getCategoriaMasculinoId(), null);	
		catMasc.getProdutosMasculino().add(produtoMaculino);
		return produtoMaculino;
	}
	
	private void updateProduto(CategoriaMasculino newObj, CategoriaMasculino obj) {
		if (obj.getNome() != null) {
			newObj.setNome(obj.getNome());
		}	
	}
	
}
