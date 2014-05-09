<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="row-fluid">
	<div class="span12">
		<!--PAGE CONTENT BEGINS-->
		<div class="page-header">
			<h1>
				Historial Social <small> <i class="icon-double-angle-right"></i>
					Panel de Administración
				</small>
			</h1>
		</div>

		<div class="widget-main">

			<div class="row-fluid">
				<form method="post" >
				<div class="span4">					
						<div class="control-group">
							<label class="control-label" for="form-field-1">Ingrese	DNI: </label>
							<div class="controls">
								<input class="input-large" type="text" placeholder="ingresar"
									name="dni" id="ing_dni" ></input>
									<button type="submit" class="btn btn-success btn-mini pull-right ">
									<i class="icon-search" id="buscar" name="buscar"></i> Buscar
									</button>
							</div>
							
						</div>					
				</div>
				</form>
			</div>
		</div>
		
			<c:if test="${model.dniNoExiste}">	
			<!-- --------------- ALERTA: DNI NO EXISTE----------- -->
				<div class="alert alert-error">
					 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					
					<i class=" icon-ban-circle "></i> El DNI ingresado NO Existe en nuestra Base de Datos.
				</div>	
			<!-- ------------- FIN ALERTA ------------- -->			
			</c:if>
			
			<c:if test="${model.fichaNoExiste}">	
			<!-- --------------- ALERTA: FICHA SOCIAL NO EXISTE----------- -->
				<div class="alert alert-error">
					 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					
					<i class=" icon-ban-circle "></i> La Persona aun no ha COMPLETADO su Ficha Social.
				</div>	
			<!-- ------------- FIN ALERTA ------------- -->			
			</c:if>
		
			
		<c:if test="${model.buscar}">
		<div class="row-fluid">
			<div class="span11">
				<div class="widget-box transparent invoice-box">
					<div class="widget-header widget-header-large">
						<h3 class="grey lighter pull-left position-relative">
							<i class="icon-folder-close green"></i>FICHA SOCIAL # <c:out value="${model.economica[0]}"/>
						</h3>

						<div class="widget-toolbar no-border invoice-info">							
							<span class=""><c:out value="${model.economica[19]}"/></span> <br /> 
							<span class="invoice-info-label">Registrado:</span> 
							<span class="blue">03/03/2013</span>
						</div>

						<div class="widget-toolbar hidden-480 ">
							<a href="#"> <i class="icon-print bigger-230"></i>
							</a>
						</div>
					</div>					
				</div>
				<div class="space-6"></div>
			</div>
		</div>
		<!------------------#INFORMACION PERSONAL------------------------------------------>
		<div class="row-fluid">
			<div class="span12">
				<div class="widget-box transparent invoice-box">
					<div class="widget-header widget-header-large">
						<h4 class="header smaller  blue"><i class="icon-check bigger-110"></i>Información Personal</h4>

						<div class="widget-toolbar no-border invoice-info">
							<span class="invoice-info-label">Categoria:</span> 						
							<span id="categoria" class="red"></span> <br /> 							
						</div>

						<div class="widget-toolbar hidden-480 ">
							<a href="#Asistenta" data-toggle="modal" ><button class=" btn btn-primary "><i class="icon-pencil bigger-125"></i>Cambiar Categoria</button></a>							
						</div>
					</div>					
				</div>
				<div class="space-10"></div>
			</div>
		</div>
				
		<!-- ------------------------------------------------------------------------------------->
		<div class="row-fluid">

			<div class="span1"></div>
			<div class="span11">

				<div id="user-profile-1" class="user-profile row-fluid">

					<div id="example" class="tabbable">
						<ul class="nav nav-tabs padding-18">
							<li class="active"><a data-toggle="tab"
								href="#datosPersonales"> <i
									class="green icon-user bigger-120"></i>Datos Personales
							</a></li>

							<li><a data-toggle="tab" href="#ubigeo"> <i
									class="orange icon-globe"></i>Ubigeo
							</a></li>

							<li><a data-toggle="tab" href="#contacto"> <i
									class="red icon-group"></i>Contacto
							</a></li>

							<li><a data-toggle="tab" href="#ubicacion"> <i
									class="green icon-user bigger-120"></i>Ubicacion
							</a></li>
						</ul>

						<div class="tab-content no-border padding-24">

							<!---------------------------#datos personales ---------------------------------->
							<div id="datosPersonales" class="tab-pane in active">
								<div class="row-fluid">

									<div class="span3 center">
										<div class="space-12"></div>
										<span class="profile-picture"> <img alt="Alex's Avatar"
											id="avatar2" src="../assets/avatars/profile-pic.jpg" />
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
									<!--/span-->

									<div class="span8">

										<div class="space-12"></div>
										<div class="profile-user-info profile-user-info-striped">

											<div class="profile-info-row">
												<div class="profile-info-name">Nombres:</div>
												<div class="profile-info-value">
													<span id="dato"><c:out value="${model.persona[8]}"></c:out></span>
												</div>
											</div>

											<div class="profile-info-row">
												<div class="profile-info-name">Apellido Paterno:</div>
												<div class="profile-info-value">
													<span id="dato"><c:out value="${model.persona[9]}"></c:out></span>
												</div>
											</div>

											<div class="profile-info-row">
												<div class="profile-info-name">Apellido Materno:</div>
												<div class="profile-info-value">
													<span id="dato"><c:out value="${model.persona[10]}"></c:out></span>
												</div>
											</div>

											<div class="profile-info-row">
												<div class="profile-info-name">Sexo:</div>
												<div class="profile-info-value">
													<span id="sexo">Masculino</span>
												</div>
											</div>

											<div class="profile-info-row">
												<div class="profile-info-name">Estado Civil:</div>
												<div class="profile-info-value">
													<span id="estadoCivil">soltero</span>
												</div>
											</div>

											<div class="profile-info-row">
												<div class="profile-info-name">Fecha Nac. :</div>
												<div class="profile-info-value">
													<fmt:formatDate value="${model.persona[13]}"
														var="dateString" pattern="dd/MM/yyyy" />
													<span id="fechaNacimiento"><c:out value="${dateString}"></c:out></span>
												</div>
											</div>

											<div class="profile-info-row">
												<div class="profile-info-name">Edad:</div>
												<div class="profile-info-value">
													<span id="idedad">18</span>
												</div>
											</div>

											<div class="profile-info-row">
												<div class="profile-info-name">Escuela:</div>
												<div class="profile-info-value">
													<span id="dato"> <c:out value="${model.persona[15]}"></c:out>
													</span>
												</div>
											</div>

										</div>
										<div class="hr hr-8 dotted"></div>
									</div>

								</div>
							</div>
							<!---------------------------#fin datos personales ---------------------------------->


							<!------------------------------------#ubigeo---------------------------------------------->

							<div id="ubigeo" class="tab-pane">
								<!---------------------Lugar nacimiento --------------------->
								<h3 class="header smaller lighter blue">
									<font size="2"><b>Lugar de Nacimiento</b></font>
								</h3>

								<div class="space-12"></div>
								<div class="profile-user-info profile-user-info-striped">
									<div class="profile-info-row">
										<div class="profile-info-name">Ubicacion:</div>
										<div class="profile-info-value">
											<i class="icon-map-marker light-orange bigger-110"> </i> 
											<span id="departamentoN"><c:out	value="${model.persona[29]}"></c:out></span> 
											<span id="provinciaN"><c:out value="${model.persona[30]}"></c:out></span> 
											<span id="distritoN"><c:out	value="${model.persona[31]}"></c:out></span>
										</div>
									</div>
								</div>
								<div class="hr hr-8 dotted"></div>
								<!---------------------fin Lugar nacimiento --------------------->

								<!--------------------- Lugar Procedencia --------------------->
								<h3 class="header smaller lighter blue">
									<font size="2"><b>Lugar de Procedencia</b></font>
								</h3>

								<div class="space-12"></div>
								<div class="profile-user-info profile-user-info-striped">
									<div class="profile-info-row">
										<div class="profile-info-name">Ubicacion:</div>
										<div class="profile-info-value">
											<i class="icon-map-marker light-orange bigger-110"></i> 
											<span id="departamentoP"><c:out	value="${model.persona[36]}"></c:out></span> 
											<span id="provinciaP"><c:out value="${model.persona[37]}"></c:out></span> 
											<span id="distritoP"><c:out	value="${model.persona[38]}"></c:out></span>
										</div>
									</div>
								</div>
								<div class="hr hr-8 dotted"></div>
								<!---------------------fin Lugar Procedencia --------------------->


								<!--------------------- Domicilio Actual --------------------->
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
								</div>
								<div class="hr hr-8 dotted"></div>
								<!---------------------fin Domicilio Actual --------------------->
							</div>
							<!------------------------------------#ubigeo---------------------------------------------->


							<!------------------------------------#contacto---------------------------------------------->
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
												<span id="dato"> <c:out value="${model.persona[22]}"></c:out></span>
											</div>
										</div>

										<div class="profile-info-row">
											<div class="profile-info-name">E-mail:</div>
											<div class="profile-info-value">
												<span id="dato"> <c:out value="${model.persona[23]}"></c:out></span>
											</div>
										</div>

									</div>
									<div class="hr hr-8 dotted"></div>
								</div>
							</div>
							<!------------------------------------#fin contacto---------------------------------------------->


							<!------------------------------------#ubicacion-------------------------------------------------->
							<div id="ubicacion" class="tab-pane ">


								<div class="span8">

									<div class="space-12"></div>
									<div class="profile-user-info profile-user-info-striped">


									</div>
									<div class="hr hr-8 dotted"></div>
								</div>
							</div>
							<!------------------------------------#fin ubicacion---------------------------------------------->

						</div>

					</div>
				</div>
			</div>

		</div>
		
		
		<!--------------#INFORMACION FICHA SOCIAL---------------------------------------------------------------- -->
		<h4 class="header smaller  blue">
			<i class="icon-check bigger-110"></i>Ficha Social
		</h4>
		<!-- ---------------------------------------------------------------------------- -->
		<div class="row-fluid">

			<div class="span1"></div>
			<div class="span11">

				<div id="user-profile-1" class="user-profile row-fluid">

					<div class="tabbable">
						<ul class="nav nav-tabs padding-18">
							<li class="active"><a data-toggle="tab" href="#clinico">
									<i class="green icon-user bigger-120"></i>Clinico
							</a></li>

							<li><a data-toggle="tab" href="#grupofamiliar"> <i
									class="orange icon-globe"></i> Grupo Familiar
							</a></li>

							<li><a data-toggle="tab" href="#vivienda"> <i
									class=" red icon-group"></i> Vivienda
							</a></li>

							<li><a data-toggle="tab" href="#situacioneconomica"> <i
									class="green icon-user bigger-120"></i>Situacion Economica
							</a></li>

							<li><a data-toggle="tab" href="#antecedentesescolares">
									<i class="green icon-user bigger-120"></i>Antecedentes
									Escolares
							</a></li>

							<li><a data-toggle="tab" href="#salud"> <i
									class="green icon-user bigger-120"></i>Salud y Alimentacion
							</a></li>

							<li><a data-toggle="tab" href="#recreacion"> <i
									class="green icon-user bigger-120"></i>Recreacion
							</a></li>

						</ul>

						<div class="tab-content no-border padding-24">
							<div id="clinico" class="tab-pane in active">
								<div class="row-fluid">

									<!--/span-->

									<!--------------------------- datos personales ---------------------------------->

									<div class="span8">

										<div class="space-12"></div>
										<div class="profile-user-info profile-user-info-striped">



											<div class="profile-info-row">
												<div class="profile-info-name">Enfermedad(es) :</div>
												<div class="profile-info-value">
													<span id="dato"><c:out value="${model.clinico[2]}"></c:out></span>
												</div>
											</div>


											<div class="profile-info-row">
												<div class="profile-info-name">Operacion(es) :</div>
												<div class="profile-info-value">
													<span id="dato"><c:out value="${model.clinico[3]}"></c:out></span>
												</div>
											</div>

											<div class="profile-info-row">
												<div class="profile-info-name">Inmunizacion(es) :</div>
												<div class="profile-info-value">
													<span id="dato"><c:out value="${model.clinico[4]}"></c:out></span>
												</div>
											</div>

											<div class="profile-info-row">
												<div class="profile-info-name">Accidente(s) :</div>
												<div class="profile-info-value">
													<span id="dato"><c:out value="${model.clinico[5]}"></c:out></span>
												</div>
											</div>

											<div class="profile-info-row">
												<div class="profile-info-name">Alergia(s) :</div>
												<div class="profile-info-value">
													<span id="dato"><c:out value="${model.clinico[6]}"></c:out></span>
												</div>
											</div>

											<div class="profile-info-row">
												<div class="profile-info-name">Lentes :</div>
												<div class="profile-info-value">
													<span id="dato"><c:out value="${model.clinico[7]}"></c:out></span>
												</div>
											</div>

										</div>
										<!------------------ fin de datos ----------------->


										<div class="hr hr-8 dotted"></div>


									</div>
									<!--/span-->
								</div>
								<!--/row-fluid-->

								<div class="space-12"></div>

							</div>

							<!------------------------------------#grupo familiar-------------------------------------------->
							<div id="grupofamiliar" class="tab-pane">
								<h3 class="header smaller lighter blue">
									<font size="2"><b>Grupo Familiar</b></font>
								</h3>

								<div class="space-12"></div>
								<table id="sample-table-2"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th class="center">N°</th>
											<th class="center">DNI</th>
											<th class="hidden-480">Nombre y Apellidos</th>
											<th>Parentesco</th>
											<th>Lugar de Nacimiento</th>
											<th class="hidden-480">Edad</th>
											<th class="hidden-480">Estado Civil</th>
											<th class="hidden-480">Grado de Instruccion</th>
											<th class="hidden-480">Ocupacion</th>
											<th class="hidden-480">Ingresos</th>
										</tr>
									</thead>

									<tbody>									
									<c:forEach var="familiar" items="${model.grupofamiliar}" varStatus="contador">
										<tr>
											<td class="center">
												<label><span class="lbl">${contador.count}</span></label>
											</td>	
											<td class="center"><c:out value="${familiar[0]}" /></td>
											<td class="hidden-480"><c:out value="${familiar[1]}" /></td>
											<td class="center"><c:out value="${familiar[2]}" /></td>
											<td class="center"><c:out value="${familiar[3]}" /></td>
											<td class="center"><c:out value="${familiar[4]}" /></td> 
											<td class="center"><c:out value="${familiar[5]}" /></td> 
											<td class="center"><c:out value="${familiar[6]}" /></td> 
											<td class="center"><c:out value="${familiar[7]}" /></td> 
											<td class="center"><c:out value="${familiar[8]}" /></td> 
										</tr>
									</c:forEach>
									</tbody>
								</table>
							</div>
							<!------------------------------------#fin grupo familiar---------------------------------------->

							<!------------------------------------#vivienda-------------------------------------------------->
							<div id="vivienda" class="tab-pane">
								<!---------------vivienda familiar--------------------------------->
								<h3 class="header smaller lighter blue">
									<font size="2"><b>Vivienda: Familiar</b></font>
								</h3>

								<div class="space-12"></div>
								<div class="profile-user-info profile-user-info-striped">

									<div class="profile-info-row">
										<div class="profile-info-name">Ubicacion :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.vivienda[0][3]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Material de Construccion
											:</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.vivienda[0][4]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Tenencia :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.vivienda[0][5]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Tipo :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.vivienda[0][6]}"></c:out></span>
										</div>
									</div>
									
									<div class="profile-info-row">
										<div class="profile-info-name">Agua Potable :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.vivienda[0][7]}"></c:out></span>
										</div>
									</div>									

									<div class="profile-info-row">
										<div class="profile-info-name">Servicio Higenico :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.vivienda[0][8]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Iluminacion :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.vivienda[0][9]}"></c:out></span>
										</div>
									</div>

								</div>
								<div class="hr hr-8 dotted"></div>
								<!---------------fin vivienda familiar--------------------------------->

								<!---------------vivienda del alumno--------------------------------->
								<h3 class="header smaller lighter blue">
									<font size="2"><b>Vivienda: Del Alumno</b></font>
								</h3>

								<div class="space-12"></div>
								<div class="profile-user-info profile-user-info-striped">

									<div class="profile-info-row">
										<div class="profile-info-name">Ubicacion :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.vivienda[1][3]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Material de Construccion
											:</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.vivienda[1][4]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Tenencia :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.vivienda[1][5]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Tipo :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.vivienda[1][6]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Agua Potable :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.vivienda[1][7]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-row">
											<div class="profile-info-name">Servicios Higenicos :</div>
											<div class="profile-info-value">
												<span id="dato"><c:out value="${model.vivienda[1][8]}"></c:out></span>
											</div>
										</div>

										<div class="profile-info-row">
											<div class="profile-info-name">Iluminacion :</div>
											<div class="profile-info-value">
												<span id="dato"><c:out value="${model.vivienda[1][9]}"></c:out></span>
											</div>
										</div>

									</div>
								</div>
								<div class="hr hr-8 dotted"></div>
								<!---------------fin vivienda del alumno--------------------------------->
							</div>
							<!------------------------------------#fin vivienda---------------------------------------------->


							<!------------------------------------#situacion economica--------------------------------------->
							<div id="situacioneconomica" class="tab-pane">

								<div class="space-12"></div>
								<div class="profile-user-info profile-user-info-striped">

									<div class="profile-info-row">
										<div class="profile-info-name">Ocupacion Laboral :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.economica[2]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Condicion :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.economica[3]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Dedicacion :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.economica[4]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Turno de Trabajo :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.economica[5]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Centro de Trab. :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.economica[6]}"></c:out></span>
										</div>
									</div>

								</div>

								<!----------table ingresos--------->
								<h3 class="header smaller lighter blue">
									<font size="2"><b>Ingresos</b></font>
								</h3>
								<table id="sample-table-2"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th class="center">N°</th>
											<th class="hidden-480">Descripcion</th>
											<th class="hidden-480">Ingresos</th>
										</tr>
									</thead>

									<tbody>
										<tr>
											<td class="center">1</td>
											<td class="center">DE PADRES</td>
											<td class="center"><c:out value="${model.economica[7]}"></c:out></td>
										</tr>
										<tr>
											<td class="center">2</td>
											<td class="center">DE ABUELOS</td>
											<td class="center"><c:out value="${model.economica[8]}"></c:out></td>
										</tr>
										<tr>
											<td class="center">3</td>
											<td class="center">POR SU TRABAJO</td>
											<td class="center"><c:out value="${model.economica[9]}"></c:out></td>
										</tr>
										<tr>
											<td class="center">4</td>
											<td class="center">DE OTROS PARIENTES</td>
											<td class="center"><c:out value="${model.economica[10]}"></c:out></td>
										</tr>
										<tr>
											<td class="center">5</td>
											<td class="center">POR PENSION JUDICIAL</td>
											<td class="center"><c:out value="${model.economica[11]}"></c:out></td>
										</tr>
									</tbody>
								</table>
								<div class="row-fluid">
									<div class="span5 pull-right">
										<h4 class="pull-center">
											Total de Ingresos : <span id="sum_ingresos" class="red">S/. 395.00</span>
										</h4>
									</div>
								</div>
								<!----------fin table ingresos--------->

								<!----------table Egresos--------->
								<h3 class="header smaller lighter blue">
									<font size="2"><b>Egresos</b></font>
								</h3>
								<table id="sample-table-2"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th class="center">N°</th>
											<th class="hidden-480">Tipo</th>
											<th class="hidden-480">Egresos</th>
										</tr>
									</thead>

									<tbody>
										<tr>
											<td class="center">1</td>
											<td class="center">PENSION UNIVERSITARIA</td>
											<td class="center"><c:out value="${model.economica[12]}"></c:out></td>
										</tr>
										<tr>
											<td class="center">2</td>
											<td class="center">ALIMENTACION</td>
											<td class="center"><c:out value="${model.economica[13]}"></c:out></td>
										</tr>
										<tr>
											<td class="center">3</td>
											<td class="center">HABITACION</td>
											<td class="center"><c:out value="${model.economica[14]}"></c:out></td>
										</tr>
										<tr>
											<td class="center">4</td>
											<td class="center">VESTIMENTA</td>
											<td class="center"><c:out value="${model.economica[15]}"></c:out></td>
										</tr>
										<tr>
											<td class="center">5</td>
											<td class="center">MOVILIDAD</td>
											<td class="center"><c:out value="${model.economica[16]}"></c:out></td>
										</tr>
										<tr>
											<td class="center">6</td>
											<td class="center">UTILES</td>
											<td class="center"><c:out value="${model.economica[17]}"></c:out></td>
										</tr>
									</tbody>
								</table>
								<div class="row-fluid">
									<div class="span5 pull-right">
										<h4 class="pull-center">
											Total de Egresos : <span id="sum_egresos" class="red">S/. 395.00</span>
										</h4>
									</div>
								</div>
								<!----------fin table Egresos--------->

							</div>
							<!------------------------------------#fin situacion economica---------------------------------------------->


							<!------------------------------------#antecedentes escolares-------------------------------------------------->
							<div id="antecedentesescolares" class="tab-pane">

								<div class="space-12"></div>
								<div class="profile-user-info profile-user-info-striped">

									<div class="profile-info-row">
										<div class="profile-info-name">Tipo de C.E. :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.antescolares[1]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Turno :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.antescolares[2]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Especialidad :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.antescolares[3]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Nombre Colegio donde
											Concluyo :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.antescolares[4]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Numero de veces que
											postulo a la Universidad :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.antescolares[5]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">Forma que ingreso a la
											universidad :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.antescolares[6]}"></c:out></span>
										</div>
									</div>

								</div>
							</div>
							<!------------------------------------#fin antecedentes escolares---------------------------------------------->


							<!------------------------------------#salud y alimentacion---------------------------------------------------->
							<div id="salud" class="tab-pane">
								<h3 class="header smaller lighter blue">
									<font size="2"><b>Salud</b></font>
								</h3>

								<div class="profile-user-info profile-user-info-striped">

									<div class="profile-info-row">
										<div class="profile-info-name">¿A quien acude ante una
											enfermedad? :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.antescolares[7]}"></c:out></span>
										</div>
									</div>

									<div class="profile-info-row">
										<div class="profile-info-name">¿Porque motivos?</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.antescolares[8]}"></c:out></span>
										</div>
									</div>

								</div>
								<!------------------------- Alimentacion----------------->
								<h3 class="header smaller lighter blue">
									<font size="2"><b>Alimentacion</b></font>
								</h3>

								<div class="profile-user-info profile-user-info-striped">

									<div class="profile-info-row">
										<div class="profile-info-name">Lugar donde toma sus
											alimentos :</div>
										<div class="profile-info-value">
											<span id="dato"><c:out value="${model.antescolares[9]}"></c:out></span>
										</div>
									</div>

								</div>
								<!------------------------- fin Alimentacion------------->
							</div>
							<!------------------------------------#fin salud y alimentacion------------------------------------------------>


							<!------------------------------------#recreacion------------------------------------------------------------>
							<div id="recreacion" class="tab-pane">
								<!------------------------- deportes --------------------->
								<div class="span3">
									<div class="widget-box pricing-box">
										<div class="widget-header header-color-blue">
											<h5 class="bigger lighter">Deportes</h5>
										</div>

										<div class="widget-body">
											<div class="widget-main">
												<ul class="unstyled spaced2">
												<c:forEach var="deporte" items="${model.deportes}" >
												<li><i class="icon-ok green"></i><c:out value="${deporte.deporte}" /></li>
										
												</c:forEach>
													
												</ul>
												<hr />
											</div>
										</div>
									</div>
								</div>
								<!------------------------- fin deportes --------------------->

								<!------------------------- aficiones ------------------------->
								<div class="span3">
									<div class="widget-box pricing-box">
										<div class="widget-header header-color-blue">
											<h5 class="bigger lighter">Aficiones</h5>
										</div>

										<div class="widget-body">
											<div class="widget-main">
												<ul class="unstyled spaced2">
													<c:forEach var="aficion" items="${model.aficiones}" >
												<li><i class="icon-ok green"></i><c:out value="${aficion.aficion}" /></li>
										
											</c:forEach>
												</ul>
												<hr />
											</div>
										</div>
									</div>
								</div>
								<!------------------------- fin aficiones ----------------------->
							</div>
							<!------------------------------------#fin recreacion-------------------------------------------------------->




						</div>
					</div>
				</div>
			</div>

		</div>


		<!------------------------#PROBLEMATICA ------------------------------------------->
		<h4 class="header smaller  blue">
			<i class="icon-check bigger-110"></i>Problematica
		</h4>

		<div class="widget-body">
			<div class="widget-main">
				<div id="comments" class="comments">
				<c:forEach var="problema" items="${model.problematica}" >
								<fmt:formatDate value="${problema[2]}"	var="dateProblematica"  pattern="dd/MM/yyyy hh:mm:ss"/>
					<div class="itemdiv commentdiv">
						<div class="user">
							<img alt="Bob Doe's Avatar" src="../assets/avatars/avatar.png" />
						</div>

						<div class="body">
							<div class="name"><a href="#"><c:out value="${problema[1]}" /></a></div>

							<div class="time">
								<i class="icon-time"></i> <span class="green"><c:out value="${dateProblematica}" /></span>
							</div>

							<div class="text">
								<i class="icon-quote-left"></i>
								<c:out value="${problema[0]}" />
							</div>
						</div>
					</div>
				</c:forEach>
				</div>
			</div>
			
			<form id="form_problematica">
			<div class="form-actions input-append">
				<input id="problematica_message" placeholder="Type your message here ..." type="text"
					class="width-75" name="message" />
				<button type="submit" class="btn btn-small btn-info no-radius">
					<i class="icon-share-alt"></i> <span class="hidden-phone">Send</span>
				</button>
			</div>
			<input type="hidden" name="idSocial" value="${model.economica[0]}"/>
			</form>			
		</div>
		<br/>
		<br/>
		<!------------------------#FIN PROBLEMATICA ------------------------------------------->


		<!------------------------#LISTA OBSERVACIONES------------------------------------------->
		<h4 class="header smaller  blue">
			<i class="icon-check bigger-110"></i>Lista de Observaciones
		</h4>
		<div class="row-fluid">
			<div class="span12">
				<div class="widget-box ">
					<div class="widget-header">
						<h4 class="lighter smaller">
							<i class="icon-comment blue"></i>Observaciones
						</h4>
					</div>

					<div class="widget-body">
						<div class="widget-main no-padding">
							<div id="dialogs" class="dialogs">
							<c:forEach var="observacion" items="${model.observaciones}" >
								<fmt:formatDate value="${observacion[2]}"	var="dateObservacion"  pattern="dd/MM/yyyy hh:mm:ss"/>
								
								<div class="itemdiv dialogdiv">
									<div class="user">
										<img alt="Alexa's Avatar" src="../assets/avatars/avatar1.png" />
									</div>

									<div class="body">
										<div class="time">
											<i class="icon-time"></i> <span class="green"><c:out value="${dateObservacion}" /></span>
										</div>

										<div class="name">
											<a href="#"><c:out value="${observacion[1]}" /></a>
										</div>
										<div class="text"><c:out value="${observacion[0]}" /></div>
										
									</div>
								</div>
										
							</c:forEach>								
							</div>

							<form  id="form_observacion">
							<div class="form-actions input-append">
								<input id="observacion_message" placeholder="Type your message here ..." type="text"
									class="width-75" name="message" />									
								<button type=submit class="btn btn-small btn-info no-radius">
									<i class="icon-share-alt"></i> <span class="hidden-phone">Send</span>
								</button>
							</div>
						
							<input type="hidden" name="idSocial" value="${model.economica[0]}"/>
							</form>
						</div>
						<!--/widget-main-->
					</div>
					<!--/widget-body-->
				</div>
				<!--/widget-box-->
			</div>
			<!--/span-->
		</div>
		<br/>
		<!------------------------#FIN LISTA OBSERVACIONES--------------------------------------->


		<!------------------------#PRESTACIONES ASISTENCIALES------------------------------------------->
		<div class="row-fluid">
			<h4 class="header smaller  blue">
				<i class="icon-check bigger-110"></i>Prestaciones Asistenciales
			</h4>
		</div>

		<div class="span8">
			<div class="widget-box">
				<div class="widget-header"></div>

				<div class="widget-body">
					<div class="widget-main no-padding">
						<form id="form_prestacion">
						<!--<legend>Form</legend>-->
						<div class="widget-body">
							<div class="widget-main">

								<div class="row-fluid">
									<label for="form-field-9">Problemática Social</label>
									<textarea id="prestacion_problematica" class="span12 limited" id="form-field-9" name="problematicaSocial"
										data-maxlength="50"></textarea>
								</div>								

								<div class="row-fluid">
									<label for="form-field-9">Resultado</label>
									<textarea id="prestacion_resultado" class="span12 limited" id="form-field-9" name="resultado"
										data-maxlength="50"></textarea>
								</div>

							</div>
						</div>

						<div class="form-actions center">
							<button type="submit" class="btn btn-small btn-success">
								Submit <i class="icon-arrow-right icon-on-right bigger-110"></i>
							</button>
						</div>
						<input type="hidden" name="idSocial" value="${model.economica[0]}"/>
						</form>
					</div>
				</div>
			</div>
			<div class="space-12"></div>
		</div>

		<table id="prestacion_table"
			class="table table-striped table-bordered table-hover">
			<thead>
				<tr>
					<th class="center">N°</th>
					<th class="center">Fecha</th>
					<th class="center hidden-480">Problema Social</th>
					<th class="center">Resultado</th>
					<th class="center">Atendido Por:</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="prestacion" items="${model.prestaciones}" varStatus="contador" >
				<fmt:formatDate value="${prestacion[0]}"	var="datePrestacion"  pattern="dd/MM/yyyy hh:mm:ss"/>
				<tr>
					<td class="center"><c:out value="${contador.count}"/></td>
					<td class="center">${datePrestacion}</td>
					<td class="center"><c:out value="${prestacion[1]}" /></td>
					<td class="center"><c:out value="${prestacion[2]}" /></td>
					<td class="center"><c:out value="${prestacion[3]}" /></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<!------------------------#FIN PRESTACIONES ASISTENCIALES--------------------------------------->
	</c:if>
	</div>

