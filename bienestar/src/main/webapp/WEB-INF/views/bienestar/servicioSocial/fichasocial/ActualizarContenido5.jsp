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
									<form class="" name="formulario5" method="post">
										<div id="fuelux-wizard" class="row-fluid hide" data-
											target="#step-container" style="display: block;">
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
													style="min-width: 11.1%; max-width: 11.1%;" class="active"><span
													class="step">5</span></li>
												<li data-target="#step6"
													style="min-width: 11.1%; max-width: 11.1%;" class=""><span
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

											<!-- ----------------------- VIVIENDA DEL ALUMNO------------------------------------- -->
											<div class="step-pane active" id="step4">
												<div class="row-fluid">
													<div class="span10">
														<div class="page-header position-relative">
															<h4 style="color: #2679b5">Situación Económica del Alumno</h4>
														</div>
														<div class="row-fluid">
															<div class="span6">
																<div class="control-group">
																	<label class="control-label" for="form-field-1">Ocupación
																		laboral</label>
																	<div class="controls">
																		<select id="ocupacion" name="situacion">
																			
																			<c:forEach var="prod" items="${model.listaOcupacion}">
																				<option value="${prod.id}">
																					<c:out value="${prod.ocupacion}"></c:out>
																				</option>
																			</c:forEach>
																		</select>
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="form-field-1">Condición</label>
																	<div class="controls">
																		<select id="condicion" name="situacion">
																			
																			<c:forEach var="prod" items="${model.listaCondicion}">
																				<option value="${prod.id}">
																					<c:out value="${prod.condicion}"></c:out>
																				</option>
																			</c:forEach>
																		</select>
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="form-field-1">Dedicación</label>
																	<div class="controls">
																		<select id="dedicacion" name="situacion">
																			
																			<c:forEach var="prod"
																				items="${model.listaDedicacion}">
																				<option value="${prod.id}">
																					<c:out value="${prod.dedicacion}"></c:out>
																				</option>
																			</c:forEach>
																		</select>
																	</div>
																</div>
															</div>
															<div class="span6">
																<div class="control-group">
																	<label class="control-label" for="form-field-1">Turno
																		de Trabajo</label>
																	<div class="controls">
																		<select id="turno" name="situacion">
																			
																			<c:forEach var="prod" items="${model.listaTrabajo}">
																				<option value="${prod.id}">
																					<c:out value="${prod.turno}"></c:out>
																				</option>
																			</c:forEach>
																		</select>
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="form-field-1">Centro
																		de trabajo</label>
																	<div class="controls">
																		<input type="text" id="form-field-1" name="lugar"
																			placeholder="Ingrese su lugar de trabajo" value="${model.listaSituacionEconomica[0][4]}">
																	</div>
																</div>
															</div>
														</div>
														<!-- ---------------------------- CUADRO 2 INGRESOS  ------------------------------------------------ -->

														<div class="page-header position-relative">
															<h4 style="color: #2679b5">Ingresos percibidos por el Alumno</h4>
														</div>
														<div class="row-fluid">
															<div class="span6">
																<div class="control-group">
																	<label class="control-label" for="form-field-1">Padres</label>
																	<div class="controls">
																		<input type="text" id="cantpadres" name="ingresos"
																			placeholder="ingrese cantidad" title="solo numeros"
																			onblur="suma()" value="${model.listaSituacionEconomica[0][5]}">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="form-field-1">Trabajo</label>
																	<div class="controls">
																		<input type="text" id="canttrabajo" name="ingresos"
																			placeholder="ingrese cantidad" onblur="suma()" value="${model.listaSituacionEconomica[0][6]}">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="form-field-1">Pensión
																		Judicial</label>
																	<div class="controls">
																		<input type="text" id="cantpension" name="ingresos"
																			placeholder="ingrese cantidad" onblur="suma()" value="${model.listaSituacionEconomica[0][7]}">
																	</div>
																</div>
															</div>
															<div class="span6">
																<div class="control-group">
																	<label class="control-label" for="form-field-1">Abuelos</label>
																	<div class="controls">
																		<input type="text" id="cantabuelos" name="ingresos"
																			placeholder="ingrese cantidad" onblur="suma()" value="${model.listaSituacionEconomica[0][8]}">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="form-field-1">Otros
																		Parientes</label>
																	<div class="controls">
																		<input type="text" id="cantotros" name="ingresos"
																			placeholder="ingrese cantidad" onblur="suma()" value="${model.listaSituacionEconomica[0][9]}">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="form-field-1">TOTAL</label>
																	<div class="controls">
																		<input type="text" id="total" name="total"
																			readonly="readonly" placeholder="ingrese cantidad">
																	</div>
																</div>
															</div>
														</div>


														<!-- ---------------------------- CUADRO 3 EGRESOS  ------------------------------------------------ -->

														<div class="page-header position-relative">
															<h4 style="color: #2679b5">Egresos percibidos por el Alumno</h4>
														</div>
														<div class="row-fluid">
															<div class="span6">
																<div class="control-group">
																	<label class="control-label" for="form-field-1">Pension
																		Universitaria</label>
																	<div class="controls">
																		<input type="text" id="cantepension" name="egresos"
																			placeholder="ingrese cantidad" onblur="sumae()" value="${model.listaSituacionEconomica[0][10]}">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="form-field-1">Habitacion</label>
																	<div class="controls">
																		<input type="text" id="cantehabitacion" name="egresos"
																			placeholder="ingrese cantidad" onblur="sumae()" value="${model.listaSituacionEconomica[0][11]}">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="form-field-1">Movilidad</label>
																	<div class="controls">
																		<input type="text" id="cantemovilidad" name="egresos"
																			placeholder="ingrese cantidad" onblur="sumae()" value="${model.listaSituacionEconomica[0][12]}">
																	</div>
																</div>
															</div>
															<div class="span6">
																<div class="control-group">
																	<label class="control-label" for="form-field-1">Alimentacion</label>
																	<div class="controls">
																		<input type="text" id="cantealimentacion"
																			name="egresos" placeholder="ingrese cantidad" value="${model.listaSituacionEconomica[0][13]}"
																			onblur="sumae()">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="form-field-1">Vestimenta</label>
																	<div class="controls">
																		<input type="text" id="cantevestimenta" name="egresos"
																			placeholder="ingrese cantidad" onblur="sumae()" value="${model.listaSituacionEconomica[0][14]}">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="form-field-1">Utiles</label>
																	<div class="controls">
																		<input type="text" id="canteutiles" name="egresos"
																			placeholder="ingrese cantidad" onblur="sumae()" value="${model.listaSituacionEconomica[0][15]}">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="form-field-1">TOTAL</label>
																	<div class="controls">
																		<input type="text" id="totale" name="totale"
																			readonly="readonly" placeholder="ingrese cantidad">
																	</div>
																</div>
																<div hidden="">
																<input type="text" value="${model.listaSituacionEconomica[0][16]}" name="IdIngreso" hidden=""/>
																<input type="text" value="${model.listaSituacionEconomica[0][17]}" name="IdEgreso" hidden=""/>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<hr>
										<div class="row-fluid wizard-actions">
											<button type="reset" class="btn btn-prev"
												onClick="location.href = 'actualizar_ficha_vivienda_Alumno.htm'">
												<i class="icon-arrow-left"></i> Anterior
											</button>

											<button type="submit" class="btn btn-success btn-next"
												data-last="Finish ">
												Siguiente <i class="icon-arrow-right icon-on-right"></i>
											</button>
										</div>
									</form>
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

