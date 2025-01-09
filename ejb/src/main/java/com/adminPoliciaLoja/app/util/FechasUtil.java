/**
 * FechasUtil.java
 * filenetWeb version 1.0 
 * 24/11/2010
 *
 * Quito - Ecuador
 * http://www.dinersclub.com.ec
 * 
 * Copyright (C) 2010 Diners Club
 */
package com.adminPoliciaLoja.app.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.adminPoliciaLoja.app.common.VariablesStatic;


/**
 * Class Util for Dates
 *
 * @author Alvaro Montesdeoca
 * @version 1.0  30/11/2010
 */
public class FechasUtil {
	
	static final String dias[]= {"Domingo","Lunes","Martes","Mi�rcoles","Jueves","Viernes","S�bado"};
	/**
	 * Permite obtener la fecha en un Objeto Date en base a un String
	 * @param fechaString			Cadena de fecha
	 * @return						Devuelve un objeto Date
	 * @throws Exception			En caso de error al transformar el dato
	 */
	public static Date getDateFecha(String fechaString)throws Exception{
		try {
			if(fechaString != null && fechaString != ""){
				DateFormat format= new SimpleDateFormat("yyyy-MM-dd");
				return format.parse(fechaString);
			}
			else{
				return null;
			}
		} catch (Exception e) {
			throw new Exception("Error de conversi�n");
		}
	}
	/**
	 * Devuelve un String de una fecha en base a un Objeto Date
	 * @param fechaDate					Date de fecha
	 * @return							Devuelve una cadena con la fecha
	 */
	public static String getStringFecha(Date fechaDate){
		if(fechaDate != null){
			DateFormat format= new SimpleDateFormat("yyyy-MM-dd");
			return format.format(fechaDate);
		}else{
			return null;
		}
	}
	
	public static String getStringFecha(Date fechaDate, String formato){
		if(fechaDate != null){
			DateFormat format= new SimpleDateFormat(formato);
			return format.format(fechaDate);
		}else{
			return null;
		}
	}
	
	
	/**
	 * Obtiene la fecha actual de sisten en forma de cadena
	 * @return		Devuelve la fecha
	 */
	public static String getFechaActual(){
		DateFormat format= new SimpleDateFormat("yyyy-MM-dd");
		return format.format(new Date(System.currentTimeMillis()));		
	}
	/**
	 * Agrega una cantidad de dias a un fecha especifica.
	 * @param fecha				Fecha a la cual se le agregar&aacute;n los dias.
	 * @param dias				N&uacute;umero de d&iacute;as a aregar
	 * @return					Devuelve la nueva fecha
	 */
	public static Date agregarDias(Date fecha, int dias){
		Calendar fechaCal = Calendar.getInstance();
		fechaCal.setTime(fecha);
		fechaCal.add(Calendar.DAY_OF_MONTH, dias);
		return fechaCal.getTime();
	}
	/**
	 * Agrega una cantidad de dias a un fecha especifica en forma de cadena.
	 * @param fecha				Fecha a la cual se le agregar&aacute;n los dias.
	 * @param dias				N&uacute;umero de d&iacute;as a aregar
	 * @return					Devuelve la cadena con la nueva fecha
	 */
	public static String agregarDiasString(Date fecha, int dias){
		Calendar fechaCal = Calendar.getInstance();
		fechaCal.setTime(fecha);
		fechaCal.add(Calendar.DAY_OF_MONTH, dias);
		return getStringFecha(fechaCal.getTime());
	}
	/**
	 * Agrega una cantidad de horas a un fecha especifica en forma de cadena.
	 * @param fecha				Fecha a la cual se le agregar&aacute;n los dias.
	 * @param horas				N&uacute;umero de d&iacute;as a agregar
	 * @return					Devuelve la cadena con la nueva fecha
	 */
	public static Date agregarHorasString(Date fecha, int horas){
		Calendar fechaCal = Calendar.getInstance();
		fechaCal.setTime(fecha);
		fechaCal.add(Calendar.HOUR_OF_DAY, horas);
		return fechaCal.getTime();
	}
	
	/**
	 * Obtiene el dia de la semana de una fecha espec&iacute;fica.
	 * @param fecha		Dato Fecha
	 * @return			Devuelve el d&iacute; de la semana.
	 */
	public static String obtenerDia(Date fecha){
		Calendar fechaCal = Calendar.getInstance();
		fechaCal.setTime(fecha);
		int dia = fechaCal.get(Calendar.DAY_OF_WEEK );
		return dias[dia - 1];
	}
	
