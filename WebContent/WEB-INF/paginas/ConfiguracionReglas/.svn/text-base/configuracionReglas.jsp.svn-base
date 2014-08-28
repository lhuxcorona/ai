<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<div class="mensajesApp" id="mensajesApp"><s:actionmessage /></div>


<script>
$(document).ready(function(){
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
<div class="borderBottom"><h1>CONFIGURACI&Oacute;N DE REGLAS DE NEGOCIO</h1></div><br>	
<fieldset>
	<legend>Configuraci&oacute;n de Reglas de Negocio</legend>
	<div>
		<s:submit value="Eliminar "  cssClass="boton2"  id="agregar" onclick="eliminarConfReglas();"/>
		<s:submit value="Agregar Configuración"  cssClass="boton2"  id="agregar" onclick="datosMapeoReglas(0,0);"/>
	</div>
	<br>	
	<s:if test="lstMapeoReglasV.size() > 0">
		<display:table id="l" name="lstMapeoReglasV" list="lstMapeoReglasV"  pagesize="30" sort="list" requestURI="/catalogos/configuracionReglas"  class="displaytag" >
			<display:column title="<input type='checkbox' name='itemSelect' value='-1' class='check_todos'/>">
				<input id="" name="itemSelect" value="<s:property value="%{#attr.l.idMapeoReglas}"/>" type="checkbox"  class="ck"/>
			</display:column>
			<display:column  property="idMapeoReglas" title="Id" />
			<display:column  property="nomRegla" title="Regla" />
			<display:column  property="nomProceso" title="Punto de Control" />
			<display:column  property="nomCentral" title="Central" />
			<display:column  property="codRegla" title="Condici&oacute;n" />
			<display:column title="Editar"  headerClass="sortable" >
				<center><a href="#" onclick="datosMapeoReglas(<s:property value="%{#attr.l.idMapeoReglas}"/>,1);" class="editar" title="Editar Configuración" ></a></center>
			</display:column>
		</display:table>		
	</s:if>
</fieldset>


