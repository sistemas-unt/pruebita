
<%@ include file="/WEB-INF/views/include.jsp"%>



<div class="row-fluid">

	<form method="POST" action="<c:url value='editarperfil.htm'/>" onSubmit="return validar()">

		<div class="span12">

			<!-- inicio de datos personales -->

			<div class="widget-box">
				<div class="widget-header">
					<h4>
						<i class="icon-user"></i> Datos Personales
					</h4>

				</div>

				<div class="widget-body">
					<div class="widget-main">
						<div class="space-12"></div>
						<div class="row-fluid">
							<div class="span4 center">

								<span class="help-block green"> Haga click en la imagen
									para modificarla. </span> <span class="profile-picture"> <img
									class="editable" alt="Alex's Avatar" id="avatar2"
									src="../assets/avatars/profile-pic.jpg" />
								</span>
								<div class="space space-4"></div>
								<div
									class="width-80 label label-info label-large arrowed-in arrowed-in-right">
									<div class="inline position-relative">


										&nbsp; <span class="white middle bigger-120"><c:out
												value="${model.persona[6]}"></c:out> </span>


									</div>
								</div>


							</div>
							<div class="span4">

								<div class="control-group">



									<div class="controls">
										<input class="input-small" type="hidden" id="usuario"
											readonly="true" value="${model.persona[0]}"></input>

									</div>

									<div class="controls">
										<input class="input-small" type="hidden" id="estado"
											readonly="true" value="1"></input>

									</div>

									<label class="control-label blue bigger-120" for="form-field-1">Nombres
										y Apellidos:</label>
									<p class="bigger-110">
										<span class="grey">${model.persona[8]}
											${model.persona[9]} ${model.persona[10]}</span>
									</p>
									<div style="margin-top: 20px">
										<label class="control-label blue bigger-120"
											for="form-field-1">Escuela:</label>
										<p class="bigger-110">
											<span class="grey">${model.persona[15]}</span>
										</p>
									</div>
									<div style="margin-top: 20px">
										<label class="control-label blue bigger-120"
											for="form-field-first">Código:</label>

										<p class="bigger-110">
											<span class="grey">${model.persona[7]}</span>
										</p>
									</div>
									<div style="margin-top: 20px">
										<label class="control-label blue bigger-120"
											for="form-field-email">Email:</label>

										<p class="bigger-110">
											<span class="grey">${model.persona[23]}</span>
										</p>
									</div>



								</div>

							</div>

							<div class="span4">

								<div class="control-group">


									<label class="control-label blue bigger-120"> Fecha Nacimiento: </label>
									<div class="controls">
										<div class="input-append">
											<fmt:formatDate value="${model.persona[13]}" var="dateString"
												pattern="dd-MM-yyyy" />

