package com.maxcom.ai.dao;


import java.util.List;
import org.hibernate.JDBCException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.maxcom.ai.domain.Reportes;
import com.maxcom.ai.domain.vistas.*;
/**
*ReportesDAO.
*Interacción con la base de datos para el módulo de reportes.
*
*Versión 1.0
*
*Septiembre 2012
*
*/
public class ReportesDAO {
	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;	
	
	/**
	 * Consulta por punto de control, central, rango de fechas, reporte o por todos los registros de la vista "REPORTES_GENERADOS_V"   
	 *  
	 * @param idProceso Es el id del punto de control
	 * @param idCentral Es el id de la central
	 * @param fecIni    Es la fecha inicio
	 * @param fecFin    Es la fecha fin
	 * @param idReporte Es el id del reporte
	 * 		
	 * @throws JDBCException Si ocurre cualquier error al consultar el reporte
	 *  
	 * @return Lista de datos de tipo ReportesGeneradosV
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<ReportesGeneradosV> consultaReportesV(int idProceso, int idCentral, String fecIni, String fecFin, int idReporte) throws  JDBCException{
		StringBuilder consulta= new StringBuilder();
		List<ReportesGeneradosV> lst=null;
		if (idProceso != 0 && idProceso != -1){
			consulta.append("where idProceso = ").append(idProceso);
		}	
		
		if (idCentral !=0 && idCentral!= -1){
			if(consulta.length()>0){
				consulta.append(" and idCentral = ").append(idCentral);
			}else{
				consulta.append("where idCentral= ").append(idCentral);
			}
		}
		
		if (!(fecIni==null || fecIni.equals(""))){
			if(consulta.length()>0){
				consulta.append(" and TO_CHAR(fecIni,'DD-MM-YYYY')= '").append(fecIni).append("'");
			}else{
				consulta.append("where TO_CHAR(fecIni,'DD-MM-YYYY')= '").append(fecIni).append("'");
			}
		}
		if (!(fecFin==null || fecFin.equals(""))){
			if(consulta.length()>0){
				consulta.append(" and TO_CHAR(fecFin,'DD-MM-YYYY') = '").append(fecFin).append("'");
			}else{
				consulta.append("where TO_CHAR(fecFin,'DD-MM-YYYY')= '").append(fecFin).append("'");
			}
		}
	
		if (idReporte !=0 && idReporte!= -1){
			if(consulta.length()>0){
				consulta.append(" and idReporte = ").append(idReporte);
			}else{
				consulta.append("where idReporte= ").append(idReporte);
			}
		}
		consulta.insert(0, "From ReportesGeneradosV ");
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}
	
	/**
	 * Consulta por id, por nombre o por ambos el reporte en la tabla de "REPORTES"  
	 *  
	 * @param idReporte Es el id del reporte		
	 * @param nomReporte Es el nombre del reporte
	 * @throws Exception Si ocurre un error inesperado al consultar datos del reporte
	 * @throws JDBCException Si ocurre un error de base de datos del reporte
	 *  
	 * @return Lista de datos de tipo Reportes
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<Reportes> consultaReportes(int idReporte, String nomReporte) throws Exception, JDBCException {
		StringBuilder consulta= new StringBuilder();
		List<Reportes> lst=null;
		if (idReporte != 0 && idReporte != -1){
			consulta.append("where idReporte = ").append(idReporte);
		}
		
		if (!(nomReporte==null || nomReporte.equals(""))){
			if(consulta.length()>0){
				consulta.append(" and nomReporte = '").append(nomReporte).append("'");
			}else{
				consulta.append("where nomReporte= '").append(nomReporte).append("'");
			}
		}
	
		consulta.insert(0, "From Reportes ").append(" ORDER BY nomReporte");
		
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}

	/**
	 * Consulta por id, por nombre o por ambos el reporte en la vista de "REPORTES_V"  
	 *  
	 * @param idReporte Es el id del reporte		
	 * @param nomReporte Es el nombre del reporte
	 * @throws Exception Si ocurre un error inesperado al consultar datos del reporte
	 * @throws JDBCException Si ocurre cualquier error al consultar en base de datos
	 *  
	 * @return Lista de datos de tipo ReportesV
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<ReportesV> consultaReportesV(int idReporte, String nomReporte) throws Exception, JDBCException {
		StringBuilder consulta= new StringBuilder();
		List<ReportesV> lst=null;
		if (idReporte != 0 && idReporte != -1){
			consulta.append("where idReporte = ").append(idReporte);
		}
		
		if (!(nomReporte==null || nomReporte.equals(""))){
			if(consulta.length()>0){
				consulta.append(" and nomReporte = '").append(nomReporte).append("'");
			}else{
				consulta.append("where nomReporte= '").append(nomReporte).append("'");
			}
		}
	
		consulta.insert(0, "From ReportesV ").append(" ORDER BY nomReporte");
		
		lst= session.createQuery(consulta.toString()).list();
		
		return lst;
	}

	
	
		
}
