package com.adminPoliciaLoja.web.beans.mantenimiento;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.Flotavehicular;
import com.adminPoliciaLoja.app.entity.Mantenimiento;
import com.adminPoliciaLoja.app.entity.Usuario;
import com.adminPoliciaLoja.app.util.FechasUtil;
import com.adminPoliciaLoja.web.util.FacesContextUtil;

/**
 * @author Alvaro Montesdeoca
 */
@ViewScoped
@Named
public class MantenimientoBean implements Serializable{

	private static final long serialVersionUID = 3156233590497362592L;
	private Usuario user;
	private boolean isUpdate=false;
	private Mantenimiento mantenimiento;
	private Flotavehicular  flota;
	private List<Flotavehicular>  flotas;
	
	public MantenimientoBean() {
	}
	
	@PostConstruct
	public void ini() {
		this.user=(Usuario)FacesContextUtil.getObjetoSession("user");
		this.mantenimiento=(Mantenimiento)FacesContextUtil.getObjetoSession("MANTENIMIENTO");
		FacesContextUtil.eliminarObjetoSession("MANTENIMIENTO");
		try {
			this.setFlotas(DaoFactory.getInstance().getFlotaVehicularDao().findAll());
			if (this.mantenimiento!=null) {
				inicializaUpdate();
			}else {
				inicializa();
			}
		} catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
		
	}
	
	public void inicializa(){
		this.setMantenimiento(new Mantenimiento());
		this.setIsUpdate(false);
		this.setFlota(new Flotavehicular());
	}
	
	public void inicializaUpdate(){
		this.isUpdate=true;
		this.flota=this.mantenimiento.getFlotavehicular();
	}

	public String ingresa(){
		try {
			this.mantenimiento.setFlotavehicular(this.flota);
			this.mantenimiento.setEstado("ACTIVO");
			this.mantenimiento.setUsercreacion(this.user.getUser());
			this.mantenimiento.setFechacreacion(FechasUtil.getDateTimeEcuador());
			DaoFactory.getInstance().getMantenimientoDao().save(this.mantenimiento);
			
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}catch (Exception e) {
			FacesContextUtil.addError(e.getMessage());
		}
		
		return navegaList();
	}
	
	public String  navegaList(){
		return "/admin/mantenimiento/mantenimientoList";
	}
	
	public String  modificar(){
		try {
			this.mantenimiento.setFlotavehicular(this.flota);
			this.mantenimiento.setUsermodif(user.getUser());
			this.mantenimiento.setFechamodif(FechasUtil.getDateTimeEcuador());
			DaoFactory.getInstance().getMantenimientoDao().update(this.mantenimiento);
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
	 * @return the flota
	 */
	public List<Flotavehicular> getFlotas() {
		return flotas;
	}

	/**
	 * @param flota the flota to set
	 */
	public void setFlotas(List<Flotavehicular> flotas) {
		this.flotas = flotas;
	}

	public Flotavehicular getFlota() {
		return flota;
	}

	public void setFlota(Flotavehicular flota) {
		this.flota = flota;
	}
	
}
