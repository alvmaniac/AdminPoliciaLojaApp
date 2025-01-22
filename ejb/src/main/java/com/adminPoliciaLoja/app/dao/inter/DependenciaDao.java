package com.adminPoliciaLoja.app.dao.inter;

import java.util.List;

import javax.ejb.Remote;

import com.adminPoliciaLoja.app.entity.Dependencia;
@Remote
public interface DependenciaDao extends GenericDaoInter<Dependencia>{
	public List<String> allCircuitos();
	public List<Dependencia> findSubCurcuitos(String circuito);

}
