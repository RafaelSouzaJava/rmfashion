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

import com.rafael.rmfashion.domain.Cidade;
import com.rafael.rmfashion.domain.Cliente;
import com.rafael.rmfashion.domain.Endereco;
import com.rafael.rmfashion.domain.enums.TipoCliente;
import com.rafael.rmfashion.dto.ClienteDTO;
import com.rafael.rmfashion.dto.ClienteNewDTO;
import com.rafael.rmfashion.repositories.ClienteRepository;
import com.rafael.rmfashion.repositories.EnderecoRepository;
import com.rafael.rmfashion.services.exceptions.DataIntegrityException;
import com.rafael.rmfashion.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Cliente Não Encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repository.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}

	public Cliente update(Cliente obj) {
		Cliente newObj = buscar(obj.getId());
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	public void delete(Integer id) {
		buscar(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é Possivel excluir um Cliente que tenha Pedidos");
		}
	}

	public List<Cliente> buscarTodos() {
		return repository.findAll();
	}

	public Page<Cliente> buscaPagina(Integer pagina, Integer linhasPorPagina, String ordenarPor, String direcao) {
		PageRequest pageRequest = PageRequest.of(pagina, linhasPorPagina, Direction.valueOf(direcao), ordenarPor);
		return repository.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null, null, null);
	}
	
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfOuCnpj(), objDto.getRg(), objDto.getDataNascimento(),TipoCliente.toEnum( objDto.getTipo()));
		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() != null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3() != null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		return cli;
	}

	private void updateData(Cliente newObj, Cliente obj) {
		if (obj.getNome() != null) {
			newObj.setNome(obj.getNome());
		}
		if (obj.getEmail() != null) {
			newObj.setEmail(obj.getEmail());
		}
	}
}
