<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script type="text/javascript" src="Validacoes.js"></script>
<title>Aluguel</title>
</head>
<body>

<div id="nav-placeholder">
	<script src="//code.jquery.com/jquery.min.js"></script>
	<script>
	$.get("NavbarLogado.html", function(data){
	    $("#nav-placeholder").replaceWith(data);
	});
	</script>
</div>

<br>

<div class="container">
	<h1>Resultado da Busca</h1>
	<br>
	<div class="card">
		<form action="Locadora" method="post">
			<div class="container-fluid">
				<br>
				<div class="row">
					<div class="col-sm-4">
						<h6> Modelo: </h6>
						<label> ${carro.modelo} </label>
					</div>
					
					<div class="col-sm-4">
						<h6> Fabricante: </h6>
						<label> ${carro.fabricante} </label>
					</div>
					
					<div class="col-sm-2">
						<h6> Ano: </h6>
						<label> ${carro.ano} </label>
					</div>
					
					<div class="col-sm-2">
						<h6> Disponibilidade: </h6>
						<input type="hidden" name="logica" value="AlugarVeiculoLogica">
						<c:choose> 
						  <c:when test="${carro.disponivel=='1'}">
						    <button type="submit" class="btn btn-success" id="btnDisponibilidade" name="btnDisponibilidade" value="${carro.id_carro}">Alugar</button>
						  </c:when>
						  <c:otherwise>
						    <button type="submit" class="btn btn-danger" id="btnDisponibilidade" name="btnDisponibilidade" value="${carro.id_carro}">Devolver</button>
						  </c:otherwise>
						</c:choose>
					</div>
				</div>
				<br>
			</div>
		</form>
	</div>
	
	<br><br>

	<form action="BuscarVeiculo.jsp">
		<button type="submit" class="btn btn-dark">Buscar Veiculo</button>
	</form>

</div>
	
	
</body>
</html>