package com.maxcom.reproceso.utilerias;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Properties;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.maxcom.ai.excepcion.RutinaExcepcion;


/**
*Utilerias
*
*Clase encargada de utilidades comunes en las demás clases, tales como envio de correo, consulta de parámetros, entre otros.
*
*Versión 1.0
*
*Mayo 2012
*
*/
public class Utilerias implements ServletResponseAware {
		private static HttpServletResponse response;
		
		/**
		 *   
		 * Settea la respuesta a ISO-8859-1, para la parte de caracteres especiales
		 * 
		 * 
		 */
		public static void getResponseISO(){
			response = ServletActionContext.getResponse();
			response.setContentType("text; charset=ISO-8859-1");
		}

		public static String separadorRuta(String path){
			return !path.endsWith(File.separator)? path + File.separator : path; 
		}	
		
		/**
		 *   
		 * Metodo encargado de consultar los parametros de configuración
		 * 
		 * @param parametro 
		 * @throws RutinaExcepcion Si ocurre un error al devolver el archivo
		 * @throws IOException Error al leer el archivo
		 */
		public String conseguirParametroConf(String parametro, String rutaArchivoConf){
			String valor="";
			Properties prop = new Properties();
	    	FileInputStream fis=null;
	    	
	    	File f = new File( rutaArchivoConf );
	    	try {
				fis = new FileInputStream(f);
				prop.load(fis);
		        for (Enumeration<?> e = prop.keys(); e.hasMoreElements() ; ) {
		            Object obj = e.nextElement();
		            if(parametro.equals(obj.toString())){
		            	valor=prop.getProperty(obj.toString());
		            }
		        }
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}finally{
				try {				 
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return valor;
		}

		public void setServletResponse(HttpServletResponse arg0) {
			// TODO Auto-generated method stub
			
		}

		
		/**
		 * Metodo encargado de convertir caracteres especialeas  de ISO-8859-1 a UTF-8
		 * 	  
		 * @throws FileNotFoundException Archivo no encontrasdo
		 * @throws IOException   Error en lectura del archivo 
		 */
		public static String convertirISO88591aUTF8(String texto) throws UnsupportedEncodingException{
			
			String textoConvertido="";
			String var=new String(texto);
			byte[] arrByte = var.getBytes("ISO-8859-1");
			textoConvertido = new String(arrByte, "UTF-8");
			  
			return textoConvertido;
		}

		/**
		 *  Devuelve el archivo, serializandolo para entregarlo al usuario 
		 *   
		 * @param log objeto que se guarda en la base de datos
		 * @throws RutinaExcepcion Si ocurre un error al devolver el archivo
		 * @throws IOException Error al leer el archivo
		 * @throws RutinaExcepcion Si ocurre un error al devolver el archivo
		 * @throws FileNotFoundException Error al conseguir el archivo
		 * 
		 */
		public static void devolverArchivo(String ruta, String nombreArchivo, String mimeType) throws RutinaExcepcion, IOException {
			// Configurar respuesta al usuario
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/"+mimeType); 
			response.setHeader("Content-Disposition", "attachment; filename="+nombreArchivo);
			InputStream in = null;
			OutputStream out = response.getOutputStream();
			try {	
				in = new BufferedInputStream(new FileInputStream(ruta+nombreArchivo));
				byte[] buf = new byte[4 * 1024]; 
				int bytesRead;
				while ((bytesRead = in.read(buf)) != -1) {
					out.write(buf, 0, bytesRead);
				}	
			}catch (FileNotFoundException e) {
				e.printStackTrace();
				throw new RutinaExcepcion("El archivo a devolver no se encuentra");
			} catch (IOException e) {
				e.printStackTrace();
				throw new RutinaExcepcion("Error al devolver el archivo");
			}finally {
				out.flush();
				out.close();
				if (in != null)
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
						throw new RutinaExcepcion("Error al cerrar el archivo");
					}	
			}		
		}
	
		
}
