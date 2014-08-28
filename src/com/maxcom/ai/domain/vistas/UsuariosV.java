package com.maxcom.ai.domain.vistas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*Usuarios
*
*Clase que mapea a la tabla "USUARIOS_V" de la base de datos  
*
*Versión 1.0
*
*Septiembre 2012
*
*/

@Entity
@Table(name = "USUARIOS_V")
public class UsuariosV {
	
	private long idUsuario;
	private int idPerfil;
	private String usuario;
	private String password;
	private String nombre;
	private String paterno;
	private String materno;
	private String email;
	private String perfil;
	
	
	@Id	
	@Column(name = "ID_USUARIO")
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}	
	
	@Column(name = "ID_PERFIL")
	public int getIdPerfil() {
		return idPerfil;
	}
	
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	@Column(name = "USUARIO")
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	@Column(name = "PASS")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "NOMBRE")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "PATERNO")
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	
	@Column(name = "MATERNO")
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	
	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "PERFIL")
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}	 	
	   
}
