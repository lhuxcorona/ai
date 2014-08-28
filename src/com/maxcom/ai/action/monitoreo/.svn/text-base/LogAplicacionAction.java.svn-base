package com.maxcom.ai.action.monitoreo;



import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import org.hibernate.JDBCException;

import com.maxcom.ai.dao.AdministracionDAO;
import com.maxcom.ai.dao.MonitoreoDAO;
import com.maxcom.ai.domain.vistas.LogAppV;
import com.maxcom.ai.domain.vistas.UsuariosV;
import com.maxcom.ai.log.AppLogger;
import com.maxcom.ai.reportes.Txt.Cvs.ReporteTxtCsv;
import com.maxcom.reproceso.utilerias.Utilerias;
import com.opensymphony.xwork2.ActionSupport;



/**
*LogAplicacionAction.
*Acciones para las consultas de  "Log de Aplicacion"
*
*Versión 1.0
*
*Octubre 2012
*
*/



@SuppressWarnings("serial")
public class LogAplicacionAction extends ActionSupport implements ServletContextAware, Serializable, SessionAware{
	
	//Datos del formulario
	private Date fechaInicio;
	private Date fechaFin;
	private String nombreUsuario;
	private String descripcion;
	private String completa;
	private Integer idUsuario;
	private Map<String, Object> userSession;
	private ServletContext context;
	private String ext; 
	private String rutaArchivoConf;
	//DAO
	private MonitoreoDAO mDAO = new MonitoreoDAO();
	private AdministracionDAO aDAO = new AdministracionDAO();
	//Listas
	private List<LogAppV> lstLogAppV;
	private List<UsuariosV> lstUsuariosV;
	private boolean bandera;	

	/**
	 * Consulta la vista Log_App_V
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al consultar la vista
	 * @throws Exception   Error al consultar la vista
	 */
	public String logs(){
		Utilerias.getResponseISO();
		try {
			
			recuperaCatalogos();
							
		} catch (JDBCException e) {
			AppLogger.error("errores","Ocurrió un error en base de datos al recuperar el catálogo de usuarios debido a: "+e.getCause());
			e.printStackTrace();
		}				
		return SUCCESS;
	}
	//Recupera catalogo de la lista
	private void recuperaCatalogos() throws JDBCException{
		lstUsuariosV = aDAO.consultaUsuariosV(0);
	}	
	/**
	 * Consulta un Log por id,fecha y descripcion 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al consultar la vista Log_App_V
	 * @throws Exception   Error al consultar la vista Log_App_V
	 */
	public String consultarLog(){
		Utilerias.getResponseISO();
		String fechaInicioS ="";
		String fechaFinS ="";
		try {				
			if(fechaInicio != null && !fechaInicio.equals("")){
				fechaInicioS = new SimpleDateFormat("dd-MM-yyyy").format(fechaInicio).toString();
			}
			if(fechaFin != null && !fechaFin.equals("")){
				fechaFinS = new SimpleDateFormat("dd-MM-yyyy").format(fechaFin).toString();
			}
			lstLogAppV=mDAO.consultaLogApp(fechaInicioS, fechaFinS, idUsuario.intValue(), descripcion);
			recuperaCatalogos();
						
			userSession.put("fechaInicioS", fechaInicioS);
			userSession.put("fechaFinS", fechaFinS);
			userSession.put("idUsuario", idUsuario);
			userSession.put("descripcion", descripcion);
			fechaInicio = null;	
			fechaFin = null;
			descripcion = null;
			bandera=true;
			
			
			
		} catch (JDBCException e) {
			AppLogger.error("errores","Ocurrió un error en la base de datos al cosultar el log debido a: "+e.getCause());
			e.printStackTrace();
		} catch (Exception e) {
			AppLogger.error("errores","Ocurrió un error inesperado al cosultar el log debido a: "+e.getCause());
			e.printStackTrace();
		}				
		return SUCCESS;
	}

		
	/**
	 * Exporta la información de logs en formato CSV ó TXT, dependiendo de la selección de exportación del usuario
	 *  
	 * @throws IOException Si ocurre un error al generar el archivo CSV ó TXT
	 * @throws NullPointerException Si no es posible recuperar los valores de la sesion de usuario
	 */
	public String reportarLog()throws Exception {
		ReporteTxtCsv reporteTxtCsv = null;
		String ruta = "/WEB-INF/reportes/";
		String nombreCsv = "";
		String fechaInicioS ="";
		String fechaFinS ="";

		try{
			fechaInicioS=(String) userSession.get("fechaInicioS");
			fechaFinS=(String) userSession.get("fechaFinS");
			idUsuario=(Integer) userSession.get("idUsuario");
			
			descripcion= (String) userSession.get("descripcion");
			/*consulta Stored procedures*/
			lstLogAppV=mDAO.consultaLogApp(fechaInicioS, fechaFinS, idUsuario.intValue(), descripcion);
			
			ruta = Utilerias.separadorRuta(context.getRealPath(ruta));
			nombreCsv = new java.text.SimpleDateFormat( "MMddHHmmssSS" ).format(new Date() )+"_log_app."+ext;
			reporteTxtCsv = new ReporteTxtCsv();
			reporteTxtCsv.reportarTxtCsvLogs(ruta, nombreCsv, lstLogAppV);
			Utilerias.devolverArchivo(ruta, nombreCsv, ext);		
		}catch (IOException e) {
			addActionError(e.getMessage());
			AppLogger.error("errores","Ocurrió un error al crear el archivo cvs o txt debido a: "+e.getCause());
			e.printStackTrace();
		}catch(NullPointerException e){
			addActionError(e.getMessage());
			AppLogger.error("errores","Ocurrió un error al crear el archivo cvs o txt debido a: "+e.getCause());
			e.printStackTrace();
		}
		return SUCCESS;
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

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<LogAppV> getLstLogAppV() {
		return lstLogAppV;
	}

	public void setLstLogAppV(List<LogAppV> lstLogAppV) {
		this.lstLogAppV = lstLogAppV;
	}

	public boolean isBandera() {
		return bandera;
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}

	public String getCompleta() {
		return completa;
	}

	public void setCompleta(String completa) {
		this.completa = completa;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<UsuariosV> getLstUsuariosV() {
		return lstUsuariosV;
	}

	public void setLstUsuariosV(List<UsuariosV> lstUsuariosV) {
		this.lstUsuariosV = lstUsuariosV;
	}
	
	
	public String getRutaArchivoConf() {
		return rutaArchivoConf;
	}
	
	public void setRutaArchivoConf(String rutaArchivoConf) {
		this.rutaArchivoConf = rutaArchivoConf;
	}
	
	/* Implementar Session aware*/
	public void setSession(Map<String,Object> session) {
	    this.userSession = session;
	 }
	public Map<String,Object> getSession() {
	    return userSession;
	}
	/* Implementar ServletContextAware */
	public void setServletContext(ServletContext context) {
		this.context = context;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	
}
