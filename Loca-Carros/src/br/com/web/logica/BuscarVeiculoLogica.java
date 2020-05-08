package br.com.web.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.web.model.bean.CarroBean;
import br.com.web.model.bo.CarroBO;

public class BuscarVeiculoLogica implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		CarroBO carroBO = new CarroBO();
		
		String modelo = request.getParameter("txtBusca");
		
		CarroBean car = carroBO.buscarModelo(modelo);
		
		if (car == null) {
			return "PaginaErro.jsp";
		} else {
			String msg = car.getDisponivel()==1 ? "Disponível": "Não Disponível";
			System.out.println("Mensagem: " + msg);
			
			request.getSession().setAttribute("carro", car);
			
			return "Aluguel.jsp";
		}
	}

}
