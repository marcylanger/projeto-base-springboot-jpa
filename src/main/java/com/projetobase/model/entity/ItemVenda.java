package com.projetobase.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ItemVenda extends AbstractEntity implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -1545483177845880180L;
	
	@ManyToOne(targetEntity = Venda.class)
	private Venda venda;
	
	@ManyToOne(targetEntity = Produto.class)
	private Produto produto;
	
	private Integer quantidade;
	
	private Integer valorUnitario;

}
