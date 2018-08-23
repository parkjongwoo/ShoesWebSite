package yjk.mypage.comment.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import yjk.join.model.Member;
import yjk.mypage.comment.model.s_p_comment;
import yjk.util.BaseDao;


public class MyPageCommentDaoImpl extends BaseDao implements MyPageCommentDao {
	
	// 로그인시 아이디, 비밀번호 체크 메서드
    // 아이디, 비밀번호를 인자로 받는다.
    public boolean commentInsert(s_p_comment comment) 
    {
    	Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean commentresult = false;
        try {
            // 쿼리 - 먼저 입력된 아이디로 DB에서 비밀번호를 조회한다.
        	String sql = "INSERT INTO S_P_COMMENT VALUES(SEQ_SS_COMMENT_CID.NEXTVAL,?,?,sysdate)";
            con = getConnection();
            con.setAutoCommit(false);
            st = con.prepareStatement(sql);
            st.setString(1, comment.getCtitle());
            st.setString(2, comment.getCcontent());
            st.executeUpdate();
            String sql2 = "UPDATE S_D_PRODUCT SET CID=SEQ_SS_COMMENT_CID.CURRVAL WHERE DID=? AND PID=?";
            st = con.prepareStatement(sql2);
            st.setInt(1, comment.getDid());
            st.setInt(2, comment.getPid());
            st.executeUpdate();
            con.commit();
        }catch(Exception e) {
			e.getStackTrace();
		}finally {
			closeDBOjects(rs, st, con);
        }
        return commentresult;
    }
    public int select_comment(int did, int pid) {
    	Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		int select_comment_result = 0;
		try {
		con = getConnection();
    	String sql = "SELECT cid FROM S_D_PRODUCT WHERE did=? and pid=? and cid is not null";    
        st = con.prepareStatement(sql);
        st.setInt(1, did);
        st.setInt(2, pid);
        rs = st.executeQuery();
        while(rs.next()) 
        {
        	select_comment_result = rs.getInt("cid");
        }
    }catch(Exception e) {
		System.out.println(e.getMessage());
	}finally {
		closeDBOjects(rs, st, con);
    }
	return select_comment_result;
    }
    public s_p_comment contenttitle(int cid) {
    	Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		s_p_comment spc = new s_p_comment();
		try {
		con = getConnection();
    	String sql = "SELECT ctitle,ccontent FROM S_p_comment WHERE cid=?";    
        st = con.prepareStatement(sql);
        st.setInt(1, cid);
        rs = st.executeQuery();
        while(rs.next()) 
        {
        	spc.setCtitle(rs.getString("ctitle"));
        	spc.setCcontent(rs.getString("ccontent"));
        }
    }catch(Exception e) {
		System.out.println(e.getMessage());
	}finally {
		closeDBOjects(rs, st, con);
    }
	return spc;
    }
}
