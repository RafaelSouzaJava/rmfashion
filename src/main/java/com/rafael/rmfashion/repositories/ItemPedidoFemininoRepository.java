package com.rafael.rmfashion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.rmfashion.domain.ItemPedidoFeminino;;

@Repository
public interface ItemPedidoFemininoRepository extends JpaRepository<ItemPedidoFeminino, Integer>{

	
}
