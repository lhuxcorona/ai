package com.maxcom.ai.domain.vistas;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*Menu
*
*Clase que mapea a la vista "DE_PROCESO_V" de la base de datos  
*
*Versión 1.0
*
*Octubre 2012
*
*/


@Entity
@Table(name="DE_PROCESO_V")
public class DeProcesoV {

	private long idDeProceso;
	private Date fecha;
	private String puntoDeControl;
	private String central; 
	private String descripcion;
	private Integer idCentral;
	private Integer idProceso;
	
	@Id
	@Column(name = "ID_DE_PROCESO")
	public long getIdDeProceso() {
		return idDeProceso;
	}
	public void setIdDeProceso(long idDeProceso) {
		this.idDeProceso = idDeProceso;
	}
	
	
	@Column(name = "FECHA")
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Column(name = "PUNTO_DE_CONTROL")
	public String getPuntoDeControl() {
		return puntoDeControl;
	}
	public void setPuntoDeControl(String puntoDeControl) {
		this.puntoDeControl = puntoDeControl;
	}	
	
	@Column(name = "CENTRAL")
	public String getCentral() {
		return central;
	}
	
	public void setCentral(String central) {
		this.central = central;
	}
	
	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Column(name = "ID_CENTRAL")

    public Integer getIdCentral() {
		return idCentral;
	}
	public void setIdCentral(Integer idCentral) {
		this.idCentral = idCentral;
	}
	
	@Column(name = "ID_PROCESO")
	public Integer getIdProceso() {
		return idProceso;
	}
	public void setIdProceso(Integer idProceso) {
		this.idProceso = idProceso;
	}
	
				
}
