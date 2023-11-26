package response;

import java.io.Serializable;

public class OrderOrderdetailResponse implements Serializable  {
    private static final long serialVersionUID = 1L;
    
//    private int idorder;
//    private int iduser;
//    private int idproduct;
//    private String content;
//    private int idinvoice;
    
  private int idorder;
private int idinvoice;
private float grandtotal;
public OrderOrderdetailResponse(int idorder, int idinvoice, float grandtotal) {
	super();
	this.idorder = idorder;
	this.idinvoice = idinvoice;
	this.grandtotal = grandtotal;
}
public int getIdorder() {
	return idorder;
}
public void setIdorder(int idorder) {
	this.idorder = idorder;
}
public int getIdinvoice() {
	return idinvoice;
}
public void setIdinvoice(int idinvoice) {
	this.idinvoice = idinvoice;
}
public float getGrandtotal() {
	return grandtotal;
}
public void setGrandtotal(float grandtotal) {
	this.grandtotal = grandtotal;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
@Override
public String toString() {
	return "OrderOrderdetailResponse [idorder=" + idorder + ", idinvoice=" + idinvoice + ", grandtotal=" + grandtotal
			+ "]";
}


    

	
	
}
