
<script src="../assets/js/jquery.validate.min.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		ubicacionSeleccionado();
		materialSeleccionado();
		tenenciaSeleccionada();
		tipoSeleccionado();
		aguaSeleccionada();
		serviciosH();
		iluminacionSeleccionada();
	});
	
	
	function ubicacionSeleccionado() {
		var estado = "${model.ubicaciones.id}";

		var estado_2 = document.getElementById("ubicacionSeleccionado");
		estado_2.options[estado-1].selected = true;

	}
	
	function materialSeleccionado() {
		var estado = "${model.materialescons.id}";

		var estado_2 = document.getElementById("materialSeleccionado");
		estado_2.options[estado-1].selected = true;

	}
	
	
	function tenenciaSeleccionada() {
		var estado = "${model.tenencias.id}";

		var estado_2 = document.getElementById("tenenciaSeleccionada");
		estado_2.options[estado-1].selected = true;

	}
	
	function tipoSeleccionado() {
		var estado = "${model.tipos.id}";

		var estado_2 = document.getElementById("tipoSeleccionado");
		estado_2.options[estado-1].selected = true;

	}
	
	function aguaSeleccionada() {
		var estado = "${model.aguapot.id}";

		var estado_2 = document.getElementById("aguaSeleccionada");
		estado_2.options[estado-1].selected = true;

	}
	
	function serviciosH() {
		var estado = "${model.sshhs.id}";

		var estado_2 = document.getElementById("serviciosH");
		estado_2.options[estado-1].selected = true;

	}
	
	function iluminacionSeleccionada() {
		var estado = "${model.iluminaciones.id}";

		var estado_2 = document.getElementById("iluminacionSeleccionada");
		estado_2.options[estado-1].selected = true;
	}
	
		
	$('#formulario3').validate({
		errorElement: 'span',
		errorClass: 'help-inline',
		focusInvalid: false,
		rules: {
			svUbicacion: {
				required: true
			},			
			svMatConstruccion: {
				required: true
			},
				
			svTenencia: {
				required: true
			},			
			svTipo: {
				required: true
			},
			svAguaPotable: {
				required: true
			},
			svServiciosHigienico: {
				required: true
			},
			svIluminacion: {
				required: true
			}
		},

		messages: {
			svUbicacion: {
				required: "este campo es obligatorio"
				},
			svMatConstruccion: {
					required: "este campo es obligatorio"
				},
			svTenencia: {
					required: "este campo es obligatorio"
				},
			svTipo: {
					required: "este campo es obligatorio"
				},
			svAguaPotable: {
					required: "este campo es obligatorio"
					},
			svServiciosHigienico: {
					required: "este campo es obligatorio"
				},
			svIluminacion: {
					required: "este campo es obligatorio"
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
	            // Handle the back (or forward) buttons here
	            // Will NOT handle refresh, use onbeforeunload for this.
	        };
	    }
	    else {
	        var ignoreHashChange = true;
	        window.onhashchange = function () {
	            if (!ignoreHashChange) {
	                ignoreHashChange = true;
	                window.location.hash = Math.random();
	                // Detect and redirect change here
	                // Works in older FF and IE9
	                // * it does mess with your hash symbol (anchor?) pound sign
	                // delimiter on the end of the URL
	            }
	            else {
	                ignoreHashChange = false;   
	            }
	        };
	    }
	};
	
</script>
