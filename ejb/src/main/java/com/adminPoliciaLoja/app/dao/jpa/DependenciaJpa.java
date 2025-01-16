package com.adminPoliciaLoja.app.dao.jpa;


import javax.ejb.Stateless;

import com.adminPoliciaLoja.app.dao.inter.DependenciaDao;
import com.adminPoliciaLoja.app.entity.Dependencia;

@Stateless
public class DependenciaJpa extends GenericJpaImp<Dependencia> implements DependenciaDao  {
	
}
