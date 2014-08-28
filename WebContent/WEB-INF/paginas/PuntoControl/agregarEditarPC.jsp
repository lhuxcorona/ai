<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>
<div class="borderBottom"><h1>PUNTOS DE CONTROL</h1></div><br>
<fieldset id="" class="clear">	
	<legend><s:if test="%{editar == 1}">Actualizar</s:if><s:else>Agregar</s:else> Punto de Control</legend>
	<div>
		 <label class="left1"><span class="requerido">*</span>Nombre del Punto de Control:</label>
		 <s:textfield id="puntoControl" name="puntoControl" maxlength="60" size="50"  value="%{pc.nomProceso}"/>	 
	</div>
	<div>
	 	<label class="left1"><span class="norequerido">*</span>Umbral:</label>
		<s:if test="%{editar == 1}" >
			<s:textfield id="umbral" name="umbral" maxlength="5" size="50"  value="%{pc.umbral}"/>
		</s:if>
		<s:else>
		 	<s:textfield id="umbral" name="umbral" maxlength="5" size="50"  value="%{1.0}"/>
		</s:else>	
	</div>
	<div class="accion">
		<s:if test="%{editar == 1}" >
			<s:hidden name="idProceso" id="idProceso" value="%{idProceso}"/>
			<a href="#" class="boton" title="Actualizar " onclick="agregarEditarPC(1);">Actualizar Punto de Control</a>
			<a href="<s:url value="/catalogos/puntosDeControl"/>" class="boton" title="Cancelar" >Cancelar Operaci&oacute;n</a>						
		</s:if>
		<s:else>
			<a href="#" class="boton" title="Agregar " onclick="agregarEditarPC(0);">Agregar Punto de Control</a>
		</s:else>
	</div>
</fieldset>


