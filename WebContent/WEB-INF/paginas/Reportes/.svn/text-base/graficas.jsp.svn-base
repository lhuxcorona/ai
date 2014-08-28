<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<link rel="stylesheet" type="text/css" href="<s:url value="/css/screen.css" />" media="screen, projection" />
<script type="text/javascript" src="<s:url value="/js/funciones.js" />"></script>
<script type="text/javascript" src="<s:url value="/js/jquery-1.7.2.min.js" />"></script>
<script type="text/javascript" src="<s:url value="/js/jquery-ui-1.8.21.custom.min.js" />"></script>
<script type="text/javascript">  	
  	google.load('visualization', '1.0', {'packages':['corechart']});
  	google.setOnLoadCallback(drawChart1);
  
	function drawChart1() 
	{

	  	// Create the data table.
	  	var data = new google.visualization.DataTable();
	  	data.addColumn('string', '<s:property value="%{etiquetaY}"/>');
	  	data.addColumn('number', '<s:property value="%{reporte.etiquetaX}"/>');

	  	<s:iterator id="dataFiller" value="lstGraficas">
    			data.addRow(['<s:property value="graficaResX"/>', <s:property value="graficaResY" />]);
    	</s:iterator>
	
	  	// Set chart options
	  	var options = {'title':'',
	                 'width':'30%',
	                 'height':280,
	                 'legend':'bottom'
	                 };
  		
  		var chart = new google.visualization.<s:property value="tipoGrafica"/>(document.getElementById('graficaEstatus'));
 		chart.draw(data, options);
	}
  	
	function cambiarGrafica(){
		var tipoGrafica = $('#tipoGrafica').val();
		if(tipoGrafica == -1){
			return false;
		}
		
		document.grafica.submit();			
	}
	</script>

<s:form action="generarGrafica" name="grafica">
	<div class="borderBottom"><h1><s:property value="%{reporte.nomReporte}"/></h1></div>
	<div id="graficaEstatus" ></div>
	<div>
		<label class="left1">Tipo de Gráfica:</label>
		<s:select id="tipoGrafica"  name="tipoGrafica" list="#{'ColumnChart':'Columna','PieChart':'Circular'}" listKey="key" listValue="value" headerKey="-1" headerValue="Seleccione una opción" onchange="cambiarGrafica();"/>	 
	</div>
	
</s:form>	
	
	
	