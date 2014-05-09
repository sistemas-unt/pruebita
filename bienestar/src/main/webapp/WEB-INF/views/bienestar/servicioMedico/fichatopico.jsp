<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Ficha Tópico <small> <i class="icon-double-angle-right"></i>
			Descripcion
		</small> <a href="../bienestar/servicioclinicotopico.htm"
			title="Lista de Alumnos" class="btn btn-success btn-small pull-right"
			style="font-size: 20px; margin-right: 5px"><i class="icon-tasks"></i></a>
	</h1>
</div>
<div class="page-header position-relative">
	<form method="POST" class="form-horizontal" name="form2"
		action="#"
		onsubmit="return validate(this)">
		<div class="row-fluid">
			<div class="page-content">
				<div class="span12">
					
					<div style="margin-left: 20px">
						<div class="control-group">
							<p class="blue bigger-110">
								Nombres y Apellidos: <span class="grey">Segundo Leiva
									Carvallo</span>
							</p>
						</div>
						<div class="control-group">
							<p class="blue bigger-110">
								Escuela: <span class="grey">Escuela de Sistema</span>
							</p>
						</div>
					</div>
					<div class="row-fluid">
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="">Peso</label>
								<div class="controls">
									<input type="text" id="" placeholder="Peso">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Talla</label>
								<div class="controls">
									<input type="text" id=""
										placeholder="Talla">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Estado Nutricional</label>
								<div class="controls">
									<input type="text" id=""
										placeholder="Estado Nutricional">
								</div>
							</div>
						</div>
						<div class="span6">
							<div class="control-group">
								<label class="control-label" for="">Agudeza Visual</label>
								<div class="controls">
									<input type="text" id="" placeholder="Agudeza Visual">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Ojo Derecho</label>
								<div class="controls">
									<input type="text" id=""
										placeholder="">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="">Ojo Izquierdo</label>
								<div class="controls">
									<input type="text" id=""
										placeholder="">
								</div>
							</div>
						</div>
					</div>
					<div class="control-group">

						<div class="controls">
							<input class="input-large" readonly="true" type="hidden"
								name="idalumno" placeholder="Escuela" value="">
						</div>
					</div>
				</div>
			</div>
			<!---------------------- 	codigo disponibles ------------------------------------>

			<!---------------------- 	Requisitos ------------------------------------>



		</div>
		<div class="form-actions">

			<button class="btn btn-info" type="submit">
				<i class="icon-ok bigger-110"></i> Guardar
			</button>
		</div>
	</form>
</div>






