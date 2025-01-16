package com.adminPoliciaLoja.web.convert;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.Flotavehicular;
import com.adminPoliciaLoja.app.util.StringUtils;

@FacesConverter("flotaConverter")
public class FlotaConverter implements Converter<Flotavehicular> {
	 
	public Flotavehicular getAsObject(FacesContext context, UIComponent component, String value) {
		boolean isNumero=StringUtils.isNumeric(value);
		if(value != null && value.trim().length() > 0 && isNumero) {
            try {
            	
                return DaoFactory.getInstance().getFlotaVehicularDao().findOne(Integer.valueOf(value));
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

	public String getAsString(FacesContext context, UIComponent component, Flotavehicular object) {
		 if(object instanceof Flotavehicular) {
	            return String.valueOf((object).getId());
	        }
	        else {
	            return null;
	        }
	}

}
