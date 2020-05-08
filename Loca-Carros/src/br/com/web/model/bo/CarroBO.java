package br.com.web.model.bo;

import java.util.ArrayList;

import br.com.web.model.bean.CarroBean;
import br.com.web.model.dao.CarroDao;

public class CarroBO {
	
	CarroDao carroDao;
	
	public CarroBO() {
		this.carroDao = new CarroDao();
	}
	
	public String inserirCarro(CarroBean newCar) {
		
		if (this.carroDao.inserirCarro(newCar)) {
			return "ListarVeiculos.jsp";
		}
		
		return "PaginaErro.jsp";
	}
	
	public ArrayList<CarroBean> listarCarros(){
		return carroDao.listarCarros();
	}
	
	public CarroBean buscarModelo(String modelo) {
		ArrayList<CarroBean> carros = carroDao.listarCarros();
		
		for(CarroBean carro: carros) {
			if(carro.getModelo().equals(modelo)) {
				return carro;
			}
		}
		
		return null;
	}
	
	public CarroBean buscarPorId(int id) {
		ArrayList<CarroBean> carros = carroDao.listarCarros();
		
		for(CarroBean carro: carros) {
			if(carro.getId_carro() == id) {
				return carro;
			}
		}
		
		return null;
	}
	
	public String mudarDisponibilidade(Integer id_carro) {
		ArrayList<CarroBean> carros = this.carroDao.listarCarros();
		
		for(CarroBean car: carros) {
			if (car.getId_carro() == id_carro) {
				if (car.getDisponivel() == 1) {
					System.out.println("Carro " + id_carro + "passou para n disponvel" );
					car.setDisponivel(0);
				} else {
					System.out.println("Carro " + id_carro + "passou para disponvel" );
					car.setDisponivel(1);
				}
				
				
				if (this.carroDao.updateCarro(car)) {
					return "ListarVeiculos.jsp";
				}
			}
		}
		return "PaginaErro.jsp";
	}
	
	public String updateCarro(CarroBean carro) {	
		if (this.carroDao.updateCarro(carro)) {
			return "ListarVeiculos.jsp";
		} else {
			return "PaginaErro.jsp";
		}
	}
	
	public String deleteCarro(Integer id_carro) {
		ArrayList<CarroBean> carros = this.carroDao.listarCarros();
		
		for(CarroBean car: carros) {
			if (car.getId_carro() == id_carro) {
				
				if (this.carroDao.deleteCarro(car)) {
					return "ListarVeiculos.jsp";
				}
			}
		}
		return "PaginaErro.jsp";
	}
}
