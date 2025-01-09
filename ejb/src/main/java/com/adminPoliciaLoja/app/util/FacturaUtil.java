package com.adminPoliciaLoja.app.util;


public class FacturaUtil {
	
	public static String invertirCadena(String cadena) {
        String cadenaInvertida = "";
        for (int x = cadena.length() - 1; x >= 0; x--) {
            cadenaInvertida = cadenaInvertida + cadena.charAt(x);
        }
        return cadenaInvertida;
    }
 
    public static int obtenerSumaPorDigitos(String cadena) {
        int pivote = 2;
        int longitudCadena = cadena.length();
        int cantidadTotal = 0;
        int b = 1;
        for (int i = 0; i < longitudCadena; i++) {
            if (pivote == 8) {
                pivote = 2;
            }
            int temporal = Integer.parseInt("" + cadena.substring(i, b));
            b++;
            temporal *= pivote;
            pivote++;
            cantidadTotal += temporal;
        }
        cantidadTotal = 11 - cantidadTotal % 11;
        return cantidadTotal;
    }
 
//    public static String secuencia(Factura f) {
//    	String fecha = FechasUtil.getStringDateTimeEcuador("ddMMyyyy");
//    	StringBuffer sec = new StringBuffer();
//    	sec.append(fecha);
//    	sec.append(f.getFacTipoComprobante().trim());
//    	sec.append(f.getSucursal().getEmpresa().getEmpRuc());
//    	sec.append(f.getFacTipoAmbiente());
//    	sec.append(f.getFacSerie());
//    	sec.append(f.getFacNumCompSec());
//    	sec.append(f.getFacCodNum());
//    	sec.append(f.getFacTipoEmision());
//    	String sumardig=String.valueOf(obtenerSumaPorDigitos(invertirCadena(sec.toString())));
//    	sec.append(sumardig);
//    	System.out.println("SECUENCIAL|"+sec.toString()+"|Tamano: "+sec.toString().length());
//		System.out.println("FECHA|" + fecha + "|TIPO_COMPROBANTE|" + f.getFacTipoComprobante().trim() +
//				"|RUC|" + f.getSucursal().getEmpresa().getEmpRuc() + "|TIPO_AMBIENTE|"+ f.getFacTipoAmbiente() + 
//				"|FAC_SERIE|" + f.getFacSerie() + "|FAC_NUM_COMP_SEC|" + f.getFacNumCompSec() + "|COD_NUM|" + f.getFacCodNum()+ 
//				"|TIPO_EMISION|" + f.getFacTipoEmision() + "|SUMA_POR_DIG|" + sumardig + "|");
//		return StringUtils.substring(sec.toString(),0, 49);
//    }
    
    
    public static void main(String args[]) throws Exception {
//        System.out.println(obtenerSumaPorDigitos(invertirCadena("41261533")));
    	
    	System.out.println(StringUtils.substring("21072020011715856561001100005200000005200000052195",0, 49));
    }
    
    
    
    
    
    
}
