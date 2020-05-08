package br.com.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.web.logica.Logica;
import br.com.web.model.bean.CarroBean;
import br.com.web.model.bo.CarroBO;
import br.com.web.model.dao.CarroDao;

/**
 * Servlet implementation class Locadora
 */
@WebServlet("/Locadora")
public class LocadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocadoraServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//  Reservado para a função de Deletar
		
		String parametro = request.getParameter("btnDeletar");
		
		Integer id = Integer.parseInt(parametro);
		
		CarroBO carroBO = new CarroBO();
		
		String redirectPage = carroBO.deleteCarro(id);
		
		if (redirectPage == "ListarVeiculos.jsp") {
			ArrayList<CarroBean> carroList = carroBO.listarCarros();
			
			request.setAttribute("lista_carros", carroList);
		} 

		request.getRequestDispatcher(redirectPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String parametro = request.getParameter("logica");
        String nomeDaClasse = "br.com.web.logica." + parametro;
        
        System.out.println(nomeDaClasse);

        try {
            Class<?> classe = Class.forName(nomeDaClasse);
            Logica logica = (Logica) classe.getDeclaredConstructor().newInstance();

            // Recebe o String após a execução da lógica
            String pagina = logica.executa(request, response);

            // Faz o forward para a página JSP
            request.getRequestDispatcher(pagina).forward(request, response);

        } catch (Exception e) {
            throw new ServletException("A lógica de negócios causou uma exceção", e);
        }
	}

}
