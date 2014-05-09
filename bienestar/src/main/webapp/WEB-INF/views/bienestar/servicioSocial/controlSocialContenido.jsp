<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="row-fluid">
	<div class="span12">
		<!--PAGE CONTENT BEGINS-->
		<div class="page-header">
			<h1>
				Control Social <small> <i class="icon-double-angle-right"></i>

					Panel de Administración
				</small>
			</h1>
		</div>


		<!-- ---------------- TABLA DE ASISTENTAS -------------------- -->
		<div class="row-fluid">
			<div class="span12">

				<div class="table-header"
					style="background: #2283c5; padding-left: 15px; padding-bottom: 2px;">

					Cantidad de Escuelas por Asistenta</div>
				<table id="data2"
					class="table table-striped table-bordered table-hover">

					<thead>
						<tr>
							<th class="center">N°</th>
							<th class="">Nombres y Apellidos</th>
							<th class="center">DNI</th>
							<th class="center">Escuelas Asignadas</th>
							<th class="center">Opciones</th>

						</tr>
					</thead>
					<tbody>

						<c:forEach var="n" items="${model.asistenta}" varStatus="contador">
							<tr>
								<td class="center"><c:out value="${contador.count}" /></td>
								<td><c:out value="${n[1]} ${n[2]} ${n[3]}"></c:out></td>
								<td class="center"><c:out value="${n[5]}"></c:out></td>
								<td class="center"><c:out value="${n[4]}"></c:out></td>
								<td class="center"><a
									href="editar_control.htm?ida=<c:out value="${n[0]}" />"
									title="Modificar"><i class="icon-edit"></i> Editar </a></td>

							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<!--/.span-->
		</div>

		<!-- ---------------- RANGOS DE TICKETS -------------------- -->

		<div class="row-fluid" style="margin-top: 20px">

			<div class="span12">
				<div class="page-header">
					<h1>
						Cantidad de Tickets por Escuelas <small> <i
							class="icon-double-angle-right"></i> Panel de Administración
						</small>
					</h1>
				</div>
				<div class="table-header"
					style="background: #2283c5; padding-left: 10px; padding-bottom: 2px;">

					<a
						href="../bienestar/sobratickets.htm" title="Agregar Tickets"
						class="btn btn-small btn-primary"
						style="border: 1px solid #c4e7ff"><i
						class="icon-inbox"></i>Agregar Tickets</a>
				</div>
				<table id="data4"
					class="table table-striped table-bordered table-hover">

					<thead>
						<tr>
							<th class="center">N°</th>
							<th class="center">Escuelas</th>
							<th class="center">Cantidad de Tickets</th>
							<th class="center">Tickets Disponibles</th>
							<th class="center">Tickets Ocupados</th>
							<th class="center">Asistenta</th>
							<th class="center">Operaciones</th>

						</tr>
					</thead>
					<tbody>

						<c:forEach var="n" items="${model.escuela2}" varStatus="contador">
							<tr>
								<td class="center"><c:out value="${contador.count}" /></td>
								<td><c:out value="${n[1]}"></c:out></td>

								<td class="center"><c:out value="${n[2]}"></c:out></td>
								<td class="center"><c:out value="${n[3]}"></c:out></td>
								<td class="center"><c:out value="${n[4]}"></c:out></td>
								<td class=""><c:out value="${n[5]} ${n[6]}"></c:out></td>
								<td class="center">
								<c:choose>
								<c:when test="${n[2]>0}">
									<a
									href="reasignarTickets.htm?numero=<c:out value="${n[0]}" />"
									title="Modificar"><i class="icon-edit"></i> Editar </a>
								</c:when>

								<c:otherwise>
									<span class="label label-warning">No disponible</span>
								</c:otherwise>
							</c:choose></td>
							

							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
			<!--/.span-->
		</div>



		<!--/span-->


	</div>
</div>

