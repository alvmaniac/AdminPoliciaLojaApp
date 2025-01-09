package com.adminPoliciaLoja.web.convert;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.Rol;
import com.adminPoliciaLoja.app.util.StringUtils;

@FacesConverter("rolConverter")
public class RolConverter implements Converter<Rol> {
	 
	public Rol getAsObject(FacesContext context, UIComponent component, String value) {
		boolean isNumero=StringUtils.isNumeric(value);
		if(value != null && value.trim().length() > 0 && isNumero) {
            try {
            	
                return DaoFactory.getInstance().getRolDao().findOne(Integer.valueOf(value));
            } catch (AdminPoliciaLojaException e) {
            	throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Cant�n no valido"));
            } 
        }
        else {
            return null;
        }
	}

	public String getAsString(FacesContext context, UIComponent component, Rol object) {
		 if(object instanceof Rol) {
	            return String.valueOf((object).getId());
	        }
	        else {
	            return null;
	        }
	}

}
