package com.adminPoliciaLoja.app.dao.jpa;


import javax.ejb.Stateless;

import com.adminPoliciaLoja.app.dao.inter.OrdenTrabajoDao;
import com.adminPoliciaLoja.app.entity.Ordentrabajo;

@Stateless
public class OrdenTrabajoJpa extends GenericJpaImp<Ordentrabajo> implements OrdenTrabajoDao  {
	
}
