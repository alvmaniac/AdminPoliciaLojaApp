package com.adminPoliciaLoja.app.dao.jpa;


import javax.ejb.Stateless;

import com.adminPoliciaLoja.app.dao.inter.RangoPolicialDao;
import com.adminPoliciaLoja.app.entity.Rangopolicial;

@Stateless
public class RangoPolicialJpa extends GenericJpaImp<Rangopolicial> implements RangoPolicialDao  {
	
}
