package kjs.S_Product_DBDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.Oracle_Info;

public class BaseDao implements dao {

	public Connection getConnection() {
		
		String driver="oracle.jdbc.driver.OracleDriver";

	//	String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String url = Oracle_Info.DB_URL;
		String username="scott";
		String password="tiger";

		Connection conn=null;

		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(url, "scott", "tiger");

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
	public void closeDBObjects(ResultSet resultSet,Statement statement,Connection connection) {
		if(resultSet !=null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(statement !=null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(connection!=null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

