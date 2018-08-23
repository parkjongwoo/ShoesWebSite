package jjh.s_product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jjh.dao.BaseDao;
import jjh.dao.Query;
import jjh.s_product.model.S_Product;

public class S_ProductImpl extends BaseDao implements S_ProductDao {

	@Override
	public S_Product selectProductByid(int pid) {
		Connection con = getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		S_Product s_product = null;
		try {
			st = con.prepareStatement(Query.PRODUCT_IMPL_SELECT_1);
			st.setInt(1, pid);
			rs = st.executeQuery();
			
			if(rs.next()) {
				s_product = new S_Product();
				s_product.setPid(rs.getInt("PID"));
				s_product.setPname(rs.getString("PNAME"));
				s_product.setPimg_url(rs.getString("PIMG_URL"));
				s_product.setPoption(rs.getString("POPTION"));
				s_product.setPhome(rs.getString("PHOME"));
				s_product.setPdcharge(rs.getInt("PDCHARGE"));
				s_product.setPprice(rs.getInt("PPRICE"));
				s_product.setPdescription(rs.getString("PDESCRIPTION"));
				s_product.setPdate(rs.getDate("PDATE"));
				
			}
		}catch(Exception e) {
			System.out.println("selectByID 예외 : " + e.getMessage());
		}
		closeDB(rs, st, con);
		return s_product;
	}

}
