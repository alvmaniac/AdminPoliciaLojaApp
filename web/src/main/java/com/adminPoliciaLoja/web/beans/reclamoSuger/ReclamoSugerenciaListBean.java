package com.adminPoliciaLoja.web.beans.reclamoSuger;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.datos.ReporteReclamoSugerencia;
import com.adminPoliciaLoja.app.util.DateUtil;
import com.adminPoliciaLoja.web.util.FacesContextUtil;



/**
 * @author Alvaro Montesdeoca
 *
 */
@ViewScoped
@Named
public class ReclamoSugerenciaListBean implements Serializable{

	private static final long serialVersionUID = -3971771374214389364L;
	private Date fechaIni;
	private Date fechaFin;
	private List<ReporteReclamoSugerencia> rep;
	
	public ReclamoSugerenciaListBean() {
	}
	
	@PostConstruct
	public void ini() {
		
	}
	
	public void cargaReporte(){
		try {
			this.rep= DaoFactory.getInstance().getReclamoSugerenciaDao().recuperaReporteDate(this.fechaIni, DateUtil.addHours(this.fechaFin, 24));
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
	}

	/**
	 * @return the fechaIni
	 */
	public Date getFechaIni() {
		return fechaIni;
	}

	/**
	 * @param fechaIni the fechaIni to set
	 */
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the rep
	 */
	public List<ReporteReclamoSugerencia> getRep() {
		return rep;
	}

	/**
	 * @param rep the rep to set
	 */
	public void setRep(List<ReporteReclamoSugerencia> rep) {
		this.rep = rep;
	}

	
}
