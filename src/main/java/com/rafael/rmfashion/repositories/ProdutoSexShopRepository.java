package com.rafael.rmfashion.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rafael.rmfashion.domain.CategoriaSexShop;
import com.rafael.rmfashion.domain.ProdutoSexShop;;

@Repository
public interface ProdutoSexShopRepository extends JpaRepository<ProdutoSexShop, Integer>{

	@Transactional(readOnly=true)
	Page<ProdutoSexShop> findDistinctByNomeContainingAndCategoriaSexShopIn(String nome, List<CategoriaSexShop> categoriaSexShop, Pageable pageRequest);
}
