package pjw.basket.dao.basket;

import java.util.List;

import pjw.basket.model.Basket;
import pjw.basket.model.BasketListItem;

public interface BasketDao {
	List<BasketListItem> selectByPid(String mid,int quantity,int pid);
	
	List<BasketListItem> selectAllItems(String mid);
	
	boolean insert(Basket basket);
	boolean update(Basket basket);
	boolean update(BasketListItem basketListItem);
	boolean deleteByPid(String mid, int pid);
	boolean clearBasketByMid(String mid);

	List<BasketListItem> insertAndSelectAll(Basket basket);	
}
