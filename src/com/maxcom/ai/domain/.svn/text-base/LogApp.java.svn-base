package com.maxcom.ai.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
*LogApp
*
*Clase que mapea a la tabla "LOG_APP" de la base de datos  
*
*Versión 1.0
*
*Octubre 2012
*
*/

@Entity
@Table(name="LOG_APP")
public class LogApp {

	private int idLog;
	private Date fecha;
	private int idUsuario;
	private String descripcion;
	
		
	public LogApp (){
		
	}
	public LogApp(Date fecha, int idUsuario, String descripcion){
	
		this.fecha = fecha;
		this.idUsuario = idUsuario;
		this.descripcion = descripcion;
	
	}
	
	@Id
	@GeneratedValue(generator = "SECUENCIA_ID_LOG_APP")
	@SequenceGenerator(name = "SECUENCIA_ID_LOG_APP", sequenceName = "SECUENCIA_ID_LOG_APP")
	@Column(name = "ID_LOG")
	public int getIdLog() {
		return idLog;
	}
	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}
	
	@Column(name = "FECHA")
	public Date getfecha() {
		return fecha;
	}
	public void setfecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Column(name = "ID_USUARIO")
	public int getidUsuario() {
		return idUsuario;
	}
	public void setidUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	@Column(name = "DESCRIPCION")
	public String getdescripcion() {
		return descripcion;
	}
	public void setdescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
