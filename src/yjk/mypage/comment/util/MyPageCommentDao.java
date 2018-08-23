package yjk.mypage.comment.util;

import yjk.join.model.Member;
import yjk.mypage.comment.model.s_p_comment;

public interface MyPageCommentDao {
	boolean commentInsert(s_p_comment comment);
	int select_comment(int did,int pid);
	s_p_comment contenttitle(int cid);
}
