package com.maxcom.ai.domain;

import javax.persistence.*;

/**
*Tarifas
*
*Clase que mapea a la tabla "TIPO_LLAMADA" de la base de datos  
*
*Versión 1.0
*
*Septiembre 2012
*
*/

@Entity
@Table(name = "TIPO_LLAMADA")
public class TipoLlamadas {
	
	private int tllClave;
	private String descTipoLlamada;
	
	@Id	
	@Column(name = "TLL_CLAVE")
	public int getTllClave() {
		return tllClave;
	}
	public void setTllClave(int tllClave) {
		this.tllClave = tllClave;
	}
	
	@Column(name = "DESCRIPCION")
	public String getDescTipoLlamada() {
		return descTipoLlamada;
	}
	public void setDescTipoLlamada(String descTipoLlamada) {
		this.descTipoLlamada = descTipoLlamada;
	}
		
}
