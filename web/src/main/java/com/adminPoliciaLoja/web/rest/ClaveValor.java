package com.adminPoliciaLoja.web.rest;

import java.io.Serializable;

public class ClaveValor implements Serializable{
	
	private static final long serialVersionUID = 7044687455604201176L;
	private String clave;
	private double valor;
	
	public ClaveValor(String clave, double valor) {
		super();
		this.clave = clave;
		this.valor = valor;
	}
	
	public String getClave() {
		return clave;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	

}
