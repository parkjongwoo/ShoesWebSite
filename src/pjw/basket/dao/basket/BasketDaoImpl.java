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
				item.setPid(rs.getInt(1));
				item.setPname(rs.getString(2));
				item.setBquantity(rs.getInt(3));
				item.setPdcharge(rs.getInt(4));
				item.setPprice(rs.getInt(5));		
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
		
		return false;
	}

	@Override
	public boolean clearBasketByMid(String mid) {
		
		return false;
	}

	@Override
	public boolean insert(Basket basket) {
		
		return false;
	}

	@Override
	public boolean update(Basket basket) {
		
		return false;
	}	
}
