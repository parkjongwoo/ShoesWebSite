package pjw.produclistitem.sql;

public class SQL {
	public static final String PRODUCTLIST_SELECT_NEW = 
			"SELECT PID, PNAME, PIMG_URL, CNAME " + 
			"FROM (SELECT PID, PNAME, PIMG_URL, PDATE, CID FROM S_PRODUCT WHERE PDATE>=add_months( PDATE, -1) ORDER BY PDATE DESC) P " + 
			"INNER JOIN S_P_CATE C ON P.CID=C.CID";
	public static final String PRODUCTLIST_SELECT_POP = "";
}
