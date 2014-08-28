package com.maxcom.ai.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
*ReglasNegocio
*
*Clase que mapea a la tabla "REGLA_NEGOCIO" de la base de datos  
*
*Versión 1.0
*
*Septiembre 2012
*
*/

@Entity
@Table(name = "REGLAS_DE_NEGOCIO")
public class ReglasNegocio {
	
		
	public ReglasNegocio(){
		
	}
	public ReglasNegocio(ReglasNegocio rn) {
		super();
		this.codRegla = rn.getCodRegla();
		this.nomRegla = rn.getNomRegla();
	}

	private int codRegla;
	private String nomRegla;
	
	@Id
	@GeneratedValue(generator = "SECUENCIA_COD_REGLA")
	@SequenceGenerator(name = "SECUENCIA_COD_REGLA", sequenceName = "SECUENCIA_COD_REGLA")
	@Column(name = "ID_REGLA")
	public int getCodRegla() {
		return codRegla;
	}
	public void setCodRegla(int codRegla) {
		this.codRegla = codRegla;
	}
	
	@Column(name = "NOM_REGLA")
	public String getNomRegla() {
		return nomRegla;
	}
	
	public void setNomRegla(String nomRegla) {
		this.nomRegla = nomRegla;
	}
	
	
	@Override
	public String toString() {
		return "ReglasNegocio [codRegla=" + codRegla + ", nomRegla=" + nomRegla
				+ "]";
	}	
	
	
	
	
}
