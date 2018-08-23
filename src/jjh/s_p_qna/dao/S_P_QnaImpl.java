package jjh.s_p_qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jjh.dao.BaseDao;
import jjh.dao.Query;
import jjh.s_p_qna.model.S_P_Qna;
import jjh.service.page.PageManager;
import jjh.service.page.PageRowResult;
import jjh.service.sql.PagingSql;

public class S_P_QnaImpl extends BaseDao implements S_P_QnaDao {

	@Override
	public List<S_P_Qna> selectQna(int pid) {
		Connection con = getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		S_P_Qna qna = null;
		List<S_P_Qna> list = new ArrayList<S_P_Qna>();
		try {
			st = con.prepareStatement(Query.QNA_IMPL_SELECT_1);
			st.setInt(1, pid);
			rs = st.executeQuery();
			while(rs.next()) {
				qna = new S_P_Qna();
				qna.setQid(rs.getInt("QID"));
				qna.setQtitle(rs.getString("QTITLE"));
				qna.setQcontent(rs.getString("QCONTENT"));
				qna.setQdate(rs.getDate("QDATE"));
				qna.setQhit(rs.getInt("QHIT"));
				if(rs.getString("MAUTH").equals("A")) {
					qna.setMid("관리자");
				}else {
					qna.setMid(rs.getString("MID"));
				}
				
				qna.setPid(pid);
				list.add(qna);
			}
		}catch(Exception e) {
			System.out.println("QNA query 예외 : " + e.getMessage());
		}
		closeDB(rs, st, con);
		return list;
	}

	@Override
	public List<S_P_Qna> selectALLQna() {
		Connection con = getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		S_P_Qna qna = null;
		List<S_P_Qna> list = new ArrayList<S_P_Qna>();
		try {
			st = con.prepareStatement(Query.QNA_IMPL_SELECTALL);
			rs = st.executeQuery();
			while(rs.next()) {
				qna = new S_P_Qna();
				qna.setQid(rs.getInt("QID"));
				qna.setQtitle(rs.getString("QTITLE"));
				qna.setQcontent(rs.getString("QCONTENT"));
				qna.setQdate(rs.getDate("QDATE"));
				qna.setQhit(rs.getInt("QHIT"));
				qna.setMid(rs.getString("MID"));
				qna.setPid(rs.getInt("PID"));
				qna.setMauth(rs.getString("MAUTH"));
				qna.setMname(rs.getString("MNAME"));
				list.add(qna);
			}
		}catch(Exception e) {
			System.out.println("QNA query 예외 : " + e.getMessage());
		}
		closeDB(rs, st, con);
		return list;
	}
	
	public List<S_P_Qna> selectPage(int requestPage) {
		Connection con = getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		S_P_Qna qna = null;
		List<S_P_Qna> list = new ArrayList<S_P_Qna>();
		try {
			st = con.prepareStatement(Query.QNA_IMPL_PAGE_2);
			
			PageManager pm = new PageManager(requestPage);
			pm.setsql(PagingSql.SELECT_ALL_COUNT_S_P_QNA);
			PageRowResult prr = pm.getPageRowResult();
			st.setInt(1, prr.getRowStartNumber());
			st.setInt(2, prr.getRowEndNumber());
			rs = st.executeQuery();
			while(rs.next()) {
				qna = new S_P_Qna();
				qna.setPid(rs.getInt("PID"));
				qna.setQid(rs.getInt("QID"));
				qna.setQtitle(rs.getString("QTITLE"));
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
			System.out.println("QNA page 예외 : " + e.getMessage());
		}
		
		closeDB(rs, st, con);
		return list;
	}
	
	public void insertQna(S_P_Qna qna) {
		Connection con = getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement(Query.QNA_IMPL_INSERT_4);
			st.setString(1, qna.getQtitle());
			st.setString(2, qna.getQcontent());
			st.setString(3, qna.getMid());
			st.setInt(4, qna.getPid());
			st.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		closeDB(rs, st, con);

	}
	
	public S_P_Qna targetPid(int qid) {
		Connection con = getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		S_P_Qna qna = new S_P_Qna();
		try {
			st = con.prepareStatement(Query.QNA_IMPL_TARGET_QNA_1);
			st.setInt(1, qid);
			rs = st.executeQuery();
			
			if(rs.next()) {
				qna.setQid(rs.getInt("QID"));
				qna.setQtitle(rs.getString("QTITLE"));
				qna.setQcontent(rs.getString("QCONTENT"));
				qna.setQdate(rs.getDate("QDATE"));
				qna.setQhit(rs.getInt("QHIT"));
				qna.setMid(rs.getString("MID"));
				qna.setPid(rs.getInt("PID"));
				qna.setMauth(rs.getString("MAUTH"));
				qna.setMname(rs.getString("MNAME"));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		closeDB(rs, st, con);
		return qna;
	}
	
	public void answerQna(S_P_Qna qna) {
		Connection con = getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement(Query.QNA_IMPL_ANSWER_QNA_5);
			st.setString(1, qna.getQtitle());
			st.setString(2, qna.getQcontent());
			st.setInt(3, qna.getQparent());
			st.setString(4, qna.getMid());
			st.setInt(5, qna.getPid());
			st.executeUpdate();
		}catch(Exception e) {
			System.out.println("qna answer 실패 : " + e.getMessage());
		}
		closeDB(rs, st, con);
	}

}
