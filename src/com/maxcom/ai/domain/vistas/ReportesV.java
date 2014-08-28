package com.maxcom.ai.domain.vistas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
*ReportesV
*
*Clase que mapea a la vista "REPORTES_V" de la base de datos  
*
*Versión 1.0
*
*Septiembre 2012
*
*/
@Entity
@Table(name="REPORTES_V")
public class ReportesV {
	
	private int idReporte;
	private int idProceso;
	private String nomReporte;
	private String sqlSelect;
	private String sqlFrom;
	private String sqlWhere;
	private String sqlGroupBy;
	private String sqlHaving;
	private String sqlOrderBy;
	private String columnaX;
	private String columnaY;
	private String etiquetaX;
	private String etiquetaY;
	private String nomProceso; 
	
	@Id	
	@Column(name = "ID_REPORTE")		
	public int getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(int idReporte) {
		this.idReporte = idReporte;
	}
	
	@Column(name = "ID_PROCESO")	
	public int getIdProceso() {
		return idProceso;
	}
	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}
	
	@Column(name = "NOM_REPORTE")	
	public String getNomReporte() {
		return nomReporte;
	}
	public void setNomReporte(String nomReporte) {
		this.nomReporte = nomReporte;
	}
	
	@Column(name = "SQL_SELECT")	
	public String getSqlSelect() {
		return sqlSelect;
	}
	public void setSqlSelect(String sqlSelect) {
		this.sqlSelect = sqlSelect;
	}
	
	@Column(name = "SQL_FROM")	
	public String getSqlFrom() {
		return sqlFrom;
	}
	public void setSqlFrom(String sqlFrom) {
		this.sqlFrom = sqlFrom;
	}
	
	@Column(name = "SQL_WHERE")	
	public String getSqlWhere() {
		return sqlWhere;
	}
	public void setSqlWhere(String sqlWhere) {
		this.sqlWhere = sqlWhere;
	}
	
	@Column(name = "SQL_GROUPBY")	
	public String getSqlGroupBy() {
		return sqlGroupBy;
	}
	public void setSqlGroupBy(String sqlGroupBy) {
		this.sqlGroupBy = sqlGroupBy;
	}
	
	@Column(name = "SQL_HAVING")	
	public String getSqlHaving() {
		return sqlHaving;
	}
	public void setSqlHaving(String sqlHaving) {
		this.sqlHaving = sqlHaving;
	}
	
	@Column(name = "SQL_ORDERBY")	
	public String getSqlOrderBy() {
		return sqlOrderBy;
	}
	public void setSqlOrderBy(String sqlOrderBy) {
		this.sqlOrderBy = sqlOrderBy;
	}
	
	@Column(name = "COLUMNA_X")
	public String getColumnaX() {
		return columnaX;
	}
	public void setColumnaX(String columnaX) {
		this.columnaX = columnaX;
	}
	
	@Column(name = "COLUMNA_Y")
	public String getColumnaY() {
		return columnaY;
	}
	public void setColumnaY(String columnaY) {
		this.columnaY = columnaY;
	}
	
	@Column(name = "ETIQUETA_X")
	public String getEtiquetaX() {
		return etiquetaX;
	}
	public void setEtiquetaX(String etiquetaX) {
		this.etiquetaX = etiquetaX;
	}
	
	@Column(name = "ETIQUETA_Y")
	public String getEtiquetaY() {
		return etiquetaY;
	}
	public void setEtiquetaY(String etiquetaY) {
		this.etiquetaY = etiquetaY;
	}
	
	@Column(name = "NOM_PROCESO")
	public String getNomProceso() {
		return nomProceso;
	}
	public void setNomProceso(String nomProceso) {
		this.nomProceso = nomProceso;
	}	
		
}