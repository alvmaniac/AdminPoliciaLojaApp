package com.adminPoliciaLoja.web.beans.perPolicial;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.Personalpolicial;
import com.adminPoliciaLoja.app.entity.Usuario;
import com.adminPoliciaLoja.app.util.FechasUtil;
import com.adminPoliciaLoja.web.util.FacesContextUtil;



/**
 * @author Alvaro Montesdeoca
 *
 */
@ViewScoped
@Named
public class PerPolicialListBean implements Serializable{
	
	private static final long serialVersionUID = 6605038940434652120L;
	private Personalpolicial perPolicial;
	private List<Personalpolicial> perPolicials;
	private String isActive;
	
	public PerPolicialListBean() {
	}
	
	@PostConstruct
	public void ini() {
		try {
				this.perPolicials= DaoFactory.getInstance().getPersonalPolicialDao().findAll();
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
			this.perPolicial.setUsermodif(user.getUser());
			this.perPolicial.setFechamodif(FechasUtil.getDateTimeEcuador());
			this.perPolicial.setEstado(this.isActive);
			DaoFactory.getInstance().getPersonalPolicialDao().update(this.perPolicial);
			FacesContextUtil.inicializarVista();
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
	}
	
	public String cargaDatos(){
		FacesContextUtil.setObjetoSession("PER_POLICIAL", this.perPolicial);
		return "/admin/perPolicial/nuevo";
	}
	
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the perPolicial
	 */
	public Personalpolicial getPerPolicial() {
		return perPolicial;
	}

	/**
	 * @param perPolicial the perPolicial to set
	 */
	public void setPerPolicial(Personalpolicial perPolicial) {
		this.perPolicial = perPolicial;
	}

	/**
	 * @return the perPolicials
	 */
	public List<Personalpolicial> getPerPolicials() {
		return perPolicials;
	}

	/**
	 * @param perPolicials the perPolicials to set
	 */
	public void setPerPolicials(List<Personalpolicial> perPolicials) {
		this.perPolicials = perPolicials;
	}

	
}
