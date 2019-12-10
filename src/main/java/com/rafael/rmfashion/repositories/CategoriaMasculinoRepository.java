package com.rafael.rmfashion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.rmfashion.domain.CategoriaMasculino;

@Repository
public interface CategoriaMasculinoRepository extends JpaRepository<CategoriaMasculino, Integer>{

	
}
