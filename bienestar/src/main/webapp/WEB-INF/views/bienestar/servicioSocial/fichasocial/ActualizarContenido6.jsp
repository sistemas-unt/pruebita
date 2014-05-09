<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="">
	<!--/.page-header-->
	<div class="row-fluid">
		<div class="span12">
			<!--PAGE CONTENT BEGINS-->

			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-header widget-header-blue widget-header-flat">
							<h4 class="lighter">Ficha de Servicio Social</h4>
						</div>

						<div class="widget-body">
							<div class="widget-main">
								<div class="row-fluid">
									<form:form modelAttribute="antecedentesEscolares">
										<div id="fuelux-wizard" class="row-fluid hide"
											data-target="#step-container" style="display: block;">
											<ul class="wizard-steps">
												<li data-target="#step1" class="complete"
													style="min-width: 11.1%; max-width: 11.1%;"><span
													class="step">1</span></li>

												<li data-target="#step2"
													style="min-width: 11.1%; max-width: 11.1%;"
													class="complete"><span class="step">2</span></li>

												<li data-target="#step3"
													style="min-width: 11.1%; max-width: 11.1%;"
													class="complete"><span class="step">3</span></li>
												<li data-target="#step4"
													style="min-width: 11.1%; max-width: 11.1%;"
													class="complete"><span class="step">4</span></li>
												<li data-target="#step5"
													style="min-width: 11.1%; max-width: 11.1%;"
													class="complete"><span class="step">5</span></li>
												<li data-target="#step6"
													style="min-width: 11.1%; max-width: 11.1%;" class="active"><span
													class="step">6</span></li>
												<li data-target="#step7"
													style="min-width: 11.1%; max-width: 11.1%;" class=""><span
													class="step">7</span></li>
												<li data-target="#step8"
													style="min-width: 11.1%; max-width: 11.1%;" class=""><span
													class="step">8</span></li>
												<li data-target="#step9"
													style="min-width: 11.1%; max-width: 11.1%;" class=""><span
													class="step">9</span></li>
											</ul>
										</div>

										<hr />
										<div class="step-content row-fluid position-relative"
											id="step-container">

											<!-- ----------------------- SITUACION ECONOMICA------------------------------------- -->
											<div class="step-pane active" id="step5">
												<div class="page-header position-relative">
													<h4 style="color: #2679b5">Antecedentes Escolares</h4>
												</div>
												<div class="form-horizontal">
													<div class="control-group">
														<label class="control-label" for="form-field-1">Tipo
															de CE</label>
														<div class="controls">
															<form:select id="tipoCE"
																path="saeTipoColegio.id">
																
																<c:forEach var="prod" items="${model.listaTipoColegio}">
																	<option value="${prod.id}">
																		<c:out value="${prod.tipo}"></c:out>
																	</option>
																</c:forEach>
															</form:select>
														</div>
													</div>
													<div class="control-group">
														<label class="control-label" for="form-field-1">Turno</label>
														<div class="controls">
															<form:select id="turno" path="SaeTurno.id">
																
																<c:forEach var="prod" items="${model.listaTurno}">
																	<option value="${prod.id}">
																		<c:out value="${prod.turno}"></c:out>
																	</option>
																</c:forEach>
															</form:select>
														</div>
													</div>
													<div class="control-group">
														<label class="control-label" for="form-field-1">Especialidad</label>
														<div class="controls">
															<form:select id="especialidad"
																path="saeEspecializacion.id">
																
																<c:forEach var="prod" items="${model.listaEspecialidad}">
																	<option value="${prod.id}">
																		<c:out value="${prod.especialidad}"></c:out>
																	</option>
																</c:forEach>
															</form:select>
														</div>
													</div>
													<div class="control-group">
														<label class="control-label" for="form-field-1">Nombre
															del colegio donde concluyo</label>
														<div class="controls">
															<form:input type="text" id="form-field-1" required="required"
																path="colegioTermino" 
																placeholder="ingrese nombre colegio" value="${model.listaAntEscolar[0][3]}"/>
														</div>
													</div>
													<div class="control-group">
														<label class="control-label" for="form-field-1">N°
															de veces que postulo a la universidad</label>
														<div class="controls">
															<form:input type="text" id="numPostulaciones" required="required"
																placeholder="ingrese cantidad" title="solo números"
																path="numPostulaciones"  value="${model.listaAntEscolar[0][4]}"/>
														</div>
													</div>
													<div class="control-group">
														<label class="control-label" for="form-field-1">Forma
															de Ingreso</label>
														<div class="controls">
															<form:select    id="formaIngreso"
																path="saeFormaIngreso.id">
																
																<c:forEach var="prod" items="${model.listaFormaIngreso}">
																	<option value="${prod.id}">
																		<c:out value="${prod.forma}"></c:out>
																	</option>
																</c:forEach>
															</form:select>
														</div>
													</div>
												</div>
											</div>
										</div>
										<hr>
										<div class="row-fluid wizard-actions">
											<button type="reset" class="btn btn-prev"
												onClick="location.href = 'actualizar_ficha_situacion_Economica.htm' ">
												<i class="icon-arrow-left"></i> Anterior
											</button>

											<button
												type="submit"
												class="btn btn-success btn-next" data-last="Finish ">
												Siguiente <i class="icon-arrow-right icon-on-right"></i>
											</button>
										</div>
									</form:form>
								</div>
							</div>
							<!--/widget-main-->
						</div>
						<!--/widget-body-->
					</div>
				</div>
			</div>
			<!--PAGE CONTENT ENDS-->
		</div>
		<!--/.span-->
	</div>
	<!--/.row-fluid-->
</div>

