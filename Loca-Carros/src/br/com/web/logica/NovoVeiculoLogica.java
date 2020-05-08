package br.com.web.logica;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.web.model.bean.CarroBean;
import br.com.web.model.bo.CarroBO;

public class NovoVeiculoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		CarroBO carroBO = new CarroBO();
		
		String modelo = request.getParameter("txtModel");
		String fabricante = request.getParameter("txtFabricante");
		String anoString = request.getParameter("txtAno");
		
		Integer ano = Integer.parseInt(anoString);
		
		CarroBean newCar = new CarroBean(modelo, fabricante, ano, 1);
		
		String jspPage = carroBO.inserirCarro(newCar);
		
		if (jspPage == "ListarVeiculos.jsp") {
			ArrayList<CarroBean> carroList = carroBO.listarCarros();
			
			request.setAttribute("lista_carros", carroList);
		}
		
		return jspPage;
	}

}
