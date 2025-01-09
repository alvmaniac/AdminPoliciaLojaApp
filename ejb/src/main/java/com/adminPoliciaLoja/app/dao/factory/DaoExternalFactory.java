/**
 * 
 */
package com.adminPoliciaLoja.app.dao.factory;

/**
 * Class that implements the methods that get the 
 * DAO Services BeanImplementations.
 * @author Alvaro Montesdeoca
 */
public class DaoExternalFactory {
	
private static DaoExternalFactory instance;
	
	/**
	 * Default Constructor.
	 */
	private DaoExternalFactory() {
	}
	/**
	 * Method that instances the class.
	 * @return DaoFactory
	 */
	public static synchronized DaoExternalFactory getInstance() {
		if (instance == null) {
			instance = new DaoExternalFactory();
		}
		return instance;
	}
	
		
}