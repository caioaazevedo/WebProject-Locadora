<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Error Page</title>
</head>
<body>

<div id="nav-placeholder">
	<script src="//code.jquery.com/jquery.min.js"></script>
	<script>
	$.get("NavbarLogged.html", function(data){
	    $("#nav-placeholder").replaceWith(data);
	});
	</script>
</div>

<div class="container">
	<h1>Ops,</h1>
	<h5>Algo deu errado...</h5>
</div>
</body>
</html>