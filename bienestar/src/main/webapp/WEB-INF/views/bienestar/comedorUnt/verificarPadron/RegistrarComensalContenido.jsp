<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="row-fluid">
	<div class="span12">
		<!--PAGE CONTENT BEGINS-->
		<div class="page-header">
			<h1>
				Registrar Comensal <small> <i
					class="icon-double-angle-right"></i> registro de comensales
				</small>
			</h1>
		</div>
		<br>
		<h4>Seleccione Tipo de Comensal :</h4>
		<div class="row-fluid">
			<div class="span2">
				<label class="inline"> <input name="form-field-radio"
					id="rbtApoyo" onclick="habilitarApoyo()" checked="checked"
					type="radio" /> <span class="lbl"> APOYO </span>
				</label>
			</div>

			<div class="span2">
				<label class="inline"> <input name="form-field-radio"
					id="rbtBomberos" onclick="habilitarBomberos()" type="radio" /> <span
					class="lbl"> BOMBEROS </span>
				</label>
			</div>

			<div class="span2">
				<label class="inline"> <input name="form-field-radio"
					onclick="habilitarPlanilla()" type="radio" /> <span class="lbl">
						PLANILLA </span>
				</label>
			</div>

			<div class="span2">
				<label class="inline"> <input name="form-field-radio"
					onclick="habilitarDelegaciones()" type="radio" /> <span
					class="lbl"> DELEGACIONES </span>
				</label>
			</div>

			<div class="span2">
				<label class="inline"> <input name="form-field-radio"
					onclick="habilitarLibres()" type="radio" /> <span class="lbl">
						LIBRES </span>
				</label>
			</div>
		</div>

		<!-- ---------------------------------------- REGISTRO DE APOYO----------------------------------------  -->
		<div class="row-fluid" id="apoyo" style="display: inline;">
			<div class="span12">
				<div class="page-header position-relative">
					<h5 style="color: #2679b5">Registrar comensales por apoyo</h5>
				</div>

				<form class="form-horizontal">
					<div class="control-group">
						<label class="control-label" for="txtcodigoA">Código N°</label>

						<div class="controls">
							<input type="text" id="txtcodigoA" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtNombresA">Nombres</label>

						<div class="controls">
							<input type="text" id="txtNombresA" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtApePaternoA">Apellido
							Paterno</label>

						<div class="controls">
							<input type="text" id="txtApePaternoA" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtApeMaternoA">Apellido
							Materno</label>

						<div class="controls">
							<input type="text" id="txtApeMaterno" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtResolucionA">N° de
							Resolución</label>

						<div class="controls">
							<input type="text" id="txtResolucionA" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtFechainicioA">Fecha
							de Inicio</label>

						<div class="controls">
							<input type="text" id="txtFechainicioA" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtFechaTerminoA">Fecha
							de termino</label>

						<div class="controls">
							<input type="text" id="txtFechaTerminoA" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtReferenciasA">Referencias</label>

						<div class="controls">
							<textarea rows="5" class="span5" id="txtReferencias"></textarea>
						</div>
					</div>

					<div class="form-actions">
						<button class="btn btn-info" type="button">
							<i class="icon-ok bigger-110"></i> Aceptar
						</button>

						&nbsp; &nbsp; &nbsp;
						<button class="btn" type="reset">
							<i class="icon-undo bigger-110"></i> Cancelar
						</button>
					</div>
				</form>

			</div>
		</div>

		<!-- ---------------------------------------- REGISTRO DE BOMBEROS-------------------------------------  -->
		<div class="row-fluid" id="bomberos" style="display: none;">
			<div class="span12">
				<div class="page-header position-relative">
					<h5 style="color: #2679b5">Registrar comensales de bomberos</h5>
				</div>

				<form class="form-horizontal">
					<div class="control-group">
						<label class="control-label" for="txtcodigoB">Código N°</label>

						<div class="controls">
							<input type="text" id="txtcodigoB" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtNombresB">Nombres</label>

						<div class="controls">
							<input type="text" id="txtNombresB" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtApePaternoB">Apellido
							Paterno</label>

						<div class="controls">
							<input type="text" id="txtApePaternoB" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtApeMaternoB">Apellido
							Materno</label>

						<div class="controls">
							<input type="text" id="txtApeMaternoB" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtResolucionB">N° de
							Resolución</label>

						<div class="controls">
							<input type="text" id="txtResolucionB" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtFechainicioB">Fecha
							de Inicio</label>

						<div class="controls">
							<input type="text" id="txtFechainicioB" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtFechaTerminoB">Fecha
							de termino</label>

						<div class="controls">
							<input type="text" id="txtFechaTerminoB" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtCantidadRacionesB">Cantidad
							de raciones</label>

						<div class="controls">
							<input type="text" id="txtCantidadRacionesB" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtReferenciasB">Referencias</label>

						<div class="controls">
							<textarea rows="5" class="span5" id="txtReferenciasB"></textarea>
						</div>
					</div>

					<div class="form-actions">
						<button class="btn btn-info" type="button">
							<i class="icon-ok bigger-110"></i> Aceptar
						</button>

						&nbsp; &nbsp; &nbsp;
						<button class="btn" type="reset">
							<i class="icon-undo bigger-110"></i> Cancelar
						</button>
					</div>
				</form>

			</div>
		</div>

		<!-- ---------------------------------------- REGISTRO DE PLANILLA-------------------------------------  -->
		<div class="row-fluid" id="planilla" style="display: none;">
			<div class="span12">
				<div class="page-header position-relative">
					<h5 style="color: #2679b5">Registrar comensales por planilla</h5>
				</div>

				<form class="form-horizontal">
					<div class="control-group">
						<label class="control-label" for="txtcodigoP">Código N°</label>

						<div class="controls">
							<input type="text" id="txtcodigoP" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtNombresP">Nombres</label>

						<div class="controls">
							<input type="text" id="txtNombresP" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtApePaternoP">Apellido
							Paterno</label>

						<div class="controls">
							<input type="text" id="txtApePaternoP" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtApeMaternoP">Apellido
							Materno</label>

						<div class="controls">
							<input type="text" id="txtApeMaternoP" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtResolucionP">N° de
							Resolución</label>

						<div class="controls">
							<input type="text" id="txtResolucionP" placeholder="" />
						</div>
					</div>
					<!-- <div class="control-group">
						<label class="control-label" for="txtFechainicioP">Fecha de
							Inicio</label>

						<div class="controls">
							<input type="text" id="txtFechainicioP" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtFechaTerminoP">Fecha
							de termino</label>

						<div class="controls">
							<input type="text" id="txtFechaTerminoP" placeholder="" />
						</div>
					</div>  -->

					<div class="form-actions">
						<button class="btn btn-info" type="button">
							<i class="icon-ok bigger-110"></i> Aceptar
						</button>

						&nbsp; &nbsp; &nbsp;
						<button class="btn" type="reset">
							<i class="icon-undo bigger-110"></i> Cancelar
						</button>
					</div>
				</form>

			</div>
		</div>

		<!-- ---------------------------------------- REGISTRO DE DELEGACIONES---------------------------------  -->
		<div class="row-fluid" id="delegaciones" style="display: none;">
			<div class="span12">
				<div class="page-header position-relative">
					<h5 style="color: #2679b5">Registrar comensales de
						delegaciones</h5>
				</div>

				<form class="form-horizontal">
					<div class="control-group">
						<label class="control-label" for="txtcodigoD">Código N°</label>

						<div class="controls">
							<input type="text" id="txtcodigoD" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtNombresD">Nombres</label>

						<div class="controls">
							<input type="text" id="txtNombresD" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtApePaternoD">Apellido
							Paterno</label>

						<div class="controls">
							<input type="text" id="txtApePaternoD" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtApeMaternoD">Apellido
							Materno</label>

						<div class="controls">
							<input type="text" id="txtApeMaternoD" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtImporteD">Importe S/.</label>

						<div class="controls">
							<input type="text" id="txtImporteD" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtFechainicioD">Fecha
							de Inicio</label>

						<div class="controls">
							<input type="text" id="txtFechainicioD" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtFechaTerminoD">Fecha
							de termino</label>

						<div class="controls">
							<input type="text" id="txtFechaTerminoD" placeholder="" />
						</div>
					</div>

					<div class="form-actions">
						<button class="btn btn-info" type="button">
							<i class="icon-ok bigger-110"></i> Aceptar
						</button>

						&nbsp; &nbsp; &nbsp;
						<button class="btn" type="reset">
							<i class="icon-undo bigger-110"></i> Cancelar
						</button>
					</div>
				</form>

				<div class="page-header position-relative">
					<h5 style="color: #2679b5">lista de integrantes de la
						delegación</h5>
				</div>
				
				<table id="sample-table-2"
				class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th class="center">N°</th>
						<th class="hidden-480">Codigo N°</th>
						<th>mmm</th>
						<th> nnnn</th>
						<th class="hidden-480">Apellidos y Nombres</th>
						<th class="hidden-480">Importe</th>
						<th>Fecha</th>
					</tr>
				</thead>
				<tbody>
						<tr>
							<td class="center"><c:out value=""/></td>
							<td class="center"><c:out value="" /></td>
							<td class="center"><c:out value="" /></td>
							<td class="hidden-480"><c:out value="" /></td>
							<td class="hidden-phone"><c:out value="" /></td>
							<td class="hidden-480"><span class="label label-important"> No Habilitado</span></td>
							<td class="td-actions center">
								<!-- OPCION VISIBLE -->
								<div class="hidden-phone visible-desktop action-buttons center">
									<a class="blue" href="ticket_comedor.htm?cod=<c:out value="" />"> <i class="icon-folder-close-alt bigger-130"> Registrar</i>
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
												<a href="ticket_comedor.htm?cod=<c:out value="" />" class="tooltip-info" data-rel="tooltip" title="Registrar"> 
												<span class="blue"> <i	class="icon-folder-close-alt bigger-120"></i></span></a>
											</li>
										</ul>
										
									</div>
								</div>
							</td>
						</tr>
				</tbody>
			</table>
			</div>
		</div>

		<!-- ---------------------------------------- REGISTRO DE LIBRES---------------------------------------  -->
		<div class="row-fluid" id="libres" style="display: none;">
			<div class="span12">
				<div class="page-header position-relative">
					<h5 style="color: #2679b5">Registrar comensales libres</h5>
				</div>

				<form class="form-horizontal">
					<div class="control-group">
						<label class="control-label" for="txtcodigoL">Código N°</label>

						<div class="controls">
							<input type="text" id="txtcodigoL" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtNombresL">Nombres</label>

						<div class="controls">
							<input type="text" id="txtNombresL" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtApePaternoL">Apellido
							Paterno</label>

						<div class="controls">
							<input type="text" id="txtApePaternoL" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtApeMaternoL">Apellido
							Materno</label>

						<div class="controls">
							<input type="text" id="txtApeMaternoL" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtImporteL">Importe S/.</label>

						<div class="controls">
							<input type="text" id="txtImporteL" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtFechainicioL">Fecha
							de Inicio</label>

						<div class="controls">
							<input type="text" id="txtFechainicioL" placeholder="" />
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="txtFechaTerminoL">Fecha
							de termino</label>

						<div class="controls">
							<input type="text" id="txtFechaTerminoL" placeholder="" />
						</div>
					</div>

					<div class="form-actions">
						<button class="btn btn-info" type="button">
							<i class="icon-ok bigger-110"></i> Aceptar
						</button>

						&nbsp; &nbsp; &nbsp;
						<button class="btn" type="reset">
							<i class="icon-undo bigger-110"></i> Cancelar
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>