package com.rafael.rmfashion.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rafael.rmfashion.domain.ProdutoVariado;
import com.rafael.rmfashion.dto.ProdutoVariadoDTO;
import com.rafael.rmfashion.dto.ProdutoVariadoNewDTO;
import com.rafael.rmfashion.services.ProdutoVariadoService;

@RestController
@RequestMapping(value = "/produtosvariado")
public class ProdutoVariadoResource {
	
	@Autowired
	private ProdutoVariadoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProdutoVariado> buscar(@PathVariable Integer id){
			ProdutoVariado obj = service.buscar(id);
			return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ProdutoVariadoNewDTO objDto){
		ProdutoVariado obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> uodate(@RequestBody ProdutoVariado obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();	
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProdutoVariadoDTO>> buscarTodos(){
			List<ProdutoVariado> list = service.buscarTodos();
			List<ProdutoVariadoDTO> listDto = list.stream().map(obj -> new ProdutoVariadoDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);		
	}
	
}
