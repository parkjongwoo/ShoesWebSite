package ksh.table1.dao.noticeDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ksh.table1.dao.BaseDAO;
import ksh.table1.dao.DAO;
import ksh.table1.model.page.PageRowResult;
import ksh.table1.service.PageManager;
import ksh.table1.sql.NoticeSql;
import ksh.table1.vo.NoticeVO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ksh.table1.dao.BaseDAO;
import ksh.table1.dao.DAO;
import ksh.table1.model.page.PageRowResult;
import ksh.table1.service.PageManager;
import ksh.table1.sql.NoticeSql;
import ksh.table1.vo.NoticeVO;


public class implDAO extends BaseDAO implements DAO {
   boolean onOff = false;

   @Override
   public List<NoticeVO> selectAll(){
         List<NoticeVO> list = new ArrayList<NoticeVO>();
         PreparedStatement st;
         try {
            st = getConnection().prepareStatement(NoticeSql.SELECT_ALL_SQL);
         
         ResultSet rs = st.executeQuery();  
   
         
         while(rs.next()) {
            NoticeVO noticeVO = new NoticeVO();
            
            noticeVO.setNid(rs.getInt("NID"));
            noticeVO.setMid(rs.getString("MID"));
            noticeVO.setNtitle(rs.getString("NTITLE"));
            noticeVO.setNcontent(rs.getString("NCONTENT"));
            noticeVO.setNhit(rs.getInt("NHIT"));
            noticeVO.setNdate(rs.getString("NDATE"));
            
            list.add(noticeVO);
         }
         rs.close(); st.close(); getConnection().close();
         } catch (SQLException e) { e.printStackTrace(); } catch (Exception e) { e.printStackTrace(); }
         
         
      return list;
   }
   public List<NoticeVO> select_page(int rquestPage) throws Exception{
      
        PreparedStatement st = null;
       
        List<NoticeVO> list = new ArrayList<NoticeVO>();   
        try {
           
           st = getConnection().prepareStatement(NoticeSql.SELECT_PAGE_SQL);
         
           //페이징 처리
           PageManager pageManager = new PageManager(rquestPage);
           PageRowResult pageRowResult = pageManager.getPageRowResult();
           System.out.println(pageRowResult.getRowStartNumber());
           System.out.println(pageRowResult.getRowEndNumber());
           st.setInt(1, pageRowResult.getRowStartNumber());
           st.setInt(2, pageRowResult.getRowEndNumber());
           ResultSet rs = st.executeQuery();  
        
           while(rs.next()) {
             NoticeVO noticeVO = new NoticeVO();
             noticeVO.setNid(rs.getInt("NID"));
            noticeVO.setMid(rs.getString("MID"));
            noticeVO.setNtitle(rs.getString("NTITLE"));
            noticeVO.setNcontent(rs.getString("NCONTENT"));
            noticeVO.setNhit(rs.getInt("NHIT"));
            noticeVO.setNdate(rs.getString("NDATE"));
            list.add(noticeVO);   
              
           }
           rs.close(); st.close(); getConnection().close();
        } catch (SQLException e) {
           System.out.println("SELECT문 실패 : " + e.getMessage());
        } 

        return list;
     }
   @Override
   public boolean insert(NoticeVO noticeVO) throws Exception {
      PreparedStatement st = getConnection().prepareStatement(NoticeSql.INSERT_SQL);
      
      st.setString(1, noticeVO.getNtitle()); 
      st.setString(2, noticeVO.getNcontent());
      st.setString(3, noticeVO.getMid());
      
      if(0<st.executeUpdate()) { onOff = true; }
      
      st.close();
      getConnection().close();
      
      return onOff;
   }

