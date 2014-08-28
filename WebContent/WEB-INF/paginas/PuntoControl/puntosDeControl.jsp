<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>
<div class="mensajesApp" id="mensajesApp"><s:actionmessage /></div>
<div id="agregarEditar">
	<s:include value="/WEB-INF/paginas/PuntoControl/agregarEditarPC.jsp" />
</div>
<div id="listaPuntoControl">
	<s:include value="/WEB-INF/paginas/PuntoControl/listaPC.jsp" />
</div>
