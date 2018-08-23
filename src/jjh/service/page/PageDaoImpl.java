package jjh.service.page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jjh.dao.BaseDao;



public class PageDaoImpl extends BaseDao implements PageDao {

	@Override
	public int getCount(String sql) {
		Connection con =getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt("cnt");
			}
		}catch(Exception e) {
			
		}finally {
			closeDB(rs, st, con);
		}
		
		return cnt;
	}

}
