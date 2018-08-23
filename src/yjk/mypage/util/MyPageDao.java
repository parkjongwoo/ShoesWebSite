package yjk.mypage.util;

import yjk.join.model.Member;

public interface MyPageDao {
	boolean PasswordCheck(String pw);
	boolean userUpdate(String id, String pw, String name, String phone, char YN, char YN2);
}
