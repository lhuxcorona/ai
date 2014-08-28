package com.maxcom.ai.action;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.JDBCException;



import com.maxcom.ai.dao.AdministracionDAO;
import com.maxcom.ai.dao.CatalogosDAO;
import com.maxcom.ai.domain.LogApp;
import com.maxcom.ai.domain.Usuarios;
import com.maxcom.ai.domain.vistas.MenuV;
import com.maxcom.ai.log.AppLogger;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*AccesoAction.
*Acciones para  los accesos al sistema "Aseguramiento de Ingresos"
*
*Versión 1.0
*
*Septiembre 2012
*
*/
@SuppressWarnings("serial")
public class AccesoAction extends ActionSupport implements SessionAware, Serializable{
	private Map<String, Object> session;
	private String  nombreUsuario;
	private String password;
	private String log;
	private Usuarios usuario;
	private AdministracionDAO aDAO = new AdministracionDAO();
	private CatalogosDAO cDAO = new CatalogosDAO();
	private List<MenuV> lstMenuV;
	
		
	/**
	 *  Acción que verifica el acceso de los usuarios y consulta el menu de acuerdo al perfil del mismo.
	 * 
	 * @throws JDBCException Si ocurre un error de base de datos al consultar el acceso de usuarios
	 * 
	 */
	public String acceso(){
		try{		
			/*Verificando el acceso del usuario*/		
			usuario = new Usuarios();
			List<Usuarios> lstUsuario = aDAO.consultaUsuarios(0,nombreUsuario, password);
			
			if(lstUsuario.size()>0){
				usuario =  lstUsuario.get(0);
			}else{
				addActionError("Los datos del usuario son incorrectos, favor de verificar ");
				//regresa a login.jsp 
				return INPUT;
			}
			//Se suben a session los datos del usuario
			session = ActionContext.getContext().getSession();
			session.put("nombreUsuario", usuario.getUsuario());
			session.put("idUsuario", usuario.getIdUsuario());
			//Consiguiendo el nombre de perfil
			session.put("perfil", aDAO.consultaPerfil(usuario.getIdPerfil()).get(0).getPerfil());
			
			//Armando el menu de opciones de acuerdo al perfil del usuario
			lstMenuV = aDAO.consultaMenuDePerfil(usuario.getIdPerfil());
			session.put("lstMenuV", lstMenuV);			
			log = "Accesó el  usuario:" +nombreUsuario;
			cDAO.guardaObjeto(new LogApp(new Date(), usuario.getIdUsuario().intValue(), log));
			AppLogger.info("app",log);
		
		}catch (JDBCException e) {
	    	AppLogger.error("errores","Ocurrió un error en el acceso debido a: "+e.getCause());
	    	addActionError("Ocurrió un error en el acceso, favor de informar al administrador ");
	    }
		
		return SUCCESS;
	}
	
	/**
	 *  Acción que destruye las variables de session del usuario
	 * 
	 * @throws IllegalStateException Si ocurre un error al destruir las variables de session del usuario
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public String salir(){	
		session = ActionContext.getContext().getSession();
		
		if( getSession().get("nombreUsuario")!=null  && session.get("idUsuario")!=null ){
			log = "El usuario "+getSession().get("nombreUsuario")+" salió del sistema ";
			AppLogger.info("app",log);
			cDAO.guardaObjeto(new LogApp(new Date(), (Integer)session.get("idUsuario"), log));
		}else{
			AppLogger.info("app","*** La sesión expiró ***");
		}
		
		if (session instanceof org.apache.struts2.dispatcher.SessionMap) {
		    try {
		        ((org.apache.struts2.dispatcher.SessionMap) session).invalidate();
		    } catch (IllegalStateException e) {
		    	AppLogger.error( "errores",""+e.getMessage() );
		    }
		}
		
		return SUCCESS;
	}
	
	
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Implementar la interfaz SessionAware, para session de usuario
	 */ 
	public void setSession(Map<String, Object> session) {
	    this.session = session;
	}
	
	public Map<String, Object> getSession() {
	    return session;
	}

	
	public List<MenuV> getLstMenuV() {
		return lstMenuV;
	}

	public void setLstMenuV(List<MenuV> lstMenuV) {
		this.lstMenuV = lstMenuV;
	}		
}
