package br.com.web.model.bean;

public class CarroBean {

	Integer id_carro;
	String modelo;
	String fabricante;
	Integer ano;
	Integer disponivel;
	
	public CarroBean(String modelo, String fabricante, Integer ano, Integer disponivel) {
		super();
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.ano = ano;
		this.disponivel = disponivel;
	}
	
	public Integer getId_carro() {
		return id_carro;
	}

	public void setId_carro(Integer id_carro) {
		this.id_carro = id_carro;
	}
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Integer disponivel) {
		this.disponivel = disponivel;
	}
}
