<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>
<div class="mensajesApp" id="mensajesApp"><s:actionmessage /></div>
<div id="agregarEditarUsuario">
	<s:include value="/WEB-INF/paginas/Usuarios/agregarEditarUsuario.jsp" />
</div>
<div id="listaUsuarios">
	<s:include value="/WEB-INF/paginas/Usuarios/listaUsuarios.jsp" />
</div>