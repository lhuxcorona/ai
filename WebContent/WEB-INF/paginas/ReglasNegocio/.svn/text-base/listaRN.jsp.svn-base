<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>
<s:if test="hasActionErrors()">
  	 <s:include value="/WEB-INF/paginas/template/abrirMensajeDialogo.jsp" />
</s:if>
<div id="dialogo_1"></div>
<fieldset>
	<legend>Reglas de Negocio</legend>
	<div><a href="#" onclick="eliminarRN();" class="boton" title="Eliminar Regla de Negocio" >Eliminar</a></div>
	<table width="100%">
		<tr>
			<th><input id="o1" name="o1" value="-1" type="checkbox" onclick ="chkTodos();" class="check_todos"/></th>
			<th>Id</th>
			<th>Regla de Negocio</th>
			<th>Editar</th>
		</tr>
		<s:iterator value="lstRN" var="resultado"  status="itStatus">
			<tr>
				<td align="center"><input id="" name="itemSelect" value="<s:property value="codRegla"/>" type="checkbox"  class="ck"/></td>
				<td align="center"><s:property value="codRegla"/></td>
				<td><s:property value="nomRegla"/></td>
				<td align="center"><center><a href="#" onclick="datosRN(<s:property value="codRegla"/>);" class="editar" title="Editar Regla de Negocio" ></a></center></td>
			</tr>
		</s:iterator>
	</table>
</fieldset>