package com.maxcom.ai.action.catalogos;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.hibernate.JDBCException;
import com.maxcom.ai.dao.CatalogosDAO;
import com.maxcom.ai.domain.LogApp;
import com.maxcom.ai.domain.ReglasNegocio;
import com.maxcom.ai.log.AppLogger;
import com.maxcom.reproceso.utilerias.Utilerias;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
*ReglasAction.
*Acciones para el catálogo de Reglas de negocio(ABC)
*
*Versión 1.0
*
*Septiembre 2012
*
*/ 
@SuppressWarnings("serial")
public class ReglasAction extends ActionSupport{
	
	private CatalogosDAO cDAO = new CatalogosDAO();
	private List<ReglasNegocio> lstRN;
	private int editar;
	private int codRegla;
	private String nomRegla;
	private ReglasNegocio rn = new ReglasNegocio();
	private String selectedItems;
	private String log;
	private Map<String, Object> session;
	
	/**
	 * Consulta el catálogo de reglas de negocio. 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al consultar el catálogo de reglas de negocio
	 * @throws Exception   Error al consultar el catálogo de reglas de negocio
	 */
	public String reglasNegocio(){
		try {
			//Consulta el catalogo de Reglas de Negocio
			lstRN = cDAO.consultaRN(0);
		} catch (JDBCException e) {
			addActionError("Error al conseguir el catálogo de reglas de negocio ");
			AppLogger.error("errores","Error al conseguir el catálogo de reglas de negocio "+e.getCause());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			addActionError("Error al conseguir el catálogo de reglas de negocio ");
			AppLogger.error("errores","Error al conseguir el catálogo de reglas de negocio "+e.getCause());
		}
			
		return SUCCESS;
	}
	/**
	 * Actualiza o agrega una regla de negocio 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al actualizar o agregar una regla de negocio
	 * @throws Exception   Error al actualizar o agregar una regla de negocio
	 */
	public String agregarEditarRN(){
		session = ActionContext.getContext().getSession();
		try {
			Utilerias.getResponseISO();
			if(editar == 1){//actualiza una regla de negocio
				// Consigue la regla de negocio por codRegla
				rn = cDAO.consultaRN(codRegla).get(0);
				if(!rn.getNomRegla().equals(nomRegla)){
					if(cDAO.consultaRN(nomRegla).size()>0){
						addActionError("El nombre de la regla de negocio ya se encuentra registrada");
						AppLogger.error("errores","El nombre de la regla de negocio ya se encuentra registrada en la base de datos");
						editar = 1;
						return INPUT;
					}
				}
				ReglasNegocio rnAnterior = null;
				rn.setNomRegla(nomRegla);
				rnAnterior = new ReglasNegocio(rn);
				cDAO.guardaObjeto(rn);
				addActionMessage("La regla de negocio se actualizó satisfactoriamente");
				log = "El usuario: "+(String) session.get("nombreUsuario")+" actualizó la regla de negocio"+rnAnterior.toString()+" por: "+rn.toString()+" satisfactoriamente";
				AppLogger.info("app",log);
				cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log));
				editar = 0;
			}else{//agrega una regla de negocio
				//verifica que el nombre de la regla de negocio no exista en la base de datos
				if(cDAO.consultaRN(nomRegla).size()>0){
					addActionError("El nombre  de la regla de negocio ya se encuentra registrada");
					return INPUT;
				}
				rn = new ReglasNegocio();
				rn.setNomRegla(nomRegla);
				cDAO.guardaObjeto(rn);
				addActionMessage("La regla de negocio se registró satisfactoriamente");
				log = "El usuario: "+(String) session.get("nombreUsuario")+" registró la regla de negocio "+nomRegla+" satisfactoriamente";
				AppLogger.info("app",log);
				cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log));
			}
			
		} catch (JDBCException e) {
			addActionError("Error al guardar la regla de negocio en la base de datos ");
			AppLogger.error("errores","Error al guardar la regla de negocio en la base de datos "+e.getCause());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				lstRN = cDAO.consultaRN(0);
			} catch (JDBCException e) {
				addActionError("Error al conseguir el catálogo de reglas de negocio ");
				AppLogger.error("errores","Error al conseguir el catálogo de reglas de negocio "+e.getCause());
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
				addActionError("Error al conseguir el catálogo de reglas de negocio");
				AppLogger.error("errores","Error al conseguir el catálogo de reglas de negocio, debido a:"+e.getCause());
			}
		}	
		
		return SUCCESS;
	}
	
	/**
	 * Consigue los datos de una regla de negocio por su codRegla
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al conseguir una regla de negocio
	 * @throws Exception  Error al conseguir una regla de negocio
	 */
	public String datosRN(){
		try {
			// Consigue la regla de negocio por el codigo de regla
			rn = cDAO.consultaRN(codRegla).get(0);
		} catch (JDBCException e) {
			addActionError("Error en base de datos al conseguir los datos de la regla de negocio");
			AppLogger.error("errores","Error de base de datos al conseguir los datos de reglas de negocio, debido a:"+e.getCause());
			e.printStackTrace();
		} catch (Exception e) {
			addActionError("Error inesperado al conseguir los datos de la regla de negocio");
			AppLogger.error("errores","Error inesperado al conseguir los datos de reglas de negocio, debido a:"+e.getCause());
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	/**
	 * Elimina reglas de negocio, siempre y cuando no tengan operaciones 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al eliminar la regla de negocio
	 * @throws Exception  Error al eliminar una regla de negocio
	 */	
	public String eliminarRN() throws JDBCException, Exception{
		Utilerias.getResponseISO();
		String idReglasNegocio = "";
		session = ActionContext.getContext().getSession();
		
		try {
			StringTokenizer tokens = new StringTokenizer(selectedItems, ",");		
			 while(tokens.hasMoreTokens()){
				 idReglasNegocio =tokens.nextToken();  
		            if(!idReglasNegocio.equals("-1")){
		            	// Consigue la regla  de negoci por codRegla
						rn = cDAO.consultaRN(Integer.valueOf(idReglasNegocio)).get(0);
						try{
							cDAO.borrarObjeto(rn);
							addActionError("Se eliminó regla de negocio: "+rn.getNomRegla());
							log ="El usuaro: "+(String) session.get("nombreUsuario")+" eliminó la regla de negocio: "+rn.getNomRegla();
							AppLogger.info("app",log);
							cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log));
						}catch (JDBCException e) {
							addActionError("No se pudo borrar la regla de negocio: "+idReglasNegocio);
							AppLogger.error("errores","No se pudo borrar la regla de negocio: "+idReglasNegocio+" por: "+e.getCause());
							e.printStackTrace();
						}
		            }
		            
			 }	

		} catch (Exception e) {
			addActionError("Error al intentar eliminar las regla de negocio ");
			AppLogger.error("errores","Error inesperado al eliminar la regla de negocio");
			e.printStackTrace();
		}finally{
			lstRN = cDAO.consultaRN(0);
		}
		
		return SUCCESS;
	}
		
	public List<ReglasNegocio> getLstRN() {
		return lstRN;
	}

	public void setLstRN(List<ReglasNegocio> lstRN) {
		this.lstRN = lstRN;
	}

	public int getCodRegla() {
		return codRegla;
	}

	public void setCodRegla(int codRegla) {
		this.codRegla = codRegla;
	}

	public String getNomRegla() {
		return nomRegla;
	}

	public void setNomRegla(String nomRegla) throws UnsupportedEncodingException {
		this.nomRegla = Utilerias.convertirISO88591aUTF8(nomRegla);
	}

	public ReglasNegocio getRn() {
		return rn;
	}

	public void setRn(ReglasNegocio rn) {
		this.rn = rn;
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
	
}
