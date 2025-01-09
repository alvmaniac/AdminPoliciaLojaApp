package com.adminPoliciaLoja.app.dao.jpa;


import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.adminPoliciaLoja.app.dao.inter.UsuarioDao;
import com.adminPoliciaLoja.app.entity.Usuario;


@Stateless
public class UsuarioJpa extends GenericJpaImp<Usuario> implements UsuarioDao  {
	
	public Usuario verificaMailExistente(String mail){
		TypedQuery<Usuario> qr =em.createNamedQuery("Usuario.findByEmail",Usuario.class);
		qr.setParameter(1, mail);
		Usuario usuario= null;
		int r= qr.getResultList().size();
		if(r==1) {
			usuario=(Usuario)qr.getSingleResult();
		}
		return usuario;
	}
	
	public Usuario verificaIdentificacionExistente(String ci) {
		TypedQuery<Usuario> qr =em.createNamedQuery("Usuario.findByCI",Usuario.class);
		qr.setParameter(1, ci);
		Usuario usuario= null;
		int r= qr.getResultList().size();
		if(r==1) {
			usuario=(Usuario)qr.getSingleResult();
		}
		return usuario;
	}
	
	
	
	
}
