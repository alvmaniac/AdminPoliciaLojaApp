package com.adminPoliciaLoja.app.dao.jpa;


import javax.ejb.Stateless;

import com.adminPoliciaLoja.app.dao.inter.RolDao;
import com.adminPoliciaLoja.app.entity.Rol;

@Stateless
public class RolJpa extends GenericJpaImp<Rol> implements RolDao  {
	
}
