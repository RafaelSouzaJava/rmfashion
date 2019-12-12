package com.rafael.rmfashion.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.rmfashion.domain.ProdutoVariado;
import com.rafael.rmfashion.domain.Variado;

@Repository
public interface ProdutoVariadoRepository extends JpaRepository<ProdutoVariado, Integer>{

	@Transactional(readOnly=true)
	Page<ProdutoVariado> findDistinctByNomeContainingAndVariadosIn(String nome, List<Variado> variados, Pageable pageRequest);
}
