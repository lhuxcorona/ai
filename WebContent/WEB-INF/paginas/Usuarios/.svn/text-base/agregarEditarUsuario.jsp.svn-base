<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>
<div class="borderBottom"><h1>USUARIOS</h1></div><br>
<fieldset id="" class="">
	<legend><s:if test="%{editar == 1}">Actualizar</s:if><s:else>Agregar</s:else> Usuario</legend>
	<div class="clear"></div>
	<div>
		 <label class="left1"><span class="requerido">*</span>Nombre:</label>
		 <s:textfield id="nombre" name="nombre" maxlength="30" size="50"  value="%{usuario.nombre}"/>
	</div>
	<div class="clear"></div>
	<div>
		 <label class="left1"><span class="requerido">*</span>Apellido Paterno:</label>
		 <s:textfield id="paterno" name="paterno" maxlength="30" size="50"  value="%{usuario.paterno}"/>
	</div>
	<div class="clear"></div>
	<div>
		 <label class="left1"><span class="norequerido">*</span>Apellido Materno:</label>
		 <s:textfield id="materno" name="materno" maxlength="30" size="50"  value="%{usuario.materno}"/>
	</div>
	<div class="clear"></div>
	<div>
		 <label class="left1"><span class="requerido">*</span>Email:</label>
		 <s:textfield id="email" name="email" maxlength="60" size="50"  value="%{usuario.email}"/>
	</div>
	<div class="clear"></div>
	<div>
		 <div><label class="left1"><span class="requerido">*</span>Usuario:</label></div>
		 <div class="formulario"><s:textfield id="nomUsuario" name="nomUsuario" maxlength="20" size="50"  value="%{usuario.usuario}"/></div>
		 <div class="ayuda_g"><a href="#" ></a><div class="tooltip">Es el nombre de usuario con el que accederá a la aplicación. </div></div>
	</div>
	<div class="clear"></div>
	<div>
		 <div><label class="left1"><span class="requerido">*</span>Contraseña:</label></div>
		 <div class="formulario"><s:textfield id="contrasenia" name="contrasenia" maxlength="20" size="50"  value="%{usuario.password}"/></div>
		 <div class="ayuda_g"><a href="#" ></a><div class="tooltip">Es la contraseña con el que accederá a la aplicación.</div></div>
	</div>
	<div class="clear"></div>
	<div>
		 <label class="left1"><span class="requerido">*</span>Perfil:</label>
		 <s:select id="idPerfil" name="idPerfil" list="lstPerfiles" listKey="idPerfil" listValue="%{perfil}" headerKey="-1" headerValue="-- Seleccione una opción --" tabindex="0" value="%{usuario.idPerfil}"/>
	</div>
	<div class="clear"></div>
	<div class="accion">
		<s:if test="%{editar == 1}">
			<s:hidden name="idUsuario" id="idUsuario" value="%{idUsuario}"/>
			<a href="#" class="boton" title="Actualizar " onclick="agregarEditarUsuario(1);">Actualizar Usuario</a>
			<a href="<s:url value="/administracion/usuarios"/>" class="boton" title="Cancelar" >Cancelar Operaci&oacute;n</a>
		</s:if>
		<s:else>
			<a href="#" class="boton" title="Agregar " onclick="agregarEditarUsuario(0);">Agregar Usuario</a>
		</s:else>
	</div>
</fieldset>
