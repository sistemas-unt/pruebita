<%@ include file="/WEB-INF/views/include.jsp"%>

<div class="page-header">
	<h1>
		Lista Padrón <small><i class="icon-double-angle-right"></i>Lista
			de Alumnos</small>

	</h1>
</div>


<div class="row-fluid">
	<div class="span12">

		<div class="table-header"
			style="background: #2283c5; padding-left: 5px; padding-bottom: 2px;">

			<a href="#dni" data-toggle="modal" title="Agregar Alumno"
				class="btn btn-small btn-primary" style="border: 1px solid #c4e7ff;"><i
				class="icon-inbox"></i>Agregar</a>

		</div>
		<table id="sample-table-3"
			class="table table-striped table-bordered table-hover">

			<thead>
				<tr>
					<th class="center">N°</th>
					<th class="">Nombre</th>
					<th class="center">DNI</th>
					<th class="hidden-phone">Escuela</th>
					<th class="center">Código Carnet</th>
					<th class="">Tipo</th>
					<th class="center">Editar</th>
					<th class="center">Ratificar</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="n" items="${model.listacomedor2}"
					varStatus="contador">
					<tr>
						<td class="center"><c:out value="${contador.count}" /></td>
						<td><c:out value="${n[0]} ${n[5]} ${n[6]}"></c:out></td>
						<td><c:out value="${n[7]}"></c:out></td>
						<td class="hidden-phone"><c:out value="${n[1]} "></c:out></td>
						<td class="center"><c:out value="${n[2]} "></c:out></td>
						<td><c:out value="${n[3]} "></c:out></td>
						<td class="center"><a
							href="editarComedor.htm?ve=<c:out value="${n[4]}" />"
							title="Modificar"><i class="icon-edit"></i> Editar </a></td>
						<td class="center"><a href="#eliminar" data-toggle="modal" onclick='enviardato("${n[4]}")' title="Eliminar"> 
						<i class="icon-trash"></i>Ratificar</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<!--/.span-->
</div>
<!--/.row-fluid-->



<!-- Modal -->
<form method="POST" action="<c:url value='lista_comedor2.htm'/>">
	<div id="eliminar" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header header-color-sky blue">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">Motivo</h3>
		</div>
		<div class="modal-body">

			<textarea name="motivo" class="input-block-level" required></textarea>
			<input value="" id="enviardato" name="idfc" type="hidden">

		</div>
		<div class="modal-footer">

			<button type="submit" class="btn btn-primary">Aceptar</button>
			<button class="btn" data-dismiss="modal">Cancelar</button>
		</div>
	</div>
</form>
<!-- Modal Buscar DNI -->

<form class="form-search" action="<c:url value='fichaComedor.htm'/>"
	method="POST" id="form_dni">
	<div id="dni" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header header-color-sky blue">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">Número de DNI</h3>
		</div>

		<div class="modal-body">
			<span class="input-icon input-block-level"
				style="margin-bottom: 20px"> <input type="text"
				placeholder="Número de DNI ..." pattern=".{8,8}"
				title="solo puedes escribir 8 dígitos"
				class="input-block-level numeros" name="dni" id="dni" /> <i
				class="icon-search nav-search-icon"></i>
			</span>
				<p id="mensaje"></p>	
		</div>
		<div class="modal-footer">

			<input type="button" onclick="return validateForm();"
				class="btn btn-primary" value="Aceptar">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button>
		</div>

	</div>
</form>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("input").blur(function(){
		document.getElementById("mensaje").innerHTML = "";
  });
});
</script>
<script>
function enviardato(a){
	document.getElementById("enviardato").value=a;
} 
</script>