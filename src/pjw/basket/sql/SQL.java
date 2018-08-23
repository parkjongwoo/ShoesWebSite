package pjw.basket.sql;

public class SQL {
	public static final String BASKET_INSERT = "INSERT INTO S_BASKET VALUES(?, ?, ?, SYSDATE)";
	
	public static final String BASKET_SELECT_BY_PID =
			"SELECT PID, PNAME, PDCHARGE, PPRICE " + 
			"FROM S_PRODUCT WHERE PID=?";
	
	public static final String BASKET_SELECT_ALL = 
			"SELECT B.MID, P.PID, P.PNAME, B.BQUANTITY, P.PDCHARGE, P.PPRICE " + 
			"FROM (SELECT * FROM S_BASKET WHERE MID=?) B " + 
			"INNER JOIN S_PRODUCT P ON B.PID=P.PID";
	
	public static final String BASKET_DELETE_ALL = "DELETE FROM S_BASKET WHERE MID=?";	
	public static final String BASKET_DELETE_BY_PID = "DELETE FROM S_BASKET WHERE PID=? AND MID=?";	
	public static final String BASKET_UPDATE_BY_PID = "UPDATE S_BASKET SET BQUANTITY=? WHERE PID=? AND MID=?";
}
