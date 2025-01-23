package com.adminPoliciaLoja.web.beans.mantenimiento;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.CellEditEvent;

import com.adminPoliciaLoja.app.datos.ImpuestoTotales;
import com.adminPoliciaLoja.app.common.AdminPoliciaLojaException;
import com.adminPoliciaLoja.app.dao.factory.DaoFactory;
import com.adminPoliciaLoja.app.util.CurrencyUtil;
import com.adminPoliciaLoja.app.util.FechasUtil;
import com.adminPoliciaLoja.web.util.FacesContextUtil;
import com.adminPoliciaLoja.app.entity.Mantenimiento;
import com.adminPoliciaLoja.app.entity.Ordentrabajo;
import com.adminPoliciaLoja.app.entity.Serviciosrepuesto;
import com.adminPoliciaLoja.app.entity.Usuario;



@ViewScoped
@Named
public class OrdenTrabajoBean implements Serializable {
     
	private static final long serialVersionUID = -5826338514180753576L;
    private List<Ordentrabajo> detL;
    private List<Serviciosrepuesto> proL;
    private Map<Integer, Integer> mapProd ;
    private List<ImpuestoTotales> facTotL;
    
    private BigDecimal  subTotal= CurrencyUtil.redondearMoney(BigDecimal.ZERO);
    private BigDecimal total= CurrencyUtil.redondearMoney(BigDecimal.ZERO);
    private BigDecimal totalImp= CurrencyUtil.redondearMoney(BigDecimal.ZERO);
    private BigDecimal cero = CurrencyUtil.redondearMoney(BigDecimal.ZERO);
	private Mantenimiento mantenimiento;
	private Usuario user;
         
    public OrdenTrabajoBean() {
    		this.user=(Usuario)FacesContextUtil.getObjetoSession("user");
			this.mantenimiento=(Mantenimiento)FacesContextUtil.getObjetoSession("MANTENIMIENTO");
			this.mapProd= new HashMap<Integer, Integer>();
			try {
				List<Ordentrabajo> ol= DaoFactory.getInstance().getOrdenTrabajoDao().findByMantenimiento(this.mantenimiento.getId());
				int tamano= ol.size();
				if(tamano > 0) {
					this.detL= ol;
					int c=0;
					for (Ordentrabajo o : ol) {
						this.mapProd.put(c,o.getServiciosrepuesto().getId());
						c++;
					}
					if(tamano<10) {
						int cont = 10-tamano;
						for(int i = 0 ; i < cont ; i++) {
							detL.add(creaProductoVacio());
				        }
					}
					calculaTotales();
				}else {
					detL=createProds(10);
			        this.subTotal= CurrencyUtil.redondearMoney(BigDecimal.ZERO);
			        this.total= CurrencyUtil.redondearMoney(BigDecimal.ZERO);
			        this.totalImp= CurrencyUtil.redondearMoney(BigDecimal.ZERO);
			        this.facTotL=null;
				}
					
			} catch (AdminPoliciaLojaException e) {
				FacesContextUtil.addError(e.getMessage());
			}
	}

	@PostConstruct
    public void init() {
		try {
	        this.proL=DaoFactory.getInstance().getServiciosRepuestoDao().findAll();
		} catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
    }
    

    
    public void calculaTotales() {
    	try {
    		BigDecimal impuesto = BigDecimal.ZERO;
	    	String nombreImpuesto = "Impuestos";
    		for (Ordentrabajo o : this.detL) {
	    		if(o.getServiciosrepuesto().getImpuesto()!=null) {
	    			nombreImpuesto = o.getServiciosrepuesto().getImpuesto().getNombre();
	    			impuesto = impuesto.add(o.getImpuesto());
	    		}
			}
    		this.facTotL= new ArrayList<ImpuestoTotales>();
	    	this.facTotL.add(new ImpuestoTotales(nombreImpuesto, impuesto));
	    	
	    	this.subTotal = CurrencyUtil.redondearMoney(this.detL.stream()
	    	        .map(o -> o.getValortotal())
	    	        .reduce(BigDecimal.ZERO, BigDecimal::add));
	    	
	    	this.totalImp = CurrencyUtil.redondearMoney(this.facTotL.stream()
	    	        .map(o -> o.getValor())
	    	        .reduce(BigDecimal.ZERO, BigDecimal::add));
	    	
	    	this.total =CurrencyUtil.redondearMoney(this.subTotal.add(this.totalImp));
    	
    	} catch (Exception e) {
			FacesContextUtil.addError(e.getMessage());
		}
    }
    
