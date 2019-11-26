package com.projetobase.model.service;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.projetobase.model.entity.Produto;

public class ProdutoServiceTests extends AbstractIntegrationTests {
	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/

	@Autowired
	private ProdutoService produtoService;

	/*-------------------------------------------------------------------
	 *				 		      TESTS
	 *-------------------------------------------------------------------*/

	// ======== CADASTRAR PRODUTO =============
	@Test
	public void cadastrarProdutoTestMustPass() {
		Produto produto = new Produto();
		produto.setNome("Coca-cola");
		produto.setQuantidadeEstoque(100);
		produto.setValor(new BigDecimal(8.00));

		this.produtoService.cadastrarProduto(produto);

		Assert.assertNotNull(produto.getId());
	}

	// ======== LISTAS PRODUTOS =============
	@Test
	@Sql({
		"/dataset/truncate.sql",
		"/dataset/produtos.sql"
	})
	public void listarProdutosTestMustPass() {
		List<Produto> produtos = this.produtoService.listarProdutos();

		Assert.assertNotNull(produtos);
		Assert.assertEquals(5, produtos.size());
	}
}
