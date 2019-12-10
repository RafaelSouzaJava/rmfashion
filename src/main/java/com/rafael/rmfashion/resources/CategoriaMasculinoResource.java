package com.rafael.rmfashion.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.rafael.rmfashion.domain.CategoriaMasculino;
import com.rafael.rmfashion.dto.CategoriaMasculinoDTO;
import com.rafael.rmfashion.services.CategoriaMasculinoService;

@RestController
@RequestMapping(value = "/categoriasmasculino")
public class CategoriaMasculinoResource {
	
	@Autowired
	private CategoriaMasculinoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CategoriaMasculino> listar(@PathVariable Integer id){
		CategoriaMasculino obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid  @RequestBody CategoriaMasculinoDTO objDto){
		CategoriaMasculino obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> uodate(@Valid @RequestBody CategoriaMasculinoDTO objDto, @PathVariable Integer id){
		CategoriaMasculino obj = service.fromDTO(objDto);
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
	public ResponseEntity<List<CategoriaMasculinoDTO>> buscarTodos(){
			List<CategoriaMasculino> list = service.buscarTodos();
			List<CategoriaMasculinoDTO> listDto = list.stream().map(obj -> new CategoriaMasculinoDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);		
	}
	
	@RequestMapping(value = "/pagina", method = RequestMethod.GET)
	public ResponseEntity<Page<CategoriaMasculinoDTO>> buscaPagina(
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina, 
			@RequestParam(value = "linhasPorPagina", defaultValue = "24") Integer linhasPorPagina, 
			@RequestParam(value = "ordenarPor", defaultValue = "nome") String ordenarPor, 
			@RequestParam(value = "direcao", defaultValue = "ASC") String direcao){
			Page<CategoriaMasculino> list = service.buscaPagina(pagina,linhasPorPagina,ordenarPor,direcao);
			Page<CategoriaMasculinoDTO> listDto = list.map(obj -> new CategoriaMasculinoDTO(obj));
			return ResponseEntity.ok().body(listDto);		
	}
	
}
