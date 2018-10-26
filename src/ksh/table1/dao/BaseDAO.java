package ksh.table1.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import common.Oracle_Info;

public class BaseDAO {

	Connection con = null;
	String url = Oracle_Info.DB_URL; 
	String user = "scott"; 
	String password = "tiger";
	
	public Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		con = DriverManager.getConnection(url, user, password);
		return con;
	}
}
