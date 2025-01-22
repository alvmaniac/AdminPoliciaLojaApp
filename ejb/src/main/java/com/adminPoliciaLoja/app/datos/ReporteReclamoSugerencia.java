package com.adminPoliciaLoja.app.datos;

import java.io.Serializable;
import java.util.Date;

public class ReporteReclamoSugerencia implements Serializable {
	
	private static final long serialVersionUID = 6149774156661117334L;
	private int  total;
	private Date fechaIni;
	private Date fechaFin;
	private String  tipo;
	private String  circuito;
	private String  subcircuito;
	
	
	public ReporteReclamoSugerencia(int total, Date fechaIni, Date fechaFin, String tipo, String circuito,
			String subcircuito) {
		this.total = total;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.tipo = tipo;
		this.circuito = circuito;
		this.subcircuito = subcircuito;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return the fechaIni
	 */
	public Date getFechaIni() {
		return fechaIni;
	}
	/**
	 * @param fechaIni the fechaIni to set
	 */
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the circuito
	 */
	public String getCircuito() {
		return circuito;
	}
	/**
	 * @param circuito the circuito to set
	 */
	public void setCircuito(String circuito) {
		this.circuito = circuito;
	}
	/**
	 * @return the subcircuito
	 */
	public String getSubcircuito() {
		return subcircuito;
	}
	/**
	 * @param subcircuito the subcircuito to set
	 */
	public void setSubcircuito(String subcircuito) {
		this.subcircuito = subcircuito;
	}
}
