package com.adminPoliciaLoja.app.dao.jpa;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.adminPoliciaLoja.app.dao.inter.DependenciaDao;
import com.adminPoliciaLoja.app.entity.Dependencia;

@Stateless
public class DependenciaJpa extends GenericJpaImp<Dependencia> implements DependenciaDao  {
	
	
	public List<String> allCircuitos(){
		TypedQuery<String> qr =em.createNamedQuery("Dependencia.findAllCircuitos",String.class);
		List<String> circuitos = qr.getResultList();
		return circuitos;
	}
	
	public List<Dependencia> findSubCurcuitos(String circuito){
		TypedQuery<Dependencia> qr =em.createNamedQuery("Dependencia.findByCircuito",Dependencia.class);
		qr.setParameter(1, circuito);
		List<Dependencia> subcircuitos = qr.getResultList();
		return subcircuitos;
	}
	
	
}
