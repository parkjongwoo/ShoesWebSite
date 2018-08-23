package ksh.table1.sql;

public class NoticeSql {
	public static final String SELECT_ALL_SQL = "SELECT * FROM S_NOTICE ORDER BY nid";
	public static final String INSERT_SQL ="INSERT INTO S_NOTICE VALUES(SEQ_SS_NOTICE_NID.nextval,?,?,sysdate,0,?)";
	public static final String UPDATE_SQL ="UPDATE s_notice SET ntitle = ?, ncontent = ? WHERE mid = ? and nid = ?";
	public static final String DELETE_SQL ="DELETE s_notice WHERE nid = ? and mid = ?";
	public static final String UPDATE_NHIT_SQL ="UPDATE s_notice SET nhit = nhit+1 WHERE nid = ?";
	public static final String SELECT_NHIT_SQL ="SELECT nhit FROM s_notice WHERE nid = ?";
	public static final String SELECT_PAGE_SQL = "select rownum rn, nid, ntitle, ncontent, ndate, nhit, mid from(select rownum rn, s_qnas.* from(select * from s_notice order by nid desc)s_qnas) where rn between ? and ?";
	
}
