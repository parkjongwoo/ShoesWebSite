package jjh.s_p_comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jjh.dao.BaseDao;
import jjh.dao.Query;
import jjh.s_p_comment.model.S_P_Comment;
import jjh.s_p_qna.model.S_P_Qna;

public class S_P_CommentImpl extends BaseDao implements S_P_CommentDao {

	@Override
	public List<S_P_Comment> selectComment(int pid) {
		Connection con = getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		List<S_P_Comment> list = null;
		try {
			
			st = con.prepareStatement(Query.COMMENT_IMPL_SELECT_1);
			
			st.setInt(1, pid);
			rs = st.executeQuery();
			list = new ArrayList<S_P_Comment>();
			while(rs.next()) {
				
				S_P_Comment com = new S_P_Comment();
				com.setCid(rs.getInt("CID"));
				com.setCtitle(rs.getString("CTITLE"));
				com.setCcontent(rs.getString("CCONTENT"));
				com.setCdate(rs.getDate("CDATE"));
				com.setMname(rs.getString("MNAME"));
				list.add(com);
			}
		}catch(Exception e) {
			System.out.println("comment 불러오기 실패 : " + e.getMessage());
		}
		
		closeDB(rs, st, con);
		return list;
	}

	@Override
	public List<S_P_Comment> selectAllComment() {
		Connection con = getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		List<S_P_Comment> list = null;
		
		try {
			
			st = con.prepareStatement(Query.COMMENT_IMPL_SELECTALL);
			rs = st.executeQuery();
			list = new ArrayList<S_P_Comment>();
			while(rs.next()) {
				
				S_P_Comment com = new S_P_Comment();
				com.setPid(rs.getInt("PID"));
				com.setCid(rs.getInt("CID"));
				com.setCtitle(rs.getString("CTITLE"));
				com.setCcontent(rs.getString("CCONTENT"));
				com.setCdate(rs.getDate("CDATE"));
				com.setMname(rs.getString("MNAME"));
				list.add(com);
			}
		}catch(Exception e) {
			System.out.println("comment 불러오기 실패 : " + e.getMessage());
		}
		
		closeDB(rs, st, con);
		return list;
	}

}
