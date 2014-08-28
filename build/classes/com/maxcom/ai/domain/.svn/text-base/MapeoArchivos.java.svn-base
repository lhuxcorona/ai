package com.maxcom.ai.domain;

import javax.persistence.*;

/**
*MapeoArchivos
*
*Clase que mapea a la tabla "MAPEO_ARCHIVOS" de la base de datos  
*
*Versión 1.0
*
*Septiembre 2012
*
*/

@Entity
@Table(name = "MAPEO_ARCHIVOS")
public class MapeoArchivos {
	
	private int idMapeo;
	private int idCentral;
	private String nomCampo;
	private Integer longitud;
	private int posicion;
	
	@Id
	@GeneratedValue(generator = "SECUENCIA_ID_MAPEO")
	@SequenceGenerator(name = "SECUENCIA_ID_MAPEO", sequenceName = "SECUENCIA_ID_MAPEO")
	@Column(name = "ID_MAPEO")
	public int getIdMapeo() {
		return idMapeo;
	}
	public void setIdMapeo(int idMapeo) {
		this.idMapeo = idMapeo;
	}
	
	@Column(name = "ID_CENTRAL" ,updatable=false,insertable=false)
	public int getIdCentral() {
		return idCentral;
	}
	public void setIdCentral(int idCentral) {
		this.idCentral = idCentral;
	}
	
	@Column(name = "NOM_CAMPO")
	public String getNomCampo() {
		return nomCampo;
	}
	public void setNomCampo(String nomCampo) {
		this.nomCampo = nomCampo;
	}
	
	@Column(name = "LONGITUD")
	public Integer getLongitud() {
		return longitud;
	}
	public void setLongitud(Integer longitud) {
		this.longitud = longitud;
	}
	
	@Column(name = "POSICION")
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	  
}
