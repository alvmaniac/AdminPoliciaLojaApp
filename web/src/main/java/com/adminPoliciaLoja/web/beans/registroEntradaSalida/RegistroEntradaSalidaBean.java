package com.adminPoliciaLoja.web.beans.registroEntradaSalida;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.Personalpolicial;
import com.adminPoliciaLoja.app.entity.RegistroEntradaSalida;
import com.adminPoliciaLoja.app.entity.Usuario;
import com.adminPoliciaLoja.web.util.FacesContextUtil;

/**
 * @author Alvaro Montesdeoca
 */
@ViewScoped
@Named
public class RegistroEntradaSalidaBean implements Serializable{

	private static final long serialVersionUID = 3156233590497362592L;
	private Usuario user;
	private boolean isUpdate=false;
	private RegistroEntradaSalida reg;
	private List<Personalpolicial>  perPolis;
	
	
	
	@PostConstruct
	public void ini() {
		this.user=(Usuario)FacesContextUtil.getObjetoSession("user");
		this.reg=(RegistroEntradaSalida)FacesContextUtil.getObjetoSession("REGISTRO");
		FacesContextUtil.eliminarObjetoSession("REGISTRO");
		try {
			this.perPolis=DaoFactory.getInstance().getPersonalPolicialDao().findAllActive();
		
			if (this.reg!=null) {
				inicializaUpdate();
			}else {
				inicializa();
			}
		} catch (AdminPoliciaLojaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void inicializa(){
		this.setReg(reg);
		this.setIsUpdate(false);
	}
	
	public void inicializaUpdate(){
		this.isUpdate=true;
	}

	public String ingresa(){
		try {
			//this.dependencia.setFechacreacion(FechasUtil.getDateTimeEcuador());
			DaoFactory.getInstance().getRegistroEntradaSalidaDao().save(this.reg);
			
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}catch (Exception e) {
			FacesContextUtil.addError(e.getMessage());
		}
		
		return navegaList();
	}
	
	public String  navegaList(){
		return "/admin/registroEntradaSalida/registroEntradaSalidaList";
	}
	
	public String  modificar(){
		try {
			DaoFactory.getInstance().getRegistroEntradaSalidaDao().update(this.reg);
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

	public RegistroEntradaSalida getReg() {
		return reg;
	}

	public void setReg(RegistroEntradaSalida reg) {
		this.reg = reg;
	}

	public List<Personalpolicial> getPerPolis() {
		return perPolis;
	}

	public void setPerPolis(List<Personalpolicial> perPolis) {
		this.perPolis = perPolis;
	}

	public RegistroEntradaSalidaBean() {
	}

}
