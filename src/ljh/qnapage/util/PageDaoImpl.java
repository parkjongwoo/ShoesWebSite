package ljh.qnapage.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ljh.qna.dao.BaseDao;


public class PageDaoImpl extends BaseDao implements PageDao{

	@Override
	public int getCount(String sql) {
		int count = 0;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				count = rs.getInt("cnt");	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
}
