package com.adminPoliciaLoja.web.beans.perPolicial;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.Dependencia;
import com.adminPoliciaLoja.app.entity.Personalpolicial;
import com.adminPoliciaLoja.app.entity.Rangopolicial;
import com.adminPoliciaLoja.app.entity.Usuario;
import com.adminPoliciaLoja.app.util.FechasUtil;
import com.adminPoliciaLoja.web.util.FacesContextUtil;

/**
 * @author Alvaro Montesdeoca
 */
@ViewScoped
@Named
public class PerPolicialBean implements Serializable{

	private static final long serialVersionUID = -4089965886299373966L;
	private Usuario user;
	private boolean isUpdate=false;
	private Rangopolicial rango;
	private Dependencia dependencia;
	private Personalpolicial perPolicial;
	private List<Rangopolicial>  rangos;
	private List<Dependencia>  dependencias;
	
	public PerPolicialBean() {
	}
	
	@PostConstruct
	public void ini() {
		this.user=(Usuario)FacesContextUtil.getObjetoSession("user");
		this.perPolicial=(Personalpolicial)FacesContextUtil.getObjetoSession("PER_POLICIAL");
		FacesContextUtil.eliminarObjetoSession("PER_POLICIAL");
		try {
			this.rangos=DaoFactory.getInstance().getRangoPolicialDao().findAll();
			this.dependencias=DaoFactory.getInstance().getDependenciaDao().findAll();
			if (this.perPolicial!=null) {
				inicializaUpdate();
			}else {
				inicializa();
			}
		} catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
		
	}
	
	public void inicializa(){
		this.setPerPolicial(new Personalpolicial());
		this.setIsUpdate(false);
		this.setRango(new Rangopolicial());
		this.setDependencia(new Dependencia());
	}
	
	public void inicializaUpdate(){
		this.isUpdate=true;
		this.rango=this.perPolicial.getRangopolicial();
		this.dependencia=this.perPolicial.getDependencia();
	}

	public String ingresa(){
		try {
			this.perPolicial.setRangopolicial(this.rango);
			this.perPolicial.setDependencia(this.dependencia);
			this.perPolicial.setEstado("ACTIVO");
			this.perPolicial.setUsercreacion(this.user.getUser());
			this.perPolicial.setFechacreacion(FechasUtil.getDateTimeEcuador());
			DaoFactory.getInstance().getPersonalPolicialDao().save(this.perPolicial);
			
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}catch (Exception e) {
			FacesContextUtil.addError(e.getMessage());
		}
		
		return navegaList();
	}
	
	public String  navegaList(){
		return "/admin/perPolicial/perPolicialList";
	}
	
	public String  modificar(){
		try {
			this.perPolicial.setRangopolicial(this.rango);
			this.perPolicial.setDependencia(this.dependencia);
			this.perPolicial.setUsermodif(user.getUser());
			this.perPolicial.setFechamodif(FechasUtil.getDateTimeEcuador());
			DaoFactory.getInstance().getPersonalPolicialDao().update(this.perPolicial);
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

	public Personalpolicial getPerPolicial() {
		return perPolicial;
	}

	public void setPerPolicial(Personalpolicial perPolicial) {
		this.perPolicial = perPolicial;
	}
	

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	/**
	 * @return the rango
	 */
	public Rangopolicial getRango() {
		return rango;
	}

	/**
	 * @param rango the rango to set
	 */
	public void setRango(Rangopolicial rango) {
		this.rango = rango;
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
	 * @return the rangos
	 */
	public List<Rangopolicial> getRangos() {
		return rangos;
	}

	/**
	 * @param rangos the rangos to set
	 */
	public void setRangos(List<Rangopolicial> rangos) {
		this.rangos = rangos;
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
