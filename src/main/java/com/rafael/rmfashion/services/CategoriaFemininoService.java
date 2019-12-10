package com.rafael.rmfashion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rafael.rmfashion.domain.CategoriaFeminino;
import com.rafael.rmfashion.dto.CategoriaFemininoDTO;
import com.rafael.rmfashion.repositories.CategoriaFemininoRepository;
import com.rafael.rmfashion.services.exceptions.DataIntegrityException;
import com.rafael.rmfashion.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaFemininoService {
	
	@Autowired
	private CategoriaFemininoRepository repository;

	public CategoriaFeminino buscar(Integer id) {
		Optional<CategoriaFeminino> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria Feminino Não Encontrado! Id: " +id + ", Tipo: "+CategoriaFeminino.class.getName()));
	}
	
	public CategoriaFeminino insert(CategoriaFeminino obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public CategoriaFeminino update(CategoriaFeminino obj) {
		CategoriaFeminino newObj = buscar(obj.getId());
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
	
	public List<CategoriaFeminino> buscarTodos(){
		return repository.findAll();
	}
	
	public Page<CategoriaFeminino> buscaPagina(Integer pagina, Integer linhasPorPagina, String ordenarPor, String direcao) {
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordenarPor);
		return repository.findAll(pageRequest);
	}
	
	public CategoriaFeminino fromDTO(CategoriaFemininoDTO objDto) {
		return new CategoriaFeminino(objDto.getId(), objDto.getNome());
	}
		
	private void updateProduto(CategoriaFeminino newObj, CategoriaFeminino obj) {
		if (obj.getNome() != null) {
			newObj.setNome(obj.getNome());
		}	
	}
	
}
