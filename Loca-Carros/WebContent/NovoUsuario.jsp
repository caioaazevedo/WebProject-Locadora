<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script type="text/javascript" src="Validacoes.js"></script>
<title>Cadastro</title>
</head>
<body>

<div id="nav-placeholder">
	<script src="//code.jquery.com/jquery.min.js"></script>
	<script>
	$.get("Nav.htm", function(data){
	    $("#nav-placeholder").replaceWith(data);
	});
	</script>
</div>

<div class="container">
	<h1>Cadastro Usuário</h1>
	<div class="card">
		<div class="card-body">
			<form action="LoginServlet" method="get">
				<div class="form-group row">
					<label class="col-sm-5">Usuário</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" id="txtNewUsername" name="txtNewUsername" placeholder="Digite seu Usuário">
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-5">Senha</label>
					<div class="col-sm-7">
						<input type="password" class="form-control" id="txtNewPassword" name="txtNewPassword" placeholder="Digite sua Senha">
					</div>
				</div>
				<button type="submit" id="submitNewPassword" name="submitNewPassword" class="btn btn-dark" onclick="return validarLogin(txtusername, txtpassword)">Salvar</button>
			</form>
		</div>
	</div>
</div>

</body>
</html>