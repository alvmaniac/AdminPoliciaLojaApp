package com.adminPoliciaLoja.web.beans.mantenimiento;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
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
public class MantenimientoListBean implements Serializable{
	
	private static final long serialVersionUID = 1921636528657484152L;
	private Mantenimiento mantenimiento;
	private List<Mantenimiento> mantenimientos;
	private String isActive;
	
	public MantenimientoListBean() {
	}
	
	@PostConstruct
	public void ini() {
		try {
				this.mantenimientos= DaoFactory.getInstance().getMantenimientoDao().findAll();
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
	}
	
	public void cargaDatosActivInact(){
		FacesContext fc = FacesContext.getCurrentInstance();
	    Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	    this.isActive =  params.get("activ"); 
	}
	
	public void activarInactivar(){
		try {
			this.mantenimiento.setEstado(this.isActive);
			DaoFactory.getInstance().getMantenimientoDao().update(this.mantenimiento);
			FacesContextUtil.inicializarVista();
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
	}
	
	
	public String cargaDatos(){
		FacesContextUtil.setObjetoSession("MANTENIMIENTO", this.mantenimiento);
		return "/admin/mantenimiento/nuevo";
	}
	
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the mantenimiento
	 */
	public Mantenimiento getMantenimiento() {
		return mantenimiento;
	}

	/**
	 * @param mantenimiento the mantenimiento to set
	 */
	public void setMantenimiento(Mantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	/**
	 * @return the mantenimientos
	 */
	public List<Mantenimiento> getMantenimientos() {
		return mantenimientos;
	}

	/**
	 * @param mantenimientos the mantenimientos to set
	 */
	public void setMantenimientos(List<Mantenimiento> mantenimientos) {
		this.mantenimientos = mantenimientos;
	}

	
}
