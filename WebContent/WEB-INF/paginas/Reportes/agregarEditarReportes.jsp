<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>
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

	$("#chkgrafica-1").click(function(event){
		   $("#oculto").fadeIn('slow');
	});
	
	$("#chkgrafica-2").click(function(event){
		   $("#oculto").fadeOut('slow');
	});	
});
</script>
	<div class="borderBottom"><h1>REPORTES</h1></div><br>
	<fieldset class ="">
	    <div class="clear"></div>
		<legend><s:if test="%{editar == 1}">Actualizar</s:if><s:else>Agregar</s:else> Reporte</legend>
		<div>
			<label class="left1"><span class="requerido">*</span>Nombre del Reporte:</label>
			<s:textfield id="nomReporte" name="nomReporte" maxlength="60" size="50"  value="%{reporte.nomReporte}"/>
		</div>
		<div class="clear"></div>
		<div>
			<label class="left1"><span class="requerido">*</span>Punto de Control:</label>
			<s:select id="idProceso" name="idProceso" list="lstPC" listKey="idProceso" listValue="%{nomProceso}" headerKey="-1" headerValue="-- Seleccione una opción --" tabindex="0" value="%{reporte.idProceso}"/>
		</div>
		<div class="clear"></div>
		<div>
			<div><label class="left1"><span class="requerido">*</span>SQL_SELECT:</label></div>
			<div class="formulario"><s:textfield id="sqlSelect" name="sqlSelect" maxlength="2000" size="50"  value="%{reporte.sqlSelect}"/></div>
			<div class="ayuda_g"><a href="#" ></a><div class="tooltip">Especifica las columnas que la consulta debe regresar </div></div>
		</div>
		<div class="clear"></div>
		<div>
			<div><label class="left1"><span class="requerido">*</span>SQL_FROM:</label></div>
			<div class="formulario"><s:textfield id="sqlFrom" name="sqlFrom" maxlength="1000" size="50"  value="%{reporte.sqlFrom}"/></div>
			<div class="ayuda_g"><a href="#"  ></a><div class="tooltip">Especifica las tablas de extracción de la consulta </div></div>
		</div>
		<div class="clear"></div>
		<div>
			<div><label class="left1"><span class="requerido">*</span>SQL_WHERE:</label></div>
			<div class="formulario"><s:textfield id="sqlWhere" name="sqlFrom" maxlength="1000" size="50"  value="%{reporte.sqlWhere}"/></div>
			<div class="ayuda_g"><a href="#" ></a><div class="tooltip">Especifica la condición de búsqueda de las filas devueltas por la consulta.</div></div>
		</div>
		<div class="clear"></div>
		<div>
			<div><label class="left1"><span class="norequerido">*</span>SQL_GROUPBY:</label></div>
			<div class="formulario"><s:textfield id="sqlGroupBy" name="sqlGroupBy" maxlength="1000" size="50"  value="%{reporte.sqlGroupBy}"/></div>
			<div class="ayuda_g"><a href="#" ></a><div class="tooltip">Agrupa el conjunto de resultados de una o más columnas</div></div>
		</div>
		<div class="clear"></div>
		<div>
			<div><label class="left1"><span class="norequerido">*</span>SQL_HAVING:</label></div>
			<div class="formulario"><s:textfield id="sqlHaving" name="sqlHaving" maxlength="1000" size="50"  value="%{reporte.sqlHaving}"/></div>
			<div class="ayuda_g"><a href="#" ></a><div class="tooltip">Especifica una condición de búsqueda para un grupo o agregado</div></div>
		</div>
		<div class="clear"></div>
		<div>
			<div><label class="left1"><span class="norequerido">*</span>SQL_ORDERBY:</label></div>
			<div class="formulario"><s:textfield id="sqlOrderBy" name="sqlOrderBy" maxlength="1000" size="50"  value="%{reporte.sqlOrderBy}"/></div>
			<div class="ayuda_g"><a href="#" ></a><div class="tooltip">Especifica el orden del conjunto de resultados de una consulta por la lista de columnas especificada</div></div>
		</div>
		<div class="clear"></div>
		<div class="inline">
			<label class="left1"><span class="norequerido">*</span>Gráfica:</label>
			<s:radio label=""  name="chkgrafica" list="#{'-1':'SI','-2':'NO'}" value="%{chkGrafica}" />
		</div>
		<div class="clear"></div>
		<s:if test="%{chkGrafica == -1}">
			<script>
			$(document).ready(function(){
				$("#oculto").css("display", "inline");
			});
			</script>
		</s:if>
		<div id="oculto">
			<div>
				<div><label class="left1"><span class="requerido">*</span>Columna X:</label></div>
				<div class="formulario"><s:textfield id="columnaX" name="columnaX" maxlength="500" size="50"  value="%{reporte.columnaX}"/></div>
				<div class="ayuda_g"><a href="#" ></a><div class="tooltip">Es el nombre de la columna para tomar el valor  de la coordenada X en la gr&aacute;fica</div></div>
			</div>
			<div class="clear"></div>
			<div>
				<div><label class="left1"><span class="requerido">*</span>Etiqueta X:</label></div>
				<div class="formulario"><s:textfield id="etiquetaX" name="etiquetaX" maxlength="30" size="50"  value="%{reporte.etiquetaX}"/></div>
				<div class="ayuda_g"><a href="#" ></a><div class="tooltip">Es el nombre de la etiqueta de la coordenada X en la gr&aacute;fica</div></div>
			</div>
			<div class="clear"></div>
			<div>
				<div><label class="left1"><span class="requerido">*</span>Columna Y:</label></div>
				<div class="formulario"><s:textfield id="columnaY" name="columnaY" maxlength="500" size="50"  value="%{reporte.columnaY}"/></div>
				<div class="ayuda_g"><a href="#" ></a><div class="tooltip">Es es nombre de la columna para tomar el valor  de la coordenada Y en la gr&aacute;fica</div></div>
			</div>
			<div class="clear"></div>
			<div>
				<div><label class="left1"><span class="requerido">*</span>Etiqueta Y:</label></div>
				<div class="formulario"><s:textfield id="etiquetaY" name="etiquetaY" maxlength="30" size="50"  value="%{reporte.etiquetaY}"/></div>
				<div class="ayuda_g"><a href="#" ></a><div class="tooltip">Es el nombre de la etiqueta de la coordenada Y en la gr&aacute;fica</div></div>
			</div>
		</div>
		<div class="clear"></div>
		<div class="accion">
			<s:if test="%{editar == 1}">
				<s:hidden name="idReporte" id="idReporte" value="%{idReporte}"/>
				<a href="#" class="boton" title="Actualizar " onclick="agregarEditarReporte(1);">Actualizar Reporte</a>
				<a href="<s:url value="/reportes/reportes"/>" class="boton" title="Cancelar" >Cancelar Operaci&oacute;n</a>
			</s:if>
			<s:else>
				<a href="#" class="boton" title="Agregar " onclick="agregarEditarReporte(0);">Agregar Reporte</a>
			</s:else>
		</div>		
	</fieldset>

