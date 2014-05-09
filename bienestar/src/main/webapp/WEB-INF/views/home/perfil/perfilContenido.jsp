<%@ include file="/WEB-INF/views/include.jsp"%>


<div class="row-fluid">


	<div class="span11">

	

			<div class="page-header">
				<h1>
					Perfil <small> <i class="icon-double-angle-right"></i>
						Infomación del Perfil
					</small> <a href="../home/editarperfil.htm" title="Editar"
						class="btn btn-mini btn-success pull-right"
						style="font-size: 15px; margin-right: 5px"; margin-right: 5px">Editar
						<i class="icon-edit"></i>
					</a>
				</h1>
			</div>
				<!-- --------------- ALERTA ----------- -->

			<c:if test="${param.success==true}">
	
				<div class="alert alert-success">
					 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					
					<i class="icon-ok green"></i> !Bien Hecho <strong class="green">se
						guardaron los cambios</strong>
				</div>
				<!-- ------------- FIN ALERTA ------------- -->
			</c:if>





			<!-- ---------------------------------------------------------------------------- -->
			<div class="row-fluid">




				<div class="span1"></div>
				<div class="span11">

					<div id="user-profile-1" class="user-profile row-fluid">


						<div class="tabbable">
							<ul class="nav nav-tabs padding-18">
								<li class="active"><a data-toggle="tab"
									href="#datosPersonales"> <i
										class="green icon-user bigger-120"></i> Datos Personales
								</a></li>

								<li><a data-toggle="tab" href="#ubigeo"> <i
										class="orange icon-globe"></i> Ubigeo
								</a></li>

								<li><a data-toggle="tab" href="#contacto"> <i
										class=" red icon-group"></i> Contacto
								</a></li>

							</ul>

							<div class="tab-content no-border padding-24">
								<div id="datosPersonales" class="tab-pane in active">
									<div class="row-fluid">

										<div class="span3 center">
											<div class="space-12"></div>
											<span class="profile-picture"> <img
												alt="Alex's Avatar" id="avatar2"
												src="../assets/avatars/profile-pic.jpg" />
											</span>

											<div class="space space-4"></div>
											<div
												class="width-80 label label-info label-large arrowed-in arrowed-in-right">
												<div class="inline position-relative">
													<span class="white middle bigger-120">
													<c:out	value="${model.persona[6]}"></c:out> </span>
												</div>
											</div>

										</div>
										<!--/span-->


										<!--------------------------- datos personales ---------------------------------->

										<div class="span8">

											<div class="space-12"></div>
											<div class="profile-user-info profile-user-info-striped">


												<div class="profile-info-row">
													<div class="profile-info-name">Nombres:</div>
													<div class="profile-info-value">
														<span id="dato"><c:out	value="${model.persona[8]}"></c:out></span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name">Apellido Paterno:</div>
													<div class="profile-info-value">
														<span id="dato"><c:out	value="${model.persona[9]}"></c:out></span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name">Apellido Materno:</div>
													<div class="profile-info-value">
														<span id="dato"><c:out	value="${model.persona[10]}"></c:out></span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name">Sexo:</div>
													<div class="profile-info-value">
														<span id="sexo"> </span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name">Estado Civil:</div>
													<div class="profile-info-value">
														<span id="estadoCivil"></span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name">Fecha Nac:</div>													
													<div class="profile-info-value">
													<fmt:formatDate value="${model.persona[13]}" var="dateString" pattern="dd/MM/yyyy" />												
													<span id="fechaNacimiento">
													<c:out	value="${dateString}"></c:out></span>
											     </div>
												</div>
												
												<div class="profile-info-row">
													<div class="profile-info-name">Edad:</div>
													<div class="profile-info-value">
														<span id="idedad"></span>
													</div>
												</div>

												<div class="profile-info-row">
													<div class="profile-info-name">Escuela:</div>
													<div class="profile-info-value">
														<span id="dato"><c:out	value="${model.persona[15]}"></c:out></span>
													</div>
												</div>
												
												<div class="profile-info-row">
													<div class="profile-info-name">Dependencia:</div>
													<div class="profile-info-value">
														<span id="dato"><c:out	value="${model.persona[16]}"></c:out></span>
													</div>
												</div>
											</div>
											<!------------------ fin de datos ----------------->


											<div class="hr hr-8 dotted"></div>

										</div>
										<!--/span-->
									</div>
									<!--/row-fluid-->

									<div class="space-20"></div>
								</div>

								<!------------------------------------#ubigeo---------------------------------------------->
								<div id="ubigeo" class="tab-pane">
									<h3 class="header smaller lighter blue">
										<font size="2"><b>Lugar de Nacimiento</b></font>
									</h3>

									<div class="space-12"></div>
									<div class="profile-user-info profile-user-info-striped">

										<div class="profile-info-row">
											<div class="profile-info-name">Ubicacion:</div>
											<div class="profile-info-value">
												<i class="icon-map-marker light-orange bigger-110"> </i> 
												<span id="departamentoN"><c:out value="${model.persona[29]}"></c:out></span>
												<span id="provinciaN"><c:out value="${model.persona[30]}"></c:out></span>
												<span id="distritoN"><c:out	value="${model.persona[31]}"></c:out></span>
											</div>
										</div>
										
									</div>
									<div class="hr hr-8 dotted"></div>

									<!--/span-->

									<h3 class="header smaller lighter blue">
										<font size="2"><b>Lugar de Procedencia</b></font>
									</h3>

									<div class="space-12"></div>
									<div class="profile-user-info profile-user-info-striped">

										<div class="profile-info-row">
											<div class="profile-info-name">Ubicacion:</div>
											<div class="profile-info-value">
												<i class="icon-map-marker light-orange bigger-110"></i> 
												<span id="departamentoP"><c:out value="${model.persona[36]}"></c:out></span> 
												<span id="provinciaP"><c:out value="${model.persona[37]}"></c:out></span> 
												<span id="distritoP"><c:out	value="${model.persona[38]}"></c:out></span>
											</div>
										</div>
										
									</div>

									<div class="hr hr-8 dotted"></div>

									<!--/span-->


									<!--/span-->


									<h3 class="header smaller lighter blue">
										<font size="2"><b>Domicilio Actual</b></font>
									</h3>


									<div class="space-12"></div>
									<div class="profile-user-info profile-user-info-striped">

										<div class="profile-info-row">
											<div class="profile-info-name">Direccion:</div>
											<div class="profile-info-value">
												<span id="direccion"><c:out	value="${model.persona[19]}"></c:out></span>
											</div>
										</div>

										<div class="profile-info-row">
											<div class="profile-info-name">Ubicacion:</div>
											<div class="profile-info-value">
												<i class="icon-map-marker light-orange bigger-110"></i> 
												<span id="departamentoA"><c:out	value="${model.persona[43]}"></c:out></span> 
												<span id="provinciaA"><c:out value="${model.persona[44]}"></c:out></span> 
												<span id="distritoA"><c:out	value="${model.persona[45]}"></c:out></span>
											</div>
										</div>

										<!--/row-->


										<!---------------------------------/#contacto---------------------------------------------->


									</div>
									<!--/span-->
									<div class="hr hr-8 dotted"></div>

								</div>
								<!--/row-->


								<!--/#contacto-->


								<div id="contacto" class="tab-pane ">

									<div class="span8">

										<div class="space-12"></div>
										<div class="profile-user-info profile-user-info-striped">
										
											<div class="profile-info-row">
												<div class="profile-info-name">Telefono:</div>
												<div class="profile-info-value">
													<span id="dato"><c:out value="${model.persona[21]}"></c:out></span>
												</div>
											</div>

											<div class="profile-info-row">
												<div class="profile-info-name">Celular:</div>
												<div class="profile-info-value">
													<span id="dato"><c:out value="${model.persona[22]}"></c:out></span>
												</div>
											</div>

											<div class="profile-info-row">
												<div class="profile-info-name">E-mail:</div>
												<div class="profile-info-value">
													<span id="dato"><c:out value="${model.persona[23]}"></c:out></span>
												</div>
											</div>

										</div>

										<div class="hr hr-8 dotted"></div>


									</div>
									<!--/span-->

								</div>
								<!--/contacto-->

							</div>
						</div>
					</div>
				</div>

			</div>
		
	</div>