package com.adminPoliciaLoja.web.functions;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.util.List;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.util.CurrencyUtil;
import com.adminPoliciaLoja.web.util.FacesContextUtil;

public final class Functions {

    private Functions() {
        // Hide constructor.
    }

    public static String convertUrlSEO(String text) {
        String seoUrl="";
    	if (text != null && !text.isEmpty()) {
    		text = Normalizer.normalize(text, Normalizer.Form.NFD);
            text = text.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
            // trim spaces at the edges, convert all to lowercase and
            // remove all non-alpha numeric characters
            String url = text.trim().toLowerCase().replaceAll("[^a-z0-9_\\s-]", ""); 
            // change all multiple white spaces to single white space
            url = url.replaceAll("[\\s-]+", " ");
            // replace all the single white spaces with a dash
            seoUrl = url.replaceAll("[\\s]", "-");
        } else {
            seoUrl = "Please enter text to convert";
        }
    	return seoUrl;
    }
    
//    public static void main(String [] args) {
//    	System.out.println(convertUrlSEO("Este producto  !\"#$%&/()=?¡¿\' 345#tiene ación sobre otres ëstilo ¬dnvc")); 
//    }

    public static String precioImpuesto(Long proCod, BigDecimal precio, int descuento) {
   	String precioImpuesto="";
//    	try {
//    	
//    		List<ImpuestoProducto>  improdList = DaoFactory.getInstance().getImpuestoProductoDao().consultaImpuestosXProd(proCod);
//    		BigDecimal imptosPrecio = improdList.stream().map(o -> precio.multiply(BigDecimal.valueOf(o.getImpuesto().getImpPorcentaje() * 0.01))).reduce(BigDecimal.ZERO, BigDecimal::add);
//    		BigDecimal precioMasImpuesto = CurrencyUtil.redondearMoney(precio.add(imptosPrecio));
//    		
//    		BigDecimal precioDesc = precio.subtract(precio.multiply(BigDecimal.valueOf(descuento * 0.01)));
//    		BigDecimal imptosPrecioDesc = improdList.stream().map(o -> precioDesc.multiply(BigDecimal.valueOf(o.getImpuesto().getImpPorcentaje() * 0.01))).reduce(BigDecimal.ZERO, BigDecimal::add);
//    		BigDecimal precioMasImpuestoMenosDesc = CurrencyUtil.redondearMoney(precioDesc.add(imptosPrecioDesc));
//    		
//    		if(descuento>0) {
//    			precioImpuesto = "<strike>"+precioMasImpuesto+"</strike> "+ precioMasImpuestoMenosDesc;
//    		}else {
//    			precioImpuesto = String.valueOf(precioMasImpuesto);
//    		}
//    		
//    		
//    		
//    	} catch (AdminPoliciaLojaException e) {
//			FacesContextUtil.addError(e.getMessage());
//		}
        return precioImpuesto;
    }
}
