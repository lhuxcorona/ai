package com.maxcom.ai.action.catalogos;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import org.hibernate.JDBCException;
import com.maxcom.ai.dao.CatalogosDAO;
import com.maxcom.ai.domain.LogApp;
import com.maxcom.ai.domain.Tarifas;
import com.maxcom.ai.domain.TipoCliente;
import com.maxcom.ai.domain.TipoLlamadas;
import com.maxcom.ai.domain.vistas.TarifasV;
import com.maxcom.ai.log.AppLogger;
import com.maxcom.reproceso.utilerias.Utilerias;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
*TarifasAction.
*Acciones para el catálogo de tarifas (ABC)
*
*Versión 1.0
*
*Septiembre 2012
*
*/
@SuppressWarnings("serial")
public class TarifasAction extends ActionSupport{
	
	private CatalogosDAO cDAO = new CatalogosDAO();
	private int editar;
	private int idTarifa;
	private int tllClave;
	private String costo;
	private String accountCategory;
	private String selectedItems;
	private List<TipoCliente> lstTipoCliente;
	private List<TipoLlamadas> lstTipoLlamadas;
	private List<TarifasV> lstTarifasV;
	private Tarifas tarifa = new Tarifas();
	private String log;
	private Map<String, Object> session;
	private String costoString;
	
