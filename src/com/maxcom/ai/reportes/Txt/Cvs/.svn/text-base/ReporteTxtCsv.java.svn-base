package com.maxcom.ai.reportes.Txt.Cvs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.maxcom.ai.domain.vistas.DeProcesoV;
import com.maxcom.ai.domain.vistas.LogAppV;
import com.maxcom.ai.domain.vistas.ReportesGeneradosV;

/**
*ReporteTxtCsv
*
*Clase encargada de generar archivos de tipo CSV ó TXT  
*
*Versión 1.0
*
*Octubre 2012
*
*/

public class ReporteTxtCsv {

	/**
	 * Genera el archivo de reporte de reproceso en formato CSV ó TXT.
	 *  
	 * @param ruta Ruta de salida del archivo
	 * @param nombreArchivo Nombre del archivo
	 * @throws IOException Error al generar el archivo
	 * 
	 */
	public void reportarTxtCsv(String ruta, String nombreArchivo, List<LogAppV> lstReporte) throws IOException {		
		
			String rutaSalida = ruta+nombreArchivo;
			System.setProperty("line.separator","\r\n");
			FileWriter fw = new FileWriter(rutaSalida);
		    BufferedWriter bw = new BufferedWriter(fw);
		    PrintWriter salida = new PrintWriter(bw);
		    
		    salida.close();   
	}	

	/**
	 * Genera el archivo de consulta de logs en formato CSV ó TXT.
	 *  
	 * @param ruta Ruta de salida del archivo
	 * @param nombreArchivo Nombre del archivo
	 * @throws IOException Error al generar el archivo
	 * 
	 */
	public void reportarTxtCsvLogs(String ruta, String nombreArchivo, List<LogAppV> lstLogs) throws IOException {		
		String rutaSalida = ruta+nombreArchivo;
		System.setProperty("line.separator","\r\n");
		FileWriter fw = new FileWriter(rutaSalida);
	    BufferedWriter bw = new BufferedWriter(fw);
	    PrintWriter salida = new PrintWriter(bw);
	    String descripcion="";
	    int i=1;
	    salida.println("Id,"+"Fecha,"+"Usuario,"+"Descripción");
	    
		for(LogAppV l: lstLogs){
					
			if(l.getDescripcion()!= null){
				descripcion=l.getCompleta();					
			}else{
				descripcion="-";
			}
			salida.println(String.valueOf(i)+","+
					new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(l.getFecha())+","+l.getUsuario()+","+descripcion);
			i++;
		}
	    salida.close();   
	}

	
	
	/**
	 * Genera el archivo de consulta de logs en formato CSV ó TXT.
	 *  
	 * @param ruta Ruta de salida del archivo
	 * @param nombreArchivo Nombre del archivo
	 * @throws IOException Error al generar el archivo
	 * 
	 */
	public void reportarTxtCsvProceso(String ruta, String nombreArchivo, List<DeProcesoV> lstProceso) throws IOException {		
		String rutaSalida = ruta+nombreArchivo;
		System.setProperty("line.separator","\r\n");
		FileWriter fw = new FileWriter(rutaSalida);
	    BufferedWriter bw = new BufferedWriter(fw);
	    PrintWriter salida = new PrintWriter(bw);
	    String descripcion="";
	    int i=1;
	    salida.println("Fecha,"+"Punto de Control,"+"Central,"+"Descripción");
	    
		for(DeProcesoV l: lstProceso){
					
			if(l.getDescripcion()!= null){
				descripcion=l.getDescripcion();					
			}else{
				descripcion="-";
			}
			salida.println(String.valueOf(i)+","+
					new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(l.getFecha())+","+l.getPuntoDeControl()+","+l.getCentral()+","+descripcion);
			i++;
		}
	    salida.close();   
	}
	
	/**
	 * Genera el archivo de reporte en formato CSV ó TXT.
	 *  
	 * @param ruta Ruta de salida del archivo
	 * @param nombreArchivo Nombre del archivo
	 * @throws IOException Error al generar el archivo
	 * 
	 */
	public void reportarTxtCsvReportes(String ruta, String nombreArchivo, List<ReportesGeneradosV> lstReportesV, String nomPuntoControl, String nomReporte, String nomCentral, String fechaInicio, String fechaFin) throws IOException {		
		String rutaSalida = ruta+nombreArchivo;
		System.setProperty("line.separator","\r\n");
		FileWriter fw = new FileWriter(rutaSalida);
	    BufferedWriter bw = new BufferedWriter(fw);
	    PrintWriter salida = new PrintWriter(bw);
	    
	    salida.println("Reporte,"+"Punto de Control,"+(nomCentral!=null && !nomCentral.equals("") ? " Central,":"")+
	    			  (fechaInicio!=null && !fechaInicio.equals("") ? "Fecha Inicio,":"")+(fechaFin!=null && !fechaFin.equals("") ? "Fecha Fin,":""));
	    
	    salida.println(nomPuntoControl+","+nomReporte+","+(nomCentral!=null && !nomCentral.equals("") ? nomCentral+",":"")+
	    		     (fechaInicio!=null && !fechaInicio.equals("") ? fechaInicio+",":"")+(fechaFin!=null && !fechaFin.equals("") ? fechaFin+",":""));
	    
	    for(ReportesGeneradosV v: lstReportesV){
			salida.println(v.getResultado().replace("|", ",").replace("null", ""));			
	    }
	    
	    salida.close();   
	}
	
	
	
	
}
