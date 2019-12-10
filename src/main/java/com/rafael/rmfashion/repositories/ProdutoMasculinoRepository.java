package com.rafael.rmfashion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.rmfashion.domain.ProdutoMasculino;

@Repository
public interface ProdutoMasculinoRepository extends JpaRepository<ProdutoMasculino, Integer>{

	
}
