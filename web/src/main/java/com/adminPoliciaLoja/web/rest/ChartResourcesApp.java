package com.adminPoliciaLoja.web.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Alvaro Montesdeoca
 * @category Clase que instancia el Servicio RestFul
 */
@ApplicationPath("resources")
public class ChartResourcesApp extends Application{
	   @Override
	   public Set<Class<?>> getClasses() {
	      Set<Class<?>> classes = new HashSet<>();
	      classes.add(ChartService.class);
	      return classes;
	   }
}
