package com.maxcom.ai.action.catalogos;

import java.io.UnsupportedEncodingException;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.hibernate.JDBCException;
import com.maxcom.ai.dao.CatalogosDAO;
import com.maxcom.ai.domain.LogApp;
import com.maxcom.ai.domain.PuntosDeControl;
import com.maxcom.ai.log.AppLogger;
import com.maxcom.reproceso.utilerias.Utilerias;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
*PuntoControlAction.
*Acciones para el catálogo de Puntos de Control (ABC)
*
*Versión 1.0
*
*Septiembre 2012
*
*/  
@SuppressWarnings("serial")
public class PuntoControlAction extends ActionSupport{
	
	private CatalogosDAO cDAO = new CatalogosDAO();
	private List<PuntosDeControl> lstPC;
	private int editar;
	private int idProceso;
	private double umbral;
	private String puntoControl;
	private PuntosDeControl pc = new PuntosDeControl();
	private String selectedItems;
	private String log;
	private Map<String, Object> session;	
	
	/**
	 * Consulta el catálogo de puntos de control. 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al consultar el catálogo de puntos de control 
	 * @throws Exception   Error al consultar un punto de control
	 */
	public String puntosDeControl(){
		try {
			
			lstPC = cDAO.consultaPC(0);
			pc.setUmbral((double) 1);
			
		} catch (JDBCException e) {
			addActionError("Error al conseguir el catálogo de puntos de control ");
			AppLogger.error("errores","Error al conseguir el catálogo de puntos de control "+e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			AppLogger.error("errores","Error inesperado al conseguir el catálogo de puntos de control, debido a: "+e.getCause());
			addActionError("Error inesperado al conseguir el catálogo de puntos de control "+e.getMessage());
			e.printStackTrace();
		}
				
		return SUCCESS;
	}
	
	/**
	 * Actualiza o agrega un punto de control en la tabla de puntos_de_control
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al actualizar o agregar un punto de control
	 * @throws Exception   Error al actualizar o agregar un punto de control
	 */
	public String agregarEditarPC(){
		session = ActionContext.getContext().getSession();
		PuntosDeControl pcAnterior = null;
		try {
			Utilerias.getResponseISO();
			if(editar == 1){//actualiza un punto de control
				
				// Consigue el punto de control de acuerdo al idProceso
				pc = cDAO.consultaPC(idProceso).get(0);
				pcAnterior = new PuntosDeControl(pc);
				if(!pc.getNomProceso().equals(puntoControl)){
					if(cDAO.consultaPC(puntoControl).size()>0){
						addActionError("El nombre del punto de control ya se encuentra registrado en la base de datos");
						AppLogger.error("errores","El nombre del punto de control ya se encuentra registrado en la base de datos");
						editar = 1;
						return INPUT;
					}
				}
				pc.setNomProceso(puntoControl);
				pc.setUmbral(umbral);
				cDAO.guardaObjeto(pc);
				addActionMessage("El punto de control se actualizó satisfactoriamente");
				log ="El usuario: "+(String) session.get("nombreUsuario")+" actualizó el punto de control "+pcAnterior.toString()+" por "+pc.toString()+" satisfactoriamente";
				AppLogger.info("app",log);
				cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log));
				editar = 0;
			}else{//agrega un punto de control
				//verifica que el nombre del punto de control no exista en la base de datos
				if(cDAO.consultaPC(puntoControl).size()>0){
					addActionError("El nombre del punto de control ya se encuentra registrado");
					return INPUT;
				}
				pc = new PuntosDeControl();
				pc.setNomProceso(puntoControl);
				pc.setUmbral(umbral);
				cDAO.guardaObjeto(pc);
				addActionMessage("El punto de control se registró satisfactoriamente");
				String nombrePC = pc.getNomProceso();
				log ="El usuario: "+(String) session.get("nombreUsuario")+" registró el punto de control "+nombrePC+" satisfactoriamente";
				AppLogger.info("app",log);
				cDAO.guardaObjeto(new LogApp(new Date(), (Integer) session.get("idUsuario") , log));
				
			}
			
		} catch (JDBCException e) {
			addActionError("Error al guardar el punto de control en la base de datos, favor de informar al administrador del sistema ");
			AppLogger.error("errores","Error al guardar el punto de control en la base de datos, debido a "+e.getCause());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			AppLogger.error("errores","Error inesperado al actualizar o agregar el punto de control, debido a "+e.getCause());
		}finally{
			try {
				lstPC = cDAO.consultaPC(0);
			} catch (JDBCException e) {
				addActionError("Error al conseguir el catálogo de puntos de control ");
				AppLogger.error("errores","Error al conseguir el catálogo de puntos de control "+e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				AppLogger.error("errores","Error inesperado al conseguir el catálogo de puntos de control "+e.getMessage());
				e.printStackTrace();
			}
		}	
		
		return SUCCESS;
	}
	/**
	 * Consigue los datos de un punto de control por su idProceso 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al conseguir un punto de control
	 * @throws Exception  Error inesperado al conseguir un punto de control
	 */
	public String datosPC(){
		try {
			// Consigue el punto de control de acuerdo al idProceso
			pc = cDAO.consultaPC(idProceso).get(0);
		} catch (JDBCException e) {
			AppLogger.error("errores","Error al conseguir el punto de control, debido a:"+e.getCause());
			addActionError("Error al conseguir los datos del punto de control");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			AppLogger.error("errores","Error inesperado al conseguir el punto de control, debido a:"+e.getCause());
			addActionError("Error al conseguir los datos del punto de control");
		}
		
		return SUCCESS;
	}

