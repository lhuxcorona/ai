package com.maxcom.ai.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*Menu
*
*Clase que mapea a la tabla "MENU" de la base de datos  
*
*Versión 1.0
*
*Septiembre 2012
*
*/

@Entity
@Table(name="MENU")
public class Menu {

	private int idMenu;
	private int idPadre;
	private int posicion;
	private int nivel;
	private String titulo;
	private Integer defecto;
	private String url;
	
	
	@Id
	@Column(name = "ID_MENU")
	public int getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}
	
	@Column(name = "ID_PADRE")
	public int getIdPadre() {
		return idPadre;
	}
	public void setIdPadre(int idPadre) {
		this.idPadre = idPadre;
	}
	
	@Column(name = "POSICION")
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	@Column(name = "NIVEL")
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	@Column(name = "TITULO")
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Column(name = "DEFECTO")
	public Integer getDefecto() {
		return defecto;
	}
	public void setDefecto(Integer defecto) {
		this.defecto = defecto;
	}

	
	@Column(name = "URL")
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Menu [idMenu=" + idMenu + "]";
	}

	
	
}
