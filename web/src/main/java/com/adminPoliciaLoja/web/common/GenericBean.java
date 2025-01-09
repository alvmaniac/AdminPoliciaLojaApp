package com.adminPoliciaLoja.web.common;

import java.io.Serializable;

import com.adminPoliciaLoja.web.util.FacesContextUtil;


public  abstract class GenericBean<E extends Serializable> {
	
	
	protected E e;
	protected boolean isUpdate=false;	 
	 
	public GenericBean() {
	}
	
	public void inicializa(){
		this.setIsUpdate(false);
		FacesContextUtil.inicializarVista();
	}
	
	public void inicializaUpdate(){
		this.isUpdate=true;
	}

	public E getE() {
		return e;
	}

	public void setE(E e) {
		this.e = e;
	}
	
	public boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(final boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	
	


}
