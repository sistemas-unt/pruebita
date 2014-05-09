
<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="row-fluid">
	<div class="span10">
		<div class="page-header">
			<h1>
				Configuraci�n de Cuenta <small> <i
					class="icon-double-angle-right"></i> Infomaci�n del Perfil
				</small>
			</h1>
		</div>
		
			<!-- --------------- ALERTA ----------- -->
			<c:if test="${not empty param.success}">	
				<div class="alert alert-success">
					 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					
					<i class="icon-ok green"></i> �La Operacion se realizo correctamente! <strong class="green">Se
						guardaron los cambios.</strong>
				</div>				
			</c:if>
			<!-- ------------- FIN ALERTA ------------- -->
			
			<!-- --------------- ALERTA ----------- -->
			<c:if test="${not empty param.error}">	
				<div class="alert alert-error">
					 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					
					<i class=" icon-ban-circle "></i> �Los Datos Ingresados son Incorrectos!. <strong class="red">No se
						guardaron los cambios.</strong>
				</div>				
			</c:if>
			<!-- ------------- FIN ALERTA ------------- -->

		<div class="row-fluid">
			<div class="span8">
				<div class="page-content">

					<div class="page-header position-relative">
						<h5>
							Correo electr�nico <a href="#editarcorreo" class="pull-right"
								data-toggle="modal" title="Editar Correo"><i
								class="icon-edit "></i> Editar</a>
						</h5>

					</div>
					<!--/.page-header-->


					<div class="page-header position-relative">
						<h5>
							Cambiar Contrase�a <a href="#editarcontrase�a" class="pull-right"
								data-toggle="modal" title="Editar Contrase�a"><i
								class="icon-edit "></i> Editar</a>
						</h5>
					</div>
					<!--/.page-header-->


				</div>



			</div>
			<!--/row-->

		</div>
		<!--/.span-->
	</div>
</div>
<!--/.span-->


<!-- Modal -->
<div id="editarcontrase�a" class="modal hide fade" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">�</button>
		<h3 id="myModalLabel">Cambiar Contrase�a</h3>
	</div>
	<form class="form-horizontal" method="POST" action="<c:url value='cambiar_password.htm'/>" onSubmit="return validar()">
	<div class="modal-body">
		
			<div class="control-group">
				<label class="control-label" for="form-field-1">Contrase�a
					Actual</label>

				<div class="controls">
					<input type="password" id="form-field-1" name="passwordActual" placeholder="Contrase�a Actual" required>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="form-field-1">Nueva
					Contrase�a</label>

				<div class="controls">
					<input type="password" id="nuevaPassword" name="nuevaPassword" placeholder="Nueva Contrase�a" required>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="form-field-1">Confirmar
					Contrase�a</label>

				<div class="controls">
					<input type="password" id="confPassword" placeholder="Confirmar Contrase�a" required>
				</div>
			</div>
	</div>
	<div class="modal-footer">

		<input class="btn btn-primary"  type="submit" value="Aceptar">
		<button class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
	</div>
	</form>
</div>

<!-- ----------------Cambiar Correo Electronico---------------->

<div id="editarcorreo" class="modal hide fade" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<form method="POST">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">�</button>
			<h3 id="myModalLabel">Cambiar Correo Electr�nico</h3>

		</div>

		<div class="modal-body">


			<!-- Email -->
			<div class="control-group">
				<label class="control-label" for="">Email-Actual</label>

				<div class="controls">
					<input type="email"	value="${model.persona}" readonly="true">
				</div>
			</div>

			<!-- Cambiar Email -->

			<div class="control-group">
				<label class="control-label" for="">Cambiar Email</label>

				<div class="controls">
					<input type="email" name="email" required>
				</div>
			</div>


			<div class="alert alert-success">

				<strong> <i class="icon-ok"></i> Alerta!
				</strong> Para Actualizar su email, introduce tu contrase�a. <br>
			</div>


			<!-- Confirmar Contrase�a -->

			<div class="control-group">
				<label class="control-label" for="form-field-1">Confirmar Contrase�a</label>

				<div class="controls">
					<input type="password" name="password" id="confirmar_contrase�a" placeholder="Contrase�a..." required>
				</div>
			</div>



		</div>
		<div class="modal-footer">

			<input class="btn btn-primary"  type="submit"
				 value="aceptar">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
		</div>
 </form>
</div>

