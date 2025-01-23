package com.adminPoliciaLoja.web.beans.flota;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.Dependencia;
import com.adminPoliciaLoja.app.entity.Flotavehicular;
import com.adminPoliciaLoja.app.entity.Personalpolicial;
import com.adminPoliciaLoja.app.entity.Tipovehiculo;
import com.adminPoliciaLoja.app.entity.Usuario;
import com.adminPoliciaLoja.app.util.FechasUtil;
import com.adminPoliciaLoja.web.util.FacesContextUtil;

/**
 * @author Alvaro Montesdeoca
 */
@ViewScoped
@Named
public class FlotaVehicularBean implements Serializable{
	
	private static final long serialVersionUID = -2726393206062515891L;
	private Usuario user;
	private Flotavehicular flota;
	private boolean isUpdate=false;
	
	private Tipovehiculo tipoVehiculo;
	private Dependencia dependencia;
	private Personalpolicial policia;
	private List<Tipovehiculo>  tipoVehiculos;
	private List<Dependencia>  dependencias;
	private List<Personalpolicial>  policias;
	
	public FlotaVehicularBean() {
	}
	
	@PostConstruct
	public void ini() {
		this.user=(Usuario)FacesContextUtil.getObjetoSession("user");
		this.flota=(Flotavehicular)FacesContextUtil.getObjetoSession("FLOTA_VEHICULAR");
		FacesContextUtil.eliminarObjetoSession("FLOTA_VEHICULAR");
		try {
			this.tipoVehiculos=DaoFactory.getInstance().getTipoVehiculoDao().findAll();
			this.dependencias=DaoFactory.getInstance().getDependenciaDao().findAll();
			this.policias=DaoFactory.getInstance().getPersonalPolicialDao().findAll();
			if (this.flota!=null) {
				inicializaUpdate();
			}else {
				inicializa();
			}
		} catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
		
	}
	
	public void inicializa(){
		this.setFlota(new Flotavehicular());
		this.setIsUpdate(false);
		this.setPolicia(new Personalpolicial());
		this.setDependencia(new Dependencia());
		this.setTipoVehiculo(new Tipovehiculo());
	}
	
	public void inicializaUpdate(){
		this.isUpdate=true;
		this.tipoVehiculo=this.flota.getTipovehiculo();
		this.dependencia=this.flota.getDependencia();
		this.policia=this.flota.getPersonalpolicial();
	}

	public String ingresa(){
		try {
			this.flota.setTipovehiculo(this.tipoVehiculo);
			this.flota.setPersonalpolicial(this.policia);
			this.flota.setDependencia(this.dependencia);
			this.flota.setEstado("ACTIVO");
			this.flota.setUsercreacion(this.user.getUser());
			this.flota.setFechacreacion(FechasUtil.getDateTimeEcuador());
			DaoFactory.getInstance().getFlotaVehicularDao().save(this.flota);
			
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}catch (Exception e) {
			FacesContextUtil.addError(e.getMessage());
		}
		
		return navegaList();
	}
	
	public String  navegaList(){
		return "/admin/flota/flotaList";
	}
	
	public String  modificar(){
		try {
			this.flota.setTipovehiculo(this.tipoVehiculo);
			this.flota.setPersonalpolicial(this.policia);
			this.flota.setDependencia(this.dependencia);
			this.flota.setUsermodif(user.getUser());
			this.flota.setFechamodif(FechasUtil.getDateTimeEcuador());
			DaoFactory.getInstance().getFlotaVehicularDao().update(this.flota);
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
	 * @return the tipoVehiculo
	 */
	public Tipovehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	/**
	 * @param tipoVehiculo the tipoVehiculo to set
	 */
	public void setTipoVehiculo(Tipovehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	/**
	 * @return the policia
	 */
	public Personalpolicial getPolicia() {
		return policia;
	}

	/**
	 * @param policia the policia to set
	 */
	public void setPolicia(Personalpolicial policia) {
		this.policia = policia;
	}

	/**
	 * @return the tipoVehiculos
	 */
	public List<Tipovehiculo> getTipoVehiculos() {
		return tipoVehiculos;
	}

	/**
	 * @param tipoVehiculos the tipoVehiculos to set
	 */
	public void setTipoVehiculos(List<Tipovehiculo> tipoVehiculos) {
		this.tipoVehiculos = tipoVehiculos;
	}

	/**
	 * @return the policias
	 */
	public List<Personalpolicial> getPolicias() {
		return policias;
	}

	/**
	 * @param policias the policias to set
	 */
	public void setPolicias(List<Personalpolicial> policias) {
		this.policias = policias;
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
