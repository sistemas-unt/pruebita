
<script>



  // calcular la edad
	function calcularEdad() {
		var f = new Date();
		var año = f.getFullYear();
		var mes = f.getMonth() + 1;
		var dia = f.getDate();

		var añon = "${model.persona[13]}".substring(0, 4);
		var mesn = "${model.persona[13]}".substring(5, 7);
		var dian = "${model.persona[13]}".substring(8, 10);

		var edad = año - añon;

		if ((mes < mesn) || (mes == mesn && dia < dian)) {
			edad--;
		}
		
		document.getElementById('idedad').innerHTML = edad;
		
	}
	

	//mostrar sexo	
	function sexo() {
		var sexo = "${model.persona[11]}";

		if (sexo == 0) {
			document.getElementById('sexo').innerHTML = ("FEMENINO");
		} else {
			document.getElementById('sexo').innerHTML = ("MASCULINO");
		}

	}

	// mostrar estado civil
	
	function estadoCivil() {
		var estado = "${model.persona[12]}";

		if (estado == 0) {
			document.getElementById('estadoCivil').innerHTML = ("SOLTERO(A)");
		}else {
			if (estado == 1){
				document.getElementById('estadoCivil').innerHTML = ("CASADO(A)");
			}else{
				if (estado == 2) {
					document.getElementById('estadoCivil').innerHTML = ("VIUDO(A)");
				}else {

					if (estado == 3) {
						document.getElementById('estadoCivil').innerHTML = ("DIVORCIADO(A)");
					}else {

						document.getElementById('estadoCivil').innerHTML = ("SIN ESTADO");
					}
				}

			}
		}
	}

	calcularEdad();
	sexo();
	estadoCivil();
</script>