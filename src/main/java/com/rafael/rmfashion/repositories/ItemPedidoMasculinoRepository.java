package com.rafael.rmfashion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.rmfashion.domain.ItemPedidoMasculino;;

@Repository
public interface ItemPedidoMasculinoRepository extends JpaRepository<ItemPedidoMasculino, Integer>{

	
}
