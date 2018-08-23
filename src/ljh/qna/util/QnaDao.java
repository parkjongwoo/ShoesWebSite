package ljh.qna.util;

import java.util.List;

import ljh.qna.model.Qna_model;


public interface QnaDao {
	List<Qna_model> select(int rquestPage);
	boolean insert(Qna_model qna);
	boolean update(Qna_model qna);
	boolean delete(int qid);
	boolean updatecount(int qid);
	Qna_model detail(int qid);
	List<Qna_model> selectAll();
}
