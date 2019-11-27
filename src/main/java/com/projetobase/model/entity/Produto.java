package com.projetobase.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
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
public class Produto extends AbstractEntity  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5728723962267291514L;
	
	@NotBlank
	private String nome;
	@NotNull
	private BigDecimal valor;
	@NotNull
	private Integer quantidadeEstoque;
	
	
	
	
	

}
