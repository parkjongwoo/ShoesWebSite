package pjw.produclistitem.dao.productlist;

import java.util.List;

import pjw.produclistitem.model.ProductListItem;

public interface ProductListItemDao {
	List<ProductListItem> selectNewItems();
	List<ProductListItem> selectPopItems();
}
