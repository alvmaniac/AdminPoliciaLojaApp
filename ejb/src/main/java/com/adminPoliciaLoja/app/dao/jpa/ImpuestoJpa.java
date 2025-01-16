package com.adminPoliciaLoja.app.dao.jpa;


import javax.ejb.Stateless;

import com.adminPoliciaLoja.app.dao.inter.ImpuestoDao;
import com.adminPoliciaLoja.app.entity.Impuesto;

@Stateless
public class ImpuestoJpa extends GenericJpaImp<Impuesto> implements ImpuestoDao  {
	
}
