package com.maxcom.ai.action.catalogos;

import java.io.UnsupportedEncodingException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.hibernate.JDBCException;
import com.maxcom.ai.dao.CatalogosDAO;
import com.maxcom.ai.domain.Centrales;
import com.maxcom.ai.domain.LogApp;
import com.maxcom.ai.domain.MapeoArchivos;
import com.maxcom.ai.domain.ReglasNegocio;
import com.maxcom.ai.domain.TipoCodificacion;
import com.maxcom.ai.domain.vistas.CentralesV;
import com.maxcom.ai.log.AppLogger;
import com.maxcom.reproceso.utilerias.Utilerias;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
*CentralesAction.
*Acciones para  el catálogo de Centrales (ABC)
*
*Versión 1.0
*
*Septiembre 2012
*
*/
@SuppressWarnings("serial")
public class CentralesAction extends ActionSupport{
	
	private CatalogosDAO cDAO = new CatalogosDAO();
	private List<CentralesV> lstCentralesV;
	private List<TipoCodificacion> lstTipoCodificacion;
	private List<MapeoArchivos> lstMapeoArchivos;
	private CentralesV centralV = new CentralesV();
	private Centrales central = new Centrales();
	private int editar;
	private int borrarInhabilitar;
	private int codRegla;
	private int idCentral;
	private int idProceso;
	private String nomRegla;
	private ReglasNegocio rn = new ReglasNegocio();
	private String selectedItems;
	private String nomArchivoCtl;
	private String nomCentral;
	private String dirAcceso;
	private String sqlInsert;
	private String sqlSelect;
	private int claveCodificacion;
	private String activo;
	private String nomTablaCrudo;
	private String nomTablaFormato;
	private Integer numCampos;
	private int numCamposAnterior;
	private String log;
	private Map<String, Object> session;
	
