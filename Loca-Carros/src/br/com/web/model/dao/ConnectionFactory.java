package br.com.web.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;;


// Classe destinada somente para abrir a conxão com o Banco de Dados
public class ConnectionFactory {
	
	public Connection getConnection() {
		
		
		String url = "jdbc:mysql://127.0.0.1:3306/dbLocadora";
		String user = "root";
		String password = "c19081998";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection(url, user, password);
			
		}catch(Exception error){
			throw new RuntimeException("Error na conexão ", error);
		}
	}

}
