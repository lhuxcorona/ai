<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>
<s:if test="hasActionErrors()">
  	 <s:include value="/WEB-INF/paginas/template/abrirMensajeDialogo.jsp" />
</s:if>
<div id="dialogo_1"></div>
<fieldset>
		<legend>Perfiles</legend>
		<div><a href="#" onclick="eliminarPerfil();" class="boton" title="Eliminar Perfil" >Eliminar</a></div>
		<table width="100%">
			<tr>
				<th><input id="o1" name="o1" value="-1" type="checkbox" onclick ="chkTodos();" class="check_todos"/></th>
				<th>Perfil</th>
				<th>Descripción</th>
				<th>Permisos</th>
				<th>Editar</th>
			</tr>
			
			<s:iterator value="lstPerfiles" var="resultado"  status="itStatus">
				<tr>
					<td align="center"><input id="itemSelect" name="itemSelect" value="<s:property value="idPerfil"/>" type="checkbox"  class="ck"/></td>
					<td><s:property value="perfil"/></td>
					<td><s:property value="descripcion"/></td>
					<td><a class="botonVerDetalles" href="<s:url value="/administracion/verPermisos?idPerfil=%{idPerfil}" />" target="winload" onclick="window.open(this.href, this.target, 'width=300,height=400,scrollbars=yes'); return false;" title="Permisos"></a></td>
					<td align="center"><center><a href="#" onclick="datosPerfil(<s:property value="idPerfil"/>);" class="editar" title="Editar Perfil" ></a></center></td>
				</tr>
			</s:iterator>
		</table>
</fieldset>