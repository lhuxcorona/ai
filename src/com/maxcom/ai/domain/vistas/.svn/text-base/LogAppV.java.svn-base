package com.maxcom.ai.domain.vistas;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*LogAppV
*
*Clase que mapea a la vista "LOG_APP_V" de la base de datos  
*
*Versión 1.0
*
*Octubre 2012
*
*/

@SuppressWarnings("serial")
@Entity
@Table(name="LOG_APP_V")
public class LogAppV implements Serializable {

	private Long id;
	private Date fecha;
	private String usuario;
	private String descripcion;
	private String completa;
	private Integer idUsuario;
	
	@Id
	@Column(name = "ID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "FECHA")
	public Date getFecha() {
		return fecha;
	}
	
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Column(name = "USUARIO")
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
	@Column(name = "COMPLETA")
	public String getCompleta() {
		return completa;
	}

	public void setCompleta(String completa) {
		this.completa = completa;
	}

	@Column(name = "IDUSUARIO")
	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
				
}
