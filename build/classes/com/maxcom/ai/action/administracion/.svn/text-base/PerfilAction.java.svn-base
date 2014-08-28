package com.maxcom.ai.action.administracion;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import javax.transaction.Transaction;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.maxcom.ai.dao.AdministracionDAO;
import com.maxcom.ai.dao.CatalogosDAO;
import com.maxcom.ai.domain.LogApp;
import com.maxcom.ai.domain.Menu;
import com.maxcom.ai.domain.Perfiles;
import com.maxcom.ai.domain.vistas.MenuV;
import com.maxcom.ai.log.AppLogger;
import com.maxcom.reproceso.utilerias.Utilerias;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*PerfilAction
*
*Clase que registra, edita y elimina un perfil. 
*
*Versión 1.0
*
*Septiembre 2012
*
*/
@SuppressWarnings("serial")
public class PerfilAction extends ActionSupport{
	
	private AdministracionDAO aDAO = new AdministracionDAO();
	private CatalogosDAO cDAO = new CatalogosDAO();
	private List<MenuV> lstMenuV;
	private List<MenuV> lstMenuVEdit;
	private List<Perfiles> lstPerfiles;
	private Map<String, Object> userSession;
	private Perfiles perfil;
	//datos del formulario
	private int editar;
	private int idPerfil;
	private String nombrePerfil;
	private String descripcion;
	private String selectedItems;
	
	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;
	private String log;
	
