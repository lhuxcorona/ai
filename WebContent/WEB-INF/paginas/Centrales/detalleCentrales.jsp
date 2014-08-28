<%@taglib uri="/struts-tags" prefix="s"%>
<link rel="stylesheet" type="text/css" href="<s:url value="/css/screen.css" />" media="screen, projection" />
<div class="borderBottom"><h1><s:property value="centralV.nomCentral"/></h1></div><br>
<fieldset >
	<div class="clear"></div>
	<div>
		 <label class="left1"><span class="requerido">*</span>Directorio de extracci&oacute;n:</label>
		 <s:property value="centralV.dirAcceso"/>
	</div>
	<div class="clear"></div>
	<div>
		 <label class="left1"><span class="requerido">*</span>Tabla de Carga en Crudo:</label>
		 <s:property value="centralV.nomTablaCrudo"/>
	</div>
	<div class="clear"></div>
	<div>
		 <label class="left1">Campos Origen:</label>
		 <s:textarea  name="descripcion"  id="descripcion" cols="30"  value="%{centralV.sqlSelect}" rows="3"/>
	</div>
	<div>
		 <label class="left1">Tabla de Formato Est&aacute;ndar:</label>
		 <s:property value="centralV.nomTablaFormato"/>
	</div>
	
	<div class="clear"></div>
	<div>
		 <label class="left1">Campos Destino:</label>
		 <s:textarea  name="descripcion"  id="descripcion" cols="30"  value="%{centralV.sqlInsert}" rows="3"/>
	</div>
	<div class="clear"></div>
	<div>
		 <label class="left1">Codificaci&oacute;n:</label>
		 <s:property value="centralV.nomCodificacion"/>
	</div>
	<br>

	<s:if test="lstMapeoArchivos.size() > 0">
		<div>
		<label class="left1">Mapeo Archivo:</label>
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
		</div>
				
	</s:if>

</fieldset>
	