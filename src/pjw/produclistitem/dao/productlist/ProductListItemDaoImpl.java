package pjw.produclistitem.dao.productlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pjw.produclistitem.dao.BaseDao;
import pjw.produclistitem.model.ProductListItem;
import pjw.produclistitem.sql.SQL;

public class ProductListItemDaoImpl extends BaseDao implements ProductListItemDao {

	@Override
	public List<ProductListItem> selectNewItems() {
		List<ProductListItem> list = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.PRODUCTLIST_SELECT_NEW);
			rs = ps.executeQuery();
			list = new ArrayList<ProductListItem>();
			while(rs.next()) {
				ProductListItem item = new ProductListItem();
				item.setPid(rs.getInt(1));
				item.setPname(rs.getString(2));
				item.setPimgurl(rs.getString(3));
				item.setCname(rs.getString(4));
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
	public List<ProductListItem> selectPopItems() {
		// TODO Auto-generated method stub
		return null;
	}

}
