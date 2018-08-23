package yjk.login.util;

import yjk.join.model.Member;

public interface LoginDao {
	Member loginCheck(String id, String pw);
}
