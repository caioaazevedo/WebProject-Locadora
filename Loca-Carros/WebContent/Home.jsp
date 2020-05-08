<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Locadora Persist</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="Style.css">
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


      <div class="cardHomeTitle">
      	<h1>Locadora Persist</h1>
        <p>A melhor locadora de veículos do lado leste da cidade.</p>
      </div>

      <div class="cardHomeBottom">
	      <div class="row">
	        <div class="col-sm-4">
	          <h2>Qualidade</h2>
	          <p>Premiada pela revista 4Locadoras como a Locadora de veiculos de melhor qualidade no lado leste da cidade.</p>
	        </div>
	        <div class="col-sm-4">
	          <h2>Facilidade</h2>
	          <p>Uma emprsa que presa pela experiência fluida com o usuário, deixando tudo a um click do que você quer fazer.</p>
	       </div>
	        <div class="col-sm-4">
	          <h2>Confiabilidade</h2>
	          <p>Aqui na Locadora Persist nós persistimos em garantir um ambiente seguro para passar confiança para o nosso Cliente.</p>
	        </div>
	      </div>
	   </div>

      <hr>

      <footer>
        <p>© Locadora Persist</p>
      </footer>

    </div>
</body>
</html>
