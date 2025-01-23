package com.adminPoliciaLoja.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the Serviciosrepuestos database table.
 * 
 */
@Entity
@Table(name="Serviciosrepuestos")
@NamedQueries({
	@NamedQuery(name="Serviciosrepuesto.findAll", query="SELECT s FROM Serviciosrepuesto s"),
	@NamedQuery(name="Serviciosrepuesto.findProXNom", query="select o from Serviciosrepuesto o where o.nombre =?1")})
public class Serviciosrepuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private int cod;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechacreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechamodif;

	private String nombre;

	private String tipo;

	private String usercreacion;

	private String usermodif;

	private BigDecimal valor;

	//bi-directional many-to-one association to Ordentrabajo
	@OneToMany(mappedBy="serviciosrepuesto")
	private List<Ordentrabajo> ordentrabajos;

	//bi-directional many-to-one association to Impuesto
	@ManyToOne
	@JoinColumn(name="ImpuestoID")
	private Impuesto impuesto;

	public Serviciosrepuesto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCod() {
		return this.cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
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

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<Ordentrabajo> getOrdentrabajos() {
		return this.ordentrabajos;
	}

	public void setOrdentrabajos(List<Ordentrabajo> ordentrabajos) {
		this.ordentrabajos = ordentrabajos;
	}

	public Ordentrabajo addOrdentrabajo(Ordentrabajo ordentrabajo) {
		getOrdentrabajos().add(ordentrabajo);
		ordentrabajo.setServiciosrepuesto(this);

		return ordentrabajo;
	}

	public Ordentrabajo removeOrdentrabajo(Ordentrabajo ordentrabajo) {
		getOrdentrabajos().remove(ordentrabajo);
		ordentrabajo.setServiciosrepuesto(null);

		return ordentrabajo;
	}

	public Impuesto getImpuesto() {
		return this.impuesto;
	}

	public void setImpuesto(Impuesto impuesto) {
		this.impuesto = impuesto;
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
		if (!(obj instanceof Serviciosrepuesto)) 
			return false;
		
		Serviciosrepuesto other = (Serviciosrepuesto) obj;
		return id == other.id;
	}

}