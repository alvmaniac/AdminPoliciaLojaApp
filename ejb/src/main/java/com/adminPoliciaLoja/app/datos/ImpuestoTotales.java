package com.adminPoliciaLoja.app.datos;

import java.io.Serializable;
import java.math.BigDecimal;


public class ImpuestoTotales implements Serializable {
	
	private static final long serialVersionUID = 6149774156661117334L;
	private String  clave;
	private BigDecimal Valor;
	
	public ImpuestoTotales(String clave, BigDecimal valor) {
		this.clave = clave;
		this.Valor = valor;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public BigDecimal getValor() {
		return Valor;
	}
	public void setValor(BigDecimal valor) {
		Valor = valor;
	}
	
	
}
