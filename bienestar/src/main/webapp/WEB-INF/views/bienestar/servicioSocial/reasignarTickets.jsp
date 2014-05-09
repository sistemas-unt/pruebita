
<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="page-header">
	<h1>
		Reasignación de Tickets <small> <i
			class="icon-double-angle-right"></i> Reasignar Tickets a otras Escuelas
		</small> <a href="../bienestar/control_social.htm" class="btn btn-success"
			style="border: 1px solid #c4e7ff; float: right; margin-top: 5px;"><i
			class="icon-reply"></i>Volver</a>
	</h1>
</div>
<p class="bigger-110">
	Escuela: <span class="grey" style="text-transform: uppercase"> ${model.nombreescuela}</span>
</p>
<div class="page-header position-relative" style="margin-top: 30px">

	<form method="POST" class="form-horizontal"
		action="<c:url value='editarTickets.htm'/>" onsubmit="return marcar(this)">
		<div class="row-fluid">
				
		<ul class="thumbnails">
			<c:forEach var="n" items="${model.codigosdisponibles}">
				<li class="span1" style="margin-left: 30px">${n[1]}<br><a href="#" class=""> 
				
				<input class="ace" value="${n[0]}" name="codigosdisponibles" style=""
							type="checkbox"> <span class="lbl" style="width: 30px;height: 30px"></span>
				</a></li>
			</c:forEach>
		</ul>
	


			<!---------------------- 	Escuelas ------------------------------------>
			<div class="page-content">
				<div class="span10">
					<div class="page-header">
						<h1 style="font-size: 16px">Escuela Asignada</h1>
					</div>
					<div class="control-group">
						<label class="control-label" for="">Elegir Escuela</label>
						<div class="controls">
							<select name="listaescuela" class="input-xlarge">
							
								<c:forEach var="n" items="${model.escuelas}">
									<option value="${n[0]}">
										<c:out value="${n[1]}"></c:out>
									</option>
								</c:forEach>
							</select>
						</div>
					</div>

				</div>
			</div>

		</div>
		<div class="form-actions">

			<button class="btn btn-info" type="submit">
				<i class="icon-ok bigger-110"></i> Guardar
			</button>
		</div>
	</form>
</div>








