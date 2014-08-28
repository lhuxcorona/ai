package com.maxcom.ai.domain;

import javax.persistence.*;

/**
*Tarifas
*
*Clase que mapea a la tabla "TARIFAS" de la base de datos  
*
*Versión 1.0
*
*Septiembre 2012
*
*/

@Entity
@Table(name = "TARIFAS")
public class Tarifas {
	
	long idTarifa;
	int tllClave;
	String accountCategory;
	double costo;
	

	public Tarifas(){
		
	}
	
	
	public Tarifas(Tarifas tarifa) {
		super();
		this.idTarifa = tarifa.getIdTarifa();
		this.tllClave = tarifa.getTllClave();
		this.accountCategory = tarifa.getAccountCategory();
		this.costo = tarifa.getCosto();
	}

	@Id
	@GeneratedValue(generator = "SECUENCIA_ID_TARIFA")
	@SequenceGenerator(name = "SECUENCIA_ID_TARIFA", sequenceName = "SECUENCIA_ID_TARIFA")
	@Column(name = "ID_TARIFA")
	public long getIdTarifa() {
		return idTarifa;
	}
	public void setIdTarifa(long idTarifa) {
		this.idTarifa = idTarifa;
	}
	
	@Column(name = "TLL_CLAVE")
	public int getTllClave() {
		return tllClave;
	}
	public void setTllClave(int tllClave) {
		this.tllClave = tllClave;
	}
	
	@Column(name = "ACCOUNT_CATEGORY")
	public String getAccountCategory() {
		return accountCategory;
	}
	public void setAccountCategory(String accountCategory) {
		this.accountCategory = accountCategory;
	}
	
	@Column(name = "COSTO")
	public double getCosto() {
		return costo;
	}
	
	public void setCosto(double costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "Tarifas [idTarifa=" + idTarifa + ", tllClave=" + tllClave
				+ ", accountCategory=" + accountCategory + ", costo=" + costo
				+ "]";
	}
	
	
	
}
