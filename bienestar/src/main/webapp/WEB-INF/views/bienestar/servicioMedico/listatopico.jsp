<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="page-header">
	<h1>
		Lista de Alumnos <small><i class="icon-double-angle-right"></i>
			Información del Alumno</small>

	</h1>
</div>


<div class="row-fluid">
	<div class="span12">

		<div class="table-header"
			style="background: #2283c5; padding-left: 5px; padding-bottom: 2px;">

			<a href="#dni" data-toggle="modal" title="Agregar Alumno"
				class="btn btn-small btn-primary" style="border: 1px solid #c4e7ff;"><i
				class="icon-inbox"></i>Agregar</a>

		</div>
		<table id="laboratorio"
			class="table table-striped table-bordered table-hover">

			<thead>
				<tr>
					<th class="center">N°</th>
					<th class="">Nombre</th>
					<th class="center">Código de Matrícula</th>
					<th class="center">DNI</th>
					<th class="hidden-phone">Escuela</th>
					<th class="center">Llenar</th>
				

				</tr>
			</thead>
			<tbody>

				<c:forEach var="n" items="${model.listaatendidos}" varStatus="contador">
					<tr>
						<td class="center"><c:out value="${contador.count}" /></td>
						<td><c:out value="${n[0]} ${n[1]} ${n[2]}"></c:out></td>
						<td class="center"><c:out value="${n[3]}"></c:out></td>
						<td class="center"><c:out value="${n[4]}"></c:out></td>
						<td class="hidden-phone"><c:out value="${n[5]} "></c:out></td>
				

												<td class="center"><a href="../bienestar/fichatopico.htm"   > 
												<i class="icon-trash"></i>Llenar</a>
												</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<!--/.span-->
</div>
<!--/.row-fluid-->