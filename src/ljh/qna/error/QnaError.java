package ljh.qna.error;

public class QnaError {
	private String titleerror;
	private String contenterror;
	private boolean result;
	
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getTitleerror() {
		return titleerror;
	}
	public void setTitleerror(String titleerror) {
		this.titleerror = titleerror;
	}
	public String getContenterror() {
		return contenterror;
	}
	public void setContenterror(String contenterror) {
		this.contenterror = contenterror;
	}
	
}	
