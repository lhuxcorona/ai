package com.maxcom.ai.action.administracion;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.hibernate.JDBCException;



import com.maxcom.ai.dao.AdministracionDAO;
import com.maxcom.ai.dao.CatalogosDAO;
import com.maxcom.ai.domain.LogApp;
import com.maxcom.ai.domain.Perfiles;
import com.maxcom.ai.domain.Usuarios;
import com.maxcom.ai.domain.vistas.UsuariosV;
import com.maxcom.ai.log.AppLogger;
import com.maxcom.reproceso.utilerias.Utilerias;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UsuariosAction extends ActionSupport{
	
	private AdministracionDAO aDAO = new AdministracionDAO();
	private CatalogosDAO cDAO = new CatalogosDAO();
	private List<UsuariosV> lstUsuariosV;
	private List<Perfiles> lstPerfiles;
	private int editar;
	private Usuarios usuario;
	private String selectedItems;
	private String nomUsuario;	
	private String contrasenia;
	private String nombre;
	private String paterno;
	private String materno;
	private String email;
	private int idPerfil;
	private int idUsuario;
	private String log;
	private Map<String, Object> session;
	
	/**
	 *  Recupera el catálogo de usuarios y de perfiles
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al consultar el catálogo de usuarios
	 */
	public String usuarios(){
		try {
			recuperaCatalogos();
			
		} catch (JDBCException e) {
			addActionError("Error al conseguir el catálogo de usuarios por favor comuniquese con el Administrador del sistema");
			AppLogger.error("errores","Ocurrió un error al conseguir los catálogos de usuarios debido a: " +e.getCause() );
			e.printStackTrace();
		} 
			
		return SUCCESS;
	}
	
	/**
	 *  Recupera el catálogo de usuarios y de perfiles de la base de datos
	 *  
	 * 
	 */
	private void recuperaCatalogos() {
		
		lstUsuariosV = aDAO.consultaUsuariosV(0);
		lstPerfiles = aDAO.consultaPerfil(0);
		
	}
	/**
	 * Actualiza o agrega un usuario en la tabla de usuarios 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al actualizar o agregar un usuario
	 * @throws Exception   Error al actualizar o agregar un usuario
	 */
	public String agregarEditarUsuario() throws Exception{
		session = ActionContext.getContext().getSession();
		Usuarios usuarioAnterior = null;
		try{
			Utilerias.getResponseISO();
			if(editar == 1){
				usuario = aDAO.consultaUsuarios(idUsuario).get(0);
				usuarioAnterior = new Usuarios(usuario);
			}else{
				usuario = new Usuarios();
			}
			usuario.setUsuario(nomUsuario);
			usuario.setPassword(contrasenia);
			usuario.setNombre(nombre);
			usuario.setPaterno(paterno);
			usuario.setMaterno(materno);
			usuario.setIdPerfil(idPerfil);
			usuario.setEmail(email);
			cDAO.guardaObjeto(usuario);
			
			addActionMessage(editar == 1?"El usuario se actualizó satisfactoriamente":"El usuario se registró satisfactoriamente");
			  if(editar==1){	  
				  log = "El usuario:" +(String) session.get("nombreUsuario")+ " actualizó al usuario: "+usuarioAnterior.toString()+" por los datos: " + usuario.toString();
				  AppLogger.info("app",log);
				  cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log));
			  }else{
				  log = "El usuario:" +(String) session.get("nombreUsuario")+ " registró al usuario: "+nomUsuario;
				  AppLogger.info("app",log);
				  cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log));
			  }
			//limpia los campos de formulario de agregar usuario
			usuario = new Usuarios();
			editar = 0;
			
		} catch (JDBCException e) {
			if(e.getErrorCode() == 1){
				addActionError("El nombre de usuario ya se encuentra registrado");	
			}else{
				AppLogger.error("errores","Ocurrió un error al agregar editar usuario debido a: "+e.getCause());
				addActionError("Ocurrió un error al agregar o editar el usuario. Favor de informar al administrador ");
			}
			e.printStackTrace();
		} finally{
			try {
				recuperaCatalogos();
			} catch (JDBCException e) {
				addActionError("Error al recuperar el catálogo usuarios, favor de informar al administrador del sistema ");
				AppLogger.error("errores","Ocurrió un error al recuperar los catálogos debido a: "+e.getCause());
				e.printStackTrace();
			} 
		}	
		
		
		return SUCCESS;
	}
	
	/**
	 * Consigue los datos de un usuario por el idUsuario
	 * @throws Exception 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al conseguir los datos del usuario
	 */
	public String datosUsuario() throws Exception{
		try {
			Utilerias.getResponseISO();
			// Consigue los datos del usuario a tráves de su id
			usuario = aDAO.consultaUsuarios(idUsuario).get(0);
			lstPerfiles = aDAO.consultaPerfil(0);
		
		} catch (JDBCException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	/**
	 * Elimina usuarios, siempre y cuando no tengan operaciones 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al eliminar la regla de negocio
	 * @throws Exception  Error al eliminar una regla de negocio
	 */	
	public String eliminarUsuario() throws JDBCException, Exception{
		Utilerias.getResponseISO();
		String idUsuarios = "";
		session = ActionContext.getContext().getSession();
		
		try {
			StringTokenizer tokens = new StringTokenizer(selectedItems, ",");		
			 while(tokens.hasMoreTokens()){
				 idUsuarios = tokens.nextToken();  
		            if(!idUsuarios.equals("-1")){
		            	// Consigue el usuario de acuerdo al idUsuario
						usuario = aDAO.consultaUsuarios(Integer.valueOf(idUsuarios)).get(0);
						nomUsuario = usuario.getUsuario();
						try{
							cDAO.borrarObjeto(usuario);
							addActionError("Se eliminó el usuario: "+nomUsuario);
							log = "El usuario:" +(String) session.get("nombreUsuario")+ " eliminó al usuario: "+nomUsuario;
							cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log));
							AppLogger.info("app",log);
						}catch (JDBCException e) {
							addActionError("No se pudo borrar usuario: "+nomUsuario);
							AppLogger.error("errores","Ocurrió un error al borrar al usuario debido a:"+e.getCause());
							e.printStackTrace();
						}
		            }
		            
			 }	

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lstUsuariosV = aDAO.consultaUsuariosV(0);
		}
		
		
		
			
		return SUCCESS;
	}
	
	public List<UsuariosV> getLstUsuariosV() {
		return lstUsuariosV;
	}
	public void setLstUsuariosV(List<UsuariosV> lstUsuariosV) {
		this.lstUsuariosV = lstUsuariosV;
	}
		
	public List<Perfiles> getLstPerfiles() {
		return lstPerfiles;
	}
	public void setLstPerfiles(List<Perfiles> lstPerfiles) {
		this.lstPerfiles = lstPerfiles;
	}
	public Usuarios getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	public int getEditar() {
		return editar;
	}

	public void setEditar(int editar) {
		this.editar = editar;
	}

	public String getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(String selectedItems) {
		this.selectedItems = selectedItems;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws UnsupportedEncodingException {
		this.nombre = Utilerias.convertirISO88591aUTF8(nombre);
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) throws UnsupportedEncodingException {
		this.paterno = Utilerias.convertirISO88591aUTF8(paterno);
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) throws UnsupportedEncodingException {
		this.materno = Utilerias.convertirISO88591aUTF8(materno);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
