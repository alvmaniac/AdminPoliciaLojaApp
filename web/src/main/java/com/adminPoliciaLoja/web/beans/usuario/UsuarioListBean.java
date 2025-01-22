package com.adminPoliciaLoja.web.beans.usuario;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.common.VariablesStatic;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.Usuario;
import com.adminPoliciaLoja.app.util.Cripto;
import com.adminPoliciaLoja.app.util.FechasUtil;
import com.adminPoliciaLoja.app.util.StringUtils;
import com.adminPoliciaLoja.web.util.FacesContextUtil;



/**
 * @author Alvaro Montesdeoca
 *
 */
@ViewScoped
@Named
public class UsuarioListBean implements Serializable{

	private static final long serialVersionUID = -4517055964735459969L;
	private Usuario usuario;
	private List<Usuario> usuarios;
	private String isActive;
	
	public UsuarioListBean() {
	}
	
	@PostConstruct
	public void ini() {
		try {
				this.usuarios= DaoFactory.getInstance().getUsuarioDao().findAll();
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
			this.usuario.setUsermodif(user.getUser());
			this.usuario.setFechamodif(FechasUtil.getDateTimeEcuador());
			this.usuario.setEstado(this.isActive);
			DaoFactory.getInstance().getUsuarioDao().update(this.usuario);
			FacesContextUtil.inicializarVista();
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
	}
	
	public void reseteaClave(){
		try {
			String clave=StringUtils.generaClaveTemporal();
			Map<String, String> param = new HashMap<String, String>();
			param.put("TO", this.usuario.getUser().trim());
			param.put("SUBJECT", VariablesStatic.EMAIL_CLAVE_TEMPORAL_SUBJECT);
			param.put("{nombreUsuario}", this.usuario.getNombreapellido().trim());
			param.put("{fecha}", FechasUtil.getStringDateTimeEcuador(VariablesStatic.TIME_FORMAT));
			param.put("{mail}", this.usuario.getUser().trim());
			param.put("{claveTemporal}", clave);
			param.put("{url}", FacesContextUtil.getURLWithContextPath());
			
			this.usuario.setClave(Cripto.encrypSHA256Code64(clave));
			this.usuario.setClaveTemporal("SI");
			this.usuario.setLoginFallido(0);
			DaoFactory.getInstance().getUsuarioDao().update(this.usuario);
			DaoFactory.getInstance().getEmailDao().envioEmail(FacesContextUtil.getDeployPath(),VariablesStatic.EMAIL_CLAVE_TEMPORAL_TEMPLATE, param);
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
	}
	
	public String cargaDatos(){
		FacesContextUtil.setObjetoSession("USUARIO", this.usuario);
		return "/admin/usuario/nuevo";
	}
	
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}
