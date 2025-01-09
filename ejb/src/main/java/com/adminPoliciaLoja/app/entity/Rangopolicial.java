package com.adminPoliciaLoja.app.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Rangopolicial database table.
 * 
 */
@Entity
@NamedQuery(name="Rangopolicial.findAll", query="SELECT r FROM Rangopolicial r")
public class Rangopolicial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Personalpolicial
	@OneToMany(mappedBy="rangopolicial")
	private List<Personalpolicial> personalpolicials;

	public Rangopolicial() {
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

	public List<Personalpolicial> getPersonalpolicials() {
		return this.personalpolicials;
	}

	public void setPersonalpolicials(List<Personalpolicial> personalpolicials) {
		this.personalpolicials = personalpolicials;
	}

	public Personalpolicial addPersonalpolicial(Personalpolicial personalpolicial) {
		getPersonalpolicials().add(personalpolicial);
		personalpolicial.setRangopolicial(this);

		return personalpolicial;
	}

	public Personalpolicial removePersonalpolicial(Personalpolicial personalpolicial) {
		getPersonalpolicials().remove(personalpolicial);
		personalpolicial.setRangopolicial(null);

		return personalpolicial;
	}

}