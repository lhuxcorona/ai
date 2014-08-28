package com.maxcom.ai.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
*MapeoReglas
*
*Clase que mapea a la tabla "MAPEO_REGLAS" de la base de datos  
*
*Versión 1.0
*
*Septiembre 2012
*
*/

@Entity
@Table(name="MAPEO_REGLAS")
public class MapeoReglas {
	
	private int idMapeoReglas;
	private int idProceso;
	private int idCentral;
	private int idRegla;
	private String codRegla;
		
	public MapeoReglas(){}
	
	
	public MapeoReglas(MapeoReglas mapeoReglas) {
		super();
		this.idMapeoReglas = mapeoReglas.getIdMapeoReglas();
		this.idProceso = mapeoReglas.getIdProceso();
		this.idCentral = mapeoReglas.getIdCentral();
		this.idRegla = mapeoReglas.getIdRegla();
		this.codRegla = mapeoReglas.getCodRegla();
	}

	@Id
	@GeneratedValue(generator = "SECUENCIA_ID_MAPEO_REG")
	@SequenceGenerator(name = "SECUENCIA_ID_MAPEO_REG", sequenceName = "SECUENCIA_ID_MAPEO_REG")
	@Column(name = "ID_MAPEO_REGLAS")
	public int getIdMapeoReglas() {
		return idMapeoReglas;
	}
	public void setIdMapeoReglas(int idMapeoReglas) {
		this.idMapeoReglas = idMapeoReglas;
	}
	
	@Column(name = "ID_REGLA")
	public int getIdRegla() {
		return idRegla;
	}
	public void setIdRegla(int idRegla) {
		this.idRegla = idRegla;
	}
	
	@Column(name = "COD_REGLA")
	public String getCodRegla() {
		return codRegla;
	}
	public void setCodRegla(String codRegla) {
		this.codRegla = codRegla;
	}
	@Column(name = "ID_CENTRAL")
	public int getIdCentral() {
		return idCentral;
	}
		
	public void setIdCentral(int idCentral) {
		this.idCentral = idCentral;
	}
	
	@Column(name = "ID_PROCESO")
	public int getIdProceso() {
		return idProceso;
	}
	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}

	@Override
	public String toString() {
		return "MapeoReglas [idMapeoReglas=" + idMapeoReglas + ", idProceso="
				+ idProceso + ", idCentral=" + idCentral + ", idRegla="
				+ idRegla + ", codRegla=" + codRegla + "]";
	}
			


}
