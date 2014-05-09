<script src="../assets/js/jquery.validate.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	enfermedadSeleccionado();
	motivosSeleccionado();

});


function enfermedadSeleccionado() {
	var estado = "${model.listaSalud.ssAcudeEnfermedad.id}";

	var estado_2 = document.getElementById("enfermedad");
	estado_2.options[estado-1].selected = true;

}

function motivosSeleccionado() {
	var estado = "${model.listaSalud.ssMotivo.id}";

	var estado_2 = document.getElementById("motivo");
	estado_2.options[estado-1].selected = true;

}

$('#formulario7').validate({
	errorElement: 'span',
	errorClass: 'help-inline',
	focusInvalid: false,
	rules: {
		ssAcudeEnfermedad: {
			required: true
		},	
		ssMotivo: {
			required: true
		}
		
	},

	messages: {
		ssAcudeEnfermedad: {
			required: "este campo es obligatorio"
		},
		ssMotivo: {
			required: "este campo es obligatorio"
		}
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