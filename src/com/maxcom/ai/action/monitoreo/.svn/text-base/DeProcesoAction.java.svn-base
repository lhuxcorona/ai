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

import com.maxcom.ai.dao.CatalogosDAO;
import com.maxcom.ai.dao.MonitoreoDAO;
import com.maxcom.ai.domain.Centrales;
import com.maxcom.ai.domain.PuntosDeControl;
import com.maxcom.ai.domain.vistas.DeProcesoV;
import com.maxcom.ai.log.AppLogger;
import com.maxcom.ai.reportes.Txt.Cvs.ReporteTxtCsv;
import com.maxcom.reproceso.utilerias.Utilerias;
import com.opensymphony.xwork2.ActionSupport;


/**
*LogAplicacionAction.
*Acciones para las consultas de "De Proceso"
*
*Versión 1.0
*
*Octubre 2012
*
*/



@SuppressWarnings("serial")
public class DeProcesoAction extends ActionSupport implements ServletContextAware, Serializable, SessionAware{
	
	//Datos del formulario
	private Date fechaInicio;
	private String puntoDeControl;
	private String descripcion;
	private String central;
	private Integer idCentral;
	private Integer idProceso;
	private Map<String, Object> userSession;
	private ServletContext context;
	private String ext; 
	private String rutaArchivoConf;
	
	//DAO
	private MonitoreoDAO mDAO = new MonitoreoDAO();
	private CatalogosDAO cDAO = new CatalogosDAO();
	//Listas
	private List<DeProcesoV> lstDeProcesoV;
	private List<Centrales> lstCentrales;
	private List<PuntosDeControl> lstPuntosDeControl;

	private boolean bandera;	

	/**
	 * Consulta la vista De_Proceso_V
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al consultar la vista
	 * @throws Exception   Error al consultar la vista
	 */
	
	public String proceso(){
		Utilerias.getResponseISO();
		try {
			
			recuperaCatalogos();
							
		} catch (JDBCException e) {
			AppLogger.error("errores","Ocurrió un error en base de datos al recuperar el catálogo de usuarios debido a: "+e.getCause());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}				
		return SUCCESS;
	}
	

	private void recuperaCatalogos() throws Exception, JDBCException{
		lstCentrales = cDAO.consultaCentrales(0);
		lstPuntosDeControl = cDAO.consultaPC(0);
	}	
	
	/**
	 * Consulta un De Proceso por id,fecha y descripcion 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al consultar la vista De_Proceso_V
	 * @throws Exception   Error al consultar la vista De_Proceso_V
	 */
		
	public String consultarProceso(){
		Utilerias.getResponseISO();
		
		String fechaInicioS ="";
		
		try {				
			if(fechaInicio != null && !fechaInicio.equals("")){
				fechaInicioS = new SimpleDateFormat("dd-MM-yyyy").format(fechaInicio).toString();
			}
			lstDeProcesoV=mDAO.consultaDeProcesoV(fechaInicioS, idProceso.intValue(), idCentral.intValue(), descripcion);
			recuperaCatalogos();
			
			userSession.put("fechaInicioS", fechaInicioS);
			userSession.put("idProceso", idProceso);
			userSession.put("idCentral", idCentral);
			userSession.put("descripcion", descripcion);
			fechaInicio = null;	
			
			descripcion = null;
			bandera=true;
			
		} catch (JDBCException e) {
			AppLogger.error("errores","Ocurrió un error en la base de datos al cosultar de proceso debido a: "+e.getCause());
			e.printStackTrace();
		} catch (Exception e) {
			AppLogger.error("errores","Ocurrió un error inesperado al cosultar de proceso debido a: "+e.getCause());
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
	public String reportarProceso()throws Exception {
		ReporteTxtCsv reporteTxtCsv = null;
		String ruta = "/WEB-INF/reportes/";
		String nombreCsv = "";
		String fechaInicioS ="";
		
		try{
			fechaInicioS=(String) userSession.get("fechaInicioS");
			idProceso=(Integer) userSession.get("idProceso");
			idCentral=(Integer) userSession.get("idCentral");
			descripcion= (String) userSession.get("descripcion");
			/*consulta Stored procedures*/
			lstDeProcesoV=mDAO.consultaDeProcesoV(fechaInicioS, idProceso.intValue(), idCentral.intValue(), descripcion);
			
			ruta = Utilerias.separadorRuta(context.getRealPath(ruta));
			nombreCsv = new java.text.SimpleDateFormat( "MMddHHmmssSS" ).format(new Date() )+"_De_Proceso."+ext;
			reporteTxtCsv = new ReporteTxtCsv();
			reporteTxtCsv.reportarTxtCsvProceso(ruta, nombreCsv, lstDeProcesoV);
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isBandera() {
		return bandera;
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}

	public String getPuntoDeControl() {
		return puntoDeControl;
	}

	public void setPuntoDeControl(String puntoDeControl) {
		this.puntoDeControl = puntoDeControl;
	}

	public String getCentral() {
		return central;
	}

	public void setCentral(String central) {
		this.central = central;
	}

	public Integer getIdCentral() {
		return idCentral;
	}

	public void setIdCentral(Integer idCentral) {
		this.idCentral = idCentral;
	}

	public Integer getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(Integer idProceso) {
		this.idProceso = idProceso;
	}

	public void setLstDeProcesoV(List<DeProcesoV> lstDeProcesoV) {
		this.lstDeProcesoV = lstDeProcesoV;
	}

	public List<DeProcesoV> getLstDeProcesoV() {
		return lstDeProcesoV;
	}
	
	public List<Centrales> getLstCentrales() {
		return lstCentrales;
	}

	public void setLstCentrales(List<Centrales> lstCentrales) {
		this.lstCentrales = lstCentrales;
	}

	public List<PuntosDeControl> getLstPuntosDeControl() {
		return lstPuntosDeControl;
	}

	public void setLstPuntosDeControl(List<PuntosDeControl> lstPuntosDeControl) {
		this.lstPuntosDeControl = lstPuntosDeControl;
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
	
	public String getRutaArchivoConf() {
		return rutaArchivoConf;
	}
	
	public void setRutaArchivoConf(String rutaArchivoConf) {
		this.rutaArchivoConf = rutaArchivoConf;
	}
	
	
}
