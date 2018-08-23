package yjk.mypage.buy.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import yjk.mypage.buy.model.s_deal;
import yjk.mypage.buy.model.s_deal_view;
import yjk.util.BaseDao;


public class MyPageBuyDaoImpl extends BaseDao implements MyPageBuyDao {
	
    public List<s_deal> buyselect(String mid) 
    {
    	Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<s_deal> lsd = new ArrayList<s_deal>();
        try {
        	con = getConnection();
        	String sql = "SELECT DID, DTITLE, DDATE, DTOTAL, DDCHARGE, DDSTATE FROM S_DEAL WHERE MID=? AND DDATE >= add_months ( sysdate, -6 ) ORDER BY DDATE DESC";    
            st = con.prepareStatement(sql);
            st.setString(1, mid);
            rs = st.executeQuery();
            while(rs.next()) 
            {
            	s_deal sd = new s_deal();
            	sd.setDid(rs.getInt("DID"));
            	sd.setDtitle(rs.getString("DTITLE"));
            	sd.setDdate(rs.getString("DDATE"));
            	sd.setDtotal(rs.getInt("DTOTAL"));
            	sd.setDcharge(rs.getInt("DDCHARGE"));
            	sd.setDdstate(rs.getString("DDSTATE"));
            	lsd.add(sd);
            }
        }catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			closeDBOjects(rs, st, con);
        }
		return lsd;
    }
    public List<s_deal> buyselect2(String mid) 
    {
    	Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<s_deal> lsd = new ArrayList<s_deal>();
        try {
        	con = getConnection();
        	String sql = "SELECT DID, DTITLE, DDATE, DTOTAL, DDCHARGE, DDSTATE FROM S_DEAL WHERE MID=? AND DDATE >= add_months ( sysdate, -3 ) ORDER BY DDATE DESC";    
            st = con.prepareStatement(sql);
            st.setString(1, mid);
            rs = st.executeQuery();
            while(rs.next()) 
            {
            	s_deal sd = new s_deal();
            	sd.setDid(rs.getInt("DID"));
            	sd.setDtitle(rs.getString("DTITLE"));
            	sd.setDdate(rs.getString("DDATE"));
            	sd.setDtotal(rs.getInt("DTOTAL"));
            	sd.setDcharge(rs.getInt("DDCHARGE"));
            	sd.setDdstate(rs.getString("DDSTATE"));
            	lsd.add(sd);
            }
        }catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			closeDBOjects(rs, st, con);
        }
		return lsd;
    }
    public List<s_deal_view> Detailselect(int did) 
    {
    	Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<s_deal_view> lsd = new ArrayList<s_deal_view>();
        try {
        	con = getConnection();
        	String sql = "SELECT DDP.*, P.PID, P.PNAME FROM (SELECT DDATE, PID, DP_QUANTITY, DDCHARGE, DTOTAL, CID, DDSTATE FROM S_DEAL D INNER JOIN S_D_PRODUCT DP ON D.DID=DP.DID WHERE D.DID=?) DDP INNER JOIN S_PRODUCT P ON DDP.PID=P.PID";    
            st = con.prepareStatement(sql);
            st.setInt(1, did);
            rs = st.executeQuery();
            while(rs.next()) 
            {
            	s_deal_view sdv = new s_deal_view();
            	sdv.setDdate(rs.getString("ddate"));
            	sdv.setPid(rs.getInt("pid"));
            	sdv.setDp_quantity(rs.getInt("dp_quantity"));
            	sdv.setDdcharge(rs.getInt("ddcharge"));
            	sdv.setDtotal(rs.getInt("dtotal"));
            	sdv.setDdstate(rs.getString("ddstate"));
            	sdv.setPname(rs.getString("pname"));
            	lsd.add(sdv);
            }
        }catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			closeDBOjects(rs, st, con);
        }
		return lsd;
    }
   
}