	/**
	 * Elimina puntos de control, siempre y cuando no tenga operaciones 
	 *  
	 * @throws JDBCException Si ocurre un error de base de datos al eliminar un punto de control
	 * @throws Exception  Error al eliminar un punto de control
	 */
	public String eliminarPC() throws JDBCException, Exception{
		Utilerias.getResponseISO();
		String idPuntosControl = "";
		session = ActionContext.getContext().getSession();
		
		try {
			StringTokenizer tokens = new StringTokenizer(selectedItems, ",");		
			 while(tokens.hasMoreTokens()){
				 idPuntosControl = tokens.nextToken();  
		            if(!idPuntosControl.equals("-1")){
		            	// Consigue el punto de control de acuerdo al idProceso
						pc = cDAO.consultaPC(Integer.valueOf(idPuntosControl)).get(0);
						try{
							log="El usuario: "+(String) session.get("nombreUsuario")+" eliminó el punto de control: "+pc.getNomProceso();
							cDAO.borrarObjeto(pc);
							addActionError("Se eliminó el punto de control: "+pc.getNomProceso());
							AppLogger.info("app",log);
							cDAO.guardaObjeto(new LogApp(new Date(), (Integer)session.get("idUsuario") , log));
						}catch (JDBCException e) {
							addActionError("No se pudo borrar el punto de control: "+idPuntosControl);
							AppLogger.error("errores","No se pudo borrar el punto de control: "+idPuntosControl);
							e.printStackTrace();
						}
		            }
		            
			 }	

		} catch (Exception e) {
			e.printStackTrace();
			AppLogger.error("errores","Ocurrió un error debido a: "+e.getCause() );
		}finally{
			lstPC = cDAO.consultaPC(0);
		}
		
		return SUCCESS;
	}
	
	public int getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}

	public double getUmbral() {
		return umbral;
	}

	public void setUmbral(double umbral) {
		this.umbral = umbral;
	}

	public List<PuntosDeControl> getLstPC() {
		return lstPC;
	}

	public void setLstPC(List<PuntosDeControl> lstPC) {
		this.lstPC = lstPC;
	}

	public int getEditar() {
		return editar;
	}

	public void setEditar(int editar) {
		this.editar = editar;
	}

	public String getPuntoControl(){
		return puntoControl;
	}

	public void setPuntoControl(String puntoControl) throws UnsupportedEncodingException {
		this.puntoControl = Utilerias.convertirISO88591aUTF8(puntoControl);
	}

	public PuntosDeControl getPc() {
		return pc;
	}

	public void setPc(PuntosDeControl pc) {
		this.pc = pc;
	}

	public String getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(String selectedItems) {
		this.selectedItems = selectedItems;
	}	
	
}
