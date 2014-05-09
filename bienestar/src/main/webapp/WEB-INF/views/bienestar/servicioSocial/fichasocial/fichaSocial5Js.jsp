
<script src="../assets/js/jquery.validate.min.js"></script>

<script type="text/javascript">
	function suma() {
		with (document.formulario5) {
			var resultado = Number(cantpadres.value)
					+ Number(canttrabajo.value) + Number(cantpension.value)
					+ Number(cantabuelos.value) + Number(cantotros.value);
			total.value = roundTo(resultado, 2);
		}
	}

	function sumae() {
		with (document.formulario5) {
			var resultado = Number(cantepension.value)
					+ Number(cantehabitacion.value)
					+ Number(cantemovilidad.value)
					+ Number(cantealimentacion.value)
					+ Number(cantevestimenta.value) + Number(canteutiles.value);
			totale.value = roundTo(resultado, 2);
		}
	}

	function roundTo(num, pow) {
		num *= Math.pow(10, pow);

		num = (Math.round(num) / Math.pow(10, pow)) + "";

		if (num.indexOf(".") == -1)
			num += ".";
		while (num.length - num.indexOf(".") - 1 < pow)
			num += "0";

		return num;
	}
	// ----------------------------------------------------------------
	$(function() {
		//Para escribir solo letras
		$('#miCampo1').validCampoFranz(' abcdefghijklmnñopqrstuvwxyzáéiou');

		//Para escribir solo numeros    
		$('#cantpadres').validCampoFranz('0123456789');
		$('#canttrabajo').validCampoFranz('0123456789');
		$('#cantpension').validCampoFranz('0123456789');
		$('#cantabuelos').validCampoFranz('0123456789');
		$('#cantotros').validCampoFranz('0123456789');
		$('#cantepension').validCampoFranz('0123456789');
		$('#cantehabitacion').validCampoFranz('0123456789');
		$('#cantemovilidad').validCampoFranz('0123456789');
		$('#cantealimentacion').validCampoFranz('0123456789');
		$('#cantevestimenta').validCampoFranz('0123456789');
		$('#canteutiles').validCampoFranz('0123456789');

	});
	
	
	
	function habilita1()
	{
		var egresosEco= document.getElementById("egresosEco");
		egresosEco.style.display="inline";
		var  ingresosEco =document.getElementById("ingresosEco");
		ingresosEco.style.display="none";
		//var  ingresosEco= $("#ingresosEco");
		//var  egresosEco= $("#egresosEco");
		
		
	}
	

	$(document).ready(function() {
		ocupacionSeleccionado();
		condicionSeleccionado();
		dedicacionSeleccionado();
		turnoSeleccionado();
		suma();
		sumae();
	});
	
	
	function ocupacionSeleccionado() {
		var estado = "${model.listaSituacionEconomica[0][0]}";

		var estado_2 = document.getElementById("ocupacion");
		estado_2.options[estado-1].selected = true;

	}
	
	function condicionSeleccionado() {
		var estado = "${model.listaSituacionEconomica[0][1]}";

		var estado_2 = document.getElementById("condicion");
		estado_2.options[estado-1].selected = true;

	}
	
	function dedicacionSeleccionado() {
		var estado = "${model.listaSituacionEconomica[0][2]}";

		var estado_2 = document.getElementById("dedicacion");
		estado_2.options[estado-1].selected = true;

	}
	
	function turnoSeleccionado() {
		var estado = "${model.listaSituacionEconomica[0][3]}";

		var estado_2 = document.getElementById("turno");
		estado_2.options[estado-1].selected = true;

	}
	
	
	
	$('#formulario5').validate({
		errorElement: 'span',
		errorClass: 'help-inline',
		focusInvalid: false,
		rules: {
			ocupacionLab: {
				required: true
				
			},
			sscondicion: {
				required: true
			},
			ssdedicacion: {
				required: true
			},
			turnotrabajo: {
				required: true
			},
			lugar: {
				required: true
			},
			cantpadres: {
				required: true
			},
			canttrabajo: {
				required: true
			},
			cantpension: {
				required: true
			},
			cantabuelos: {
				required: true
			},
			cantotros: {
				required: true
			},
			cantepension: {
				required: true
			},
			cantehabitacion: {
				required: true
			},
			cantemovilidad: {
				required: true
			},
			cantealimentacion: {
				required: true
			},
			cantevestimenta: {
				required: true
			},
			canteutiles: {
				required: true
			}
		},

		messages: {
			ocupacionLab: {
				required: "este campo es obligatorio."
			},
			sscondicion: {
				required: "este campo es obligatorio."
			},
			ssdedicacion: {
				required: "este campo es obligatorio."
			},
			turnotrabajo: {
				required: "este campo es obligatorio."
			},
			lugar: {
				required: "este campo es obligatorio."
			},
			cantpadres: {
				required: "este campo es obligatorio."
			},
			canttrabajo: {
				required: "este campo es obligatorio."
			},
			cantpension: {
				required: "este campo es obligatorio."
			},
			cantabuelos: {
				required: "este campo es obligatorio."
			},
			cantotros: {
				required: "este campo es obligatorio."
			},
			cantepension: {
				required: "este campo es obligatorio."
			},
			cantehabitacion: {
				required: "este campo es obligatorio."
			},
			cantemovilidad: {
				required: "este campo es obligatorio."
			},
			cantealimentacion: {
				required: "este campo es obligatorio."
			},
			cantevestimenta: {
				required: "este campo es obligatorio."
			},
			canteutiles: {
				required: "este campo es obligatorio."
			},
			
			
		},

		highlight: function (e) {
			$(e).closest('.control-group').removeClass('info').addClass('error');
		},

		success: function (e) {
			$(e).closest('.control-group').removeClass('error').addClass('info');
			$(e).remove();
		},

		
	});
		
	
	window.onload = function () {
	    if (typeof history.pushState === "function") {
	        history.pushState("jibberish", null, null);
	        window.onpopstate = function () {
	            history.pushState('newjibberish', null, null);
	        };
	    }
	    else {
	        var ignoreHashChange = true;
	        window.onhashchange = function () {
	            if (!ignoreHashChange) {
	                ignoreHashChange = true;
	                window.location.hash = Math.random();
	            }
	            else {
	                ignoreHashChange = false;   
	            }
	        };
	    }
	};
</script>