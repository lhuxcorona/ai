package com.maxcom.ai.action.reproceso;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.JDBCException;
import com.maxcom.ai.dao.CatalogosDAO;
import com.maxcom.ai.domain.Centrales;
import com.maxcom.ai.domain.LogApp;
import com.maxcom.ai.log.AppLogger;
import com.maxcom.reproceso.utilerias.Utilerias;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
*ReprocesoAction
*
*Clase que ejecuta un reproceso. 
*
*Versión 1.0
*
*Septiembre 2012
*
*/
@SuppressWarnings("serial")
public class ReprocesoAction extends ActionSupport{
	private List<Centrales> lstCentrales;
	private CatalogosDAO cDAO = new CatalogosDAO();
	private Integer idCentral;
	private Map<String, Object> userSession;
	private String log;
	
	/**
	 * Recupera el catálogo de centrales para que posteriormente se ejecute un reproceso,
	 * en el módulo de "Procesos".
	 *  
	 *  
	 * @throws JDBCException Si ocurre un error al conseguir los catálogos en la base de datos 
	 * 
	 */	
	public String reproceso(){
		try {
			//recupera lista de centrales
			lstCentrales = cDAO.consultaCentrales(0);				
		} catch (JDBCException e) {
			AppLogger.error("errores","Ocurrió un error al recuperar el catálogo de centrales debido a: "+e.getCause());
			addActionError("Error al conseguir el catálogo de centrales, favor de informar al administrador del sistema");
			e.printStackTrace();
		}				
		return SUCCESS;
	}
	
	/**
	 * Ejecuta un re-proceso para una central en especifico.
	 * 
	 * @throws JDBCException Si ocurre un error al conseguir los catálogos en la base de datos  
	 * 
	 */
	public String ejecutaReproceso(){
		Utilerias.getResponseISO();
		String respuesta = "";
		try {				
			userSession = ActionContext.getContext().getSession();
			respuesta = cDAO.ejecutaReproceso(idCentral.intValue());
			if(respuesta.equals("THIS IS CORRECT !!!!!!")){
				addActionMessage("El reproceso se ejecutó satisfactoriamente");
				 log = "El usuario:" +(String) userSession.get("nombreUsuario")+ " ejecutó el reproceso para la central: "+cDAO.consultaCentrales(idCentral).get(0).getNomCentral();
				 cDAO.guardaObjeto(new LogApp(new Date(), (Integer) userSession.get("idUsuario") , log));
				 AppLogger.info("app",log);
				
			}else{
				addActionError("No fue posible realizar la operación, favor de informar al administrador del sistema");
			}
				
		} catch (JDBCException e) {
			AppLogger.error("errores","Ocurrió un error en la base de datos en el reproceso debido a: "+e.getCause());
			addActionError("Error al ejecutar el reproceso, favor de informar al administrador del sistema");
			e.printStackTrace();
		} catch (Exception e) {
			AppLogger.error("errores","Ocurrió un error inesperado en el reproceso debido a: "+e.getCause());
			addActionError("Error al ejecutar el reproceso, favor de informar al administrador del sistema");
			e.printStackTrace();
		}finally{
			try{
				lstCentrales = cDAO.consultaCentrales(0);
			}catch (JDBCException e) {
				AppLogger.error("errores","Ocurrió un error en la base de datos en el reproceso debido a: "+e.getCause());
				addActionError("Error al ejecutar el reproceso, favor de informar al administrador del sistema");
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}
	
	public List<Centrales> getLstCentrales() {
		return lstCentrales;
	}
	public void setLstCentrales(List<Centrales> lstCentrales) {
		this.lstCentrales = lstCentrales;
	}

	
	public Integer getIdCentral() {
		return idCentral;
	}
	
	public void setIdCentral(Integer idCentral) {
		this.idCentral = idCentral;
	}
	
	/* Implementar Session aware*/
	public void setSession(Map<String,Object> session) {
	    this.userSession = session;
	 }
	public Map<String,Object> getSession() {
	    return userSession;
	}	
	
}
