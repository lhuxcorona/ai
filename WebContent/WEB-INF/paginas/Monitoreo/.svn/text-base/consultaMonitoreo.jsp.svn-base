<%@taglib uri="/struts-tags" prefix="s"%>
	<div class="borderBottom"><h1>MONITOREO DE PROCESOS</h1></div><br>
	<fieldset class="prestador">
		<legend>Criterios de B&uacute;squeda</legend>
		<table width="100%" class="clean">	
			<tr>
				<td><label >Punto de Control:</label></td>
				<td>
					<s:select id="idEstatus"  name="idEstatus" list="#{1:'Interact vs Tarificación',2:'Centrales vs Interact'}" listKey="key" listValue="value" headerKey="0"headerValue="Seleccione una opción"/>
			    </td>
				<td><label >Central:</label></td>
				<td><s:select id="idEstatus"  name="idEstatus" list="#{1:'Central NORTEL (Monterrey)',2:'Central ANIMAS (Puebla)'}" listKey="key" listValue="value" headerKey="0"headerValue="Seleccione una opción"/></td>
			</tr>
			<tr>
				<td><label >Fecha:</label></td>
				<td><s:if test="%{fechaInicio==null}" >
						<s:textfield name="fechaInicio" maxlength="10" size="10" id="fechaInicio" readonly="true" cssClass="dateBox" />
					</s:if>
					<s:else>
						<s:textfield key="fechaInicio" value=""   maxlength="10" size="10" id="fechaInicio" readonly="true" cssClass="dateBox" />
					</s:else>
					<img src="../images/calendar.gif" id="trg1" style="cursor: pointer;" alt="Seleccione la fecha" border="0" class="dtalign" title="Seleccione la fecha" />
				</td>
				<td><label > Descripción:</label></td>
				<td>
					<s:textfield id="nomRegla" name="nomRegla" maxlength="100" size="50"  value="%{rn.nomRegla}"/>
				</td>
			</tr>
		</table>
		<div class="accion">
		 	<a href="#" class="boton" title="Consultar" onclick="consultarProceso();">Consultar Proceso</a>
		</div>
	</fieldset>
	<div id="resultadoConsulta"></div>
<script type="text/javascript">
	<!--
	Calendar.setup({
		inputField     :    "fechaInicio",     
		ifFormat       :    "%d/%m/%Y",     
		button         :    "trg1",  
		align          :    "Br",           
		singleClick    :    true
	});
	
	//-->
</script>