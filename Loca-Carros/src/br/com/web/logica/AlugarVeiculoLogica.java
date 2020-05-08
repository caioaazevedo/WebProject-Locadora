package br.com.web.logica;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.web.model.bean.CarroBean;
import br.com.web.model.bo.CarroBO;

public class AlugarVeiculoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		CarroBO carroBO = new CarroBO();
		
		String id_carroStr = request.getParameter("btnDisponibilidade");
		Integer id_carro = Integer.parseInt(id_carroStr);
		
		String redirctPage = carroBO.mudarDisponibilidade(id_carro);
		
		System.out.println("Page --> "+ redirctPage);
		
		if (redirctPage == "ListarVeiculos.jsp") {
			ArrayList<CarroBean> carroList = carroBO.listarCarros();
			
			request.setAttribute("lista_carros", carroList);
		} 

		return redirctPage;
	}

}

