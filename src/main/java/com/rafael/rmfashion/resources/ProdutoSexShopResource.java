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

import com.rafael.rmfashion.domain.ProdutoSexShop;
import com.rafael.rmfashion.dto.ProdutoSexShopDTO;
import com.rafael.rmfashion.dto.ProdutoSexShopNewDTO;
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
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProdutoSexShopDTO>> buscarTodos(){
			List<ProdutoSexShop> list = service.buscarTodos();
			List<ProdutoSexShopDTO> listDto = list.stream().map(obj -> new ProdutoSexShopDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);		
	}
	
}
