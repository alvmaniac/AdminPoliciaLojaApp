package com.adminPoliciaLoja.web.beans.dependencia;

import java.io.Serializable;

import javax.annotation.PostConstruct;
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
 */
@ViewScoped
@Named
public class DependenciaBean implements Serializable{

	private static final long serialVersionUID = 3156233590497362592L;
	private Usuario user;
	private boolean isUpdate=false;
	private Dependencia dependencia;
	
	public DependenciaBean() {
	}
	
	@PostConstruct
	public void ini() {
		this.user=(Usuario)FacesContextUtil.getObjetoSession("user");
		this.dependencia=(Dependencia)FacesContextUtil.getObjetoSession("DEPENDENCIA");
		FacesContextUtil.eliminarObjetoSession("DEPENDENCIA");
		if (this.dependencia!=null) {
			inicializaUpdate();
		}else {
			inicializa();
		}
		
	}
	
	public void inicializa(){
		this.setDependencia(new Dependencia());
		this.setIsUpdate(false);
		FacesContextUtil.inicializarVista();
	}
	
	public void inicializaUpdate(){
		this.isUpdate=true;
	}

	public String ingresa(){
		try {
			this.dependencia.setEstado("ACTIVO");
			this.dependencia.setUsercreacion(this.user.getUser());
			this.dependencia.setFechacreacion(FechasUtil.getDateTimeEcuador());
			DaoFactory.getInstance().getDependenciaDao().save(this.dependencia);
			
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}catch (Exception e) {
			FacesContextUtil.addError(e.getMessage());
		}
		
		return navegaList();
	}
	
	public String  navegaList(){
		return "/admin/dependencia/dependenciaList";
	}
	
	public String  modificar(){
		try {
			this.dependencia.setUsermodif(user.getUser());
			this.dependencia.setFechamodif(FechasUtil.getDateTimeEcuador());
			DaoFactory.getInstance().getDependenciaDao().update(this.dependencia);
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
		return navegaList();
	}


	public boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(final boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
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

}
