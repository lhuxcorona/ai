package com.maxcom.ai.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
*Usuarios
*
*Clase que mapea a la tabla "USUARIOS" de la base de datos  
*
*Versión 1.0
*
*Septiembre 2012
*
*/

@Entity
@Table(name = "USUARIOS")
public class Usuarios {
	
	private Integer idUsuario;
	private int idPerfil;
	private String usuario;
	private String password;
	private String nombre;
	private String paterno;
	private String materno;
	private String email;
	
	public Usuarios(){
		
	}
	public Usuarios(Usuarios u){
		this.email = u.getEmail();
		this.idPerfil = u.getIdPerfil();
		this.idUsuario = u.getIdUsuario();
		this.materno = u.getMaterno();
		this.nombre = u.getNombre();
		this.password = u.getPassword();
		this.paterno = u.getPaterno();
		this.usuario = u.getUsuario();
		
	}

	@Id
	@GeneratedValue(generator = "SECUENCIA_ID_USUARIO")
	@SequenceGenerator(name = "SECUENCIA_ID_USUARIO", sequenceName = "SECUENCIA_ID_USUARIO")
	@Column(name = "ID_USUARIO")
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
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
	
	@Override
	public String toString() {
		return "Usuarios [idUsuario=" + idUsuario + ", idPerfil=" + idPerfil
				+ ", usuario=" + usuario + ", password=" + password
				+ ", nombre=" + nombre + ", paterno=" + paterno + ", materno="
				+ materno + ", email=" + email + "]";
	}	 
	   
	
}
