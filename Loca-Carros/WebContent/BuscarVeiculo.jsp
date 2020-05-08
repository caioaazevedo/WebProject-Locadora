<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script type="text/javascript" src="Validacoes.js"></script>
<title>Alugar Veiculo</title>
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

<div class="container">
	<h1>Buscar Carro</h1>
	<div class="card">
		<div class="card-body">
			<form action="Locadora" method="post">
				<div class="form-group row">
					<label class="col-sm-4">Buscar Modelo:</label>
					<div class="col-sm-8">
						<input type=text id="txtBusca" name="txtBusca" class="form-control" placeholder="Digite o Modelo do Carro">
					</div>
				</div>
				<br>
				<input type="hidden" name="logica" value="BuscarVeiculoLogica">
				<button type="submit" id="submitBusca" name="submitBusca" class="btn btn-dark" onclick="return validarBusca(txtBusca)">Buscar</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>