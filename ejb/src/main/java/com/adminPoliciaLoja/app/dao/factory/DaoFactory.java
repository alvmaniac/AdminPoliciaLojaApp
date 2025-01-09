/**
 * 
 */
package com.adminPoliciaLoja.app.dao.factory;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.common.VariablesStatic;
import com.adminPoliciaLoja.app.dao.inter.EmailInter;
import com.adminPoliciaLoja.app.dao.inter.PersonalPolicialDao;
import com.adminPoliciaLoja.app.dao.inter.RolDao;
import com.adminPoliciaLoja.app.dao.inter.UsuarioDao;


/**
 * Class that implements the methods that get the 
 * DAO Services BeanImplementations.
 * @author Alvaro Montesdeoca
 */
public class DaoFactory {
	
private static DaoFactory instance;
	
	/**
	 * Default Constructor.
	 */
	private DaoFactory() {
	}
	/**
	 * Method that instances the class.
	 * @return DaoFactory
	 */
	public static synchronized DaoFactory getInstance() {
		if (instance == null) {
			instance = new DaoFactory();
		}
		return instance;
	}
	
	public UsuarioDao getUsuarioDao() throws AdminPoliciaLojaException{
		Object o = null;
		try {
			 o= InitialContext.doLookup("java:app/AdminPoliciaLoja/UsuarioJpa!com.adminPoliciaLoja.app.dao.inter.UsuarioDao");
		} catch (NamingException e) {
			throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_NAMING +"_2_" +getClass().getSimpleName().toUpperCase(),e.getMessage());
		}
		return (UsuarioDao)o;
	}
	
	public RolDao getRolDao() throws AdminPoliciaLojaException{
		Object o = null;
		try {
			 o= InitialContext.doLookup("java:app/AdminPoliciaLoja/RolJpa!com.adminPoliciaLoja.app.dao.inter.RolDao");
		} catch (NamingException e) {
			throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_NAMING +"_2_" +getClass().getSimpleName().toUpperCase(),e.getMessage());
		}
		return (RolDao)o;
	}
	
	public PersonalPolicialDao getPersonalPolicialDao() throws AdminPoliciaLojaException{
		Object o = null;
		try {
			 o= InitialContext.doLookup("java:app/AdminPoliciaLoja/PersonalPolicialJpa!com.adminPoliciaLoja.app.dao.inter.PersonalPolicialDao");
		} catch (NamingException e) {
			throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_NAMING +"_2_" +getClass().getSimpleName().toUpperCase(),e.getMessage());
		}
		return (PersonalPolicialDao)o;
	}
	
	public EmailInter getEmailDao() throws AdminPoliciaLojaException{
		Object o = null;
		try {
			 o= InitialContext.doLookup("java:global/AdminPoliciaLojaApp-ear/AdminPoliciaLoja/EmailImpl");
		} catch (NamingException e) {
			throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_NAMING +"_2_" +getClass().getSimpleName().toUpperCase(),e.getMessage());
		}
		return (EmailInter)o;
	}
	
	
	
}