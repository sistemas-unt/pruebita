
<script src="../assets/js/jquery.dataTables.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>


<!--inline scripts related to this page-->

<script type="text/javascript">
	$(document).ready(function() {
	// 	categoria();
	//		requisitos();
// 	alert('dfdsf');
	
	
	$('input[name=listaRequisitos]').change(function() {

			if ($(this).is(':checked')) {
				// Checkbox is checked.
// 				alert('dfdsf1');
				document.getElementById("nota2").disabled = false;
			} else {
				// Checkbox is not checked.
// 				alert('dfdsf2');
				document.getElementById("nota2").disabled = true;
			}

		});
	



	});

	function agregar() {
		var ch = document.getElementsByName('codigo');

		for (var i = ch.length; i--;) {
			if (ch[i].checked) {

				$('#numerocodigo').val(ch[i].value);
				$('#codigo').modal('hide');
			}

		}
	}

	function validate(esto) {
		valido = false;
		for (var a = 0; a < esto.elements.length; a++) {
			if (esto[a].type == "checkbox" && esto[a].checked == true) {
				valido = true;
				break;
			}

		}
		if (!valido) {
			alert("Debe marcar al menos un requisito!");
			return false;
		}

	}

	function validar(){
		
	var a= document.getElementById("check");
		if(a.checked==true){
			document.getElementById("nota").disabled=false;
		}else
			document.getElementById("nota").disabled=true;
	}
</script>
