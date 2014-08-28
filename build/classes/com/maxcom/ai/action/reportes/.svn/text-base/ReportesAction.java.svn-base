package com.maxcom.ai.action.reportes;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.JDBCException;

import com.maxcom.ai.dao.CatalogosDAO;
import com.maxcom.ai.dao.ReportesDAO;
import com.maxcom.ai.domain.Centrales;
import com.maxcom.ai.domain.Graficas;
import com.maxcom.ai.domain.LogApp;
import com.maxcom.ai.domain.PuntosDeControl;
import com.maxcom.ai.domain.Reportes;
import com.maxcom.ai.domain.vistas.ReportesGeneradosV;
import com.maxcom.ai.domain.vistas.ReportesV;
import com.maxcom.ai.log.AppLogger;
import com.maxcom.ai.reportes.Txt.Cvs.ReporteTxtCsv;
import com.maxcom.reproceso.utilerias.Utilerias;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*ReportesAction.
*Acciones para la generación de reportes, así como ABC del catálogo de reportes.
*
*Versión 1.0
*
*Septiembre 2012
*
*/
@SuppressWarnings("serial")
public class ReportesAction extends ActionSupport implements ServletContextAware, Serializable, SessionAware{
	private List<Reportes> lstR;
	private List<ReportesGeneradosV> lstReportesGeneradosV;
	private ReportesDAO rDAO = new ReportesDAO();
	private CatalogosDAO cDAO = new CatalogosDAO();
	private List<String> lstDetalle;
	private List<String> lstEncDetalle;
	private Map<String, String> totales;
	private List<Centrales> lstCentrales;
	private List<PuntosDeControl> lstPC;
	private List<Reportes> lstReportes;
	private List<ReportesV> lstReportesV;	
	private List<Graficas> lstGraficas;
	//Datos del formulario
	private int idProceso;
	private int idCentral;
	private int idReporte;
	private Date fechaInicio;
	private Date fechaFin;
	private String nomProceso;
	private String nomCentral;
	private String nomReporte;
	private boolean bandera;	
	private boolean grafica;
	private String graficaResX;
	private String graficaResY;
	private Map<String, Object> userSession;
	private ServletContext context;	
	private String tipoGrafica;
	private Reportes reporte;
	private ReportesV reporteV;
	private String fechaInicioS ="";
	private String fechaFinS ="";
	private String ext;
	private int editar; 	
	private String sqlSelect;
	private String sqlFrom;
	private String sqlGroupBy;
	private String sqlHaving;
	private String sqlOrderBy;
	private String columnaX;
	private String columnaY;
	private String etiquetaX;
	private String etiquetaY;
	private String sqlWhere;
	private String selectedItems;
	private String log;
	private int chkGrafica;
	
	
	/**
	 * Consulta los catalogos de centrales, puntos de control, y reportes para mostrarlos en el jsp "consultaReportes.jsp" que retorna 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al consultar los catálogos
	 * @throws Exception   Error inesperado al consultar los catálogos
	 */
	public String consultarReportes(){
		try {
			recuperaCatalogos();
			
		} catch (JDBCException e) {
			addActionError("Error al recuperar los catálogos de consulta de reportes, favor de informar al administrador del sistema");
			AppLogger.error("errores","Ocurrió un error de base de datos al recuperar los catálogos de centrales y puntos de control, debido a: "+e.getCause());
			e.printStackTrace();
		} catch (Exception e) {
			addActionError("Error al recuperar los catálogos de consulta de reportes, favor de informar al administrador del sistema");
			AppLogger.error("errores", "Ocurrió un error inesperado al recuperar los catálogs de centrales y puntos de control, debido a: "+e.getCause());
			e.printStackTrace();
		}
				
		return SUCCESS;
	}
	
	/**
	 * Consulta los catalogos de centrales, puntos de control, y reportes  
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al consultar los catálogos
	 * @throws Exception   Error inesperado al consultar los catálogos
	 */
	private void recuperaCatalogos() throws JDBCException, Exception {
		lstCentrales = cDAO.consultaCentrales(0);
		lstPC = cDAO.consultaPC(0);
		lstReportes = rDAO.consultaReportes(0, "");
		
	}