	/**
	 * Recupera los catálogos de perfiles y los módulos de la aplicación para ser
	 * mostrados en la vista del módulo de "Administración-Perfiles" 
	 *  
	 * @throws JDBCException Si ocurre un error al conseguir los catálogos en la base de datos 
	 * 
	 */
	public String perfiles(){
		try {
			recuperaCatalogos();
		} catch (JDBCException e) {
			addActionError("Error al conseguir el catálogo de perfiles");
			AppLogger.error("errores","Error al conseguir los catálogos de perfiles y módulos de la aplicación, debido a: "+e.getCause());
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	/**
	 * Recupera los catálogos de perfiles y los módulos de la aplicación en la base de datos 
	 *  
	 * @throws JDBCException Si ocurre un error al conseguir los catálogos en la base de datos 
	 * 
	 */
	private void recuperaCatalogos() throws JDBCException {
		lstMenuV = aDAO.consultaMenuV(0);
		lstPerfiles = aDAO.consultaPerfil(0);
	}
	
	/**
	 * Actualiza o agrega un perfil 
	 *  
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al actualizar o agregar un perfil
	 */
	public String agregarEditarPerfil(){
		String idMenu = "";
		Perfiles perfilAnterior = null;
		try{
			Utilerias.getResponseISO();
			userSession = ActionContext.getContext().getSession();
			if(editar == 1){
				//Borrar elementos del menu de acuerdo al perfil, en la tabla de perfil_menu
				aDAO.borrarPerfilMenu(idPerfil);
				perfil = aDAO.consultaPerfil(idPerfil).get(0);	
				perfilAnterior = new Perfiles(perfil);
			}else{
				perfil = new Perfiles();
			}
			perfil.setDescripcion(descripcion);
			perfil.setPerfil(nombrePerfil);
			StringTokenizer tokens = new StringTokenizer(selectedItems, ",");
			int tmp1 =0;
			int tmp2 =0;
			while(tokens.hasMoreTokens()){
				 idMenu = tokens.nextToken();  
				 //recuperando los datos del menu a través de su id
				 Menu menu = aDAO.consultaMenu(Integer.valueOf(idMenu)).get(0);
				 perfil.getMenu().add(menu);
				 tmp1 = menu.getIdPadre();
				 if(tmp1 != tmp2){
					 menu = aDAO.consultaMenu(tmp1).get(0);
					 if(menu.getIdMenu() != 1){
						 perfil.getMenu().add(menu);
					 }
					 
				 }
				 tmp2 = tmp1;		 				 
			}
			cDAO.guardaObjeto(perfil);
		  if(editar==1){	  
			  log = "El usuario:" +(String) userSession.get("nombreUsuario")+ " actualizó el perfil: "+perfilAnterior.toString()+" por los datos "+perfil.toString();
			  AppLogger.info("app",log);
			  addActionMessage("El perfil se actualizó satisfactoriamente");
			  cDAO.guardaObjeto(new LogApp(new Date(), (Integer) userSession.get("idUsuario") , log));
			  editar = 0;
		  }else{
			  log = "El usuario:" +(String) userSession.get("nombreUsuario")+ " registró el perfil: "+nombrePerfil;
			  AppLogger.info("app",log);
			  addActionMessage("El perfil se registró satisfactoriamente");
			  cDAO.guardaObjeto(new LogApp(new Date(), (Integer) userSession.get("idUsuario") , log));
		  }			
		  perfil = new Perfiles();
			
		}catch (JDBCException e) {
			AppLogger.error("errores"," "+e.getCause());
			if(e.getErrorCode()== 1){
				addActionError("El nombre del perfil ya se encuentra registrado");	
				if(editar == 1){
					lstMenuVEdit = aDAO.consultaMenuDePerfil(idPerfil);
				}
			}else{
				addActionError("Ocurrió un error al agregar o editar el perfil. Favor de informar al administrador ");
			}
						
			e.printStackTrace();
		} finally{
			try {
				recuperaCatalogos();
			} catch (JDBCException e) {
				addActionError("Error al recuperar los catálogos de perfiles");
				e.printStackTrace();
			} 
		}	
		return SUCCESS;
	}
	

	/**
	 * Consulta los permisos de un perfil en especifico, a través de idPerfil
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al conseguir una regla de negocio
	 * @throws Exception  Error al conseguir una regla de negocio
	 */
	public String verPermisos(){
		try {
			perfil = aDAO.consultaPerfil(idPerfil).get(0);
			lstMenuV = aDAO.consultaMenuDePerfil(idPerfil);
		} catch (JDBCException e) {
			addActionError("Ocurrió un error de base de datos al conseguir los permisos del perfil");
			AppLogger.error("errores","Ocurrió un error al conseguir los permisos del perfil, debido a:"+e.getCause());
			e.printStackTrace();
		} catch (Exception e) {
			addActionError("Ocurrió un error inesperado al conseguir los permisos del perfil");
			AppLogger.error("errores","Ocurrió un error inesperado al conseguir los permisos del perfil, debido a:"+e.getCause());
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	
	
	/**
	 * Consigue los datos de perfil a través de su idPerfil
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al conseguir una regla de negocio
	 * @throws Exception  Error al conseguir una regla de negocio
	 */
	public String datosPerfil(){
		try{
			Utilerias.getResponseISO();
			perfil = aDAO.consultaPerfil(idPerfil).get(0);
			lstMenuV = aDAO.consultaMenuV(0);
			lstMenuVEdit = aDAO.consultaMenuDePerfil(idPerfil);
		}catch (JDBCException e) {
			addActionError("Ocurrió un error al conseguir los datos del perfil");
			AppLogger.error("errores","Ocurrió un error al conseguir los datos del perfil, debido a:"+e.getCause());
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * Elimina un perfil, siempre y cuando no tengan operaciones 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al eliminar un perfil
	 */	
	public String eliminarPerfil(){
		Utilerias.getResponseISO();
		String idPerfil = "";
		boolean error = false;
		List <String> lstNomPerfil = new ArrayList<String>(); 
		userSession = ActionContext.getContext().getSession();
		try {
			StringTokenizer tokens = new StringTokenizer(selectedItems, ",");		
			 while(tokens.hasMoreTokens()){
				 idPerfil = tokens.nextToken();  
		            if(!idPerfil.equals("-1")){
						try{
							//obtiene el objeto de perfil a tráves del idPerfil 
							perfil = aDAO.consultaPerfil(Integer.valueOf(idPerfil)).get(0);
							nombrePerfil = perfil.getPerfil();
							lstNomPerfil.add(perfil.getPerfil());
							cDAO.borrarObjeto(perfil);																				
						}catch (JDBCException e) {
							addActionError("No se borraron los perfiles, ocurrió un problema al intentar borrar el perfil: \""+nombrePerfil+"\", favor de informar al administrador");
							AppLogger.error("errores","Ocurrió un error al intentar borrar el perfil "+ nombrePerfil+" debido a:"+e.getCause());
							error = true;
							e.printStackTrace();
						}
		            }
			 }	
			 
			 if(!error){ 
				 for(String s: lstNomPerfil){
					 addActionError("Se eliminó perfil: "+s);
					 log = "El usuario: "+(String) userSession.get("nombreUsuario")+" eliminó al perfil: "+s;
					 cDAO.guardaObjeto(new LogApp(new Date(), (Integer) userSession.get("idUsuario"), log));
					 AppLogger.info("app",log);
				 }
			 }

		} catch (Exception e) {
			AppLogger.error("errores","Ocurrió un error al borrar al usuario debido a:"+e.getCause());
		}finally{
			lstPerfiles = aDAO.consultaPerfil(0);
		}				
		return SUCCESS;
	}
	
	public List<MenuV> getLstMenuV() {
		return lstMenuV;
	}

	public void setLstMenuV(List<MenuV> lstMenuV) {
		this.lstMenuV = lstMenuV;
	}
	
	public List<MenuV> getLstMenuVEdit() {
		return lstMenuVEdit;
	}

	public void setLstMenuVEdit(List<MenuV> lstMenuVEdit) {
		this.lstMenuVEdit = lstMenuVEdit;
	}

	public int getEditar() {
		return editar;
	}

	public void setEditar(int editar) {
		this.editar = editar;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(String selectedItems) {
		this.selectedItems = selectedItems;
	}

	public List<Perfiles> getLstPerfiles() {
		return lstPerfiles;
	}

	public void setLstPerfiles(List<Perfiles> lstPerfiles) {
		this.lstPerfiles = lstPerfiles;
	}

	public Perfiles getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfiles perfil) {
		this.perfil = perfil;
	}

	public String getNombrePerfil() {
		return nombrePerfil;
	}

	public void setNombrePerfil(String nombrePerfil) throws UnsupportedEncodingException {
		this.nombrePerfil = Utilerias.convertirISO88591aUTF8(nombrePerfil);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) throws UnsupportedEncodingException {
		this.descripcion = Utilerias.convertirISO88591aUTF8(descripcion);
	}		
	
}
