<script src="../assets/js/jquery.dataTables.min.js"></script>
		<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>

<script type="text/javascript">
	var divApoyo = document.getElementById("apoyo");
	var divBomberos = document.getElementById("bomberos");
	var divPlanilla = document.getElementById("planilla");
	var divDelegaciones = document.getElementById("delegaciones");
	var divLibres = document.getElementById("libres");

	function habilitarApoyo() 
	{

		divApoyo.style.display = "inline";
		divBomberos.style.display = "none";
		divPlanilla.style.display = "none";
		divDelegaciones.style.display = "none";
		divLibres.style.display = "none";
	}

	function habilitarBomberos() 
	{
		divApoyo.style.display = "none";
		divBomberos.style.display = "inline";
		divPlanilla.style.display = "none";
		divDelegaciones.style.display = "none";
		divLibres.style.display = "none";

	}

	function habilitarPlanilla()
	{
		divApoyo.style.display = "none";
		divBomberos.style.display = "none";
		divPlanilla.style.display = "inline";
		divDelegaciones.style.display = "none";
		divLibres.style.display = "none";

	}

	function habilitarDelegaciones() 
	{
		divApoyo.style.display = "none";
		divBomberos.style.display = "none";
		divPlanilla.style.display = "none";
		divDelegaciones.style.display = "inline";
		divLibres.style.display = "none";

	}
	
	function habilitarLibres() 
	{
		divApoyo.style.display = "none";
		divBomberos.style.display = "none";
		divPlanilla.style.display = "none";
		divDelegaciones.style.display = "none";
		divLibres.style.display = "inline";
	}
	
	$(function() {
		var oTable1 = $('#sample-table-2').dataTable( {
		"aoColumns": [
	      { "bSortable": false },
	      null, null,null, null, null,
		  { "bSortable": false }
		] } );
		
		
		$('table th input:checkbox').on('click' , function(){
			var that = this;
			$(this).closest('table').find('tr > td:first-child input:checkbox')
			.each(function(){
				this.checked = that.checked;
				$(this).closest('tr').toggleClass('selected');
			});
				
		});
	
	
		$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
		function tooltip_placement(context, source) {
			var $source = $(source);
			var $parent = $source.closest('table')
			var off1 = $parent.offset();
			var w1 = $parent.width();
	
			var off2 = $source.offset();
			var w2 = $source.width();
	
			if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
			return 'left';
		}
	})
</script>