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
									<div id="fuelux-wizard" class="row-fluid hide"
										data-target="#step-container" style="display: block;">
										<ul class="wizard-steps">
											<li data-target="#step1" class="complete"
												style="min-width: 11.1%; max-width: 11.1%;"><span
												class="step">1</span> <span class="title"></span></li>

											<li data-target="#step2"
												style="min-width: 11.1%; max-width: 11.1%;" class="active"><span
												class="step">2</span> <span class="title"></span></li>

											<li data-target="#step3"
												style="min-width: 11.1%; max-width: 11.1%;" class=""><span
												class="step">3</span> <span class="title"></span></li>
											<li data-target="#step4"
												style="min-width: 11.1%; max-width: 11.1%;" class=""><span
												class="step">4</span> <span class="title"></span></li>
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

										<!-- ----------------------- GRUPO FAMILIAR------------------------------------- -->
										<div class="step-pane active" id="step2">
											<div class="row-fluid">
												<div class="page-header position-relative">
													<h4 style="color: #2679b5;">Grupo Familiar</h4>
												</div>
												<p style="padding-left: 30px">

													<a href="#modal-agregar" title="Agregar Familiar"
														class="btn btn-info btn-small" role="button" class="blue"
														data-toggle="modal"><i class="icon-user"> Agregar</i></a>
												</p>
												<div class="span11">

													<c:choose>
														<c:when test="${empty model.listafamilia}">
															<h3>Lista de Familiares vacía. Ingrese para poder
																continuar</h3>
														</c:when>
														<c:otherwise>
															<table id="tblDatos"
																class="table table-striped table-bordered table-hover">
																<thead>
																	<tr>
																		<th class="center">Dni</th>
																		<th class="center">Nombres</th>
																		<th class="hidden-480">Apellido Paterno</th>
																		<th class="hidden-480">Apellidos Materno</th>
																		<th class="hidden-480">Fecha de Nacimiento</th>
																		<th class="hidden-phone">Parentezco</th>
																		<th class="hidden-phone">Estado Civil</th>
																		<th class="hidden-phone">Grado de
																			Instrucci&oacute;n</th>
																		<th class="hidden-phone">Lugar de Nacimiento</th>
																		<th class="hidden-phone">Acción</th>
																	</tr>
																</thead>
																<tbody>
																	<c:forEach var="n" items="${model.listafamilia}">
																		<tr>
																			<td class="center"><c:out
																					value="${n.docIdentidad}"></c:out></td>
																			<td class="center"><c:out value="${n.nombres } "></c:out></td>
																			<td class="hidden-480"><c:out
																					value="${n.apellidoPaterno } "></c:out></td>
																			<td class="hidden-480"><c:out
																					value="${n.apellidoMaterno } "></c:out></td>
																			<td class="hidden-480"><c:out
																					value="${n.fechaNacimiento } "></c:out></td>
																			<c:if test="${n.parentesco==0 }">
																				<td class="hidden-phone">Padre</td>
																			</c:if>
																			<c:if test="${n.parentesco==1 }">
																				<td class="hidden-phone">Madre</td>
																			</c:if>
																			<c:if test="${n.parentesco==2 }">
																				<td class="hidden-phone">Hermano</td>
																			</c:if>
																			<c:if test="${n.parentesco==3 }">
																				<td class="hidden-phone">Otro</td>
																			</c:if>

																			<c:if test="${n.estadoCivil==0 }">
																				<td class="hidden-phone">Soltero</td>
																			</c:if>
																			<c:if test="${n.estadoCivil==1 }">
																				<td class="hidden-phone">Casado</td>
																			</c:if>
																			<c:if test="${n.estadoCivil==2 }">
																				<td class="hidden-phone">Vuido</td>
																			</c:if>
																			<c:if test="${n.estadoCivil==3 }">
																				<td class="hidden-phone">Divorciado</td>
																			</c:if>

																			<td class="hidden-phone"><c:out
																					value="${n.gradoInstruccion } "></c:out></td>
																			<td class="hidden-phone"><c:out
																					value="${n.lugarNacimiento } "></c:out></td>
																			<td class="hidden-phone"><div
																					class="hidden-phone visible-desktop btn-group">
																					<!-- <a class="btn btn-mini btn-info"
																						href="#modal-actualizar" role="button"
																						class="blue" data-toggle="modal" title="Editar">
																						<i class="icon-edit bigger-120"> </i>
																					</a>-->
																					<a href="eliminar_servicio_social2.htm?codigo=${n.id} " class="btn btn-mini btn-danger"
																						title="Eliminar">
																						<i class="icon-trash bigger-120"> Eliminar</i>
																					</a>
																				</div></td>
																		</tr>
																	</c:forEach>
																</tbody>
															</table>
														</c:otherwise>
													</c:choose>

												</div>
											</div>
										</div>
									</div>

									<hr>
									<div class="row-fluid wizard-actions">
										<button class="btn btn-prev"
											onClick="location.href = 'actualizar_ficha_antecedentes_Personales.htm' ">
											<i class="icon-arrow-left"></i> Anterior
										</button>
										<c:choose>
											<c:when test="${empty model.listafamilia}">
												<button
													onClick="location.href = 'ficha_vivienda_Familiar.htm'"
													disabled="disabled" class="btn btn-success btn-next"
													data-last="Finish">
													Siguiente <i class="icon-arrow-right icon-on-right"></i>
												</button>
											</c:when>
											<c:otherwise>
												<button
													onClick="location.href = 'buscarVista3aElegir.htm'"
													class="btn btn-success btn-next" data-last="Finish">
													Siguiente <i class="icon-arrow-right icon-on-right"></i>
												</button>
											</c:otherwise>
										</c:choose>



									</div>
								</div>
							</div>
							<!--/widget-main-->
						</div>
						<!--/widget-body-->
					</div>
				</div>

				<!-- MODAL AGREGAR -->
				<div id="modal-agregar" class="modal hide" tabindex="-1">
					<form method="post" id="formulario2" name="formulario2">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="blue bigger">Datos de Familiares - Registrar</h4> 
						</div>

						<div class="modal-body">
							<div class="row-fluid">
								<div class="vspace"></div>

								<div class="span7">
									<div class="form-horizontal">
										<div class="control-group">
											<label class="control-label" for="form-field-1">Dni</label>
											<div class="controls">
												<input type="text" name="txtdni"  id="txtdni" class="numeros" pattern=".{8,8}"
													title="ingrese un DNI valido max. 8 dígitos" placeholder="numero de dni">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="form-field-1">Nombres</label>
											<div class="controls">
												<input type="text" name="txtnombre" id="nombre"
													required="required" placeholder="nombre">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="form-field-1">Apellido
												Paterno</label>
											<div class="controls">
												<input type="text" name="txtapellidopaterno"
													required="required" id="apellidopaterno"
													placeholder="apellido paterno">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="form-field-1">Apellido
												Materno</label>
											<div class="controls">
												<input type="text" name="txtapellidomaterno"
													required="required" id="apellidomaterno"
													placeholder="apellido materno">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="edad">Fecha de
												nacimiento</label>
											<div class="controls">
												<input type="text" name="txtfechanac" id="edad"
													required="required" class="date-picker"
													placeholder="fecha de nacimiento"
													data-date-format="yyyy-mm-dd">
											</div>
										</div>
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
										<div class="control-group">
											<label class="control-label" for="">Estado Civil</label>
											<div class="controls">
												<select name="cboestadocivil" id="estadocivil">
													<option value="0">Soltero</option>
													<option value="1">Casado</option>
													<option value="2">Vuido</option>
													<option value="3">Divorciado</option>
												</select>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="">Grado de
												Instrucci&oacute;n</label>
											<div class="controls">
												<input type="text" name="txtgradoi" id="gradoi"
													required="required" placeholder="grado de instrucción">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="form-field-1">Lugar
												de Nacimiento</label>
											<div class="controls">
												<input type="text" name="txtlugarna" id="lugarna"
													required="required" placeholder="lugar de nacimiento">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="form-field-1">Ocupación</label>
											<div class="controls">
												<input type="text" name="txtocupacion" id="ocupacion"
													required="required" placeholder="ocupacion">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="form-field-1">Ingresos</label>
											<div class="controls">
												<input type="text" name="txtingreso" id="txtingreso"
													required="required" placeholder="ingrese la cantidad...">
											</div>
										</div>
										
										<div class="control-group" id="pregunta" >
											<label class="inline">¿Su familiar integra su nucleo familiar?
												&nbsp;&nbsp;&nbsp;&nbsp;												
											</label> <label class="inline"><input name="rtbintegra" type="radio" checked="checked" value="1"> <span
												class="lbl"> SI</span> &nbsp;&nbsp;&nbsp; <input name="rtbintegra" type="radio" value="0">
												<span class="lbl"> NO</span>
											</label>
										</div>
										
										<div class="control-group"  id="falle">
											<label class="control-label" for="form-field-1">Observaciones</label>
											<div class="controls">
												<textarea rows="5" data-maxlength="500" required="required" name="txtobservaciones" maxlength="500"
												placeholder="detallar alguna observacion, por ejemplo si alguno de sus padres no viviera con usted"></textarea>
											</div>
										</div>


										<label
											style="margin-top: -10px; background: white; width: 160px; margin-left: 15px; padding-left: 5px; font-size: 18px; color: #638BC7;">Antecedentes
											Clínicos</label>

										<div class="control-group">
											<label class="inline">¿Su familiar es fallecido?
												&nbsp;&nbsp;&nbsp;&nbsp; <input name="rtbfallecido" type="radio"
												onclick="habilitafallecido()" value="1"> <span
												class="lbl"> SI</span> &nbsp;&nbsp;&nbsp;
											</label> <label class="inline"> <input name="rtbfallecido" id="falleNo"
												type="radio" title="HAGAclick"
												onclick="deshabilitafallecido()" checked="checked"
												value="0"> <span class="lbl"> NO</span>
											</label>
										</div>
										
										<div class="control-group"  id="falle">
											<label class="control-label" for="form-field-1">Fallecimiento</label>
											<div class="controls">
												<textarea rows="4" id="fallecimiento" data-maxlength="200" readonly="readonly"
													required="required" name="txtfallecimiento" maxlength="200"></textarea>
											</div>
										</div>
										
										<div class="control-group" id="pregunta" >
											<label class="inline">¿Sufre Enfermedad?
												&nbsp;&nbsp;&nbsp;&nbsp;
												<input name="rtbsano" type="radio"
												onclick="habilitaenfermedad()" value="1"> <span
												class="lbl"> SI</span> &nbsp;&nbsp;&nbsp;
											</label> <label class="inline"> <input name="rtbsano" id="enferNo"
												type="radio" title="HAGAclick"
												onclick="deshabilitaenfermedad()" checked="checked"
												value="0"> <span class="lbl"> NO</span>
											</label>
										</div>												

										<div class="control-group"  id="enfer">
											<label class="control-label" for="form-field-1">Enfermedades</label>
											<div class="controls">
												<textarea rows="4" id="enfermedad" data-maxlength="200" readonly="readonly"
													required="required" name="txtenfermedad" maxlength="200"></textarea>
											</div>
										</div>
										
										
										


									</div>
								</div>
							</div>
						</div>

						<div class="modal-footer">
							<button class="btn btn-small" data-dismiss="modal">
								<i class="icon-remove"></i> Cancelar
							</button>

							<button type=submit class="btn btn-small btn-primary"
								id="btnagregar" value="Guardar">
								<i class="icon-ok"></i>Guardar
							</button>
						</div>
					</form>

				</div>

				<!-- FIN DE MODAL AGREGAR -->

				<!-- MODAL ACTUALIZAR -->

				<div id="modal-actualizar" class="modal hide" tabindex="-1">
					<form method="post">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="blue bigger">Datos de Familiares - Actualizar</h4>
						</div>

						<div class="modal-body">
							<div class="row-fluid">
								<div class="vspace"></div>

								<div class="span7">
									<div class="form-horizontal">
										<div class="control-group">
											<label class="control-label" for="form-field-1">Dni</label>
											<div class="controls">
												<input type="text" name="txtdni" class="numeros"
													required="required" placeholder="numero de dni">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="form-field-1">Nombres</label>
											<div class="controls">
												<input type="text" name="txtnombre" id="nombre" value=""
													required="required" placeholder="nombre">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="form-field-1">Apellido
												Paterno</label>
											<div class="controls">
												<input type="text" name="txtapellidopaterno"
													required="required" id="apellidopaterno"
													placeholder="apellido paterno">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="form-field-1">Apellido
												Materno</label>
											<div class="controls">
												<input type="text" name="txtapellidomaterno"
													required="required" id="apellidomaterno"
													placeholder="apellido materno">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="edad">Fecha de
												nacimiento</label>
											<div class="controls">
												<input type="text" name="txtfechanac" id="edad"
													required="required" class="date-picker"
													placeholder="fecha de nacimiento"
													data-date-format="yyyy-mm-dd">
											</div>
										</div>
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
										<div class="control-group">
											<label class="control-label" for="">Estado Civil</label>
											<div class="controls">
												<select name="cboestadocivil" id="estadocivil">
													<option value="0">Soltero</option>
													<option value="1">Casado</option>
													<option value="2">Vuido</option>
													<option value="3">Divorciado</option>
												</select>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="">Grado de
												Instrucci&oacute;n</label>
											<div class="controls">
												<input type="text" name="txtgradoi" id="gradoi"
													required="required" placeholder="grado de instrucción">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="form-field-1">Lugar
												de Nacimiento</label>
											<div class="controls">
												<input type="text" name="txtlugarna" id="lugarna"
													required="required" placeholder="lugar de nacimiento">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="form-field-1">Ocupación</label>
											<div class="controls">
												<input type="text" name="txtocupacion" id="ocupacion"
													required="required" placeholder="ocupacion">
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="form-field-1">Ingresos</label>
											<div class="controls">
												<input  type="email" name="txtingreso"  
													required="required" placeholder="ingrese la cantidad...">
											</div>
										</div>

										<label
											style="margin-top: -10px; background: white; width: 160px; margin-left: 15px; padding-left: 5px; font-size: 18px; color: #638BC7;">Antecedentes
											Clínicos</label>

										<div class="control-group">
											<label class="inline">¿Su familiar es fallecido?
												&nbsp;&nbsp;&nbsp;&nbsp; <input name="rtbsano" type="radio"
												onclick="habilitaenfermedad()" value="1"> <span
												class="lbl"> SI</span> &nbsp;&nbsp;&nbsp;
											</label> <label class="inline"> <input name="rtbsano"
												type="radio" title="HAGAclick"
												onclick="deshabilitaenfermedad()" checked="checked"
												value="0"> <span class="lbl"> NO</span>
											</label>
										</div>


										<div class="control-group">
											<label class="control-label" for="form-field-1">Enfermedades</label>
											<div class="controls">
												<textarea id="enfermedad" data-maxlength="50"
													required="required" name="txtenfermedad" maxlength="50"></textarea>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="form-field-1">Fallecimiento</label>
											<div class="controls">
												<textarea id="fallecimiento" data-maxlength="50"
													required="required" name="txtfallecimiento" maxlength="50"></textarea>
											</div>
										</div>


									</div>
								</div>
							</div>
						</div>

						<div class="modal-footer">
							<button class="btn btn-small" data-dismiss="modal">
								<i class="icon-remove"></i> Cancelar
							</button>

							<button type=submit class="btn btn-small btn-primary"
								id="btnagregar" value="Guardar">
								<i class="icon-ok"></i>Guardar
							</button>
						</div>
					</form>

				</div>

				<!-- FIN DE MODAL ACTUALIZAR -->

			</div>
			<!--PAGE CONTENT ENDS-->
		</div>
		<!--/.span-->
	</div>
	<!--/.row-fluid-->
</div>

