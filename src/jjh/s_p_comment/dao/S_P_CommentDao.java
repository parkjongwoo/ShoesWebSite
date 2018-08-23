package jjh.s_p_comment.dao;

import java.util.List;

import jjh.s_p_comment.model.S_P_Comment;


public interface S_P_CommentDao {
	public List<S_P_Comment> selectComment(int pid); 
	public List<S_P_Comment> selectAllComment(); 
	
}
