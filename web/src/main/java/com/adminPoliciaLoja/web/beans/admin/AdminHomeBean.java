package com.adminPoliciaLoja.web.beans.admin;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.adminPoliciaLoja.web.util.FacesContextUtil;


@ViewScoped
@Named
public class AdminHomeBean implements Serializable{
	private static final long serialVersionUID = -5421684862093202443L;
	private boolean dashboard=false;
	
	public AdminHomeBean() {
	}
	
	@PostConstruct
	public void ini() {
		try {
				this.dashboard = true;
		} catch (Exception e) {
			FacesContextUtil.addError(e.getMessage());
		}
	}

	public boolean getDashboard() {
		return dashboard;
	}

	public void setDashboard(boolean dashboard) {
		this.dashboard = dashboard;
	}
	
}
