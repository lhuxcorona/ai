package com.maxcom.ai.domain.vistas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*Centrales
*
*Clase que mapea a la tabla "CENTRALES_V" de la base de datos  
*
*Versión 1.0
*
*Septiembre 2012
*
*/
@Entity
@Table(name="CENTRALES_V")
public class CentralesV {
	
	private int idCentral;
	private String nomCentral;
	private String nomTablaCrudo;
	private String ctlArchivo;
	private String nomTablaFormato;
	private String sqlInsert;
	private String sqlSelect;
	private String sqlWhere;
	private String activo;
	private String dirAcceso;
	private String cveCodificacion;
	private String nomCodificacion;
	private String inhabilitarBorrar;
	
	@Id
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
	
	@Column(name = "NOM_TABLA_CRUDO")
	public String getNomTablaCrudo() {
		return nomTablaCrudo;
	}
	public void setNomTablaCrudo(String nomTablaCrudo) {
		this.nomTablaCrudo = nomTablaCrudo;
	}
	
	@Column(name = "CTL_ARCHIVO")
	public String getCtlArchivo() {
		return ctlArchivo;
	}
	public void setCtlArchivo(String ctlArchivo) {
		this.ctlArchivo = ctlArchivo;
	}
	
	@Column(name = "NOM_TABLA_FORMATO")
	public String getNomTablaFormato() {
		return nomTablaFormato;
	}
	
	public void setNomTablaFormato(String nomTablaFormato) {
		this.nomTablaFormato = nomTablaFormato;
	}
	
	@Column(name = "SQL_INSERT")
	public String getSqlInsert() {
		return sqlInsert;
	}
	public void setSqlInsert(String sqlInsert) {
		this.sqlInsert = sqlInsert;
	}
	
	@Column(name = "SQL_SELECT")
	public String getSqlSelect() {
		return sqlSelect;
	}
	public void setSqlSelect(String sqlSelect) {
		this.sqlSelect = sqlSelect;
	}
		
	@Column(name = "SQL_WHERE")
	public String getSqlWhere() {
		return sqlWhere;
	}
	public void setSqlWhere(String sqlWhere) {
		this.sqlWhere = sqlWhere;
	}
	
	@Column(name = "MCA_ACTIVO")
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}

	@Column(name = "DIR_ACCESO")
	public String getDirAcceso() {
		return dirAcceso;
	}
	public void setDirAcceso(String dirAcceso) {
		this.dirAcceso = dirAcceso;
	}
	
	@Column(name = "CVE_CODIFICACION")
	public String getCveCodificacion() {
		return cveCodificacion;
	}
	
	public void setCveCodificacion(String cveCodificacion) {
		this.cveCodificacion = cveCodificacion;
	}
	
	@Column(name = "NOM_CODIFICACION")
	public String getNomCodificacion() {
		return nomCodificacion;
	}
	public void setNomCodificacion(String nomCodificacion) {
		this.nomCodificacion = nomCodificacion;
	}
		
	@Column(name = "INHABILITAR_BORRAR")
	public String getInhabilitarBorrar() {
		return inhabilitarBorrar;
	}
	public void setInhabilitarBorrar(String inhabilitarBorrar) {
		this.inhabilitarBorrar = inhabilitarBorrar;
	}
}
