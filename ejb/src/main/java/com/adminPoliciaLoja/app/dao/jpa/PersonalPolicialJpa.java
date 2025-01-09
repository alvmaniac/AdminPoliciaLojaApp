package com.adminPoliciaLoja.app.dao.jpa;


import javax.ejb.Stateless;

import com.adminPoliciaLoja.app.dao.inter.PersonalPolicialDao;
import com.adminPoliciaLoja.app.entity.Personalpolicial;

@Stateless
public class PersonalPolicialJpa extends GenericJpaImp<Personalpolicial> implements PersonalPolicialDao  {
	
}
