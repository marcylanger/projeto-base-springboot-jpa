package com.projetobase.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Venda extends AbstractEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5851878162845751829L;
	
	@OneToMany(targetEntity = ItemVenda.class, mappedBy = "venda", cascade = CascadeType.PERSIST)
	private List<ItemVenda> itens = new ArrayList<ItemVenda>();
	
	private BigDecimal valorTotal;
	
	@NotNull
	private LocalDateTime data;
	
	
	
	
	
	
	
	

}
