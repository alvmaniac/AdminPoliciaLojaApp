package com.adminPoliciaLoja.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the Impuesto database table.
 * 
 */
@Entity
@NamedQuery(name="Impuesto.findAll", query="SELECT i FROM Impuesto i")
public class Impuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechacreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechamodif;

	private String nombre;

	private BigDecimal porcentaje;

	private String usercreacion;

	private String usermodif;

	//bi-directional many-to-one association to Serviciosrepuesto
	@OneToMany(mappedBy="impuesto")
	private List<Serviciosrepuesto> serviciosrepuestos;

	public Impuesto() {
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(BigDecimal porcentaje) {
		this.porcentaje = porcentaje;
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

	public List<Serviciosrepuesto> getServiciosrepuestos() {
		return this.serviciosrepuestos;
	}

	public void setServiciosrepuestos(List<Serviciosrepuesto> serviciosrepuestos) {
		this.serviciosrepuestos = serviciosrepuestos;
	}

	public Serviciosrepuesto addServiciosrepuesto(Serviciosrepuesto serviciosrepuesto) {
		getServiciosrepuestos().add(serviciosrepuesto);
		serviciosrepuesto.setImpuesto(this);

		return serviciosrepuesto;
	}

	public Serviciosrepuesto removeServiciosrepuesto(Serviciosrepuesto serviciosrepuesto) {
		getServiciosrepuestos().remove(serviciosrepuesto);
		serviciosrepuesto.setImpuesto(null);

		return serviciosrepuesto;
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
		if (!(obj instanceof Impuesto)) 
			return false;
		
		Impuesto other = (Impuesto) obj;
		return id == other.id;
	}

}