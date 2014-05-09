<%@ include file="/WEB-INF/views/include.jsp"%>

<c:url var="getDeparList" value="/ficha_Servicio_Social.htm" />

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
									<form class="" name="formStep1" method="post" >
										<div id="fuelux-wizard" class="row-fluid hide"
											data-target="#step-container" style="display: block;">
											<ul class="wizard-steps">
												<li data-target="#step1" class="active"
													style="min-width: 11.1%; max-width: 11.1%;"><span
													class="step">1</span> <span class="title"> </span></li>

												<li data-target="#step2"
													style="min-width: 11.1%; max-width: 11.1%;" class=""><span
													class="step">2</span> <span class="title"> </span></li>

												<li data-target="#step3"
													style="min-width: 11.1%; max-width: 11.1%;" class=""><span
													class="step">3</span> <span class="title"> </span></li>
												<li data-target="#step4"
													style="min-width: 11.1%; max-width: 11.1%;" class=""><span
													class="step">4</span> <span class="title"> </span></li>
												<li data-target="#step5"
													style="min-width: 11.1%; max-width: 11.1%;" class=""><span
													class="step">5</span> <span class="title"></span></li>
												<li data-target="#step6"
													style="min-width: 11.1%; max-width: 11.1%;" class=""><span
													class="step">6</span> <span class="title"></span></li>
												<li data-target="#step7"
													style="min-width: 11.1%; max-width: 11.1%;" class=""><span
													class="step">7</span> <span class="title"></span></li>
												<li data-target="#step8"
													style="min-width: 11.1%; max-width: 11.1%;" class=""><span
													class="step">8</span> <span class="title"></span></li>
												<li data-target="#step9"
													style="min-width: 11.1%; max-width: 11.1%;" class=""><span
													class="step">9</span> <span class="title"></span></li>
											</ul>
										</div>

										<hr />
										<div class="step-content row-fluid position-relative"
											id="step-container">

											<!-- ----------------------- DATOS PERSONALES------------------------------------- -->
											<div class="step-pane active" id="step1">
												<div class="row-fluid">

													<div class="span10">
														<div class="page-header position-relative">
															<h4 style="color: #2679b5">Antecedentes Personales</h4>
														</div>
														<div class="row-fluid">
															<div class="span6">
																<div class="control-group">
																	<div class="controls">
																		<label class="inline">¿Sufre de alguna
																			enfermedad?&nbsp; <input name="enfermedadradio"
																			type="radio" onclick="habilitaenfermedad()" value="1">
																			<span class="lbl"> SI</span> &nbsp;&nbsp;&nbsp;
																		</label> <label class="inline"> <input
																			name="enfermedadradio" type="radio" title="HAGAclick"
																			onclick="deshabilitaenfermedad()" checked="checked"
																			value="0"> <span class="lbl"> NO</span>
																		</label>
																	</div>
																</div>
																<div class="control-group">
																	<div class="controls">
																		<textarea class="span10 " id="txtenfermedad"
																			name="txtenfermedad" readonly="readonly" required="required"
																			placeholder="si sufre de alguna enfermedad presione SI para escribir la(s) emfermedad(es) de la cual padece..."></textarea>
																	</div>
																</div>
																<div class="control-group">
																	<div class="controls">
																		<label class="inline">¿A tenido alguna
																			operación?&nbsp;<input name="operacionradio"
																			type="radio" onclick="habilitaoperacion()" value="1">
																			<span class="lbl"> SI</span> &nbsp;&nbsp;&nbsp;
																		</label> <label class="inline"> <input
																			name="operacionradio" type="radio" title=""
																			onclick="deshabilitaoperacion()" checked="checked"
																			value="0"> <span class="lbl"> NO</span>
																		</label>
																	</div>
																</div>
																<div class="control-group">
																	<div class="controls">
																		<textarea class="span10" id="txtoperacion"
																			name="txtoperacion" readonly="readonly" required="required"
																			placeholder="si a tenido alguna operación presione SI para escribir la(s) operacion(es) la cual le realizaron..."></textarea>
																	</div>
																</div>
																<div class="control-group">
																	<div class="controls">
																		<label class="inline">¿Le han realizado alguna
																			inmunización?&nbsp; <input name="inmunizacionradio"
																			type="radio" onclick="habilitainmunizacion()"
																			value="1"> <span class="lbl"> SI</span>
																			&nbsp;&nbsp;&nbsp;
																		</label> <label class="inline"> <input
																			name="inmunizacionradio" type="radio"
																			title="HAGAclick" onclick="deshabilitainmunizacion()"
																			checked="checked" value="0"> <span
																			class="lbl"> NO</span>
																		</label>
																	</div>
																</div>
																<div class="control-group">
																	<div class="controls">
																		<textarea class="span10" id="txtinmunizacion"
																			name="txtinmunizacion" readonly="readonly" required="required"
																			placeholder="si le han realizado alguna inmunización presione SI para escribir el motivo..."></textarea>
																	</div>
																</div>
															</div>
															<div class="span6">
																<div class="control-group">
																	<label class="control-label"></label>
																	<div class="controls">
																		<label class="inline">¿A sufrido algún
																			accidente?&nbsp; <input name="accidenteradio"
																			type="radio" onclick="habilitaaccidente()" value="1">
																			<span class="lbl"> SI</span> &nbsp;&nbsp;&nbsp;
																		</label> <label class="inline"> <input
																			name="accidenteradio" type="radio" title="HAGAclick"
																			onclick="deshabilitaaccidente()" checked="checked"
																			value="0"> <span class="lbl"> NO</span>
																		</label>
																	</div>
																</div>
																<div class="control-group">
																	<div class="controls">
																		<textarea class="span10" id="txtaccidente"
																			name="txtaccidente" readonly="readonly" required="required"
																			placeholder="si a sufrido algún accidente presione SI para escribir..."></textarea>
																	</div>
																</div>

																<div class="control-group">
																	<div class="controls">
																		<label class="inline">¿Sufre de algún tipo de
																			alergia? <input name="alergiaradio" type="radio"
																			onclick="habilitaalergia()" value="1"> <span
																			class="lbl"> SI</span> &nbsp;&nbsp;&nbsp;
																		</label> <label class="inline"> <input
																			name="alergiaradio" type="radio" title="HAGAclick"
																			onclick="deshabilitaalergia()" checked="checked"
																			value="0"> <span class="lbl"> NO</span>
																		</label>
																	</div>
																</div>
																<div class="control-group">
																	<div class="controls">
																		<textarea class="span10" id="txtalergia"
																			name="txtalergia" readonly="readonly" required="required"
																			placeholder="si sufre de algún tipo de alergia presione SI para escribir..."></textarea>
																	</div>
																</div>

																<div class="control-group">
																	<label class="control-label"></label>
																	<div class="controls">
																		<label class="inline">¿Utiliza lentes?&nbsp; <input
																			name="lentesradio" type="radio" value="1"> <span
																			class="lbl"> SI</span> &nbsp;&nbsp;&nbsp;
																		</label> <label class="inline"> <input
																			name="lentesradio" type="radio" title="HAGAclick"
																			checked="checked" value="0"> <span
																			class="lbl"> NO</span>
																		</label>
																	</div>
																</div>
															</div>
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

											<button
												type="submit"
												class="btn btn-success btn-next" data-last="Finish ">
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

