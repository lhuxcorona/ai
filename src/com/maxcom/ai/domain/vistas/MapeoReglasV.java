package com.maxcom.ai.domain.vistas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
*MapeoReglasV
*
*Clase que mapea a la vista "LOG_APP_V" de la base de datos  
*
*Versión 1.0
*
*Octubre 2012
*
*/
@Entity
@Table(name="MAPEO_REGLAS_V")
public class MapeoReglasV {
	
	private int idMapeoReglas;
	private String codRegla;
	private int idProceso;
	private String nomProceso;
	private int idCentral;
	private String nomCentral;
	private int idRegla;
	private String nomRegla;
	
	@Id
	@Column(name = "ID_MAPEO_REGLAS")
	public int getIdMapeoReglas() {
		return idMapeoReglas;
	}
	public void setIdMapeoReglas(int idMapeoReglas) {
		this.idMapeoReglas = idMapeoReglas;
	}
	
	@Column(name = "COD_REGLA")
	public String getCodRegla() {
		return codRegla;
	}
	public void setCodRegla(String codRegla) {
		this.codRegla = codRegla;
	}
	
	@Column(name = "ID_PROCESO")
	public int getIdProceso() {
		return idProceso;
	}
	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}
	
	@Column(name = "NOM_PROCESO")
	public String getNomProceso() {
		return nomProceso;
	}
	public void setNomProceso(String nomProceso) {
		this.nomProceso = nomProceso;
	}
	
	@Column(name = "ID_CENTRAL")
	public int getIdCentral() {
		return idCentral;
	}
	
	public void setIdCentral(int idCentral) {
		this.idCentral = idCentral;
	}
	
	@Column(name = "NOM_CENTRAL")
	public String getNomCentral() {
		return nomCentral;
	}
	public void setNomCentral(String nomCentral) {
		this.nomCentral = nomCentral;
	}
	
	@Column(name = "ID_REGLA")
	public int getIdRegla() {
		return idRegla;
	}
	public void setIdRegla(int idRegla) {
		this.idRegla = idRegla;
	}

	@Column(name = "NOM_REGLA")
	public String getNomRegla() {
		return nomRegla;
	}
	public void setNomRegla(String nomRegla) {
		this.nomRegla = nomRegla;
	}
			
}