    public void onCellEdit(CellEditEvent<?> event) {
    	try {
	        Object oldValue = event.getOldValue();
	        Object newValue = event.getNewValue();
	        int row= event.getRowIndex();
	        String header= event.getColumn().getHeaderText();
	        if(newValue != null && !newValue.equals(oldValue)) {
	        	switch (header) {
		            case "COD":
		            	Integer newValueL=(Integer)newValue;
		            	if(newValueL==0) {
		            		borrafacturaDet(row);
		            	}else {
		            		Serviciosrepuesto p =DaoFactory.getInstance().getServiciosRepuestoDao().findOne(newValueL);
		            		agregafacturaDet(row, p);
		            	}
		        		break;
		            case "NOMBRE":
		            	String newValueS=(String)newValue;
		            	if(newValueS.trim().equals("")) {
		            		borrafacturaDet(row);
		            	}else {
		            		Serviciosrepuesto p =DaoFactory.getInstance().getServiciosRepuestoDao().consultaProductoXNombre(newValueS);
		            		agregafacturaDet(row, p);
		            	}
		            	break;
		            case "CANT":
		            	Integer newValueC=(Integer)newValue;
		            	Integer oldValueC=(Integer)oldValue;
		            	Ordentrabajo f =this.detL.get(row);
		            	if(newValueC<=0) {
		            		this.detL.set(row, new Ordentrabajo(oldValueC,
									CurrencyUtil.redondearMoney(((f.getServiciosrepuesto().getValor().multiply(BigDecimal.valueOf(oldValueC))).multiply(f.getServiciosrepuesto().getImpuesto().getPorcentaje()).multiply(BigDecimal.valueOf(0.01)))),
									f.getServiciosrepuesto().getImpuesto().getPorcentaje(),
									CurrencyUtil.redondearMoney(f.getServiciosrepuesto().getValor().multiply(BigDecimal.valueOf(oldValueC))),
									CurrencyUtil.redondearMoney(f.getServiciosrepuesto().getValor()),
									this.mantenimiento,
									f.getServiciosrepuesto(),
									this.user.getUser(),
									FechasUtil.getDateTimeEcuador()));
		            	}else {
		            		this.detL.set(row, new Ordentrabajo(newValueC,
									CurrencyUtil.redondearMoney(((f.getServiciosrepuesto().getValor().multiply(BigDecimal.valueOf(newValueC))).multiply(f.getServiciosrepuesto().getImpuesto().getPorcentaje()).multiply(BigDecimal.valueOf(0.01)))),
									f.getServiciosrepuesto().getImpuesto().getPorcentaje(),
									CurrencyUtil.redondearMoney(f.getServiciosrepuesto().getValor().multiply(BigDecimal.valueOf(newValueC))),
									CurrencyUtil.redondearMoney(f.getServiciosrepuesto().getValor()),
									this.mantenimiento,
									f.getServiciosrepuesto(),
									this.user.getUser(),
									FechasUtil.getDateTimeEcuador()));
		            	
		            	}
		            	break;
		            default:
		            	break;
		        }
	        	calculaTotales();
	            PrimeFaces current = PrimeFaces.current();
				current.executeScript("rcT();");
	        }
    	} catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
    }
    
 
    
    public void agregafacturaDet(int row, Serviciosrepuesto p) {
    	int cont=0;
    	if(!this.mapProd.isEmpty() && this.mapProd.containsValue(p.getId())) {
        	/*
        	 * Entra cuando se modifica un producto que ya existe en la tabla
        	 */
        	Integer rowExis = 0;
        	for (Entry<Integer, Integer> entry : this.mapProd.entrySet()) {
                if (entry.getValue().equals(p.getId())) {
                	rowExis = entry.getKey();
                }
            }
        	
        	Ordentrabajo fd=this.detL.get(rowExis); 
        	
        	this.detL.set(rowExis, new Ordentrabajo(fd.getCantidad()+1,
					CurrencyUtil.redondearMoney(((p.getValor().multiply(BigDecimal.valueOf(fd.getCantidad()+1))).multiply(p.getImpuesto().getPorcentaje()).multiply(BigDecimal.valueOf(0.01)))),
					p.getImpuesto().getPorcentaje(),
					CurrencyUtil.redondearMoney(p.getValor().multiply(BigDecimal.valueOf(fd.getCantidad()+1))),
					CurrencyUtil.redondearMoney(p.getValor()),
					this.mantenimiento,
					p,
					this.user.getUser(),
					FechasUtil.getDateTimeEcuador()));
        	
        	this.mapProd.put(rowExis,p.getId());
        	borrafacturaDet(row);
        }else {
        	Serviciosrepuesto fd=this.detL.get(row).getServiciosrepuesto(); 
        	if(fd.getValor()==null) {
        		/*
            	 * Entra cuando el producto es nuevo en la tabla
            	 */
        		for (Ordentrabajo f : this.detL) {
        			if(f.getValorunitario().compareTo(BigDecimal.ZERO)==0) {
        				this.detL.set(row, creaProductoVacio());
        				row = cont;
        				break;
        			} 
        			cont++;
        		}
            }else {
            	/*
            	 * Entra cuando se modifica un producto por otro que no esta insertado en la tabla
            	 */
            	this.mapProd.remove(row);
            }
        	
        	this.detL.set(row, new Ordentrabajo(1,
					CurrencyUtil.redondearMoney(((p.getValor().multiply(BigDecimal.valueOf(1L))).multiply(p.getImpuesto().getPorcentaje()).multiply(BigDecimal.valueOf(0.01)))),
					p.getImpuesto().getPorcentaje(),
					CurrencyUtil.redondearMoney(p.getValor().multiply(BigDecimal.valueOf(1L))),
					CurrencyUtil.redondearMoney(p.getValor()),
					this.mantenimiento,
					p,
					this.user.getUser(),
					FechasUtil.getDateTimeEcuador()));
        	
        	this.mapProd.put(row,p.getId());
       	}
    }
    
