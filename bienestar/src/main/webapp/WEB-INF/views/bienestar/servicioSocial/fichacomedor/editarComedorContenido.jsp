<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Ficha Comedor <small> <i class="icon-double-angle-right"></i>
			Descripcion
		</small> <a href="../bienestar/lista_comedor.htm" title="Listar Comedor"
			class="btn btn-success btn-small pull-right"
			style="font-size: 20px; margin-right: 5px"><i class="icon-tasks"></i></a>
	</h1>
</div>
<div class="page-header position-relative">
	<form method="POST" class="form-horizontal"
		action="<c:url value='editarComedor.htm'/>"
		onsubmit="return validate(this)">
		<div class="row-fluid">
			<div class="page-content">
				<div class="span10">
					<div class="page-header">
						<h1 style="font-size: 20px">Datos Personales</h1>
					</div>
					<div style="margin-left: 20px">
						<div class="control-group">
							<p class="blue bigger-110">
								Nombres y Apellidos: <span class="grey">${model.datosalumno[0]}
									${model.datosalumno[1]} ${model.datosalumno[2]}</span>
							</p>
						</div>
						<div class="control-group">
							<p class="blue bigger-110">
								Escuela: <span class="grey">${model.datosalumno[3]}</span>
							</p>
						</div>
					</div>

					<div class="control-group">

						<div class="controls">
							<input class="input-large" type="hidden" name="idfichacomedor"
								value="${model.datosalumno[6]}">
						</div>
					</div>
				</div>
			</div>
			<!---------------------- 	codigo disponibles ------------------------------------>
			<div class="page-content">
				<div class="span10">
					<div class="page-header">
						<h1 style="font-size: 20px">Código de Carnet</h1>
					</div>
					<div class="control-group">
						<label class="control-label">Código:</label>
						<div class="controls">
							<div class="input-append">
								<input class="input-medium" name="codigo" id="numerocodigo"
									readonly="readonly" value="${model.codigoalumno}" type="text">
								<a href="#codigo" data-toggle="modal" class="btn btn-info"
									type="button">Buscar Códigos</a>
							</div>
						</div>
					</div>

				</div>
			</div>
			<!---------------------- 	Requisitos ------------------------------------>
			<div class="page-content">
				<div class="span10">
					<div class="page-header">
						<h1 style="font-size: 20px">Verificar Documentos</h1>
					</div>
					<div class="">
						<c:forEach var="n" items="${model.listaRequisitos2}">
							<div class="control-group">
								<div class="checkbox">
									<label> <input name="listaRequisitos2" onchange="validar()" id="check" type="checkbox" class="ace"
										value="${n.id }"> <span class="lbl"> <c:out
												value="${n.requisitos }"></c:out>
									</span></label>
									 <c:if test="${n.id==1}">
											<input class="input-medium" name="nota" id="nota"
												disabled="disabled" placeholder="Ingrese nota" type="text" value="${model.nota}" required>
										</c:if>
									

								</div>

							</div>
						</c:forEach>
					</div>

				</div>
			</div>
			<!---------------------- 	Categoria ------------------------------------>
			<div class="page-content">
				<div class="span10">
					<div class="page-header">
						<h1 style="font-size: 20px">Categorización</h1>
					</div>
					<div class="control-group">
						<label class="control-label" for="">Tipo</label>
						<div class="controls">
							<select name="categoria" class="input-xlarge" id="categoria">

								<c:forEach var="cat" items="${model.listacategoria}">
									<option value="${cat.id}">
										<c:out value="${cat.tipo}"></c:out>
									</option>
								</c:forEach>
							</select>
						</div>
					</div>


				</div>
			</div>
			<!---------------------- 	Motivo ------------------------------------>
			<div class="page-content">
				<div class="span10">
					<div class="page-header">
						<h1 style="font-size: 20px">Motivo</h1>
					</div>

					<div class="alert alert-block alert-success">
						<button type="button" class="close" data-dismiss="alert">
							<i class="icon-remove"></i>
						</button>

						<i class="icon-ok green"></i> Escribir el motivo del cambio
					</div>
					<div class="control-group">
						<label class="control-label" for="form-field-1">Motivo</label>
						<div class="controls">
							<textarea class="span10" name="motivo" id="form-field-1" required></textarea>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="form-actions">

			<button class="btn btn-info" type="submit">
				<i class="icon-ok bigger-110"></i> Guardar
			</button>
		</div>
	</form>
</div>








<!-- Modal -->

<div id="codigo" class="modal hide fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel">Códigos Disponibles</h3>
	</div>
	<div class="modal-body">

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#</th>
					<th>Código</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="n" items="${model.codigo}">
					<tr>
						<td class="center  sorting_1"><label> <input
								type="radio" name="codigo" value="${n[0]}" class="ace">
								<span class="lbl"></span>
						</label></td>
						<td><c:out value="${n[1]}" /></td>

					</tr>
				</c:forEach>

			</tbody>
		</table>

	</div>


	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">Cerrar</button>
		<button class="btn btn-primary" onclick="agregar()">Agregar</button>
	</div>

</div>





































