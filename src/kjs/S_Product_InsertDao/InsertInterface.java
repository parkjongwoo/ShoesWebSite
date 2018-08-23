package kjs.S_Product_InsertDao;

import java.util.List;

import kjs.S_ProductInsertModel.InsertModel;
import kjs.S_ProductInsertModel.ValueModel;


public interface InsertInterface {
	boolean Insert(InsertModel insertmodel);
	List<InsertModel> selectAll(int requestPage);
	List<ValueModel> select();
}
