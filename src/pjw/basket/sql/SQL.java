package pjw.basket.sql;

public class SQL {
	public static final String BASKET_INSERT = 
			"MERGE INTO S_BASKET B " + 
			"USING (SELECT ? MID,? PID,? BQUANTITY, SYSDATE BDATE FROM dual) N " + 
			"ON ( B.MID = N.MID and B.PID = N.PID) " + 
			"WHEN MATCHED THEN " + 
			"UPDATE " + 
			"SET B.BQUANTITY = N.BQUANTITY " + 
			"WHEN NOT MATCHED THEN " + 
			"INSERT (MID, PID, BQUANTITY, BDATE) " + 
			"VALUES (N.MID, N.PID, N.BQUANTITY, N.BDATE)";
	
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
