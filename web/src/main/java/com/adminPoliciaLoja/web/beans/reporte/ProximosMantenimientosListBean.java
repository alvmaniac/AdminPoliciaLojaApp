package com.adminPoliciaLoja.web.beans.reporte;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.Mantenimiento;
import com.adminPoliciaLoja.web.util.FacesContextUtil;



/**
 * @author Alvaro Montesdeoca
 *
 */
@ViewScoped
@Named
public class ProximosMantenimientosListBean implements Serializable{

	private static final long serialVersionUID = -3971771374214389364L;
	private Date fechaIni;
	private Date fechaFin;
	private List<Mantenimiento> rep;
	
	public ProximosMantenimientosListBean() {
	}
	
	@PostConstruct
	public void ini() {
		
	}
	
	public void cargaReporte(){
		try {
			this.rep= DaoFactory.getInstance().getMantenimientoDao().proximoMantenimiento(this.fechaIni, this.fechaFin);
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
	public List<Mantenimiento> getRep() {
		return rep;
	}

	/**
	 * @param rep the rep to set
	 */
	public void setRep(List<Mantenimiento> rep) {
		this.rep = rep;
	}

	
}
