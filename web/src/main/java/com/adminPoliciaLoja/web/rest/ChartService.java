package com.adminPoliciaLoja.web.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.Usuario;
import com.adminPoliciaLoja.web.util.FacesContextUtil;

/**
 * @author Alvaro Montesdeoca
 * @category Clase que describe el Servicio RestFul el cual recive la cedula 
 * como parametro y devuelve la entida Data como JSON
 */
@Path("/service/")
public class ChartService {
	   
	   @GET
	   @Produces({MediaType.APPLICATION_JSON})
	   @Path("{codUser}")
	   public List<ClaveValor> getData(@PathParam("codUser") String ciUser){
		   List<Usuario> facL=null;
		   try {
			   facL=DaoFactory.getInstance().getUsuarioDao().findAll();
		   }catch (AdminPoliciaLojaException e) {
				FacesContextUtil.addError(e.getMessage());
		   }
		   if (!ciUser.equals(null)){
	    	  List<ClaveValor> cv= facL.stream().map(e -> new ClaveValor(e.getNombreapellido(),2)).collect(Collectors.toList()); 
	    	  return cv;
	      }
	      throw new WebApplicationException(404);
		  
	   }
}
