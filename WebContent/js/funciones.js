$(document).ready(function(){
	$.ajaxSetup({
		'beforeSend' : function(xhr) {
			try{
				xhr.overrideMimeType('text/html; charset=iso-8859-1');
			}catch(e){}
		}});
});
/*****************************************************************/
/**********************ABC Puntos de Control**********************/
/*****************************************************************/
/*Actualiza ó agrega un punto de control*/
function agregarEditarPC(editar){ 
	var puntoControl = $('#puntoControl').val();
	var umbral = $('#umbral').val();
	var patron = "";
	
	$("#mensajesApp").fadeOut("slow");
	//Validar campos del formulario
	if(puntoControl == null || puntoControl == ""){
   		$('#dialogo_1').html('Capture el punto de control');
   		abrirDialogo();
 		return false;	
   	}else{
   		patron = /^(\w*ñ*\s*á*é*í*ó*ú*A*É*Í*Ó*Ú*Ñ*)*$/;
		if(!puntoControl.match(patron)){
			  $('#dialogo_1').html('El punto de control no es válido, se aceptan solo alfanúmericos');
		   		abrirDialogo();
		 		return false;	
		}
   	}
    
	patron = /^\d{1,2}(\.\d{1,2})?$/;
	if(!umbral.match(patron)){
		$('#dialogo_1').html('El umbral no es válido, capture números menores a 100');
   		abrirDialogo();
   		return false;	
	}
 
	var idProceso = -1;
	if(editar == 1){
		idProceso = $('#idProceso').val();
	}
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "agregarEditarPC",
						   data: "puntoControl="+puntoControl+
					  		 "&editar="+editar+
					  		 "&umbral="+umbral+
					  		 "&idProceso="+idProceso,
						   success: function(data){
								$('#pContenido').html(data).ready(function () {
									hideLoading();
									$('#puntoControl').val('');
									$('#umbral').val('1');
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });
	  
}

/*Consigue los datos de un punto de control*/
function datosPC(idProceso){ 
	$("#mensajesApp").fadeOut("slow");
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "datosPC",
						   data: "idProceso="+idProceso+
						   		 "&editar=1",
						   success: function(data){
								$('#agregarEditar').html(data).ready(function () {
									hideLoading();
									$("#puntoControl").css("color", "#000");
									$("#umbral").css("color", "#000");
									
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });
	  
}
/*Elimina los puntos de control seleccionados por el usuario*/
function eliminarPC(){ 	
	$('#mensajesApp').html('');
	var selectedItems = new Array();
	$("input[@name='itemSelect[]']:checked").each(function() {selectedItems.push($(this).val());});
	if (selectedItems.length == 0){ 
	    $('#dialogo_1').html('Por favor seleccione los puntos de control a eliminar.');
		abrirDialogo();
	    return false;
	}
	
	$('#dialogo_1').html('¿Está seguro de eliminar los puntos de control seleccionados?');
	$('#dialogo_1').dialog({
		autoOpen: true,
		width: 300,
		show: "slide",
		hide: "fade",
		modal: true,
		buttons: {
			"Aceptar": function() {
				$(this).dialog("close");
				$("#espera").fadeIn('slow', function() {
					  $("#img-espera").fadeIn('slow', function(){
						  $.ajax({
							   async: false,
							   type: "POST",
							   url: "eliminarPC",
							   data: "selectedItems="+selectedItems,	 
							   success: function(data){
									$('#listaPuntoControl').html(data).ready(function () {
										hideLoading(); 
									});
							   }
							});//fin ajax	
					  });
				  });				
			},
			"Cancelar": function() {
				$(this).dialog("close");
				return false;
			}
		}
	});
}	


/*****************************************************************/
/**********************ABC Reglas de Negocio**********************/
/*****************************************************************/
/*Actualiza ó agrega una regla de negocio*/
function agregarEditarRN(editar){ 
	var nomRegla = $('#nomRegla').val();
	var patron = "";
	$("#mensajesApp").fadeOut("slow");
	//Validar campos del formulario
	if(nomRegla == null || $.trim(nomRegla) == ""){
   		$('#dialogo_1').html('Capture el nombre de la regla de negocio');
   		abrirDialogo();
 		return false;	
   	}else{
   		patron = /^([a-zA-Z0-9]*\(*\)*ñ*\s*á*é*í*ó*ú*A*É*Í*Ó*Ú*Ñ*´*)*$/;
		if(!nomRegla.match(patron)){
			  $('#dialogo_1').html('La regla de negocio no es válido,  se aceptan solo letras, números, espacios, vocales acentuadas, ñ y los signos "(´)"');
		   		abrirDialogo();
		 		return false;	
		}
   	}	
	var codRegla = -1;
	if(editar == 1){
		codRegla = $('#codRegla').val();
	}
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "agregarEditarRN",
						   data: "nomRegla="+nomRegla+
					  		 "&editar="+editar+
					  		 "&codRegla="+codRegla,
						   success: function(data){
								$('#pContenido').html(data).ready(function () {
									hideLoading();
									$('#nomRegla').val('');
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });
	  
}

/*Consigue los datos de una regla de negocio*/
function datosRN(codRegla){ 
	$("#mensajesApp").fadeOut("slow");
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "datosRN",
						   data: "codRegla="+codRegla+
						   		 "&editar=1",
						   success: function(data){
								$('#agregarEditarRN').html(data).ready(function () {
									hideLoading();
									$("#codRegla").css("color", "#000");
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });
	  
}
/*Elimina reglas de negocio seleccionados por el usuario*/
function eliminarRN(){ 	
	$('#mensajesApp').html('');
	var selectedItems = new Array();
	$("input[@name='itemSelect[]']:checked").each(function() {selectedItems.push($(this).val());});
	if (selectedItems.length == 0){ 
	    $('#dialogo_1').html('Por favor seleccione las reglas de negocio a eliminar.');
		abrirDialogo();
	    return false;
	}
	
	$('#dialogo_1').html('¿Está seguro de eliminar las reglas de negocio seleccionadas?');
	$('#dialogo_1').dialog({
		autoOpen: true,
		width: 300,
		show: "slide",
		hide: "fade",
		modal: true,
		buttons: {
			"Aceptar": function() {
				$(this).dialog("close");
				$("#espera").fadeIn('slow', function() {
					  $("#img-espera").fadeIn('slow', function(){
						  $.ajax({
							   async: false,
							   type: "POST",
							   url: "eliminarRN",
							   data: "selectedItems="+selectedItems,	 
							   success: function(data){
									$('#listaReglasNegocio').html(data).ready(function () {
										hideLoading(); 
									});
							   }
							});//fin ajax	
					  });
				  });				
			},
			"Cancelar": function() {
				$(this).dialog("close");
				return false;
			}
		}
	});
}	


/*****************************************************************/
/********************** ABC Tarifas ******************************/
/*****************************************************************/
/*Actualiza ó agrega una Tarifa*/
function agregarEditarTarifa(editar){ 
	var tllClave = $('#tllClave').val();
	var accountCategory = $('#accountCategory').val();
	var costo = $('#costo').val();
	var patron = "";
	$("#mensajesApp").fadeOut("slow");
	//Validar campos del formulario
	
	if(tllClave == -1 || accountCategory == -1 || (costo == null || costo == "")){
   		$('#dialogo_1').html('Debe capturar todos los datos obligatorios');
   		abrirDialogo();
 		return false;	
   	}	
	
	patron =/^\d{1,10}((\.\d{1,2})|(\.))?$/;
	if(!costo.match(patron)){
		$('#dialogo_1').html('El valor máximo del costo es de 10 digitos y 2 decimales. ');
   		abrirDialogo();
   		return false;	
	}
		
	var idTarifa = -1;
	if(editar == 1){
		idTarifa = $('#idTarifa').val();
	}
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "agregarEditarTarifa",
						   data: "tllClave="+tllClave+
						   	 "&accountCategory="+accountCategory+
						   	 "&costo="+costo+
					  		 "&editar="+editar+
					  		 "&idTarifa="+idTarifa,
						   success: function(data){
								$('#pContenido').html(data).ready(function () {
									hideLoading();
									$('#tllClave').val('-1');
									$('#accountCategory').val('-1');
									$('#costo').val('');
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });
	  
}

/*Consigue los datos de una tarifa*/
function datosTarifa(idTarifa){ 
	$("#mensajesApp").fadeOut("slow");
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "datosTarifa",
						   data: "idTarifa="+idTarifa+
						   		 "&editar=1",
						   success: function(data){
								$('#agregarEditarTarifa').html(data).ready(function () {
									hideLoading();
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });
	  
}
/*Elimina las tarifas seleccionados por el usuario*/
function eliminarTarifa(){ 	
	$('#mensajesApp').html('');
	var selectedItems = new Array();
	$("input[@name='itemSelect[]']:checked").each(function() {selectedItems.push($(this).val());});
	if (selectedItems.length == 0){ 
	    $('#dialogo_1').html('Por favor seleccione las tarifas a eliminar.');
		abrirDialogo();
	    return false;
	}
	
	$('#dialogo_1').html('¿Está seguro de eliminar las tarifas seleccionadas?');
	$('#dialogo_1').dialog({
		autoOpen: true,
		width: 300,
		show: "slide",
		hide: "fade",
		modal: true,
		buttons: {
			"Aceptar": function() {
				$(this).dialog("close");
				$("#espera").fadeIn('slow', function() {
					  $("#img-espera").fadeIn('slow', function(){
						  $.ajax({
							   async: false,
							   type: "POST",
							   url: "eliminarTarifa",
							   data: "selectedItems="+selectedItems,	 
							   success: function(data){
									$('#listaTarifas').html(data).ready(function () {
										hideLoading(); 
									});
							   }
							});//fin ajax	
					  });
				  });				
			},
			"Cancelar": function() {
				$(this).dialog("close");
				return false;
			}
		}
	});
}	

/*****************************************************************/
/********************** ABC Centrales ****************************/
/*****************************************************************/
function agregarEditarCentral(editar){ 	  
	var patron = "";
	var idCentral =0;
	//validando los campos del  formulario//
	var nomCentral = $('#nomCentral').val();
	
	var dirAcceso = $('#dirAcceso').val();
	var nomTablaCrudo = $('#nomTablaCrudo').val();
	var nomTablaFormato = $('#nomTablaFormato').val();
	var sqlSelect = $('#sqlSelect').val();
	var sqlInsert = $('#sqlInsert').val();
	var claveCodificacion = $('#claveCodificacion').val();
	var selectedItems = new Array();
	var activo = 1;
	if(editar == 1){
		idCentral = $('#idCentral').val();
		activo = $('input:radio[name=activo]:checked').val();
	}
	$('.ck').each(function() {selectedItems.push($(this).val());});
	
	
	if((nomCentral == null || nomCentral == "")|| (dirAcceso == null || dirAcceso == "")||
	   (nomTablaCrudo == null || nomTablaCrudo == "")|| (nomTablaFormato == null || nomTablaFormato == "")||
	   (sqlSelect == null || sqlSelect == "") || (sqlInsert == null || sqlInsert == "") || ( claveCodificacion == -1)){
		$('#dialogo_1').html('Debe capturar todos los datos obligatorios');
		abrirDialogo();		
		return false;	
	}
	if(nomCentral != null && nomCentral != ""){
   		patron = /^(\w*ñ*\s*\(*\)*á*é*í*ó*ú*A*É*Í*Ó*Ú*Ñ*)*$/;
		if(!nomCentral.match(patron)){
			  $('#dialogo_1').html('El nombre de la central no es válida, se aceptan solo alfanúmericos y los signos "(" , ")"');
		   		abrirDialogo(); 
		 		return false;	
		}
   	}	
	if(claveCodificacion == 3){
		var numCampos = $('#numCampos').val();
		var i;
		if(numCampos == null || numCampos == ""){
	   		$('#dialogo_1').html('Capture el número de campos del archivo de control');
	   		abrirDialogo();
	 		return false;	
	   	}else{
	   		for (i=1;i<=numCampos;i++){
	   			var l =  $('#l'+i).val();
		   		if((l == "" || l == null) ){
		   			$('#dialogo_1').html('Capture la longitud del campo '+i);
			   		abrirDialogo();
			 		return false;
		   		 }else{
		   			 if(!l.match(/^\d*$/)){
			   			$('#dialogo_1').html('La longitud "'+l+' del campo '+i+' es inválido se aceptan solo números');
				   		abrirDialogo();
				 		return false;
		   			 }
		   		 }
	   		}
	   	}
	}
	$("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "agregarEditarCentral",
						   data: "selectedItems="+selectedItems+
						   		"&nomCentral="+nomCentral+
						   		"&dirAcceso="+dirAcceso+
						   		"&nomTablaCrudo="+nomTablaCrudo+
						   		"&nomTablaFormato="+nomTablaFormato+
						   		"&sqlSelect="+sqlSelect+
						   		"&sqlInsert="+sqlInsert+
						   		"&claveCodificacion="+claveCodificacion+
						   		"&idCentral="+idCentral+
						   		"&activo="+activo+
						   		"&editar="+editar,
						   success: function(data){
								$('#pContenido').html(data).ready(function () {
									hideLoading();
									
								});
								
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });
	  
}//termina metodo de agregarEditarCentral 

/*Consigue los datos de una tarifa*/
function datosCentral(idCentral){ 
	$("#mensajesApp").fadeOut("slow");
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "datosCentral",
						   data: "idCentral="+idCentral+
						   		 "&editar=1",
						   success: function(data){
								$('#agregarEditarCentral').html(data).ready(function () {
									hideLoading();
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });
	  
}
function eliminarInhabilitarCentral(idCentral,borrarInhabilitar){ 	
	$('#mensajesApp').html('');
	if(borrarInhabilitar == 0){
		$('#dialogo_1').html('¿Está seguro de eliminar la central?');	
	}else if (borrarInhabilitar == 1){
		$('#dialogo_1').html('¿Está seguro de inhabilitar la central?');
	}else{
		$('#dialogo_1').html('¿Está seguro de habilitar la central?');
	}
	
	$('#dialogo_1').dialog({
		autoOpen: true,
		width: 300,
		show: "slide",
		hide: "fade",
		modal: true,
		buttons: {
			"Aceptar": function() {
				$(this).dialog("close");
				 $("#espera").fadeIn('slow', function() {
					  $("#img-espera").fadeIn('slow', function(){
						  	$("#pContenido").slideUp('slow', function() {
								  $.ajax({
									   async: false,
									   type: "POST",
									   url: "eliminarInhabilitarCentral",
									   data: "borrarInhabilitar="+borrarInhabilitar+
									   		"&idCentral="+idCentral,
									   success: function(data){
											$('#listaCentral').html(data).ready(function () {
												hideLoading();
											});	
									   }
									});//fin ajax	
								  $("#pContenido").fadeIn("slow");
						  	 });
					  });
				  });			
			},
			"Cancelar": function() {
				$(this).dialog("close");
				return false;
			}
		}
	});

}	

/*****************************************************************/
/********************** ABC Configuración de Reglas **************/
/*****************************************************************/
function agregarEditarConfReglas(editar){ 	
	var idRegla = $('#idRegla').val();
	var idProceso = $('#idProceso').val();
	var idCentral = 0;
	var idMapeoRegla = 0;
	var codRegla = $('#codRegla').val();
	if(editar == 1){
		idCentral = $('#idCentral').val();
		idMapeoRegla = $('#idMapeoRegla').val();
	}
	var selectedItems = new Array();
	$("input[@name='itemSelect[]']:checked").each(function() {selectedItems.push($(this).val());});	
	
	if(idRegla == -1){
   		$('#dialogo_1').html('Seleccione la regla de negocio');
   		abrirDialogo();
 		return false;	
   	}
	if(idProceso == -1){
   		$('#dialogo_1').html('Seleccione el punto de control');
   		abrirDialogo();
 		return false;	
   	}
	if(editar == 1){
		if(idCentral == -1){
			$('#dialogo_1').html('Seleccione la central');
	   		abrirDialogo();
	 		return false;	
	   	}
	}else{
		if (selectedItems.length == 0){ 
			$('#dialogo_1').html('Seleccione la central o centrales');
	   		abrirDialogo();
	 		return false;	
		}
	}
	
	if(codRegla == null || codRegla == ""){
   		$('#dialogo_1').html('Capture la condición de la configuración de regla');
   		abrirDialogo();
 		return false;	
   	}
	
	
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "agregarEditarConfReglas",
						   data: "editar="+editar+
						   		"&idRegla="+idRegla+
						   		"&idProceso="+idProceso+
						   		"&idCentral="+idCentral+
						   		"&codRegla="+codRegla+
						   		"&idMapeoRegla="+idMapeoRegla+
						   		"&selectedItems="+selectedItems,
						   success: function(data){
								$('#pContenido').html(data).ready(function () {
									hideLoading();
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });
}

/*Consigue los datos de configuracion de reglas*/
function datosMapeoReglas(idMapeoRegla,editar){ 
	$("#mensajesApp").fadeOut("slow");
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "datosMapeoReglas",
						   data: "idMapeoRegla="+idMapeoRegla+
						   		 "&editar = "+editar,
						   success: function(data){
								$('#pContenido').html(data).ready(function () {
									hideLoading();
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });	  
}

function eliminarConfReglas(){ 	
	var selectedItems = new Array();
	$("input[@name='itemSelect[]']:checked").each(function() {selectedItems.push($(this).val());});
	if (selectedItems.length == 0){ 
	    $('#dialogo_1').html('Por favor seleccione las configuraciones de reglas a eliminar.');
		abrirDialogo();
	    return false;
	}
	
	$('#dialogo_1').html('¿Está seguro de eliminar las configuraciones de reglas seleccionadas?');
	$('#dialogo_1').dialog({
		autoOpen: true,
		width: 300,
		show: "slide",
		hide: "fade",
		modal: true,
		buttons: {
			"Aceptar": function() {
				$(this).dialog("close");
				$("#espera").fadeIn('slow', function() {
					  $("#img-espera").fadeIn('slow', function(){
						  $.ajax({
							   async: false,
							   type: "POST",
							   url: "eliminarConfReglas",
							   data: "selectedItems="+selectedItems,	 
							   success: function(data){
									$('#pContenido').html(data).ready(function () {
										hideLoading(); 
									});
							   }
							});//fin ajax	
					  });
				  });				
			},
			"Cancelar": function() {
				$(this).dialog("close");
				return false;
			}
		}
	});
}	

/*****************************************************************/
/**********************ABC Usuarios*******************************/
/*****************************************************************/
function agregarEditarUsuario(editar){ 	
	
	var nomUsuario = $('#nomUsuario').val();
	var contrasenia = $('#contrasenia').val();
	var nombre = $('#nombre').val();
	var paterno = $('#paterno').val();
	var materno = $('#materno').val();
	var email = $('#email').val();
	var idPerfil = $('#idPerfil').val();
	var idUsuario = 0;
	
	if(editar == 1){
		idUsuario = $('#idUsuario').val();
	}
	
	if ((nombre == null || nombre =="") || 
		   (paterno == null || paterno =="") || 
		   (idPerfil == -1) || 
		   (email == null || email =="")||
		   (nomUsuario == null || nomUsuario =="")||
		   (contrasenia == null || contrasenia =="")){
		$('#dialogo_1').html('Debe capturar todos los datos obligatorios');
		abrirDialogo();
	 	return false;	
	}
	
   if(nombre != null && nombre != ""){
	   patron = /^([a-zA-Z]*ñ*\s*á*é*í*ó*ú*Á*É*Í*Ó*Ú*Ñ*)*$/;
 		if(!nombre.match(patron)){
 			$('#dialogo_1').html('El nombre de usuario no es válido, se aceptan solo letras, espacios, vocales acentuadas y la ñ');
	   		abrirDialogo();
	   		return false;	
 		}
   }
   if(paterno != null && paterno != ""){
	   patron = /^([a-zA-Z]*ñ*\s*á*é*í*ó*ú*Á*É*Í*Ó*Ú*Ñ*)*$/;
		if(!paterno.match(patron)){
			$('#dialogo_1').html('El apellido paterno no es válido, se aceptan solo letras, espacios, vocales acentuadas y la ñ');
	   		abrirDialogo();
	   		return false;	
		}	
   }
   if(materno != null || materno != ""){	
		patron = /^([a-zA-Z]*ñ*\s*á*é*í*ó*ú*Á*É*Í*Ó*Ú*Ñ*)*$/;
		if(!materno.match(patron)){
			$('#dialogo_1').html('El apellido materno no es válido, se aceptan solo letras, espacios, vocales acentuadas y la ñ');
	   		abrirDialogo();
	   		return false;	
		}
	}
   if(email != null && email != ""){
	   patron = /^[a-zA-Z0-9]+([\._-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+([\._-]?[a-zA-Z0-9]+)*\.[a-zA-Z]{2,}$/;
		if(!email.match(patron)){
			$('#dialogo_1').html('La cuenta de correo no es válida');
	   		abrirDialogo();
	   		return false;	
		}
	}
   
   if(nomUsuario != null && nomUsuario != ""){
	   patron = /^(\w*ñ*\s*á*é*í*ó*ú*Á*É*Í*Ó*Ú*Ñ*\.*)*$/;
 		if(!nomUsuario.match(patron)){
 			$('#dialogo_1').html('El nombre de usuario no es válido, se aceptan solo alfanuméricos y el signo "." ');
	   		abrirDialogo();
	   		return false;	
 		}	
  	}
  if(contrasenia != null && contrasenia != ""){
	  patron = /^(\w*\s*-*_*\.*%*\$*#*\/*\**)*$/;
		if(!contrasenia.match(patron)){
			$('#dialogo_1').html('La contraseña no es válida, se aceptan letras, números y los signos “-_.%$#/*"');
	   		abrirDialogo();
	   		return false;	
		}	
 	} 	  
	
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "agregarEditarUsuario",
						   data: "editar="+editar+
					   		"&nomUsuario="+nomUsuario+
					   		"&contrasenia="+contrasenia+
					   		"&nombre="+nombre+
					   		"&paterno="+paterno+
					   		"&materno="+materno+
					   		"&email="+email+
					   		"&idPerfil="+idPerfil+
					   		"&idUsuario="+idUsuario,						   		
						   success: function(data){
								$('#pContenido').html(data).ready(function () {
									hideLoading();
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });
}



/*Consigue los datos de un usuario*/
function datosUsuario(idUsuario){ 
	$("#mensajesApp").fadeOut("slow");
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "datosUsuario",
						   data: "idUsuario="+idUsuario+
						   		"&editar=1",
						   success: function(data){
								$('#agregarEditarUsuario').html(data).ready(function () {
									hideLoading();
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });	  
}

function eliminarUsuario(){ 	
	$('#mensajesApp').html('');
	var selectedItems = new Array();
	$("input[@name='itemSelect[]']:checked").each(function() {selectedItems.push($(this).val());});
	if (selectedItems.length == 0){ 
	    $('#dialogo_1').html('Por favor seleccione los usuarios a eliminar.');
		abrirDialogo();
	    return false;
	}
	
	$('#dialogo_1').html('¿Está seguro de eliminar los usuarios seleccionados?');
	$('#dialogo_1').dialog({
		autoOpen: true,
		width: 300,
		show: "slide",
		hide: "fade",
		modal: true,
		buttons: {
			"Aceptar": function() {
				$(this).dialog("close");
				$("#espera").fadeIn('slow', function() {
					  $("#img-espera").fadeIn('slow', function(){
						  $.ajax({
							   async: false,
							   type: "POST",
							   url: "eliminarUsuario",
							   data: "selectedItems="+selectedItems,	 
							   success: function(data){
									$('#listaUsuarios').html(data).ready(function () {
										hideLoading(); 
									});
							   }
							});//fin ajax	
					  });
				  });				
			},
			"Cancelar": function() {
				$(this).dialog("close");
				return false;
			}
		}
	});
}	

/*****************************************************************/
/**********************ABC Perfiles*******************************/
/*****************************************************************/
function agregarEditarPerfil(editar){ 	
	
	var nombrePerfil = $('#nombrePerfil').val();
	var descripcion = $('#descripcion').val();
	var selectedItems = new Array();
	var idPerfil = 0;
	$("input[@name='itemPerfil[]']:checked").each(function() {selectedItems.push($(this).val());});
	if(editar == 1){
		idPerfil = $('#idPerfil').val();
	}
	
	if ((nombrePerfil == null || nombrePerfil =="") || 
	     selectedItems.length == 0){
		$('#dialogo_1').html('Debe capturar todos los datos obligatorios');
		abrirDialogo();
	 	return false;	
		}
   if(nombrePerfil != null && nombrePerfil != ""){
	   patron = /^([a-zA-Z0-9]*ñ*\s*á*é*í*ó*ú*Á*É*Í*Ó*Ú*Ñ*)*$/;
  		if(!nombrePerfil.match(patron)){
  			$('#dialogo_1').html('El nombre del perfil no es válido, se aceptan letras, números, espacios, vocales acentuadas y la ñ');
	   		abrirDialogo();
	   		return false;	
  		}	
   	}
   
   if(descripcion != null && descripcion != ""){
		patron = /^(\w*ñ*á*é*í*ó*ú*Á*É*Í*Ó*Ú*Ñ*\s*-*_*\.*%*\$*#*\/*\**)*$/;
		if(!descripcion.match(patron)){
			$('#dialogo_1').html('La descripción no es válida, se aceptan letras, números y los signos “-_.%$#/*"');
	   		abrirDialogo();
	   		return false;	
		}
  	}
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "agregarEditarPerfil",
						   data: "editar="+editar+
					   		"&nombrePerfil="+nombrePerfil+
					   		"&descripcion="+descripcion+
					   		"&selectedItems="+selectedItems+
					   		"&idPerfil="+idPerfil,
						   success: function(data){							   
								$('#pContenido').html(data).ready(function () {
									hideLoading();
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });
}


/*Consigue los datos del perfil*/
function datosPerfil(idPerfil){ 
	$("#mensajesApp").fadeOut("slow");
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "datosPerfil",
						   data: "idPerfil="+idPerfil+
						   		"&editar=1",
						   success: function(data){
								$('#agregarEditarPerfil').html(data).ready(function () {
									hideLoading();
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });	  
}

function eliminarPerfil(){ 	
	$('#mensajesApp').html('');
	var selectedItems = new Array();
	$("input[@name='itemSelect[]']:checked").each(function() {selectedItems.push($(this).val());});
	if (selectedItems.length == 0){ 
	    $('#dialogo_1').html('Por favor seleccione los perfiles a eliminar.');
		abrirDialogo();
	    return false;
	}
	
	$('#dialogo_1').html('¿Está seguro de eliminar los perfiles seleccionados?');
	$('#dialogo_1').dialog({
		autoOpen: true,
		width: 300,
		show: "slide",
		hide: "fade",
		modal: true,
		buttons: {
			"Aceptar": function() {
				$(this).dialog("close");
				$("#espera").fadeIn('slow', function() {
					  $("#img-espera").fadeIn('slow', function(){
						  $.ajax({
							   async: false,
							   type: "POST",
							   url: "eliminarPerfil",
							   data: "selectedItems="+selectedItems,	 
							   success: function(data){
									$('#listaPerfiles').html(data).ready(function () {
										hideLoading(); 
									});
							   }
							});//fin ajax	
					  });
				  });				
			},
			"Cancelar": function() {
				$(this).dialog("close");
				return false;
			}
		}
	});
}	
/*****************************************************************/
/********************** ABC Reportes *****************************/
/*****************************************************************/
/*Actualiza ó agrega un reporte*/
function agregarEditarReporte(editar){ 
	var nomReporte = $('#nomReporte').val();
	var idProceso = $('#idProceso').val();
	var sqlSelect = $('#sqlSelect').val();
	var sqlFrom = $('#sqlFrom').val();
	var sqlWhere = $('#sqlWhere').val();
	var sqlGroupBy = $('#sqlGroupBy').val();
	var sqlHaving = $('#sqlHaving').val();
	var sqlOrderBy = $('#sqlOrderBy').val();
	var columnaX = $('#columnaX').val();
	var etiquetaX = $('#etiquetaX').val();
	var columnaY = $('#columnaY').val();
	var etiquetaY = $('#etiquetaY').val();
	var idReporte = -1;
	var patron = "";
	$("#mensajesApp").fadeOut("slow");
	if($('input:radio[name=chkgrafica]:checked').val() == -2){
		columnaX="";
		etiquetaX="";
		columnaY="";
		etiquetaY="";
	}	
	//Validar campos del formulario	
	if ((nomReporte == null || nomReporte =="") && 
		(sqlSelect == null || sqlSelect =="") && 
		(idProceso == 0 || idProceso == -1) && 
		(sqlFrom == null || sqlFrom =="")&&
		(sqlWhere == null || sqlWhere =="")){
			$('#dialogo_1').html('Debe capturar todos los datos obligatorios');
			abrirDialogo();
		 	return false;	
	}
	
	if(nomReporte != null && nomReporte != ""){
		patron = /^(\w*ñ*\s*á*é*í*ó*ú*A*É*Í*Ó*Ú*Ñ*)*$/;
	    if(!nomReporte.match(patron)){
		$('#dialogo_1').html('El nombre no es válido, se aceptan solo alfanuméricos');
		abrirDialogo();
	 	return false;
	    }
	}
	
	if(sqlSelect != null && sqlSelect != ""){
		patron = /^(\w*\s*\[*\]*\(*\)*_*\**\.*=*-*\+*\/*,*\'*\|*)*$/;
	    if(!sqlSelect.match(patron)){
		$('#dialogo_1').html('El Select no es válido, se aceptan solo alfanuméricos y caracteres como: ()[]_-*+.,/|');
		abrirDialogo();
	 	return false;
	    }
	}
	
	if(sqlFrom != null && sqlFrom != ""){
		patron = /^(\w*\s*\[*\]*\(*\)*:*\.*=*_*)*$/;
	    if(!sqlFrom.match(patron)){
		$('#dialogo_1').html('El From no es válido, se aceptan solo alfanuméricos y caracteres como: ()[].=_');
		abrirDialogo();
	 	return false;
	    }
	}
	
	if(sqlWhere != null && sqlWhere != ""){
		patron = /^(\w*\s*\[*\]*\(*\)*:*\.*=*_*-*\**\'*\%*\<*\>*,*\/*)*$/;
	    if(!sqlWhere.match(patron)){
		$('#dialogo_1').html('El Where no es válido, se aceptan solo alfanuméricos y caracteres como: ()[]_.,-=*/');
		abrirDialogo();
	 	return false;
	    }
	}
	
	if(sqlGroupBy != null && sqlGroupBy != ""){
		patron = /^(\w*\s*\[*\]*\(*\)*_*\**\.*\<*\>*,*)*$/;
	    if(!sqlGroupBy.match(patron)){
		$('#dialogo_1').html('El GroupBy no es válido, se aceptan solo alfanuméricos y caracteres como: ()[].,_*<>');
		abrirDialogo();
	 	return false;
	    }
	}
	
	if(sqlHaving != null && sqlHaving != ""){
		patron = /^(\w*\s*\[*\]*\(*\)*:*\.*_*\**\.*\<*\>*,*)*$/;
	    if(!sqlHaving.match(patron)){
		$('#dialogo_1').html('El Having no es válido, se aceptan solo alfanuméricos y caracteres como: ()[].,_<>');
		abrirDialogo();
	 	return false;
	    }
	}
	
	if(sqlOrderBy != null && sqlOrderBy != ""){
		patron = /^(\w*\s*\[*\]*\(*\)*:*\.*=*\**_*-*\<*\>*,*)*$/;
	    if(!sqlOrderBy.match(patron)){
		$('#dialogo_1').html('El OrderBy no es válido, se aceptan solo alfanuméricos y caracteres como: ()[]_.,-=<>');
		abrirDialogo();
	 	return false;
	    }
	}

	if($('input:radio[name=chkgrafica]:checked').val() == -1){
		if((columnaX == null || columnaX =="") || 
		   (columnaY == null || columnaY =="") || 
		   (etiquetaX == null || etiquetaX =="") || 
		   (etiquetaY == null || etiquetaY =="")){
			$('#dialogo_1').html('Debe capturar todos los campos obligatorios');
			abrirDialogo();
		 	return false;
		}
	}
	if(columnaX != null && columnaX != ""){
		patron = /^[a-zA-Z0-9]+([_]?[a-zA-Z0-9]+)$/;
		if(!columnaX.match(patron)){
		$('#dialogo_1').html('La Columna X no es válido, se aceptan solo letras y caracter como: _');
		abrirDialogo();
	 	return false;
	    }
	}
	
	if(columnaY != null && columnaY != ""){
		patron = /^[a-zA-Z0-9]+([_]?[a-zA-Z0-9]+)$/;
	    if(!columnaY.match(patron)){
		$('#dialogo_1').html('La Columna Y no es válido, se aceptan solo letras y caracter como: _');
		abrirDialogo();
	 	return false;
	    }
	}
	
	if(etiquetaX != null && etiquetaX != ""){
		patron = /^(\w*ñ*\s*á*é*í*ó*ú*Á*É*Í*Ó*Ú*Ñ*)*$/;
	    if(!etiquetaX.match(patron)){
		$('#dialogo_1').html('La Columna X no es válido, se aceptan solo letras y caracter como: _');
		abrirDialogo();
	 	return false;
	    }
	}
	
	if(etiquetaY != null && etiquetaY != ""){
		patron = /^(\w*ñ*\s*á*é*í*ó*ú*Á*É*Í*Ó*Ú*Ñ*)*$/;
	    if(!etiquetaY.match(patron)){
		$('#dialogo_1').html('La Columna Y no es válido, se aceptan solo letras y caracter como: _');
		abrirDialogo();
	 	return false;
	    }
	}	
	
	if(editar == 1){
		idReporte = $('#idReporte').val();
	}
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "agregarEditarReporte",
						   data: "nomReporte="+nomReporte+
						   	 "&idProceso="+idProceso+
						   	 "&sqlSelect="+sqlSelect+
						   	 "&sqlFrom="+sqlFrom+
						   	 "&sqlWhere="+sqlWhere+
						   	 "&sqlGroupBy="+sqlGroupBy+
						   	 "&sqlHaving="+sqlHaving+
						   	 "&sqlOrderBy="+sqlOrderBy+
						   	 "&columnaX="+columnaX+
						   	 "&etiquetaX="+etiquetaX+
						   	 "&columnaY="+columnaY+
					  		 "&etiquetaY="+etiquetaY+
					  		 "&idReporte="+idReporte+
					  		 "&editar="+editar,
						   success: function(data){
								$('#pContenido').html(data).ready(function () {
									hideLoading();
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });
	  
}

/*Consigue los datos de una regla de negocio*/
function datosReporte(idReporte){ 
	$("#mensajesApp").fadeOut("slow");
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "datosReporte",
						   data: "idReporte="+idReporte+
						   		 "&editar=1",
						   success: function(data){
								$('#agregarEditarReportes').html(data).ready(function () {
									hideLoading();
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });
	  
}

function eliminarReporte(){ 	
	//$('#mensajesApp').html('');
	var selectedItems = new Array();
	$("input[@name='itemSelect[]']:checked").each(function() {selectedItems.push($(this).val());});
	if (selectedItems.length == 0 || selectedItems == -2){ 
	    $('#dialogo_1').html('Por favor seleccione los reportes a eliminar.');
		abrirDialogo();
	    return false;
	}
		
	$('#dialogo_1').html('¿Está seguro de eliminar los reportes seleccionados?');
	$('#dialogo_1').dialog({
		autoOpen: true,
		width: 300,
		show: "slide",
		hide: "fade",
		modal: true,
		buttons: {
			"Aceptar": function() {
				$(this).dialog("close");
				$("#espera").fadeIn('slow', function() {
					  $("#img-espera").fadeIn('slow', function(){
						  $.ajax({
							   async: false,
							   type: "POST",
							   url: "eliminarReporte",
							   data: "selectedItems="+selectedItems,	 
							   success: function(data){
									$('#listaReportes').html(data).ready(function () {
										hideLoading(); 
									});
							   }
							});//fin ajax	
					  });
				  });				
			},
			"Cancelar": function() {
				$(this).dialog("close");
				return false;
			}
		}
	});
}	



/*****************************************************************/
/********************** Log Aplicacion ***************************/
/*****************************************************************/

function chkCamposLogs(){
	var fechaInicio = $('#fechaInicio').val();
	var fechaFin = $('#fechaFin').val();
	var idUsuario = $('#idUsuario').val();
	var descripcion = $('#descripcion').val();
	
	if((fechaInicio == null || fechaInicio =="") && 
	   (fechaFin == null || fechaFin =="") && 
	   (idUsuario == 0 || idUsuario == -1) && 
	   (descripcion == null || descripcion =="")){
		$('#dialogo_1').html('Debe capturar al menos un dato');
		abrirDialogo();
	 	return false;
	}
	
	if(fechaFin != null && fechaFin!=""){
		if(fechaInicio==null || fechaInicio==""){
			$('#dialogo_1').html('Debe capturar la fecha inicio');
			abrirDialogo();
		 	return false;
		}
	}
		
	if(fechaInicio !=null && fechaInicio!=""){
		if(fechaFin != null && fechaFin !=""){
			if(fechaInicio > fechaFin){
			 	$('#dialogo_1').html('La fecha inicio no puede ser mayor a la fecha final');
				abrirDialogo();
			 	return false;
		    } 	
		}
	}
	
	
	if(descripcion != null && descripcion != ""){
		patron = /^(\w*ñ*\s*á*é*í*ó*ú*Á*É*Í*Ó*Ú*Ñ*\[*\]*\(*\)*:*\.*=*_*-*)*$/;
   		if(!descripcion.match(patron)){
   			$('#dialogo_1').html('La descripcion no es válida, se aceptan solo alfanuméricos y caracteres como: ()[]:._-= ');
   			abrirDialogo();
   			return false;	
   		}	
	}
	
		
}

/*****************************************************************/
/************************ De Proceso *****************************/
/*****************************************************************/

function chkCamposProceso(){
	var fechaInicio = $('#fechaInicio').val();
	var idProceso = $('#idProceso').val();
	var idCentral = $('#idCentral').val();
	var descripcion = $('#descripcion').val();
	
	if((fechaInicio == null || fechaInicio =="") && 
	   (idProceso == 0 || idProceso == -1) && 
	   (idCentral == 0 || idCentral == -1) && 
	   (descripcion == null || descripcion =="")){
		$('#dialogo_1').html('Debe capturar al menos un dato');
		abrirDialogo();
	 	return false;
	}

	if(descripcion != null && descripcion != ""){
		patron = /^(\w*ñ*\s*á*é*í*ó*ú*Á*É*Í*Ó*Ú*Ñ*\[*\]*\(*\)*:*\.*=*_*-*\**)*$/;
   		if(!descripcion.match(patron)){
   			$('#dialogo_1').html('La descripcion no es válida, se aceptan solo alfanuméricos y caracteres como: ()[]:._-= ');
   			abrirDialogo();
   			return false;	
   		}	
	}
	
		
}


/*****************************************************************/
/************************ Re Proceso *****************************/
/*****************************************************************/

function chkCamposReproceso(){

	var idCentral = $('#idCentral').val();

	if (idCentral == 0 || idCentral == -1) {
				$('#dialogo_1').html('Debe seleccionar la central');
				abrirDialogo();
			 	return false;
			}
		
}


/*****************************************************************/
/********************** Consulta de Reporte **********************/
/*****************************************************************/
function chkCamposReporte(){
	var idProceso = $('#idProceso').val();
	var idCentral = $('#idCentral').val();
	var idReporte = $('#idReporte').val();
	var fechaInicio = $('#fechaInicio').val();
	var fechaFin = $('#fechaFin').val();
	
	if(idProceso == -1){
		$('#dialogo_1').html('El punto de control es requerido');
		abrirDialogo();
	 	return false;
	}
	
	if(idReporte == -1){
		$('#dialogo_1').html('El reporte es requerido');
		abrirDialogo();
	 	return false;
	}
	
	if(fechaFin != null && fechaFin!=""){
		if(fechaInicio==null || fechaInicio==""){
			$('#dialogo_1').html('Debe capturar la fecha inicio');
			abrirDialogo();
		 	return false;
		}
	}
	/*	
	if(fechaInicio !=null && fechaInicio!=""){
		if(fechaFin != null && fechaFin !=""){
			if(fechaInicio > fechaFin){
			 	$('#dialogo_1').html('La fecha inicio no puede ser mayor a la fecha final');
				abrirDialogo();
			 	return false;
		    } 	
		}
	}*/
}


function altaReporte(){ 	  
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "altaReporte",	 
						   success: function(data){
								$('#pContenido').html(data).ready(function () {
									hideLoading();
									
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });
	  
}

function generarReporte(){ 	  
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "generarReporte",	 
						   success: function(data){
								$('#resultadoReportes').html(data).ready(function () {
									hideLoading();
									
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });
	  
}
function consultarProceso(){ 	  
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "consultarProceso",	 
						   success: function(data){
								$('#resultadoConsulta').html(data).ready(function () {
									hideLoading();
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });
	  
}

function consultarLogs(){ 	  
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow', function(){
			  	$("#pContenido").slideUp('slow', function() {
					  $.ajax({
						   async: false,
						   type: "POST",
						   url: "consultarLogs",	 
						   success: function(data){
								$('#resultadoLogs').html(data).ready(function () {
									hideLoading();
								});
						   }
						});//fin ajax	
					  $("#pContenido").fadeIn("slow");
			  	 });
		  });
	  });
	  
}

function chkTodos(){ 
	if($(".check_todos").is(":checked")) {
		$(".ck:checkbox:not(:checked)").attr("checked", "checked");
	 }else{
		 $(".ck:checkbox:checked").removeAttr("checked");
	 }
}

function chkCamposLogin(){ 
	var nombreUsuario = $('#nombreUsuario').val();
	var password = $('#password').val();
	
	if(nombreUsuario == null || nombreUsuario == ""){
 		$('#dialogo_1').html('Capture el usuario');
 		abrirDialogo();
		return false;	
 	}else{
 		
 	}
	if(password == null || password == ""){
 		$('#dialogo_1').html('Capture el password');
 		abrirDialogo();
		return false;	
 	}
	
}

function abrirDialogo() {
	$.fx.speeds._default = 300;
	$(function() {
	    $( "#dialogo_1" ).dialog({
	        autoOpen: true,
	        resizable:false,
	        show: "slide",
	        hide: "fade",
	        width:300,
	modal: true,
	buttons: {
		Ok: function() {
			$( this ).dialog( "close" );
		}   
	}
	    });

	    $( "#open_1" ).click(function() {
	        $( "#dialogo_1" ).dialog( "open" );
	        return false;
	    });

	$('.ui-widget-overlay').live('click', function() {
	     $('#dialogo_1').dialog( "close" );
	    });
	});	
}

$(document).ready(function() {
	//Tooltips
	$(".res_descripcion").hover(function(){
		tip = $(this).find('.tooltip');
		tip.show(); 
	}, function() {
		tip.hide(); 		  
	}).mousemove(function(e) {
		var mousex = e.pageX + 20; 
		var mousey = e.pageY + 20;
		var tipWidth = tip.width(); 
		var tipHeight = tip.height(); 
		var tipVisX = $(window).width() - (mousex + tipWidth);
		var tipVisY = $(window).height() - (mousey + tipHeight);
		  
		if ( tipVisX < 20 ) { 
			mousex = e.pageX - tipWidth - 20;
		} if ( tipVisY < 20 ) { 
			mousey = e.pageY - tipHeight - 20;
		} 
		tip.css({  top: mousey, left: mousex});
	});
});


$(document).ready(function() {
	//Tooltips
	$(".ayuda_g").hover(function(){
		tip = $(this).find('.tooltip');
		tip.show(); 
	}, function() {
		tip.hide(); 		  
	}).mousemove(function(e) {
		var mousex = e.pageX + 20; 
		var mousey = e.pageY + 20;
		var tipWidth = tip.width(); 
		var tipHeight = tip.height(); 
		var tipVisX = $(window).width() - (mousex + tipWidth);
		var tipVisY = $(window).height() - (mousey + tipHeight);
		  
		if ( tipVisX < 20 ) { 
			mousex = e.pageX - tipWidth - 20;
		} if ( tipVisY < 20 ) { 
			mousey = e.pageY - tipHeight - 20;
		} 
		tip.css({  top: mousey, left: mousex});
	});
});
function ayuda(){
	//Tooltips
	$(".ayuda_g").hover(function(){
		tip = $(this).find('.tooltip');
		tip.show(); 
	}, function() {
		tip.hide(); 		  
	}).mousemove(function(e) {
		var mousex = e.pageX + 20; 
		var mousey = e.pageY + 20;
		var tipWidth = tip.width(); 
		var tipHeight = tip.height(); 
		var tipVisX = $(window).width() - (mousex + tipWidth);
		var tipVisY = $(window).height() - (mousey + tipHeight);
		  
		if ( tipVisX < 20 ) { 
			mousex = e.pageX - tipWidth - 20;
		} if ( tipVisY < 20 ) { 
			mousey = e.pageY - tipHeight - 20;
		} 
		tip.css({  top: mousey, left: mousex});
	});
}


function showLoading() {
	  $("#espera").fadeIn('slow', function() {
		  $("#img-espera").fadeIn('slow');
	  });
}

function hideLoading() {
	  $("#img-espera").fadeOut("slow", function() {
		  $("#espera").fadeOut("slow");
	  });
}

function limpiarMsg(){
	$('#mensajesApp').html('');
}