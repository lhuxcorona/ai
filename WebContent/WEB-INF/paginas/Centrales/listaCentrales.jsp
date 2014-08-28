<%@taglib uri="/struts-tags" prefix="s"%>
<s:if test="hasActionErrors()">
  	 <s:include value="/WEB-INF/paginas/template/abrirMensajeDialogo.jsp" />
</s:if>
<div id="dialogo_1"></div>	
<fieldset>
	<legend>Centrales</legend>
	<br>	
	<s:if test="lstCentralesV.size() > 0">
		<table width="100%">
			<tr>
				<th>Id</th>
				<th>Central</th>
				<th>Activo</th>
				<th>Detalle</th>
				<th>Editar</th>
				<th>Eliminar/Inhabilitar</th>
			</tr>
			<s:iterator value="lstCentralesV" var="resultado"  status="itStatus">
				<tr>
					<td><s:property value="idCentral"/></td>
					<td><s:property value="nomCentral"/></td>
					<td align="center">
						<s:if test="%{activo==1}">SI</s:if><s:else>NO</s:else>
					</td>
					<td>
						<a class="botonVerDetalles" href="<s:url value="/catalogos/detalleCentral?idCentral=%{idCentral}" />" target="winload" onclick="window.open(this.href, this.target, 'width=600,height=400,scrollbars=yes'); return false;" title="Ver Detalle de Central"></a>
					</td>
					<td><a href="#" onclick="datosCentral(<s:property value="idCentral"/>);" class="editar" title="Editar central" ></a></td>
					<td> 
						<s:if test="%{inhabilitarBorrar == 'BORRAR'}">
							<a href="#" onclick="eliminarInhabilitarCentral(<s:property value="idCentral"/>,0);" class="borrar" title="Eliminar Central" ></a>
						</s:if>
						<s:else>
							<s:if test="%{activo==1}">
								<a href="#" onclick="eliminarInhabilitarCentral(<s:property value="idCentral"/>,1);" class="inhabilitar" title="Inhabilitar Central" ></a>
							</s:if>
							<s:else>
								<a href="#" onclick="eliminarInhabilitarCentral(<s:property value="idCentral"/>,2);" class="habilitar" title="Habilitar Central" ></a>
							</s:else>
								
						</s:else>
					</td>
				</tr>
			</s:iterator>
		</table>
	</s:if>
</fieldset>


