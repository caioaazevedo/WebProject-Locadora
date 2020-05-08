function validarLogin(username, password) {
  if(username.value == "" || password.value == ""){
    alert("Campo(s) Inválidos. Por favor, digite novamnte!");
    return false
  } else {
	  return true;
  }
}

function validarBusca(modelo) {
  if(modelo.value == ""){
    alert("Modelo Inválido! Por favor, digite novamente");
    return false
  } else {
	  return true;
  }
}

function validarNovoCarro(modelo, fabricante, ano){
	if (modelo.value == "" || fabricante.value == "" || ano.value == ""){
		alert("Campo(s) Inválido! Verifique se preencheu todos os campos corretamente.");
		return false
	} else {
		return true;
	}
}

function validarAluguel(){
	alert("Para alugar um carro diriga-se a página 'Alugar Carro' na barra de navegação.");
}

function alugarCarro(id_carro){
	const parameter = `id_carro=${id_carro}`
	
	$.ajax({
		url: `AlugaCarroServlet/${parameter}`,
		type: "GET"
	});
}

function validarExcusao(disponibilidade){
	if (disponibilidade == 1){
		return true;
	} else {
		alert("Não é possível deletar um carro que está Alugado");
		return false;
	}
}
