package com.rafael.rmfashion.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.rmfashion.domain.ProdutoFeminino;



@Repository
public interface ProdutoFemininoRepository extends JpaRepository<ProdutoFeminino, Integer> {

	
	
}



