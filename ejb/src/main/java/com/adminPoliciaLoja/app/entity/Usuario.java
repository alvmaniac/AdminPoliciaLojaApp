package com.adminPoliciaLoja.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Usuario database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Usuario.findByEmail", query="select o from Usuario o where o.personalpolicial.email =?1"),
	@NamedQuery(name="Usuario.findByCI", query="select o from Usuario o where o.personalpolicial.cedula =?1")})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String clave;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechacreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechamodif;

	private String nombreapellido;
	
	private String claveTemporal;
	
	private int loginFallido;

	private String user;

	private String usercreacion;

	private String usermodif;

	//bi-directional many-to-one association to Personalpolicial
	@ManyToOne
	@JoinColumn(name="PersonalpolicialID")
	private Personalpolicial personalpolicial;

	//bi-directional many-to-one association to Rol
	@ManyToOne
	@JoinColumn(name="RolID")
	private Rol rol;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public String getNombreapellido() {
		return this.nombreapellido;
	}

	public void setNombreapellido(String nombreapellido) {
		this.nombreapellido = nombreapellido;
	}

	public String getClaveTemporal() {
		return claveTemporal;
	}

	public void setClaveTemporal(String claveTemporal) {
		this.claveTemporal = claveTemporal;
	}

	public int getLoginFallido() {
		return loginFallido;
	}

	public void setLoginFallido(int loginFallido) {
		this.loginFallido = loginFallido;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
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

	public Personalpolicial getPersonalpolicial() {
		return this.personalpolicial;
	}

	public void setPersonalpolicial(Personalpolicial personalpolicial) {
		this.personalpolicial = personalpolicial;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}