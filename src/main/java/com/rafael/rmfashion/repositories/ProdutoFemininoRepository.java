package com.rafael.rmfashion.repositories;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.rmfashion.domain.CategoriaFeminino;
import com.rafael.rmfashion.domain.ProdutoFeminino;



@Repository
public interface ProdutoFemininoRepository extends JpaRepository<ProdutoFeminino, Integer> {

	
	@Transactional(readOnly=true)
	Page<ProdutoFeminino> findDistinctByNomeContainingAndCategoriasFemininoIn(String nome, List<CategoriaFeminino> categoriasFeminino, Pageable pageRequest);
}