	/**
	 * Realiza la consulta el reporte de acuerdo a los criterios seleccionados por el usuario que realizó  en el módulo de "consulta" 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al consultar el reporte
	 * @throws Exception   Error inesperado al consultar el reporte
	 */	
	public String generarReporte(){
		Utilerias.getResponseISO();
		String fechaInicioS = "";
		String fechaFinS = "";
		try {
			String cadena="";
			String str = "";
			lstEncDetalle = new ArrayList<String>();
			lstDetalle = new ArrayList<String>();
			/*Validación de rango de fecha*/
			if(fechaInicio !=null && !fechaInicio.equals("")){
				if(fechaFin != null && !fechaFin.equals("")){
					fechaInicioS = new SimpleDateFormat("yyyyMMdd").format(fechaInicio).toString();		
					fechaFinS = new SimpleDateFormat("yyyyMMdd").format(fechaFin).toString();
					if(Long.parseLong(fechaFinS)< Long.parseLong(fechaInicioS)){
						addActionError("La fecha inicio no puede ser mayor a la fecha final");
						return SUCCESS;
					}			
				     	
				}
			}
			totales = new HashMap<String, String>();
			StringTokenizer tokens = new StringTokenizer(cadena, "|");
			
			if(fechaInicio != null && !fechaInicio.equals("")){
				fechaInicioS = new SimpleDateFormat("dd-MM-yyyy").format(fechaInicio).toString();
			}
			if(fechaFin != null && !fechaFin.equals("")){
				fechaFinS = new SimpleDateFormat("dd-MM-yyyy").format(fechaFin).toString();
			}
			//Consigue los nombres de punto de control, reporte y central en caso de haber sido solicitada
			nomReporte = rDAO.consultaReportes(idReporte, "").get(0).getNomReporte();
			nomProceso = cDAO.consultaPC(idProceso).get(0).getNomProceso();
			if(idCentral !=-1){
				nomCentral = cDAO.consultaCentrales(idCentral).get(0).getNomCentral();
			}
			
			//Consulta el reporte de acuerdo a los criterios seleccionados por el usuario	
			lstReportesGeneradosV = rDAO.consultaReportesV(idProceso, idCentral,  fechaInicioS, fechaFinS, idReporte);
			
			if(lstReportesGeneradosV.size()>0){// si hubo resultados		
				for(ReportesGeneradosV v:lstReportesGeneradosV){
					tokens = new StringTokenizer(v.getResultado(), "|");
					if(v.getTipoRegistro()== 1){
						while(tokens.hasMoreTokens()){
							lstEncDetalle.add(tokens.nextToken());
						}
					}				
					if(v.getTipoRegistro()== 2){	//si el tipo de registro es detalle del reporte				 
				        while(tokens.hasMoreTokens()){
				            str = tokens.nextToken();
				            if(str.contains("null")){
				            	str="";
				            }
							lstDetalle.add(str);
						}	
				       //verificar si el reporte debe mostrar grafica
				        if(!bandera ){
					        if((v.getxGraficaResultado()!=null && !v.getxGraficaResultado().equals(""))&& (v.getyGraficaResultado()!=null && !v.getyGraficaResultado().equals(""))){
					        	bandera = true; //si un registro tiene los valores de los resultados de x,y, se activara la bandera para no consultar cada vez que iteramos
					        	//ir por las etiquetas de la configuracion del reporte
					        	lstReportes = rDAO.consultaReportes(idReporte, "");
					        	if(lstReportes.size()>0){
					        		grafica = true;
					        	}
					        	
					        }
					        
				        }
				        
					}
					
				}
				//guarda en bitácora que el usuario [usuario_id] generó un reporte
				log = "El  usuario:" +(String) userSession.get("nombreUsuario")+" generó el reporte: "+lstReportesGeneradosV.get(0).getNomReporte()+
					  " para el punto de control " +lstReportesGeneradosV.get(0).getNomProceso();
				cDAO.guardaObjeto(new LogApp(new Date(), (Integer) userSession.get("idUsuario") , log));
				AppLogger.info("app",log);
			}
			bandera = true;
			//subir a session los criterios que el usuario selecciono.
			userSession.put("fechaInicioS", fechaInicioS);
			userSession.put("fechaFinS", fechaFinS);
			userSession.put("idProceso", idProceso);
			userSession.put("idCentral", idCentral);
			userSession.put("idReporte", idReporte);
			
			// 
			
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Ocurrió un error inesperado al generar reporte, favor de informar al administrador del sistema");
			AppLogger.error("errores","Ocurrió un error inesperado al generar reporte, debido a: "+e.getCause());
		}finally{
			try {
				recuperaCatalogos(); //carga de nuevo los catálogos de centrales, puntos de control y reportes
			} catch (JDBCException e) {
				addActionError("Ocurrió un error de base de datos al recuperar los catálogos de centrales y punto de control, favor de informar al administrador del sistema");
				AppLogger.error("errores","Ocurrió un error de base de datos al recuperar los catálogos de centrales y puntos de control, debido a: "+e.getCause());
				e.printStackTrace();
			} catch (Exception e) {
				addActionError("Ocurrió un error inesperado al recuperar los catálogos de centrales y puntos de control, favor de informar al administrador del sistema");
				AppLogger.error("errores", "Ocurrió un error inesperado al recuperar los catálogs de centrales y puntos de control, debido a: "+e.getCause());
				e.printStackTrace();
			}
		}
				
		return SUCCESS;
	}

