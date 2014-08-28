<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>

<script>
function CalculaPosicion(){
	
	var nmOrigen;
	var nmDestino;
	var tElementos = document.getElementById("numCampos").value;
	var nPosI = 1;
	var nPosF = 0;
	
	for (i=1;i<parseInt(tElementos)+1;i++){	
		nmOrigen = document.getElementById('l'+i).value;
		nPosF += parseInt(document.getElementById('l'+i).value);	
		if(!nmOrigen.match(/^\d*$/)){
			$('#dialogo_1').html('La longitud  del campo '+i+' no es correcto, favor de verificar');
	   		abrirDialogo();
	 		return false;
		}
		if (!isNaN(nPosF))
			document.getElementById('t'+i).value = nPosI + " - " + nPosF;
		nPosI = nPosF + 1;	
	}
}
</script>
<div>
	<p><span class="requerido">*Debe capturar los campos del archivo de control</span></p>
</div>
<s:if test="lstMapeoArchivos.size() > 0">
	<table class="clean">
		<tr>
			<th class="clean">Campo</th>
			<th class="clean">Longitud</th>
			<th class="clean">Posici&oacute;n</th>
		</tr>
		<s:iterator value="lstMapeoArchivos" var="resultado"  status="itStatus">
			<tr>
				<td><s:property value="%{#itStatus.count}"/> </td>
				<td>
					<s:textfield id="l%{#itStatus.count}"  maxlength="20" size="20"  cssClass="ck" value="%{longitud}" onChange="CalculaPosicion();" onBlur="CalculaPosicion()"/>
				</td>
				<td><s:textfield id="t%{#itStatus.count}" maxlength="20" size="20" class="ck" disabled="true"/></td>
			</tr>
		</s:iterator>
	</table>
</s:if>


