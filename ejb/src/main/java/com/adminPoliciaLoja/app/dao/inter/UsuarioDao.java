package com.adminPoliciaLoja.app.dao.inter;

import javax.ejb.Remote;

import com.adminPoliciaLoja.app.entity.Usuario;
@Remote
public interface UsuarioDao extends GenericDaoInter<Usuario>{
	public Usuario verificaMailExistente(String mail);
	public Usuario verificaIdentificacionExistente(String ci);

}