</div>


<!----------------------- MODAL CAMBIAR CATEGORIA  ---------------------------------------------------------->
<form id="form_categoria" class="form-horizontal" >

	<div id="Asistenta" class="modal hide fade" tabindex="-1" >
		<div class="modal-header header-color-sky blue">		
			<button type="button" class="close" data-dismiss="modal">×</button>			
			<h3 id="myModalLabel">Buscar Asistenta Social</h3>
		</div>

		<div class="modal-body">			
			<div class="control-group">
				<label class="control-label" for="form-field-1">Categoria:</label>
				<div class="controls">
					<select id="select_categoria" name="select_categoria">
						<option value="0" selected>SIN CATEGORIA</option>
						<option value="1">CATEGORIA A</option>
						<option value="2">CATEGORIA B</option>
						<option value="3">CATEGORIA C</option>						
					</select>
				</div>
			</div>
		</div>
		
		<div class="modal-body">			
			<div class="control-group">
				<label class="control-label" for="form-field-1">Motivo:</label>
				<div class="controls">
					<textarea id="categoria_motivo" rows="" cols="" name="categoria_motivo" required></textarea>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<input type="submit" class="btn btn-primary" value="Aceptar">			
		</div>

	</div>
	<input type="hidden" name="idSocial" value="${model.economica[0]}"/>
</form>







