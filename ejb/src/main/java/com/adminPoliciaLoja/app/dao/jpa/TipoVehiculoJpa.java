package com.adminPoliciaLoja.app.dao.jpa;


import javax.ejb.Stateless;

import com.adminPoliciaLoja.app.dao.inter.TipoVehiculoDao;
import com.adminPoliciaLoja.app.entity.Tipovehiculo;

@Stateless
public class TipoVehiculoJpa extends GenericJpaImp<Tipovehiculo> implements TipoVehiculoDao  {
	
}
