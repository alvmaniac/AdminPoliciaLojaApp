package com.adminPoliciaLoja.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the Tipovehiculo database table.
 * 
 */
@Entity
@NamedQuery(name="Tipovehiculo.findAll", query="SELECT t FROM Tipovehiculo t")
public class Tipovehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Flotavehicular
	@OneToMany(mappedBy="tipovehiculo")
	private List<Flotavehicular> flotavehiculars;

	public Tipovehiculo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Flotavehicular> getFlotavehiculars() {
		return this.flotavehiculars;
	}

	public void setFlotavehiculars(List<Flotavehicular> flotavehiculars) {
		this.flotavehiculars = flotavehiculars;
	}

	public Flotavehicular addFlotavehicular(Flotavehicular flotavehicular) {
		getFlotavehiculars().add(flotavehicular);
		flotavehicular.setTipovehiculo(this);

		return flotavehicular;
	}

	public Flotavehicular removeFlotavehicular(Flotavehicular flotavehicular) {
		getFlotavehiculars().remove(flotavehicular);
		flotavehicular.setTipovehiculo(null);

		return flotavehicular;
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
		if (!(obj instanceof Tipovehiculo)) 
			return false;
		Tipovehiculo other = (Tipovehiculo) obj;
		return id == other.id;
	}

}