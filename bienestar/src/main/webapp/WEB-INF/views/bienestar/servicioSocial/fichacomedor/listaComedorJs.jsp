
<script src="../assets/js/jquery.dataTables.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>


<!--inline scripts related to this page-->

<script type="text/javascript">
	$(function() {
		var oTable1 = $('#sample-table-3').dataTable({
			"aoColumns" : [ {
				"bSortable" : false
			}, null,null, null, null, null, {
				"bSortable" : false
			}, {
				"bSortable" : false
			} ]
		});

		$('table th input:checkbox').on(
				'click',
				function() {
					var that = this;
					$(this).closest('table').find(
							'tr > td:first-child input:checkbox').each(
							function() {
								this.checked = that.checked;
								$(this).closest('tr').toggleClass('selected');
							});

				});

		$('[data-rel="tooltip"]').tooltip({
			placement : tooltip_placement
		});
		function tooltip_placement(context, source) {
			var $source = $(source);
			var $parent = $source.closest('table');
			var off1 = $parent.offset();
			var w1 = $parent.width();

			var off2 = $source.offset();
			var w2 = $source.width();

			if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2))
				return 'right';
			return 'left';
		}
	});

	function validateForm() {

		$
				.post('${pageContext.request.contextPath}/bienestar/validardni.htm',
						$("#form_dni").serialize(),
						function(response) {

							if (response == "3") {
								document.getElementById("mensaje").innerHTML = "El DNI no existe";
								document.getElementById("mensaje").style.color="#FA5858";
							} else {
 								if (response != "3" && response != "2" && response != "0") {
 									document.getElementById("mensaje").innerHTML = "El alumno no pertenece a su rango de escuelas. Pertenece a la "+response+"";
 									document.getElementById("mensaje").style.color="#FA5858";
 								} else{
 									if (response == "2") {
 										document.getElementById("mensaje").innerHTML = "El alumno ya está registrado";
 										document.getElementById("mensaje").style.color="#FA5858";
									}else
										if(response == "0"){
											$("#form_dni").submit();
										}
									
								}
									

 							}

						});
	};
</script>





<script type="text/javascript">
	function cambio() {
		var nodo = document.getElementById("lifichac");
		nodo.className = "active";
	}
	function cambio2() {
		var nodo = document.getElementById("social");
		var nodo2 = document.getElementById("social2");
		nodo.className = "active open";
		nodo2.className = "active open";
	}

	cambio();
	cambio2();
	

</script>


<script type="text/javascript">
	$(document).ready(function() {
		categoria();
// 		requisitos();
	});
	
	
	function categoria() {
		var estado = "${model.datosalumno[7]}";

		var estado_2 = document.getElementById("categoria");
		estado_2.options[estado-1].selected = true;

	}
// 	function requisitos() {
		
	
// 		  var checkboxes = document.getElementsByName('requisitos');
 		  
//  			var id = 0;
//  		    alert('${model.listarequisitoporalumno[id]}');
 		  
// 		 };
	
</script>
