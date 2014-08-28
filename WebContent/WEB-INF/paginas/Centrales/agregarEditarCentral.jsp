<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>

<div class="borderBottom"><h1>CENTRALES</h1></div><br>	
<s:hidden name="editar" id="editar" value="%{editar}"/>
<s:hidden name="numCamposAnterior" id="numCamposAnterior" value="%{numCamposAnterior}"/>
<fieldset id="" class="">
	<legend> <s:if test="%{editar == 1}">Actualizar</s:if><s:else>Agregar</s:else> Central</legend>
	<s:if test="%{editar == 1}">
		<div class="inline">
			<label class="left1"><span class="requerido">*</span>Habilitar:</label>
			<s:radio label=""  name="activo" list="#{'1':'SI','0':'NO'}" value="%{central.activo}" />
		</div>
		<div class="clear"></div>
	</s:if>
	<div>
		 <label class="left1"><span class="requerido">*</span>Nombre de la Central:</label>
	     <s:textfield id="nomCentral" name="nomCentral" maxlength="60" size="50"  value="%{central.nomCentral}"/>	     
	</div>
	<!-- <div class="ayuda_g" style="float:rigth;"><a href='<s:url value="/monitoreo/reportarLog?ext=csv"/>' title="Ayuda"></a></div> -->
	<div class="clear"></div> 
	
	<div>
		 <div><label class="left1"><span class="requerido">*</span>Directorio de extracci&oacute;n:</label></div>
		 <div class="formulario"><s:textfield id="dirAcceso" name="dirAcceso" maxlength="100" size="50"  value="%{central.dirAcceso}"/></div>
		 <div class="ayuda_g"><a href="#" ></a><div class="tooltip">Es la ubicaci&oacute;n para la extracci&oacute;n de archivos generados por la central</div></div>
	</div>

	<div class="clear"></div>
	<div>
		 <div><label class="left1"><span class="requerido">*</span>Tabla de Carga en Crudo:</label></div>
		 <div class="formulario"><s:textfield id="nomTablaCrudo" name="nomTablaCrudo" maxlength="100" size="50"  value="%{central.nomTablaCrudo}"/></div>
		 <div class="ayuda_g"><a href="#" ></a><div class="tooltip">Nombre de la tabla, donde se poblar�n los datos provenientes de los archivos generados por la central</div></div>
	</div>
	<div class="clear"></div>
	<div>
		 <div><label class="left1"><span class="requerido">*</span>Campos Origen:</label></div>
		 <div class="formulario"><s:textfield id="sqlSelect" name="sqlSelect" maxlength="2000" size="50"  value="%{central.sqlSelect}"/></div>
		 <div class="ayuda_g"><a href="#" ></a><div class="tooltip">Son los campos de la tabla de carga en crudo, que ser�n transferidos a la tabla de formato &uacute;nico "FORMATO_UNICO_ADI"</div></div>
	</div>
	<div class="clear"></div>
	<div>
		 <label class="left1"><span class="norequerido">*</span>Tabla de Formato &Uacute;nico</label>
		 <s:if test="%{editar == 1}">
		 	<s:textfield id="nomTablaFormato" name="nomTablaFormato" disabled="true" maxlength="100" size="50"  value="%{central.nomTablaFormato}"/>
		 </s:if>
		 <s:else>
		 	<s:textfield id="nomTablaFormato" name="nomTablaFormato" disabled="true"  maxlength="100" size="50"  value="%{lstCentralesV.get(0).nomTablaFormato}"/>
		 </s:else>
	</div>	
	<div class="clear"></div>
	<div>
		 <label class="left1"><span class="requerido">*</span>Campos Destino:</label>
		 <div class="formulario"><s:textfield id="sqlInsert" name="sqlInsert" maxlength="2000" size="50"  value="%{central.sqlInsert}"/></div>
		 <div class="ayuda_g"><a href="#"></a><div class="tooltip">Son los campos de la tabla FORMATO_UNICO_ADI donde se depositar&aacute; la informaci&oacute;n estandarizada de la central</div></div>
	</div>
	<div class="clear"></div>
	<div>		
		 <label class="left1"><span class="requerido">*</span>Tipo de Codificaci&oacute;n:</label>
		 <s:select id="claveCodificacion" name="claveCodificacion" list="lstTipoCodificacion" listKey="claveCodificacion" listValue="%{nombreCodificacion}" headerKey="-1" headerValue="-- Seleccione el Tipo de Codificacion --" tabindex="0" value="%{central.cveCodificacion}"/>
	</div>
	<s:if test="%{editar == 1 && central.cveCodificacion == 3 }">
	    <div>
			<label class="left1">Mapeo Actual del Archivo:</label>
			<table class="clean">
				<tr>
					<th class="clean">Campo </th>
					<th class="clean">Longitud</th>
					<th class="clean">Posici&oacute;n</th>					
				</tr>
				<s:set var="posicionInicial" value="%{1}" />
				<s:set var="posicionFinal" value="%{0}" />
				<s:iterator value="lstMapeoArchivos" var="resultado"  status="itStatus">
					<s:set var="posicionFinal" value="%{longitud+ #posicionFinal}" />
					<tr>
						<td><s:property value="%{#itStatus.count}"/> </td>
						<td>
							<s:property value="%{longitud}"/> 
						</td>
						<td><s:property value="%{#attr.posicionInicial}" />-<s:property value="%{#attr.posicionFinal}" /></td>					    
					</tr>
					<s:set var="posicionInicial" value="%{#posicionFinal + 1 }" />
				</s:iterator>
			</table>
			<script>
				$(document).ready(function(){
					$("#oculto").css("display", "inline");
				 });
			</script>
		</div>
	</s:if>
	<script>
	  $("#claveCodificacion").change(function(event){
		  var claveCodificacion = $('#claveCodificacion').val();
		  var editar = $('#editar').val();
		   if(claveCodificacion == 3){
			   $("#oculto").fadeIn('slow'); 
			   $("#agregaCampos").fadeIn('slow');
			   
		   }else{
			   $("#oculto").fadeOut('slow');
			   $("#agregaCampos").fadeOut('slow');
			   if(editar == 1){
				   $("#agregaCamposEditar").fadeOut('slow');
			   }
			   
		   }	  
      });
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
 	 </script>
 	<div class="clear"></div>
	<div id="oculto"> 
		 <div><label class="left1"><span class="requerido">*</span>N&uacute;mero de Campos:</label></div>
		 <div class="formulario"><s:textfield id="numCampos" name="numCampos" maxlength="10" size="50"  value="%{numCamposAnterior}"/></div>
		 <div class="ayuda_g"><a href="#" ></a><div class="tooltip">Capture el n&uacute;mero de campos del mapeo de archivos</div></div>
		 <script>
		 $(document).ready(function(){
	   			$("#numCampos").keyup(function(event){
	   				//manda a llamar 
	   				var idCentral = 0;
	   				var numCamposAnterior = 0;
		   			var numCampos = $('#numCampos').val();
		   			if(numCampos == null || numCampos == ""){
		   				return false;
		   			}
		   			var editar = $('#editar').val();
		   			if(editar == 1){
		   				idCentral = $('#idCentral').val();
		   				numCamposAnterior = $('#numCamposAnterior').val();
		   			}
		   			
		   			
			   $.ajax({
				   async: false,
				   type: "POST",
				   url: "insertaCampos",
				   data: "numCampos="+numCampos+
				   		"&editar = "+editar+
				   		"&numCamposAnterior = "+numCamposAnterior+
				   		"&idCentral="+idCentral,
				   success: function(data){
						$('#agregaCampos').html(data).ready(function () {
							
						});
				   }
				}); //termina ajax
	   		});//termina keyup numCampos	   	
	 	 });// termina $(document).ready(function(){
		 </script>		 
	</div>
	<div class="clear"></div>
	<s:if test="%{editar == 1 && central.cveCodificacion == 3 }">
	<script>
		var numCampos = $('#numCampos').val();
		var editar = $('#editar').val();
		var idCentral = $('#idCentral').val();
		var numCamposAnterior = $('#numCamposAnterior').val();		 
	   $.ajax({
		   async: false,
		   type: "POST",
		   url: "insertaCampos",
		   data: "numCampos="+numCampos+
		   		"&editar = "+editar+
		   		"&numCamposAnterior = "+numCamposAnterior+
		   		"&idCentral="+idCentral,
		   success: function(data){
				$('#agregaCampos').html(data).ready(function () {
					
				});
		   }
		}); //termina ajax	
		
	</script>	
	</s:if>
	<div id="agregaCampos"></div>
	<div class="accion">
		<s:if test="%{editar == 1}">
			<s:hidden name="idCentral" id="idCentral" value="%{idCentral}"/>
			<a href="#" class="boton" title="Actualizar " onclick="agregarEditarCentral(1);">Actualizar Central</a>
			<a href="<s:url value="/catalogos/centrales"/>" class="boton" title="Cancelar" >Cancelar Operaci&oacute;n</a>
		</s:if>
		<s:else>
			<a href="#" class="boton" title="Agregar " onclick="agregarEditarCentral(0);">Agregar Central</a>
		</s:else>
	</div>
</fieldset>


