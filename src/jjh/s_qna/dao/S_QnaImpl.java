package jjh.s_qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jjh.dao.BaseDao;
import jjh.dao.Query;
import jjh.s_p_qna.model.S_P_Qna;
import jjh.s_qna.model.S_Qna;
import jjh.service.page.PageManager;
import jjh.service.page.PageRowResult;
import jjh.service.sql.PagingSql;

public class S_QnaImpl extends BaseDao implements S_QnaDao {

	@Override
	public List<S_Qna> selectAll() {
		Connection con = getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		List<S_Qna> list = new ArrayList<S_Qna>();
		try {
			st = con.prepareStatement(Query.S_QNA_IMPL_SELECTALL);
			rs = st.executeQuery();
			while(rs.next()) {
				S_Qna qna = new S_Qna();
				qna.setQid(rs.getInt("QID"));
				qna.setQtitle(rs.getString("QTITLE"));
				qna.setMid(rs.getString("MID"));
				qna.setQdate(rs.getDate("QDATE"));
				qna.setQhit(rs.getInt("QHIT"));
				qna.setMname(rs.getString("MNAME"));
				list.add(qna);
			}
		}catch(Exception e) {
			System.out.println("S_Qna SELECTALL fail : " + e.getMessage());
		}
		
		closeDB(rs, st, con);
		return list;
	}



	@Override
	public void answerQna(S_Qna qna) {
		Connection con = getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement(Query.S_QNA_IMPL_ANSWER_4);
			st.setString(1, qna.getQtitle());
			st.setString(2, qna.getQcontent());
			st.setInt(3, qna.getQparent());
			st.setString(4, qna.getMid());
			
			st.executeUpdate();
		}catch(Exception e) {
			System.out.println("1:1문의 answer 실패 : " + e.getMessage());
		}
		
		closeDB(rs, st, con);
		
	}

	@Override
	public List<S_Qna> pagerQna(int requestPage) {
		Connection con = getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		S_Qna qna = null;
		List<S_Qna> list = new ArrayList<S_Qna>();
		try {
			st = con.prepareStatement(Query.S_QNA_IMPL_PAGE);
			PageManager pm = new PageManager(requestPage);
			pm.setsql(PagingSql.SELECT_ALL_COUNT_S_QNA);
			PageRowResult prr = pm.getPageRowResult();
			st.setInt(1, prr.getRowStartNumber());
			st.setInt(2, prr.getRowEndNumber());
			rs = st.executeQuery();
			while(rs.next()) {
				qna = new S_Qna();
				qna.setQid(rs.getInt("qid"));
				qna.setQtitle(rs.getString("qtitle"));
				qna.setQcontent(rs.getString("QCONTENT"));
				qna.setQdate(rs.getDate("QDATE"));
				qna.setQhit(rs.getInt("QHIT"));
				qna.setMid(rs.getString("MID"));
				qna.setMauth(rs.getString("MAUTH"));
				qna.setMname(rs.getString("MNAME"));
				qna.setStatus(rs.getString("STATUS"));
				list.add(qna);
			}
		}catch(Exception e) {
			System.out.println("1:1문의 page 예외 : " + e.getMessage());
		}
		
		closeDB(rs, st, con);
		return list;
	}



	@Override
	public S_Qna targetQna(int qid) {
		Connection con = getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		S_Qna qna = null;
		try {
			st = con.prepareStatement(Query.S_QNA_IMPL_TARGET_1);
			st.setInt(1, qid);
			rs = st.executeQuery();
			
			if(rs.next()) {
				qna = new S_Qna();
				qna.setQid(rs.getInt("QID"));
				qna.setQtitle(rs.getString("QTITLE"));
				qna.setQcontent(rs.getString("QCONTENT"));
				
			}
			
		}catch(Exception e) {
			System.out.println("Q&A 찾기 실패 : " + e.getMessage());
		}
		
		
		closeDB(rs, st, con);
		return qna;
	}

}
