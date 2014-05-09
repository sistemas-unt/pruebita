
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
	habilita();
	
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



function habilita() {
	document.FormStep4.motivo.disabled = false;
	document.FormStep4.ubicacion.disabled = false;
	document.FormStep4.materialConstruccion.disabled = false;
	document.FormStep4.tenencia.disabled = false;
	document.FormStep4.tipo.disabled = false;
	document.FormStep4.aguapotable.disabled = false;
	document.FormStep4.servicios.disabled = false;
	document.FormStep4.iluminacion.disabled = false;
}

function deshabilita() {
	document.FormStep4.motivo.disabled = true;
	document.FormStep4.motivo.value = "";
	document.FormStep4.ubicacion.disabled = true;
	document.FormStep4.materialConstruccion.disabled = true;
	document.FormStep4.tenencia.disabled = true;
	document.FormStep4.tipo.disabled = true;
	document.FormStep4.aguapotable.disabled = true;
	document.FormStep4.servicios.disabled = true;
	document.FormStep4.iluminacion.disabled = true;
}


$('#FormStep4').validate({
	errorElement: 'span',
	errorClass: 'help-inline',
	focusInvalid: false,
	rules: {
		motivo: {
			required: true
			//email:true
		},			
		ubicacion: {
			required: true
		},	

		materialConstruccion:{
			required: true
		},

		tenencia:{
			required: true
		},

		tipo:{
			required: true
		},

		aguapotable:{
			required: true
		},

		servicios:{
			required: true
		},

		iluminacion:{
			required: true
		}
	},

	messages: {
		motivo: {
			required: "este campo es obligatorio"
		},
		ubicacion: {
		required: "este campo es obligatorio"
		},
		materialConstruccion: {
			required: "este campo es obligatorio"
		},
		tenencia: {
			required: "este campo es obligatorio"
		},
		tipo: {
			required: "este campo es obligatorio"
		},
		aguapotable: {
			required: "este campo es obligatorio"
			},
		servicios: {
			required: "este campo es obligatorio"
		},
		iluminacion: {
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