package com.rafael.rmfashion.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.rmfashion.domain.CategoriaMasculino;
import com.rafael.rmfashion.domain.ProdutoMasculino;

@Repository
public interface ProdutoMasculinoRepository extends JpaRepository<ProdutoMasculino, Integer>{

	@Transactional(readOnly=true)
	Page<ProdutoMasculino> findDistinctByNomeContainingAndCategoriasMasculinoIn(String nome, List<CategoriaMasculino> categoriasMasculino, Pageable pageRequest);
}
