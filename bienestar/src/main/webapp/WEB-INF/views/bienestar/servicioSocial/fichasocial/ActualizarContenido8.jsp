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
									<form class="form-horizontal" method="post"  onsubmit="return validar()">
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
													style="min-width: 11.1%; max-width: 11.1%;"
													class="complete"><span class="step">6</span></li>
												<li data-target="#step7"
													style="min-width: 11.1%; max-width: 11.1%;"
													class="complete"><span class="step">7</span></li>
												<li data-target="#step8"
													style="min-width: 11.1%; max-width: 11.1%;" class="active"><span
													class="step">8</span></li>
												<li data-target="#step9"
													style="min-width: 11.1%; max-width: 11.1%;" class=""><span
													class="step">9</span></li>
											</ul>
										</div>

										<hr />
										<div class="step-content row-fluid position-relative"
											id="step-container">

											<!-- ----------------------- SALUD ------------------------------------- -->
											<div class="step-pane active" id="step8">
												<div class="page-header position-relative">
													<h4 style="color: #2679b5">Alimentaci�n y Recreaci�n</h4>
												</div>
												<div class="row-fluid">
													<div class="span10">
														<div class="row-fluid">
															<div class="span12">
																<div class="control-group">
																	<label class="control-label" for="form-field-1">Lugar
																		donde toma sus alimentos</label>
																	<div class="controls">
																		<textarea class="span10" id="form-field-1"
																			name="txtLugarAlimentos"
																			placeholder="lugar donde toma sus alimentos.
																			Ejemplo casa, restaurante...">${model.listaAlimentacion.alimentacion}</textarea>
																	</div>
																</div>
															</div>
														</div>
														
														<div class="row-fluid">
															<div class="control-group">
																<div class="page-header position-relative">
																	<h5 style="color: #2679b5">�Qu� deporte pr�cticas?</h5>
																</div>
															</div>
														</div>
														<div class="row-fluid">
															<div class="span3">
																<div class="controls-group">
																	<!-- <label> <input name="listaDeportes" id="futbol" -->
																	<label> <input name="listaDeportes" id="futbol" 
																		type="checkbox"  value="FUTBOL">
																		<span class="lbl"> Futbol</span>
																	</label> <label> <input name="listaDeportes" id="natacion"
																		type="checkbox" value="NATACI�N">
																		<span class="lbl"> Nataci�n</span>
																	</label>
																</div>
															</div>
															<div class="span3">
																<div class="controls-group">
																	<label> <input name="listaDeportes" id="tennis"
																		type="checkbox"  value="TENNIS">
																		<span class="lbl"> Tennis</span>
																	</label> <label> <input name="listaDeportes" id="voley"
																		type="checkbox"  value="VOLLEYBALL">
																		<span class="lbl"> Volleyball</span>
																	</label>
																</div>
															</div>
															<div class="span3">
																<div class="controls-group">
																	<label> <input name="listaDeportes" id="basquet"
																		type="checkbox"  value="BASQUETBALL">
																		<span class="lbl"> Basquetball</span>
																	</label> <label> <input name="listaDeportes" id="ping"
																		type="checkbox"  value="PING PONG">
																		<span class="lbl"> Ping Pong</span>
																	</label>
																</div>
															</div>
															<div class="span3">
																<div class="controls-group">
																	<label> <input name="listaDeportes" id="equitacion"
																		type="checkbox"  value="EQUITACI�N">
																		<span class="lbl"> Equitaci�n</span>
																	</label> <label> <input name="listaDeportes" id="otros"
																		type="checkbox"  value="OTROS">
																		<span class="lbl"> Otros</span>
																	</label>
																</div>
															</div>
														</div>
														<div class="row-fluid">
															<div class="control-group">
																<div class="page-header position-relative">
																	<h5 style="color: #2679b5">�Cu�l de estas
																		aficiones pr�cticas?</h5>
																</div>
															</div>
														</div>
														<div class="row-fluid">
															<div class="span3">
																<div class="controls-group">
																	<label> <input name="listaAficiones" id="pintura"
																		type="checkbox" value="DIBUJO O PINTURA">
																		<span class="lbl"> Dibujo o Pintura</span>
																	</label> <label> <input name="listaAficiones"
																		id="decoracion" type="checkbox" value="DECORACI�N">
																		 <span class="lbl">
																			Decoraci�n</span>
																	</label> <label> <input name="listaAficiones" id="teatro"
																		type="checkbox"  value="TEATRO">
																		<span class="lbl"> Teatro</span>
																	</label> <label> <input name="listaAficiones"
																		id="fotografia" type="checkbox" 
																		value="FOTOGRAF�A"> <span class="lbl">
																			Fotograf�a</span>
																	</label>
																</div>
															</div>
															<div class="span3">
																<div class="controls-group">
																	<label> <input name="listaAficiones" id="Lectura"
																		type="checkbox" value="LECTURA">
																		<span class="lbl"> Lectura</span>
																	</label> <label> <input name="listaAficiones" id="escritor"
																		type="checkbox" value="ESCRITOR">
																		<span class="lbl"> Escritor</span>
																	</label> <label> <input name="listaAficiones" id="mecanica"
																		type="checkbox"  value="MEC�NICA">
																		<span class="lbl"> Mec�nica</span>
																	</label> <label> <input name="listaAficiones" id="poesia"
																		type="checkbox"  value="POES�A">
																		<span class="lbl"> Poes�a</span>
																	</label>
																</div>
															</div>
															<div class="span3">
																<div class="controls-group">
																	<label> <input name="listaAficiones" id="artesania"
																		type="checkbox"  value="ARTESAN�A">
																		<span class="lbl"> Artesan�a</span>
																	</label> <label> <input name="listaAficiones"
																		id="carpinteria" type="checkbox" 
																		value="CARPINTER�A"> <span class="lbl">
																			Carpinter�a</span>
																	</label> <label> <input name="listaAficiones" id="danza"
																		type="checkbox"  value="DANZA">
																		<span class="lbl"> Danza</span>
																	</label> <label> <input name="listaAficiones" id="costura"
																		type="checkbox"  value="COSTURA">
																		<span class="lbl"> Costura</span>
																	</label>
																</div>
															</div>
															<div class="span3">
																<div class="controls-group">
																	<label> <input name="listaAficiones" id="sastreria"
																		type="checkbox" value="SASTRER�A">
																		<span class="lbl"> Sastrer�a</span>
																	</label> <label> <input name="listaAficiones" id="ballet"
																		type="checkbox" value="BALLET">
																		<span class="lbl"> Ballet</span>
																	</label> <label> <input id="musicaa" type="checkbox" onclick="habilitaMusica()"
																		value="1"> <span
																		class="lbl"> M�sica</span>
																	</label> <input type="text" id="txtmusicaa" name="listaAficiones" required="required"
																		readonly="readonly" style="text-transform: uppercase;"
																		placeholder="ingrese el instrumento que toca...">
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
												onClick="location.href = 'actualizar_ficha_Salud.htm' ">
												<i class="icon-arrow-left"></i> Anterior
											</button>

											<button type="submit" 											
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

