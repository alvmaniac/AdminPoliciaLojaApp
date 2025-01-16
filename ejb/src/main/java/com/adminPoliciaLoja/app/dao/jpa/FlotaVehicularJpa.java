package com.adminPoliciaLoja.app.dao.jpa;


import javax.ejb.Stateless;

import com.adminPoliciaLoja.app.dao.inter.FlotaVehicularDao;
import com.adminPoliciaLoja.app.entity.Flotavehicular;

@Stateless
public class FlotaVehicularJpa extends GenericJpaImp<Flotavehicular> implements FlotaVehicularDao  {
	
}
