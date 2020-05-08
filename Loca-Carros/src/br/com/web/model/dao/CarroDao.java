package br.com.web.model.dao;

import br.com.web.model.bean.CarroBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;

public class CarroDao {
	
	private Connection conn;
	private PreparedStatement ps;
	private Statement st;
	private ResultSet rs;
	
	public CarroDao() {
		
		// Abre a conexão com o banco
		this.conn = new ConnectionFactory().getConnection();
		
	}
	
	public boolean inserirCarro(CarroBean newCar) {
		
		String sql = "INSERT INTO carro (fabricante, modelo, ano, disponivel) values (?,?,?,?)";
		
		try {
			
			// Executa o sql passando os parametros para o banco
			ps = conn.prepareStatement(sql);
			ps.setString(1, newCar.getFabricante());
			ps.setString(2, newCar.getModelo());
			ps.setInt(3, newCar.getAno());
			ps.setInt(4, newCar.getDisponivel());
			ps.execute();
			ps.close();
			
			return true;
		} catch(Exception error) {
			return false;
		}
	}
	
	public ArrayList<CarroBean> listarCarros(){
		ArrayList<CarroBean> listaCarros = new ArrayList<CarroBean>();
		
		String sql = "SELECT * FROM carro";
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				CarroBean carroBean = new CarroBean(rs.getString("modelo"), rs.getString("fabricante"), rs.getInt("ano"), rs.getInt("disponivel"));
				carroBean.setId_carro(rs.getInt("id_carro"));
				
				listaCarros.add(carroBean);
			}

		} catch(Exception error) {
			System.out.println("Error não conectou!");
		}
		return listaCarros;
	}
	
	public boolean updateCarro(CarroBean newCar) {
		String sql = "UPDATE carro SET fabricante=?, modelo=?, ano=?, disponivel=? WHERE id_carro=?";
		
		try {
			
			// Executa o sql passando os parametros para o banco
			ps = conn.prepareStatement(sql);
			ps.setString(1, newCar.getFabricante());
			ps.setString(2, newCar.getModelo());
			ps.setInt(3, newCar.getAno());
			ps.setInt(4, newCar.getDisponivel());
			ps.setInt(5, newCar.getId_carro());
			ps.execute();
			ps.close();
			
			return true;
		} catch(Exception error) {
			return false;
		}
	}
	
	public boolean deleteCarro(CarroBean carro) {
String sql = "DELETE FROM carro WHERE id_carro=?";
		
		try {
			
			// Executa o sql passando os parametros para o banco
			ps = conn.prepareStatement(sql);
			ps.setInt(1, carro.getId_carro());
			ps.execute();
			ps.close();
			
			return true;
		} catch(Exception error) {
			return false;
		}
	}
}
