package com.adminPoliciaLoja.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the Dependencia database table.
 * 
 */
@Entity
@NamedQuery(name="Dependencia.findAll", query="SELECT d FROM Dependencia d")
public class Dependencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String codcircuito;

	private String coddistritos;

	private String codsubcircuitos;

	private String estado;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechacreacion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechamodif;

	private String nocircuitos;

	private String nodistritos;

	private String nombrecircuito;

	private String nombredistrito;

	private String nombresubcircuitos;

	private String nosubcircuitos;

	private String parroquia;

	private String provincia;

	private String usercreacion;

	private String usermodif;

	//bi-directional many-to-one association to Flotavehicular
	@OneToMany(mappedBy="dependencia")
	private List<Flotavehicular> flotavehiculars;

	//bi-directional many-to-one association to Personalpolicial
	@OneToMany(mappedBy="dependencia")
	private List<Personalpolicial> personalpolicials;

	public Dependencia() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodcircuito() {
		return this.codcircuito;
	}

	public void setCodcircuito(String codcircuito) {
		this.codcircuito = codcircuito;
	}

	public String getCoddistritos() {
		return this.coddistritos;
	}

	public void setCoddistritos(String coddistritos) {
		this.coddistritos = coddistritos;
	}

	public String getCodsubcircuitos() {
		return this.codsubcircuitos;
	}

	public void setCodsubcircuitos(String codsubcircuitos) {
		this.codsubcircuitos = codsubcircuitos;
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

	public String getNocircuitos() {
		return this.nocircuitos;
	}

	public void setNocircuitos(String nocircuitos) {
		this.nocircuitos = nocircuitos;
	}

	public String getNodistritos() {
		return this.nodistritos;
	}

	public void setNodistritos(String nodistritos) {
		this.nodistritos = nodistritos;
	}

	public String getNombrecircuito() {
		return this.nombrecircuito;
	}

	public void setNombrecircuito(String nombrecircuito) {
		this.nombrecircuito = nombrecircuito;
	}

	public String getNombredistrito() {
		return this.nombredistrito;
	}

	public void setNombredistrito(String nombredistrito) {
		this.nombredistrito = nombredistrito;
	}

	public String getNombresubcircuitos() {
		return this.nombresubcircuitos;
	}

	public void setNombresubcircuitos(String nombresubcircuitos) {
		this.nombresubcircuitos = nombresubcircuitos;
	}

	public String getNosubcircuitos() {
		return this.nosubcircuitos;
	}

	public void setNosubcircuitos(String nosubcircuitos) {
		this.nosubcircuitos = nosubcircuitos;
	}

	public String getParroquia() {
		return this.parroquia;
	}

	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
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
		flotavehicular.setDependencia(this);

		return flotavehicular;
	}

	public Flotavehicular removeFlotavehicular(Flotavehicular flotavehicular) {
		getFlotavehiculars().remove(flotavehicular);
		flotavehicular.setDependencia(null);

		return flotavehicular;
	}

	public List<Personalpolicial> getPersonalpolicials() {
		return this.personalpolicials;
	}

	public void setPersonalpolicials(List<Personalpolicial> personalpolicials) {
		this.personalpolicials = personalpolicials;
	}

	public Personalpolicial addPersonalpolicial(Personalpolicial personalpolicial) {
		getPersonalpolicials().add(personalpolicial);
		personalpolicial.setDependencia(this);

		return personalpolicial;
	}

	public Personalpolicial removePersonalpolicial(Personalpolicial personalpolicial) {
		getPersonalpolicials().remove(personalpolicial);
		personalpolicial.setDependencia(null);

		return personalpolicial;
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
		if (!(obj instanceof Dependencia)) 
			return false;
		Dependencia other = (Dependencia) obj;
		return id == other.id;
	}

}