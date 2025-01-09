package com.adminPoliciaLoja.app.common;

import java.math.BigDecimal;

public class VariablesStatic {
	
	public static final Long EMPRESA_DEFAULT=1l;
	
	public static final int INTENTOS_FALLIDOS=3;
	public static final int IVA_12=2;
	public static final int PORCENTAJE_IVA_12 = 12;
	public static final int ROL_EMPLEADO=3;
	public static final int PROD_CANTIDAD=1;
	public static final int TIEMPO_VIDA_COOKIE=2592000;
	public static final String LLAVE_MD5="asdfqwerfrjubglo23743frvxalp8";
	public static final String TIME_ZONE="America/Guayaquil";
	public static final String TIME_FORMAT="yyyy-MM-dd HH:mm:ss";
	public static final String TIPO_DOC_CI = "1";
	public static final String TIPO_DOC_RUC = "2";
	
	public static final BigDecimal ENVIO_TREINTA_KG = new BigDecimal(30);
	public static final BigDecimal ENVIO_CINCUENTA_KG = new BigDecimal(50);
	
	public static final String SERVIENTREGA_URL_LIQUIDADOR="http://www.servientrega.com.ec/liquidador/nacionalresponse";
	public static final String SERVIENTREGA_PATH_CIUDADES_EC="/json/ciudadesEc.json";
	public static final String SERVIENTREGA_ID_QUITO="2";
	public static final String SERVIENTREGA_MERCANCIAS = "mercancias";
	
	public static final String FAC_ESTADO_ELECT_PENDIENTE="PENDIENTE";
	public static final String FAC_ESTADO_ELECT_ENPROCESO="ENPROCESO";
	public static final String FAC_ESTADO_ELECT_PROCESADA="PROCESADA";
	public static final String FAC_ESTADO_APROBADA = "APROBADA";
	public static final String FAC_ESTADO_REVERSADA = "REVERSADA";
	public static final String FAC_ESTADO_ANULADA = "ANULADA";
	public static final String FAC_ESTADO_RECHAZADA = "RECHAZADA";
	public static final String FAC_ESTADO_PENDIENTE = "PENDIENTE";
	public static final String FAC_ESTADO_FALLIDA = "FALLIDA";
	public static final String FAC_TIPO_COMPROB_FACTURA="01";
	public static final String FAC_TIPO_COMPROB_NOTACREDITO="04";
	public static final String FAC_VIA_COMPRA_OFFLINE="OFFLINE";
	public static final String FAC_VIA_COMPRA_ONLINE="ONLINE";
	public static final String FAC_TIPO_EMISION_NORMAL="1";
	public static final String FAC_SEC_COD="FAC_SEC_COD";
	public static final String FAC_SEC_NUMERO_COMPROBANTE="FAC_SEC_NUMERO_COMPROBANTE";
	public static final String FAC_SEC_SERIE="FAC_SEC_SERIE";
	public static final String FAC_ENTREGA_ENTREGADA="ENTREGADA";
	public static final String FAC_ENTREGA_POR_ENTREGAR="POR_ENTREGAR";
	public static final String FAC_ENTREGA_CANCELADA="CANCELADA";
	public static final String FAC_ENTREGA_DEVUELTA="DEVUELTA";
	public static final String FAC_ENTREGA_PERDIDA="PERDIDA";
	public static final String FAC_FORMA_PAGO_EFECTIVO="EFECTIVO";
	public static final String FAC_FORMA_PAGO_TARJETA="TARJETA";
	public static final String FAC_FORMA_PAGO_TRANSFERENCIA="TRANSFERENCIA";
	
	public static final String EMAIL_IMAGE_HEADER="logo_elmer.png";
	public static final String EMAIL_TO_OPERACIONES="info@elmer.ec";
	public static final String EMAIL_CLAVE_TEMPORAL_SUBJECT="Clave temporal de elmer";
	public static final String EMAIL_CLAVE_TEMPORAL_TEMPLATE="claveTemporal.html";
	public static final String EMAIL_CUENTA_CREADA_SUBJECT="Cuenta creada en Elmer";
	public static final String EMAIL_CUENTA_CREADA_TEMPLATE="cuentaCreada.html";
	public static final String EMAIL_CONTACTO_SUBJECT="Nuevo mensaje de contacto";
	public static final String EMAIL_CONTACTO_TEMPLATE="contacto.html";
	public static final String EMAIL_SONDA_SUBJECT="Pago de Facturas en batch";
	public static final String EMAIL_SONDA_TEMPLATE="sonda.html";
	public static final String EMAIL_COMPRA_SUBJECT="Nueva compra en elmer";
	public static final String EMAIL_COMPRA_TEMPLATE="compra.html";
	public static final String EMAIL_TEMPLATE_SERVER_PATH= "/opt";
	
	public static final Long PTP_COD_EMPRESA_DEFAULT = 1L;
	public static final String PTP_LOCALE = "es_EC";
	public static final String PTP_COUNTRY= "EC";
    public static final String PTP_TIPO_DOC_1 = "CI";
    public static final String PTP_TIPO_DOC_2 = "RUC";
    public static final String PTP_TIPO_DOC_3 = "PPN";
    public static final String PTP_DESCRIPCION = "COMPRA ELECTRONICA ELMER";
    public static final String PTP_SECUENCIAL_REFERENCIA="PTP_SECUENCIAL_REFERENCIA";
    public static final String PTP_ESTADO_APPROVED = "APPROVED";
    public static final String PTP_ESTADO_REJECTED="REJECTED";
    public static final String PTP_ESTADO_PENDING="PENDING";
    public static final int PTP_SONDA_HORA_EJECUCION=2;   // en Horas
    public static final String PTP_TIME_FORMAT="yyyy-MM-dd'T'HH:mm:ss'-05:00'";
    
    public static final String EXCEPTION_APPLICATION="EAPP: ";
    public static final String EXCEPTION_SYSTEM="ESYS: ";
    public static final String EXCEPTION_NAMING="NAMING";
    
    public static final String PROMOCION_POSICION_BANNER="BANNER";
    public static final String PROMOCION_POSICION_BODY_1="BODY_1";
    public static final String PROMOCION_POSICION_BODY_2="BODY_2";
    public static final String PROMOCION_POSICION_BODY_3="BODY_3";
    public static final String PROMOCION_POSICION_BODY_4="BODY_4";
    public static final String PROMOCION_POSICION_LINK="LINK";
}