	/**
	 * Permite obtener la fecha de Inicio de un Mes en un a�o
	 * 
	 * @param   int year							A�o del cual se obtendra la fecha Inicio
	 * @param	int mes                             Mes del cual se obtendra la fecha Inicio
	 * @return 	Date								Devuelve la fecha Inicio de un mes en un a�o.
	 * @author  amontesdeoca.   
	 * @throws Exception 
	 */
	public static Date fechaInicioMes(int year, int mes) throws Exception{
		
        Calendar cale = new GregorianCalendar();
        cale.set(year, mes, 1);
        String fecha = FechasUtil.getStringFecha(cale.getTime());
        Date fechaInicio = FechasUtil.getDateFecha(fecha);			
		return fechaInicio;
	
	}
	
	/**
	 * Permite obtener la fecha Fin de un Mes en un a�o
	 * 
	 * @param   int year							A�o del cual se obtendra la fecha Fin
	 * @param	int mes                             Mes del cual se obtendra la fecha Fin
	 * @return 	Date								Devuelve la fecha Fin de un mes en un a�o.
	 * @author  amontesdeoca.   
	 * @throws Exception 
	 */
	public static Date fechaFinMes(int year, int mes) throws Exception{
		Calendar cal = new GregorianCalendar();	
		cal.set(Calendar.MONTH, mes); 
        int dias = cal.getActualMaximum(Calendar.DAY_OF_MONTH); 
        
        Calendar cale = new GregorianCalendar();
        cale.set(year, mes, dias);
        
        String fecha = FechasUtil.getStringFecha(cale.getTime());
        Date fechaFin = FechasUtil.getDateFecha(fecha);			
		return fechaFin;	
	}
	
	/**
	 * Devuelve una Fecha Formateada dd/MM/yyyy de una fecha en base a un Objeto Date
	 * @param 	Date fecha					Fecha a Formatear
	 * @return 	Date						Devuelve una cadena con la fecha
	 * @author  amontesdeoca.   
	 * @throws 	Exception 
	 */
	public static Date getFechaFormateada(Date fecha)throws Exception{
		if(fecha!=null){
			DateFormat format= new SimpleDateFormat("yyyy-MM-dd");
			String fechaString = format.format(fecha);
			DateFormat format2= new SimpleDateFormat("yyyy-MM-dd");
			Date fechaDate =  format2.parse(fechaString);
			return fechaDate;
		}else{
			return null;
		}
		
		
	}
	
	/**
	 * Devuelve la hora actual
	 * @return String     Hora Acrual
	 */
	public static int getHoraActual(){
		int horaActual;
		Calendar calendario = Calendar.getInstance();
		int hora = calendario.get(Calendar.HOUR);
		int min = calendario.get(Calendar.MINUTE);
		int seg = calendario.get(Calendar.SECOND);
		String horaStr = String.valueOf(hora)+StringUtils.leftPad(String.valueOf(min), 2, '0')+StringUtils.leftPad(String.valueOf(seg), 2, '0');
		horaActual = Integer.parseInt(horaStr);
		return horaActual;
	}
	
	public static Date getDateTimeEcuador() {
		Date ans = null;
	     try {
			ans = new SimpleDateFormat(VariablesStatic.TIME_FORMAT)
					.parse(ZonedDateTime.ofInstant(Instant.now(), ZoneId.of(VariablesStatic.TIME_ZONE))
							.format(DateTimeFormatter.ofPattern(VariablesStatic.TIME_FORMAT)));
	       } catch (ParseException e) {
	    	   ans = Calendar.getInstance().getTime();
	       }
		return ans;
	}
	
	public static String getStringDateTimeEcuador(String pattern) {
		String formattedString = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of(VariablesStatic.TIME_ZONE))
				.format(DateTimeFormatter.ofPattern(pattern));
		return formattedString;
	}
	
	public static String getStringDateTimeAddMinEcuador(String pattern, int min) {
		String formattedString = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of(VariablesStatic.TIME_ZONE)).plusMinutes(min)
				.format(DateTimeFormatter.ofPattern(pattern));
		return formattedString;
	}
	
	public static Date getNextDate(int targetHour, int targetMin, int targetSec) { 
		 ZonedDateTime zonedNow = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of(VariablesStatic.TIME_ZONE)); 
		 ZonedDateTime zonedNextTarget = zonedNow.withHour(targetHour).withMinute(targetMin).withSecond(targetSec); 
		 if(zonedNow.compareTo(zonedNextTarget) > 0) 
		  zonedNextTarget = zonedNextTarget.plusDays(1);
		 Date ans = null;
	     try {
			ans = new SimpleDateFormat(VariablesStatic.TIME_FORMAT)
					.parse(zonedNextTarget.format(DateTimeFormatter.ofPattern(VariablesStatic.TIME_FORMAT)));
	       } catch (ParseException e) {
	       }
		return ans; 
	} 
}
