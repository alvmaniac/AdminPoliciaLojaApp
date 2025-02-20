package com.adminPoliciaLoja.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


/**
 * The persistent class for the RegistroEntradaSalida database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="RegistroEntradaSalida.findByEmail", query="select o from RegistroEntradaSalida o where o.personalpolicial.email =?1"),
	@NamedQuery(name="RegistroEntradaSalida.findByCI", query="select o from RegistroEntradaSalida o where o.personalpolicial.cedula =?1")})
public class RegistroEntradaSalida implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	

	//bi-directional many-to-one association to Personalpolicial
	@ManyToOne
	@JoinColumn(name="PersonalpolicialID")
	private Personalpolicial personalpolicial;

	
	public RegistroEntradaSalida() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
		if (!(obj instanceof Rol)) 
			return false;
		
		RegistroEntradaSalida other = (RegistroEntradaSalida) obj;
		return id == other.id;
	}

}