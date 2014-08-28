package com.maxcom.ai.log;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet encargado de la inicializacion de log4j, usando el archivo log4j.lcf
 * 
 *
 */
@SuppressWarnings("serial")
public class Log4jInitServlet extends HttpServlet {

	public void init() {
			String prefix = getServletContext().getRealPath("/");
			String file = getInitParameter("log4j-init-file");
	
			if (file != null) {
				PropertyConfigurator.configure(prefix + file);
			}
			// Iniciar bitacoras
			AppLogger.setLogger("app", Logger.getLogger("app"));
			AppLogger.setLogger("errores", Logger.getLogger("errores"));
			
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) {
	}
}