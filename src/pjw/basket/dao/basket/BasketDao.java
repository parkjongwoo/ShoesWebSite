package pjw.basket.dao.basket;

import java.util.List;

import pjw.basket.model.Basket;
import pjw.basket.model.BasketListItem;

public interface BasketDao {
	List<BasketListItem> selectAllItems(String mid);
	
	boolean insert(Basket basket);
	boolean update(Basket basket);
	boolean deleteByPid(String mid, int pid);
	boolean clearBasketByMid(String mid);	
}
