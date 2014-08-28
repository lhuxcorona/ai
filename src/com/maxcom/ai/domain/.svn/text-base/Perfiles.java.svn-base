package com.maxcom.ai.domain;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
*Perfiles
*
*Clase que mapea a la tabla "PERFILES" de la base de datos  
*
*Versión 1.0
*
*Septiembre 2012
*
*/
@Entity
@Table(name = "PERFILES")
public class Perfiles {
	
	private int idPerfil;
	private String perfil;
	private String descripcion;
	private Set<Menu> menu = new HashSet<Menu>(0);
	
	public Perfiles(){}	
	
	public Perfiles(Perfiles perfil) {
		super();
		this.idPerfil = perfil.getIdPerfil();
		this.perfil = perfil.getPerfil();
		this.descripcion = perfil.getDescripcion();		
	}
	@Id
	@GeneratedValue(generator = "SECUENCIA_ID_PERFIL")
	@SequenceGenerator(name = "SECUENCIA_ID_PERFIL", sequenceName = "SECUENCIA_ID_PERFIL")
	@Column(name = "ID_PERFIL")	
	public int getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	@Column(name = "PERFIL")
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	@Column(name = "DESCRIPCION")
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "PERFIL_MENU", joinColumns = {
    @JoinColumn(name = "ID_PERFIL") }, inverseJoinColumns = { @JoinColumn(name = "ID_MENU") })
	public Set<Menu> getMenu() {
		return this.menu;
	}
	public void setMenu(Set<Menu> menu) {
		this.menu = menu;
	}
	
	@Override
	public String toString() {
		return "Perfiles [idPerfil=" + idPerfil + ", perfil=" + perfil
				+ ", descripcion=" + descripcion + "]";
	}
	
	
	
}
