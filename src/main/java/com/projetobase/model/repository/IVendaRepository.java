package com.projetobase.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetobase.model.entity.Venda;

public interface IVendaRepository extends JpaRepository<Venda, Long> {

}
