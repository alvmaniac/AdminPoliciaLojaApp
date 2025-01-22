package com.adminPoliciaLoja.app.dao.inter;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import com.adminPoliciaLoja.app.datos.ReporteReclamoSugerencia;
import com.adminPoliciaLoja.app.entity.ReclamoSugerencia;
@Remote
public interface ReclamoSugerenciaDao extends GenericDaoInter<ReclamoSugerencia>{
	
	public List<ReporteReclamoSugerencia> recuperaReporteDate(Date inicio, Date fin);

}
