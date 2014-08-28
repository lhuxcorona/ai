package com.maxcom.ai.domain;

import javax.persistence.*;

/**
*Tarifas
*
*Clase que mapea a la tabla "TIPOCLIENTE" de la base de datos  
*
*Versión 1.0
*
*Septiembre 2012
*
*/

@Entity
@Table(name = "TIPOCLIENTE")
public class TipoCliente {

	String accountCategory;
	String displayValue;
	String clasificacion;
	
	@Id
	@Column(name = "ACCOUNT_CATEGORY")	
	public String getAccountCategory() {
		return accountCategory;
	}
	public void setAccountCategory(String accountCategory) {
		this.accountCategory = accountCategory;
	}
	
	@Column(name = "DISPLAY_VALUE")
	public String getDisplayValue() {
		return displayValue;
	}
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
	
	@Column(name = "CLASIFICACION")
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	
}
