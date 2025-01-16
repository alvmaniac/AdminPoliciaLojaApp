package com.adminPoliciaLoja.web.beans.login;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.adminPoliciaLoja.web.util.FacesContextUtil;
import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.common.VariablesStatic;
//import com.adminPoliciaLoja.app.entity.Registro;
import com.adminPoliciaLoja.app.entity.Usuario;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.util.Cripto;
import com.adminPoliciaLoja.app.util.FechasUtil;
import com.adminPoliciaLoja.app.util.StringUtils;

@ViewScoped
@Named
public class LoginBean implements Serializable{
	private static final long serialVersionUID = 1704570007466704314L;
	private String mail;
	private String numDoc;
	private String contrasenia;
	
	private boolean recuperaClave=false;

	@PostConstruct
	public void ini() {
		try {
			Usuario user=(Usuario)FacesContextUtil.getObjetoSession("user");
			if (user!= null)
				FacesContextUtil.getExternalContext().redirect("/admin/adminHome");
		}catch (Exception e) {
			FacesContextUtil.addError("ERROR REDIRECCION");
		}
	}
	
	public String login(){
		Usuario usuario=null;
//		Registro r = new Registro();
		String navega=null;
		try {
			
		    usuario = DaoFactory.getInstance().getUsuarioDao().verificaMailExistente(this.mail);
//			r.setRegFecha(FechasUtil.getDateTimeEcuador());
//			r.setRegTabla("REGISTRO");
//			r.setRegUser(this.mail);
//			r.setRegValor(this.mail);
			FacesContextUtil.login(this.mail, this.contrasenia);
			if(usuario.getClaveTemporal().contentEquals("NO")) {
				this.mail=null;
				FacesContextUtil.setObjetoSession("user", usuario);
				usuario.setLoginFallido(0);
				usuario.setUsermodif(usuario.getUser());
				usuario.setFechamodif(FechasUtil.getDateTimeEcuador());
				DaoFactory.getInstance().getUsuarioDao().update(usuario);
//				r.setRegProceso("LOGIN");
				navega="/admin/adminHome";
			}else {
				cerrarSesion();
				FacesContextUtil.setObjetoSession("mailUsu",this.mail.trim());
				navega= "/aut/cambioClave";
			}
//			DaoFactory.getInstance().getRegistroDao().save(r);
		} catch (ServletException e1) {
			int fallo=0;
			if(usuario!=null) {
				fallo=usuario.getLoginFallido();
				usuario.setLoginFallido(fallo+1);
				usuario.setUsermodif(this.mail);
				usuario.setFechamodif(FechasUtil.getDateTimeEcuador());
				try {
					DaoFactory.getInstance().getUsuarioDao().update(usuario);
				}catch (AdminPoliciaLojaException e) { 
					FacesContextUtil.addError(e.getMessage());
				}
				if((usuario.getLoginFallido())>=VariablesStatic.INTENTOS_FALLIDOS) {
					FacesContextUtil.addError("Usuario Bloqueado");
//					r.setRegProceso("USUARIO BLOQUEADO");
				}else {
					FacesContextUtil.addError("CREDENCIALES INVALIDAS");
//					r.setRegProceso("CREDENCIALES INVALIDAS");
				}
			}else {
				FacesContextUtil.addError("CREDENCIALES INVALIDAS");
//				r.setRegProceso("CREDENCIALES INVALIDAS");
			}
//			try {
//				DaoFactory.getInstance().getRegistroDao().save(r);
//			}catch (AdminPoliciaLojaException e) {
//				FacesContextUtil.addError(e.getMessage());
//			}
		} catch (Exception e) {
			int fallo=0;
			if(usuario!=null) {
				fallo=usuario.getLoginFallido();
				usuario.setLoginFallido(fallo+1);
				try {
					usuario.setUsermodif(this.mail);
					usuario.setFechamodif(FechasUtil.getDateTimeEcuador());
					DaoFactory.getInstance().getUsuarioDao().update(usuario);
				}catch (AdminPoliciaLojaException s) {
					FacesContextUtil.addError(s.getMessage());
				}
				if((usuario.getLoginFallido())>=3) {
					FacesContextUtil.addError("CREDENCIALES INVALIDAS");
//					r.setRegProceso("USUARIO BLOQUEADO");
				}else {
					FacesContextUtil.addError("CREDENCIALES INVALIDAS");
//					r.setRegProceso("CREDENCIALES INVALIDAS");
				}
			}else {
				FacesContextUtil.addError("CREDENCIALES INVALIDAS");
//				r.setRegProceso("CREDENCIALES INVALIDAS");
			}
//			try {
//				DaoFactory.getInstance().getRegistroDao().save(r);
//			}catch (AdminPoliciaLojaException s) {
//				FacesContextUtil.addError(s.getMessage());
//			}
		}
	        return navega;		
	}
	public String cerrarSesion(){
		ExternalContext externalContext = FacesContextUtil.getExternalContext();;
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        externalContext.invalidateSession();
        try {
			request.logout();
		} catch (ServletException e) {
			e.printStackTrace();
		}
		return "/inicio?faces-redirect=true";
	}
	
