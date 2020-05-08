package br.com.web.logica;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.web.model.bean.CarroBean;
import br.com.web.model.bo.CarroBO;

public class EditarVeiculoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		CarroBO carroBO = new CarroBO();
		
		String modelo = request.getParameter("txtEditModel");
		String fabricante = request.getParameter("txtEditFabricante");
		String anoString = request.getParameter("txtEditAno");
		Integer ano = Integer.parseInt(anoString);
		
		String id_carroStr = request.getParameter("btnEdit");
		Integer id_carro = Integer.parseInt(id_carroStr);
		
		CarroBean carroBean = new CarroBean(modelo, fabricante, ano, 1);
		carroBean.setId_carro(id_carro);
		
		System.out.println("Modelo: " + carroBean.getModelo());
		
		String redirctPage = carroBO.updateCarro(carroBean);
		
		if (redirctPage == "ListarVeiculos.jsp") {
			ArrayList<CarroBean> carroList = carroBO.listarCarros();
			
			request.setAttribute("lista_carros", carroList);
		} 

		return redirctPage;
	}

}



