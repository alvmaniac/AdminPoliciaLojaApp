package com.adminPoliciaLoja.web.beans.reclamoSuger;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.entity.Dependencia;
import com.adminPoliciaLoja.app.entity.ReclamoSugerencia;
import com.adminPoliciaLoja.app.util.FechasUtil;
import com.adminPoliciaLoja.web.util.FacesContextUtil;

/**
 * @author Alvaro Montesdeoca
 */
@ViewScoped
@Named
public class ReclamoSugerenciaBean implements Serializable{
	
	private static final long serialVersionUID = -2726393206062515891L;
	private ReclamoSugerencia reclamoSuger;
	
	private String circuito;
	private Dependencia subcircuito;
	private List<String>  circuitos;
	private List<Dependencia>  subcircuitos;
	
	public ReclamoSugerenciaBean() {
	}
	
	@PostConstruct
	public void ini() {
		try {
			this.circuitos=DaoFactory.getInstance().getDependenciaDao().allCircuitos();
			inicializa();
		} catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
		
	}
	
	public void inicializa(){
		this.setCircuito("");
		this.setReclamoSuger(new ReclamoSugerencia());
		this.setSubcircuito(new Dependencia());
		FacesContextUtil.inicializarVista();
	}
	
	/**
	 * @return the reclamoSuger
	 */
	public ReclamoSugerencia getReclamoSuger() {
		return reclamoSuger;
	}

	/**
	 * @param reclamoSuger the reclamoSuger to set
	 */
	public void setReclamoSuger(ReclamoSugerencia reclamoSuger) {
		this.reclamoSuger = reclamoSuger;
	}

	public String ingresa(){
		try {
			this.reclamoSuger.setDependencia(this.subcircuito);
			this.reclamoSuger.setEstado("ACTIVO");
			this.reclamoSuger.setUsercreacion("ANONIMO");
			this.reclamoSuger.setFechacreacion(FechasUtil.getDateTimeEcuador());
			DaoFactory.getInstance().getReclamoSugerenciaDao().save(this.reclamoSuger);
			inicializa();
			FacesContextUtil.addInfo("Su Reclamo/Sugerencia se ha ingresado Exitosamente");
		}catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}catch (Exception e) {
			FacesContextUtil.addError(e.getMessage());
		}
		
		return navegaList();
	}
	
	public String  navegaList(){
		return "";
	}
	
	public void subcircuitosChangeListener(ValueChangeEvent event){
		this.circuito = ( (String) event.getNewValue());
		try {
			this.subcircuitos = DaoFactory.getInstance().getDependenciaDao().findSubCurcuitos(this.circuito);
		} catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
	}
	
	/**
	 * @return the circuito
	 */
	public String getCircuito() {
		return circuito;
	}

	/**
	 * @param circuito the circuito to set
	 */
	public void setCircuito(String circuito) {
		this.circuito = circuito;
	}

	/**
	 * @return the subcircuito
	 */
	public Dependencia getSubcircuito() {
		return subcircuito;
	}

	/**
	 * @param subcircuito the subcircuito to set
	 */
	public void setSubcircuito(Dependencia subcircuito) {
		this.subcircuito = subcircuito;
	}

	/**
	 * @return the circuitos
	 */
	public List<String> getCircuitos() {
		return circuitos;
	}

	/**
	 * @param circuitos the circuitos to set
	 */
	public void setCircuitos(List<String> circuitos) {
		this.circuitos = circuitos;
	}

	/**
	 * @return the subcircuitos
	 */
	public List<Dependencia> getSubcircuitos() {
		return subcircuitos;
	}

	/**
	 * @param subcircuitos the subcircuitos to set
	 */
	public void setSubcircuitos(List<Dependencia> subcircuitos) {
		this.subcircuitos = subcircuitos;
	}
	
	
}
