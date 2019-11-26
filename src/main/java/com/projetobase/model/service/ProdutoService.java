package com.projetobase.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetobase.model.entity.Produto;
import com.projetobase.model.repository.IProdutoRepository;

@Service
@Transactional
public class ProdutoService {

	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/

	@Autowired
	private IProdutoRepository produtoRepository;
	
	/*-------------------------------------------------------------------
	 *				 		      SERVICES
	 *-------------------------------------------------------------------*/
	
	
	public Produto cadastrarProduto(Produto produto) {
		return this.produtoRepository.save(produto);
	}
	
	
	public List<Produto> listarProdutos(){
		return this.produtoRepository.findAll();
	}
}
