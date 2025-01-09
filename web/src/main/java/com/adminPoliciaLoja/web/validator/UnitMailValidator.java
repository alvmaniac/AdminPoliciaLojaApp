package com.adminPoliciaLoja.web.validator;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.Usuario;
import com.adminPoliciaLoja.web.util.FacesContextUtil;

@FacesValidator("UnitMailValidator")
public class UnitMailValidator implements Validator<Object>{

	
	public  UnitMailValidator() {
	}
	
	
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		Usuario cli=null;
		try {
			cli=DaoFactory.getInstance().getUsuarioDao().verificaMailExistente(value.toString());
			if(cli!=null){
				FacesMessage msg = 	new FacesMessage("Email ya registrado", "Email ya registrado");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(msg);
			}
		 }catch (AdminPoliciaLojaException e) {
				FacesContextUtil.addError(e.getMessage());
		 }

	}
}
