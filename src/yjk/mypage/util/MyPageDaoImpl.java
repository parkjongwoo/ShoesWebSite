package yjk.mypage.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import yjk.join.model.Member;
import yjk.util.BaseDao;


public class MyPageDaoImpl extends BaseDao implements MyPageDao {
	
	// 로그인시 아이디, 비밀번호 체크 메서드
    // 아이디, 비밀번호를 인자로 받는다.
    public boolean PasswordCheck(String pw) 
    {
    	Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
        boolean pck_result= false;
        try {
            // 쿼리 - 먼저 입력된 아이디로 DB에서 비밀번호를 조회한다.
        	String sql = "SELECT * FROM s_member WHERE mpw=?";
            con = getConnection();
            st = con.prepareStatement(sql);
            st.setString(1, pw);
            rs = st.executeQuery();
            if (rs.next()) // 입려된 아이디에 해당하는 비번 있을경우
            {
            	pck_result = true;
            }
        }catch(Exception e) {
			e.getStackTrace();
		}finally {
			closeDBOjects(rs, st, con);
        }
		return pck_result;
    }
    public boolean userUpdate(String id, String pw, String name, String phone, char YN, char YN2) {
    	Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean userUpdate_result= false;
		try {
            // 쿼리 - 먼저 입력된 아이디로 DB에서 비밀번호를 조회한다.
        	String sql = "UPDATE s_member SET mpw=?,mname=?,mphone=?,magree_email=?,magree_sms=? WHERE mid=?";
            con = getConnection();
            st = con.prepareStatement(sql);
            st.setString(1, pw);
            st.setString(2, name);
            st.setString(3, phone);
            st.setString(4, String.valueOf(YN));
            st.setString(5, String.valueOf(YN2));
            st.setString(6, id);
            int a = st.executeUpdate();
            if(a>0) {
            	userUpdate_result = true;
            }
        }catch(Exception e) {
			e.getStackTrace();
		}finally {
			closeDBOjects(rs, st, con);
        }
		return userUpdate_result;
    }
}
