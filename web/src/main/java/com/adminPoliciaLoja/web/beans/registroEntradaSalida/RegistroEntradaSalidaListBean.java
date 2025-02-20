package com.adminPoliciaLoja.web.beans.registroEntradaSalida;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.RegistroEntradaSalida;
import com.adminPoliciaLoja.web.util.FacesContextUtil;



/**
 * @author Alvaro Montesdeoca
 *
 */
@ViewScoped
@Named
public class RegistroEntradaSalidaListBean implements Serializable{
	
	private static final long serialVersionUID = 1921636528657484152L;
	private RegistroEntradaSalida reg;
	private List<RegistroEntradaSalida> registros;
	
	public RegistroEntradaSalidaListBean() {
	}
	
	@PostConstruct
	public void ini() {
		try {
				this.registros= DaoFactory.getInstance().getRegistroEntradaSalidaDao().findAll();
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
	}
	
	public String cargaDatos(){
		FacesContextUtil.setObjetoSession("REGISTRO", this.reg);
		return "/admin/registroEntradaSalida/modificarRegistro";
	}

	public RegistroEntradaSalida getReg() {
		return reg;
	}

	public void setReg(RegistroEntradaSalida reg) {
		this.reg = reg;
	}

	public List<RegistroEntradaSalida> getRegistros() {
		return registros;
	}

	public void setRegistros(List<RegistroEntradaSalida> registros) {
		this.registros = registros;
	}
	

	
}