	public void reseteaClave(){
		try {
			this.mail=null;
//			Usuario usuario = DaoFactory.getInstance().getUsuarioDao().verificaMailExistente(this.mail);
			Usuario usuario =DaoFactory.getInstance().getUsuarioDao().verificaIdentificacionExistente(this.numDoc);
			if(usuario !=null) {
				this.mail=usuario.getUser().trim();
				String clave=StringUtils.generaClaveTemporal();
				Map<String, String> param = new HashMap<String, String>();
				param.put("TO", usuario.getUser().trim());
				param.put("SUBJECT", VariablesStatic.EMAIL_CLAVE_TEMPORAL_SUBJECT);
				param.put("{nombreUsuario}", usuario.getNombreapellido().trim());
				param.put("{fecha}", FechasUtil.getStringDateTimeEcuador(VariablesStatic.TIME_FORMAT));
				param.put("{mail}", usuario.getUser().trim());
				param.put("{claveTemporal}", clave);
				param.put("{url}", FacesContextUtil.getURLWithContextPath()+"/inicio");
				
				usuario.setClave(Cripto.encrypSHA256Code64(clave));
				usuario.setClaveTemporal("SI");
				usuario.setLoginFallido(0);
				usuario.setUsermodif(this.mail);
				usuario.setFechamodif(FechasUtil.getDateTimeEcuador());
				DaoFactory.getInstance().getUsuarioDao().update(usuario);
				DaoFactory.getInstance().getEmailDao().envioEmail(FacesContextUtil.getDeployPath(),VariablesStatic.EMAIL_CLAVE_TEMPORAL_TEMPLATE, param);
				this.recuperaClave=true;
			}else {
				FacesContextUtil.addError("Usuario no registrado");
			}
			
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
	}
	
	public void cambioClave() {
		try {
			this.mail = (String)FacesContextUtil.getObjetoSession("mailUsu");
			FacesContextUtil.eliminarObjetoSession("mailUsu");
			Usuario usuario = DaoFactory.getInstance().getUsuarioDao().verificaMailExistente(this.mail);
			if(usuario!=null) {
				usuario.setClave(Cripto.encrypSHA256Code64(this.contrasenia));
				usuario.setClaveTemporal("NO");
				usuario.setLoginFallido(0);
				usuario.setUsermodif(this.mail);
				usuario.setFechamodif(FechasUtil.getDateTimeEcuador());
				DaoFactory.getInstance().getUsuarioDao().update(usuario);
			}
			
			this.recuperaClave=true;
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
	}
	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public boolean isRecuperaClave() {
		return recuperaClave;
	}

	public void setRecuperaClave(boolean recuperaClave) {
		this.recuperaClave = recuperaClave;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}	
}

