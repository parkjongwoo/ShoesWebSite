package pjw.basket.dao.productlist;

import java.util.List;

import pjw.produclistitem.model.ProductListItem;

public interface BasketDao {
	List<ProductListItem> selectNewItems();
	List<ProductListItem> selectPopItems();
	List<ProductListItem> selectCateItems(int cateNum);
	List<ProductListItem> selectByKeyword(String keyword);
}
