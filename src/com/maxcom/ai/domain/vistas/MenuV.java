package com.maxcom.ai.domain.vistas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*MenuV
*
*Clase que mapea a la vista "MENU_V" de la base de datos  
*
*Versión 1.0
*
*Septiembre 2012
*
*/


@Entity
@Table(name="MENU_V")
@SuppressWarnings("serial")
public class MenuV implements Serializable {
	private int idMenu;
	private int idPadre;
	private Integer idHijo;
	private String padre;
	private String hijo;
	private int nivelPadre;
	private Integer nivelHijo;
	private int posicionPadre;
	private Integer posicionHijo;
	private String urlPadre;
	private String urlHijo;

	
	public MenuV (){
		
	}
	
	public MenuV(int idMenu, int idPadre, Integer idHijo, String padre,
			String hijo, int nivelPadre, Integer nivelHijo, int posicionPadre,
			Integer posicionHijo, String urlPadre, String urlHijo) {
		super();
		this.idMenu = idMenu;
		this.idPadre = idPadre;
		this.idHijo = idHijo;
		this.padre = padre;
		this.hijo = hijo;
		this.nivelPadre = nivelPadre;
		this.nivelHijo = nivelHijo;
		this.posicionPadre = posicionPadre;
		this.posicionHijo = posicionHijo;
		this.urlPadre = urlPadre;
		this.urlHijo = urlHijo;
	}

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
	
	@Column(name = "ID_HIJO")
	public Integer getIdHijo() {
		return idHijo;
	}
	public void setIdHijo(Integer idHijo) {
		this.idHijo = idHijo;
	}
	
	@Column(name = "PADRE")
	public String getPadre() {
		return padre;
	}
	public void setPadre(String padre) {
		this.padre = padre;
	}
	
	@Column(name = "HIJO")
	public String getHijo() {
		return hijo;
	}
	public void setHijo(String hijo) {
		this.hijo = hijo;
	}
	
	@Column(name = "NIVEL_PADRE")
	public int getNivelPadre() {
		return nivelPadre;
	}
	public void setNivelPadre(int nivelPadre) {
		this.nivelPadre = nivelPadre;
	}
	
	@Column(name = "NIVEL_HIJO")
	public Integer getNivelHijo() {
		return nivelHijo;
	}
	public void setNivelHijo(Integer nivelHijo) {
		this.nivelHijo = nivelHijo;
	}
	   	
	@Column(name = "POSICION_PADRE")
	public int getPosicionPadre() {
		return posicionPadre;
	}
	public void setPosicionPadre(int posicionPadre) {
		this.posicionPadre = posicionPadre;
	}
	
	@Column(name = "POSICION_HIJO")
	public Integer getPosicionHijo() {
		return posicionHijo;
	}
	public void setPosicionHijo(Integer posicionHijo) {
		this.posicionHijo = posicionHijo;
	}
	
	@Column(name = "URL_PADRE")
	public String getUrlPadre() {
		return urlPadre;
	}
	public void setUrlPadre(String urlPadre) {
		this.urlPadre = urlPadre;
	}
	
	@Column(name = "URL_HIJO")
	public String getUrlHijo() {
		return urlHijo;
	}
	public void setUrlHijo(String urlHijo) {
		this.urlHijo = urlHijo;
	}
		
}
