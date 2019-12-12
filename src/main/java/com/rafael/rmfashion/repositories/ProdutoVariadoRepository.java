package com.rafael.rmfashion.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.rmfashion.domain.ProdutoVariado;
import com.rafael.rmfashion.domain.Variado;

@Repository
public interface ProdutoVariadoRepository extends JpaRepository<ProdutoVariado, Integer>{

	@Transactional(readOnly=true)

	@Query("SELECT DISTINCT obj FROM ProdutoVariado obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<ProdutoVariado> findDistinctByNomeContainingAndCategoriasIn(@Param("nome") String nome, @Param("categorias") List<Variado> categorias, Pageable pageRequest);
}
