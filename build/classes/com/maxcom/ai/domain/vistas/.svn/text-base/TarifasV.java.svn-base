package com.maxcom.ai.domain.vistas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
*TarifasV
*
*Clase que mapea a la vista "TARIFAS_V" de la base de datos  
*
*Versión 1.0
*
*Septiembre 2012
*
*/

@Entity
@Table(name="TARIFAS_V")
public class TarifasV {
	
	long idTarifa;
	int tllClave;
	String accountCategory;
	double costo;
	String shortDisplay;
	String desTipoLlamada;
	String displayValue;
	String clasificacionCliente;
	
	@Id
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
	
	@Column(name = "SHORT_DISPLAY")
	public String getShortDisplay() {
		return shortDisplay;
	}
	public void setShortDisplay(String shortDisplay) {
		this.shortDisplay = shortDisplay;
	}
	@Column(name = "DES_TIPO_LLAMADA")
	public String getDesTipoLlamada() {
		return desTipoLlamada;
	}
	public void setDesTipoLlamada(String desTipoLlamada) {
		this.desTipoLlamada = desTipoLlamada;
	}
	
	@Column(name = "DISPLAY_VALUE")
	public String getDisplayValue() {
		return displayValue;
	}
	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}
	
	@Column(name = "CLASIFICACION_CLIENTE")
	public String getClasificacionCliente() {
		return clasificacionCliente;
	}
	public void setClasificacionCliente(String clasificacionCliente) {
		this.clasificacionCliente = clasificacionCliente;
	}
}
