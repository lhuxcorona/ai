package com.maxcom.ai.domain;

import javax.persistence.*;

/**
*PuntosDeControl
*
*Clase que mapea a la tabla "PUNTOS_DE_CONTROL" de la base de datos  
*
*Versión 1.0
*
*Agosto 2012
*
*/

@Entity
@Table(name = "PUNTOS_DE_CONTROL")
public class PuntosDeControl {
	private int idProceso;
	private String nomProceso;
	private Double umbral;
	
	public PuntosDeControl(){}
	

	
	public PuntosDeControl(int idProceso, String nomProceso, Double umbral) {
		super();
		this.idProceso = idProceso;
		this.nomProceso = nomProceso;
		this.umbral = umbral;
	}


	
	public PuntosDeControl(PuntosDeControl pc) {
		super();
		this.idProceso = pc.getIdProceso();
		this.nomProceso = pc.getNomProceso();
		this.umbral = pc.getUmbral();
	}



	@Id
	@GeneratedValue(generator = "SECUENCIA_ID_PROCESO")
	@SequenceGenerator(name = "SECUENCIA_ID_PROCESO", sequenceName = "SECUENCIA_ID_PROCESO")
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
	
	@Column(name = "PCT_UMBRAL")
	public Double getUmbral() {
		return umbral;
	}
	public void setUmbral(Double umbral) {
		this.umbral = umbral;
	}
	
	@Override
	public String toString() {
		return "PuntosDeControl [idProceso=" + idProceso + ", nomProceso="
				+ nomProceso + ", umbral=" + umbral + "]";
	}



}

