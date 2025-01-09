package com.adminPoliciaLoja.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Personalpolicial database table.
 * 
 */
@Entity
@NamedQuery(name="Personalpolicial.findAll", query="SELECT p FROM Personalpolicial p")
public class Personalpolicial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String cedula;

	private String codpolicial;

	private String direccion;

	private String email;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechacreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechamodif;

	@Temporal(TemporalType.DATE)
	private Date fechanacimiento;

	private String nombreapellido;

	private String telcelular;

	private String tiposangre;

	private String usercreacion;

	private String usermodif;

	//bi-directional many-to-one association to Flotavehicular
	@OneToMany(mappedBy="personalpolicial")
	private List<Flotavehicular> flotavehiculars;

	//bi-directional many-to-one association to Ordenmovilizacion
	@OneToMany(mappedBy="personalpolicial")
	private List<Ordenmovilizacion> ordenmovilizacions;

	//bi-directional many-to-one association to Dependencia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DependenciaID")
	private Dependencia dependencia;

	//bi-directional many-to-one association to Rangopolicial
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RangopolicialID")
	private Rangopolicial rangopolicial;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="personalpolicial")
	private List<Usuario> usuarios;

	public Personalpolicial() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCodpolicial() {
		return this.codpolicial;
	}

	public void setCodpolicial(String codpolicial) {
		this.codpolicial = codpolicial;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public Date getFechanacimiento() {
		return this.fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getNombreapellido() {
		return this.nombreapellido;
	}

	public void setNombreapellido(String nombreapellido) {
		this.nombreapellido = nombreapellido;
	}

	public String getTelcelular() {
		return this.telcelular;
	}

	public void setTelcelular(String telcelular) {
		this.telcelular = telcelular;
	}

	public String getTiposangre() {
		return this.tiposangre;
	}

	public void setTiposangre(String tiposangre) {
		this.tiposangre = tiposangre;
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

	public List<Flotavehicular> getFlotavehiculars() {
		return this.flotavehiculars;
	}

	public void setFlotavehiculars(List<Flotavehicular> flotavehiculars) {
		this.flotavehiculars = flotavehiculars;
	}

	public Flotavehicular addFlotavehicular(Flotavehicular flotavehicular) {
		getFlotavehiculars().add(flotavehicular);
		flotavehicular.setPersonalpolicial(this);

		return flotavehicular;
	}

	public Flotavehicular removeFlotavehicular(Flotavehicular flotavehicular) {
		getFlotavehiculars().remove(flotavehicular);
		flotavehicular.setPersonalpolicial(null);

		return flotavehicular;
	}

	public List<Ordenmovilizacion> getOrdenmovilizacions() {
		return this.ordenmovilizacions;
	}

	public void setOrdenmovilizacions(List<Ordenmovilizacion> ordenmovilizacions) {
		this.ordenmovilizacions = ordenmovilizacions;
	}

	public Ordenmovilizacion addOrdenmovilizacion(Ordenmovilizacion ordenmovilizacion) {
		getOrdenmovilizacions().add(ordenmovilizacion);
		ordenmovilizacion.setPersonalpolicial(this);

		return ordenmovilizacion;
	}

	public Ordenmovilizacion removeOrdenmovilizacion(Ordenmovilizacion ordenmovilizacion) {
		getOrdenmovilizacions().remove(ordenmovilizacion);
		ordenmovilizacion.setPersonalpolicial(null);

		return ordenmovilizacion;
	}

	public Dependencia getDependencia() {
		return this.dependencia;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}

	public Rangopolicial getRangopolicial() {
		return this.rangopolicial;
	}

	public void setRangopolicial(Rangopolicial rangopolicial) {
		this.rangopolicial = rangopolicial;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setPersonalpolicial(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setPersonalpolicial(null);

		return usuario;
	}

}