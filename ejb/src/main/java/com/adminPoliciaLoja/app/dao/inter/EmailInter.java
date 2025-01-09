package com.adminPoliciaLoja.app.dao.inter;

import java.util.Map;

import javax.ejb.Remote;
@Remote
public interface EmailInter {
	
	public void envioEmail(String deploy,String template, Map<String, String> param);

}
