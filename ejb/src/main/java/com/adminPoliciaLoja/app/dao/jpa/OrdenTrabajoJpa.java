package com.adminPoliciaLoja.app.dao.jpa;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.adminPoliciaLoja.app.dao.inter.OrdenTrabajoDao;
import com.adminPoliciaLoja.app.entity.Ordentrabajo;

@Stateless
public class OrdenTrabajoJpa extends GenericJpaImp<Ordentrabajo> implements OrdenTrabajoDao  {
	
	public List<Ordentrabajo>  findByMantenimiento(Integer mantenimientoId){
		TypedQuery<Ordentrabajo> qr=em.createNamedQuery("Ordentrabajo.findByMantenimiento",Ordentrabajo.class);
		qr.setParameter(1, mantenimientoId);
		return qr.getResultList();
	}
}
