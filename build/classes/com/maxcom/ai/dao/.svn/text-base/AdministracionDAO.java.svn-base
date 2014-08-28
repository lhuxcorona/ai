package com.maxcom.ai.dao;
/**
*AdministracionDAO
*
*Clase que opera las consultas de la base de datos, para el módulo de Administración 
*
*Versión 1.0
*
*Septiembre 2012
*
*/
import java.util.List;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.maxcom.ai.domain.*;
import com.maxcom.ai.domain.vistas.*;


public class AdministracionDAO {
	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;	
	/**
	 * Consulta por nombre de usuario a la tabla de "USUARIOS"   
	 *  
	 * @param nomUsuario Es el nombre del usuario	
	 * @throws JDBCException Si ocurre cualquier error al consultar el catálogo de usuarios
	 *  
	 * @return Lista de datos de usuarios
	 *  
	 */
	public List<Usuarios> consultaUsuarios(String nomUsuario) throws Exception, JDBCException {
		return consultaUsuarios(0,nomUsuario,"");
	}

	/**
	 * Consulta por idUsuario, por nombre de usuario  o por todos los usuarios de la tabla de "USUARIOS"   
	 *  
	 * @param idUsuario Es el id del usuario
	 * @param nomUsuario Es el nombre del usuario
	 * 		
	 * @throws JDBCException Si ocurre cualquier error al consultar el usuarios
	 *  
	 * @return Lista de datos de usuarios
	 *  
	 */
	public List<Usuarios> consultaUsuarios(int idUsuario) throws Exception, JDBCException {
		return consultaUsuarios(idUsuario,"","");
	}

	/**
	 * Consulta por idUsuario a la tabla de "USUARIOS"   
	 *  
	 * @param idUsuario Es el id del usuario
	 * 		
	 * @throws JDBCException Si ocurre cualquier error al consultar el usuarios
	 *  
	 * @return Lista de datos de usuarios
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<Usuarios> consultaUsuarios(int idUsuario, String nomUsuario, String password) throws  JDBCException{
		StringBuilder consulta= new StringBuilder();
		List<Usuarios> lst=null;
		if (idUsuario != 0 && idUsuario != -1){
			consulta.append("where idUsuario = ").append(idUsuario);
		}	
		if (!(nomUsuario==null || nomUsuario.equals(""))){
			if(consulta.length()>0){
				consulta.append(" and usuario = '").append(nomUsuario).append("'");
			}else{
				consulta.append("where usuario= '").append(nomUsuario).append("'");
			}
		}
		if (!(password==null || password.equals(""))){
			if(consulta.length()>0){
				consulta.append(" and password = '").append(password).append("'");
			}else{
				consulta.append("where password= '").append(password).append("'");
			}
		}
		consulta.insert(0, "From Usuarios ").append(" ORDER BY nombre, paterno, materno");
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}
	
	/**
	 * Consulta por idUsuario, o por todos los usuarios de la vista de "USUARIOS_V"   
	 *  
	 * @param idUsuario Es el id del usuario
	 * 		
	 * @throws JDBCException Si ocurre cualquier error al consultar el catálogo de usuarios
	 *  
	 * @return Lista de datos de usuarios
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<UsuariosV> consultaUsuariosV(int idUsuario) throws  JDBCException{
		StringBuilder consulta= new StringBuilder();
		List<UsuariosV> lst=null;
		if (idUsuario != 0 && idUsuario != -1){
			consulta.append("where idUsuario = ").append(idUsuario);
		}	
		consulta.insert(0, "From UsuariosV ").append(" ORDER BY nombre, paterno, materno");
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}
	
	/**
	 * Consulta por idPerfil, o por todos los perfiles de la tabla de "PERFILES"   
	 *  
	 * @param idPerfil Es el id del perfil
	 * 		
	 * @throws JDBCException Si ocurre cualquier error al consultar el catálogo de perfiles
	 *  
	 * @return Lista de datos de perfiles
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<Perfiles> consultaPerfil(int idPerfil) throws  JDBCException{
		StringBuilder consulta= new StringBuilder();
		List<Perfiles> lst=null;
		if (idPerfil != 0 && idPerfil != -1){
			consulta.append("where idPerfil = ").append(idPerfil);
		}	
		consulta.insert(0, "From Perfiles ").append(" ORDER BY perfil");
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}
	
	/**
	 * Consulta el menu de acuerdo al perfil.   
	 *  
	 * @param idPerfil Es el id del perfil
	 * 		
	 * @throws JDBCException Si ocurre cualquier error al consultar el menu correspondiente al tipo de perfil
	 *  
	 * @return Lista de Menu
	 *  
	 */
	
