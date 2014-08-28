<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<s:if test="hasActionErrors()">
   <s:include value="/WEB-INF/paginas/template/abrirMensajeDialogo.jsp" />
</s:if>
<div id="dialogo_1"></div>
<s:form action="consultarLog" onsubmit="return chkCamposLogs();">
<div class="borderBottom"><h1>LOG DE LA APLICACI&Oacute;N</h1></div><br>
<fieldset class="clear">
	<legend>Criterios de B&uacute;squeda</legend>
	<table width="100%" class="clean">	
		<tr>
			<td><label >Fecha de:</label></td>
			<td><s:if test="%{fechaInicio==null}" >
					<s:textfield name="fechaInicio" maxlength="10" size="10" id="fechaInicio" readonly="true" cssClass="dateBox" />
				</s:if>
				<s:else>
					<s:textfield key="fechaInicio" value="%{getText('fecha.log',{fechaInicio})}"    maxlength="10" size="10" id="fechaInicio" readonly="true" cssClass="dateBox" />
				</s:else>
				<img src="../images/calendar.gif" id="trg1" style="cursor: pointer;" alt="Seleccione la fecha" border="0" class="dtalign" title="Seleccione la fecha" />
			</td>
			<td><label > a:</label></td>
			<td><s:if test="%{fechaFin==null}" >
					<s:textfield name="fechaFin" maxlength="10" size="10" id="fechaFin" readonly="true" cssClass="dateBox" />
				</s:if>
				<s:else>
					<s:textfield key="fechaFin" value="%{getText('fecha.log',{fechaFin})}"   maxlength="10" size="10" id="fechaFin" readonly="true" cssClass="dateBox" />
				</s:else>
				<img src="../images/calendar.gif" id="trg2" style="cursor: pointer;" alt="Seleccione la fecha" border="0" class="dtalign" title="Seleccione la fecha" />
			</td>
		</tr>
		<tr>
		    <td><label>Usuario:</label></td>
		    <td><s:select id="idUsuario" name="idUsuario" list="lstUsuariosV" listKey="idUsuario" listValue="%{usuario}" headerKey="-1" headerValue="-- Seleccione una opción --" tabindex="0" value="%{usuario.idUsuario}"/></td>			
			<td><label >Descripción:</label></td>
			<td><s:textfield label="descripcion" name="descripcion"  id="descripcion"  maxlength="500" size="50"/></td>
		</tr>
	</table>
	<div>
	<p><span class="requerido">* Debe capturar el dato o seleccionar al menos una opci&oacute;n</span></p>
	</div>
	<div class="aline"></div>
	
	<div class="accion">	    	
	    <s:submit  value="Consultar Log" cssClass="boton2" />
	</div>
</fieldset>
<s:if test="%{bandera==true}">
	<s:if test="lstLogAppV.size() > 0">
		<div>
			<div class="exporta_csv"><a href='<s:url value="/monitoreo/reportarLog?ext=csv"/>' title="Exportar a CSV" ></a></div>
			<div class="exporta_txt"><a href='<s:url value="/monitoreo/reportarLog?ext=txt"/>' title="Exportar a TXT" ></a></div>
		</div>
		<div class="clear"></div>
		<br/>
		<fieldset>
			<legend>Resultado de Búsqueda</legend>
			<div id="tablaresultados">
				<display:table id="resultados"  name="lstLogAppV"  list="lstLogAppV"  pagesize="50" sort="list" requestURI="/monitoreo/consultarLog"  class="displaytag">
					<display:column  property="id" title="Id" />
					<display:column title="Fecha"  headerClass="sortable" >
						<s:text name="fecha.log"><s:param value="%{#attr.resultados.fecha}"/></s:text>
			 		</display:column>
					<display:column  property="usuario" title="Usuario" />
					<display:column  title="Descripción" class="res_descripcion"><s:property value="%{#attr.resultados.descripcion}"/><div class="tooltip"><s:property value="%{#attr.resultados.completa}"/></div> </display:column>
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
	
	Calendar.setup({
		inputField     :    "fechaFin",     
		ifFormat       :    "%d/%m/%Y",     
		button         :    "trg2",  
		align          :    "Br",           
		singleClick    :    true
		});
	//-->
</script>

	