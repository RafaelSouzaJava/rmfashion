package com.rafael.rmfashion.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rafael.rmfashion.domain.Variado;
import com.rafael.rmfashion.dto.VariadoDTO;
import com.rafael.rmfashion.repositories.VariadoRepository;
import com.rafael.rmfashion.services.exceptions.DataIntegrityException;
import com.rafael.rmfashion.services.exceptions.ObjectNotFoundException;

@Service
public class VariadoService {
	
	@Autowired
	private VariadoRepository repository;
	
	public Variado buscar(Integer id) {
		Optional<Variado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria de Variados Não Encontrado! Id: " +id + ", Tipo: "+Variado.class.getName()));
	}
	
	public Variado insert(Variado obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Variado update(Variado obj) {
		Variado newObj = buscar(obj.getId());
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
	
	public List<Variado> buscarTodos(){
		return repository.findAll();
	}
	
	public Page<Variado> buscaPagina(Integer pagina, Integer linhasPorPagina, String ordenarPor, String direcao) {
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordenarPor);
		return repository.findAll(pageRequest);
	}
	
	public Variado fromDTO(VariadoDTO objDto) {
		return new Variado(objDto.getId(), objDto.getNome());
	}
	
	private void updateProduto(Variado newObj, Variado obj) {
		if (obj.getNome() != null) {
			newObj.setNome(obj.getNome());
		}	
	}

}
