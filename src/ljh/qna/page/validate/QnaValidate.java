package ljh.qna.page.validate;

import ljh.qna.error.QnaError;
import ljh.qna.error.model.QnaErrorModel;


public class QnaValidate {
	
	public QnaError validate(QnaErrorModel wf) {
		QnaError qnaerror = new QnaError();
		
		String title = wf.getQtitle();
		if(title==null || title.trim().isEmpty()) {
			qnaerror.setTitleerror("제목를 입력하세요!");
			qnaerror.setResult(true);
		}
		
		String content = wf.getQcontent();
		if(content==null || content.trim().isEmpty()) {
			qnaerror.setContenterror("내용을 입력하세요!");
			qnaerror.setResult(true);
		}
		return qnaerror;
	}
}
