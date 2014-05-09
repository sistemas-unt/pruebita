
<script src="../assets/js/jquery.validate.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	tipoSeleccionado();
	turnoSeleccionado();
	especialidadSeleccionado();
	formaSeleccionado();
	$('#numPostulaciones').validCampoFranz('0123456789');
	$('.numeros').validCampoFranz('0123456789');
});


function tipoSeleccionado() {
	var estado = "${model.listaAntEscolar[0][0]}";

	var estado_2 = document.getElementById("tipoCE");
	estado_2.options[estado-1].selected = true;

}

function turnoSeleccionado() {
	var estado = "${model.listaAntEscolar[0][1]}";

	var estado_2 = document.getElementById("turno");
	estado_2.options[estado-1].selected = true;

}

function especialidadSeleccionado() {
	var estado = "${model.listaAntEscolar[0][2]}";

	var estado_2 = document.getElementById("especialidad");
	estado_2.options[estado-1].selected = true;

}

function formaSeleccionado() {
	var estado = "${model.listaAntEscolar[0][5]}";

	var estado_2 = document.getElementById("formaIngreso");
	estado_2.options[estado-1].selected = true;

}

$('#formulario6').validate({
	errorElement: 'span',
	errorClass: 'help-inline',
	focusInvalid: false,
	rules: {
		saeTipoColegio: {
			required: true
		},	
		saeTurno: {
			required: true
		},
		saeEspecializacion: {
			required: true
		},
		colegioTermino: {
			required: true
		},
		numPostulaciones: {
			required: true
		},
		saeFormaIngreso: {
			required: true
		}	
	},

	messages: {
		saeTipoColegio: {
			required: "este campo es obligatorio"
		},
		saeTurno: {
			required: "este campo es obligatorio"
		},
		saeEspecializacion: {
			required: "este campo es obligatorio"
		},
		colegioTermino: {
			required: "este campo es obligatorio"
		},
		numPostulaciones: {
			required: "este campo es obligatorio"
		},
		saeFormaIngreso: {
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