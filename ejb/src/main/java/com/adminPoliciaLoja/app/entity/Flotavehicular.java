package com.adminPoliciaLoja.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Flotavehicular database table.
 * 
 */
@Entity
@NamedQuery(name="Flotavehicular.findAll", query="SELECT f FROM Flotavehicular f")
public class Flotavehicular implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private int anio;

	private String color;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechacreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechamodif;

	private String modelo;

	private String placa;

	private String usercreacion;

	private String usermodif;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DependenciaID")
	private Dependencia dependencia;

	//bi-directional many-to-one association to Personalpolicial
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PersonalpolicialID")
	private Personalpolicial personalpolicial;

	//bi-directional many-to-one association to Tipovehiculo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TipovehiculoID")
	private Tipovehiculo tipovehiculo;

	//bi-directional many-to-one association to Mantenimiento
	@OneToMany(mappedBy="flotavehicular")
	private List<Mantenimiento> mantenimientos;

	//bi-directional many-to-one association to Ordenmovilizacion
	@OneToMany(mappedBy="flotavehicular")
	private List<Ordenmovilizacion> ordenmovilizacions;

	public Flotavehicular() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnio() {
		return this.anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechamodif() {
		return this.fechamodif;
	}

	public void setFechamodif(Date fechamodif) {
		this.fechamodif = fechamodif;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getUsercreacion() {
		return this.usercreacion;
	}

	public void setUsercreacion(String usercreacion) {
		this.usercreacion = usercreacion;
	}

	public String getUsermodif() {
		return this.usermodif;
	}

	public void setUsermodif(String usermodif) {
		this.usermodif = usermodif;
	}

	public Dependencia getDependencia() {
		return this.dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}

	public Personalpolicial getPersonalpolicial() {
		return this.personalpolicial;
	}

	public void setPersonalpolicial(Personalpolicial personalpolicial) {
		this.personalpolicial = personalpolicial;
	}

	public Tipovehiculo getTipovehiculo() {
		return this.tipovehiculo;
	}

	public void setTipovehiculo(Tipovehiculo tipovehiculo) {
		this.tipovehiculo = tipovehiculo;
	}

	public List<Mantenimiento> getMantenimientos() {
		return this.mantenimientos;
	}

	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

	public Mantenimiento addMantenimiento(Mantenimiento mantenimiento) {
		getMantenimientos().add(mantenimiento);
		mantenimiento.setFlotavehicular(this);

		return mantenimiento;
	}

	public Mantenimiento removeMantenimiento(Mantenimiento mantenimiento) {
		getMantenimientos().remove(mantenimiento);
		mantenimiento.setFlotavehicular(null);

		return mantenimiento;
	}

	public List<Ordenmovilizacion> getOrdenmovilizacions() {
		return this.ordenmovilizacions;
	}

	public void setOrdenmovilizacions(List<Ordenmovilizacion> ordenmovilizacions) {
		this.ordenmovilizacions = ordenmovilizacions;
	}

	public Ordenmovilizacion addOrdenmovilizacion(Ordenmovilizacion ordenmovilizacion) {
		getOrdenmovilizacions().add(ordenmovilizacion);
		ordenmovilizacion.setFlotavehicular(this);

		return ordenmovilizacion;
	}

	public Ordenmovilizacion removeOrdenmovilizacion(Ordenmovilizacion ordenmovilizacion) {
		getOrdenmovilizacions().remove(ordenmovilizacion);
		ordenmovilizacion.setFlotavehicular(null);

		return ordenmovilizacion;
	}

}