	@SuppressWarnings("unchecked")
	public List<MenuV> consultaMenuDePerfil(int idPerfil) throws  JDBCException{
		StringBuilder consulta= new StringBuilder();
		List<MenuV> lst=null;
		consulta.append("select v.id_menu, v.id_padre, v.id_hijo, v.padre, v.hijo, v.nivel_padre, v.nivel_hijo, v.posicion_padre, v.posicion_hijo, v.url_padre, v.url_hijo ")
				.append("from menu_v v ")
				.append("left JOIN perfil_menu pm1 on v.id_padre=pm1.id_menu ")
				.append("left JOIN perfil_menu pm2 on nvl(v.id_hijo,v.id_padre)=pm2.id_menu ")
				.append("where pm1.id_perfil=").append(idPerfil).append(" and pm2.id_perfil=").append(idPerfil)
				.append("order by v.posicion_padre, v.posicion_hijo");
		lst= session.createSQLQuery(consulta.toString()).addEntity(MenuV.class).list();
		
		return lst;
	}	
	
	/**
	 * Consulta el por idMenu, por defecto o todo el menu de la aplicación en la vista de "MENU_V"  
	 *  
	 * @param idMenu Es el id del menu
	 * @param defecto Es una bandera para saber cual es la opción que por default tendrá el perfil, por ejemplo "salir" 
	 * 		
	 * @throws JDBCException Si ocurre cualquier error al consultar el menu
	 *  
	 * @return Lista de Menu
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<MenuV> consultaMenuV(int idMenu) throws  JDBCException{
		StringBuilder consulta= new StringBuilder();
		List<MenuV> lst=null;
		if (idMenu != 0 && idMenu != -1){
			consulta.append("where idMenu = ").append(idMenu);
		}	
		consulta.insert(0, "From MenuV ");
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}
	

	/**
	 * Consulta el por idMenu, por defecto o todo el menu de la aplicación en la tabla de "MENU"  
	 *  
	 * @param idMenu Es el id del menu
	 * @param defecto Es una bandera para saber cual es la opción que por default tendrá el perfil, por ejemplo "salir" 
	 * 		
	 * @throws JDBCException Si ocurre cualquier error al consultar el menu
	 *  
	 * @return Lista de Menu
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<Menu> consultaMenu(int idMenu) throws  JDBCException{
		StringBuilder consulta= new StringBuilder();
		List<Menu> lst=null;
		if (idMenu != 0 && idMenu != -1){
			consulta.append("where idMenu = ").append(idMenu);
		}	
		
		consulta.insert(0, "From Menu ");
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}
	
	/**
	 * Borra de la tabla perfil_menu, de acuerdo al id_perfil  
	 *  
	 * @param idPerfil Es el id del perfil		
	 * 
	 * @throws JDBCException Si ocurre un error al borrar, se ejecuta rollback
	 *  
	 *  
	 */
	public int borrarPerfilMenu(int idPerfil)throws JDBCException {
		int elementosBorrados = 0;
		try{
			StringBuilder hql = new StringBuilder()
			.append("DELETE FROM PERFIL_MENU WHERE ID_PERFIL= ").append(idPerfil);
			elementosBorrados = session.createSQLQuery(hql.toString()).executeUpdate();
			
		}catch (JDBCException e){
			transaction.rollback();
			throw e;
		}	
		return elementosBorrados;
	}	
	
}
