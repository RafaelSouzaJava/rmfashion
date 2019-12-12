package com.rafael.rmfashion.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rafael.rmfashion.domain.ProdutoMasculino;
import com.rafael.rmfashion.dto.ProdutoMasculinoDTO;
import com.rafael.rmfashion.dto.ProdutoMasculinoNewDTO;
import com.rafael.rmfashion.resources.utils.URL;
import com.rafael.rmfashion.services.ProdutoMasculinoService;

@RestController
@RequestMapping(value = "/produtosmasculino")
public class ProdutoMasculinoResource {
	
	@Autowired
	private ProdutoMasculinoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProdutoMasculino> buscar(@PathVariable Integer id){
			ProdutoMasculino obj = service.buscar(id);
			return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ProdutoMasculinoNewDTO objDto){
		ProdutoMasculino obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> uodate(@Valid @RequestBody ProdutoMasculinoDTO objDto, @PathVariable Integer id){
		ProdutoMasculino obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();	
	}
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<ProdutoMasculinoDTO>> findPage(
			@RequestParam(value="nome", defaultValue="") String nome, 
			@RequestParam(value="categoriaSexShop", defaultValue="") String categoriasMasculino, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		String nomeDecoded = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeIntList(categoriasMasculino);
		Page<ProdutoMasculino> list = service.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
		Page<ProdutoMasculinoDTO> listDto = list.map(obj -> new ProdutoMasculinoDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
	
}