	/**
	 * Genera los datos para graficar el reporte con los criterios seleccionados por el usuario 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al consultar el reporte
	 * @throws Exception   Error inesperado al consultar el reporte
	 */	
	public String generarGrafica(){
		Utilerias.getResponseISO();
		try {
			recuperaDatosSession();			
			//Consulta el reporte de acuerdo a los criterios seleccionados por el usuario	
			lstReportesGeneradosV = rDAO.consultaReportesV(idProceso, idCentral, fechaInicioS, fechaFinS, idReporte);
			lstGraficas = new ArrayList<Graficas>();
			for(ReportesGeneradosV v: lstReportesGeneradosV){
				if(v.getTipoRegistro() == 2){
					if((v.getxGraficaResultado()!=null && !v.getxGraficaResultado().equals("")) && (v.getyGraficaResultado()!= null && !v.getyGraficaResultado().equals(""))){
						lstGraficas.add(new Graficas(v.getxGraficaResultado(), v.getyGraficaResultado()));
					}
				}
			}
			//Recuperando datos del reporte
			reporte = rDAO.consultaReportes(lstReportesGeneradosV.get(0).getIdReporte(), "").get(0);	
			etiquetaX = reporte.getEtiquetaX();
			etiquetaY = reporte.getEtiquetaY();
			
		} catch (JDBCException e) {
			addActionError("Ocurrió un error de base de datos al generar la gráfica, favor de informar al administrador del sistema");
			AppLogger.error("errores", "Ocurrió un error de base de datos al generar la gráfica, debido a: "+e.getCause());
			e.printStackTrace();
		}catch (Exception e) {
			addActionError("Ocurrió un error inesperado al generar la gráfica, favor de informar al administrador del sistema");
			AppLogger.error("errores", "Ocurrió un error inesperado al generar la gráfica, debido a: "+e.getCause());
			e.printStackTrace();
		}
				
		return SUCCESS;
	}
	
