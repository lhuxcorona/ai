<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>
<div class="mensajesApp" id="mensajesApp"><s:actionmessage /></div>
<div id="agregarEditarRN">
	<s:include value="/WEB-INF/paginas/ReglasNegocio/agregarEditarRN.jsp" />
</div>
<div id="listaReglasNegocio">
	<s:include value="/WEB-INF/paginas/ReglasNegocio/listaRN.jsp" />
</div>
