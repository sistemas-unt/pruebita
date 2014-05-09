<script type="text/javascript">
	$(document).ready(function() {
		deporteSeleccionado();
		aficionSeleccionada();
		habilitaMusica();

	});

	function deporteSeleccionado() {
		var listadeportes = "${model.listaSocDeportes}";
		var string1 = listadeportes.replace("[", "");
		var stringfinal = string1.replace("]", "");
		var a = stringfinal.split(",");

		for (var i = 0; i < a.length; i++) {
			var p = a[i].trim();
			switch (p) {
			case "FUTBOL":
				document.getElementById('futbol').checked = true;
				break;

			case "NATACIÓN":
				document.getElementById('natacion').checked = true;
				break;

			case "TENNIS":
				document.getElementById('tennis').checked = true;
				break;

			case "VOLLEYBALL":
				document.getElementById('voley').checked = true;
				break;

			case "BASQUETBALL":
				document.getElementById('basquet').checked = true;
				break;

			case "PING PONG":
				document.getElementById('ping').checked = true;
				break;

			case "EQUITACIÓN":
				document.getElementById('equitacion').checked = true;
				break;

			case "OTROS":
				document.getElementById('otros').checked = true;
				break;

			}
		}
	}

	function aficionSeleccionada() {
		var listaaficion = "${model.listaSocAficiones}";
		var string1 = listaaficion.replace("[", "");
		var stringfinal = string1.replace("]", "");
		var a = stringfinal.split(",");

		for (var i = 0; i < a.length; i++) {
			var p = a[i].trim();
			switch (p) {
			case "DIBUJO O PINTURA":
				document.getElementById('pintura').checked = true;
				break;

			case "DECORACIÓN":
				document.getElementById('decoracion').checked = true;
				break;
			case "TEATRO":
				document.getElementById('teatro').checked = true;
				break;
			case "FOTOGRAFÍA":
				document.getElementById('fotografia').checked = true;
				break;
			case "LECTURA":
				document.getElementById('Lectura').checked = true;
				break;
			case "ESCRITOR":
				document.getElementById('escritor').checked = true;
				break;
			case "MECÁNICA":
				document.getElementById('mecanica').checked = true;
				break;
			case "POESÍA":
				document.getElementById('poesia').checked = true;
				break;
			case "ARTESANÍA":
				document.getElementById('artesania').checked = true;
				break;
			case "CARPINTERÍA":
				document.getElementById('carpinteria').checked = true;
				break;
			case "DANZA":
				document.getElementById('danza').checked = true;
				break;
			case "COSTURA":
				document.getElementById('costura').checked = true;
				break;
			case "SASTRERÍA":
				document.getElementById('sastreria').checked = true;
				break;
			case "BALLET":
				document.getElementById('ballet').checked = true;
				break;

			default:
				document.getElementById('musicaa').checked = true;
				enf = $('#txtmusicaa').get(0);
				enf.value = a[i].trim();
				break;
			}

		}

	}

	function habilitaMusica() {
		if (document.getElementById('musicaa').checked == true) {
			var enf = $('#txtmusicaa').get(0);
			enf.removeAttribute('readonly');
			txtmusicaa.disabled = false;
		} else {
			enf = $('#txtmusicaa').get(0);
			enf.setAttribute('readonly', 'true');
			enf.value = null;
			txtmusicaa.disabled = true;

		}
	}

	function habilitaMusica1() {
		if (document.getElementById('musica').checked == true) {
			var enf = $('#txtmusica').get(0);
			enf.removeAttribute('readonly');
			txtmusica.disabled = false;
		} else {
			enf = $('#txtmusica').get(0);
			enf.setAttribute('readonly', 'true');
			txtmusica.disabled = true;
			enf.value = null;

		}
	}

	function validar() {
		if (document.getElementById('futbol').checked == true
				|| document.getElementById('natacion').checked == true
				|| document.getElementById('tennis').checked == true
				|| document.getElementById('voley').checked == true
				|| document.getElementById('basquet').checked == true
				|| document.getElementById('ping').checked == true
				|| document.getElementById('equitacion').checked == true
				|| document.getElementById('otros').checked == true) 
		{
			if (document.getElementById('pintura').checked == true
					|| document.getElementById('decoracion').checked == true
					|| document.getElementById('teatro').checked == true
					|| document.getElementById('fotografia').checked == true
					|| document.getElementById('Lectura').checked == true
					|| document.getElementById('escritor').checked == true
					|| document.getElementById('mecanica').checked == true
					|| document.getElementById('poesia').checked == true
					|| document.getElementById('artesania').checked == true
					|| document.getElementById('carpinteria').checked == true
					|| document.getElementById('danza').checked == true
					|| document.getElementById('costura').checked == true
					|| document.getElementById('sastreria').checked == true
					|| document.getElementById('ballet').checked == true)
				{
				return true;
				}else
					{
						alert("Debe escoger al menos una afición");
						return false;
					}
		} else {
			if(document.getElementById('pintura').checked == true
					|| document.getElementById('decoracion').checked == true
					|| document.getElementById('teatro').checked == true
					|| document.getElementById('fotografia').checked == true
					|| document.getElementById('Lectura').checked == true
					|| document.getElementById('escritor').checked == true
					|| document.getElementById('mecanica').checked == true
					|| document.getElementById('poesia').checked == true
					|| document.getElementById('artesania').checked == true
					|| document.getElementById('carpinteria').checked == true
					|| document.getElementById('danza').checked == true
					|| document.getElementById('costura').checked == true
					|| document.getElementById('sastreria').checked == true
					|| document.getElementById('ballet').checked == true)
				{
				if(document.getElementById('futbol').checked == true
						|| document.getElementById('natacion').checked == true
						|| document.getElementById('tennis').checked == true
						|| document.getElementById('voley').checked == true
						|| document.getElementById('basquet').checked == true
						|| document.getElementById('ping').checked == true
						|| document.getElementById('equitacion').checked == true
						|| document.getElementById('otros').checked == true)
				{return true;}
				else
					{
						alert("Debe escoger al menos un deporte");
						return false;
					}
					
				}
			
			alert("Debe escoger al menos una afición y un deporte");
			return false;
		}
	}
	
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