/**
 * 
 */
package com.adminPoliciaLoja.app.dao.factory;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.common.VariablesStatic;
import com.adminPoliciaLoja.app.dao.inter.DependenciaDao;
import com.adminPoliciaLoja.app.dao.inter.EmailInter;
import com.adminPoliciaLoja.app.dao.inter.FlotaVehicularDao;
import com.adminPoliciaLoja.app.dao.inter.ImpuestoDao;
import com.adminPoliciaLoja.app.dao.inter.MantenimientoDao;
import com.adminPoliciaLoja.app.dao.inter.OrdenTrabajoDao;
import com.adminPoliciaLoja.app.dao.inter.PersonalPolicialDao;
import com.adminPoliciaLoja.app.dao.inter.RangoPolicialDao;
import com.adminPoliciaLoja.app.dao.inter.ReclamoSugerenciaDao;
import com.adminPoliciaLoja.app.dao.inter.RolDao;
import com.adminPoliciaLoja.app.dao.inter.ServiciosRepuestoDao;
import com.adminPoliciaLoja.app.dao.inter.TipoVehiculoDao;
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
			throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_NAMING +"_1_" +getClass().getSimpleName().toUpperCase(),e.getMessage());
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
			throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_NAMING +"_3_" +getClass().getSimpleName().toUpperCase(),e.getMessage());
		}
		return (PersonalPolicialDao)o;
	}
	
	public RangoPolicialDao getRangoPolicialDao() throws AdminPoliciaLojaException{
		Object o = null;
		try {
			 o= InitialContext.doLookup("java:app/AdminPoliciaLoja/RangoPolicialJpa!com.adminPoliciaLoja.app.dao.inter.RangoPolicialDao");
		} catch (NamingException e) {
			throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_NAMING +"_4_" +getClass().getSimpleName().toUpperCase(),e.getMessage());
		}
		return (RangoPolicialDao)o;
	}
	
	public DependenciaDao getDependenciaDao() throws AdminPoliciaLojaException{
		Object o = null;
		try {
			 o= InitialContext.doLookup("java:app/AdminPoliciaLoja/DependenciaJpa!com.adminPoliciaLoja.app.dao.inter.DependenciaDao");
		} catch (NamingException e) {
			throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_NAMING +"_5_" +getClass().getSimpleName().toUpperCase(),e.getMessage());
		}
		return (DependenciaDao)o;
	}
	
	public TipoVehiculoDao getTipoVehiculoDao() throws AdminPoliciaLojaException{
		Object o = null;
		try {
			 o= InitialContext.doLookup("java:app/AdminPoliciaLoja/TipoVehiculoJpa!com.adminPoliciaLoja.app.dao.inter.TipoVehiculoDao");
		} catch (NamingException e) {
			throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_NAMING +"_6_" +getClass().getSimpleName().toUpperCase(),e.getMessage());
		}
		return (TipoVehiculoDao)o;
	}
	
	public FlotaVehicularDao getFlotaVehicularDao() throws AdminPoliciaLojaException{
		Object o = null;
		try {
			 o= InitialContext.doLookup("java:app/AdminPoliciaLoja/FlotaVehicularJpa!com.adminPoliciaLoja.app.dao.inter.FlotaVehicularDao");
		} catch (NamingException e) {
			throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_NAMING +"_7_" +getClass().getSimpleName().toUpperCase(),e.getMessage());
		}
		return (FlotaVehicularDao)o;
	}
	
	public ImpuestoDao getImpuestoDao() throws AdminPoliciaLojaException{
		Object o = null;
		try {
			 o= InitialContext.doLookup("java:app/AdminPoliciaLoja/ImpuestoJpa!com.adminPoliciaLoja.app.dao.inter.ImpuestoDao");
		} catch (NamingException e) {
			throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_NAMING +"_8_" +getClass().getSimpleName().toUpperCase(),e.getMessage());
		}
		return (ImpuestoDao)o;
	}
	
	public MantenimientoDao getMantenimientoDao() throws AdminPoliciaLojaException{
		Object o = null;
		try {
			 o= InitialContext.doLookup("java:app/AdminPoliciaLoja/MantenimientoJpa!com.adminPoliciaLoja.app.dao.inter.MantenimientoDao");
		} catch (NamingException e) {
			throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_NAMING +"_9_" +getClass().getSimpleName().toUpperCase(),e.getMessage());
		}
		return (MantenimientoDao)o;
	}
	
	public OrdenTrabajoDao getOrdenTrabajoDao() throws AdminPoliciaLojaException{
		Object o = null;
		try {
			 o= InitialContext.doLookup("java:app/AdminPoliciaLoja/OrdenTrabajoJpa!com.adminPoliciaLoja.app.dao.inter.OrdenTrabajoDao");
		} catch (NamingException e) {
			throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_NAMING +"_10_" +getClass().getSimpleName().toUpperCase(),e.getMessage());
		}
		return (OrdenTrabajoDao)o;
	}
	
	public ServiciosRepuestoDao getServiciosRepuestoDao() throws AdminPoliciaLojaException{
		Object o = null;
		try {
			 o= InitialContext.doLookup("java:app/AdminPoliciaLoja/ServiciosRepuestoJpa!com.adminPoliciaLoja.app.dao.inter.ServiciosRepuestoDao");
		} catch (NamingException e) {
			throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_NAMING +"_11_" +getClass().getSimpleName().toUpperCase(),e.getMessage());
		}
		return (ServiciosRepuestoDao)o;
	}
	
	public ReclamoSugerenciaDao getReclamoSugerenciaDao() throws AdminPoliciaLojaException{
		Object o = null;
		try {
			 o= InitialContext.doLookup("java:app/AdminPoliciaLoja/ReclamoSugerenciaJpa!com.adminPoliciaLoja.app.dao.inter.ReclamoSugerenciaDao");
		} catch (NamingException e) {
			throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_NAMING +"_11_" +getClass().getSimpleName().toUpperCase(),e.getMessage());
		}
		return (ReclamoSugerenciaDao)o;
	}
	
	
	public EmailInter getEmailDao() throws AdminPoliciaLojaException{
		Object o = null;
		try {
			 o= InitialContext.doLookup("java:global/AdminPoliciaLojaApp-ear/AdminPoliciaLoja/EmailImpl");
		} catch (NamingException e) {
			throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_NAMING +"_12_" +getClass().getSimpleName().toUpperCase(),e.getMessage());
		}
		return (EmailInter)o;
	}
	
	
	
}