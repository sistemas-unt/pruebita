<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="page-header position-relative">
	<h1>
		Verificar Padron Comedor <small> <i class="icon-double-angle-right"></i> Reporte de Tickets
		</small> <a href="verificar_padron.htm" class="btn btn-success"
			style="border: 1px solid #c4e7ff; float: right; margin-top: 5px;"><i class="icon-reply"></i>Volver</a>
	</h1>

</div>

<div class="row-fluid">
	<div class="span12">

		<!-- DATOS PERSONALES Y ESTADISTICOS -->
		<div class="row-fluid">
			<div class="span6">
				<p class="bigger-120">
					DNI: <span class="grey">${model.ticket[0][2]}</span>
				</p>
				<p class="bigger-120">
					Codigo de Matricula: <span class="grey">${model.ticket[0][3]}</span>
				</p>
				<p class="bigger-120">
					Apellidos y Nombres: <span class="grey">${model.ticket[0][4]}</span>
				</p>
				<p class="bigger-120">
					Escuela: <span class="grey">${model.ticket[0][5]}</span>
				</p>
			</div>

			<div class="span6">
				<p class="bigger-120">
					Nro de Tickets Entregados: <span class="grey">490</span>
				</p>
				<p class="bigger-120">
					Ultimo dia de Entrega: <span class="grey">22/12/2013</span>
				</p>
			</div>
		</div>

		<hr />

		<!-- TABLA DE GESTION DE TICKETS -->
		<div class="row-fluid">
			<div class="span12">

				<!-- TABLA DE TICKET ENTREGADOS -->
				<div class="table-header" style="background: #2283c5; padding-left: 5px; padding-bottom: 2px;">

					<a href="#registrarTicket" data-toggle="modal" title="Agregar Asistenta" class="btn btn-small btn-primary"
						style="border: 1px solid #c4e7ff;"><i class="icon-inbox"></i>Agregar</a>

				</div>
				<table id="sample-table-1" class="table table-striped table-bordered table-hover">

					<thead>
						<tr>
							<th class="center"><label> <span class="lbl">N</span>
							</label></th>
							<th class="center">Fecha</th>
							<th class="center">Voucher</th>
							<th class="hidden-480 center">Nro de Tickets</th>
							<th class="hidden-480 center">Monto</th>
						</tr>
					</thead>

					<tbody>

						<c:forEach var="rowData" items="${model.rowTicket}" varStatus="contador">
							<tr>
								<td class="center"><label> <span class="lbl">${contador.count}</span>
								</label></td>

								<fmt:formatDate value="${rowData[1]}" type="both" dateStyle="medium" timeStyle="medium" var="dateString" />

								<td class="center"><c:out value="${dateString}" /></td>
								<td class="center"><c:out value="${rowData[0]}" /></td>
								<td class="hidden-480 center"><c:out value="${rowData[2]}" /></td>
								<td class="hidden-480 center"><c:out value="${rowData[3]}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

	</div>
	<hr>

</div>
<!--/.row-fluid-->

<!-- MODAL PARA EL INGRESO DEL VOUCHER -->

<form action="" class="form-horizontal" method="POST">
	<div id="registrarTicket" class="modal hide fade" tabindex="-1">
		<div class="modal-header header-color-sky blue">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h3 id="myModalLabel">Ingresar Ticket</h3>
		</div>

		<div class="modal-body">
			<div class="control-group">
				<label class="control-label" for="form-field-1">Numero de Voucher</label>
				<div class="controls">
					<input class="input-large" id="voucher" name="voucher" type="text" maxlength="8">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="form-field-1">Numero de Tickets</label>
				<div class="controls">
					<input class="input-mini" id="cantidad" name="cantidad" type="text" maxlength="5">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="form-field-1">Monto s/.</label>
				<div class="controls">
					<input class="input-mini" id="monto" name="monto" type="text" maxlength="5">
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<input type="submit" class="btn btn-primary" value="Aceptar">
			<button class="btn" data-dismiss="modal">Cancelar</button>
		</div>
	</div>
	<input type="hidden" name="idFicha" value="${model.ticket[0][0]}">
</form>




