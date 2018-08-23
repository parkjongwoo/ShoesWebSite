package jjh.s_qna.dao;

import java.util.List;

import jjh.s_qna.model.S_Qna;

public interface S_QnaDao {
	
	public List<S_Qna> selectAll();
	public void answerQna(S_Qna qna);
	public List<S_Qna> pagerQna(int requestPage);
	public S_Qna targetQna(int qid);
}
