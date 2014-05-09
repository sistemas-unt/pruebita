<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="page-header">
	<h1>
		Ficha Médica <small><i class="icon-double-angle-right"></i>
			Información del Alumno</small>

	</h1>
</div>
<div class="row-fluid">
	<!-- 									<form class="" name="formStep1" method="post" > -->



	<div class="row-fluid " id="step-container">

		<!-- ----------------------- DATOS PERSONALES------------------------------------- -->
		<div class="" id="step1">
			<div class="row-fluid">



				<div class="span8">
					<div class="page-header position-relative">
						<h4 style="color: #2679b5">Antecedentes Familiares</h4>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="form-field-1">Parentezco</label>
								<div class="controls">
									<select name="cboparentezco" id="parentezco">
										<option value="0">Padre</option>
										<option value="1">Madre</option>
										<option value="2">Hermano</option>
										<option value="3">Otro</option>
									</select>
								</div>
							</div>
							<div class="control-group" id="pregunta">
								<label class="inline">¿Sufre Enfermedad?
									&nbsp;&nbsp;&nbsp;&nbsp; <input name="rtbsano" type="radio"
									onclick="habilitaenfermedad()" value="1"> <span
									class="lbl"> SI</span> &nbsp;&nbsp;&nbsp;
								</label> <label class="inline"> <input name="rtbsano"
									id="enferNo" type="radio" title="HAGAclick"
									onclick="deshabilitaenfermedad()" checked="checked" value="0">
									<span class="lbl"> NO</span>
								</label>
							</div>

							<div class="control-group" id="enfer">

								<div class="controls">
									<textarea rows="2" id="enfermedad" data-maxlength="200"
										required="required" name="txtenfermedad" maxlength="200"
										placeholder="Escribir sus enfermedades"></textarea>
								</div>
							</div>

						</div>
						<div class="span6">
							<div class="control-group">
								<label class="inline">¿Su familiar es fallecido?
									&nbsp;&nbsp;&nbsp;&nbsp; <input name="rtbfallecido"
									type="radio" onclick="habilitafallecido()" value="1"> <span
									class="lbl"> SI</span> &nbsp;&nbsp;&nbsp;
								</label> <label class="inline"> <input name="rtbfallecido"
									id="falleNo" type="radio" title="HAGAclick"
									onclick="deshabilitafallecido()" checked="checked" value="0">
									<span class="lbl"> NO</span>
								</label>
							</div>

							<div class="control-group" id="falle">

								<div class="controls">
									<textarea rows="2" id="fallecimiento" data-maxlength="200"
										required="required" name="txtfallecimiento" maxlength="200"
										placeholder="Especificar su causa"></textarea>
								</div>
							</div>

							<input name="btnInsertar" class="btn btn-success"
								id="btnInsertar" type="button" onclick="insertar()"
								value="Insertar" />

						</div>
						<table class="table table-striped table-bordered table-hover"
							id="tblDatos">
							<thead>
							
								<tr>
								
									<th>Parentesco</th>
									<th>Enfermedad</th>
									<th>Causa del Fallecimiento</th>
									<th>Eliminar</th>

								</tr>
							</thead>
							<tbody>

							</tbody>
						</table>


					</div>



				</div>
			</div>
			<!-- row-fluid -->
		</div>
	</div>

	<hr>
	<div class="row-fluid wizard-actions">
		<button class="btn btn-prev" disabled="disabled">
			<i class="icon-arrow-left"></i> Anterior
		</button>

		<a href="../bienestar/fichamedica2.htm" type="submit"
			class="btn btn-success btn-next" data-last="Finish "> Siguiente <i
			class="icon-arrow-right icon-on-right"></i>
		</a>
	</div>
	<!-- 									</form> -->
</div>

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script type="text/javascript">
	function insertar() {
		var parentezco = $("#parentezco").val();
		var enfermedad = $("#enfermedad").val();
		var fallecimiento = $("#fallecimiento").val();
		var a = innerHTML = "<a href='#' onclick='eliminar(this)' id='del'><i class='icon-trash'></i></a>";
		var tablaDatos = $("#tblDatos");

		if (parentezco != "" || enfermedad != "" || fallecimiento != "") {
			tablaDatos.append("<tr><td>" + parentezco + "</td><td>"
					+ enfermedad + "</td><td>" + fallecimiento + "</td><td>"
					+ a + "</td></tr>");
			reset_campos();
		}

	}
	function reset_campos() {
		$("#enfermedad").val("");
		$("#fallecimiento").val("");
	}
	function eliminar(a) {

		var td = a.parentNode;
		var tr = td.parentNode;
		var table = tr.parentNode;
		table.removeChild(tr);

	}
</script>