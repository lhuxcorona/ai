package com.maxcom.ai.dao;
/**
*CatalogosDAO
*
*Clase que opera las consultas de la base de datos, para el módulo de Catalogos 
*
*Versión 1.0
*
*Septiembre 2012
*
*/
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.maxcom.ai.domain.*;
import com.maxcom.ai.domain.vistas.*;

public class CatalogosDAO {
	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;
	/**
	 * Guarda un objeto en la base de datos de acuerdo al mapeo de la tabla que tiene asignado dicho objeto  
	 *  
	 * @param o Es el objeto a guardar		
	 * @throws Exception Si ocurre un error al guardar el objeto
	 * @throws JDBCException Si ocurre cualquier error al guardar en la base de datos
	 *  
	 *  
	 */
	public void guardaObjeto(Object o)throws JDBCException {
		try{
			session.saveOrUpdate(o);
			session.flush();
			session.clear();
		}catch (JDBCException e){
			transaction.rollback();
			throw e;
		}
	}
	
	/**
	 * Borra un objeto  en la base de datos de acuerdo al mapeo de la tabla que tiene asignado dicho objeto  
	 *  
	 * @param o Es el objeto a borrar		
	 * @throws Exception Si ocurre un error al borrar el objeto
	 * @throws JDBCException Si ocurre cualquier error al borrar el objeto en la base de datos
	 *  
	 *  
	 */
	public void borrarObjeto(Object o)throws JDBCException {	
		session.delete(o);
		session.flush();
		session.clear();
		
	}
	
	/**
	 * Consulta por id el punto de control en la tabla de "PUNTOS_DE_CONTROL"  
	 *  
	 *		
	 * @param idProceso Es el id del punto de control
	 * @throws Exception Si ocurre un error al consultar datos del punto de control
	 * @throws JDBCException Si ocurre cualquier error al consultar en base de datos
	 *  
	 * @return Lista de datos de punto de control
	 *  
	 */	
	public List<PuntosDeControl> consultaPC(int idProceso) throws Exception, JDBCException {
		return consultaPC(idProceso,"");
	}
	/**
	 * Consulta por nombre, el punto de control en la tabla de "PUNTOS_DE_CONTROL"  
	 *  
	 *		
	 * @param puntoControl Es el nombre del punto de control
	 * @throws Exception Si ocurre un error al consultar datos del punto de control
	 * @throws JDBCException Si ocurre cualquier error al consultar en base de datos
	 *  
	 * @return Lista de datos de punto de control
	 *  
	 */	
	public List<PuntosDeControl> consultaPC(String puntoControl) throws Exception, JDBCException {
		return consultaPC(0,puntoControl);
	}
	
	/**
	 * Consulta por nombre, por id o por ambos el punto de control en la tabla de "PUNTOS_DE_CONTROL"  
	 *  
	 * @param idProceso Es el id del punto de control		
	 * @param puntoControl Es el nombre del punto de control
	 * @throws Exception Si ocurre un error al consultar datos del punto de control
	 * @throws JDBCException Si ocurre cualquier error al consultar en base de datos
	 *  
	 * @return Lista de datos de punto de control
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<PuntosDeControl> consultaPC(int idProceso, String puntoControl) throws Exception, JDBCException {
		StringBuilder consulta= new StringBuilder();
		List<PuntosDeControl> lst=null;
		if (idProceso != 0 && idProceso != -1){
			consulta.append("where idProceso = ").append(idProceso);
		}
		
		if (!(puntoControl==null || puntoControl.equals(""))){
			if(consulta.length()>0){
				consulta.append(" and nomProceso = '").append(puntoControl).append("'");
			}else{
				consulta.append("where nomProceso= '").append(puntoControl).append("'");
			}
		}
	
		consulta.insert(0, "From PuntosDeControl ").append(" ORDER BY idProceso");
		
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}
	
	/**
	 * Consulta por id la regla de negocio en la tabla de "REGLA_NEGOCIO"  
	 *  
	 *		
	 * @param idProceso Es el id del punto de control
	 * @throws Exception Si ocurre un error al consultar datos del punto de control
	 * @throws JDBCException Si ocurre cualquier error al consultar en base de datos
	 *  
	 * @return Lista de datos de punto de control
	 *  
	 */	
	public List<ReglasNegocio> consultaRN(int codRegla) throws Exception, JDBCException {
		return consultaRN(codRegla,"");
	}
	/**
	 * Consulta por nombre, el punto de control en la tabla de "PUNTOS_DE_CONTROL"  
	 *  
	 *		
	 * @param puntoControl Es el nombre del punto de control
	 * @throws Exception Si ocurre un error al consultar datos del punto de control
	 * @throws JDBCException Si ocurre cualquier error al consultar en base de datos
	 *  
	 * @return Lista de datos de punto de control
	 *  
	 */	
	public List<ReglasNegocio> consultaRN(String nomRegla) throws Exception, JDBCException {
		return consultaRN(0,nomRegla);
	}
	
