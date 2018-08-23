package yjk.mypage.buy.util;

import java.util.List;
import yjk.mypage.buy.model.s_deal;
import yjk.mypage.buy.model.s_deal_view;

public interface MyPageBuyDao {
	List<s_deal> buyselect(String mid);
	List<s_deal> buyselect2(String mid);
	List<s_deal_view> Detailselect(int did);

}
