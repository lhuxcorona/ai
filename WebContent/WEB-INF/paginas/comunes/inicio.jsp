
<%@taglib uri="/struts-tags" prefix="s"%>
<s:if test="%{#session.nombreUsuario!=null }" >
	<div id="bienvenida">
		<label class="label2">Aseguramiento de Ingresos</label> 
	</div>
</s:if>
