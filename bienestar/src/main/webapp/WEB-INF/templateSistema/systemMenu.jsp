<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="sidebar" id="sidebar">

	<ul class="nav nav-list">
		<!-- INICIO -->
		<li id="inicio"><a href="#" class="dropdown-toggle"> <i
				class="icon-home"></i> <span class="menu-text"> Inicio </span> <b
				class="arrow icon-angle-down"></b>
		</a>

			<ul class="submenu">
				<li id="inicio_bienvenida"><a href="../home/bienvenida.htm"><i
						class="icon-double-angle-right"></i> Bienvenida </a></li>
				<li id="inicio_perfil"><a href="../home/perfil.htm"><i
						class="icon-double-angle-right"></i> Perfil </a></li>
				<li id="inicio_configuracion"><a
					href="../home/configuracion.htm"><i
						class="icon-double-angle-right"></i> Configuración </a></li>
			</ul></li>

		<!-- ------------------- MENU GERENCIA DE RECURSOS----------------- -->
		<security:authorize access="hasAnyRole('ROLE_CONTROL_JEFE')">
			<li><a href="#" class="dropdown-toggle"> <i
					class="icon-bell"></i> <span class="menu-text"> Gerencia
						Recursos </span> <b class="arrow icon-angle-down"></b>
			</a>

				<ul class="submenu">

					<!-- PERSONAL ADMINISTRATIVO  -->


					<security:authorize access="hasAnyRole('ROLE_CONTROL_JEFE')">

						<li><a href="#" class="dropdown-toggle"> <i
								class="icon-double-angle-right"></i> Unidad Control <b
								class="arrow icon-angle-down"></b>
						</a>
							<ul class="submenu">

								<security:authorize access="isAuthenticated()">
									<li id="lifichac"><a href="../gerencia/ficha_cas.htm"><i
											class="icon-align-justify"></i> Ficha CAS </a></li>
								</security:authorize>

								<security:authorize access="isAuthenticated()">
									<li id="lifichac"><a href="../gerencia/ficha_admin.htm"><i
											class="icon-align-justify"></i> Ficha ADMIN </a></li>
									<li id="lifichac"><a href="../gerencia/ficha_admin.htm"><i
											class="icon-align-justify"></i> Ficha ADMIN </a></li>
								</security:authorize>

							</ul></li>


					</security:authorize>
				</ul></li>
		</security:authorize>
		<!-- -----------------------FIN MENU GERENCIA DE RECURSOS------------------------>


		<!-- -----------------------MENU BIENESTAR UNIVERSITARIO ------------------------>
		<security:authorize
			access="hasAnyRole('ROLE_BIENESTAR_JEFE','ROLE_BIENESTAR_ASISTENTA','ROLE_ALUMNO')">
			<li id="bienestar"><a href="#" class="dropdown-toggle"> <i
					class="icon-edit"></i> <span class="menu-text"> Bienestar
						Univ. </span> <b class="arrow icon-angle-down"></b>
			</a>

				<ul class="submenu">

					<!-- SERVICIO SOCIAL  -->
					<li id="bienestarSocial"><a href="#" class="dropdown-toggle">
							<i class="icon-double-angle-right"></i> Servicio Social <b
							class="arrow icon-angle-down"></b>
					</a>
						<ul class="submenu">
							<!-- ------------------------------------------------------ -->
							<security:authorize
								access="hasAnyRole('ROLE_BIENESTAR_JEFE','ROLE_BIENESTAR_ASISTENTA')">
								<li id="bienestar_fichaComedor"><a
									href="../bienestar/lista_comedor.htm"><i
										class="icon-align-justify"></i> Ficha Comedor </a></li>
							</security:authorize>
							<!-- ------------------------------------------------------ -->
							<security:authorize access="isAuthenticated()">
								<li id="bienestar_fichaSocial"><a
									href="../bienestar/buscar_paso.htm"><i
										class="icon-align-justify"></i> Ficha Servicio Social </a></li>
							</security:authorize>
							<!-- ------------------------------------------------------ -->
							<security:authorize access="hasAnyRole('ROLE_BIENESTAR_JEFE')">
								<li id="bienestar_controlSocial"><a
									href="../bienestar/control_social.htm"><i
										class="icon-align-justify"></i> Control Social </a></li>
							</security:authorize>
							<!-- ------------------------------------------------------ -->
							<security:authorize
								access="hasAnyRole('ROLE_BIENESTAR_JEFE','ROLE_BIENESTAR_ASISTENTA')">
								<li id="bienestar_historial"><a
									href="../bienestar/historiaSocial.htm"><i
										class="icon-align-justify"></i> Historial Social </a></li>
							</security:authorize>
							<!-- ------------------------------------------------------ -->
						</ul></li>

					<security:authorize access="hasAnyRole('ROLE_BIENESTAR_JEFE')">

						<!-------------------- SERVICIO MEDICO ----------------------------------------------->
						<!-- COMEDOR UNIVERSITARIO  -->
						<li id="serviciomedico"><a href="#" class="dropdown-toggle">
								<i class="icon-double-angle-right"></i> Servicio Medico <b
								class="arrow icon-angle-down"></b>
						</a>
							<ul class="submenu">
								<li id="servicioprueba"><a
									href="../bienestar/fichamedica2.htm"><i
										class="icon-align-justify"></i> Prueba </a></li>
								<li id="secretaria"><a
									href="../bienestar/servicioclinicosecretaria.htm"><i
										class="icon-align-justify"></i> Secretaria </a></li>
								<li id="laboratorio"><a
									href="../bienestar/servicioclinicolaboratorio.htm"><i
										class="icon-align-justify"></i> Laboratorio </a></li>
								<li id="topico"><a
									href="../bienestar/servicioclinicotopico.htm"><i
										class="icon-align-justify"></i> Tópico </a></li>
							</ul></li>
					</security:authorize>

					<security:authorize access="hasAnyRole('ROLE_BIENESTAR_JEFE')">
						<!-- DEPORTES  -->
						<li><a href="#"><i class="icon-double-angle-right"></i>
								Deportes </a></li>
					</security:authorize>

					<security:authorize access="hasAnyRole('ROLE_BIENESTAR_JEFE')">
						<!-- COMEDOR UNIVERSITARIO  -->
						<li id="bienestarComedor"><a href="#" class="dropdown-toggle">
								<i class="icon-double-angle-right"></i> Comedor UNT <b
								class="arrow icon-angle-down"></b>
						</a>
							<ul class="submenu">
								<li id="bienestar_verificarPadron"><a
									href="../bienestar/verificar_padron.htm"><i
										class="icon-align-justify"></i> Verificar Padron </a></li><li id="bienestar_registrarComensal"><a
							href="../bienestar/registrar_comensal.htm"><i
								class="icon-align-justify"></i> Registrar Comensal </a></li></ul>
					
		</security:authorize>

			
						<security:authorize access="hasAnyRole('ROLE_BIENESTAR_JEFE')">
						<!-- PSICOLOGIA  -->
						<li id="list11"><a href="#"><i
					class="icon-double-angle-right"></i> Psicologia </a></li>
					</security:authorize>

				</ul>
	</li>
		</security:authorize>
		<!-- -----------------------MENU BIENESTAR UNIVERSITARIO ------------------------>


		<!-- ----------------------- MENU ADMINISTRACION -------------------------------->
		<security:authorize access="hasAnyRole('ROLE_BIENESTAR_JEFE')">
			<li><a href="#" class="dropdown-toggle"> <i
				class="icon-wrench"></i> <span class="menu-text">
						Administracion </span> <b class="arrow icon-angle-down"></b>
			</a>
				<ul class="submenu">

					<!-- GESTION DE USUARIOS -->
					<security:authorize access="isAuthenticated()">

						<li><a href="#" class="dropdown-toggle"><i
							class="icon-double-angle-right"></i> Gestion Usuarios<b
							class="arrow icon-angle-down"></b> </a>
							<ul class="submenu">

								<security:authorize access="isAuthenticated()">
									<li><a href="../gerencia/ficha_cas.htm"><i
										class="icon-align-justify"></i> Crear Usuario</a></li>
								</security:authorize>

								<security:authorize access="isAuthenticated()">
									<li><a href="../gerencia/ficha_cas.htm"><i
										class="icon-align-justify"></i> Acciones Usuario</a></li>
								</security:authorize>

								<security:authorize access="isAuthenticated()">
									<li><a href="../gerencia/ficha_cas.htm"><i
										class="icon-align-justify"></i> Asignar Permisos</a></li>
								</security:authorize>

								<security:authorize access="isAuthenticated()">
									<li><a href="../gerencia/ficha_cas.htm"><i
										class="icon-align-justify"></i> Bloquear Usuario</a></li>
								</security:authorize>

							</ul></li>

					</security:authorize>
				</ul></li>
		</security:authorize>
		<!------------------------- FIN MENU ADMINISTRACION ------------------------>

	</ul>

	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left"></i>
	</div>
</div>