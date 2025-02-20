package com.adminPoliciaLoja.web.beans.registroEntradaSalida;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.RegistroEntradaSalida;
import com.adminPoliciaLoja.app.entity.Usuario;
import com.adminPoliciaLoja.app.util.FechasUtil;
import com.adminPoliciaLoja.web.util.FacesContextUtil;

/**
 * @author Alvaro Montesdeoca
 */
@ViewScoped
@Named
public class RegistroEntradaSalidaPoliciaBean implements Serializable{

	private static final long serialVersionUID = 3156233590497362592L;
	private Usuario user;
	private RegistroEntradaSalida reg;
	
	public RegistroEntradaSalidaPoliciaBean() {
	}
	
	@PostConstruct
	public void ini() {
		this.user=(Usuario)FacesContextUtil.getObjetoSession("user");
		inicializa();
		
		
	}
	
	public void inicializa(){
		this.setReg(reg);
	}
	

	public String ingresa(){
		try {
			this.reg.setPersonalpolicial(user.getPersonalpolicial());
			this.reg.setFecha(FechasUtil.getDateTimeEcuador());
			DaoFactory.getInstance().getRegistroEntradaSalidaDao().save(this.reg);
			inicializa();
			FacesContextUtil.addInfo("Registro Exitoso");
			
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}catch (Exception e) {
			FacesContextUtil.addError(e.getMessage());
		}
		
		return navegaList();
	}
	
	public String  navegaList(){
		return "";
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


}