	/**
	 * Genera archivo en formato txt o csv del reporte generado por el usuario. 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al generar el archivo
	 * @throws Exception   Error inesperado en la generación del archivo
	 */	
	public String generarReporteTxtCsv() throws Exception{
		Utilerias.getResponseISO();
		String nombreCsvTxt = "";
		ReporteTxtCsv reporteTxtCsv = null;
		String ruta = "/WEB-INF/reportes/";
		try{
			recuperaDatosSession();
			//Consulta el reporte de acuerdo a los criterios seleccionados por el usuario	
			lstReportesGeneradosV = rDAO.consultaReportesV(idProceso, idCentral, fechaInicioS, fechaFinS, idReporte);
			//Recuperando los nombres de punto de control, reporte y central en caso de haber sido solicitada
			nomReporte = rDAO.consultaReportes(lstReportesGeneradosV.get(0).getIdReporte(), "").get(0).getNomReporte();
			nomProceso = cDAO.consultaPC(idProceso).get(0).getNomProceso();
			if(idCentral !=-1){
				nomCentral = cDAO.consultaCentrales(idCentral).get(0).getNomCentral();
			}
			
			ruta = Utilerias.separadorRuta(context.getRealPath(ruta));
			nombreCsvTxt = new java.text.SimpleDateFormat( "MMddHHmmssSS" ).format(new Date() )+"_rep."+ext;
			reporteTxtCsv = new ReporteTxtCsv();
			reporteTxtCsv.reportarTxtCsvReportes(ruta, nombreCsvTxt, lstReportesGeneradosV, nomReporte, nomProceso, nomCentral, fechaInicioS, fechaFinS);
			Utilerias.devolverArchivo(ruta, nombreCsvTxt, ext);		
			
		}catch(IOException e) {
			addActionError("Error al generar el archivo en formato "+ext+", favor de informar al administrador del sistema");
			AppLogger.error("errores","Ocurrió un error al crear el archivo cvs o txt debido a: "+e.getCause());
			e.printStackTrace();
		}catch(Exception e){
			addActionError("Error al generar el archivo en formato "+ext+", favor de informar al administrador del sistema");
			AppLogger.error("errores","Ocurrió un error inesperado al crear el archivo cvs o txt debido a: "+e.getCause());
			e.printStackTrace();
		} 
		return SUCCESS;
	}
	
	/**
	 * Recupera los datos de la session del usuario 
	 *  
	 */	
	public void recuperaDatosSession(){
		//Recuperando los criterios seleccionados por el usuario
		fechaInicioS = (String) userSession.get("fechaInicioS");
		fechaFinS = (String) userSession.get("fechaFinS");
		idProceso = (Integer) userSession.get("idProceso");
		idCentral = (Integer) userSession.get("idCentral");
		idReporte = (Integer) userSession.get("idReporte");
	}
		
