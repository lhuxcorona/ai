package com.maxcom.ai.domain.vistas;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*ReportesGeneradosV
*
*Clase que mapea a la vista "REPORTES_GENERADOS_V" de la base de datos  
*
*Versión 1.0
*
*Septiembre 2012
*
*/


@Entity
@Table(name="REPORTES_GENERADOS_V")
public class ReportesGeneradosV {
	
	private Long idRepoGrado;
	private int idProceso;
	private int idCentral;
	private Date FecIni;
	private Date FecFin;
	private Integer idReporte;
	private int tipoRegistro;
	private String resultado;
	private String xGraficaResultado;
	private String yGraficaResultado;
	private String nomProceso;
	private String nomCentral;
	private String nomReporte;
	
	@Id
	@Column(name = "ID_REPO_GRADO")	
	public Long getIdRepoGrado() {
		return idRepoGrado;
	}
	public void setIdRepoGrado(Long idRepoGrado) {
		this.idRepoGrado = idRepoGrado;
	}
	
	@Column(name = "ID_PROCESO")	
	public int getIdProceso() {
		return idProceso;
	}
	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}
	
	@Column(name = "ID_CENTRAL")
	public int getIdCentral() {
		return idCentral;
	}
	public void setIdCentral(int idCentral) {
		this.idCentral = idCentral;
	}
	
	@Column(name = "FEC_INI")
	public Date getFecIni() {
		return FecIni;
	}
	public void setFecIni(Date fecIni) {
		FecIni = fecIni;
	}
	
	@Column(name = "FEC_FIN")
	public Date getFecFin() {
		return FecFin;
	}
	public void setFecFin(Date fecFin) {
		FecFin = fecFin;
	}
	
	@Column(name = "ID_REPORTE")
	public Integer getIdReporte() {
		return idReporte;
	}
	public void setIdReporte(Integer idReporte) {
		this.idReporte = idReporte;
	}
	
	@Column(name = "TIPO_REGISTRO")
	public int getTipoRegistro() {
		return tipoRegistro;
	}
	public void setTipoRegistro(int tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}
	
	@Column(name = "RESULTADO")
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	@Column(name = "X_GRAFICA_RESULTADO")
	public String getxGraficaResultado() {
		return xGraficaResultado;
	}
	public void setxGraficaResultado(String xGraficaResultado) {
		this.xGraficaResultado = xGraficaResultado;
	}
	
	@Column(name = "Y_GRAFICA_RESULTADO")
	public String getyGraficaResultado() {
		return yGraficaResultado;
	}
	public void setyGraficaResultado(String yGraficaResultado) {
		this.yGraficaResultado = yGraficaResultado;
	}
	
	@Column(name = "NOM_PROCESO")
	public String getNomProceso() {
		return nomProceso;
	}
	public void setNomProceso(String nomProceso) {
		this.nomProceso = nomProceso;
	}
	
	@Column(name = "NOM_CENTRAL")
	public String getNomCentral() {
		return nomCentral;
	}
	public void setNomCentral(String nomCentral) {
		this.nomCentral = nomCentral;
	}
	
	@Column(name = "NOM_REPORTE")
	public String getNomReporte() {
		return nomReporte;
	}
	public void setNomReporte(String nomReporte) {
		this.nomReporte = nomReporte;
	}	
}
