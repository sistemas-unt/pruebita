<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="page-header">
	<h1>
		Lista de Pacientes <small><i class="icon-double-angle-right"></i>
			Información del Alumno</small>

	</h1>
</div>


<div class="row-fluid">
	<div class="span12">

		<div class="table-header"
			style="background: #2283c5; padding-left: 5px; padding-bottom: 2px;">

			<a href="#dni" data-toggle="modal" title="Nueva Cita Médica"
				class="btn btn-small btn-primary" style="border: 1px solid #c4e7ff;"><i
				class="icon-inbox"></i>Registrar Cita</a> 
			<a href="#dni" data-toggle="modal"
				title="Agregar Paciente" class="btn btn-small btn-primary"
				style="border: 1px solid #c4e7ff;"><i class="icon-user"></i>Nuevo</a>

		</div>
		<table id="historiasocial"
			class="table table-striped table-bordered table-hover">

			<thead>
				<tr>
					<th class="center">N°</th>
					<th class="">Nombre</th>
					<th class="center">Nro Historial Clínico</th>
					<th class="center">DNI</th>
					<th class="center">Estado</th>


				</tr>
			</thead>
			<tbody>

				<c:forEach var="n" items="${model.listasocial}" varStatus="contador">
					<tr>
						<td class="center"><c:out value="${contador.count}" /></td>
						<td><c:out value="${n[0]} ${n[1]} ${n[2]}"></c:out></td>
						<td class="center"><c:out value="${n[6]}"></c:out></td>
						<td class="center"><c:out value="${n[3]}"></c:out></td>
						<td class="center"><c:choose>
								<c:when test="${n[5]==9}">
									<a href="#" title="Atender"> Atender </a>
								</c:when>

								<c:otherwise>
									<span class="label label-success">Completar</span>
								</c:otherwise>
							</c:choose></td>

						<%-- 						<td class="center"><a href="#eliminar" data-toggle="modal" onclick='enviardato("${n[4]}")' title="Eliminar">  --%>
						<!-- 						<i class="icon-trash"></i>Ratificar</a> -->
						<!-- 						</td> -->
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<!--/.span-->
</div>
<!--/.row-fluid-->




<!-- Modal Buscar DNI ó Código -->

<form class="form-search" action="#" method="POST" id="form_dni">
	<div id="dni" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header header-color-sky blue">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">Número de DNI ó Carnet Universitario</h3>
		</div>

		<div class="modal-body">
			<span class="input-icon input-block-level"
				style="margin-bottom: 20px"> <input type="text"
				placeholder="Ingresar docuemnto..." pattern=".{8,8}"
				title="solo puedes escribir 8 dígitos"
				class="input-block-level numeros" name="dni" id="dni" /> <i
				class="icon-search nav-search-icon"></i>
			</span>
			<p id="mensaje"></p>
		</div>
		<div class="modal-footer">

			<input type="button" onclick="return validateForm();"
				class="btn btn-primary" value="Aceptar">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
		</div>

	</div>
</form>
