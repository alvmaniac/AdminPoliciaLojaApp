package com.adminPoliciaLoja.web.beans.flota;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.Flotavehicular;
import com.adminPoliciaLoja.app.entity.Usuario;
import com.adminPoliciaLoja.app.util.FechasUtil;
import com.adminPoliciaLoja.web.util.FacesContextUtil;



/**
 * @author Alvaro Montesdeoca
 *
 */
@ViewScoped
@Named
public class FlotaVehicularListBean implements Serializable{

	private static final long serialVersionUID = 8746939127882703127L;
	private Flotavehicular flota;
	private List<Flotavehicular> flotas;
	private String isActive;
	
	public FlotaVehicularListBean() {
	}
	
	@PostConstruct
	public void ini() {
		try {
				this.flotas= DaoFactory.getInstance().getFlotaVehicularDao().findAll();
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
			Usuario user=(Usuario)FacesContextUtil.getObjetoSession("user");
			this.flota.setUsermodif(user.getUser());
			this.flota.setFechamodif(FechasUtil.getDateTimeEcuador());
			this.flota.setEstado(this.isActive);
			DaoFactory.getInstance().getFlotaVehicularDao().update(this.flota);
			FacesContextUtil.inicializarVista();
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
	}
	
	public String cargaDatos(){
		FacesContextUtil.setObjetoSession("FLOTA_VEHICULAR", this.flota);
		return "/admin/flota/nuevo";
	}
	
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	/**
	 * @return the flota
	 */
	public Flotavehicular getFlota() {
		return flota;
	}

	/**
	 * @param flota the flota to set
	 */
	public void setFlota(Flotavehicular flota) {
		this.flota = flota;
	}

	/**
	 * @return the flotas
	 */
	public List<Flotavehicular> getFlotas() {
		return flotas;
	}

	/**
	 * @param flotas the flotas to set
	 */
	public void setFlotas(List<Flotavehicular> flotas) {
		this.flotas = flotas;
	}


	
}
