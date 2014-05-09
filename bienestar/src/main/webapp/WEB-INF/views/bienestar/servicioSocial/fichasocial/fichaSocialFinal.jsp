<%@ include file="/WEB-INF/views/include.jsp"%>

<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>


<div id="impresion">

	<div class="page-header">
		<h1>Ficha Social <small> <i class="icon-double-angle-right"></i>
				Infomación de la Ficha
			</small>
		</h1>
	</div>

	<h1>¡Felicitaciones, Ficha Social Completada !</h1>

	<table
		style="border: 1px solid #C5C5C5; width: 700px; margin: auto; margin-bottom: 40px">

		<tbody>
			<tr>
				<td style="background: #f9f9f9;text-align: right;width: 200px;padding: 10px;border-right: 1px solid #C5C5C5;border-bottom: 1px solid #C5C5C5">Nombre :</td>
				<td style="background: #f9f9f9;padding-left: 20px;border-bottom: 1px solid #C5C5C5"><security:authentication
						property="principal.nombre" /></td>
			</tr>
			<tr>
				<td style="text-align: right;width: 200px;padding: 10px;border-right: 1px solid #C5C5C5;border-bottom: 1px solid #C5C5C5">DNI :</td>
				<td style="padding-left: 20px;border-bottom: 1px solid #C5C5C5"><security:authentication property="principal.username" /></td>
			</tr>

			
		</tbody>
	</table>


</div>
<a href="ficha_imprimir.htm">
<button class="btn btn-primary">
	<i class="icon-print"></i> IMPRIMIR
</button></a>

