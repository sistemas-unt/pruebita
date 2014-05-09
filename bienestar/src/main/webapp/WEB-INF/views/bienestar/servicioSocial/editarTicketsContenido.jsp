<%@ include file="/WEB-INF/views/include.jsp"%>
	<div class="page-header">
		<h1>
				Control Social <small> <i class="icon-double-angle-right"></i>
					Editar Control Tickets
				</small> 
			<a href="../bienestar/control_social.htm"
				title="Lista Asistenta" class="btn btn-success btn-small pull-right"
				style="font-size: 20px"><i class="icon-tasks"></i></a>
				
		</h1>
	</div>
	<!--/.page-header-->

	<!--/.span-->
	<div class="widget-box">
				<div >
					<label for="form-field-1">Nombre de Escuela:</label>
				    <div >
							<label class="input-xxlarge"  id="escuela"  >
							${model.escuela2[1]}
							</label>
								
					</div>
				</div>
				<br>
				 
				<div class="span2"></div>
				
				<div class="span10">
						<a href="#escuelas" data-toggle="modal" title="Agregar Escuela" class="btn btn-success btn-mini pull-right" style="font-size: 15px; margin-right: 5px"> Agregar Escuela <i class="icon-plus"></i></a>
						
				</div>
					<div class="span1"></div>
							
				</div>
		
		<div class="row-fluid" >
			<br>
			<div class="span1"></div>
			<div class="span10">
				<table    id="grid" class="table table-striped table-bordered table-hover"  >
				
					<thead>
						<tr >
				
						<td class="widget-header header-color-blue" > Total Tickets </td> 						
						</tr>
					</thead>
					<tbody>
						<c:forEach 	var="n" items="${model.escuela}">
						<tr>
							 
							<td name="escuelas" id="nombreescuelas"><c:out value="${n[1]} "></c:out></td>
						
				
						</tr>
							</c:forEach>
					</tbody>
						
					
				</table>
		</div>
	
	</div>
					
		<div class="modal-footer">
		<a href= "../bienestar/control_social.htm" class="btn btn-primary">Guardar</a> 
		
		<a href="../bienestar/control_social.htm" class="btn">Cancelar</a>
		</div>

	
		