    public void borrafacturaAction(int row) {
    	borrafacturaDet(row);
    	calculaTotales();
    }
    
    public void borrafacturaDet(int row) {
    	Ordentrabajo fd=null; 
    	this.mapProd.remove(row);
    	this.detL.set(row, creaProductoVacio());
    	
    	for(int i =row+1; i<this.detL.size();i++) {
    		fd=this.detL.get(i);
    		if(fd.getServiciosrepuesto().getNombre()!=null) {
    			this.detL.set(i-1, fd);
    			this.mapProd.put(i-1,fd.getId());
        	}
    		this.detL.set(i, creaProductoVacio());
    		this.mapProd.remove(i);
    	}
    }
    
    public String facturar() {
    	try {
    		List<Ordentrabajo> ol= DaoFactory.getInstance().getOrdenTrabajoDao().findByMantenimiento(this.mantenimiento.getId());
			for (Ordentrabajo o : ol) {
				DaoFactory.getInstance().getOrdenTrabajoDao().delete(o);
			}
    		
	    	BigDecimal porcentaje;
	    	String nombreImpuesto;
    		for (Ordentrabajo o : this.detL) {
    			if(o.getServiciosrepuesto().getNombre()!=null) {
    				o.setId(0);
		    		DaoFactory.getInstance().getOrdenTrabajoDao().save(o);
		    		nombreImpuesto=o.getServiciosrepuesto().getImpuesto().getNombre();
		    		porcentaje=o.getServiciosrepuesto().getImpuesto().getPorcentaje();
    			}
			}
    		
//    		this.mantenimento.setNombreImpuesto(porcentaje);
//    		this.mantenimento.setPorcentajeImpuesto(nombreImpuesto);
//	    	this.mantenimento.setTotal(this.total);
//	    	this.mantenimento.setTotalImpuesto(this.totalImp);
//	    	this.mantenimento.setSubTotal(this.subTotal);
			this.mantenimiento.setUsermodif(this.user.getUser());
			this.mantenimiento.setFechamodif(FechasUtil.getDateTimeEcuador());
			DaoFactory.getInstance().getMantenimientoDao().update(this.mantenimiento);
	    	init();
	    	FacesContextUtil.setObjetoSession("MANTENIMIENTO", this.mantenimiento);
	    	
	    	
    	} catch (AdminPoliciaLojaException e) {
			FacesContextUtil.addError(e.getMessage());
		}
    	return "";
    }
    
    public void onAddNew() {
    	detL.add(creaProductoVacio());
    }
     
    public List<Ordentrabajo> createProds(int size) {
    	List<Ordentrabajo> list = new ArrayList<Ordentrabajo>();
        for(int i = 0 ; i < size ; i++) {
        	list.add(creaProductoVacio());
        }
        return list;
    }
    
    public Ordentrabajo creaProductoVacio() {
    	Ordentrabajo p= new Ordentrabajo(0,
				CurrencyUtil.redondearMoney(BigDecimal.ZERO),
				BigDecimal.ZERO,
				CurrencyUtil.redondearMoney(BigDecimal.ZERO),
				CurrencyUtil.redondearMoney(BigDecimal.ZERO),
				new Mantenimiento(),
				new Serviciosrepuesto(),
				"",
				new Date());
    	return p;
    }
    

	public List<Ordentrabajo> getDetL() {
		return detL;
	}

	public void setDetL(List<Ordentrabajo> detL) {
		this.detL = detL;
	}

	public List<Serviciosrepuesto> getProL() {
		return proL;
	}

	public void setProL(List<Serviciosrepuesto> proL) {
		this.proL = proL;
	}

	public Map<Integer, Integer > getMapProd() {
		return mapProd;
	}

	public void setMapProd(Map<Integer, Integer> mapProd) {
		this.mapProd = mapProd;
	}

	public List<ImpuestoTotales> getFacTotL() {
		return facTotL;
	}

	public void setFacTotL(List<ImpuestoTotales> facTotL) {
		this.facTotL = facTotL;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public BigDecimal getTotalImp() {
		return totalImp;
	}

	public void setTotalImp(BigDecimal totalImp) {
		this.totalImp = totalImp;
	}

	public BigDecimal getCero() {
		return cero;
	}

	public void setCero(BigDecimal cero) {
		this.cero = cero;
	}

	/**
	 * @return the mantenimiento
	 */
	public Mantenimiento getMantenimiento() {
		return mantenimiento;
	}

	/**
	 * @param mantenimiento the mantenimiento to set
	 */
	public void setMantenimiento(Mantenimiento mantenimiento) {
		this.mantenimiento = mantenimiento;
	}
}