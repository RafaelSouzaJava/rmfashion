package com.rafael.rmfashion.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.rafael.rmfashion.domain.Cliente;
import com.rafael.rmfashion.domain.enums.TipoCliente;
import com.rafael.rmfashion.dto.ClienteNewDTO;
import com.rafael.rmfashion.repositories.ClienteRepository;
import com.rafael.rmfashion.resources.exception.FieldMessage;
import com.rafael.rmfashion.services.validation.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	@Autowired
	private ClienteRepository repo;
	
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();

		// inclua os testes aqui, inserindo erros na lista
		
		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF Inválido"));
		}
		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ Inválido"));
		}
		
		Cliente aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}	
		Cliente aux2 = repo.findByCpfOuCnpj(objDto.getCpfOuCnpj());
		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && aux2 != null) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF já existente"));
		}
		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && aux2 != null) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ já existente"));
		}
		

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFildName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
