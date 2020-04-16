<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous" />
<link rel="stylesheet" type="text/css" href="assets/css/main.css" />
<!-- JS file responsible for load the partials -->
<script type="text/javascript" src="assets/js/main.js"></script>
<title>ElectoLab</title>
</head>
<body>

<!-- Header -->
	<header class="header"></header>
	<!-- Information page -->

	<!-- Content -->
	<section class="container container-index">
		<h1 class="display-2 screenHeader">ElectoLab Parte II</h1>
		<div>
			<p class="index-text">Página web dedicada a la simulacion de
				votaciones de leyes en el Congreso de los Diputados, pensada tanto
				como para el público general como para un público con más
				conocimiento, como pueden ser analistas o periodistas.</p>
			<p class="index-text">Pulse simulación sencilla para una votación
				estándar del Congreso dividido por partidos políticos.</p>
			<p class="index-text">Tras registrarse y acceder, pulse
				simulación avanzada para votaciones más complejas.</p>
			
			<h2>Registrar analista</h2>
		<%@ include file="FormRegistro.jsp"%>
		
			<h2>Acceder a cuenta existente</h2>
			<form action="FormLoginServlet">
				<input type="text" name="email" placeholder="Email"> 
				<input type="password" name="password" placeholder="Password">
				<button type="submit">Login</button>
			</form>
			
		</div>
		<img id="resultados" src="assets/images/resultados.png"
			alt="resultados de las elecciones generales de 2019" />
		<div id="btns-home">
			<a role="button" class="btn btn-info btn-home" href="AsignacionSimple.jsp">Simulación
				Sencilla</a> <a role="button" class="btn btn-info btn-home disabled"
				href="#">Simulación Avanzada</a>
		</div>

		<div class="ver-simul">
			<p class="index-text">¿Prefiere ver simulaciones realizadas por
				otras personas en vez de simular usted mismo?</p>
			<p class="index-text">Aquí podrá encontrarlas:</p>
			<a role="button" class="btn btn-success btn-home disabled" href="#">Ver
				otras simulaciones</a>
		</div>
	</section>
	<br />
	<br />
	<br />
	<!-- Footer -->
	<footer class="footer"></footer>

	<!-- Bootstrap required JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>

</body>
</html>