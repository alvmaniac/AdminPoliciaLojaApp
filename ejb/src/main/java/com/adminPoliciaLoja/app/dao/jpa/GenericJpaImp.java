package com.adminPoliciaLoja.app.dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.common.VariablesStatic;
import com.adminPoliciaLoja.app.dao.inter.GenericDaoInter;

public abstract class GenericJpaImp< T extends Serializable > implements GenericDaoInter<T>{
	 
	   private Class< T > clazz;
	 
	   @PersistenceContext(unitName = "unit_AdminPoliciaLoja")
	   protected EntityManager em ;
	 
		@SuppressWarnings("unchecked")
		public GenericJpaImp() {
			final Class<T> aType = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			this.clazz = aType;
		}
		
		public GenericJpaImp(Class<T> type) {
			this.clazz = type;
		}
		
	   public void setClazz( Class< T > clazzToSet ) {
	      this.clazz = clazzToSet;
	   }
	 
	   public T findOne( Integer id ) throws AdminPoliciaLojaException{
		   try {
		   		return em.find( clazz, id );
			}catch (EJBException e) {
				throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_SYSTEM +"_1_" +clazz.getSimpleName().toUpperCase(),e.getMessage());
			}catch (Exception e) {
				throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_APPLICATION+"_1_" +clazz.getSimpleName().toUpperCase(),e.getMessage());
			}
	   }
	   
	   public List< T > findAll() throws AdminPoliciaLojaException{
			try {
				TypedQuery<T> qr =em.createQuery( "from " + clazz.getName(),clazz);
			   return qr.getResultList();
			}catch (EJBException e) {
				throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_SYSTEM +"_2_" +clazz.getSimpleName().toUpperCase(),e.getMessage());
			}catch (Exception e) {
				throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_APPLICATION+"_2_" +clazz.getSimpleName().toUpperCase(),e.getMessage());
			}
	   }
	   
	   public List< T > findAllActive() throws AdminPoliciaLojaException{
			try {
				TypedQuery<T> qr =em.createQuery( "from " + clazz.getName()+" where estado = 'ACTIVO'",clazz);
			   return qr.getResultList();
			}catch (EJBException e) {
				throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_SYSTEM +"_2_" +clazz.getSimpleName().toUpperCase(),e.getMessage());
			}catch (Exception e) {
				throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_APPLICATION+"_2_" +clazz.getSimpleName().toUpperCase(),e.getMessage());
			}
	   }
	   
	   public void save( T entity ) throws AdminPoliciaLojaException{
		   try {	
			   em.persist( entity );
		   }catch (EJBException e) {
				throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_SYSTEM +"_3_" +clazz.getSimpleName().toUpperCase(),e.getMessage());
			}catch (Exception e) {
				throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_APPLICATION+"_3_" +clazz.getSimpleName().toUpperCase(),e.getMessage());
			}
	   }
	   
	   public void saveWithoutInterceptor( T entity ) throws AdminPoliciaLojaException{
		   try {	
			   em.persist( entity );
		   }catch (EJBException e) {
				throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_SYSTEM +"_3_" +clazz.getSimpleName().toUpperCase(),e.getMessage());
			}catch (Exception e) {
				throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_APPLICATION+"_3_" +clazz.getSimpleName().toUpperCase(),e.getMessage());
			}
	   }
	   public void update( T entity ) throws AdminPoliciaLojaException{
		   try {	
			   em.merge( entity );
		   }catch (EJBException e) {
				throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_SYSTEM +"_4_" +clazz.getSimpleName().toUpperCase(),e.getMessage());
			}catch (Exception e) {
				throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_APPLICATION+"_4_" +clazz.getSimpleName().toUpperCase(),e.getMessage());
			}
	   }
	   public void delete( T entity ) throws AdminPoliciaLojaException{
		   try {
		   		em.remove( entity );
		   }catch (EJBException e) {
				throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_SYSTEM +"_4_" +clazz.getSimpleName().toUpperCase(),e.getMessage());
			}catch (Exception e) {
				throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_APPLICATION+"_4_" +clazz.getSimpleName().toUpperCase(),e.getMessage());
			}
	   }
	   public void deleteById( Integer entityId ) throws AdminPoliciaLojaException{
		      T entity = findOne( entityId );
		      delete( entity );
	   }
	   
	   public List<T> findResult(String namedQuery, Map<String, Object> parameters)throws AdminPoliciaLojaException {
	        List<T> result = null;
	        try {
	        	TypedQuery<T> query = em.createNamedQuery(namedQuery,clazz);
	            if (parameters != null && !parameters.isEmpty()) {
	                populateQueryParameters(query, parameters);
	            }
	            result = query.getResultList();
	 
	        }catch (EJBException e) {
				throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_SYSTEM +"_5_" +clazz.getSimpleName().toUpperCase(),e.getMessage());
			}catch (Exception e) {
				throw new AdminPoliciaLojaException(VariablesStatic.EXCEPTION_APPLICATION+"_5_" +clazz.getSimpleName().toUpperCase(),e.getMessage());
			}
	        return result;
	    }
	 
	    public void populateQueryParameters(Query query, Map<String, Object> parameters) {
	        for (Entry<String, Object> entry : parameters.entrySet()) {
	            query.setParameter(entry.getKey(), entry.getValue());
	        }
	    }
	}
