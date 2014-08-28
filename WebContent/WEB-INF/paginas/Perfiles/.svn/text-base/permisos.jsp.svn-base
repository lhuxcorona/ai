<%@taglib uri="/struts-tags" prefix="s"%>
<link rel="stylesheet" type="text/css" href="<s:url value="/css/screen.css" />" media="screen, projection" />
<div class="borderBottom"><h1>Permisos - <s:property value="perfil.perfil"/></h1></div><br>
<table class="clean">
		<s:set name="tmp1">ok</s:set>
		<s:set name="tmp2">ok</s:set>
		<s:iterator value="lstMenuV" status="itStatus">
			<s:set name="tmp1"><s:property value="padre"/></s:set>
				<s:if test='#tmp1!=#tmp2' >
					<tr>
						<th class="clean"  align="left"><s:property value="padre"/></th>
					</tr>	
				</s:if>
				<s:if test='hijo!=null && hijo!=""' >
					<tr>
						<td><s:property value="hijo"/></td>
					</tr>
				</s:if>
				<s:if test='hijo==null'>
					<td><s:property value="padre"/></td>
				</s:if>
				<s:set name="tmp2"><s:property value="padre"/></s:set>	
		</s:iterator>		
	</table>

	   	