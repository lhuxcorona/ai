package com.maxcom.ai.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
/**
*Reportes
*
*Clase que mapea a la tabla "REPORTES" de la base de datos  
*
*Versión 1.0
*
*Septiembre 2012
*
*/

@Entity
@Table(name="REPORTES")
public class Reportes {
	
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
	
	
	public Reportes(){}
	
	
	public Reportes(Reportes r) {
		super();
		this.idReporte = r.getIdReporte();
		this.idProceso = r.getIdProceso();
		this.nomReporte = r.getNomReporte();
		this.sqlSelect = r.getSqlSelect();
		this.sqlFrom = r.getSqlFrom();
		this.sqlWhere = r.getSqlWhere();
		this.sqlGroupBy = r.getSqlHaving();
		this.sqlHaving = r.getSqlHaving();
		this.sqlOrderBy = r.getSqlOrderBy();
		this.columnaX = r.getColumnaX();
		this.columnaY = r.getColumnaY();
		this.etiquetaX = r.getEtiquetaX();
		this.etiquetaY = r.getEtiquetaY();
	}
	
	@Id
	@GeneratedValue(generator = "SECUENCIA_ID_REPORTE")
	@SequenceGenerator(name = "SECUENCIA_ID_REPORTE", sequenceName = "SECUENCIA_ID_REPORTE")
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
	
	@Override
	public String toString() {
		return "Reportes [idReporte=" + idReporte + ", idProceso=" + idProceso
				+ ", nomReporte=" + nomReporte + ", sqlSelect=" + sqlSelect
				+ ", sqlFrom=" + sqlFrom + ", sqlWhere=" + sqlWhere
				+ ", sqlGroupBy=" + sqlGroupBy + ", sqlHaving=" + sqlHaving
				+ ", sqlOrderBy=" + sqlOrderBy + ", columnaX=" + columnaX
				+ ", columnaY=" + columnaY + ", etiquetaX=" + etiquetaX
				+ ", etiquetaY=" + etiquetaY + "]";
	}
	
	
		
}