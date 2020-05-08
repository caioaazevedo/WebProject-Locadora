<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script type="text/javascript" src="Validacoes.js"></script>
<title>Login</title>
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
	<h1>Login</h1>
	<div class="card">
		<div class="card-body">
			<form action="LoginServlet" method="post">
				<div class="form-group row">
					<label class="col-sm-5">Usuário</label>
					<div class="col-sm-7">
						<input type="text" class="form-control" id="txtusername" name="txtusername" placeholder="Digite seu Usuário">
					</div>
				</div>

				<div class="form-group row">
					<label class="col-sm-5">Senha</label>
					<div class="col-sm-7">
						<input type="password" class="form-control" id="txtpassword" name="txtpassword" placeholder="Digite sua senha">
					</div>
				</div>
				<button type="submit" id="submitLogin" name="submitLogin" class="btn btn-dark" onclick="return validarLogin(txtusername, txtpassword)">Enter</button>
			</form>
		</div>
	</div>
</div>

</body>
</html>
