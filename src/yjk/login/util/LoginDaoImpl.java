package yjk.login.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import yjk.join.model.Member;
import yjk.util.BaseDao;


public class LoginDaoImpl extends BaseDao implements LoginDao {
	
	// 로그인시 아이디, 비밀번호 체크 메서드
    // 아이디, 비밀번호를 인자로 받는다.
    public Member loginCheck(String id, String pw) 
    {
    	Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
        Member member = new Member();
        String dbPW = ""; // db에서 꺼낸 비밀번호를 담을 변수
        try {
            // 쿼리 - 먼저 입력된 아이디로 DB에서 비밀번호를 조회한다.
        	String sql = "SELECT * FROM s_member WHERE mid=?";
            con = getConnection();
            st = con.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            if (rs.next()) // 입려된 아이디에 해당하는 비번 있을경우
            {
                dbPW = rs.getString("MPW"); // 비번을 변수에 넣는다.
                if(dbPW.equals(pw)) {
                     // 넘겨받은 비번과 꺼내온 배번 비교. 같으면 인증성공
                	member.setMid(rs.getString("MID"));
                	member.setMpw(rs.getString("MPW"));
                	member.setMname(rs.getString("MNAME"));
                	member.setMphone(rs.getString("MPHONE"));
                	member.setMagree_email(rs.getString("MAGREE_EMAIL").charAt(0));
                	member.setMagree_sms(rs.getString("MAGREE_SMS").charAt(0));
                	member.setMauth(rs.getString("MAUTH").charAt(0));
                	member.setValidate(1);
                }
                else{                 
                     // DB의 비밀번호와 입력받은 비밀번호 다름, 인증실패
                	member.setValidate(0);
                }
            }else {
                 // 해당 아이디가 없을 경우
            	member.setValidate(-1);
            }
        }catch(Exception e) {
			e.getStackTrace();
		}finally {
			closeDBOjects(rs, st, con);
        }
		return member;
    } // end loginCheck()
}
