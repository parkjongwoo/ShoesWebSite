package jjh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import common.Oracle_Info;

public class BaseDao implements Dao{
	String driver="oracle.jdbc.driver.OracleDriver";
//	String url="jdbc:oracle:thin:@172.16.3.9:1521:orcl";
	String url = Oracle_Info.DB_URL;
	String username="scott";
	String password="tiger";

	@Override
	public Connection getConnection(){
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
			System.out.println("DB 접속 실패, 사유 : " + e.getMessage());
		}
		return con;
	}
	
	public void closeDB(ResultSet resultSet, Statement statement, Connection connection) {
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if(statement != null) {
			try {
				statement.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		if(connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
