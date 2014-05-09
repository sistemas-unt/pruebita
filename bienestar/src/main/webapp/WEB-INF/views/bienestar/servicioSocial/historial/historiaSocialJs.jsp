<script type="text/javascript">


$(document).on ("ready", function() {
	sumarEgresos();
	sumarIngresos();
	
	var categ = "${model.economica[20]}";
	categoria(categ);
	 $('#form_problematica').submit(function(event) {          
		
			 $.post('${pageContext.request.contextPath}/bienestar/problematica.htm', $(this).serialize(), function(response) {	          
// 		          alert(response);
				  $('#problematica_message').val("");
		          var split = response.split(',');
					
		          var message = split[2];
		          var fecha = split[1];
		          var user = split[0];
		          $('#comments').append('<div class="itemdiv commentdiv">'+
		        		  '	<div class="user">	<img alt="Bob Does Avatar" src="../assets/avatars/avatar.png" />	</div>	'+
		        		  '	<div class="body">	<div class="name"><a href="#">'+user+'</a></div>'+
		        		  '<div class="time">	<i class="icon-time"></i> <span class="green">'+fecha+'</span></div>'+
		        		  '<div class="text"><i class="icon-quote-left"></i>'+message+'</div>	</div>	</div>');		      
		          
		        });  
		       
		    event.preventDefault();  
	  });  
	 
	 $('#form_observacion').submit(function(event) {          
			
		 $.post('${pageContext.request.contextPath}/bienestar/observacion.htm', $(this).serialize(), function(response) {	          
// 	          alert(response);
				$('#observacion_message').val("");
		         var split = response.split(',');
					
		          var message = split[2];
		          var fecha = split[1];
		          var user = split[0];
		          $('#dialogs').append('<div class="itemdiv dialogdiv">'+
					'<div class="user"><img alt="Alexas Avatar" src="../assets/avatars/avatar1.png" /></div>'+
					'<div class="body"><div class="time">'+
					'<i class="icon-time"></i> <span class="green">'+fecha+'</span></div>'+
					'<div class="name"><a href="#">'+user+'</a></div>'+
					'<div class="text">'+message+'</div></div></div>');          
	          
	        });  
	       
	    event.preventDefault();  
  });
	 
	 $('#form_prestacion').submit(function(event) {          
			
		 $.post('${pageContext.request.contextPath}/bienestar/prestacion.htm', $(this).serialize(), function(response) {	          
// 	          alert(response);
	          $('#prestacion_problematica').val("");
	          $('#prestacion_resultado').val("");
	          var split = response.split(',');
				
	          var persona = split[0];
	          var fecha = split[1];
	          var problematica = split[2];
	          var resultado = split[3];
	          var count = split[4];
		      $('#prestacion_table').append('<tr><td class="center">'+count+'</td>'+
							'<td class="center">'+fecha+'</td>'+
							'<td class="center">'+problematica+'</td>'+
							'<td class="center">'+resultado+'</td>'+
							'<td class="center">'+persona+'</td></tr>');	          
	          
	        });  
	       
	    event.preventDefault();  
  });
	 
	 $('#form_categoria').submit(function(event) {          
			var asd =  $(this).serialize();
		 $.post('${pageContext.request.contextPath}/bienestar/cambiar_categoria.htm',asd, function(response) {	        
	          categoria(response);
	          $('#categoria_motivo').val("");
	          $('#Asistenta').modal('hide');

	        });  
	       
	    event.preventDefault();  
  });
	 
});

	function categoria(categoria) {
		if (categoria == 1) {
			document.getElementById('categoria').innerHTML = ("CATEGORIA A");
		} else if(categoria == 2){
			document.getElementById('categoria').innerHTML = ("CATEGORIA B");
		}else if(categoria == 3){
			document.getElementById('categoria').innerHTML = ("CATEGORIA C");	
		}else{
			document.getElementById('categoria').innerHTML = ("SIN CATEGORIA");
		}
	}
	
	function sumarIngresos(){
		var eco1 = parseFloat("${model.economica[7]}");
		var eco2 = parseFloat("${model.economica[8]}");
		var eco3 = parseFloat("${model.economica[9]}");
		var eco4 = parseFloat("${model.economica[10]}");
		var eco5 = parseFloat("${model.economica[11]}");
		
		var sum_ingresos = eco1+eco2+eco3+eco4+eco5;
		document.getElementById('sum_ingresos').innerHTML = 'S/. '+sum_ingresos;
	}
	
	function sumarEgresos(){
		var eco11 = parseFloat("${model.economica[12]}");
		var eco22 = parseFloat("${model.economica[13]}");
		var eco33 = parseFloat("${model.economica[14]}");
		var eco44 = parseFloat("${model.economica[15]}");
		var eco55 = parseFloat("${model.economica[16]}");
		var eco66 = parseFloat("${model.economica[17]}");		
		
		var sum_egresos = eco11+eco22+eco33+eco44+eco55+eco66;		
		document.getElementById('sum_egresos').innerHTML = 'S/. '+sum_egresos;
	}
	
</script>