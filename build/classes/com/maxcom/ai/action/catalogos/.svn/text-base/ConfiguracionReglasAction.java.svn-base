package com.maxcom.ai.action.catalogos;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.hibernate.JDBCException;
import com.maxcom.ai.dao.CatalogosDAO;
import com.maxcom.ai.domain.Centrales;
import com.maxcom.ai.domain.LogApp;
import com.maxcom.ai.domain.MapeoReglas;
import com.maxcom.ai.domain.PuntosDeControl;
import com.maxcom.ai.domain.ReglasNegocio;
import com.maxcom.ai.domain.vistas.MapeoReglasV;
import com.maxcom.ai.log.AppLogger;
import com.maxcom.reproceso.utilerias.Utilerias;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
*ConfiguracionReglasAction.
*Acciones para los accesos al sistema "Aseguramiento de Ingresos"
*
*Versión 1.0
*
*Septiembre 2012
*
*/
@SuppressWarnings("serial")
public class ConfiguracionReglasAction extends ActionSupport{
	
	private CatalogosDAO cDAO = new CatalogosDAO();
	
	private int editar;
	private int idCentral;
	private int idProceso;
	private int idRegla;
	private String codRegla;
	private String selectedItems;
	private List<MapeoReglasV> lstMapeoReglasV;
	private List<Centrales> lstCentrales;
	private List<PuntosDeControl> lstPuntosControl;
	private List<ReglasNegocio> lstReglasNegocio;
	private MapeoReglas mapeoReglas;
	private int idMapeoRegla;
	private String log;
	private Map<String, Object> session;	
	
	
	/**
	 * Consulta el catalogo de mapeo de reglas. 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al consultar el catalogo de mapeo de reglas 
	 * @throws Exception  Error inesperado al consultar el catálogo de mapeo de reglas
	 */
	public String configuracionReglas(){
		try {
			//Consulta la vista de mapeo_archivos_v
			lstMapeoReglasV = cDAO.consultaMapeoReglasV(0);
			
		} catch (JDBCException e) {
			addActionError("Error al conseguir el catálogo de mapeo de reglas ");
			AppLogger.error("errores","Error al conseguir el catálogo de mapeo de reglas "+e.getCause() );
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			AppLogger.error("errores","Error inesperado al conseguir el catálogo de mapeo de reglas "+e.getCause() );
			addActionError("Error inesperado al conseguir el catálogo de mapeo de reglas ");
		}
				
		return SUCCESS;
	}
	

