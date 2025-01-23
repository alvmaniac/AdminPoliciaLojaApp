package com.adminPoliciaLoja.app.dao.jpa;


import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.adminPoliciaLoja.app.dao.inter.MantenimientoDao;
import com.adminPoliciaLoja.app.entity.Mantenimiento;

@Stateless
public class MantenimientoJpa extends GenericJpaImp<Mantenimiento> implements MantenimientoDao  {
	public List<Mantenimiento> proximoMantenimiento (Date fechaIni, Date fechaFin){
		TypedQuery<Mantenimiento> qr=em.createNamedQuery("Mantenimiento.proximoMantenimiento",Mantenimiento.class);
		qr.setParameter(1, fechaIni);
		qr.setParameter(2, fechaFin);
		return qr.getResultList();
		
	}
}