<!-- 											<input class="input-largue input-mask-date" type="text" -->
<%-- 												id="fechaNacimiento" value="${dateString}"></input> --%>
									<input type="text" name="fechaNacimiento" id="fechaNacimiento" value="${dateString}"
													required="required" class="date-picker input-medium"
													placeholder="fecha de nacimiento"
													data-date-format="dd-mm-yyyy">
													<span class="add-on">
																		<i class="icon-calendar"></i>
																	</span>
										</div>
									</div>

									<label class="control-label blue bigger-120" for="estadoCivil">Estado Civil:</label>
									<div class="controls">
										<select class="form-control" id="estadoCivil"
											name="estadoCivil">
											<option value="0">Soltero(a)</option>
											<option value="1">Casado(a)</option>
											<option value="2">Viudo(a)</option>
											<option value="3">Divorciado(a)</option>

										</select>

									</div>
									<label class="control-label blue bigger-120" for="form-field-phone">Telefono:</label>
									<div class="controls">
										<input class="input-large input-mask-phone" type="text"
											maxlength="6" id="telefono" name="telefono"
											required="required" value="${model.persona[21]}" />
									</div>

									<label class="control-label blue bigger-120" for="form-field-phone">Celular:</label>
									<div class="controls">
										<input class="input-large input-mask-phone" type="text"
											maxlength="9" size="9" id="celular" name="celular"
											required="required" value="${model.persona[22]}" />
									</div>

								</div>


							</div>


						</div>
					</div>
				</div>

			</div>
			<!-- fin de datos personales -->

			<div class="hr hr-8 dotted"></div>


			<!------------------------------------------/#Ubigeo---------------------------------------->


			<div class="widget-box">
				<div class="widget-header ">
					<h4>

						<i class="icon-globe"></i> Ubigeo

					</h4>
				</div>

				<div class="widget-body">

					<div class="widget-main">

						<div class="row-fluid">


							<!----------------------inicio de lugar de nacimiento---------------------->

							<div class="span4">

								<div class="control-group">

									<h4 class="header smaller lighter blue">
										Lugar de Nacimiento <small> <i
											class="icon-double-angle-right"></i>
										</small>
									</h4>

									<div class="span1"></div>

									<div class="control-group">
										<label class="control-label" for="form-field-select-1">Departamento:</label>
										<div class="controls">
											<select id="departamento_nac" name="departamento_nac" class="form-control"  onchange="setProvinciasNac();">
												<c:forEach var="ubigeo_nac" items="${model.ubigeo}">
													<option value="${ubigeo_nac[0]}">
														<c:out value="${ubigeo_nac[1]}"></c:out>
													</option>
												</c:forEach>
											</select>
										</div>
									</div>


									<div class="span1"></div>
									<div class="control-group">
										<label class="control-label" for="form-field-select-1">Provincia:</label>
										<div class="controls">
											<select class="form-control" id="provincia_nac"  name="provincia_nac" onchange="setDistritosNac();">
											</select>
										</div>
									</div>


									<div class="span1"></div>
									<div class="control-group">
										<label class="control-label" for="form-field-select-1">Distrito:</label>
										<div class="controls">
											<select class="form-control" id="distrito_nac" name="distrito_nac">
											</select>
										</div>
									</div>

								</div>

							</div>
							<!--/span---------------------Termino de Lugar de nacimiento------------------------->

							<!------------------------------lugar de procedencia--------------------------------->
							<div class="span4">
								<div class="control-group">

									<h4 class="header smaller lighter blue">
										Lugar de Procedencia <small> <i
											class="icon-double-angle-right"></i></small>
									</h4>

									<div class="span1"></div>
									<div class="control-group">
										<label class="control-label" for="form-field-select-1">Departamento:</label>
										<div class="controls">
											<select class="form-control" id="departamento_proc" name="departamento_proc" onchange="setProvincias();">
												<c:forEach var="ubigeo_proc" items="${model.ubigeo}">
													<option value="${ubigeo_proc[0]}">
														<c:out value="${ubigeo_proc[1]}"></c:out>
													</option>
												</c:forEach>
											</select>
										</div>
									</div>

									<div class="span1"></div>
									<div class="control-group">
										<label class="control-label" for="form-field-select-1">Provincia:</label>
										<div class="controls">
											<select class="form-control" id="provincia_proc" name="provincia_proc" onchange="setDistritos();">
											</select>
										</div>
									</div>

									<div class="span1"></div>
									<div class="control-group">
										<label class="control-label" for="form-field-select-1">Distrito:</label>
										<div class="controls">
											<select class="form-control" id="distrito_proc" name="distrito_proc">
												
											</select>
										</div>
									</div>
								</div>
							</div>
							<!--/span--------Termino de lugar de procedencia-------------->

							<!----------inicio de domicilio actual------------------------------------>
							<div class="span4">
								<div class="control-group">
									<h4 class="header smaller lighter blue">
										Domicilio Actual <small> <i
											class="icon-double-angle-right"></i>

										</small>
									</h4>
									
									<div class="span1"></div>

									<div class="control-group">
										<label class="control-label" for="form-field-select-1">Departamento:</label>
										<div class="controls">
											<select class="form-control" id="departamento_act" name="departamento_act" onchange="setProvinciasAct();">
												<c:forEach var="ubigeo_act" items="${model.ubigeo}">
													<option value="${ubigeo_act[0]}">
														<c:out value="${ubigeo_act[1]}"></c:out>
													</option>
												</c:forEach>
											</select>
										</div>

									</div>

									<div class="span1"></div>
									<div class="control-group">
										<label class="control-label" for="form-field-select-1">Provincia:</label>
										<div class="controls">
											<select class="form-control" id="provincia_act" name="provincia_act" onchange="setDistritosAct();">
											</select>
										</div>
									</div>

									<div class="span1"></div>
									<div class="control-group">
										<label class="control-label" for="form-field-select-1">Distrito:</label>
										<div class="controls">
											<select class="form-control" id="distrito_act" name="distrito_act">												
											</select>
										</div>
									</div>
									
									<div class="span1"></div>
									<div class="control-group">
										<label class="control-label" for="form-field-1">Direccion Actual:</label>
										<div class="controls">
											<input class="input-large span10" type="text" id="domicilioActual"
												name="domicilioActual" placeholder="Domicilio Actual"
												required="required" value="${model.persona[19]}" />
										</div>
									</div>
									
								</div>
							</div>
							<!--/termino de domicilio actual------------------------------------------>
						</div>
					</div>
				</div>
			</div>

			<div class="hr hr-8 dotted"></div>

			<!-- botones -->

			<div class="form-actions center">
				<button id="actualizar" class="btn btn-info" type="submit">
					<i class="icon-ok bigger-110"></i> Actualizar Perfil
				</button>

				&nbsp; &nbsp;

			</div>
			<a href="#" id="btn-scroll-up"
				class="btn-scroll-up btn btn-small btn-inverse"> <i
				class="icon-double-angle-up icon-only bigger-110"></i>
			</a>
		</div>

	</form>

	<!-- --------------------------------------------------------------------------------- -->

	<script type="text/javascript">
		/*	$(document).ready(function() {
				sendAjax();
			});

			function sendAjax() {

				$.getJSON('bienestar/bienestar/editarperfil.htm',
						data = "${model.ubigeo}");
				alert();

			}*/
	</script>

</div>



