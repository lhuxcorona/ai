<%@taglib uri="/struts-tags" prefix="s"%>
<link rel="stylesheet" type="text/css" href="<s:url value="/css/screen.css" />" media="screen, projection" />
<div class="borderBottom"><h1><s:property value="reporteV.nomReporte"/></h1></div><br>
<fieldset >
	<div>
		 <label class="left1">Punto de control:</label>
		 <label><s:property value="reporteV.nomProceso"/></label>
	</div>
	<div class="clear"></div>
	<div>
		 <label class="left1">SQL_SELECT:</label>
		 <s:textarea  name=""  id="" cols="30"  value="%{reporteV.sqlSelect}" rows="3"/>
	</div>
	<div class="clear"></div>
	<div>
		 <label class="left1">SQL_FROM:</label>
		 <s:textarea  name=""  id="" cols="30"  value="%{reporteV.sqlFrom}" rows="3"/>
	</div>
	<div class="clear"></div>
	<div>
		 <label class="left1">SQL_WHERE:</label>
		 <s:textarea  name=""  id="" cols="30"  value="%{reporteV.sqlWhere}" rows="3"/>
	</div>
	<div class="clear"></div>
	<div>
		 <label class="left1">SQL_GROUPBY:</label>
		 <s:textarea  name=""  id="" cols="30"  value="%{reporteV.sqlGroupBy}" rows="3"/>
	</div>
	<div class="clear"></div>
	<div>
		 <label class="left1">SQL_HAVING:</label>
		 <s:textarea  name=""  id="" cols="30"  value="%{reporteV.sqlHaving}" rows="3"/>
	</div>
	<div class="clear"></div>
	<div>
		 <label class="left1">SQL_ORDERBY:</label>
		 <s:textarea  name=""  id="" cols="30"  value="%{reporteV.sqlOrderBy}" rows="3"/>
	</div>
	<s:if test="%{chkGrafica == -1}">
		<div>
			<div><label class="left1"><span class="requerido">*</span>Columna X:</label></div>
			<label><s:property value="reporteV.columnaX"/></label>
		</div>
		<div class="clear"></div>
		<div>
			<div><label class="left1"><span class="requerido">*</span>Etiqueta X:</label></div>
			<label><s:property value="reporteV.etiquetaX"/></label>
		</div>
		<div class="clear"></div>
		<div>
			<div><label class="left1"><span class="requerido">*</span>Columna Y:</label></div>
			<label><s:property value="reporteV.columnaY"/></label>
		</div>
		<div class="clear"></div>
		<div>
			<div><label class="left1"><span class="requerido">*</span>Etiqueta Y:</label></div>
				<label><s:property value="reporteV.etiquetaY"/></label>
		</div>	
	</s:if>
</fieldset>
	