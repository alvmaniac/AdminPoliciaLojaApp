package com.adminPoliciaLoja.web.beans.dependencia;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.Dependencia;
import com.adminPoliciaLoja.app.entity.Usuario;
import com.adminPoliciaLoja.app.util.FechasUtil;
import com.adminPoliciaLoja.web.util.FacesContextUtil;



/**
 * @author Alvaro Montesdeoca
 *
 */
@ViewScoped
@Named
public class DependenciaListBean implements Serializable{
	
	private static final long serialVersionUID = 1921636528657484152L;
	private Dependencia dependencia;
	private List<Dependencia> dependencias;
	private String isActive;
	
	public DependenciaListBean() {
	}
	
	@PostConstruct
	public void ini() {
		try {
				this.dependencias= DaoFactory.getInstance().getDependenciaDao().findAll();
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
			this.dependencia.setUsermodif(user.getUser());
			this.dependencia.setFechamodif(FechasUtil.getDateTimeEcuador());
			this.dependencia.setEstado(this.isActive);
			DaoFactory.getInstance().getDependenciaDao().update(this.dependencia);
			FacesContextUtil.inicializarVista();
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
	}
	
	public String cargaDatos(){
		FacesContextUtil.setObjetoSession("DEPENDENCIA", this.dependencia);
		return "/admin/dependencia/nuevo";
	}
	
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the dependencia
	 */
	public Dependencia getDependencia() {
		return dependencia;
	}

	/**
	 * @param dependencia the dependencia to set
	 */
	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}

	/**
	 * @return the dependencias
	 */
	public List<Dependencia> getDependencias() {
		return dependencias;
	}

	/**
	 * @param dependencias the dependencias to set
	 */
	public void setDependencias(List<Dependencia> dependencias) {
		this.dependencias = dependencias;
	}

	
}
