/**
 * FacesContextUtil.java
 * eclient version 1.0 
 * 30/11/2010
 *
 * Quito - Ecuador
 * http://www.dinersclub.com.ec
 * 
 * Copyright (C) 2010 Diners Club
 */
 
package com.adminPoliciaLoja.web.util;

import java.util.Iterator;
import java.util.Map;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class Util for FacesContext
 *
 * @author Alvaro Montesdeoca
 * @version 1.0  30/11/2010
 */
public class FacesContextUtil {
	
	/**
	 * @param infoTmp
	 */
	public static void addInfo(String infoTmp)
	{
		FacesMessage info = new FacesMessage();
		info.setSeverity(FacesMessage.SEVERITY_INFO);
		info.setSummary (infoTmp);
		if (FacesContext.getCurrentInstance() != null) {
			FacesContext.getCurrentInstance().addMessage(null, info);
		}
	}
	
	/**
	 * @param messageTmp
	 */
	public static void addMessage(String messageTmp)
	{
		FacesMessage message = new FacesMessage();			
		message.setSummary(messageTmp);
		if (FacesContext.getCurrentInstance() != null) {
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	/**
	 * @param errorTmp
	 */
	public static void addError(String errorTmp){
		FacesMessage error = new FacesMessage();		
		error.setSummary(errorTmp);
		error.setSeverity(FacesMessage.SEVERITY_ERROR);
		if (FacesContext.getCurrentInstance() != null) {
			FacesContext.getCurrentInstance().addMessage(null, error);
		}
	}
	
	/**
	 * @param seItems // arreglo de select Items en el que se busca
	 * @param itemBuscado //el itemvalue recuperado de la JSP
	 * @return si encuentra retorna el Itemlabel sino ""
	 */
	public static String buscarEnSelectItems(SelectItem[] seItems, String itemBuscado ){
		String resp=""; 
		for (int i = 0; i< seItems.length;i++ ){
			SelectItem se = seItems[i];
			if (se.getValue().equals(itemBuscado)  ) 
			 return  se.getLabel();
		}
		return resp;
	}	
	
	/**
	 * Obtiene ExternalContext, devolviendo una referencia a la instancia JSF asociada a la petici�n
	 * @return 		ExternalContext
	 */
	public static ExternalContext getExternalContext() {		
		return FacesContext.getCurrentInstance().getExternalContext();
	}
	
	/**
	 * Metodo que guarda un objeto en el contexto session
	 * @param nombre		Nombre de la variable que se desea guardar
	 * @param obj			Objeto que se guardara en el contexto session
	 */	
	public static void setObjetoSession(String nombre, Object obj) {
		if (FacesContext.getCurrentInstance() != null) {
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(nombre, obj);
		}
	}
	
	/**
	 * Obtiene objetos de session
	 * @return UsuarioDTO
	 */
	public static Object getObjetoSession(String nombre){	
		Object object = null;
		if (FacesContext.getCurrentInstance() != null) {
			object = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(nombre);
		}
		return object;		
	}
	
	/**
	 * Metodo para eliminar un objeto del contexto session 
	 * 
	 * @param nombre		Nombre de la variable que se desea eliminar
	 */
	public static void eliminarObjetoSession(String nombre) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(nombre);		
	}
	
	/**
	 * Obtiene un parametro del request
	 * @param nombreParametro
	 * @return
	 */
	public static String obtenerParametroRequest(String nombreParametro) 
	{
		String valorParametro = null;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();		
		valorParametro = request.getParameter(nombreParametro);		
		return valorParametro;
	}
	
	public static String obtenerParametroRequestMap(String nombreParametro) 
	{
		String valorParametro = null;
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, String> map = context.getExternalContext().getRequestParameterMap();		
		valorParametro = map.get(nombreParametro);		
		return valorParametro;
	}
	
	
	public static void login(String mail, String contrasenia) throws ServletException
	{
		FacesContext context = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = context.getExternalContext();
	    HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		request.login(mail, contrasenia);
	}
	
	public static HttpServletRequest obtenerRequest() 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();		
		return request;
	}
	
	public static HttpServletResponse obtenerResponse() 
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();		
		return response;
	}
	
	/**
	 * Metodo para imprimir los objetos que se encuentran en el contexto session
	 *
	 */
	@SuppressWarnings("rawtypes")
	public static void imprimirObjetosSession() {		
		Iterator it = getExternalContext().getSessionMap().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();
			System.out.println(e.getValue());
		}		
	}
	
	public static void inicializarVista() {
		FacesContext context = FacesContext.getCurrentInstance();
	    Application application = context.getApplication();
	    ViewHandler viewHandler = application.getViewHandler();
	    UIViewRoot viewRoot = viewHandler.createView(context, context.getViewRoot().getViewId());
	    context.setViewRoot(viewRoot);
//	    context.renderResponse(); //Optional
	}
	
	public static String getDeployPath() {
		return getExternalContext().getRealPath("/");
	}
	
	public static String getURLWithContextPath() {
	   return obtenerRequest().getScheme() + "://" + obtenerRequest().getServerName() + ":" + obtenerRequest().getServerPort() + obtenerRequest().getContextPath();
	}

}
