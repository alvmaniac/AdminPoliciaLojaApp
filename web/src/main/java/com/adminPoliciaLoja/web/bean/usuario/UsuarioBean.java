package com.adminPoliciaLoja.web.bean.usuario;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.common.VariablesStatic;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.Personalpolicial;
import com.adminPoliciaLoja.app.entity.Rol;
import com.adminPoliciaLoja.app.entity.Usuario;
import com.adminPoliciaLoja.app.util.Cripto;
import com.adminPoliciaLoja.app.util.FechasUtil;
import com.adminPoliciaLoja.web.util.FacesContextUtil;

/**
 * @author Alvaro Montesdeoca
 */
@ViewScoped
@Named
public class UsuarioBean implements Serializable{
	private static final long serialVersionUID = -5421684862093202443L;
	
	private Usuario usuario;
	private boolean isUpdate=false;
	private Rol rol;
	private Personalpolicial perPoli;
	private List<Rol>  roles;
	private List<Personalpolicial>  perPolis;
	
	public UsuarioBean() {
	}
	
	@PostConstruct
	public void ini() {
		this.usuario=(Usuario)FacesContextUtil.getObjetoSession("USUARIO");
		FacesContextUtil.eliminarObjetoSession("USUARIO");
		try {
			this.roles=DaoFactory.getInstance().getRolDao().findAll();
			this.perPolis=DaoFactory.getInstance().getPersonalPolicialDao().findAll();
			if (this.usuario!=null) {
				inicializaUpdate();
			}else {
				inicializa();
			}
		} catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
		
	}
	
	public void inicializa(){
		this.setUsuario(new Usuario());
		this.setIsUpdate(false);
		this.setRol(new Rol());
		this.setPerPoli(new Personalpolicial());
		FacesContextUtil.inicializarVista();
	}
	
	public void inicializaUpdate(){
		this.isUpdate=true;
		this.rol=this.usuario.getRol();
		this.perPoli=this.usuario.getPersonalpolicial();
	}

	public String ingresa(){
		try {
			this.usuario.setClave(Cripto.encrypSHA256Code64(this.usuario.getClave()));
			this.usuario.setClaveTemporal("NO");
			this.usuario.setLoginFallido(0);
			this.usuario.setRol(this.rol);
			this.usuario.setPersonalpolicial(this.perPoli);
			this.usuario.setEstado("ACTIVO");
			DaoFactory.getInstance().getUsuarioDao().save(this.usuario);
			
			Map<String, String> param = new HashMap<String, String>();
			param.put("TO", this.usuario.getUser().trim());
			param.put("SUBJECT", VariablesStatic.EMAIL_CUENTA_CREADA_SUBJECT);
			param.put("{nombreUsuario}", this.usuario.getNombreapellido().trim());
			param.put("{fecha}", FechasUtil.getStringDateTimeEcuador(VariablesStatic.TIME_FORMAT));
			param.put("{mail}", this.usuario.getUser().trim());
			param.put("{url}", FacesContextUtil.getURLWithContextPath());
			
			DaoFactory.getInstance().getEmailDao().envioEmail(FacesContextUtil.getDeployPath(),VariablesStatic.EMAIL_CUENTA_CREADA_TEMPLATE, param);
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}catch (Exception e) {
			FacesContextUtil.addError(e.getMessage());
		}
		
		return navegaList();
	}
	
	public String  navegaList(){
		return "/admin/usuario/usuarioList";
	}
	
	public String  modificar(){
		try {
			this.usuario.setRol(this.rol);
			this.usuario.setPersonalpolicial(this.perPoli);
			DaoFactory.getInstance().getUsuarioDao().update(this.usuario);
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
		return navegaList();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(final Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(final boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Personalpolicial getPerPoli() {
		return perPoli;
	}

	public void setPerPoli(Personalpolicial perPoli) {
		this.perPoli = perPoli;
	}
	
	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public List<Personalpolicial> getPerPolis() {
		return perPolis;
	}

	public void setPerPolis(List<Personalpolicial> perPolis) {
		this.perPolis = perPolis;
	}
	
}
