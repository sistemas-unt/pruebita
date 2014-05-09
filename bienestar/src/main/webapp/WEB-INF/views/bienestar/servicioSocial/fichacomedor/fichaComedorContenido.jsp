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
	<form method="POST" class="form-horizontal" name="form2"
		 action="<c:url value='ficha_comedor.htm'/>" onsubmit="return validate(this)">
		<div class="row-fluid">
			<div class="page-content">
				<div class="span10">
					<div class="page-header">
						<h1 style="font-size: 20px">Datos Personales</h1>
					</div>
					<div style="margin-left: 20px">
						<div class="control-group">
							<p class="blue bigger-110">
								Nombres y Apellidos: <span class="grey">${model.datos.persona.nombres}
									${model.datos.persona.apellidoPaterno}
									${model.datos.persona.apellidoMaterno}</span>
							</p>
						</div>
						<div class="control-group">
							<p class="blue bigger-110">
								Escuela: <span class="grey">${model.datos.dependencia.nombre}</span>
							</p>
						</div>
					</div>
					<div class="control-group">

						<div class="controls">
							<input class="input-large" readonly="true" type="hidden"
								name="idalumno" placeholder="Escuela"
								value="${model.datos.persona.id}">
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
								<input class="input-medium" name="codigo" readonly="readonly"
									id="numerocodigo" type="text" required> <a
									href="#codigo" data-toggle="modal" class="btn btn-info"
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
						<c:forEach var="n" items="${model.listaRequisitos}">
							<div class="control-group">
								<div class="checkbox">
									<label> <input name="listaRequisitos" id="check2" type="checkbox"
										class="ace" value="${n.id }"> <span class="lbl">
											<c:out value="${n.requisitos }"></c:out>
									</span></label>
									<c:if test="${n.id==1}">
											<input class="input-medium" name="nota" id="nota2"
												disabled="disabled" placeholder="Ingrese nota" type="text" required>
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
							<select name="categoria" class="input-xlarge">
								
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
								type="radio" name="codigo" value="${n[0]}" class="ace"> <span
								class="lbl"></span>
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

