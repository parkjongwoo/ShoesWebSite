package jjh.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface Dao {
	Connection getConnection();
	void closeDB(ResultSet resultSet, Statement statement, Connection connection);
}
