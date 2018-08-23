package jjh.s_p_qna.dao;

import java.util.List;

import jjh.s_p_qna.model.S_P_Qna;
import jjh.s_product.model.S_Product;

public interface S_P_QnaDao {
	public List<S_P_Qna> selectQna(int qid);
	public List<S_P_Qna> selectALLQna();
	
}