	/**
	 * Recupera los catálogos de reportes y de puntos de control que se muestran en el formulario de captura de reportes 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al recuperar los catálogos de reportes y puntos de control 
	 * @throws Exception   Error inesperado al recuperar los catálogos de reportes y puntos de control
	 */	
	public String reportes(){
		try {
			
			recuperaCatalogosReportes();
			chkGrafica = -2;
			
		} catch (JDBCException e) {
			addActionError("Error al recuperar los catálogos de reportes, favor de informar al administrador del sistema");
			AppLogger.error("errores","Ocurrió un error al recuperar los catálogos de reportes y puntos de control en base de datos debido a: "+e.getCause());
			e.printStackTrace();
		} catch (Exception e) {
			addActionError("Error al recuperar los catálogos de reportes, favor de informar al administrador del sistema");
			AppLogger.error("errores","Ocurrió un error inesperado al recuperar los catálogos de reportes y puntos de control debido a: "+e.getCause());
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	/**
	 * Agrega ó edita un reporte. 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al agregar o editar un reporte 
	 * @throws Exception   Error inesperado al agregar o editar  un reporte
	 */	
	public String agregarEditarReporte(){
		Reportes reporteAnterior = null;
		Utilerias.getResponseISO();
		try{
			userSession = ActionContext.getContext().getSession();
			//Validar query en la base de datos, de acuerdo a los campos de referencia capturados
			StringBuilder query  = new StringBuilder();
			query.append("SELECT ").append(sqlSelect).append(" FROM ").append(sqlFrom);
			if(sqlWhere!=null && !sqlWhere.equals("")){
				query.append(" WHERE ").append(sqlWhere).append(" and rownum = 1");
			}else{
				query.append(" WHERE rownum = 1 ");
			}			
			if(sqlGroupBy != null && !sqlGroupBy.equals("")){
				query.append(" GROUP BY").append(" ").append(sqlGroupBy);
			}
			
			if(sqlHaving != null && !sqlHaving.equals("")){
				query.append(" HAVING ").append(sqlHaving);
			}
			if(sqlOrderBy != null && !sqlOrderBy.equals("")){
				query.append(" ORDER BY ").append(sqlOrderBy);
			}
			
			if(editar == 1){
				reporte = rDAO.consultaReportes(idReporte, "").get(0);
				reporteAnterior = new Reportes(reporte);
			}else{
				reporte = new Reportes();
			}
						
			reporte.setColumnaX(columnaX);
			reporte.setColumnaY(columnaY);
			reporte.setEtiquetaX(etiquetaX);
			reporte.setEtiquetaY(etiquetaY);
			reporte.setIdProceso(idProceso);
			reporte.setNomReporte(nomReporte);
			reporte.setSqlFrom(sqlFrom);
			reporte.setSqlGroupBy(sqlGroupBy);
			reporte.setSqlHaving(sqlHaving);
			reporte.setSqlOrderBy(sqlOrderBy);
			reporte.setSqlSelect(sqlSelect);
			reporte.setSqlWhere(sqlWhere);
			
			try{
				//Verifica consulta de los datos capturados por el usuario
				cDAO.consultaEnCrudo(query.toString());	
			}catch (JDBCException e) {
				if(reporte.getColumnaX()!=null && !reporte.getColumnaX().equals("")){
					chkGrafica = -1;
				}else{
					chkGrafica = -2;
				}
				addActionError("No fue posible ejecutar la consulta, intente nuevamente");
				return SUCCESS;
			}
			
			cDAO.guardaObjeto(reporte);
			
			addActionMessage(editar == 1?"El reporte se actualizó satisfactoriamente":"El reporte se registró satisfactoriamente");
			
			
			chkGrafica = -2;
			if(editar==1){	  
				  log = "El usuario:" +(String) userSession.get("nombreUsuario")+ " actualizó el reporte: "+reporteAnterior.toString()+" por los datos: " + reporte.toString();
				  AppLogger.info("app",log);
				  cDAO.guardaObjeto(new LogApp(new Date(), (Integer) userSession.get("idUsuario") , log.length()> 500 ? log.substring(1, 500): log));
			}else{
				  log = "El usuario:" +(String) userSession.get("nombreUsuario")+ " registró el reporte: "+nomReporte;
				  AppLogger.info("app",log);
				  cDAO.guardaObjeto(new LogApp(new Date(), (Integer) userSession.get("idUsuario") , log.length()> 500 ? log.substring(1, 500): log));
			}
			reporte = new Reportes();
			editar = 0;
		}catch (JDBCException e) {
			if(e.getErrorCode() == 1){
				addActionError("El nombre del reporte ya se encuentra registrado");
				if(reporte.getColumnaX()!=null && !reporte.getColumnaX().equals("")){
					chkGrafica = -1;
				}else{
					chkGrafica = -2;
				}
			}else{
				AppLogger.error("errores","Ocurrió un error al agregar ó editar el reporte debido a: "+e.getCause());
				addActionError("Ocurrió un error al agregar o editar el reporte. Favor de informar al administrador del sistema");
			}
			
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			AppLogger.error("errores","Ocurrió un error inesperado al agregar ó editar el reporte debido a: "+e.getCause());
			addActionError("Ocurrió un error inesperado al agregar o editar el reporte. Favor de informar al administrador del sistema");
		}finally{
			try{
				recuperaCatalogosReportes();
			}catch (JDBCException e) {
				addActionError("Error al recuperar los catálogos de reportes, favor de informar al administrador del sistema");
				AppLogger.error("errores","Ocurrió un error al recuperar los catálogos de reportes y puntos de control en base de datos debido a: "+e.getCause());
				e.printStackTrace();
			} catch (Exception e) {
				addActionError("Error al recuperar los catálogos de reportes, favor de informar al administrador del sistema");
				AppLogger.error("errores","Ocurrió un error inesperado al recuperar los catálogos de reportes y puntos de control debido a: "+e.getCause());
				e.printStackTrace();
			}
		}
		
		return SUCCESS;
	}
	
	/**
	 * Recupera los catalogos de reportes y de puntos de control
	 *
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al conseguir los catálogos
	 * @throws Exception Si ocurre un error inesperado al conseguir los catálogos
	 */
	private void recuperaCatalogosReportes() throws JDBCException, Exception {
		
		lstReportesV = rDAO.consultaReportesV(0,"");
		lstPC = cDAO.consultaPC(0);
		
	}
	
	
	/**
	 * Consigue los datos del reporte por el idReporte
	 *
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al conseguir los datos del reporte
	 * @throws Exception Si ocurre un error inesperado al conseguir los datos del reporte
	 */
	public String datosReporte(){
		try {
			Utilerias.getResponseISO();
			// Consigue los datos del reporte a tráves de su id
			reporte = rDAO.consultaReportes(idReporte, "").get(0);
			if((reporte.getColumnaX() != null && !reporte.getColumnaX().equals("") &&
					(reporte.getColumnaY() != null && !reporte.getColumnaY().equals("")) &&
					(reporte.getEtiquetaX() != null && !reporte.getEtiquetaX().equals("")) &&
					(reporte.getEtiquetaY() != null && !reporte.getEtiquetaY().equals("")))){
				chkGrafica = -1;
			}else{
				chkGrafica = -2;
			}
			
			lstPC = cDAO.consultaPC(0);
			
		
		} catch (JDBCException e) {
			AppLogger.error("errores","Ocurrió un error al recuperar los datos del reporte en la base de datos, debido a: "+e.getCause());
			addActionError("Error al recuperar los datos del reporte, favor de informar al administrador del sistema");
			e.printStackTrace();
		} catch (Exception e) {
			AppLogger.error("errores","Ocurrió un error inesperado al recuperar los datos del reporte, debido a: "+e.getCause());
			addActionError("Error al recuperar los datos del reporte, favor de informar al administrador del sistema");
			e.printStackTrace();
		}

		return SUCCESS;
	}
	
	/**
	 * Elimina uno o varios reportes
	 *
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al eliminar los reportes
	 * @throws Exception Si ocurre un error inesperado al eliminar los reportes
	 */
	public String eliminarReporte() throws JDBCException, Exception{
		Utilerias.getResponseISO();
		String idReporte = "";
		try {
			
			System.out.println("Select Items"+selectedItems);
			StringTokenizer tokens = new StringTokenizer(selectedItems, ",");		
			 while(tokens.hasMoreTokens()){
				 idReporte = tokens.nextToken();  
		            if(!idReporte.equals("-1") && !idReporte.equals("-2")){
		            	// Consigue el reporte de acuerdo al idReporte
						reporte = rDAO.consultaReportes(Integer.valueOf(idReporte), "").get(0);
						nomReporte = reporte.getNomReporte();
						try{
							cDAO.borrarObjeto(reporte);
							addActionError("Se eliminó reporte: [Nombre del Reporte]");
							log = "El usuario:" +(String) userSession.get("nombreUsuario")+ " eliminó el reporte: "+nomReporte;
							cDAO.guardaObjeto(new LogApp(new Date(), (Integer) userSession.get("idUsuario") , log));
							AppLogger.info("app",log);
						}catch (JDBCException e) {
							addActionError("No se pudo borrar el reporte: "+nomReporte);
							AppLogger.error("errores","Ocurrió un error al borrar el reporte debido a:"+e.getCause());
							e.printStackTrace();
						}
		            }
		            
			 }	

		} catch (Exception e) {
			AppLogger.error("errores","Ocurrió un error al intentar borrar el reporte, debido a:"+e.getCause());
			addActionError("No se pudo borrar el reporte");
			e.printStackTrace();
		}finally{
			lstReportesV = rDAO.consultaReportesV(0,"");
		}			
		return SUCCESS;
	}
	
	/**
	 * Recupera el detalle de un reporte por el idReporte
	 *
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al recuperar el reporte
	 * @throws Exception Si ocurre un error inesperado al recuperar el reporte
	 */	
	public String detalleReporte() {
		try {
			
			reporteV = rDAO.consultaReportesV(idReporte,"").get(0);
			if((reporteV.getColumnaX() != null && !reporteV.getColumnaX().equals("") &&
					(reporteV.getColumnaY() != null && !reporteV.getColumnaY().equals("")) &&
					(reporteV.getEtiquetaX() != null && !reporteV.getEtiquetaX().equals("")) &&
					(reporteV.getEtiquetaY() != null && !reporteV.getEtiquetaY().equals("")))){
				chkGrafica = -1;
			}else{
				chkGrafica = -2;
			}
			
		} catch (JDBCException e) {
			AppLogger.error("errores","Ocurrió un error de base de datos al consultar del detalle de reporte, debido a:"+e.getCause());
			addActionError("No se fue posible recuperar el reporte");
			e.printStackTrace();
		} catch (Exception e) {
			AppLogger.error("errores","Ocurrió un error inesperado al consultar del detalle de reporte, debido a:"+e.getCause());
			addActionError("No se fue posible recuperar el reporte");
			e.printStackTrace();
		}
		return SUCCESS;
		
	}
	
	public List<Reportes> getLstR() {
		return lstR;
	}

	public void setLstR(List<Reportes> lstR) {
		this.lstR = lstR;
	}

	public List<ReportesGeneradosV> getLstReportesGeneradosV() {
		return lstReportesGeneradosV;
	}

	public void setLstReportesGeneradosV(
			List<ReportesGeneradosV> lstReportesGeneradosV) {
		this.lstReportesGeneradosV = lstReportesGeneradosV;
	}

	public List<String> getLstDetalle() {
		return lstDetalle;
	}

	public void setLstDetalle(List<String> lstDetalle) {
		this.lstDetalle = lstDetalle;
	}

	public List<String> getLstEncDetalle() {
		return lstEncDetalle;
	}

	public void setLstEncDetalle(List<String> lstEncDetalle) {
		this.lstEncDetalle = lstEncDetalle;
	}
	
	public Map<String, String> getTotales() {
		return totales;
	}
	
	public void setTotales(Map<String, String> totales) {
		this.totales = totales;
	}

	public List<Centrales> getLstCentrales() {
		return lstCentrales;
	}
	
	public void setLstCentrales(List<Centrales> lstCentrales) {
		this.lstCentrales = lstCentrales;
	}

	public List<PuntosDeControl> getLstPC() {
		return lstPC;
	}

	public void setLstPC(List<PuntosDeControl> lstPC) {
		this.lstPC = lstPC;
	}

	public List<Reportes> getLstReportes() {
		return lstReportes;
	}

	public void setLstReportes(List<Reportes> lstReportes) {
		this.lstReportes = lstReportes;
	}
	
	public List<Graficas> getLstGraficas() {
		return lstGraficas;
	}

	public void setLstGraficas(List<Graficas> lstGraficas) {
		this.lstGraficas = lstGraficas;
	}

	public int getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}

	public int getIdCentral() {
		return idCentral;
	}

	public void setIdCentral(int idCentral) {
		this.idCentral = idCentral;
	}

	public int getIdReporte() {
		return idReporte;
	}

	public void setIdReporte(int idReporte) {
		this.idReporte = idReporte;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isBandera() {
		return bandera;
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}

	public boolean isGrafica() {
		return grafica;
	}

	public void setGrafica(boolean grafica) {
		this.grafica = grafica;
	}

	public String getGraficaResX() {
		return graficaResX;
	}

	public void setGraficaResX(String graficaResX) {
		this.graficaResX = graficaResX;
	}

	public String getGraficaResY() {
		return graficaResY;
	}

	public void setGraficaResY(String graficaResY) {
		this.graficaResY = graficaResY;
	}	
	/* Implementar Session aware*/
	public void setSession(Map<String,Object> session) {
	    this.userSession = session;
	 }
	public Map<String,Object> getSession() {
	    return userSession;
	}
	public String getNomProceso() {
		return nomProceso;
	}

	public void setNomProceso(String nomProceso) {
		this.nomProceso = nomProceso;
	}

	public String getNomCentral() {
		return nomCentral;
	}

	public void setNomCentral(String nomCentral) {
		this.nomCentral = nomCentral;
	}

	public String getNomReporte() {
		return nomReporte;
	}

	public void setNomReporte(String nomReporte) {
		this.nomReporte = nomReporte;
	}

	/* Implementar ServletContextAware */
	public void setServletContext(ServletContext context) {
		this.context = context;
	}

	public String getTipoGrafica() {
		return tipoGrafica;
	}

	public void setTipoGrafica(String tipoGrafica) {
		this.tipoGrafica = tipoGrafica;
	}

	public Reportes getReporte() {
		return reporte;
	}

	public void setReporte(Reportes reporte) {
		this.reporte = reporte;
	}

	public String getEtiquetaX() {
		return etiquetaX;
	}

	public void setEtiquetaX(String etiquetaX) throws UnsupportedEncodingException {
		this.etiquetaX = Utilerias.convertirISO88591aUTF8(etiquetaX);
	}

	public String getEtiquetaY() {
		return etiquetaY;
	}

	public void setEtiquetaY(String etiquetaY) throws UnsupportedEncodingException {
		this.etiquetaY = Utilerias.convertirISO88591aUTF8(etiquetaY);
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public List<ReportesV> getLstReportesV() {
		return lstReportesV;
	}

	public void setLstReportesV(List<ReportesV> lstReportesV) {
		this.lstReportesV = lstReportesV;
	}

	public int getEditar() {
		return editar;
	}

	public void setEditar(int editar) {
		this.editar = editar;
	}

	public ServletContext getContext() {
		return context;
	}

	public void setContext(ServletContext context) {
		this.context = context;
	}

	public String getSqlSelect() {
		return sqlSelect;
	}

	public void setSqlSelect(String sqlSelect) {
		this.sqlSelect = sqlSelect;
	}

	public String getSqlFrom() {
		return sqlFrom;
	}

	public void setSqlFrom(String sqlFrom) {
		this.sqlFrom = sqlFrom;
	}

	public String getSqlGroupBy() {
		return sqlGroupBy;
	}

	public void setSqlGroupBy(String sqlGroupBy) {
		this.sqlGroupBy = sqlGroupBy;
	}

	public String getSqlHaving() {
		return sqlHaving;
	}

	public void setSqlHaving(String sqlHaving) {
		this.sqlHaving = sqlHaving;
	}

	public String getSqlOrderBy() {
		return sqlOrderBy;
	}

	public void setSqlOrderBy(String sqlOrderBy) {
		this.sqlOrderBy = sqlOrderBy;
	}
	
	public String getSqlWhere() {
		return sqlWhere;
	}

	public void setSqlWhere(String sqlWhere) {
		this.sqlWhere = sqlWhere;
	}

	public String getColumnaX() {
		return columnaX;
	}

	public void setColumnaX(String columnaX) {
		this.columnaX = columnaX;
	}

	public String getColumnaY() {
		return columnaY;
	}

	public void setColumnaY(String columnaY) {
		this.columnaY = columnaY;
	}

	public String getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(String selectedItems) {
		this.selectedItems = selectedItems;
	}

	public int getChkGrafica() {
		return chkGrafica;
	}

	public void setChkGrafica(int chkGrafica) {
		this.chkGrafica = chkGrafica;
	}

	public ReportesV getReporteV() {
		return reporteV;
	}

	public void setReporteV(ReportesV reporteV) {
		this.reporteV = reporteV;
	}
	
}
