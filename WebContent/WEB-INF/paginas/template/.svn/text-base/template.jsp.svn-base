<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<s:url value="/css/screen.css" />" media="screen, projection" />
<link rel="stylesheet" type="text/css" href="<s:url value="/css/nav-h.css" />" media="screen, projection" />
<link rel="stylesheet" type="text/css" href="<s:url value="/css/calendar-system.css" />" media="screen, projection" />
<link rel="stylesheet" type="text/css" href="<s:url value="/css/custom-theme/jquery-ui-1.8.21.custom.css" />" media="screen, projection" />
<script type="text/javascript" src="<s:url value="/js/jquery-1.7.2.min.js" />"></script>
<script type="text/javascript" src="<s:url value="/js/jquery-ui-1.8.21.custom.min.js" />"></script>
<script type="text/javascript" src="<s:url value="/js/jquery.form.js" />"></script>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>
<script type="text/javascript" language="JavaScript" src="<s:url value="/js/calendar.js" />"></script>
<script type="text/javascript" language="JavaScript" src="<s:url value="/js/calendar-es.js" />"></script>
<script type="text/javascript" language="JavaScript" src="<s:url value="/js/calendar-setup.js" />"></script>

<title>Maxcom</title>
</head>
<body>
	<div id="contenido">
		<s:if test="%{#session.nombreUsuario!=null}" >
			<div id="encabezado">
				<s:include value="/WEB-INF/paginas/template/menu.jsp" />
			</div>
			<div class="clear"></div>
			<div class="session">
				Bienvenido: <strong><s:property value="#session.nombreUsuario" /> (<s:property value="#session.perfil" />)</strong>
			</div>
		</s:if>				  
		<div class="clear"></div>
		<div id="pContenido">
			<tiles:insertAttribute name="body" ignore="true">
			</tiles:insertAttribute>			
		</div>
	</div>
	<div id="espera">
		<div id="img-espera">
			<img class="load" src="<s:url value="/images/ajax-loader.gif" />" />
  		</div>
  		<div id="texto-espera">Espere un momento por favor ...</div>
	</div>
</body>
</html>