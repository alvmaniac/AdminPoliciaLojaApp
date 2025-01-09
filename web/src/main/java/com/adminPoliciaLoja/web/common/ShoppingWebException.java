package com.adminPoliciaLoja.web.common;

public class ShoppingWebException extends java.lang.Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5567553415000459001L;
	private java.lang.String _infostring = null;
    private java.lang.String ex;
	/**
	* Comentario de constructor GenericTest.
	*/
	
	public ShoppingWebException() {
	    super();
	}
	/**
	* Comentario de constructor GenericTest.
	*/
	public ShoppingWebException (String infostring)
	{
	    _infostring = infostring;
	}
	public ShoppingWebException(String msg,String t) {
	    super(msg);
	    this.setEx(t);
	    
	    }
    /**
     * @return
     */
    public java.lang.String get_infostring() {
           return _infostring;
    }

    /**
     * @return
     */
    public java.lang.String getEx() {
           return ex;
    }

    /**
     * @param string
     */
    public void set_infostring(java.lang.String string) {
           _infostring = string;
    }

    /**
     * @param Exception
     */
    public void setEx(java.lang.String exception) {
           ex = exception;
    }
    
    public void printStackTrace(java.io.PrintWriter s) {  
      System.out.println("the exception is :"+ex);       
      }

}
