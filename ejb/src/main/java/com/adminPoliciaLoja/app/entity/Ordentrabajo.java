package com.adminPoliciaLoja.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;


/**
 * The persistent class for the Ordentrabajo database table.
 * 
 */
@Entity
@NamedQuery(name="Ordentrabajo.findAll", query="SELECT o FROM Ordentrabajo o")
public class Ordentrabajo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private int cantidad;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechacreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechamodif;

	private BigDecimal impuesto;

	private String novedad;

	private BigDecimal porcentaje;

	private String usercreacion;

	private String usermodif;

	private BigDecimal valortotal;

	private BigDecimal valorunitario;

	//bi-directional many-to-one association to Mantenimiento
	@ManyToOne
	@JoinColumn(name="MantenimientoID")
	private Mantenimiento mantenimiento;

	//bi-directional many-to-one association to Serviciosrepuesto
	@ManyToOne
	@JoinColumn(name="ServiciosrepuestosID")
	private Serviciosrepuesto serviciosrepuesto;

	public Ordentrabajo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public BigDecimal getImpuesto() {
		return this.impuesto;
	}

	public void setImpuesto(BigDecimal impuesto) {
		this.impuesto = impuesto;
	}

	public String getNovedad() {
		return this.novedad;
	}

	public void setNovedad(String novedad) {
		this.novedad = novedad;
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

	public BigDecimal getValortotal() {
		return this.valortotal;
	}

	public void setValortotal(BigDecimal valortotal) {
		this.valortotal = valortotal;
	}

	public BigDecimal getValorunitario() {
		return this.valorunitario;
	}

	public void setValorunitario(BigDecimal valorunitario) {
		this.valorunitario = valorunitario;
	}

	public Mantenimiento getMantenimiento() {
		return this.mantenimiento;
	}

	public void setMantenimiento(Mantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	public Serviciosrepuesto getServiciosrepuesto() {
		return this.serviciosrepuesto;
	}

	public void setServiciosrepuesto(Serviciosrepuesto serviciosrepuesto) {
		this.serviciosrepuesto = serviciosrepuesto;
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
		if (!(obj instanceof Ordentrabajo)) 
			return false;
		
		Ordentrabajo other = (Ordentrabajo) obj;
		return id == other.id;
	}

}