package pjw.deal.dao.deal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import pjw.basket.dao.BaseDao;
import pjw.basket.model.BasketListItem;
import pjw.deal.model.Deal;
import pjw.deal.sql.SQL;

public class DealDaoImpl extends BaseDao implements DealDao {
	
	@Override
	public List<Deal> selectRecentDeal(String mid) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Deal> list = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.DEAL_SELECT_RECENT_LIST);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			list = new ArrayList<Deal>();
			while(rs.next()) {
				Deal deal = new Deal();
				deal.setDdname(rs.getString(1));
				deal.setDdphone(rs.getString(2));
				deal.setDdphone2(rs.getString(3));
				deal.setDdzipcode(rs.getString(4));
				deal.setDdadress(rs.getString(5));
				deal.setDda_detail(rs.getString(6));
				deal.setDdmsg(rs.getString(7));
				list.add(deal);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			closeDBObjects(rs, ps, con);
		}
		
		return list;
	}
	
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
			
			if("계좌이체".equals(deal.getDdmethod())) {
				ps.setNull(parameterIndex++, Types.VARCHAR);
				ps.setNull(parameterIndex++, Types.INTEGER);
				if("y".equals(deal.getDdcash_request())) {
					ps.setString(parameterIndex++, deal.getDdcash_num());
					ps.setString(parameterIndex++, deal.getDdcash_use());					
				}else {
					ps.setNull(parameterIndex++, Types.VARCHAR);
					ps.setNull(parameterIndex++, Types.VARCHAR);
				}					
			}else {
				ps.setString(parameterIndex++, deal.getDdcard());
				ps.setInt(parameterIndex++, deal.getDdinstallment());
				ps.setNull(parameterIndex++, Types.VARCHAR);
				ps.setNull(parameterIndex++, Types.VARCHAR);
			}		
			
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
		List<BasketListItem> list = deal.getDealProducts();
		
		for(BasketListItem item : list) {
			result += SQL.DEAL_INSERT_S_D_PRODUCT_TABLE;
		}
		result += SQL.DEAL_INSERT_ENDING;
		
		return result;
	}
	
	private PreparedStatement inputDProductInfo(PreparedStatement ps,Deal deal,int parameterIndex) throws SQLException {
		List<BasketListItem> list = deal.getDealProducts();
		
		for(BasketListItem item : list) {
			
			ps.setInt(parameterIndex++, item.getPid());
			ps.setInt(parameterIndex++, item.getBquantity());
		}
		return ps;
	}

	
	
	
}
