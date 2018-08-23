package jjh.service.page;

import jjh.service.sql.PagingSql;

public class PageManager {
	
	private int requestPage;
	
	public PageManager() {
		
	}
	public PageManager(int requestPage) {
		this.requestPage = requestPage;
	}
	
	public PageRowResult getPageRowResult() {
		
		int rowEndNumber = requestPage*PageInfo.ROW_COUNT_PER_PAGE;
		int rowStartNumber = rowEndNumber-PageInfo.ROW_COUNT_PER_PAGE+1;
//		rowStartNumber = rowStartNumber + (PageInfo.ROW_COUNT_PER_PAGE * (requestPage-1));
//		rowEndNumber = rowStartNumber + PageInfo.ROW_COUNT_PER_PAGE-1;
		
		
		PageRowResult pageRowResult = new PageRowResult();
		pageRowResult.setRowStartNumber(rowStartNumber);
		pageRowResult.setRowEndNumber(rowEndNumber);

		return pageRowResult;
	}
	
	String sql = null;
	
	public void setsql(String sql) {
		this.sql = sql;
	}
	
	public PageGroupResult getPageGroupResult(String sql) {
		PageGroupResult pageGroupResult = new PageGroupResult();
		Double temp = (double)requestPage/(double)PageInfo.SHOW_PAGE_COUNT;
		
		int groupEndNumber = (int)(Math.ceil(temp) * PageInfo.SHOW_PAGE_COUNT);
		int groupStartNumber = groupEndNumber-PageInfo.SHOW_PAGE_COUNT+1;
		
		pageGroupResult.setGroupStartNumber(groupStartNumber);
		pageGroupResult.setGroupEndNumber(groupEndNumber);

		PageDao pageDao = new PageDaoImpl();
		int dbtotalPage = pageDao.getCount(sql);
		int totalPage = 0;
		double tmp = (double)dbtotalPage/(double)PageInfo.ROW_COUNT_PER_PAGE;

		totalPage = (int)(Math.ceil(tmp));

		if(pageGroupResult.getGroupEndNumber() > totalPage) {
			pageGroupResult.setGroupEndNumber(totalPage);
		}
		//before, after 유무
		if(pageGroupResult.getGroupStartNumber()==1) {
			pageGroupResult.setBeforePage(false);
		}
		if(pageGroupResult.getGroupEndNumber() == totalPage) {
			pageGroupResult.setAfterPage(false);
		}
		
		// 선택페이지 set
		pageGroupResult.setSelectPageNumber(requestPage);

		return pageGroupResult;
	}

}
