package com.adminPoliciaLoja.app.dao.inter;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import com.adminPoliciaLoja.app.entity.Mantenimiento;
@Remote
public interface MantenimientoDao extends GenericDaoInter<Mantenimiento>{
	
	public List<Mantenimiento> proximoMantenimiento (Date fechaIni, Date fechaFin);

}
