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

import com.rafael.rmfashion.domain.CategoriaFeminino;
import com.rafael.rmfashion.dto.CategoriaFemininoDTO;
import com.rafael.rmfashion.services.CategoriaFemininoService;

@RestController
@RequestMapping(value = "/categoriasfeminino")
public class CategoriaFemininoResource {
	
	@Autowired
	private CategoriaFemininoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<CategoriaFeminino> buscar(@PathVariable Integer id){
			CategoriaFeminino obj = service.buscar(id);
			return ResponseEntity.ok().body(obj);		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoriaFemininoDTO objDto){
		CategoriaFeminino obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> uodate(@RequestBody CategoriaFemininoDTO objDto, @PathVariable Integer id){
		CategoriaFeminino obj = service.fromDTO(objDto);
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
	public ResponseEntity<List<CategoriaFemininoDTO>> buscarTodos(){
			List<CategoriaFeminino> list = service.buscarTodos();
			List<CategoriaFemininoDTO> listDto = list.stream().map(obj -> new CategoriaFemininoDTO(obj)).collect(Collectors.toList());
			return ResponseEntity.ok().body(listDto);		
	}
	
	@RequestMapping(value = "/pagina", method = RequestMethod.GET)
	public ResponseEntity<Page<CategoriaFemininoDTO>> buscaPagina(
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina, 
			@RequestParam(value = "linhasPorPagina", defaultValue = "24") Integer linhasPorPagina, 
			@RequestParam(value = "ordenarPor", defaultValue = "nome") String ordenarPor, 
			@RequestParam(value = "direcao", defaultValue = "ASC") String direcao){
			Page<CategoriaFeminino> list = service.buscaPagina(pagina,linhasPorPagina,ordenarPor,direcao);
			Page<CategoriaFemininoDTO> listDto = list.map(obj -> new CategoriaFemininoDTO(obj));
			return ResponseEntity.ok().body(listDto);		
	}
	
	
	
}
