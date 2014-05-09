<%@ include file="/WEB-INF/views/include.jsp"%>

<div id="impresion">

	
	<h1>Ejemplo</h1>

	<table
		style="border: 1px solid #C5C5C5; width: 700px; margin: auto; margin-bottom: 40px">

		<tbody>
			<tr>
				<td style="background: #f9f9f9;text-align: right;width: 200px;padding: 10px;border-right: 1px solid #C5C5C5;border-bottom: 1px solid #C5C5C5">numero resolucion :</td>
				<td style="background: #f9f9f9;padding-left: 20px;border-bottom: 1px solid #C5C5C5"><c:out value="${model.fichaPer[0][0] }"></c:out> </td>
			</tr>
			<tr>
				<td style="text-align: right;width: 200px;padding: 10px;border-right: 1px solid #C5C5C5;border-bottom: 1px solid #C5C5C5">tipo de ficha</td>
				<td style="padding-left: 20px;border-bottom: 1px solid #C5C5C5"><c:out value="${model.fichaPer[0][1] }"></c:out> </td>
			</tr>

			
		</tbody>
	</table>


</div>

