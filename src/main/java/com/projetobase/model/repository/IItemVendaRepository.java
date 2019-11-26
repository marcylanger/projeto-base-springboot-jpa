package com.projetobase.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetobase.model.entity.ItemVenda;

public interface IItemVendaRepository extends JpaRepository<ItemVenda, Long> {

}
