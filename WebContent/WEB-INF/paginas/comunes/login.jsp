<%@ taglib uri="/struts-tags" prefix="s"%>
<s:if test="hasActionErrors()">
  	 <s:include value="/WEB-INF/paginas/template/abrirMensajeDialogo.jsp" />
</s:if>
<div id="dialogo_1"></div>	
<s:if test="%{#session.nombreUsuario == null }" >
	<div id="login">
		<h1>Bienvenido</h1>
		<s:form name="forma" action="acceso" id="frmLog" onsubmit="return chkCamposLogin();">
				<label>Usuario:</label>
				<s:textfield name="nombreUsuario" maxlength="20" size="20" id="nombreUsuario" />
				
				<label>Contraseña:</label>
				<s:password name="password" maxlength="20" size="20" id="password"/>
			<br/>
			<br/>
			<div>
				<s:submit value="Entrar"  id="button"  cssClass="boton2" />
			</div>	
		</s:form>
	</div>
</s:if>

