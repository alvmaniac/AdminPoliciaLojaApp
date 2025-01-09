package com.adminPoliciaLoja.app.dao.inter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;

public interface GenericDaoInter< T extends Serializable >  {
	   public T findOne( Integer id )throws AdminPoliciaLojaException;
	   public List< T > findAll()throws AdminPoliciaLojaException;
	   public void save( T entity )throws AdminPoliciaLojaException;
	   public void saveWithoutInterceptor( T entity ) throws AdminPoliciaLojaException;
	   public void update( T entity )throws AdminPoliciaLojaException;
	   public void delete( T entity )throws AdminPoliciaLojaException;
	   public void deleteById( Long entityId )throws AdminPoliciaLojaException;
	   public List<T> findResult(String namedQuery, Map<String, Object> parameters)throws AdminPoliciaLojaException;
}
