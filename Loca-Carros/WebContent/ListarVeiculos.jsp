<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<script type="text/javascript" src="Validacoes.js"></script>
<title>Lista de Veiculos</title>
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
	<h3>Locadora Persist - Melhor locadora do leste da cidade!</h3>
	<br>
	<div class="card">
		<div class="card-body">
			<h4>Lista de Carros</h4>
			<br>
			<c:forEach items = "${lista_carros}" var="carro">
				<div class="card">
					<div class="container-fluid">
						<br>
						<div class="row">
							<div class="col-sm-3">
								<h6> Modelo: </h6>
								<label> ${carro.modelo} </label>
							</div>
							
							<div class="col-sm-3">
								<h6> Fabricante: </h6>
								<label> ${carro.fabricante} </label>
							</div>
							
							<div class="col-sm-2">
								<h6> Ano: </h6>
								<label> ${carro.ano} </label>
							</div>
							
							<div class="col-sm-2">
								<h6> Disponibilidade: </h6>
								<c:choose> 
								  <c:when test="${carro.disponivel=='1'}">
								    <label> Disponível </label>
								  </c:when>
								  <c:otherwise>
								  	<label style="color:#999"> Indisponível </label>
								  </c:otherwise>
								</c:choose>
								
							</div>
							
							<div class="col-sm-1">
								<form action="Locadora" method="post">
									<input type="hidden" name="logica" value="ListaVeiculosLogica">
									<button type="submit" class="btn btn-success" id="btnEditar" name="btnEditar" value="${carro.id_carro}"><i class="material-icons">edit</i></button>
								</form>
							</div>
							<div class="col-sm-1">
								<form action="Locadora" method="get">
									<button type="submit" class="btn btn-danger" id="btnDeletar" name="btnDeletar" value="${carro.id_carro}" onclick="return validarExcusao(${carro.disponivel})"><i class="material-icons">delete</i></button>
								</form>
							</div>
						</div>
						<br>
					</div>
				</div>
				<br>
			</c:forEach>
		</div>
	</div>
	
	<br><br>

	<form action="BuscarVeiculo.jsp">
		<button type="submit" class="btn btn-dark">Alugar Veiculo</button>
	</form>

</div>
	
	
</body>
</html>
