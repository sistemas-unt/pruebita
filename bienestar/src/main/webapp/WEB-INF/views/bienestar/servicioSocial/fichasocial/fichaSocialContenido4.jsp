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
									<form method="post" name="FormStep4" id="FormStep4">
										<div id="fuelux-wizard" class="row-fluid hide"
											data-target="#step-container" style="display: block;">
											<ul class="wizard-steps">
												<li data-target="#step1" class="complete"
													style="min-width: 11.1%; max-width: 11.1%;"><span
													class="step">1</span> <span class="title"></span></li>

												<li data-target="#step2"
													style="min-width: 11.1%; max-width: 11.1%;"
													class="complete"><span class="step">2</span></li>

												<li data-target="#step3"
													style="min-width: 11.1%; max-width: 11.1%;"
													class="complete"><span class="step">3</span></li>
												<li data-target="#step4"
													style="min-width: 11.1%; max-width: 11.1%;" class="active"><span
													class="step">4</span></li>
												<li data-target="#step5"
													style="min-width: 11.1%; max-width: 11.1%;" class=""><span
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
												<div class="form-horizontal">
													<div class="row-fluid">
														<div class="page-header position-relative">
															<h4 style="color: #2679b5">Vivienda del Alumno</h4>
														</div>

														<div class="span10">
															<div class="control-group">
																<label class="control-label">¿Vive con sus
																	Padres?</label>
																<div class="controls">
																	<label class="inline"> <input name="rdbpadres"
																		type="radio" checked="checked" value=2
																		onclick="deshabilita()"> <span class="lbl">
																			SI</span> &nbsp;&nbsp;&nbsp;
																	</label> <label class="inline"> <input name="rdbpadres"
																		type="radio" title="HAGAclick" value=1
																		onclick="habilita()"> <span class="lbl">
																			NO</span>
																	</label>
																</div>
															</div>
														</div>
													</div>
													<div class="row-fluid">
														<div class="span10">
															<div class="row-fluid">
																<div class="control-group">
																		<label class="control-label" for="form-field-1">¿Motivo
																			de no vivir con sus padres?</label>
																		<div class="controls">
																			<textarea class="input-block-label" name="motivo"
																				required="required" disabled="disabled"></textarea>
																		</div>
																	</div>
																	<div class="control-group">
																		<label class="control-label" for="form-field-1">Ubicación</label>
																		<div class="controls">
																			<select name="ubicacion" disabled="disabled">
																				<option value="">--- Seleccione opción ---</option>
																				<c:forEach var="prod" items="${model.listaUbi}">
																					<option value="${prod.id}">
																						<c:out value="${prod.ubicacion}"></c:out>
																					</option>
																				</c:forEach>
																			</select>
																		</div>
																	</div>
																	<div class="control-group">
																		<label class="control-label" for="form-field-1">Material
																			de Construcción</label>
																		<div class="controls">
																			<select name="materialConstruccion"
																				disabled="disabled">
																				<option value="">--- Seleccione opción ---</option>
																				<c:forEach var="prod" items="${model.listaMat}">
																					<option value="${prod.id}">
																						<c:out value="${prod.material}"></c:out>
																					</option>
																				</c:forEach>
																			</select>
																		</div>
																	</div>
																	<div class="control-group">
																		<label class="control-label" for="form-field-1">Tenencia</label>
																		<div class="controls">
																			<select name="tenencia" disabled="disabled">
																				<option value="">--- Seleccione opción ---</option>
																				<c:forEach var="prod" items="${model.listaTen}">
																					<option value="${prod.id}">
																						<c:out value="${prod.tenencia}"></c:out>
																					</option>
																				</c:forEach>
																			</select>
																		</div>
																	</div>
																
																
																<div class="control-group">
																		<label class="control-label" for="form-field-1">Tipo</label>
																		<div class="controls">
																			<select name="tipo" disabled="disabled">
																				<option value="">--- Seleccione opción ---</option>
																				<c:forEach var="prod" items="${model.listaTipo}">
																					<option value="${prod.id}">
																						<c:out value="${prod.tipo}"></c:out>
																					</option>
																				</c:forEach>
																			</select>
																		</div>
																	</div>
																	<div class="control-group">
																		<label class="control-label" for="form-field-1">Agua
																			Potable</label>
																		<div class="controls">
																			<select name="aguapotable" disabled="disabled">
																				<option value="">--- Seleccione opción ---</option>
																				<c:forEach var="prod" items="${model.listaAgua}">
																					<option value="${prod.id}">
																						<c:out value="${prod.aguaPotable}"></c:out>
																					</option>
																				</c:forEach>
																			</select>
																		</div>
																	</div>
																	<div class="control-group">
																		<label class="control-label" for="form-field-1">Servicios
																			Higiénicos</label>
																		<div class="controls">
																			<select name="servicios" disabled="disabled">
																				<option value="">--- Seleccione opción ---</option>
																				<c:forEach var="prod" items="${model.listaServ}">
																					<option value="${prod.id}">
																						<c:out value="${prod.servicioHigienico}"></c:out>
																					</option>
																				</c:forEach>
																			</select>
																		</div>
																	</div>
																	<div class="control-group">
																		<label class="control-label" for="form-field-1">Iluminación</label>


																		<div class="controls">
																			<select name="iluminacion" disabled="disabled">
																				<option value="">--- Seleccione opción ---</option>
																				<c:forEach var="prod" items="${model.listaIlu}">
																					<option value="${prod.id}">
																						<c:out value="${prod.iluminacion}"></c:out>
																					</option>
																				</c:forEach>
																			</select>
																		</div>
																	</div>

																	<!-- <iframe width="560" height="315" src="//www.youtube.com/embed/n7zb_0-XrIs" 
																frameborder="0" allowfullscreen></iframe>-->
																	
															</div>
															<div class="row-fluid">
																
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<hr>
										<div class="row-fluid wizard-actions">
											<button type="reset" class="btn btn-prev"
												onClick="location.href = 'actualizar_ficha_vivienda_Familiar.htm'">
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

