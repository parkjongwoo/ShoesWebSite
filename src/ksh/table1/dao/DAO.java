package ksh.table1.dao;

import java.util.List;

import ksh.table1.vo.NoticeVO;


public interface DAO {
	 /*
	   List<InfoVO> select(String id) throws Exception;
	   List selectRelevant(int id) throws Exception;
	   List<InfoVO> selectDay() throws Exception;
	   */
	   boolean update(NoticeVO noticeVO) throws Exception;
	   boolean insert(NoticeVO noticeVO) throws Exception;
	   List<NoticeVO> selectAll() throws Exception;
	   boolean delete(NoticeVO noticeVO) throws Exception;
	   int countNhit(int nid) throws Exception;
	   List<NoticeVO> select_page(int rquestPage) throws Exception;
	   List<NoticeVO> select(String name, int requestPage) throws Exception;
	   List<NoticeVO> selectName(String selectName, int requestPage) throws Exception;
}
