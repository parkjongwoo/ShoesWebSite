package jjh.service.sql;

public class PagingSql {
	public static final String SELECT_ALL_COUNT_S_P_QNA = "SELECT count(*) AS cnt FROM s_p_qna_view WHERE mauth='N'";
	public static final String SELECT_ALL_COUNT_S_QNA = "SELECT count(*) AS cnt FROM s_qna_view WHERE mauth='N'";
}
