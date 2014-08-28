package com.maxcom.ai.interceptor;

/**
*SessionInterceptor
*
* Inteceptor encargada de verificar la session de usuario para los diferentes
* móludos que la implementen.
* 
*
*Versión 1.0
*
*Mayo 2012
*
*/
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
@SuppressWarnings("serial")
public class SessionInterceptor extends AbstractInterceptor  {

	
	public String intercept(ActionInvocation invocation) throws Exception {

		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession(true);
		
		String  nombreUsuario = (String)session.getAttribute("nombreUsuario");
		
		
		if(nombreUsuario!=null && !StringUtils.isEmpty(nombreUsuario)){
			return invocation.invoke();
		}
			
		
		return "session";
	}

}
