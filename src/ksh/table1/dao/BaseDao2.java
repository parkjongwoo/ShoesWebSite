package ksh.table1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.Oracle_Info;

public class BaseDao2 implements Dao2{

	String driver="oracle.jdbc.driver.OracleDriver";
//	String url="jdbc:oracle:thin:@localhost:1521:orcl";
	String url=Oracle_Info.DB_URL;
	String username="scott";
	String password="tiger";

	public Connection getConnection() {

		Connection connection = null;

		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	public void closeDBOjects(ResultSet resultSet, Statement statement, Connection connection) {
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
