package br.com.web.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.web.model.bean.CarroBean;
import br.com.web.model.bo.CarroBO;

public class ListaVeiculosLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		CarroBO carroBO = new CarroBO();
		
		String parametro = request.getParameter("btnEditar");
		
		Integer id = Integer.parseInt(parametro);
		
		String redirectPage = "EditarVeiculo.jsp";
		
		CarroBean carroBean = carroBO.buscarPorId(id);
		
		request.setAttribute("carro", carroBean);

		return redirectPage;
	}

}



