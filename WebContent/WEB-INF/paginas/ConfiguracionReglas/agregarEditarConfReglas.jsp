<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>
<div class="borderBottom"><h1>CONFIGURACI&Oacute;N DE REGLAS DE NEGOCIO</h1></div><br>	
<script>
$(document).ready(function(){
	$(".ayuda_g").hover(function(){
		tip = $(this).find('.tooltip');
		tip.show(); 
	}, function() {
		tip.hide(); 		  
	}).mousemove(function(e) {
		var mousex = e.pageX + 20; 
		var mousey = e.pageY + 20;
		var tipWidth = tip.width(); 
		var tipHeight = tip.height(); 
		var tipVisX = $(window).width() - (mousex + tipWidth);
		var tipVisY = $(window).height() - (mousey + tipHeight);
		  
		if ( tipVisX < 20 ) { 
			mousex = e.pageX - tipWidth - 20;
		} if ( tipVisY < 20 ) { 
			mousey = e.pageY - tipHeight - 20;
		} 
		tip.css({  top: mousey, left: mousex});
	});
	 
	
	$(".check_todos").click(function(event){
			 if($(this).is(":checked")) {
				$(".ck:checkbox:not(:checked)").attr("checked", "checked");
			 }else{
				 $(".ck:checkbox:checked").removeAttr("checked");
			 }
		   });
	 });

</script>
<s:if test="hasActionErrors()">
  	 <s:include value="/WEB-INF/paginas/template/abrirMensajeDialogo.jsp" />
</s:if>
<div id="dialogo_1"></div>
<fieldset  class="">	
	<legend><s:if test="%{editar == 1}">Actualizar</s:if><s:else>Agregar</s:else> Configuraci&oacute;n de Regla de Negocio</legend>
	<div class="clear"></div>
	<div>
		<label class="left1"><span class="requerido">*</span>Regla:</label>
		<s:select id="idRegla" name="codRegla" list="lstReglasNegocio" listKey="codRegla" listValue="%{nomRegla}" headerKey="-1" headerValue="-- Seleccione una opción --" tabindex="0" value="%{mapeoReglas.idRegla}"/>
	</div>
	<div class="clear"></div>
	<div>
		<label class="left1"><span class="requerido">*</span>Punto de Control:</label>
		<s:select id="idProceso" name="idProceso" list="lstPuntosControl" listKey="idProceso" listValue="%{nomProceso}" headerKey="-1" headerValue="-- Seleccione una opción --" tabindex="0" value="%{mapeoReglas.idProceso}"/>
	</div>
	<div class="clear"></div>
	<s:if test="%{editar == 1}" >
		<div>
			<label class="left1"><span class="requerido">*</span>Central:</label>
			<s:select id="idCentral" name="idCentral" list="lstCentrales" listKey="idCentral" listValue="%{nomCentral}" headerKey="-1" headerValue="-- Seleccione una opción --" tabindex="0" value="%{mapeoReglas.idCentral}"/>
		</div>
	</s:if>
	<div class="clear"></div>
	<s:else>
		<div>
			<label class="left1"><span class="requerido">*</span>Central:</label>
			<table>
				<tr>
					<th><input id="o1" name="o1" value="-1" type="checkbox" class="check_todos"/></th>
					<th>Centrales</th>
				</tr>
				<s:iterator value="lstCentrales" var="resultado"  status="itStatus">
					<tr>
						<td align="center"><input id="itemSelect" name="itemSelect" value="<s:property value="idCentral"/>" type="checkbox" class="ck" /></td>
						<td><s:property value="nomCentral"/></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</s:else>
	<div class="clear"></div>
	<div>
	 	<div ><label class="left1"><span class="requerido">*</span>Condici&oacute;n:</label></div>
		<div class="formulario"><s:textfield id="codRegla" name="codRegla" maxlength="2000" size="50"  value="%{mapeoReglas.codRegla}"/></div>
		<div class="ayuda_g"><a href="#"></a><div class="tooltip">Son las condiciones de las reglas de negocio para un punto de control y centrales seleccionadas en la configuración</div></div>
	</div>
	<div class="clear"></div>
	<div class="accion">
		<s:if test="%{editar == 1}" >
			<s:hidden name="idMapeoRegla" id="idMapeoRegla" value="%{mapeoReglas.idMapeoReglas}"/>						
			<a href="#" class="boton" title="Actualizar " onclick="agregarEditarConfReglas(1);">Actualizar Configuraci&oacute;n</a>
		</s:if>
		<s:else>
			<a href="#" class="boton" title="Agregar " onclick="agregarEditarConfReglas(0);">Agregar Configuraci&oacute;n</a>
		</s:else>
		<a href="<s:url value="/catalogos/configuracionReglas"/>" class="boton" title="Cancelar" >Cancelar Operaci&oacute;n</a>
	</div>
</fieldset>