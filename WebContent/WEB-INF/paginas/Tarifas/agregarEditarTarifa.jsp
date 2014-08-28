<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>

<div class="borderBottom"><h1>TARIFAS</h1></div><br>
<fieldset id="" class="clear">	
	<legend><s:if test="%{editar == 1}">Actualizar</s:if><s:else>Agregar</s:else> Tarifa</legend>
	<div>
		<label class="left1"><span class="requerido">*</span>Tipo llamada:</label>
		<s:select id="tllClave" name="tllClave" list="lstTipoLlamadas" listKey="tllClave" listValue="%{descTipoLlamada}" headerKey="-1" headerValue="-- Seleccione el Tipo Llamada --" tabindex="0" value="%{tarifa.tllClave}"/>
	</div>
	<div>
		<label class="left1"><span class="requerido">*</span>Tipo cliente:</label>
		<s:select id="accountCategory" name="accountCategory" list="lstTipoCliente" listKey="accountCategory" listValue="%{displayValue + ' - ' + clasificacion }" headerKey="-1" headerValue="-- Seleccione el Tipo Cliente --" tabindex="0" value="%{tarifa.accountCategory}"/>
	</div>
	<div>
	 	<label class="left1"><span class="requerido">*</span>Costo:</label>
		<s:textfield id="costo" name="costo" maxlength="100" size="50"  value="%{costoString}"/>
	</div>
	<div class="accion">
		<s:if test="%{editar == 1}">
			<s:hidden name="idTarifa" id="idTarifa" value="%{idTarifa}"/>
			<a href="#" class="boton" title="Actualizar " onclick="agregarEditarTarifa(1);">Actualizar Tarifa</a>
			<a href="<s:url value="/catalogos/tarifas"/>" class="boton" title="Cancelar" >Cancelar Operaci&oacute;n</a>
		</s:if>
		<s:else>
			<a href="#" class="boton" title="Agregar " onclick="agregarEditarTarifa(0);">Agregar Tarifa</a>
		</s:else>
	</div>
</fieldset>


