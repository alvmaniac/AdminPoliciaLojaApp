package com.adminPoliciaLoja.app.dao.inter;

import javax.ejb.Remote;

import com.adminPoliciaLoja.app.entity.Serviciosrepuesto;
@Remote
public interface ServiciosRepuestoDao extends GenericDaoInter<Serviciosrepuesto>{
	public Serviciosrepuesto consultaProductoXNombre(String nombre);

}
