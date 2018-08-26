package pjw.deal.dao.deal;

import java.util.List;

import pjw.deal.model.Deal;

public interface DealDao {
	boolean insert(Deal deal);
	List<Deal> selectRecentDeal(String mid);
}
