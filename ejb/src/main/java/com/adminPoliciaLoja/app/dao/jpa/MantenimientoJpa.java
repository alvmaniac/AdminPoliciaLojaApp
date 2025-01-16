package com.adminPoliciaLoja.app.dao.jpa;


import javax.ejb.Stateless;

import com.adminPoliciaLoja.app.dao.inter.MantenimientoDao;
import com.adminPoliciaLoja.app.entity.Mantenimiento;

@Stateless
public class MantenimientoJpa extends GenericJpaImp<Mantenimiento> implements MantenimientoDao  {
	
}
