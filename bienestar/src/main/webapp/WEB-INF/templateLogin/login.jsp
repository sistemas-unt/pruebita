<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<security:authorize access="isAuthenticated()">
	<c:redirect url="/home/bienvenida.htm" />
</security:authorize>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>Login - UNT</title>

<meta name="description" content="User login page" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!--basic styles-->

<link href="<c:url value="/assets/css/bootstrap.min.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/assets/css/bootstrap-responsive.min.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/assets/css/font-awesome.min.css"/>"
	rel="stylesheet" />

<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

<!--page specific plugin styles-->

<!--fonts-->

<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

<!--ace styles-->

<link rel="stylesheet" href="<c:url value="/assets/css/ace.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/assets/css/ace-responsive.min.css"/>" />
<link rel="stylesheet"
	href="<c:url value="/assets/css/ace-skins.min.css"/>" />

<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

<!--inline styles related to this page-->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body class="login-layout" style="background: #FFF;">
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a href="#" class="brand"> <small> <i class="icon-book"></i>
						Sistema Integral Universitario
				</small>
				</a>
				<!--/.brand-->

				<!-- ---------------- VENTANAS EMERGENTES ---------------- -->


			</div>
			<!--/.container-fluid-->
		</div>
		<!--/.navbar-inner-->
	</div>
	<div class="main-container container-fluid">
		<div class="main-content">
			<div class="row-fluid">
				<div class="span12">
					<div class="login-container">
						<div class="row-fluid">
							<div class="center">
								<span> <br />
								</span>
								<!-- <h1>
									<span class="red"></span> <span class="blue">Bienestar
										Universitario</span>
								</h1> -->

								<c:if test="${not empty param.error}">
									<div class="alert alert-error">
										No se pudo INICIAR SESSION. <br />
										<fmt:message key="error.badCredentials" />
										<%-- 										<fmt:message --%>
										<%-- 											key="AbstractUserDetailsAuthenticationProvider.badCredentials" /> --%>
									</div>

								</c:if>

								<c:if test="${param.expired != null}">
									<div class="alert alert-error">La Sesi�n se ha cerrado a
										la fuerza debido a varias sesiones en la misma cuenta (s�lo se
										permite una sesi�n activa por usuario).</div>
								</c:if>

								<c:if test="${param.timeout != null}">
									<div class="alert alert-error">Tiempo de Sessi�n
										Terminado</div>
								</c:if>

							</div>

							<div class="space-6"></div>

							<div class="row-fluid">
								<div class="position-relative">
									<div id="login-box"
										class="login-box visible widget-box no-border">
										<div class="widget-body">
											<div class="widget-main">
												<h4 class="header blue lighter bigger">
													<i class="icon-coffee green"></i> Inicie Sesi&oacute;n
												</h4>

												<div class="space-6"></div>


												<fieldset>

													<form action="<c:url value='j_spring_security_check.htm'/>"
														method="POST">

														<label> <span
															class="block input-icon input-icon-right"> <input
																type="text" name="j_username" class="span12"
																placeholder="Usuario" /> <i class="icon-user"></i>
														</span>
														</label> <label> <span
															class="block input-icon input-icon-right"> <input
																type="password" name="j_password" class="span12"
																placeholder="Contrase�a" /> <i class="icon-lock"></i>
														</span>
														</label>

														<div class="space"></div>
														<div class="clearfix">
															<input type="submit"
																class="width-35 pull-right btn btn-small btn-primary"
																value="Ingresar" /> <i class="icon-key"></i>
														</div>
														<div class="space-4"></div>
													</form>
												</fieldset>
											</div>
											<!--/widget-main-->

											<div class="toolbar clearfix">
												<div>
													<a href="#" onclick="show_box('forgot-box'); return false;"
														class="forgot-password-link"> <i
														class="icon-arrow-left"></i> Olvidaste tu contrase�a?
													</a>
												</div>


											</div>
										</div>
										<!--/widget-body-->
									</div>
									<!--/login-box-->

									<div id="forgot-box" class="forgot-box widget-box no-border">
										<div class="widget-body">
											<div class="widget-main">
												<h4 class="header red lighter bigger">
													<i class="icon-key"></i> Recuperar Contrase�a
												</h4>

												<div class="space-6"></div>
												<p>Ingrese su correo para recibir instrucciones</p>

												<form>
													<fieldset>
														<label> <span
															class="block input-icon input-icon-right"> <input
																type="email" class="span12" placeholder="Email" /> <i
																class="icon-envelope"></i>
														</span>
														</label>

														<div class="clearfix">
															<button onclick="return false;"
																class="width-35 pull-right btn btn-small btn-danger">
																<i class="icon-lightbulb"></i> Enviar
															</button>
														</div>
													</fieldset>
												</form>
											</div>
											<!--/widget-main-->

											<div class="toolbar center">
												<a href="#" onclick="show_box('login-box'); return false;"
													class="back-to-login-link"> Regresar <i
													class="icon-arrow-right"></i>
												</a>
											</div>
										</div>
										<!--/widget-body-->
									</div>
									<!--/forgot-box-->

									<!--/signup-box-->
								</div>
								<!--/position-relative-->
							</div>
						</div>
					</div>
					<!--/.span-->
				</div>
				<!--/.row-fluid-->
			</div>
		</div>
	</div>
	<!--/.main-container-->

	<!--basic scripts-->

	<!--[if !IE]>-->

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

	<!--<![endif]-->

	<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

	<!--[if !IE]>-->

	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"/script>");
	</script>

	<!--<![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script src="assets/js/bootstrap.min.js"></script>

	<!--page specific plugin scripts-->

	<!--ace scripts-->

	<script src="assets/js/ace-elements.min.js"></script>
	<script src="assets/js/ace.min.js"></script>

	<!--inline scripts related to this page-->

	<script type="text/javascript">
		function show_box(id) {
			$('.widget-box.visible').removeClass('visible');
			$('#' + id).addClass('visible');
		}
	</script>
</body>
</html>
