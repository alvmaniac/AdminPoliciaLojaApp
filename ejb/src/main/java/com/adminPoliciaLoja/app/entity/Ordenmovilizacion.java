package com.adminPoliciaLoja.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;


/**
 * The persistent class for the Ordenmovilizacion database table.
 * 
 */
@Entity
@NamedQuery(name="Ordenmovilizacion.findAll", query="SELECT o FROM Ordenmovilizacion o")
public class Ordenmovilizacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String estado;

	private String estadoorden;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechacreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechallegada;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechamodif;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecharetornollegada;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecharetornosalida;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechasalida;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechasolicitud;

	private Time horallegada;

	private Time horaretornollegada;

	private Time horaretornosalida;

	private Time horasalida;

	private int kilometrajeinicio;

	private String motivo;

	private String nombrepersonas;

	private String nombresolicitante;

	private int numeropersonas;

	private String ruta;

	private String usercreacion;

	private String usermodif;

	//bi-directional many-to-one association to Flotavehicular
	@ManyToOne
	@JoinColumn(name="FlotavehicularID")
	private Flotavehicular flotavehicular;

	//bi-directional many-to-one association to Personalpolicial
	@ManyToOne
	@JoinColumn(name="PersonalpolicialID")
	private Personalpolicial personalpolicial;

	public Ordenmovilizacion() {
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

	public String getEstadoorden() {
		return this.estadoorden;
	}

	public void setEstadoorden(String estadoorden) {
		this.estadoorden = estadoorden;
	}

	public Date getFechacreacion() {
		return this.fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public Date getFechallegada() {
		return this.fechallegada;
	}

	public void setFechallegada(Date fechallegada) {
		this.fechallegada = fechallegada;
	}

	public Date getFechamodif() {
		return this.fechamodif;
	}

	public void setFechamodif(Date fechamodif) {
		this.fechamodif = fechamodif;
	}

	public Date getFecharetornollegada() {
		return this.fecharetornollegada;
	}

	public void setFecharetornollegada(Date fecharetornollegada) {
		this.fecharetornollegada = fecharetornollegada;
	}

	public Date getFecharetornosalida() {
		return this.fecharetornosalida;
	}

	public void setFecharetornosalida(Date fecharetornosalida) {
		this.fecharetornosalida = fecharetornosalida;
	}

	public Date getFechasalida() {
		return this.fechasalida;
	}

	public void setFechasalida(Date fechasalida) {
		this.fechasalida = fechasalida;
	}

	public Date getFechasolicitud() {
		return this.fechasolicitud;
	}

	public void setFechasolicitud(Date fechasolicitud) {
		this.fechasolicitud = fechasolicitud;
	}

	public Time getHorallegada() {
		return this.horallegada;
	}

	public void setHorallegada(Time horallegada) {
		this.horallegada = horallegada;
	}

	public Time getHoraretornollegada() {
		return this.horaretornollegada;
	}

	public void setHoraretornollegada(Time horaretornollegada) {
		this.horaretornollegada = horaretornollegada;
	}

	public Time getHoraretornosalida() {
		return this.horaretornosalida;
	}

	public void setHoraretornosalida(Time horaretornosalida) {
		this.horaretornosalida = horaretornosalida;
	}

	public Time getHorasalida() {
		return this.horasalida;
	}

	public void setHorasalida(Time horasalida) {
		this.horasalida = horasalida;
	}

	public int getKilometrajeinicio() {
		return this.kilometrajeinicio;
	}

	public void setKilometrajeinicio(int kilometrajeinicio) {
		this.kilometrajeinicio = kilometrajeinicio;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getNombrepersonas() {
		return this.nombrepersonas;
	}

	public void setNombrepersonas(String nombrepersonas) {
		this.nombrepersonas = nombrepersonas;
	}

	public String getNombresolicitante() {
		return this.nombresolicitante;
	}

	public void setNombresolicitante(String nombresolicitante) {
		this.nombresolicitante = nombresolicitante;
	}

	public int getNumeropersonas() {
		return this.numeropersonas;
	}

	public void setNumeropersonas(int numeropersonas) {
		this.numeropersonas = numeropersonas;
	}

	public String getRuta() {
		return this.ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
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

	public Personalpolicial getPersonalpolicial() {
		return this.personalpolicial;
	}

	public void setPersonalpolicial(Personalpolicial personalpolicial) {
		this.personalpolicial = personalpolicial;
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
		if (!(obj instanceof Ordenmovilizacion)) 
			return false;
		
		Ordenmovilizacion other = (Ordenmovilizacion) obj;
		return id == other.id;
	}

}