<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>
<s:if test="hasActionErrors()">
  	 <s:include value="/WEB-INF/paginas/template/abrirMensajeDialogo.jsp" />
</s:if>
<div id="dialogo_1"></div>
<s:if test="lstUsuariosV.size() > 0">
	<fieldset>
		<legend>Usuarios</legend>
		<div><a href="#" onclick="eliminarUsuario();" class="boton" title="Eliminar Usuario" >Eliminar</a></div>		
		<table width="100%">
			<tr>
				<th><input id="o1" name="o1" value="-1" type="checkbox" onclick ="chkTodos();" class="check_todos"/></th>
				<th>Nombre Completo</th>
				<th>Perfil</th>
				<th>Usuario</th>
				<th>Contraseña</th>				
				<th>Email</th>
				<th>Editar</th>
			</tr>
			<s:iterator value="lstUsuariosV" var="resultado"  status="itStatus">
				<tr>
					<td align="center"><input id="" name="itemSelect" value="<s:property value="idUsuario"/>" type="checkbox"  class="ck"/></td>
					<td><s:property value="nombre"/>&nbsp;<s:property value="paterno"/>&nbsp;<s:property value="materno"/></td>
					<td><s:property value="perfil"/></td>
					<td><s:property value="usuario"/></td>
					<td><s:property value="password"/></td>
					<td><s:property value="email"/></td>
					<td align="center"><center><a href="#" onclick="datosUsuario(<s:property value="idUsuario"/>);" class="editar" title="Editar Usuario" ></a></center></td>
				</tr>
			</s:iterator>
			</table>
	</fieldset>
</s:if>