   @Override
   public boolean update(NoticeVO noticeVO) throws Exception {
      

      
      PreparedStatement st = getConnection().prepareStatement(NoticeSql.UPDATE_SQL);
      st.setString(1, noticeVO.getNtitle()); 
      st.setString(2, noticeVO.getNcontent());  
      st.setString(3, noticeVO.getMid());  
      st.setInt(4, noticeVO.getNid());   
      if(0<st.executeUpdate()) { onOff = true; }
      
      st.close();
      getConnection().close();
      
      return onOff;
      
   }

   @Override
   

   public boolean delete(NoticeVO noticeVO) throws Exception{
      PreparedStatement st = getConnection().prepareStatement(NoticeSql.DELETE_SQL);
      st.setInt(1, noticeVO.getNid()); 
      st.setString(2, noticeVO.getMid()); 
      if(0<st.executeUpdate()) { onOff = true; }
      
      st.close();
      getConnection().close();
      
      return onOff;
   }

   public int countNhit(int nid) throws Exception {
      int nhit = 0;
      PreparedStatement st = getConnection().prepareStatement(NoticeSql.UPDATE_NHIT_SQL);
      st.setInt(1, nid); 
      
      if(0<st.executeUpdate()) { onOff = true; } else { onOff = false; }
      String selectSql ="SELECT nhit FROM s_notice WHERE nid = ?";
      st = getConnection().prepareStatement(NoticeSql.SELECT_NHIT_SQL);
      st.setInt(1, nid);
      ResultSet rs = st.executeQuery();
      
      if(rs.next()) {
         nhit = rs.getInt("nhit");
      }
      
      rs.close();
      st.close();
      getConnection().close();
      
      return nhit;
      
   }
   @Override
   public List<NoticeVO> select(String name, int requestPage) throws Exception {
      name = '%'+name+'%';
      PreparedStatement st = null;
          
        List<NoticeVO> list = new ArrayList<NoticeVO>();   
        try {
           
           st = getConnection().prepareStatement(NoticeSql.SELECT_SQL);
         
           //페이징 처리
           PageManager pageManager = new PageManager(requestPage);
           PageRowResult pageRowResult = pageManager.getPageRowResult();
           st.setString(1, name);
           st.setInt(2, pageRowResult.getRowStartNumber());
           st.setInt(3, pageRowResult.getRowEndNumber());
           ResultSet rs = st.executeQuery();  
        
           while(rs.next()) {
             NoticeVO noticeVO = new NoticeVO();
             noticeVO.setNid(rs.getInt("NID"));
            noticeVO.setMid(rs.getString("MID"));
            noticeVO.setNtitle(rs.getString("NTITLE"));
            noticeVO.setNcontent(rs.getString("NCONTENT"));
            noticeVO.setNhit(rs.getInt("NHIT"));
            noticeVO.setNdate(rs.getString("NDATE"));
            list.add(noticeVO);   
              
           }
           rs.close(); st.close(); getConnection().close();
        } catch (SQLException e) {
           System.out.println("SELECT문 실패 : " + e.getMessage());
        } 

        return list;
   }
   public List<NoticeVO> selectName(String selectName, int requestPage) throws Exception {
      selectName = '%'+selectName+'%';
      PreparedStatement st = null;
          
        List<NoticeVO> list = new ArrayList<NoticeVO>();   
        try {
           
           st = getConnection().prepareStatement(NoticeSql.SELECT_MID_SQL);
         
           //페이징 처리
           PageManager pageManager = new PageManager(requestPage);
           PageRowResult pageRowResult = pageManager.getPageRowResult();
           st.setString(1, selectName);
           st.setInt(2, pageRowResult.getRowStartNumber());
           st.setInt(3, pageRowResult.getRowEndNumber());
           ResultSet rs = st.executeQuery();  
        
           while(rs.next()) {
             NoticeVO noticeVO = new NoticeVO();
             noticeVO.setNid(rs.getInt("NID"));
            noticeVO.setMid(rs.getString("MID"));
            noticeVO.setNtitle(rs.getString("NTITLE"));
            noticeVO.setNcontent(rs.getString("NCONTENT"));
            noticeVO.setNhit(rs.getInt("NHIT"));
            noticeVO.setNdate(rs.getString("NDATE"));
            list.add(noticeVO);   
              
           }
           rs.close(); st.close(); getConnection().close();
        } catch (SQLException e) {
           System.out.println("SELECT문 실패 : " + e.getMessage());
        } 

        return list;
   }
}



   
   /*
   public boolean insert(NoticeVO noticeVO) throws Exception{
      
      String insertSql ="INSERT INTO CLOTHES_TABLE (CLOTHES_ID ,title ,content, price, startday, endday, class_id, set_id)  VALUES (exhibitions_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
      
      PreparedStatement st = getConnection().prepareStatement(insertSql);
      st.setString(1, infoVO.getName()); 
      st.setString(2, infoVO.getContent());  
      st.setInt(3, infoVO.getPrice());   
      st.setString(4, infoVO.getStartDay());   
      st.setString(5, infoVO.getEndDay()); 
      st.setInt(6, infoVO.getClassId());   
      st.setInt(7, infoVO.getSetId()); 
      if(0<st.executeUpdate()) { onOff = true; }
      
      st.close();
      getConnection().close();
      
      return onOff;
   }

   public boolean update(InfoVO infoVO) throws Exception{
      
      String updateSql ="UPDATE CLOTHES_TABLE SET title = ?, content = ?, price = ?, startday = ?, endday = ?, set_id = ?, class_id = ?  WHERE CLOTHES_ID = ?";
      
      PreparedStatement st = getConnection().prepareStatement(updateSql);
      st.setString(1, infoVO.getName()); 
      st.setString(2, infoVO.getContent());  
      st.setInt(3, infoVO.getPrice());   
      st.setString(4, infoVO.getStartDay());   
      st.setString(5, infoVO.getEndDay());   
      st.setInt(6, infoVO.getId()); 
      st.setInt(6, infoVO.getSetId()); 
      st.setInt(5, infoVO.getClassId());   
      if(0<st.executeUpdate()) { onOff = true; }
      
      st.close();
      getConnection().close();
      
      return onOff;
   }

   public boolean delete(int id) throws Exception{
      String deleteSql ="DELETE CLOTHES_TABLE WHERE CLOTHES_ID = ?";
      PreparedStatement st = getConnection().prepareStatement(deleteSql);
      st.setInt(1, id); 
      if(0<st.executeUpdate()) { onOff = true; }
      
      st.close();
      getConnection().close();
      
      return onOff;
   }

   @Override
   public List<InfoVO> select(String name) throws Exception{
      
      name = '%'+name+'%';
      System.out.println(name+" =======select======= ");
      List<InfoVO> list = new ArrayList<InfoVO>();
      String selectSql ="SELECT * FROM CLOTHES_TABLE WHERE title LIKE ?";
      PreparedStatement st = getConnection().prepareStatement(selectSql);
      st.setString(1, name); 
      ResultSet rs = st.executeQuery();  
      while(rs.next()) {
      InfoVO infoVO = new InfoVO();
      infoVO.setId(rs.getInt("CLOTHES_ID"));
      infoVO.setName(rs.getString("title"));
      infoVO.setContent(rs.getString("content"));
      infoVO.setPrice(rs.getInt("price"));
      infoVO.setSetId(rs.getInt("set_Id"));
      infoVO.setClassId(rs.getInt("class_Id"));
      infoVO.setStartDay(rs.getString("startday").substring(0, 10));
      infoVO.setEndDay(rs.getString("endday").substring(0, 10));
      list.add(infoVO);
      }
      rs.close();
      st.close();
      getConnection().close();
      
      return list;
   }

   public List<InfoVO> selectDay() throws Exception{
      String selectAllSql ="SELECT * FROM CLOTHES_TABLE WHERE to_char(startday, 'YY/MM/DD') = to_char(sysdate, 'YY/MM/DD') and to_char(sysdate, 'YY/MM/DD') <= to_char(endday, 'YY/MM/DD') order by CLOTHES_ID";
      List<InfoVO> list = new ArrayList<InfoVO>();
      PreparedStatement st = getConnection().prepareStatement(selectAllSql);
      st.executeUpdate();
      ResultSet rs = st.executeQuery();  
      
      while(rs.next()) {
         InfoVO infoVO = new InfoVO();
         infoVO.setId(rs.getInt("CLOTHES_ID"));
         infoVO.setName(rs.getString("title"));
         infoVO.setContent(rs.getString("content"));
         infoVO.setPrice(rs.getInt("price"));
         infoVO.setStartDay(rs.getString("startday").substring(0, 10));
         infoVO.setEndDay(rs.getString("endday").substring(0, 10));
         infoVO.setClassId(rs.getInt("class_id"));
         infoVO.setSetId(rs.getInt("set_id"));
         
         list.add(infoVO);
      }
      
      rs.close();
      st.close();
      getConnection().close();
      
      return list;
   }
   
   
      
      rs.close();
      st.close();
      getConnection().close();
      
      return list;
   }

   @SuppressWarnings("null")
   public List selectRelevant(int id) throws Exception {
      
      System.out.println(id+"======relevantSelect=====");
      
      List<List> list = new ArrayList<List>();
      List<InfoVO> listClass  = new ArrayList<InfoVO>();
      List<InfoVO> listSet =  new ArrayList<InfoVO>();
      
      String relevantSQL ="select class_id, set_id from CLOTHES_TABLE where CLOTHES_ID = ?";
      PreparedStatement st = getConnection().prepareStatement(relevantSQL);
      st.setInt(1, id); 
      st.executeUpdate();
      ResultSet rs = st.executeQuery();  

      int classId = 0;
      int setId = 0;
      if(rs.next()) {
         classId = rs.getInt("class_id");
         setId = rs.getInt("set_id");
      }
      System.out.println(classId);
      System.out.println(setId);
      
      relevantSQL ="select * from CLOTHES_TABLE a join CLASSIFICATION_table b on a.class_id = b.class_id where a.class_id = ?";
      st = getConnection().prepareStatement(relevantSQL);
      st.setInt(1, classId); 
      st.executeUpdate();
      rs = st.executeQuery();  
      // 의류관련 검색
      while(rs.next()) {
         InfoVO infoVO = new InfoVO();
         infoVO.setId(rs.getInt("CLOTHES_ID"));
         infoVO.setName(rs.getString("title"));
         infoVO.setContent(rs.getString("content"));
         infoVO.setPrice(rs.getInt("price"));
         infoVO.setStartDay(rs.getString("startday").substring(0, 10));
         infoVO.setEndDay(rs.getString("endday").substring(0, 10));
         infoVO.setClassId(rs.getInt("class_id"));
         infoVO.setSetId(rs.getInt("set_id"));
         
         listClass.add(infoVO);
      }
      // 세트관련 검색
      relevantSQL ="select * from CLOTHES_TABLE a join clothes_set_table b on a.set_id = b.set_id where a.set_id = ?";
      st = getConnection().prepareStatement(relevantSQL);
      st.setInt(1, setId);
      st.executeUpdate();
      rs = st.executeQuery();  
      while(rs.next()) {
         InfoVO infoVO = new InfoVO();
         infoVO.setId(rs.getInt("clothes_id"));
         infoVO.setName(rs.getString("title"));
         infoVO.setContent(rs.getString("content"));
         infoVO.setPrice(rs.getInt("price"));
         infoVO.setStartDay(rs.getString("startday").substring(0, 10));
         infoVO.setEndDay(rs.getString("endday").substring(0, 10));
         infoVO.setClassId(rs.getInt("class_id"));
         infoVO.setSetId(rs.getInt("set_id"));
         
         listSet.add(infoVO);
      }
      list.add(listClass);
      list.add(listSet);
      
      return list;
   }
    */
   


   
