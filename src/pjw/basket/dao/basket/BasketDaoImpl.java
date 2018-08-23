package pjw.basket.dao.basket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pjw.basket.dao.BaseDao;
import pjw.basket.model.Basket;
import pjw.basket.model.BasketListItem;
import pjw.basket.sql.SQL;

public class BasketDaoImpl extends BaseDao implements BasketDao {
	
	@Override
	public List<BasketListItem> selectAllItems(String mid) {
		List<BasketListItem> list = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.BASKET_SELECT_ALL);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			list = new ArrayList<BasketListItem>();
			while(rs.next()) {
				BasketListItem item = new BasketListItem();
				item.setMid(rs.getString(1));
				item.setPid(rs.getInt(2));
				item.setPname(rs.getString(3));
				item.setBquantity(rs.getInt(4));
				item.setPdcharge(rs.getInt(5));
				item.setPprice(rs.getInt(6));		
				list.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		return list;
	}

	@Override
	public boolean deleteByPid(String mid, int pid) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.BASKET_DELETE_BY_PID);
			ps.setInt(1, pid);
			ps.setString(2, mid);
			result = ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		return result>0;
	}

	@Override
	public boolean clearBasketByMid(String mid) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.BASKET_DELETE_ALL);
			ps.setString(1, mid);
			result = ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		return result>0;
	}

	@Override
	public boolean insert(Basket basket) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.BASKET_INSERT);
			ps.setString(1, basket.getMid());
			ps.setInt(2, basket.getPid());
			ps.setInt(3, basket.getBquantity());
			result = ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		return result>0;
	}

	@Override
	public boolean update(Basket basket) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.BASKET_UPDATE_BY_PID);
			ps.setInt(1, basket.getBquantity());
			ps.setInt(2, basket.getPid());
			ps.setString(3, basket.getMid());
			result = ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		return result>0;
	}
	
	@Override
	public boolean update(BasketListItem basketListItem) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.BASKET_UPDATE_BY_PID);
			ps.setInt(1, basketListItem.getBquantity());
			ps.setInt(2, basketListItem.getPid());
			ps.setString(3, basketListItem.getMid());
			result = ps.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		return result>0;
	}
}
