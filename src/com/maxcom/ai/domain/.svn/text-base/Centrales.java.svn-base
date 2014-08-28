package com.maxcom.ai.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
*Centrales
*
*Clase que mapea a la tabla "CENTRALES" de la base de datos  
*
*Versión 1.0
*
*Septiembre 2012
*
*/

@Entity
@Table(name="CENTRALES")
public class Centrales {

	private int idCentral;
	private String nomCentral;
	private String ctlArchivo;
	private String dirAcceso;
	private String nomTablaCrudo;
	private String nomTablaFormato;
	private String sqlInsert;
	private String sqlSelect;
	private int cveCodificacion;
	private String activo;
	private Set<MapeoArchivos> mapeoArchivos;
		
	public Centrales (){
		
	}
	public Centrales(String nomCentral, String dirAcceso, String nomTablaCrudo, String nomTablaFormato, String sqlInsert, String sqlSelect, int cveCodificacion){
		
		this.nomCentral = nomCentral;
		this.dirAcceso = dirAcceso;
		this.nomTablaCrudo = nomTablaCrudo;
		this.nomTablaFormato = nomTablaFormato;
		this.sqlInsert = sqlInsert;
		this.sqlSelect = sqlSelect;
		this.cveCodificacion = cveCodificacion;
	}
	
	
	public Centrales(int idCentral, String nomCentral, String ctlArchivo,
			String dirAcceso, String nomTablaCrudo, String nomTablaFormato,
			String sqlInsert, String sqlSelect, int cveCodificacion,
			String activo, Set<MapeoArchivos> mapeoArchivos) {
		super();
		this.idCentral = idCentral;
		this.nomCentral = nomCentral;
		this.ctlArchivo = ctlArchivo;
		this.dirAcceso = dirAcceso;
		this.nomTablaCrudo = nomTablaCrudo;
		this.nomTablaFormato = nomTablaFormato;
		this.sqlInsert = sqlInsert;
		this.sqlSelect = sqlSelect;
		this.cveCodificacion = cveCodificacion;
		this.activo = activo;
		this.mapeoArchivos = mapeoArchivos;
	}
	
	
	public Centrales(Centrales central) {
		super();
		this.idCentral = central.getIdCentral();
		this.nomCentral = central.getNomCentral();
		this.ctlArchivo = central.getCtlArchivo();
		this.dirAcceso = central.getDirAcceso();
		this.nomTablaCrudo = central.getNomTablaCrudo();
		this.nomTablaFormato = central.getNomTablaFormato();
		this.sqlInsert = central.getSqlInsert();
		this.sqlSelect = central.getSqlSelect();
		this.cveCodificacion = central.getCveCodificacion();
		this.activo = central.getActivo();
		this.mapeoArchivos = central.getMapeoArchivos();	
	}
	
	
	@Id
	@GeneratedValue(generator = "SECUENCIA_ID_CENTRAL")
	@SequenceGenerator(name = "SECUENCIA_ID_CENTRAL", sequenceName = "SECUENCIA_ID_CENTRAL")
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
	
	@Column(name = "DIR_ACCESO")
	public String getDirAcceso() {
		return dirAcceso;
	}
	public void setDirAcceso(String dirAcceso) {
		this.dirAcceso = dirAcceso;
	}
	@Column(name = "CTL_ARCHIVO")
	public String getCtlArchivo() {
		return ctlArchivo;
	}
	public void setCtlArchivo(String ctlArchivo) {
		this.ctlArchivo = ctlArchivo;
	}
	
	@Column(name = "NOM_TABLA_CRUDO")
	public String getNomTablaCrudo() {
		return nomTablaCrudo;
	}
	public void setNomTablaCrudo(String nomTablaCrudo) {
		this.nomTablaCrudo = nomTablaCrudo;
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
			
	@Column(name = "CVE_CODIFICACION")
	public int getCveCodificacion() {
		return cveCodificacion;
	}
	public void setCveCodificacion(int cveCodificacion) {
		this.cveCodificacion = cveCodificacion;
	}
	
	@Column(name = "MCA_ACTIVO")
	public String getActivo() {
		return activo;
	}
	public void setActivo(String activo) {
		this.activo = activo;
	}
		
	@OneToMany (cascade = {CascadeType.ALL},fetch = FetchType.LAZY)	
	@JoinColumn(name="ID_CENTRAL", nullable=false) 	
	public Set<MapeoArchivos> getMapeoArchivos() {
		return mapeoArchivos;
	}
	public void setMapeoArchivos(Set<MapeoArchivos> mapeoArchivos) {
		this.mapeoArchivos = mapeoArchivos;
	}
	
	
	@Override
	public String toString() {
		return "Centrales [idCentral=" + idCentral + ", nomCentral="
				+ nomCentral + ", ctlArchivo=" + ctlArchivo + ", dirAcceso="
				+ dirAcceso + ", nomTablaCrudo=" + nomTablaCrudo
				+ ", nomTablaFormato=" + nomTablaFormato + ", sqlInsert="
				+ sqlInsert + ", sqlSelect=" + sqlSelect + ", cveCodificacion="
				+ cveCodificacion + ", activo=" + activo +  "]";
	}
	
}
