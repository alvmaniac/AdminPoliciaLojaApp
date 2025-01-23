package com.adminPoliciaLoja.app.dao.inter;

import java.util.List;

import javax.ejb.Remote;

import com.adminPoliciaLoja.app.entity.Ordentrabajo;
@Remote
public interface OrdenTrabajoDao extends GenericDaoInter<Ordentrabajo>{
	
	public List<Ordentrabajo>  findByMantenimiento(Integer mantenimientoId);

}
