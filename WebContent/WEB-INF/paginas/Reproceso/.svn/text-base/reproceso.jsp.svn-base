<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>
<div class="mensajesApp" id="mensajesApp"><s:actionmessage /></div>
<s:if test="hasActionErrors()">
  	 <s:include value="/WEB-INF/paginas/template/abrirMensajeDialogo.jsp" />
</s:if>
<div id="dialogo_1"></div>	
<s:form action="ejecutaReproceso" onsubmit="return chkCamposReproceso();">
<div class="borderBottom"><h1>RE-PROCESO</h1></div><br>
<fieldset class ="clear">
	<legend>Re-proceso</legend>
	<div>		
		 <label class="left1"><span class="requerido">*</span>Central:</label>
		 <s:select id="idCentral" name="idCentral" list="lstCentrales" listKey="idCentral" listValue="%{nomCentral}" headerKey="-1" headerValue="-- Seleccione la central --" tabindex="0"  onchange="limpiarMsg();"/>
	</div>
	<div class="accion">
		<s:submit value="Re-procesar"  cssClass="boton2"  id="" onclick=""/>
	</div>
</fieldset>
</s:form>