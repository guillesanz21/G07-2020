<c:choose>

	<c:when test="${emailUsuario == null }">
		<div>
			<h3>Muchas gracias por simular</h3>
		</div>
	</c:when>

	<c:when test="${emailUsuario != null }">
		<div>
			<h3>Guarde su simulaci�n aqu�</h3>
			<form class="form-inline" action="FormGuardaSimulacionServlet">
				<input type="text" class="form-control" name="simName"
					placeholder="nombre ley" /> <input type="hidden"
					name="TipoMayoria" id="TipoMayoria" value="" /> <input
					type="hidden" name="LeyAprobada" id="LeyAprobada" value="" />
				<button type="submit" class="btn btn-success"
					style="margin-left: 10px">Guardar
					simulacion</button>
			</form>
		</div>

	</c:when>
</c:choose>