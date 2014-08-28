<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>
<div class="mensajesApp" id="mensajesApp"><s:actionmessage /></div>
<div id="agregarEditarPerfil">
	<s:include value="/WEB-INF/paginas/Perfiles/agregarEditarPerfil.jsp" />
</div>
<div id="listaPerfiles">
	<s:include value="/WEB-INF/paginas/Perfiles/listaPerfil.jsp" />
</div>