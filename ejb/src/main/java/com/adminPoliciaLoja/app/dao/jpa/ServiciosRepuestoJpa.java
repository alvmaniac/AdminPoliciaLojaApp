package com.adminPoliciaLoja.app.dao.jpa;


import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.adminPoliciaLoja.app.dao.inter.ServiciosRepuestoDao;
import com.adminPoliciaLoja.app.entity.Serviciosrepuesto;

@Stateless
public class ServiciosRepuestoJpa extends GenericJpaImp<Serviciosrepuesto> implements ServiciosRepuestoDao  {
	
	public Serviciosrepuesto consultaProductoXNombre(String nombre) {
		TypedQuery<Serviciosrepuesto> qr=em.createNamedQuery("Serviciosrepuesto.findProXNom",Serviciosrepuesto.class);
		qr.setParameter(1, nombre.trim());
		int size = qr.getResultList().size();
		Serviciosrepuesto p = null;
		if(size>=1) {
			p= (Serviciosrepuesto)qr.getResultList().get(0);
		}
		return p;
	}
	
}
