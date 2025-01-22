package com.adminPoliciaLoja.app.dao.jpa;


import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import com.adminPoliciaLoja.app.dao.inter.ReclamoSugerenciaDao;
import com.adminPoliciaLoja.app.datos.ReporteReclamoSugerencia;
import com.adminPoliciaLoja.app.entity.ReclamoSugerencia;

@Stateless
public class ReclamoSugerenciaJpa extends GenericJpaImp<ReclamoSugerencia> implements ReclamoSugerenciaDao  {
	
	@SuppressWarnings("unchecked") 
	public List<ReporteReclamoSugerencia> recuperaReporteDate(Date inicio, Date fin) {
		Query qr =em.createNativeQuery("SELECT COUNT(r.Id) as total, MIN(r.fechacreacion) as fechaIni, MAX(r.fechacreacion) as fechaFin, r.tipo as tipo, d.nombrecircuito as circuito, d.nombresubcircuitos as subcircuito FROM ReclamoSugerencia r, Dependencia d WHERE r.DependenciaID = d.Id AND r.fechacreacion BETWEEN ?1 AND ?2 GROUP BY r.tipo, r.tipo, d.nombrecircuito, d.nombresubcircuitos" , "ReporteReclamoSugerenciaMapping");
		qr.setParameter(1, inicio);
		qr.setParameter(2, fin);
		return (List<ReporteReclamoSugerencia>)qr.getResultList();
	}
}
