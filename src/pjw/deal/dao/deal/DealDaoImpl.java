package pjw.deal.dao.deal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import pjw.basket.dao.BaseDao;
import pjw.deal.model.DProduct;
import pjw.deal.model.Deal;
import pjw.deal.sql.SQL;

public class DealDaoImpl extends BaseDao implements DealDao {

	@Override
	public boolean insert(Deal deal) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		int parameterIndex = 1;
		try {
			con = getConnection();
			ps = con.prepareStatement(buildSQL(deal));
			ps.setString(parameterIndex++, deal.getMid());
			ps.setString(parameterIndex++, deal.getDtitle());
			ps.setInt(parameterIndex++, deal.getDtotal());
			ps.setInt(parameterIndex++, deal.getDdcharge());
			ps.setString(parameterIndex++, deal.getDdstate());
			ps.setString(parameterIndex++, deal.getDdname());
			ps.setString(parameterIndex++, deal.getDdphone());
			ps.setString(parameterIndex++, deal.getDdphone2());
			ps.setString(parameterIndex++, deal.getDdzipcode());
			ps.setString(parameterIndex++, deal.getDdadress());
			ps.setString(parameterIndex++, deal.getDda_detail());
			ps.setString(parameterIndex++, deal.getDdmsg());
			ps.setString(parameterIndex++, deal.getDdmethod());
			ps.setString(parameterIndex++, deal.getDdcard());
			ps.setInt(parameterIndex++, deal.getDdinstallment());
			ps.setString(parameterIndex++, deal.getDdcash_num());
			ps.setString(parameterIndex++, deal.getDdcash_use());
			
			inputDProductInfo(ps,deal,parameterIndex);
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		return result>0;
	}
	
	private String buildSQL(Deal deal) {
		String result = SQL.DEAL_INSERT;
		List<DProduct> list = deal.getDealProducts();
		
		for(DProduct item : list) {
			result += SQL.DEAL_INSERT_S_D_PRODUCT_TABLE;
		}
		result += SQL.DEAL_INSERT_ENDING;
		
		return result;
	}
	
	private PreparedStatement inputDProductInfo(PreparedStatement ps,Deal deal,int parameterIndex) throws SQLException {
		List<DProduct> list = deal.getDealProducts();
		
		for(DProduct item : list) {
			ps.setInt(parameterIndex++, item.getPid());
			ps.setInt(parameterIndex++, item.getDp_quantity());
		}
		return ps;
	}
	
}
