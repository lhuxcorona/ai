<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>
<s:if test="hasActionErrors()">
  	 <s:include value="/WEB-INF/paginas/template/abrirMensajeDialogo.jsp" />
</s:if>
<div id="dialogo_1"></div>
<fieldset>
	<legend>Reportes</legend>		
	<div><a href="#" onclick="eliminarReporte();" class="boton" title="Eliminar Reporte" >Eliminar</a></div>
	<table width="100%">
		<tr>
			<th><input id="o1" name="o1" value="-1" type="checkbox" onclick ="chkTodos();" class="check_todos"/></th>
			<th>Reporte</th>
			<th>Punto de Control</th>
			<th>Detalle</th>
			<th>Editar</th>
		</tr>
		<s:iterator value="lstReportesV" var="resultado"  status="itStatus">
			<tr>
				<td align="center"><input id="idDestinatarios" name="itemSelect" value="<s:property value="idReporte"/>" type="checkbox"  class="ck"/></td>
				<td><s:property value="nomReporte"/></td>
				<td><s:property value="nomProceso"/></td>
				<td><a class="botonVerDetalles" href="<s:url value="/reportes/detalleReporte?idReporte=%{idReporte}" />" target="winload" onclick="window.open(this.href, this.target, 'width=600,height=400,scrollbars=yes'); return false;" title="Detalle del Reporte"></a></td>
				<td align="center"><center><a href="#" onclick="datosReporte(<s:property value="idReporte"/>);" class="editar" title="Editar Reporte" ></a></center></td>
			</tr>
		</s:iterator>
	</table>
</fieldset>