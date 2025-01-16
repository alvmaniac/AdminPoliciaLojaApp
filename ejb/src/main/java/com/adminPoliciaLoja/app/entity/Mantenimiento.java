package com.adminPoliciaLoja.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the Mantenimiento database table.
 * 
 */
@Entity
@NamedQuery(name="Mantenimiento.findAll", query="SELECT m FROM Mantenimiento m")
public class Mantenimiento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String estado;

	private String estadomantenimiento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechacita;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechacreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaentrega;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechamodif;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecharecepcion;

	private int kilometrajecita;

	private int kilometrajeentrega;

	private int kilometrajeproximarevicion;

	private int kilometrajerecepcion;

	private String observacionentrega;

	private String observacionrecepcion;

	private int tiempoestimado;

	private int tiemporeal;

	private String usercreacion;

	private String usermodif;

	//bi-directional many-to-one association to Flotavehicular
	@ManyToOne
	@JoinColumn(name="FlotavehicularID")
	private Flotavehicular flotavehicular;

	//bi-directional many-to-one association to Ordentrabajo
	@OneToMany(mappedBy="mantenimiento")
	private List<Ordentrabajo> ordentrabajos;

	public Mantenimiento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadomantenimiento() {
		return this.estadomantenimiento;
	}

	public void setEstadomantenimiento(String estadomantenimiento) {
		this.estadomantenimiento = estadomantenimiento;
	}

	public Date getFechacita() {
		return this.fechacita;
	}

	public void setFechacita(Date fechacita) {
		this.fechacita = fechacita;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechaentrega() {
		return this.fechaentrega;
	}

	public void setFechaentrega(Date fechaentrega) {
		this.fechaentrega = fechaentrega;
	}

	public Date getFechamodif() {
		return this.fechamodif;
	}

	public void setFechamodif(Date fechamodif) {
		this.fechamodif = fechamodif;
	}

	public Date getFecharecepcion() {
		return this.fecharecepcion;
	}

	public void setFecharecepcion(Date fecharecepcion) {
		this.fecharecepcion = fecharecepcion;
	}

	public int getKilometrajecita() {
		return this.kilometrajecita;
	}

	public void setKilometrajecita(int kilometrajecita) {
		this.kilometrajecita = kilometrajecita;
	}

	public int getKilometrajeentrega() {
		return this.kilometrajeentrega;
	}

	public void setKilometrajeentrega(int kilometrajeentrega) {
		this.kilometrajeentrega = kilometrajeentrega;
	}

	public int getKilometrajeproximarevicion() {
		return this.kilometrajeproximarevicion;
	}

	public void setKilometrajeproximarevicion(int kilometrajeproximarevicion) {
		this.kilometrajeproximarevicion = kilometrajeproximarevicion;
	}

	public int getKilometrajerecepcion() {
		return this.kilometrajerecepcion;
	}

	public void setKilometrajerecepcion(int kilometrajerecepcion) {
		this.kilometrajerecepcion = kilometrajerecepcion;
	}

	public String getObservacionentrega() {
		return this.observacionentrega;
	}

	public void setObservacionentrega(String observacionentrega) {
		this.observacionentrega = observacionentrega;
	}

	public String getObservacionrecepcion() {
		return this.observacionrecepcion;
	}

	public void setObservacionrecepcion(String observacionrecepcion) {
		this.observacionrecepcion = observacionrecepcion;
	}

	public int getTiempoestimado() {
		return this.tiempoestimado;
	}

	public void setTiempoestimado(int tiempoestimado) {
		this.tiempoestimado = tiempoestimado;
	}

	public int getTiemporeal() {
		return this.tiemporeal;
	}

	public void setTiemporeal(int tiemporeal) {
		this.tiemporeal = tiemporeal;
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

	public Flotavehicular getFlotavehicular() {
		return this.flotavehicular;
	}

	public void setFlotavehicular(Flotavehicular flotavehicular) {
		this.flotavehicular = flotavehicular;
	}

	public List<Ordentrabajo> getOrdentrabajos() {
		return this.ordentrabajos;
	}

	public void setOrdentrabajos(List<Ordentrabajo> ordentrabajos) {
		this.ordentrabajos = ordentrabajos;
	}

	public Ordentrabajo addOrdentrabajo(Ordentrabajo ordentrabajo) {
		getOrdentrabajos().add(ordentrabajo);
		ordentrabajo.setMantenimiento(this);

		return ordentrabajo;
	}

	public Ordentrabajo removeOrdentrabajo(Ordentrabajo ordentrabajo) {
		getOrdentrabajos().remove(ordentrabajo);
		ordentrabajo.setMantenimiento(null);

		return ordentrabajo;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Mantenimiento)) 
			return false;
		
		Mantenimiento other = (Mantenimiento) obj;
		return id == other.id;
	}

}