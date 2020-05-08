package br.com.web.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.web.model.bean.CarroBean;
import br.com.web.model.bean.UsuarioBean;

public class UsuarioDao {
	private ArrayList<UsuarioBean> listaUsers = new ArrayList<UsuarioBean>();
	
	private Connection conn;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;
	
	public UsuarioDao() {
		this.conn = new ConnectionFactory().getConnection();
	}
	
	public boolean inserirUser(UsuarioBean newUser) {
		
		String sql = "INSERT INTO user (username, password) values (?,?)";
		
		try {
			
			// Executa o sql passando os parametros para o banco
			ps = conn.prepareStatement(sql);
			ps.setString(1, newUser.getUsername());
			ps.setString(2, newUser.getPassword());
			ps.execute();
			ps.close();
			
			return true;
		} catch(Exception error) {
			return false;
		}
	}
	
	public ArrayList<UsuarioBean> listarUsers(){
		listaUsers = new ArrayList<UsuarioBean>();
		String sql = "SELECT * FROM user";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("username"));
				UsuarioBean usuarioBean = new  UsuarioBean(rs.getString("username"), rs.getString("password"));
				listaUsers.add(usuarioBean);
			}

		} catch(Exception error) {
			System.out.println("Error não conectou!6");
		}
		return this.listaUsers;
	}
}