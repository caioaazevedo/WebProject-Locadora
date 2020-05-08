package br.com.web.model.bo;

import java.util.ArrayList;

import br.com.web.model.bean.UsuarioBean;
import br.com.web.model.dao.UsuarioDao;

public class UsuarioBO {
	private UsuarioDao usuarioDao = new UsuarioDao();

	public UsuarioBO() {
		super();
	}
	
	public String insertUser(UsuarioBean newUser) {
		ArrayList<UsuarioBean> listUser = this.usuarioDao.listarUsers();
		
		for(UsuarioBean users: listUser) {
			if (users.getUsername().equals(newUser.getUsername())) {
				return "ErrorPage.jsp";
			}
		}
		
		if(this.usuarioDao.inserirUser(newUser)) {
			return "ListarVeiculos.jsp";
		}
		
		return "PaginaErro.jsp";
	}
	
	public ArrayList<UsuarioBean> obterUsuarios(){
		return this.usuarioDao.listarUsers();
	}
	
	
}
