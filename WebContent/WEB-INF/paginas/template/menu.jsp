<%@taglib uri="/struts-tags" prefix="s"%>
<!-- Se trae de la session el menu  --> 
<s:if test="#session.lstMenuV.size() > 0">
	<s:set name="tmp1">ok</s:set>
	<s:set name="tmp2">ok</s:set>
	<s:set name="bandera">0</s:set>
	<s:set name="banderaPadre">0</s:set>
	<ul id="navmenu-h">	
		<s:iterator value="#session.lstMenuV" var="resultado"  status="itStatus">
			<s:set name="tmp1"><s:property value="padre"/></s:set>
			<s:if test='#tmp1!=#tmp2 && #banderaPadre == 1'>
				<s:if test='#bandera == 1'>
					</ul>
					<s:set name="bandera">0</s:set>
				</s:if>
				</li>
			</s:if>
			<s:if test='#tmp1!=#tmp2' >
				<s:if test="#itStatus.first == true"><s:set name="clase">esquinaIzq</s:set></s:if>
				<s:else><s:set name="clase"></s:set></s:else>
      			<li> <a href="<s:url value="%{urlPadre}"/>" class="<s:property value="%{#clase}"/>"><s:property value="padre"/></a>
				<s:set name="banderaPadre">1</s:set>
			</s:if>
			<s:if test='hijo!=null && hijo!="" && #bandera!=1'  >
				<ul>
				<s:set name="bandera">1</s:set>
			</s:if>
			<s:if test='hijo!=null && hijo!=""' >
				<li><a href="<s:url value="%{urlHijo}"/>"><s:property value="hijo"/></a></li>
			</s:if>
			<s:set name="tmp2"><s:property value="padre"/></s:set>					
		</s:iterator>
	
	<s:if test='#bandera == 1'>
		</ul>
	</s:if>
	<s:if test='#banderaPadre == 1'>
		</li>
	</s:if>
	<li>
		<a href="<s:url value="/salir.action" />" class="esquinaDer">Salir</a>
	</li>
	</ul>
</s:if>

	