package helper;

public class Contants {
//	public static final boolean ISLOCALHOST = true;//localhost
	public static final boolean ISLOCALHOST = false;//azure
	
	public static final int ORDER_NOT_MEASURE = 0;//mua hàng có sẵn
    public static final int ORDER_MEASURE = 1;//đặt may
    
    public static final String PASSWORD_DEFAULT = "abc123";
    public static final int ROLE_CUSTOMER = 1;
    public static final int ROLE_ADMIN = 2;
    
    public static final int INVOICE_MODE_TRUCTIEP = 1;
    public static final int INVOICE_MODE_ATM = 2;
    
    public static final int INVOIE_STATUS_CANCEL = 0;//Hủy đơn
    public static final int INVOIE_STATUS_SUCCESS = 1;//thành công đã giao hàng
    public static final int INVOIE_STATUS_WAITING_APPROVE = 2;//chờ xác nhận
    public static final int INVOIE_STATUS_APPROVE = 3;//xác nhận
    public static final int INVOIE_STATUS_DELIVERY = 4;//đang giao hàng
    
    public static final int INVOIE_GIAMDOC = 1;
    public static final int INVOIE_QUANLYCAOCAP	 = 2;
    public static final int INVOIE_QUANLYSANPHAM	 = 3;
    public static final int INVOIE_QUANLYDONHANG	 = 4;
    public static final int INVOIE_QUANLYBINHLUAN	 = 5;
    public static final int INVOIE_QUANLYBAIVIET	 = 6;
    public static final int INVOIE_QUANLYPHANQUYEN   = 7;
    

    
    
}
