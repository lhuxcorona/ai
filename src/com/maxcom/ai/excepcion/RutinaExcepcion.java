package com.maxcom.ai.excepcion;

/**
*RutinaExcepcion
*
*Devuelve cualquier excepción de rutina  
*
*Versión 1.0
*
*Mayo 2012
*
*/
@SuppressWarnings("serial")
public class RutinaExcepcion extends Exception {
	
	public RutinaExcepcion(String msg){
		super(msg);
	}
	public RutinaExcepcion(){
		super("");
	}
}
