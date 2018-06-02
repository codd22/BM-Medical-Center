package codd.major.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB 
{
	public static Connection Create(String database)
	{
		Connection con=null;
		String jdbcurl="jdbc:mysql://db4free.net:3306/"+database;
		String driver="com.mysql.cj.jdbc.Driver";
		String mysqlusername="softydb";
		String mysqlpassword="softy@database";
		
			try
			{
				Class.forName(driver);
				con=DriverManager.getConnection(jdbcurl, mysqlusername, mysqlpassword);
			    System.out.println("connected");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return con;
		}
}
