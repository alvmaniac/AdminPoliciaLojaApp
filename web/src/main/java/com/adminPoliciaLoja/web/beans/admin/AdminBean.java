package com.adminPoliciaLoja.web.beans.admin;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.adminPoliciaLoja.app.entity.Usuario;
import com.adminPoliciaLoja.web.util.FacesContextUtil;


@ViewScoped
@Named
public class AdminBean implements Serializable{
	private static final long serialVersionUID = -5421684862093202443L;
	private Usuario usuario;
	private boolean menuDisabled =true;
	
	public AdminBean() {
	}
	
	@PostConstruct
	public void ini() {
		this.usuario=(Usuario)FacesContextUtil.getObjetoSession("user");
	}
	
		 
	
	public String cerrarSesion(){
		FacesContextUtil.eliminarObjetoSession("user");
		ExternalContext externalContext = FacesContextUtil.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        externalContext.invalidateSession();
        try {
			request.logout();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return "/inicio?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean getMenuDisabled() {
		return menuDisabled;
	}

	public void setMenuDisabled(boolean menuDisabled) {
		this.menuDisabled = menuDisabled;
	}
}