	/**
	 * Consulta por nombre, por id, por ambos o todas la reglas de negocio den la tabla de "REGLA_NEGOCIO"  
	 *  
	 * @param idProceso Es el id del punto de control		
	 * @param puntoControl Es el nombre del punto de control
	 * @throws Exception Si ocurre un error al consultar datos del punto de control
	 * @throws JDBCException Si ocurre cualquier error al consultar en base de datos
	 *  
	 * @return Lista de datos de reglas de negocio
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<ReglasNegocio> consultaRN(int codRegla, String nomRegla) throws Exception, JDBCException {
		StringBuilder consulta= new StringBuilder();
		List<ReglasNegocio> lst=null;
		if (codRegla != 0 && codRegla != -1){
			consulta.append("where codRegla = ").append(codRegla);
		}
		
		if (!(nomRegla==null || nomRegla.equals(""))){
			if(consulta.length()>0){
				consulta.append(" and nomRegla = '").append(nomRegla).append("'");
			}else{
				consulta.append("where nomRegla = '").append(nomRegla).append("'");
			}
		}
	
		consulta.insert(0, "From ReglasNegocio ").append(" ORDER BY codRegla");
		
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}
	
	/**
	 * Consulta por id o todas la tarifas de la vista de "TARIFAS_V"  
	 *  
	 * @param idTarifa Es el id de la tarifa		
	 * @throws Exception Si ocurre un error al consultar datos de la tarifa
	 * @throws JDBCException Si ocurre cualquier error al consultar en base de datos
	 *  
	 * @return Lista de datos de tarifas
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<TarifasV> consultaTarifasV(int idTarifa) throws Exception, JDBCException {
		StringBuilder consulta= new StringBuilder();
		List<TarifasV> lst=null;
		if (idTarifa != 0 && idTarifa != -1){
			consulta.append("where idTarifa = ").append(idTarifa);
		}			
		consulta.insert(0, "From TarifasV ");
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}
	/**
	 * Consulta por id o todas la tarifas de la tabla de "TARIFAS"  
	 *  
	 * @param idTarifa Es el id de la tarifa		
	 * @throws Exception Si ocurre un error al consultar datos de la tarifa
	 * @throws JDBCException Si ocurre cualquier error al consultar en base de datos
	 *  
	 * @return Lista de datos de tarifas
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<Tarifas> consultaTarifas(int idTarifa) throws Exception, JDBCException {
		StringBuilder consulta= new StringBuilder();
		List<Tarifas> lst=null;
		if (idTarifa != 0 && idTarifa != -1){
			consulta.append("where idTarifa = ").append(idTarifa);
		}			
		consulta.insert(0, "From Tarifas ");
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}
	
	/**
	 * Consulta por tllClave o todos los  tipos de llamadas de la tabla de "TIPO_LLAMADAS"  
	 *  
	 * @param tllClave Es el id del tipo de llamada		
	 * @throws Exception Si ocurre un error al consultar datos del tipo de llamada
	 * @throws JDBCException Si ocurre cualquier error al consultar el tipo de llamadas en base de datos
	 *  
	 * @return Lista de datos de tipos de llamadas
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<TipoLlamadas> consultaTipoLlamada(int tllClave) throws Exception, JDBCException {
		StringBuilder consulta= new StringBuilder();
		List<TipoLlamadas> lst=null;
		if (tllClave != 0 && tllClave != -1){
			consulta.append(" where tllClave = ").append(tllClave);
		}			
		consulta.insert(0, " From TipoLlamadas ").append(" order by descTipoLlamada");;
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}
	/**
	 * Consulta por accountCategory o todos los tipos de clientes  de la tabla de "TIPOCLIENTE"  
	 *  
	 * @param accountCategory Es el id del tipo de cliente
	 * @throws Exception Si ocurre un error al consultar datos del tipo de cliente
	 * @throws JDBCException Si ocurre cualquier error al consultar el tipo de cliente en base de datos
	 *  
	 * @return Lista de datos de tipos de cliente
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<TipoCliente> consultaTipoCliente(int accountCategory) throws Exception, JDBCException {
		StringBuilder consulta= new StringBuilder();
		List<TipoCliente> lst=null;
		if (accountCategory != 0 && accountCategory != -1){
			consulta.append("where accountCategory = ").append(accountCategory);
		}			
		consulta.insert(0, "From TipoCliente ").append(" order by displayValue");
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}
	
	/**
	 * Consulta por id o todas las centrales de la vista de "CENTRALES_V"  
	 *  
	 * @param idCentral Es el id de la central		
	 * @throws Exception Si ocurre un error al consultar la central
	 * @throws JDBCException Si ocurre cualquier error al consultar la central en base de datos
	 *  
	 * @return Lista de datos de centrales
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<CentralesV> consultaCentralesV(int idCentral) throws Exception, JDBCException {
		StringBuilder consulta= new StringBuilder();
		List<CentralesV> lst=null;
		if (idCentral != 0 && idCentral != -1){
			consulta.append("where idCentral = ").append(idCentral);
		}			
		consulta.insert(0, "From CentralesV ").append("order by idCentral");
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}
	
	/**
	 * Consulta por id o todas las centrales de la tabla de "Centrales"  
	 *  
	 * @param idCentral Es el id de la central		
	 * @throws Exception Si ocurre un error al consultar datos de la central
	 * @throws JDBCException Si ocurre cualquier error al consultar en base de datos
	 *  
	 * @return Lista de datos de las centrales
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<Centrales> consultaCentrales(int idCentral) throws JDBCException {
		StringBuilder consulta= new StringBuilder();
		List<Centrales> lst=null;
		if (idCentral != 0 && idCentral != -1){
			consulta.append("where idCentral = ").append(idCentral);
		}			
		consulta.insert(0, "From Centrales ").append(" order by nomCentral");
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}

	/**
	 * Consulta por claveCodificacion o todos los tipos de codificación  
	 *  
	 * @param claveCodificacion Es el id del tipo de codificación		
	 * @throws Exception Si ocurre un error al consultar los tipos de codificación
	 * @throws JDBCException Si ocurre cualquier error al consultar en base de datos
	 *  
	 * @return Lista de datos de tipo "TipoCodificacion"
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<TipoCodificacion> consultaTipoCodificacion(int claveCodificacion) throws Exception, JDBCException {
		StringBuilder consulta= new StringBuilder();
		List<TipoCodificacion> lst=null;
		if (claveCodificacion != 0 && claveCodificacion != -1){
			consulta.append("where claveCodificacion = ").append(claveCodificacion);
		}			
		consulta.insert(0, "From TipoCodificacion ");
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}
	
	/**
	 * Consulta una query  
	 *  
	 * @param query Es la query de la consulta		
	 * @throws JDBCException Si ocurre cualquier error al consultar en base de datos
	 *  
	 *  
	 */
	public void consultaEnCrudo(String query) throws JDBCException{
		session.createSQLQuery(query.toString()).list();
	}
	
