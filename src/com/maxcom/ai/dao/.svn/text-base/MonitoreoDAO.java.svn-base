package com.maxcom.ai.dao;
/**
*MonitoreoDAO
*
*Clase que opera las consultas de la base de datos, para el módulo de Monitoreo 
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
import com.maxcom.ai.domain.vistas.DeProcesoV;
import com.maxcom.ai.domain.vistas.LogAppV;


public class MonitoreoDAO {
	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;	
	
	
	/**
	 * Consulta por nombre, por id o por ambos el Log de Aplicacion en la Vista de "LogAppV"  
	 *  
	 * @param idLog Es el id del LogApp		
	 * @param Log de Aplicacion Es el nombre del LogApp
	 * @throws Exception Si ocurre un error al consultar datos del LogApp
	 * @throws JDBCException Si ocurre cualquier error al consultar en base de datos
	 *  
	 * @return Lista de datos de LogApp
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<LogAppV> consultaLogApp(String fechaInicio, String fechaFin, int idUsuario, String descripcion) throws Exception, JDBCException {
		StringBuilder consulta= new StringBuilder();
		List<LogAppV> lst=null;
		
		if(!(fechaInicio==null || fechaInicio.equals("") || fechaFin==null || fechaFin.equals(""))){
			   
	           consulta.append(" where TO_CHAR(fecha,'DD-MM-YYYY') between "); 
			   consulta.append(" '").append(fechaInicio).append("'"); 
			   consulta.append(" and '").append(fechaFin).append("'");
			   
		}else{
				if (!(fechaInicio==null || fechaInicio.equals(""))){
					if(consulta.length()>0){
						consulta.append(" and TO_CHAR(fecha,'DD-MM-YYYY') = '").append(fechaInicio).append("'");
					}else{
						consulta.append("where TO_CHAR(fecha,'DD-MM-YYYY') = '").append(fechaInicio).append("'");
					}
		        }
				if (!(fechaFin==null || fechaFin.equals(""))){
					if(consulta.length()>0){
						consulta.append(" and TO_CHAR(fecha,'DD-MM-YYYY') = '").append(fechaFin).append("'");
					}else{
						consulta.append("where TO_CHAR(fecha,'DD-MM-YYYY') = '").append(fechaFin).append("'");
					}
				}
		   
        }
		
		if (idUsuario != 0 && idUsuario != -1){
			if(consulta.length()>0){
				consulta.append(" and idUsuario = ").append(idUsuario);
			}else{
				consulta.append("where idUsuario = ").append(idUsuario);
			}
		}
	
		if (!(descripcion==null || descripcion.equals(""))){
			if(consulta.length()>0){
				consulta.append(" and descripcion like '%").append(descripcion).append("%'");
			}else{
				consulta.append("where descripcion like '%").append(descripcion).append("%'");
			}
		}		
		consulta.insert(0, "From LogAppV ").append(" ORDER BY id");
		
		
		
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}


	


	
	/**
	 * Consulta por nombres, por fecha o por ambos el De Proceso en la Vista de "DeProcesoV "  
	 *  		
	 * @param DeProceso de Aplicacion Es el nombre del CONTROL_DE_CARGAS
	 * @throws Exception Si ocurre un error al consultar datos del CONTROL_DE_CARGAS 
	 * @throws JDBCException Si ocurre cualquier error al consultar en base de datos
	 *  
	 * @return Lista de datos DeProceso
	 *  
	 */	
	
	
	@SuppressWarnings("unchecked")
	public List<DeProcesoV> consultaDeProcesoV(String fechaInicio, int idProceso, int idCentral, String descripcion)throws Exception, JDBCException {
		StringBuilder consulta= new StringBuilder();
		List<DeProcesoV> lst=null;
		
		
		if (!(fechaInicio==null || fechaInicio.equals(""))){
			if(consulta.length()>0){
				consulta.append(" and TO_CHAR(fecha,'DD-MM-YYYY') = '").append(fechaInicio).append("'");
			}else{
				consulta.append("where TO_CHAR(fecha,'DD-MM-YYYY') = '").append(fechaInicio).append("'");
			}
		}
		
        	
		if (idProceso != 0 && idProceso != -1){
			if(consulta.length()>0){
				consulta.append(" and idProceso = ").append(idProceso);
			}else{
				consulta.append("where idProceso = ").append(idProceso);
			}
		}
		
		if (idCentral != 0 && idCentral != -1){
			if(consulta.length()>0){
				consulta.append(" and idCentral = ").append(idCentral);
			}else{
				consulta.append("where idCentral = ").append(idCentral);
			}
		}
	
		if (!(descripcion==null || descripcion.equals(""))){
			if(consulta.length()>0){
				consulta.append(" and descripcion like '%").append(descripcion).append("%'");
			}else{
				consulta.append("where descripcion like '%").append(descripcion).append("%'");
			}
		}		
		consulta.insert(0, "From DeProcesoV ").append(" ORDER BY fecha");
		
		
		
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	 }


}
