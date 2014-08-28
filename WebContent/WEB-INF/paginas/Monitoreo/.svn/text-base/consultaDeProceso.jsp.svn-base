<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<s:if test="hasActionErrors()">
   <s:include value="/WEB-INF/paginas/template/abrirMensajeDialogo.jsp" />
</s:if>
<div id="dialogo_1"></div>
<s:form action="consultarProceso" onsubmit="return chkCamposProceso();">
<div class="borderBottom"><h1>MONITOREO DE PROCESOS</h1></div><br>
<fieldset class="clear">
	<legend>Criterios de B&uacute;squeda</legend>
	<table width="100%" class="clean">	

		<tr>
			<td><label >Punto de Control:</label></td>
			<td><s:select id="idProceso" name="idProceso" list="lstPuntosDeControl" listKey="idProceso" listValue="%{nomProceso}" headerKey="-1" headerValue="-- Seleccione una opción --" tabindex="0" value="%{}"/></td>
			<td><label >Central:</label></td>
			<td><s:select id="idCentral" name="idCentral" list="lstCentrales" listKey="idCentral" listValue="%{nomCentral}" headerKey="-1" headerValue="-- Seleccione una opción --" tabindex="0" value="%{}"/></td>
		</tr>
		<tr>
			<td><label >Fecha:</label></td>
			<td><s:if test="%{fechaInicio==null}" >
					<s:textfield name="fechaInicio" maxlength="10" size="10" id="fechaInicio" readonly="true" cssClass="dateBox" />
				</s:if>
				<s:else>
					<s:textfield key="fechaInicio" value="%{getText('fecha.log',{fechaInicio})}"    maxlength="10" size="10" id="fechaInicio" readonly="true" cssClass="dateBox" />
				</s:else>
				<img src="../images/calendar.gif" id="trg1" style="cursor: pointer;" alt="Seleccione la fecha" border="0" class="dtalign" title="Seleccione la fecha" />
			</td>
			<td><label >Descripción:</label></td>
			<td><s:textfield label="descripcion" name="descripcion"  id="descripcion"  maxlength="500" size="50"/></td>			
		</tr>		
	</table>
	<div>
	<p><span class="requerido">* Debe capturar el dato o seleccionar al menos una opci&oacute;n</span></p>
	</div>
	<div class="aline"></div>
	
	<div class="accion">	    	
	    <s:submit  value="Consultar Proceso" cssClass="boton2" />
	</div>
</fieldset>
<s:if test="%{bandera==true}">
	<s:if test="lstDeProcesoV.size() > 0">
		<div>
			<div class="exporta_csv"><a href='<s:url value="/monitoreo/reportarProceso?ext=csv"/>' title="Exportar a CSV" ></a></div>
			<div class="exporta_txt"><a href='<s:url value="/monitoreo/reportarProceso?ext=txt"/>' title="Exportar a TXT" ></a></div>
		</div>
		<div class="clear"></div>
		<br/>
		<fieldset>
			<legend>Resultado de Búsqueda</legend>
			<div id="tablaresultados">
				<display:table id="resultados"  name="lstDeProcesoV"  list="lstDeProcesoV"  pagesize="50" sort="list" requestURI="/monitoreo/consultarProceso"  class="displaytag">
					<display:column title="Fecha"  headerClass="sortable" >
						<s:text name="fecha.log"><s:param value="%{#attr.resultados.fecha}"/></s:text>
			 		</display:column>
					<display:column  property="puntoDeControl" title="Punto de Control" />
					<display:column  property="central" title="Central" />
					<display:column  property="descripcion" title="Descripción"/> 
				</display:table>
			</div>
		</fieldset>
	</s:if>
	<s:else><h2>No se encontraron registros con los criterios capturados</h2></s:else>
</s:if>
</s:form>



<script type="text/javascript">
	<!--
	Calendar.setup({
		inputField     :    "fechaInicio",     
		ifFormat       :    "%d/%m/%Y",     
		button         :    "trg1",  
		align          :    "Br",           
		singleClick    :    true
	});

	//-->
</script>

	