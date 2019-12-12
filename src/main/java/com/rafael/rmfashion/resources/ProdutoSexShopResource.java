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

import com.rafael.rmfashion.domain.ProdutoSexShop;
import com.rafael.rmfashion.dto.ProdutoSexShopDTO;
import com.rafael.rmfashion.dto.ProdutoSexShopNewDTO;
import com.rafael.rmfashion.resources.utils.URL;
import com.rafael.rmfashion.services.ProdutoSexShopService;

@RestController
@RequestMapping(value = "/produtossexshop")
public class ProdutoSexShopResource {
	
	@Autowired
	private ProdutoSexShopService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProdutoSexShop> buscar(@PathVariable Integer id){
			ProdutoSexShop obj = service.buscar(id);
			return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ProdutoSexShopNewDTO objDto){
		ProdutoSexShop obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> uodate(@Valid @RequestBody ProdutoSexShopDTO objDto, @PathVariable Integer id){
		ProdutoSexShop obj = service.fromDTO(objDto);
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
	public ResponseEntity<Page<ProdutoSexShopDTO>> findPage(
			@RequestParam(value="nome", defaultValue="") String nome, 
			@RequestParam(value="categoriaSexShop", defaultValue="") String categoriaSexShop, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		String nomeDecoded = URL.decodeParam(nome);
		List<Integer> ids = URL.decodeIntList(categoriaSexShop);
		Page<ProdutoSexShop> list = service.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
		Page<ProdutoSexShopDTO> listDto = list.map(obj -> new ProdutoSexShopDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
	
}
