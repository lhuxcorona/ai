<%@taglib uri="/struts-tags" prefix="s"%>
<s:if test="lstR.size() > 0">	
	<fieldset >
		<legend>Reportes</legend>			
			<table width="100%" class="clean">	
				<tr>
					<td><label >Reporte:</label></td>
					<td colspan="3">
						<strong>Archivos transferidos a INTERACT</strong>
				    </td>
				</tr>
				<tr>
					<td><label >Central:</label></td>
					<td colspan="3"><strong>Central LUCENT ANIMAS (Puebla)</strong></td>
				</tr>
				<tr>
					<td><label >Desde:</label></td>
					<td><strong>01-junio-12</strong></td>
					<td><label>Hasta:</label></td>
					<td><strong>30-junio-12</strong></td>
				</tr>
			</table>
			<div>
				<div class="exporta_csv"><a href="#" title="Exportar a CSV" ></a></div>
				<div class="exporta_txt"><a href="" title="Exportar a TXT" ></a></div>
				<div class="grafica">
					<a  href="<s:url value="/reportes/otroGenerador" />" target="winload" onclick="window.open(this.href, this.target, 'width=600,height=400,scrollbars=yes'); return false;" title="Gráfica"></a>
				</div>
			</div>			
			<table width="100%">
				<tr>
					<th>Fecha</th>
					<th>Archivos</th>
					<th>Llamadas</th>
					<th>Minutos</th>
				</tr>
				<s:iterator value="lstR" var="resultado"  status="itStatus">
					<tr>
						<td><s:property value="fecha"/></td>
						<td><s:property value="archivos"/></td>
						<td><s:property value="llamadas"/></td>
						<td><s:property value="minutos"/></td>
					</tr>
				</s:iterator>
			</table>
	</fieldset>
</s:if>