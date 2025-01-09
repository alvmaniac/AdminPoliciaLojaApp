package com.adminPoliciaLoja.web.convert;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.Personalpolicial;
import com.adminPoliciaLoja.app.util.StringUtils;

@FacesConverter("perPolicialConverter")
public class PersonalPolicialConverter implements Converter<Personalpolicial> {
	 
	public Personalpolicial getAsObject(FacesContext context, UIComponent component, String value) {
		boolean isNumero=StringUtils.isNumeric(value);
		if(value != null && value.trim().length() > 0 && isNumero) {
            try {
            	
                return DaoFactory.getInstance().getPersonalPolicialDao().findOne(Integer.valueOf(value));
            } catch (AdminPoliciaLojaException e) {
            	throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage()));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Valor no valido"));
            } 
        }
        else {
            return null;
        }
	}

	public String getAsString(FacesContext context, UIComponent component, Personalpolicial object) {
		 if(object instanceof Personalpolicial) {
	            return String.valueOf((object).getId());
	        }
	        else {
	            return null;
	        }
	}

}
