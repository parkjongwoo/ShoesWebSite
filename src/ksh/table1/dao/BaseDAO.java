package ksh.table1.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDAO {

	Connection con = null;
	String url = "jdbc:oracle:thin:@localhost:1521:orcl"; 
	String user = "scott"; 
	String password = "tiger";
	
	public Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		con = DriverManager.getConnection(url, user, password);
		return con;
	}
}
