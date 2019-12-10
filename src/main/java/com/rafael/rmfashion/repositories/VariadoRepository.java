package com.rafael.rmfashion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.rmfashion.domain.Variado;

@Repository
public interface VariadoRepository extends JpaRepository<Variado, Integer>{

	
}
