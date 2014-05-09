<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="page-header position-relative">
	<h1>
		Verificar Padron Comedor
		<!--  small> 
			<i class="icon-double-angle-right"></i> Static	&amp; Dynamic Tables
		</small -->
	</h1>
</div>
<!--/.page-header-->

<div class="row-fluid">
	<div class="span12">
		<!--PAGE CONTENT BEGINS-->

		<div class="row-fluid">

			<table id="sample-table-2"
				class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center">N°</th>
						<th class="hidden-480">Cod de Comedor</th>
						<th>DNI</th>
						<th>Codigo Matricula</th>
						<th class="hidden-480">Apellidos y Nombres</th>
						<th class="hidden-480">Tickest Entregados</th>
						<th>Opciones</th>
					</tr>
				</thead>

				<tbody>

					<c:forEach var="pad" items="${model.padron}" varStatus="contador">

						<tr>
							<td class="center"><c:out value="${contador.count}"/></td>
							<td class="center"><c:out value="${pad[1]}" /></td>
							<td class="center"><c:out value="${pad[2]}" /></td>
							<td class="hidden-480"><c:out value="${pad[3]}" /></td>
							<td class="hidden-phone"><c:out value="${pad[4]}" /></td>
							<td class="hidden-480"><span class="label label-important"> No Habilitado</span></td>
							<td class="td-actions center">
								<!-- OPCION VISIBLE -->
								<div class="hidden-phone visible-desktop action-buttons center">
									<a class="blue" href="ticket_comedor.htm?cod=<c:out value="${pad[0]}" />"> <i class="icon-folder-close-alt bigger-130"> Registrar</i>
									</a>
								</div>
								
								<!-- OPCION RESPONSIVE -->
								<div class="hidden-desktop visible-phone">
									<div class="inline position-relative">
										<button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown">
											<i class="icon-caret-down icon-only bigger-120"></i>
										</button>

										<ul	class="dropdown-menu dropdown-icon-only dropdown-yellow pull-right dropdown-caret dropdown-close">
											<li>
												<a href="ticket_comedor.htm?cod=<c:out value="${pad[0]}" />" class="tooltip-info" data-rel="tooltip" title="Registrar"> 
												<span class="blue"> <i	class="icon-folder-close-alt bigger-120"></i></span></a>
											</li>
										</ul>
										
									</div>
								</div>
							</td>
						</tr>
						
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>
	<!--/.span-->
</div>
<!--/.row-fluid-->