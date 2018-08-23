package kjs.S_Product_PageDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kjs.S_Product_DBDao.BaseDao;
import kjs.S_Product_util.CountSql;


public class PageDaoImpl extends BaseDao implements PageInterface{

	public int getCount(String sql) {
		int Apage=0;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			sql = CountSql.MEMO_SELECT_ALL_COUNT_SQL;
			st = con.prepareStatement(sql);
			rs =st.executeQuery();
			while(rs.next()) {
			Apage = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, st, con);
		}
		
		return Apage;
	}
}
