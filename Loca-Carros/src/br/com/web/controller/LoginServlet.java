package br.com.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.web.model.bean.CarroBean;
import br.com.web.model.bean.UsuarioBean;
import br.com.web.model.bo.CarroBO;
import br.com.web.model.bo.UsuarioBO;
import br.com.web.model.dao.UsuarioDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newUsername = request.getParameter("txtNewUsername");
		String newPassword = request.getParameter("txtNewPassword");
		
		UsuarioBO usuarioBO = new UsuarioBO();
		UsuarioBean newUsuario = new UsuarioBean(newUsername, newPassword);
		
		System.out.println("Uswername: " + newUsername + "Password: " + newPassword);
		
		String page = usuarioBO.insertUser(newUsuario);
		
		CarroBO carroBO = new CarroBO();
		
		ArrayList<CarroBean> lista_carros = carroBO.listarCarros();
		
		request.getSession().setAttribute("lista_carros", lista_carros);
		response.sendRedirect(page);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String username = request.getParameter("txtusername");
		String password = request.getParameter("txtpassword");
		
		UsuarioBO usuarioBO = new UsuarioBO();
		ArrayList<UsuarioBean> usuarios = usuarioBO.obterUsuarios();
		
		String redirectPage = "PaginaErro.jsp";
		
		for(UsuarioBean user: usuarios) {
			boolean loginOk = user.getUsername().equals(username) && user.getPassword().equals(password);
			if(loginOk) {
				System.out.println("senha e usuario corretos");
				
				CarroBO carroBO = new CarroBO();
				ArrayList<CarroBean> lista_carros = carroBO.listarCarros();
				
				request.getSession().setAttribute("lista_carros", lista_carros);
				redirectPage = "ListarVeiculos.jsp";
			}
		}
		
		response.sendRedirect(redirectPage);
		

}

}