	/**
	 * Consulta el catálogo de centrales
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al consultar el catálogo de centrales
	 * @throws Exception   Error al consultar el catálogo de centrales
	 */
	public String centrales(){
		try {
			//Consulta el catalogo de centrales			
			consultaCatalogos();
			
		} catch (JDBCException e) {
			addActionError("Error al conseguir el catálogo de reglas de negocio.");
			AppLogger.error("errores","Ocurrió un error al conseguir los catálogos de reglas de negocio debido a: " +e.getCause() );
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return SUCCESS;
	}
	
	/**
	 * Consulta el catálogo de centrales y la lista del tipo de codificacion
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al consultar el catálogo de centrales
	 * @throws Exception   Error al consultar el catálogo de centrales
	 */
	private void consultaCatalogos() throws JDBCException, Exception {
		lstCentralesV = cDAO.consultaCentralesV(0);
		lstTipoCodificacion = cDAO.consultaTipoCodificacion(0);
	}


	/**
	 * Consulta una central por id, para ver el detalle, así mismo
	 * si el tipo de codificacion es por "archivo de control" consigue 
	 * el mapeo de archivo de dicha central 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al consultar el catálogo de centrales
	 * @throws Exception   Error al consultar el catálogo de centrales
	 */
	public String detalleCentral(){
		try {
			//Consulta la central por idCentral
			centralV = cDAO.consultaCentralesV(idCentral).get(0);
			if(centralV.getCveCodificacion().equals("3")){
				lstMapeoArchivos = cDAO.consultaMapeoArchivos(0, idCentral); //consulta el mapeo de archivo por id_central		
			}			
		} catch (JDBCException e) {
			addActionError("Error al conseguir el detalle de la central ");
			AppLogger.error("errores","Ocurrió un error de base de datos al conseguir el detalle de la central debido a: " +e.getCause() );
			e.printStackTrace();
		} catch (Exception e) {
			addActionError("Error al conseguir el detalle de la central ");
			AppLogger.error("errores","Ocurrió un error inesperado al conseguir el detalle de la central debido a: " +e.getCause() );
			e.printStackTrace();
		}	
		return SUCCESS;
	}
	
	
	/**
	 * Agrega campos de acuerdo al numero de campos que capture el usuario en el mapeo de archivos. Para el caso de edición, si el tipo de codificación en la
	 * central es "archivo de control", el calculo para agregar campos depende de numCamposAnteriores vs numCampos
	 *  
	 * @throws Exception   Error al consultar el catálogo de centrales
	 */
	public String insertaCampos(){
		session = ActionContext.getContext().getSession();
		try {
			lstMapeoArchivos = new ArrayList<MapeoArchivos>();
			if(editar ==1){
				//Consigue el mapeo de archivo de la central en cuestión(id_central)
				lstMapeoArchivos = cDAO.consultaMapeoArchivos(0, idCentral);
				if(numCampos > numCamposAnterior){//
					int resta = 0;
					resta = numCampos - numCamposAnterior;
					for(int i = 1; i<=resta; i++){ //se agregan a la lista de  los valores del mapeo que actualmente tiene la central + los que determine el usuario
						lstMapeoArchivos.add(new MapeoArchivos());
					}
				}else if(numCampos < numCamposAnterior){//si el numCampos es menor a los que  actualmente tiene la central 
					List<MapeoArchivos> lstMapeoArchivosTmp = new ArrayList<MapeoArchivos>();
					for (int i=1; i<=numCampos; i++){
						lstMapeoArchivosTmp.add(lstMapeoArchivos.get(i-1));
					}
					lstMapeoArchivos = new ArrayList<MapeoArchivos>();
					lstMapeoArchivos = lstMapeoArchivosTmp;
				}				
			}else{
				//Accion cuando se agrega nueva central 
				for(int i=1; i<=numCampos; i++){
					lstMapeoArchivos.add(new MapeoArchivos());
				}
			}
									
		} catch (Exception e) {
			AppLogger.error("errores", "ocurrio un error en el metodo insertaCampos "+e.getCause());
			addActionError("Error al insertar los campos ");
		}	
		return SUCCESS;
	}
	
	
	/**
	 * Actualiza o agrega una central 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al actualizar o agregar una central
	 * @throws Exception   Error inesperado al actualizar o agregar una central
	 */
	public String agregarEditarCentral(){
		
		try {
			Utilerias.getResponseISO();
			
			session = ActionContext.getContext().getSession();
			String query  = "select * from "+nomTablaCrudo+" where rownum < 2";
			/*validando que las tabla de carga en crudo exista en la base de datos */
			cDAO.consultaEnCrudo(query);			
			/* Validando los campos de origen "sqlSelect" VS la tabla de carga en crudo*/
			try{
				query = "select "+sqlSelect+ " from "+nomTablaCrudo+" where rownum < 2";
				cDAO.consultaEnCrudo(query);			
			}catch (JDBCException e) {		
				addActionError("Error al ejecutar la consulta con los campos de origen de la tabla de carga en crudo, por favor verifica los datos");	
				AppLogger.error("errores","Error al ejecutar la consulta con los campos de origen de la tabla de carga en crudo, por favor verifica los datos"+e.getCause());
				central = new Centrales(nomCentral, dirAcceso, nomTablaCrudo, nomTablaFormato, sqlInsert, sqlSelect, claveCodificacion);
				return INPUT;
			}
			
			/*Validando los campos de origen "sqlInsert" VS la tabla de formato único*/
			try{				
				query = "select "+sqlInsert+ " from "+nomTablaFormato+" where rownum < 2";
				cDAO.consultaEnCrudo(query);			
			}catch (JDBCException e) {		
				addActionError("Error al ejecutar la consulta con los campos de destino de la tabla de formato único, por favor verifica los datos");	
				AppLogger.error("errores","Error al ejecutar la consulta con los campos de destino de la tabla de formato único, por favor verifica los datos"+e.getCause());
				central = new Centrales(nomCentral, dirAcceso, nomTablaCrudo, nomTablaFormato, sqlInsert, sqlSelect, claveCodificacion);
				return INPUT;
			}
						
			if(editar == 1){//actualiza central
				//consigue la central que el usuario quiere actualizar
				Centrales centralAnterior = null;
				central = cDAO.consultaCentrales(idCentral).get(0);
				centralAnterior = new Centrales(central);
				guardarCentral();
				editar = 0;
				addActionMessage("La central se actualizó satisfactoriamente");
				log= "El usuario: "+(String) session.get("nombreUsuario")+" actualizó la central "+centralAnterior.toString()+ " por: "+central.toString()+" satisfactoriamente";
				AppLogger.info("app",log);
				cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log.length()>500?log.substring(0, 500):log));
				central = new Centrales();
				
			}else{//agrega una central
				central = new Centrales();
				guardarCentral();				
				addActionMessage("La central se registró satisfactoriamente");
				log= "El usuario: "+(String) session.get("nombreUsuario")+" registró la central "+nomCentral+" satisfactoriamente";
				AppLogger.info("app",log);
				cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log.length()>500?log.substring(0, 500):log));
				central = new Centrales();
			}
						
		} catch (JDBCException e) {		
			if(e.getErrorCode() == 942){
				addActionError("No existe la tabla \""+nomTablaCrudo +"\" en la base de datos, favor de verificar");
				AppLogger.error("errores","No existe la tabla \""+nomTablaCrudo +"\" en la base de datos, favor de verificar"+e.getCause());
			}else if(e.getErrorCode() == 1) {
				addActionError("El nombre de la central ya se encuentra registrada");	
			}else{
				addActionError("Ocurrió un error al agregar o editar la central, Favor de informar al administrador");
			}
			central = new Centrales(nomCentral, dirAcceso, nomTablaCrudo, nomTablaFormato, sqlInsert, sqlSelect, claveCodificacion);
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{					
			try {
				consultaCatalogos();
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
	 * Guarda  o actualiza en base de datos el objeto central
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al actualizar o agregar una central
	 * @throws Exception   Error al actualizar o agregar una central
	 */
	private void guardarCentral() throws JDBCException, Exception {
		String longitud = "";
		int i = 1;
		central.setActivo(activo);
		central.setCtlArchivo(nomArchivoCtl);
		central.setCveCodificacion(claveCodificacion);
		central.setDirAcceso(dirAcceso);
		central.setNomCentral(nomCentral);
		central.setNomTablaCrudo(nomTablaCrudo);
		central.setNomTablaFormato(nomTablaFormato);
		central.setSqlInsert(sqlInsert);
		central.setSqlSelect(sqlSelect);
		if(claveCodificacion == 3){
			//si es edicion y el tipo de codificacion es "Archivo de control", eliminar el de la 
			//base de datos el mapeo actual de la central
			if(editar == 1){
				cDAO.borraMapeoArchivos(idCentral);
			}
			central.setMapeoArchivos(new HashSet<MapeoArchivos>());
			StringTokenizer tokens = new StringTokenizer(selectedItems, ","); 
			while(tokens.hasMoreTokens()){
				longitud = tokens.nextToken();
				MapeoArchivos m = new MapeoArchivos();
				m.setLongitud(Integer.parseInt(longitud));
				m.setNomCampo("Campo "+i);
				m.setPosicion(i);
				central.getMapeoArchivos().add(m);
				i++;
			}
		}
		
		cDAO.guardaObjeto(central);

		
	}

	/**
	 * Consigue los datos de una central por id_central, si el tipo de codificacion es "archivo de control", consigue 
	 * el mapeo de archivos de la misma.
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al conseguir los datos de la central
	 * @throws Exception   Error al conseguir los datos de una central
	 */
	public String datosCentral(){
		Utilerias.getResponseISO();
		try {						
			// Consigue la central por id de la central
			central = cDAO.consultaCentrales(idCentral).get(0);
			lstTipoCodificacion = cDAO.consultaTipoCodificacion(0);		
			if(central.getCveCodificacion()== 3){
				lstMapeoArchivos = cDAO.consultaMapeoArchivos(0, idCentral);
				numCamposAnterior = lstMapeoArchivos.size();
				
			}
			
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
	 * Elimina o Inhabilita una central
	 * 
	 * @throws JDBCException Si ocurre un error de base de datos al eliminar o inhabilita una central
	 * @throws Exception   Error al consultar el catálogo de centrales
	 */
	public String eliminarInhabilitarCentral(){
		try {
			Utilerias.getResponseISO();
			session = ActionContext.getContext().getSession();
			central = cDAO.consultaCentrales(Integer.valueOf(idCentral)).get(0);
			nomCentral = central.getNomCentral();
			if(borrarInhabilitar == 1){
				//se inhabilita la central poniendo activo = 0 en la base de datos
				central.setActivo("0");
				cDAO.guardaObjeto(central);
				addActionError("La central \""+nomCentral+"\" se inhabilitó satisfactoriamente");
				log= "El usuario: "+(String) session.get("nombreUsuario")+" inhabilito la central "+nomCentral +" satisfactoriamente";
				AppLogger.info("app",log);
				cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log));
			}else if (borrarInhabilitar == 0){
				try{
					//se borra fisicamente de la base de datos
					session = ActionContext.getContext().getSession();
					cDAO.borrarObjeto(central);
					addActionError("La central \""+nomCentral+"\" se borró satisfactoriamente");
					log= "El usuario: "+(String) session.get("nombreUsuario")+" borró la central "+nomCentral+" satisfactoriamente";
					AppLogger.info("app",log);
					cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log));
					central = new Centrales();
				}catch (JDBCException e) {
					addActionError("No se pudo borrar la central: "+idCentral);
					AppLogger.error("errores", "Ocurrio un error al borrar la central "+idCentral+"debido a:"+e.getCause());
					e.printStackTrace();
				}
			}else {
				//se habilita la central poniendo activo = 1 en la base de datos
				central.setActivo("1");
				cDAO.guardaObjeto(central);
				addActionError("La central \""+nomCentral+"\" se habilitó satisfactoriamente");
				log= "El usuario: "+(String) session.get("nombreUsuario")+" habilitó la central "+nomCentral +" satisfactoriamente";
				AppLogger.info("app",log);
				cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log));
			}
			lstCentralesV = cDAO.consultaCentralesV(0);
		} catch (JDBCException e) {
			addActionError("Error al conseguir la lista de tipo de codificación");
			AppLogger.error("errores", "Ocurrio un error al conseguir la lista de tipo de codificación debido a:"+e.getCause());
			e.printStackTrace();
		} catch (Exception e) {
			addActionError("Error al conseguir la lista del tipo de codificación");
			AppLogger.error("errores", "Ocurrio un error al conseguir la lista del tipo de codificación debido a:"+e.getCause());
			e.printStackTrace();
		}
		return SUCCESS;
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

	public int getBorrarInhabilitar() {
		return borrarInhabilitar;
	}


	public void setBorrarInhabilitar(int borrarInhabilitar) {
		this.borrarInhabilitar = borrarInhabilitar;
	}


	public String getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(String selectedItems) {
		this.selectedItems = selectedItems;
	}
	public List<CentralesV> getLstCentralesV() {
		return lstCentralesV;
	}
	public void setLstCentralesV(List<CentralesV> lstCentralesV) {
		this.lstCentralesV = lstCentralesV;
	}
	
	public List<TipoCodificacion> getLstTipoCodificacion() {
		return lstTipoCodificacion;
	}
	public void setLstTipoCodificacion(List<TipoCodificacion> lstTipoCodificacion) {
		this.lstTipoCodificacion = lstTipoCodificacion;
	}
	public CentralesV getCentralV() {
		return centralV;
	}
	public void setCentralV(CentralesV centralV) {
		this.centralV = centralV;
	}
	public int getIdCentral() {
		return idCentral;
	}
	public void setIdCentral(int idCentral) {
		this.idCentral = idCentral;
	}
	public int getIdProceso() {
		return idProceso;
	}
	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}
	public String getNomArchivoCtl() {
		return nomArchivoCtl;
	}
	public void setNomArchivoCtl(String nomArchivoCtl) {
		this.nomArchivoCtl = nomArchivoCtl;
	}
	public String getNomCentral() {
		return nomCentral;
	}
	public void setNomCentral(String nomCentral) {
		this.nomCentral = nomCentral;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Centrales getCentral() {
		return central;
	}
	public void setCentral(Centrales central) {
		this.central = central;
	}
	public String getDirAcceso() {
		return dirAcceso;
	}
	public void setDirAcceso(String dirAcceso) {
		this.dirAcceso = dirAcceso;
	}
	public String getSqlInsert() {
		return sqlInsert;
	}
	public void setSqlInsert(String sqlInsert) {
		this.sqlInsert = sqlInsert;
	}
	public String getSqlSelect() {
		return sqlSelect;
	}
	public void setSqlSelect(String sqlSelect) {
		this.sqlSelect = sqlSelect;
	}
	
	
	public int getClaveCodificacion() {
		return claveCodificacion;
	}


	public void setClaveCodificacion(int claveCodificacion) {
		this.claveCodificacion = claveCodificacion;
	}

	public String getNomTablaCrudo() {
		return nomTablaCrudo;
	}
	public void setNomTablaCrudo(String nomTablaCrudo) {
		this.nomTablaCrudo = nomTablaCrudo;
	}
	public String getNomTablaFormato() {
		return nomTablaFormato;
	}
	public void setNomTablaFormato(String nomTablaFormato) {
		this.nomTablaFormato = nomTablaFormato;
	}

	public List<MapeoArchivos> getLstMapeoArchivos() {
		return lstMapeoArchivos;
	}

	public void setLstMapeoArchivos(List<MapeoArchivos> lstMapeoArchivos) {
		this.lstMapeoArchivos = lstMapeoArchivos;
	}


	public int getNumCamposAnterior() {
		return numCamposAnterior;
	}

	public void setNumCamposAnterior(int numCamposAnterior) {
		this.numCamposAnterior = numCamposAnterior;
	}
	
	public Integer getNumCampos() {
		return numCampos;
	}

	public void setNumCampos(Integer numCampos) {
		this.numCampos = numCampos;
	}	
}
