package kjs.S_Product_InsertDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kjs.S_ProductInsertModel.InsertModel;
import kjs.S_ProductInsertModel.ValueModel;
import kjs.S_Product_DBDao.BaseDao;
import kjs.S_Product_PageModel.PageRowResult;
import kjs.S_Product_util.PageManager;



public class InsertImpl extends BaseDao implements InsertInterface {

	
	@Override
	public boolean Insert(InsertModel insertmodel) {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		boolean a=false;
		
		con=getConnection();
		String sql="INSERT INTO S_PRODUCT VALUES(seq_ss_product_pid.NEXTVAL,?,?,?,?,?,?,?,SYSDATE,?,?) ";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, insertmodel.getPname());
			ps.setString(2, insertmodel.getPimg_url());
			ps.setString(3,insertmodel.getPoption());
			ps.setString(4, insertmodel.getPhome());
			ps.setInt(5, insertmodel.getPdcharge());
			ps.setInt(6,insertmodel.getPprice());
			ps.setString(7,insertmodel.getPdescription());
			ps.setString(8,insertmodel.getPpost_yn());
			ps.setInt(9,insertmodel.getCid());
			
			ps.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return a;
	}

	@Override
	public List<InsertModel> selectAll(int requestPage) {
		Connection con=null;
		PreparedStatement st = null;
		ResultSet rs = null;
		List<InsertModel> lm = new ArrayList<InsertModel>();	
		try {
			con = getConnection();
			String sql = "SELECT * FROM "
					+ " (SELECT ROWNUM rn, memos.* FROM (SELECT p.*,c.cname FROM s_product p inner join s_p_cate c on p.cid=c.cid) memos) WHERE rn BETWEEN ? AND ?";
			st = con.prepareStatement(sql);
			
			//페이징 처리
			PageManager pageManager = new PageManager(requestPage);
			PageRowResult pageRowResult = pageManager.getPageRowResult();

			st.setInt(1, pageRowResult.getRowStartNumber());
			st.setInt(2, pageRowResult.getRowEndNumber());
			
			rs =st.executeQuery();
			
			while(rs.next()) {
				InsertModel vm = new InsertModel();
				vm.setPname(rs.getString("pname"));
				vm.setPimg_url(rs.getString("pimg_url"));
				vm.setPoption(rs.getString("poption"));
				vm.setPhome(rs.getString("phome"));
				vm.setPdcharge(rs.getInt("pdcharge"));
				vm.setPprice(rs.getInt("pprice"));
				vm.setPpost_yn(rs.getString("Ppost_yn"));
				vm.setCid(rs.getInt("cid"));
				vm.setCname(rs.getString("cname"));
				lm.add(vm);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, st, con);
		}
		return lm;
	}

	@Override
	public List<ValueModel> select() {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<ValueModel> list = new ArrayList<ValueModel>();
		try {
		con=getConnection();
		String sql="SELECT * FROM S_P_CATE";
		ps=con.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			ValueModel vmo=new ValueModel();			
			vmo.setCname(rs.getString("cname"));
			vmo.setCid(rs.getInt("cid"));
			list.add(vmo);
		}		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeDBObjects(rs, ps, con);
		}
		return list;
	}


	
		


}

