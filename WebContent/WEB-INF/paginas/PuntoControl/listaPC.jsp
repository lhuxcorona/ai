<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>
<s:if test="hasActionErrors()">
  	 <s:include value="/WEB-INF/paginas/template/abrirMensajeDialogo.jsp" />
</s:if>
<div id="dialogo_1"></div>
<fieldset>
	<legend>Puntos de Control</legend>
	<div><a href="#" onclick="eliminarPC();" class="boton" title="Eliminar Punto de Control" >Eliminar</a></div>
	<table width="100%">
		<tr>
			<th><input id="o1" name="o1" value="-1" type="checkbox" onclick ="chkTodos();" class="check_todos"/></th>
			<th>Id</th>
			<th>Punto de Control</th>
			<th>Umbral (%)</th>
			<th>Editar</th>
		</tr>
		<s:iterator value="lstPC" var="resultado"  status="itStatus">
			<tr>
				<td align="center"><input id="idDestinatarios" name="itemSelect" value="<s:property value="idProceso"/>" type="checkbox"  class="ck"/></td>
				<td align="center"><s:property value="idProceso"/></td>
				<td><s:property value="nomProceso"/></td>
				<td align="center"><s:text name="porcentaje"><s:param value="%{umbral}"/></s:text></td>
				<td align="center"><center><a href="#" onclick="datosPC(<s:property value="idProceso"/>);" class="editar" title="Editar Punto de Control" ></a></center></td>
			</tr>
		</s:iterator>
	</table>
</fieldset>