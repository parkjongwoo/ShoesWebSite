package ljh.qna.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

import ljh.model.page.PageRowResult;
import ljh.qna.dao.BaseDao;
import ljh.qna.model.Qna_model;
import ljh.qna.pageservice.PageManager;


public class QnaDaoImpl extends BaseDao implements QnaDao{

	public static final String MEMO_SELECT_PAGE_SQL=
			 "select RN, qid, QTITLE, QCONTENT, qdate, qhit, MID, MAUTH, Mname"
			         + " from(select rownum rn, Q.*"
			         + " from(select * from S_QNA_VIEW order by s_qna_view.qid desc) Q)"
			         + " where rn between ? and ? ";
			
	
	public boolean insert(Qna_model qna) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean result = false;
	
		try {
			
			con = getConnection();
			String sql = "insert into s_qna values(seq_ss_qna_qid.nextval,?,?,sysdate,?,null,?)";
			st = con.prepareStatement(sql);
			st.setString(1, qna.getQtitle());
			st.setString(2, qna.getQcontent());
			st.setInt(3, 0);
			st.setString(4, qna.getMid());
			
			int flag = st.executeUpdate();
			if(flag>0) {
				result = true;
				con.commit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDBOjects(rs, st, con);
		}
		return result;
	}	
		public boolean update(Qna_model qna) {
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			boolean a = false;
			try {
				con = getConnection();
				String sql = "UPDATE s_qna SET qtitle=?, qcontent=? WHERE qid=?";
				st = con.prepareStatement(sql);
				st.setString(1, qna.getQtitle());
				st.setString(2, qna.getQcontent());
				st.setInt(3, qna.getQid());
				int i= st.executeUpdate();
				if(i>0) {
					a = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeDBOjects(rs, st, con);
			}
			return a;
		}	
		public boolean delete(int qid) {
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			boolean a = false;
			try {
				con = getConnection();
				String sql = "DELETE FROM s_qna WHERE qid=?";
				st = con.prepareStatement(sql);
				st.setInt(1, qid);
				int i= st.executeUpdate();
				if(i>0) {
					a = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeDBOjects(rs, st, con);
			}
			return a;
		}
		public List<Qna_model> selectAll(){
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			List<Qna_model> qnalist = new ArrayList<Qna_model>();	
			try {
				String sql = "select * form s_qna ";
				con = getConnection();
				st = con.prepareStatement(sql);
				rs = st.executeQuery();
				while(rs.next()) {
					Qna_model qna = new Qna_model();
					qna.setMAUTH(rs.getString("MAUTH"));
					qna.setQid(rs.getInt("QID"));
					qna.setQtitle(rs.getString("QTITLE"));
					qna.setQcontent(rs.getString("QCONTENT"));
					qna.setQdate(rs.getDate("QDATE"));
					qna.setQhit(rs.getInt("QHIT"));
					qna.setQparent(rs.getString("QPARENT"));
					qna.setMid(rs.getString("MID"));
					qna.setQname(rs.getString("MNAME"));
					qna.setRn(rs.getInt("rn"));
					qnalist.add(qna);		
				}
			} catch (SQLException e) {
				System.out.println("SELECT문 실패 : " + e.getMessage());
			} finally {
				closeDBOjects(rs, st, con);
			}

			return qnalist;
			
		}
		
		public List<Qna_model> select(int rquestPage){
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			List<Qna_model> qnalist = new ArrayList<Qna_model>();	
			try {
				con = getConnection();
				st = con.prepareStatement(MEMO_SELECT_PAGE_SQL);
				
				//페이징 처리
				PageManager pageManager = new PageManager(rquestPage);
				PageRowResult pageRowResult = pageManager.getPageRowResult();
				st.setInt(1, pageRowResult.getRowStartNumber());
				st.setInt(2, pageRowResult.getRowEndNumber());
			
				rs = st.executeQuery();
				while(rs.next()) {
					Qna_model qna = new Qna_model();
					qna.setQid(rs.getInt("QID"));
					qna.setQtitle(rs.getString("QTITLE"));
					qna.setQcontent(rs.getString("QCONTENT"));
					qna.setQdate(rs.getDate("QDATE"));
					qna.setQhit(rs.getInt("QHIT"));
					qna.setRn(rs.getInt("RN"));
					qna.setMid(rs.getString("MID"));
					qna.setQname(rs.getString("MNAME"));
					qnalist.add(qna);	
					
				}
			} catch (SQLException e) {
				System.out.println("SELECT문 실패 : " + e.getMessage());
			} finally {
				closeDBOjects(rs, st, con);
			}

			return qnalist;
		}
		 
		public Qna_model detail(int qid){
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			Qna_model qna = new Qna_model();	
			try {
				String sql = "select *from s_qna where qid=?";
				con = getConnection();
				st = con.prepareStatement(sql);
				st.setInt(1, qid);
				rs = st.executeQuery();
				while(rs.next()) {
					qna.setQid(rs.getInt("QID"));
					qna.setQtitle(rs.getString("QTITLE"));
					qna.setQcontent(rs.getString("QCONTENT"));
					qna.setQdate(rs.getDate("QDATE"));
					qna.setQhit(rs.getInt("QHIT"));
					qna.setQparent(rs.getString("QPARENT"));
					qna.setMid(rs.getString("MID"));
				}
			} catch (SQLException e) {
				System.out.println("detail문 실패 : " + e.getMessage());
			} finally {
				closeDBOjects(rs, st, con);
			}

			return qna;
		}
		public boolean updatecount(int qid) {
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			boolean result = false;
			try {
				String sql = "update s_qna set qhit=qhit+1 where qid=?";
				con = getConnection();
				st = con.prepareStatement(sql);
				st.setInt(1, qid);
				st.executeUpdate();
				
//				int flag = st.executeUpdate();
//				if(flag>0) {
//					result=true;
//					con.commit();
//				}
			} catch (SQLException e) {
				System.out.println("UPDATECOUNT문 실패 : " + e.getMessage());
			} finally {
				closeDBOjects(rs, st, con);
			}
			return result;
		}
		
}
