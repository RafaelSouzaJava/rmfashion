package com.rafael.rmfashion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.rmfashion.domain.ItemPedidoSexShop;;

@Repository
public interface ItemPedidoSexShopRepository extends JpaRepository<ItemPedidoSexShop, Integer>{

	
}
