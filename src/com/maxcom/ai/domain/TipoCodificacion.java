package com.maxcom.ai.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*CodificaArchivos
*
*Clase que mapea a la tabla "TIPO_CODIFICACION" de la base de datos  
*
*Versión 1.0
*
*Septiembre 2012
*
*/

@Entity
@Table(name = "TIPO_CODIFICACION")
public class TipoCodificacion {
	private int claveCodificacion;
	private String nombreCodificacion;
	
	@Id
	@Column(name = "CVE_CODIFICACION")
	public int getClaveCodificacion() {
		return claveCodificacion;
	}
	public void setClaveCodificacion(int claveCodificacion) {
		this.claveCodificacion = claveCodificacion;
	}
	
	@Column(name = "NOM_CODIFICACION")
	public String getNombreCodificacion() {
		return nombreCodificacion;
	}
	public void setNombreCodificacion(String nombreCodificacion) {
		this.nombreCodificacion = nombreCodificacion;
	}
	
}
