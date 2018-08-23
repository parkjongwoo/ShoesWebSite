package yjk.join.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import yjk.join.model.Member;
import yjk.util.BaseDao;


public class JoinDaoImpl extends BaseDao implements JoinDao {
	
	public boolean selectByMid(String mid) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean mid_check_result = false;
		try {
			con = getConnection();
			String sql = "SELECT * FROM s_member WHERE mid=?";
			st = con.prepareStatement(sql);
			st.setString(1, mid);
			rs = st.executeQuery();
			while(rs.next()) {
				mid_check_result=true;
			}
		}catch(Exception e) {
			e.getStackTrace();
		}finally {
			closeDBOjects(rs, st, con);
		}
		return mid_check_result;
	}
	public boolean member_insert(Member member) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean member_insert_result = false;
		try {
			con = getConnection();
			String sql = "INSERT INTO s_member VALUES(?,?,?,?,?,?,sysdate,'N')";
			st = con.prepareStatement(sql);
			st.setString(1, member.getMid());
			st.setString(2, member.getMpw());
			st.setString(3, member.getMname());
			st.setString(4, member.getMphone());
			st.setString(5, String.valueOf(member.getMagree_email()));
			st.setString(6, String.valueOf(member.getMagree_sms()));
			int a = st.executeUpdate();
			if(a>0) {
				member_insert_result=true;
			}
		}catch(Exception e) {
			e.getStackTrace();
		}finally {
			closeDBOjects(rs, st, con);
		}
		return member_insert_result;
	}
}
