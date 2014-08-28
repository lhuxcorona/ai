<%@taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>
<div class="borderBottom"><h1>PERFILES</h1></div><br>
<fieldset id="" class="clear">
	<legend><s:if test="%{editar == 1}">Actualizar</s:if><s:else>Agregar</s:else> Perfil</legend>
	<div>
		 <label class="left1"><span class="requerido">*</span>Perfil:</label>
		 <s:textfield id="nombrePerfil" name="nombrePerfil" maxlength="60" size="50"  value="%{perfil.perfil}"/>
	</div>
	<div>
		 <label class="left1"><span class="norequerido">*</span>Descripción:</label>
		 <s:textfield id="descripcion" name="descripcion" maxlength="200" size="50"  value="%{perfil.descripcion}"/>
	</div>
	<div>
		 <label class="left1"><span class="requerido">*</span>Privilegios del perfil:</label>		 
	</div>
	<table class="clean">
		<s:set name="tmp1">ok</s:set>
		<s:set name="tmp2">ok</s:set>
		<s:set name="tmp3">0</s:set>
		<s:set name="encontrado">0</s:set>
		<s:iterator value="lstMenuV" status="itStatus">	
					
			<s:set name="tmp1"><s:property value="padre"/></s:set>
				<s:if test='#tmp1!=#tmp2' >
					<tr>
						<th class="clean" colspan="2" align="left"><s:property value="padre"/></th>
					</tr>	
				</s:if>
				<s:if test='hijo!=null && hijo!=""' >
					<tr>
						<td>
							<s:if test="%{editar == 1}">
								<s:set name="tmp3"><s:property value="idHijo"/></s:set>	
								<s:iterator value="lstMenuVEdit" status="itStatus">
									<s:if test='#tmp3 == idHijo' ><s:set var="encontrado" value="%{1}" /></s:if>
								</s:iterator>								
								<s:if test="%{#encontrado == 1}">
									<input id="" name="itemPerfil" value="<s:property value="idHijo"/>" type="checkbox" checked="checked"/>
								</s:if>
								<s:else>
									<input id="" name="itemPerfil" value="<s:property value="idHijo"/>" type="checkbox" />
								</s:else>								
							</s:if>
							<s:else><input id="" name="itemPerfil" value="<s:property value="idHijo"/>" type="checkbox" /></s:else>	
							<s:set var="encontrado" value="%{0}" />
						</td>
						<td><s:property value="hijo"/></td>
					</tr>
				</s:if>
				<s:if test='hijo==null'>
					<td>
						<s:if test="%{editar == 1}">
							<s:set name="tmp3"><s:property value="idPadre"/></s:set>	
							<s:iterator value="lstMenuVEdit" status="itStatus">
								<s:if test='#tmp3 == idPadre' ><s:set var="encontrado" value="%{1}" /></s:if>
							</s:iterator>
							<s:if test="%{#encontrado==1}">
								<input id="" name="itemPerfil" value="<s:property value="idPadre"/>" type="checkbox" checked="checked"/>
							</s:if>	
							<s:else>
								<input id="" name="itemPerfil" value="<s:property value="idPadre"/>" type="checkbox" />
							</s:else>
							<s:set var="encontrado" value="%{0}"/>								
						</s:if>
						<s:else><input id="" name="itemPerfil" value="<s:property value="idPadre"/>" type="checkbox" /></s:else>						
					</td>
					<td><s:property value="padre"/></td>
				</s:if>
				<s:set name="tmp2"><s:property value="padre"/></s:set>	
		</s:iterator>		
	</table>
	<div class="accion">
		<s:if test="%{editar == 1}">
			<s:hidden name="idPerfil" id="idPerfil" value="%{idPerfil}"/>
			<a href="#" class="boton" title="Actualizar " onclick="agregarEditarPerfil(1);">Actualizar Perfil</a>
			<a href="<s:url value="/administracion/perfiles"/>" class="boton" title="Cancelar" >Cancelar Operaci&oacute;n</a>
		</s:if>
		<s:else>
			<a href="#" class="boton" title="Agregar " onclick="agregarEditarPerfil(0);">Agregar Perfil</a>
		</s:else>
	</div>
</fieldset>