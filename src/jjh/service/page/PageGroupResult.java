package jjh.service.page;

public class PageGroupResult {
	
	// 하단 시작 번호
	private int groupStartNumber;
	// 하단 마지막 번호
	private int groupEndNumber;
	
	// 앞으로 페이지 넘기기
	private boolean beforePage = true;
	
	// 뒤로 페이지 넘기기
	private boolean afterPage = true;
	
	// 현재 페이지 번호
	private int selectPageNumber;

	public int getGroupStartNumber() {
		return groupStartNumber;
	}

	public int getGroupEndNumber() {
		return groupEndNumber;
	}

	public boolean isBeforePage() {
		return beforePage;
	}

	public boolean isAfterPage() {
		return afterPage;
	}

	public int getSelectPageNumber() {
		return selectPageNumber;
	}

	public void setGroupStartNumber(int groupStartNumber) {
		this.groupStartNumber = groupStartNumber;
	}

	public void setGroupEndNumber(int groupEndNumber) {
		this.groupEndNumber = groupEndNumber;
	}

	public void setBeforePage(boolean beforePage) {
		this.beforePage = beforePage;
	}

	public void setAfterPage(boolean afterPage) {
		this.afterPage = afterPage;
	}

	public void setSelectPageNumber(int selectPageNumber) {
		this.selectPageNumber = selectPageNumber;
	}
	
	
}
