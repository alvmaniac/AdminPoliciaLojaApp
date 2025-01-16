package com.adminPoliciaLoja.app.dao.jpa;


import javax.ejb.Stateless;

import com.adminPoliciaLoja.app.dao.inter.ServiciosRepuestoDao;
import com.adminPoliciaLoja.app.entity.Serviciosrepuesto;

@Stateless
public class ServiciosRepuestoJpa extends GenericJpaImp<Serviciosrepuesto> implements ServiciosRepuestoDao  {
	
}
