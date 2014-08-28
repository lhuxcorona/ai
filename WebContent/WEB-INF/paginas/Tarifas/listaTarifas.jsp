<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>
<s:if test="hasActionErrors()">
  	 <s:include value="/WEB-INF/paginas/template/abrirMensajeDialogo.jsp" />
</s:if>
<div id="dialogo_1"></div>
<s:if test="lstTarifasV.size() > 0">
	<fieldset>
		<legend>Tarifas</legend>
		<div><a href="#" onclick="eliminarTarifa();" class="boton" title="Eliminar Regla de Negocio" >Eliminar</a></div>
		<table width="100%">
			<tr>
				<th><input id="o1" name="o1" value="-1" type="checkbox" onclick ="chkTodos();" class="check_todos"/></th>
				<th>Id</th>
				<th>Tipo Llamada</th>
				<th>Tipo Cliente</th>
				<th>Costo</th>
				<th>Editar</th>
			</tr>
			<s:iterator value="lstTarifasV" var="resultado"  status="itStatus">
				<tr>
					<td align="center"><input id="" name="itemSelect" value="<s:property value="idTarifa"/>" type="checkbox"  class="ck"/></td>
					<td align="center"><s:property value="idTarifa"/></td>
					<td><s:property value="desTipoLlamada"/></td>
					<td><s:property value="displayValue"/> - <s:property value="clasificacionCliente"/></td>
					<td><s:text name="porcentaje"><s:param value="%{costo}"/></s:text></td>
					<td align="center"><center><a href="#" onclick="datosTarifa(<s:property value="idTarifa"/>);" class="editar" title="Editar Tarifa" ></a></center></td>
				</tr>
			</s:iterator>
		</table>
	</fieldset>
</s:if>
<s:else>
	<h2>No se encontraron tarifas registradas</h2>
</s:else>
