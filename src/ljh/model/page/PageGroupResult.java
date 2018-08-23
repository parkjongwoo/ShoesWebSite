package ljh.model.page;

public class PageGroupResult {
	private int groupStartNumber;  //밑에 게시판 이동수 1,2,3,4 의 1인 스타트 변수
	private int groupEndNumber; //밑에 게시판 이동수 1,2,3,4  의 4인 마지막 변수
	
	private boolean beforePage = true; // 페이지 제일 앞일 경우 화살표 없음
	private boolean afterPage = true; // 페이지 제일 뒤일 경우 화살표 없음
	
	private int selectPageNumber; // 현재이지 표시 할꺼!

	public int getGroupStartNumber() {
		return groupStartNumber;
	}

	public void setGroupStartNumber(int groupStartNumber) {
		this.groupStartNumber = groupStartNumber;
	}

	public int getGroupEndNumber() {
		return groupEndNumber;
	}

	public void setGroupEndNumber(int groupEndNUmber) {
		this.groupEndNumber = groupEndNUmber;
	}

	public boolean isBeforePage() {
		return beforePage;
	}

	public void setBeforePage(boolean beforePage) {
		this.beforePage = beforePage;
	}

	public boolean isAfterPage() {
		return afterPage;
	}

	public void setAfterPage(boolean afterPage) {
		this.afterPage = afterPage;
	}

	public int getSelectPageNumber() {
		return selectPageNumber;
	}

	public void setSelectPageNumber(int selectPageNumber) {
		this.selectPageNumber = selectPageNumber;
	}
	
}
