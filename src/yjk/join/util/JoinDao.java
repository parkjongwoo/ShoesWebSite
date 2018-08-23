package yjk.join.util;

import yjk.join.model.Member;

public interface JoinDao {
	boolean selectByMid(String mid);
	boolean member_insert(Member member);
}
