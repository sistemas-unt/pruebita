<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Control Social <small> <i class="icon-double-angle-right"></i>
			Lista de Escuelas por Asistenta
		</small> <a href="../bienestar/control_social.htm" class="btn btn-success"
			style="border: 1px solid #c4e7ff; float: right; margin-top: 5px;"><i
			class="icon-reply"></i>Volver</a>
	</h1>
</div>

<p class="bigger-110">
	Nombre y Apellidos: <span class="grey">${model.control[0]}
		${model.control[1]} ${model.control[2]}</span>
</p>
<!-- ---------------- RANGOS DE TICKETS -------------------- -->

<div class="row-fluid" style="margin-top: 20px; margin-bottom: 40px">
	<div class="span12">

		<div class="table-header"
			style="background: #2283c5; padding-left: 15px; padding-bottom: 2px;">

			<a href="#escuelas" data-toggle="modal" title="Asignar Escuela"
				class="btn btn-small btn-primary" style="border: 1px solid #c4e7ff;"><i
				class="icon-inbox"></i>Asignar Escuela</a>

		</div>
		<table id="data"
			class="table table-striped table-bordered table-hover">

			<thead>
				<tr>
					<th class="center">N°</th>
					<th class="">Escuelas</th>

					<th class="center">Cantidad de Tickets</th>
					<th class="center">Tickets Disponibles</th>
					<th class="center">Tickets Ocupados</th>
					<th class="center">Operaciones</th>

				</tr>
			</thead>
			<tbody>

				<c:forEach var="n" items="${model.escuela}" varStatus="contador">
					<tr>
						<td class="center"><c:out value="${contador.count}" /></td>
						<td><c:out value="${n[1]}"></c:out></td>

						<td class="center"><c:out value="${n[2]}"></c:out></td>
						<td class="center"><c:out value="${n[3]}"></c:out></td>
						<td class="center"><c:out value="${n[4]}"></c:out></td>
						<td class="center"><c:choose>
								<c:when test="${n[4]==0}">
									<a href="#eliminarescuela" onclick='enviar(value="${n[0]}")'
										data-toggle="modal" title="Eliminar"><i class="icon-edit"></i>Eliminar</a>
								</c:when>

								<c:otherwise>
									<span class="label label-warning">Tickets Ocupados</span>
								</c:otherwise>
							</c:choose></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<!--/.span-->
</div>



<form method="POST" class="form-horizontal"
	action="<c:url value='escuelasdisponibles.htm'/>">
	<div id="escuelas" class="modal hide fade" tabindex="-1">


		<div class="modal-header header-color-sky blue">
			<button type="button" class="close" data-dismiss="modal">x</button>

			<h4 id="myModalLabel">Escuelas Disponibles</h4>
		</div>
		<div class="modal-body">
			<c:choose>
				<c:when test="${empty model.escuela1}">
					<p style="font-size: 16px">Por ahora no hay escuelas disponibles</p>
				</c:when>
				<c:otherwise>
					<c:forEach var="n" items="${model.escuela1}">
						<div class="control-group">
							<div class="checkbox">
								<label> <input name="escuelasdisponibles" id=""
									type="checkbox" class="ace" value="${n[1]}"> <span
									class="lbl"> <c:out value="${n[2]}"></c:out>
								</span></label>


							</div>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>


			<input type="hidden" name="idasistenta" value="${model.control[3] }">

		</div>

		<div class="modal-footer">
			<button class="btn" data-dismiss="modal">Cerrar</button>
			<button class="btn btn-primary" type="submit">Agregar</button>
		</div>

	</div>
</form>









<script type="text/javascript">
	function agregar() {
		var ch = document.getElementsByName('codigo');
		for (var n = ch.length; n--;) {
			if (ch[n].checked) {
				$('#nombreescuelas').val(ch[n].value);

				$('#escuelas').modal('hide');
			}
		}
	}
</script>



<form method="POST" class="form-horizontal"
	action="<c:url value='eliminarescuela.htm'/>">
	<div id="eliminarescuela" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

		<div class="modal-body header-color-sky blue">
			<h4 id="myModalLabel">¿Seguro que desea eliminar la escuela?</h4>
			<input type="hidden" id="dato" name="datoide" value="">

		</div>
		<div class="modal-footer">

			<button type="submit" class="btn btn-primary">Aceptar</button>
			<button class="btn" data-dismiss="modal">Cancelar</button>
		</div>
	</div>
</form>
<script>
	function enviar(a) {
		document.getElementById("dato").value = a;
	}
</script>