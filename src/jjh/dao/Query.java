package jjh.dao;

public class Query {
//	--------------- S_PRODUCT
	public static final String PRODUCT_IMPL_SELECT_1 = "SELECT * FROM s_product WHERE pid = ?";
	
//	--------------- S_P_QNA
	public static final String QNA_IMPL_SELECT_1 = "SELECT * FROM S_P_QNA_VIEW WHERE PID = ?"; 
	public static final String QNA_IMPL_SELECTALL = "SELECT * FROM S_P_QNA_VIEW WHERE MAUTH = 'N'";
	public static final String QNA_IMPL_PAGE_2 = "SELECT things.* FROM " +
	" (SELECT ROWNUM rn, qnas.* FROM "
			+" (SELECT Q.*, CASE WHEN (QID IN (SELECT QPARENT FROM S_P_QNA)) THEN " +
	" '답변완료' ELSE '미답변' END STATUS FROM s_p_qna_view Q " +
			" WHERE mauth='N') qnas) things WHERE rn BETWEEN ? and ?";
	
	public static final String QNA_IMPL_INSERT_4 = "INSERT INTO s_p_qna VALUES( " +
	" SEQ_SS_P_QNA_QID.NEXTVAL, ?, ?, SYSDATE, 0, NULL, ?, ?)";
	public static final String QNA_IMPL_TARGET_QNA_1 = "SELECT * FROM S_P_QNA_VIEW WHERE qid = ?";
	
	public static final String QNA_IMPL_ANSWER_QNA_5 = "INSERT INTO s_p_qna VALUES( " +
	" SEQ_SS_P_QNA_QID.NEXTVAL, ?, ?, SYSDATE, 0, ?, ?, ?)";
	
//	--------------- S_P_COMMENT
	public static final String COMMENT_IMPL_SELECT_1 = "SELECT * FROM S_COMMENT_VIEW WHERE PID = ?";
	public static final String COMMENT_IMPL_SELECTALL = "SELECT * FROM S_COMMENT_VIEW";
	
	
//	--------------- S_QNA
	
	public static final String S_QNA_IMPL_SELECTALL = "SELECT S_qna.*, s_member.mname, s_member.mauth " +
	" FROM s_qna,s_member WHERE qparent is null and s_qna.mid = s_member.mid " +
			" ORDER BY QID DESC";
	public static final String S_QNA_IMPL_PAGE = "SELECT things.* FROM (SELECT ROWNUM rn, qnas.* FROM " +
			" (SELECT Q.*, CASE WHEN (QID IN (SELECT QPARENT FROM S_QNA)) THEN " +
			" '답변완료' ELSE '미답변' END STATUS FROM s_qna_view Q " +
			" WHERE mauth='N') qnas) things WHERE rn BETWEEN ? and ?";
	public static final String S_QNA_IMPL_TARGET_1 = "SELECT * FROM s_qna_view WHERE qid = ?";
	public static final String S_QNA_IMPL_ANSWER_4 = "INSERT INTO s_qna values(SEQ_SS_QNA_QID.nextval, ?, ?, sysdate, 0, ?, ?)";
}
