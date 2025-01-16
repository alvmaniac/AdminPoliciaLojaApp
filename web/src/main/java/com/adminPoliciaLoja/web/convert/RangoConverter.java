package com.adminPoliciaLoja.web.convert;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.Rangopolicial;
import com.adminPoliciaLoja.app.util.StringUtils;

@FacesConverter("rangoConverter")
public class RangoConverter implements Converter<Rangopolicial> {
	 
	public Rangopolicial getAsObject(FacesContext context, UIComponent component, String value) {
		boolean isNumero=StringUtils.isNumeric(value);
		if(value != null && value.trim().length() > 0 && isNumero) {
            try {
            	
                return DaoFactory.getInstance().getRangoPolicialDao().findOne(Integer.valueOf(value));
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

	public String getAsString(FacesContext context, UIComponent component, Rangopolicial object) {
		 if(object instanceof Rangopolicial) {
	            return String.valueOf((object).getId());
	        }
	        else {
	            return null;
	        }
	}

}
