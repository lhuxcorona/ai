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
*Versi�n 1.0
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
	 * Recupera el cat�logo de centrales para que posteriormente se ejecute un reproceso,
	 * en el m�dulo de "Procesos".
	 *  
	 *  
	 * @throws JDBCException Si ocurre un error al conseguir los cat�logos en la base de datos 
	 * 
	 */	
	public String reproceso(){
		try {
			//recupera lista de centrales
			lstCentrales = cDAO.consultaCentrales(0);				
		} catch (JDBCException e) {
			AppLogger.error("errores","Ocurri� un error al recuperar el cat�logo de centrales debido a: "+e.getCause());
			addActionError("Error al conseguir el cat�logo de centrales, favor de informar al administrador del sistema");
			e.printStackTrace();
		}				
		return SUCCESS;
	}
	
	/**
	 * Ejecuta un re-proceso para una central en especifico.
	 * 
	 * @throws JDBCException Si ocurre un error al conseguir los cat�logos en la base de datos  
	 * 
	 */
	public String ejecutaReproceso(){
		Utilerias.getResponseISO();
		String respuesta = "";
		try {				
			userSession = ActionContext.getContext().getSession();
			respuesta = cDAO.ejecutaReproceso(idCentral.intValue());
			if(respuesta.equals("THIS IS CORRECT !!!!!!")){
				addActionMessage("El reproceso se ejecut� satisfactoriamente");
				 log = "El usuario:" +(String) userSession.get("nombreUsuario")+ " ejecut� el reproceso para la central: "+cDAO.consultaCentrales(idCentral).get(0).getNomCentral();
				 cDAO.guardaObjeto(new LogApp(new Date(), (Integer) userSession.get("idUsuario") , log));
				 AppLogger.info("app",log);
				
			}else{
				addActionError("No fue posible realizar la operaci�n, favor de informar al administrador del sistema");
			}
				
		} catch (JDBCException e) {
			AppLogger.error("errores","Ocurri� un error en la base de datos en el reproceso debido a: "+e.getCause());
			addActionError("Error al ejecutar el reproceso, favor de informar al administrador del sistema");
			e.printStackTrace();
		} catch (Exception e) {
			AppLogger.error("errores","Ocurri� un error inesperado en el reproceso debido a: "+e.getCause());
			addActionError("Error al ejecutar el reproceso, favor de informar al administrador del sistema");
			e.printStackTrace();
		}finally{
			try{
				lstCentrales = cDAO.consultaCentrales(0);
			}catch (JDBCException e) {
				AppLogger.error("errores","Ocurri� un error en la base de datos en el reproceso debido a: "+e.getCause());
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
