<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>

<div class="borderBottom"><h1>REGLAS DE NEGOCIO</h1></div><br>
<fieldset id="" class="clear">	
	<legend><s:if test="%{editar == 1}">Actualizar</s:if><s:else>Agregar</s:else> Regla de Negocio</legend>
	<div>
		<label class="left1"><span class="requerido">*</span>Nombre de la Regla:</label>
		<s:textfield id="nomRegla" name="nomRegla" maxlength="60" size="50"  value="%{rn.nomRegla}"/>
	</div>
	<div class="accion">
		<s:if test="%{editar == 1}" >
			<s:hidden name="codRegla" id="codRegla" value="%{codRegla}"/>
			<a href="#" class="boton" title="Actualizar " onclick="agregarEditarRN(1);">Actualizar Regla de Negocio</a>
			<a href="<s:url value="/catalogos/reglasNegocio"/>" class="boton" title="Cancelar" >Cancelar Operaci&oacute;n</a>
		</s:if>
		<s:else>
			<a href="#" class="boton" title="Agregar " onclick="agregarEditarRN(0);">Agregar Regla de Negocio</a>
		</s:else>
	</div>
</fieldset>


