<%@taglib uri="/struts-tags" prefix="s"%>
<style type="text/css">
.advertencia{ padding:5px 5px 5px 40px; background-repeat: no-repeat; background-position: 5px center; border:1px solid #DADADA; font-weight:bold; width:55%;  background-image: url(images/warning.gif); border: 1px solid; margin: 20px 0 0 0; color: #9F6000; background-color: #FEEFB3; font-weight: normal; }
h1 { margin: 0 auto;  color: #d31245; font-size:16px; font-weight: bold; font-family:Helvetica; display: inline}
</style>
<h1>P&aacute;gina no disponible</h1>
<%
	
	//Utilerias.enviaNotificacionConexionBD("No fue posible establecer la conexión de la base de datos ");
%>

<div class="advertencia">
	No fue posible establecer la conexi&oacute;n de la base de datos, por favor pongase en contacto con el administrador del sistema
</div>