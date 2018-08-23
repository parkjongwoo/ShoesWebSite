package ksh.table1.pageDao.page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ksh.table1.dao.BaseDao2;
import ksh.table1.sql.CountSql;


public class PageDaoImpl extends BaseDao2 implements PageDao{

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
			closeDBOjects(rs, st, con);
		}
		
		return Apage;
	}
}
