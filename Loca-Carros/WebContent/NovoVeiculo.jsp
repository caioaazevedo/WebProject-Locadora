<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script type="text/javascript" src="Validacoes.js"></script>
<title>New Car</title>
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
	<h1>Adicionar Novo Carro</h1>
	<div class="card">
		<div class="card-body">
			<form action="Locadora" method="post">
				<div class="form-group row">
					<label class="col-sm-4">Modelo</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="txtModel" name="txtModel" placeholder="Digite o Modelo">
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-4">Fabricante</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="txtFabricante" name="txtFabricante" placeholder="Digite o Fabricante">
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-4">Ano</label>
					<div class="col-sm-8">
						<input type="number" class="form-control" id="txtAno" name="txtAno" placeholder="Digite o Ano">
					</div>
				</div>
				<input type="hidden" name="logica" value="NovoVeiculoLogica">
				<button type="submit" id="Submit" name="Submit" class="btn btn-dark" onclick="return validarNovoCarro(txtModel, txtFabricante, txtAno)">Salvar</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>