	/**
	 * Accion que consulta el catálogo de tarifas, tipo de llamadas y tipo de clientes 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al consultar el catálogo de tarifas
	 * @throws Exception   Error al consultar el catálogo de tarifas
	 */
	public String tarifas(){
		try {
			
			cargaCatTarifasTLlTC();
			tllClave = -1;
						
		} catch (JDBCException e) {
			addActionError("Error al conseguir catálogos "+e.getMessage());
			AppLogger.error("errores", "Ocurrio un error al conseguir catálogos en tarifas "+e.getCause());
			e.printStackTrace();
		} catch (Exception e) {
			addActionError("Error al conseguir catálogos "+e.getMessage());
			AppLogger.error("errores", "Ocurrio un error al conseguir catálogos en tarifas "+e.getCause());
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	/**
	 * Carga los catalogos de tarifas, tipo de llamadas y tipo de clientes 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al consultar el catálogo de tarifas
	 * @throws Exception   Error al consultar el catálogo de tarifas
	 */
	private void cargaCatTarifasTLlTC() throws JDBCException, Exception {
		lstTipoCliente = cDAO.consultaTipoCliente(0);
		lstTipoLlamadas = cDAO.consultaTipoLlamada(0);
		lstTarifasV = cDAO.consultaTarifasV(0);		
	}
	/**
	 * Actualiza o agrega una tarifa
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al actualizar o agregar una tarifa
	 * @throws Exception   Error al actualizar o agregar una tarifa
	 */
	public String agregarEditarTarifa(){
		session = ActionContext.getContext().getSession();
		try {
			
			Utilerias.getResponseISO();
			if(editar == 1){//actualiza una tarifa
				// Consigue la tarifa de negocio por codRegla
				Tarifas tarifaAnterior = null;
				tarifa = cDAO.consultaTarifas(idTarifa).get(0);
				tarifaAnterior = new Tarifas(tarifa);
				//Actualiza valores
				tarifa.setAccountCategory(accountCategory);
				tarifa.setTllClave(tllClave);
				tarifa.setCosto(Double.valueOf(costo));
				
				cDAO.guardaObjeto(tarifa);
				log = "El usuario: "+(String) session.get("nombreUsuario")+" actualizó la tarifa"+tarifaAnterior.toString()+" por: "+tarifa.toString()+" satisfactoriamente";
				addActionMessage("La tarifa se actualizó satisfactoriamente");
				AppLogger.info("app",log);
				cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log));
				editar = 0;
			}else{//agrega una tarifa
				
				tarifa = new Tarifas();
				tarifa.setTllClave(tllClave);
				tarifa.setAccountCategory(accountCategory);
				tarifa.setCosto(Double.valueOf(costo));
				cDAO.guardaObjeto(tarifa);
				log ="El usuario: "+(String) session.get("nombreUsuario")+ " registró la tarifa "+cDAO.consultaTipoCliente(idTarifa).get(0).getDisplayValue()+", "+cDAO.consultaTipoLlamada(idTarifa).get(0).getDescTipoLlamada()+" satisfactoriamente" ;
				addActionMessage("La tarifa se registró satisfactoriamente");
				AppLogger.info("app",log);
				cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log));
			}
			
		} catch (JDBCException e) {
			if(e.getErrorCode()== 1){
				addActionError("El tipo de llamada y el tipo de cliente ya se encuentran registrados");	
			}else{
				addActionError("Ocurrió un error al agregar o editar la tarifa. Favor de informar al administrador ");
			}
			AppLogger.error("errores", "Ocurrio un error al guardar o actualizar la tarifa debido a: "+e.getCause());
			e.printStackTrace();
		} catch (Exception e) {
			addActionError("Error al guardar la tarifa");
			AppLogger.error("errores", "Ocurrio un error inesperado al guardar o actualizar la tarifa "+e.getCause());
			e.printStackTrace();
		}finally{
			try {
				cargaCatTarifasTLlTC();
			} catch (JDBCException e) {
				addActionError("Error al conseguir catálogos ");
				AppLogger.error("errores", "Ocurrio un error al conseguir catálogos en tarifas "+e.getCause());
				e.printStackTrace();
			} catch (Exception e) {
				addActionError("Error al conseguir catálogos  debido a:"+e.getMessage());
				AppLogger.error("errores", "Ocurrio un error al conseguir catálogos en tarifas debido a:"+e.getCause());
				e.printStackTrace();
			}
		}	
		
		return SUCCESS;
	}
	
	/**
	 * Consigue los datos de una tarifa
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al conseguir la tarifa
	 * @throws Exception  Error al conseguir una tarifa
	 */
	public String datosTarifa(){
		try {
			// Consigue la tarifa por id de la tarifa
			tarifa = cDAO.consultaTarifas(idTarifa).get(0);
			
			costoString = formateaNumeroComoCantidad(tarifa.getCosto());
			
			cargaCatTarifasTLlTC();
			
		} catch (JDBCException e) {
			addActionError("Error al conseguir la tarifa debido a:"+e.getMessage());
			AppLogger.error("errores", "Ocurrio un error al conseguir catálogos en tarifas debido a:"+e.getCause());
			e.printStackTrace();
		} catch (Exception e) {
			addActionError("Error al conseguir la tarifa  debido a:"+e.getMessage());
			AppLogger.error("errores", "Ocurrio un error al conseguir la tarifa debido a:"+e.getCause());
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	/**
	 * Elimina tarifas, siempre y cuando no tenga operaciones 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al eliminar la tarifa
	 * @throws Exception  Error al eliminar una tarifa
	 */	
	public String eliminarTarifa() throws JDBCException, Exception{
		Utilerias.getResponseISO();
		String idTarifas = "";
		session = ActionContext.getContext().getSession();
		try {
			StringTokenizer tokens = new StringTokenizer(selectedItems, ",");		
			 while(tokens.hasMoreTokens()){
				 idTarifas = tokens.nextToken();  
		            if(!idTarifas.equals("-1")){
		            	// Consigue la tarifa por id
						tarifa = cDAO.consultaTarifas(Integer.valueOf(idTarifas)).get(0);
						try{
							
							cDAO.borrarObjeto(tarifa);
							addActionError("Se eliminó tarifa: "+idTarifas);
							log = "El usuario: "+(String) session.get("nombreUsuario")+" eliminó tarifa: "+cDAO.consultaTipoCliente(idTarifa).get(0).getDisplayValue()+", "+cDAO.consultaTipoLlamada(idTarifa).get(0).getDescTipoLlamada();
							AppLogger.info("app",log);
							cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log));
						}catch (JDBCException e) {
							addActionError("No se pudo borrar la tarifa: "+idTarifas);
							AppLogger.error("errores", "Ocurrio un error al borrar la tarifa "+idTarifas+"debido a:"+e.getCause());
							e.printStackTrace();
						}
		            }
		            
			 }	

		} catch (Exception e) {
			addActionError("Error al borrar la tarifa: "+idTarifas);
			AppLogger.error("errores", "Ocurrio un error al borrar la tarifa debido a:"+e.getCause());
			e.printStackTrace();
		}finally{
			try {
				cargaCatTarifasTLlTC();
			} catch (JDBCException e) {
				addActionError("Error al conseguir catálogos "+e.getMessage());
				AppLogger.error("errores", "Ocurrio un error al conseguir catálogos en tarifas "+e.getCause());
				e.printStackTrace();
			} catch (Exception e) {
				addActionError("Error al conseguir catálogos  debido a:"+e.getMessage());
				AppLogger.error("errores", "Ocurrio un error al conseguir catálogos en tarifas debido a:"+e.getCause());
				e.printStackTrace();
			}
		}
		
		return SUCCESS;
	}
	
	
	public  String formateaNumeroComoCantidad(double cantidad){
		Locale.setDefault(Locale.ENGLISH);
		return new DecimalFormat("###.00").format(cantidad);
	}
		
	public int getTllClave() {
		return tllClave;
	}
	public void setTllClave(int tllClave) {
		this.tllClave = tllClave;
	}
	public String getAccountCategory() {
		return accountCategory;
	}
	public void setAccountCategory(String accountCategory) {
		this.accountCategory = accountCategory;
	}
	public List<TipoCliente> getLstTipoCliente() {
		return lstTipoCliente;
	}
	public void setLstTipoCliente(List<TipoCliente> lstTipoCliente) {
		this.lstTipoCliente = lstTipoCliente;
	}
	public List<TipoLlamadas> getLstTipoLlamadas() {
		return lstTipoLlamadas;
	}
	public void setLstTipoLlamadas(List<TipoLlamadas> lstTipoLlamadas) {
		this.lstTipoLlamadas = lstTipoLlamadas;
	}
	public List<TarifasV> getLstTarifasV() {
		return lstTarifasV;
	}
	public void setLstTarifasV(List<TarifasV> lstTarifasV) {
		this.lstTarifasV = lstTarifasV;
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
	
	public Tarifas getTarifa() {
		return tarifa;
	}
	public void setTarifa(Tarifas tarifa) {
		this.tarifa = tarifa;
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	public int getIdTarifa() {
		return idTarifa;
	}
	public void setIdTarifa(int idTarifa) {
		this.idTarifa = idTarifa;
	}
	public String getCostoString() {
		return costoString;
	}
	public void setCostoString(String costoString) {
		this.costoString = costoString;
	}
	
	
}
