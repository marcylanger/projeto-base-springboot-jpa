package com.projetobase.model.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetobase.model.entity.Venda;
import com.projetobase.model.repository.IVendaRepository;

@Transactional
@Service
public class VendaService {

	@Autowired
	private IVendaRepository vendaRepository;
	
	public Venda registrarVenda(Venda venda) {
		return vendaRepository.save(venda);
	}
	
}
