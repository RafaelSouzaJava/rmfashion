package com.rafael.rmfashion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rafael.rmfashion.domain.ProdutoSexShop;;

@Repository
public interface ProdutoSexShopRepository extends JpaRepository<ProdutoSexShop, Integer>{

	
}
