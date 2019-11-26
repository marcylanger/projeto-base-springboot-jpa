package com.projetobase.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetobase.model.entity.Produto;

public interface IProdutoRepository extends JpaRepository<Produto, Long> {

}
