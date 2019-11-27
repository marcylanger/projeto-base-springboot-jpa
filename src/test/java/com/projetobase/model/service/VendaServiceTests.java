package com.projetobase.model.service;

import java.time.LocalDateTime;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.projetobase.model.entity.ItemVenda;
import com.projetobase.model.entity.Produto;
import com.projetobase.model.entity.Venda;
import com.projetobase.model.repository.IProdutoRepository;

public class VendaServiceTests extends AbstractIntegrationTests{

	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private IProdutoRepository produtoRepository;
	
	@Test
	public void registrarVendaTestMustPass() {
		Venda venda = new Venda();
		venda.setData(LocalDateTime.now());
		
		vendaService.registrarVenda(venda);
		
		Assert.assertNotNull(venda);
		Assert.assertNotNull(venda.getId());
	}
	
	@Test(expected = ValidationException.class)
	public void registrarVendaTestMustFailWithoutDate() {
		Venda venda = new Venda();
		
		vendaService.registrarVenda(venda);
		
	}
	
	@Sql({
		"/dataset/truncate.sql",
		"/dataset/produtos.sql"
	})
	@Test
	public void registrarVendaTestMustPassVerifyItensVenda() {
		Venda venda = new Venda();
		
		Produto produto1 = produtoRepository.findById(1001L).orElse(null);
		ItemVenda item1 = new ItemVenda();
		item1.setVenda(venda);
		item1.setProduto(produto1);
		
		venda.setData(LocalDateTime.now());
		
		venda.getItens().add(item1);
		
		vendaService.registrarVenda(venda);
		
		Assert.assertNotNull(venda);
		Assert.assertNotNull(venda.getItens());
		Assert.assertNotNull(venda.getItens().get(0));
		Assert.assertNotNull(venda.getItens().get(0).getId());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
