package pjw.basket.dao.productlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pjw.produclistitem.dao.BaseDao;
import pjw.produclistitem.model.ProductListItem;
import pjw.produclistitem.sql.SQL;

public class BasketDaoImpl extends BaseDao implements BasketDao {

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
		List<ProductListItem> list = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.PRODUCTLIST_SELECT_POP);
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
	public List<ProductListItem> selectCateItems(int cateNum) {
		List<ProductListItem> list = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.PRODUCTLIST_SELECT_CATE);
			ps.setInt(1, cateNum);
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
	public List<ProductListItem> selectByKeyword(String keyword) {
		List<ProductListItem> list = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String queryString = "%"+keyword+"%";
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.PRODUCTLIST_SELECT_KEYWORD);
			ps.setString(1, queryString);
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
	
}