	/**
	 * Recupera los catalogos de centrales, reglas de negocio y puntos de control 
	 * 
	 * @throws JDBCException Si ocurre un error de base de datos al consultar los catálogos
	 * @throws Exception  Error inesperado al consultar el catálogo de mapeo de reglas 
	 */
	private void recuperaCatalogos() throws Exception, JDBCException{
		lstCentrales = cDAO.consultaCentrales(0); 
		lstPuntosControl = cDAO.consultaPC(0);
		lstReglasNegocio = cDAO.consultaRN(0);
	}

	
	/**
	 * Actualiza o agrega una configuracion de regla 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al actualizar o agregar una configuración de reglas 
	 * @throws Exception   Error inesperado al actualizar o agregar una configuración de regla
	 */
	public String agregarEditarConfReglas(){
		Utilerias.getResponseISO();	
		session = ActionContext.getContext().getSession();
		try {
			//validando el campo de la condición "codRegla"
			String query  = "select * from formato_unico_adi where rownum < 2 and "+codRegla;
			
			cDAO.consultaEnCrudo(query);
			
			
			if(editar == 1){ //edición de configuración de reglas de negocio
				MapeoReglas mapeoReglasAnterior = null;
				mapeoReglas = cDAO.consultaMapeoReglas(idMapeoRegla).get(0); 
				mapeoReglasAnterior = new MapeoReglas(mapeoReglas);
				mapeoReglas.setIdCentral(idCentral);
				mapeoReglas.setIdProceso(idProceso);
				mapeoReglas.setIdRegla(idRegla);
				mapeoReglas.setCodRegla(codRegla);
				
				cDAO.guardaObjeto(mapeoReglas);		
				addActionMessage("Se actualizó satisfactoriamente la configuración");
				log ="El usuario: "+(String) session.get("nombreUsuario")+ " actualizó"+mapeoReglasAnterior.toString()+" por: "+mapeoReglas.toString()+" satisfactoriamente la configuracion";
				AppLogger.info("app",log);
				cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log));
			}else{//agregar configuración de reglas de negocio
				String idCentrales = "";
				boolean error = false;
				StringTokenizer tokens = new StringTokenizer(selectedItems, ",");		
				 while(tokens.hasMoreTokens()){
					 idCentrales = tokens.nextToken();  
			            if(!idCentrales.equals("-1")){
			            	//guarda el objeto de mapeo de reglas por cada id central seleccionada por el usuario
							try{
								mapeoReglas = new MapeoReglas();
								mapeoReglas.setIdCentral(Integer.valueOf(idCentrales));
								mapeoReglas.setIdProceso(idProceso);
								mapeoReglas.setIdRegla(idRegla);
								mapeoReglas.setCodRegla(codRegla);
								cDAO.guardaObjeto(mapeoReglas);								
								
							}catch (JDBCException e) {
								if(e.getErrorCode() == 1){
									addActionError("No se guardó la configuración de reglas: [Configuracion capturada]"
											+cDAO.consultaRN(idRegla).get(0).getNomRegla()+" - "
											+cDAO.consultaPC(idProceso).get(0).getNomProceso()+" - "+ cDAO.consultaCentrales(Integer.valueOf(idCentrales)).get(0).getNomCentral());
										
								}else{
									addActionError("Ocurrió un error al agregar la configuración, favor de informar al administrador");
								}
								error = true;
								e.printStackTrace();
								log="No se guardó la configuración de reglas: "
									+cDAO.consultaRN(idRegla).get(0).getNomRegla()+" - "
									+cDAO.consultaPC(idProceso).get(0).getNomProceso()+" - "+ cDAO.consultaCentrales(Integer.valueOf(idCentrales)).get(0).getNomCentral()
									+" debido a:"+e.getCause();
								AppLogger.error("errores",log);
							}
			            }			            
				 }
				 
				 if(!error){
						addActionMessage("Se guardarón satisfactoriamente las configuraciones");
						log = "El usuario"+(String) session.get("nombreUsuario")+" guardo satisfactoriamente las configuraciones"+cDAO.consultaPC(idProceso).get(0).getNomProceso()+", "+cDAO.consultaCentrales(Integer.valueOf(idCentral)).get(0).getNomCentral()+", "+cDAO.consultaRN(idRegla).get(0).getNomRegla();
						AppLogger.info("app",log);
						cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log));
				}
			}
			
		} catch (JDBCException e) {
			try {
				if(e.getErrorCode() == 1){
					addActionError("No es posible actualizar los datos, ya se encuentran registrados en otra configuración, favor de verificar");
				    AppLogger.error("errores","No es posible actualizar los datos, ya se encuentran registrados en otra configuración, favor de verificar"+e.getCause());
				}else if(e.getErrorCode() == 920){
					addActionError("La condición es inválida, favor de verificar");
					AppLogger.error("errores","La condición es inválida, favor de verificar"+e.getCause());
				}else{
					addActionError("Ocurrió un error al actualizar la configuración, favor de informar al administrador");
				}
				
				if(editar == 0){
					mapeoReglas = new MapeoReglas();
					mapeoReglas.setCodRegla(codRegla);
					mapeoReglas.setIdProceso(idProceso);
					mapeoReglas.setIdRegla(idRegla);
				}else{
					mapeoReglas = cDAO.consultaMapeoReglas(idMapeoRegla).get(0); 
				}
				recuperaCatalogos();
			} catch (Exception e1) {
				addActionError("Ocurrió un error al recuperar los catálogos de puntos de control, centrales y reglas de negocio");
				AppLogger.error("errores","Ocurrió un error al recuperar los catálogos de puntos de control, centrales y reglas de negocio"+e.getCause());
				e1.printStackTrace();
			}
			return INPUT;			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{					
			try{
				recuperaCatalogos();
				lstMapeoReglasV = cDAO.consultaMapeoReglasV(0);
			} catch (JDBCException e) {
				addActionError("Error al conseguir el catálogo de centrales ");
				AppLogger.error("errores", "Error al conseguir el catálogo de centrales "+e.getCause());
				e.printStackTrace();
			} catch (Exception e) {
				addActionError("Error al conseguir el catálogo de centrales");
				AppLogger.error("errores", "Error al conseguir el catálogo de centrales "+e.getCause());
				e.printStackTrace();
			}
		}	
		
		return SUCCESS;
	}
	
	/**
	 * Consigue los datos de un mapeo de reglas por id, así como la recuperación de catálogos de reglas de negocio, puntos de control y centrales 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al conseguir los datos del mapeo de reglas
	 * @throws Exception  Error inesperado al conseguir los datos de mapeo de reglas 
	 */
	public String datosMapeoReglas() {
		Utilerias.getResponseISO();	
		try {
			if(editar == 1){
				mapeoReglas = cDAO.consultaMapeoReglas(idMapeoRegla).get(0);	
			}
			
			recuperaCatalogos();
		} catch (JDBCException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return SUCCESS;
	}

	/**
	 * Elimina las configuraciones de reglas seleccionadas por el usuario, siempre y cuando no tenga operaciones ni relaciones en la base de datos
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al eliminar una configuración de regla
	 * @throws Exception  Error al eliminar una configuración de regla
	 */
	public String eliminarConfReglas(){
		Utilerias.getResponseISO();		
		String idMapeoRegla = "";
		session = ActionContext.getContext().getSession();
		try {
			StringTokenizer tokens = new StringTokenizer(selectedItems, ",");		
			while(tokens.hasMoreTokens()){
				idMapeoRegla = tokens.nextToken();  
		            if(!idMapeoRegla.equals("-1")){
		            	// Consigue el punto de control de acuerdo al idProceso
		            	mapeoReglas = cDAO.consultaMapeoReglas(Integer.valueOf(idMapeoRegla)).get(0);
						try{
							log = "El usuario "+(String) session.get("nombreUsuario")+" eliminó configuración de regla: "+cDAO.consultaPC(idProceso).get(0).getNomProceso()+", "+cDAO.consultaCentrales(Integer.valueOf(idCentral)).get(0).getNomCentral()+", "+cDAO.consultaRN(idRegla).get(0).getNomRegla();
							cDAO.borrarObjeto(mapeoReglas);
							addActionError("Se eliminó configuración de regla: "+idMapeoRegla); 
							AppLogger.info("app",log);
							cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log));
						}catch (JDBCException e) {
							addActionError("No fue posible borrar la configuración de regla: "+idMapeoRegla);
							AppLogger.error("errores","No fue posible borrar la configuración de regla: "+idMapeoRegla+" por: "+ e.getCause());
							e.printStackTrace();
						}
		            }       
			 }	
		} catch (Exception e) {
			e.printStackTrace();
			AppLogger.error("errores","Error al eliminar una configuración de reglas, debido a: "+e.getCause());
		}finally{
			try{
				//Consulta la vista de mapeo_archivos_v
				lstMapeoReglasV = cDAO.consultaMapeoReglasV(0);
			}catch(JDBCException e){
				addActionError("No se pudo conseguir la lista de configuración de reglas");
				AppLogger.error("errores","No se pudo conseguir la lista de configuración de reglas"+e.getCause());
			}
			
		}
		return SUCCESS;
	}
		
	public int getEditar() {
		return editar;
	}

	public void setEditar(int editar) {
		this.editar = editar;
	}

	public int getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}
	
	public int getIdCentral() {
		return idCentral;
	}

	public void setIdCentral(int idCentral) {
		this.idCentral = idCentral;
	}

	public int getIdRegla() {
		return idRegla;
	}

	public void setIdRegla(int idRegla) {
		this.idRegla = idRegla;
		
	}

	public String getCodRegla() {
		return codRegla;
	}


	public void setCodRegla(String codRegla) throws UnsupportedEncodingException {
		this.codRegla = Utilerias.convertirISO88591aUTF8(codRegla);
	}


	public String getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(String selectedItems) {
		this.selectedItems = selectedItems;
	}

	public List<MapeoReglasV> getLstMapeoReglasV() {
		return lstMapeoReglasV;
	}

	public void setLstMapeoReglasV(List<MapeoReglasV> lstMapeoReglasV) {
		this.lstMapeoReglasV = lstMapeoReglasV;
	}

	public List<Centrales> getLstCentrales() {
		return lstCentrales;
	}

	public void setLstCentrales(List<Centrales> lstCentrales) {
		this.lstCentrales = lstCentrales;
	}

	public List<PuntosDeControl> getLstPuntosControl() {
		return lstPuntosControl;
	}

	public void setLstPuntosControl(List<PuntosDeControl> lstPuntosControl) {
		this.lstPuntosControl = lstPuntosControl;
	}

	public List<ReglasNegocio> getLstReglasNegocio() {
		return lstReglasNegocio;
	}

	public void setLstReglasNegocio(List<ReglasNegocio> lstReglasNegocio) {
		this.lstReglasNegocio = lstReglasNegocio;
	}
	
	public MapeoReglas getMapeoReglas() {
		return mapeoReglas;
	}

	public void setMapeoReglas(MapeoReglas mapeoReglas) {
		this.mapeoReglas = mapeoReglas;
	}


	public int getIdMapeoRegla() {
		return idMapeoRegla;
	}

	public void setIdMapeoRegla(int idMapeoRegla) {
		this.idMapeoRegla = idMapeoRegla;
	}	
	
}
