package com.rafael.rmfashion.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.rafael.rmfashion.domain.ProdutoVariado;
import com.rafael.rmfashion.domain.Variado;
import com.rafael.rmfashion.dto.ProdutoVariadoDTO;
import com.rafael.rmfashion.dto.ProdutoVariadoNewDTO;
import com.rafael.rmfashion.repositories.ProdutoVariadoRepository;
import com.rafael.rmfashion.repositories.VariadoRepository;
import com.rafael.rmfashion.services.exceptions.DataIntegrityException;
import com.rafael.rmfashion.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoVariadoService {
	
	@Autowired
	private ProdutoVariadoRepository repository;
	
	@Autowired
	private VariadoRepository variadoRepository;

	public ProdutoVariado buscar(Integer id) {
		Optional<ProdutoVariado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Produto Feminino Não Encontrado! Id: " +id + ", Tipo: "+ProdutoVariado.class.getName()));
	}
	
	@Transactional
	public ProdutoVariado insert(ProdutoVariado obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public ProdutoVariado update(ProdutoVariado obj) {
		ProdutoVariado newObj = buscar(obj.getId());
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
	
	public List<ProdutoVariado> buscarTodos(){
		return repository.findAll();
	}
	
	public ProdutoVariado fromDTO(ProdutoVariadoDTO objDto) {
		return new ProdutoVariado(objDto.getId(),objDto.getNome(),objDto.getPreco());
	}
	
	public ProdutoVariado fromDTO(ProdutoVariadoNewDTO objDto) {
		ProdutoVariado produtoVariado = new ProdutoVariado(null, objDto.getNome(), objDto.getPreco());
		Variado variado = new Variado(objDto.getVariadoId(), null);
		produtoVariado.getVariados().add(variado);
		return produtoVariado;
	}
	
	
	
	public Page<ProdutoVariado> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Variado> variado = variadoRepository.findAllById(ids);
		return repository.findDistinctByNomeContainingAndVariadosIn(nome, variado, pageRequest);
	}
	
	private void updateProduto(ProdutoVariado newObj, ProdutoVariado obj) {
		if (obj.getNome() != null) {
			newObj.setNome(obj.getNome());
		}		
		if (obj.getPreco() != null) {
			newObj.setPreco(obj.getPreco());
		}
	}
}
