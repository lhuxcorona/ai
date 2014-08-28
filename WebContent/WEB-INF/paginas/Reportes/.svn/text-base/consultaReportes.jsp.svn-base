<%@taglib uri="/struts-tags" prefix="s"%>
<s:if test="hasActionErrors()">
  	 <s:include value="/WEB-INF/paginas/template/abrirMensajeDialogo.jsp" />
</s:if>
<div id="dialogo_1"></div>
<s:form action="generarReporte" onsubmit="return chkCamposReporte();">
	<div class="borderBottom"><h1>CONSULTA DE REPORTES</h1></div><br>
	<fieldset class="prestador">
		<legend>Criterios del Reporte</legend>
		<table width="100%" class="clean">	
			<tr>
				<td><label><span class="requerido">*</span>Punto de Control:</label></td>
				<td>
					 <s:select id="idProceso" name="idProceso" list="lstPC" listKey="idProceso" listValue="%{nomProceso}" headerKey="-1" headerValue="-- Seleccione una opción --" tabindex="0" value="%{}"/>
			    </td>
				<td><label >Central:</label></td>
				<td><s:select id="idCentral" name="idCentral" list="lstCentrales" listKey="idCentral" listValue="%{nomCentral}" headerKey="-1" headerValue="-- Seleccione una opción --" tabindex="0" value="%{}"/></td>
			</tr>
			<tr>
				<td><label >Fecha Inicio:</label></td>
				<td><s:if test="%{fechaInicio==null}" >
						<s:textfield name="fechaInicio" maxlength="10" size="10" id="fechaInicio" readonly="true" cssClass="dateBox" />
					</s:if>
					<s:else>
						<s:textfield key="fechaInicio" value=""   maxlength="10" size="10" id="fechaInicio" readonly="true" cssClass="dateBox" />
					</s:else>
					<img src="../images/calendar.gif" id="trg1" style="cursor: pointer;" alt="Seleccione la fecha" border="0" class="dtalign" title="Seleccione la fecha" />
				</td>
				<td><label > Fecha Fin:</label></td>
				<td><s:if test="%{fechaFin==null}" >
						<s:textfield name="fechaFin" maxlength="10" size="10" id="fechaFin" readonly="true" cssClass="dateBox" />
					</s:if>
					<s:else>
						<s:textfield key="fechaFin" value=""   maxlength="10" size="10" id="fechaFin" readonly="true" cssClass="dateBox" />
					</s:else>
					<img src="../images/calendar.gif" id="trg2" style="cursor: pointer;" alt="Seleccione la fecha" border="0" class="dtalign" title="Seleccione la fecha" />
				</td>
			</tr>
			<tr>
				<td><label><span class="requerido">*</span>Nombre de Reporte:</label></td>
				<td colspan="3"><s:select id="idReporte" name="idReporte" list="lstReportes" listKey="idReporte" listValue="%{nomReporte}" headerKey="-1" headerValue="-- Seleccione una opción --" tabindex="0" value="%{}"/></td>
			</tr>
		</table>
		<div class="accion">
		 	<s:submit value="Consultar Reporte" cssClass="boton2" />
		</div>
	</fieldset>
	
<s:if test="%{bandera==true}">
	<s:if test="lstReportesGeneradosV.size() > 0">
		<fieldset>
			<legend>Resultado de Búsqueda</legend>
			<table width="100%" class="clean">	
				<tr>
					<td><label >Reporte:</label></td>
					<td>
						<strong><s:property value="nomReporte"/></strong>
				    </td>
				</tr>
				<tr>
					<td><label >Punto de Control:</label></td>
					<td>
						<strong><s:property value="nomProceso"/></strong>
				    </td>
				</tr>
				<s:if test="%{(nomCentral!=null && nomCentral!='')}">
					<tr>
						<td><label >Central:</label></td>
						<td><strong><s:property value="nomCentral"/></strong></td>
					</tr>
				</s:if>
				<s:if test="%{fechaInicio!=null}">
					<tr>
						<td><label >Fecha Inicio:</label></td>
						<td><strong><s:property value="fechaInicio"/></strong></td>
					</tr>
				</s:if>
				<s:if test="%{fechaFin!=null}">
					<tr>
						<td><label>Fecha Fin:</label></td>
						<td><strong><s:property value="fechaFin"/></strong></td>
					</tr>
				</s:if>
			</table>
			<div>
				<div class="exporta_csv"><a href='<s:url value="/reportes/generarReporteTxtCsv?ext=csv"/>' title="Exportar a CSV" ></a></div>
				<div class="exporta_txt"><a href=<s:url value="/reportes/generarReporteTxtCsv?ext=txt"/>' title="Exportar a TXT" ></a></div>
				<s:if test="%{grafica==true}">
					<div class="grafica">
						<a  href="<s:url value="/reportes/generarGrafica?tipoGrafica=ColumnChart" />" target="winload" onclick="window.open(this.href, this.target, 'width=600,height=400,scrollbars=yes'); return false;" title="Gráfica"></a>
					</div>
				</s:if> 
			</div>
			<table width="100%">
				<tr>
					<s:iterator value="lstEncDetalle" var="resultado"  status="itStatus">
						<th><s:property/></th>		
					</s:iterator>
				</tr>
				<s:set name="tmEncDetalle"><s:property value="lstEncDetalle.size()"/></s:set>
				<s:set name="tmDetalle"><s:property value="lstDetalle.size()"/></s:set>
				<s:set var="i" value="%{1}" />
				<s:iterator value="lstDetalle" var="resultado"  status="itStatus">
					<s:if test='#i == 1'>
						<tr>
					</s:if>	
					<td><s:property/></td>
					<s:if test='#i == #tmEncDetalle'>
						</tr>
						<s:set var="i" value="%{0}" />		
					</s:if>	
					<s:set var="i" value="%{#i+1}" />				
				</s:iterator>
				<s:if test='#tmDetalle%#tmEncDetalle != 0'>
					</tr>		
				</s:if>				
			</table>
			<table class="clean">
				<s:iterator status="stat" value="totales" status="it">
					<tr>
						<th class="clean" align="right"><s:property value="key"/>:</th>
						<td ><s:property value="value"/></td>
					</tr>
				</s:iterator>
			</table>
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