	/**
	 * Consulta por idMapeo, por central o todos los mapeos de los archivos en la tabla de "MAPEO_ARCHIVOS"   
	 *  
	 * @param idMapeo Es el id de mapeo
	 * @param idCentral Es el id de la central
	 * 		
	 * @throws JDBCException Si ocurre cualquier error al consultar en base de datos
	 *  
	 * @return Lista de datos de mapeo de archivos
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<MapeoArchivos> consultaMapeoArchivos(int idMapeo, int idCentral) throws  JDBCException {
		StringBuilder consulta= new StringBuilder();
		List<MapeoArchivos> lst=null;
		if (idMapeo != 0 && idMapeo != -1){
			consulta.append("where idMapeo = ").append(idMapeo);
		}
		
		if (idCentral != 0 && idCentral != -1){
			if(consulta.length()>0){
				consulta.append(" and idCentral = ").append(idCentral);
			}else{
				consulta.append("where idCentral = ").append(idCentral);
			}
		}
	
		consulta.insert(0, "From MapeoArchivos ").append(" ORDER BY posicion");
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}
	
	
	/**
	 * Borra de la tabla "mapeo_archivos" por id_central   
	 *  
	 * @param idCentral Es el id de la central
	 * 		
	 * @throws JDBCException Si ocurre cualquier error al consultar en base de datos
	 *  
	 *  
	 */
	public void borraMapeoArchivos(int idCentral) throws  JDBCException {
		String hql = "delete from  mapeo_archivos where id_central = " + idCentral;
		session.createSQLQuery(hql).executeUpdate();
	}
	
	
	/**
	 * Consulta por idMapeoRegla, los mapeo de las reglas en la tabla de "MAPEO_REGLAS"   
	 *  
	 * @param idMapeoRegla Es el id de mapeo de regla
	 * @param idCentral Es el id de la central
	 * 		
	 * @throws JDBCException Si ocurre cualquier error al consultar en base de datos
	 *  
	 * @return Lista de datos de mapeo de reglas
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<MapeoReglas> consultaMapeoReglas(int idMapeoRegla) throws  JDBCException {
		StringBuilder consulta= new StringBuilder();
		List<MapeoReglas> lst=null;
		if (idMapeoRegla != 0 && idMapeoRegla != -1){
			consulta.append("where idMapeoReglas = ").append(idMapeoRegla);
		}
	
		consulta.insert(0, "From MapeoReglas ").append(" ORDER BY idMapeoReglas");
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}
	
	/**
	 * Consulta por idMapeoRegla, o por todos los mapeo de las reglas en la vista de "MAPEO_REGLAS_V"   
	 *  
	 * @param idMapeoRegla Es el id de mapeo de regla
	 * @param idCentral Es el id de la central
	 * 		
	 * @throws JDBCException Si ocurre cualquier error al consultar en base de datos
	 *  
	 * @return Lista de datos de mapeo de reglas
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<MapeoReglasV> consultaMapeoReglasV(int idMapeoRegla) throws  JDBCException{
		StringBuilder consulta= new StringBuilder();
		List<MapeoReglasV> lst=null;
		if (idMapeoRegla != 0 && idMapeoRegla != -1){
			consulta.append("where idMapeoReglas = ").append(idMapeoRegla);
		}
	
		consulta.insert(0, "From MapeoReglasV ").append(" ORDER BY idMapeoReglas");
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}
	
	
	/**
	 * Llama a el stored para la ejecución del reproceso de la central que recibe como parametro.    
	 *  
	 * @param idCentral Es el id de la central
	 * 		
	 * @throws JDBCException Si ocurre un error al ejecutar el stored procedures
	 *  
	 * @return Mensaje de ejecución correcta o incorrecta.
	 *  
	 */
	@SuppressWarnings("deprecation")
	public String ejecutaReproceso(int idCentral) throws JDBCException, HibernateException, SQLException {
					
		String resultado = "";
		CallableStatement callableStatement = session.connection().prepareCall("{ call SP_PRUEBA(?,?)}");		  
		callableStatement.setInt(1, idCentral);
		callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
		callableStatement.executeUpdate();	
		resultado = callableStatement.getString(2);	
		
		return resultado;
		
	}
	
}
