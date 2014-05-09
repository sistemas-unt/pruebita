<script src="../assets/js/jquery.dataTables.min.js"></script>
<script src="../assets/js/jquery.dataTables.bootstrap.js"></script>

<!--inline scripts related to this page-->

<script type="text/javascript">
	$(function() {
		var oTable1 = $('#data').dataTable({
			"aoColumns" : [ {
				"bSortable" : false
			}, null,null,null,null,{
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
	
// 	----------------tabla de asistentas------------------------------------------------------
	
	$(function() {
		var oTable1 = $('#data2').dataTable({
			"aoColumns" : [ {
				"bSortable" : false
			}, null,null,null, {
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
// 	----------------Cantidad de Tickets por Escuelas------------------------------------------------------
		$(function() {
		var oTable1 = $('#data4').dataTable({
			"aoColumns" : [ {
				"bSortable" : false
			}, null,null,null,null,null, {
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
		function marcar(esto) {
			valido = false;
			for (var a = 0; a < esto.elements.length; a++) {
				if (esto[a].type == "checkbox" && esto[a].checked == true) {
					valido = true;
					break;
				}

			}
			if (!valido) {
				alert("Debe marcar al menos un ticket!");
				return false;
			}

		}
		function sobra(esto) {
			valido = false;
			for (var a = 0; a < esto.elements.length; a++) {
				if (esto[a].type == "checkbox" && esto[a].checked == true) {
					valido = true;
					break;
				}

			}
			if (!valido) {
				alert("Debe marcar al menos un ticket!");
				return false;
			}

		}
</script>
