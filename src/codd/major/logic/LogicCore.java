package codd.major.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import codd.major.dao.DB;

public class LogicCore 
{
	static Integer count = 0;
	public static ResultSet LoginDetails(String sql,String database)
	{
		Connection con=DB.Create(database);
		try{
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs!=null)
		return rs;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getPatientIdBy(String firstName, String middleName, String lastName)
	{
	    
	    String res1 = firstName.substring(0,2);
	    String res2 = middleName.isEmpty() ? "0" : middleName.substring(0, 1);
	    String res3 = lastName.substring(0,2);
	    String res4 = res1 + res2 + res3;
	    String res5 = count.toString().length() == 1 ? ("00" + count)
	            : count.toString().length() == 2 ? ("0" + count) : count.toString();
	    count = count + 1;
	    String patientid = res4 + res5;
	    return patientid;
	}
	
	public static ResultSet FetchRecordByWhere(String sql,String database,String am)
	{
		Connection con=DB.Create(database);
		try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,am);
		ResultSet rs=ps.executeQuery();
		if(rs!=null)
		return rs;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static ResultSet FetchTest()
	{
		Connection con=DB.Create("majorproject");
		try{
		PreparedStatement ps=con.prepareStatement("select * from lab_test;");
		ResultSet rs=ps.executeQuery();
		if(rs!=null)
		return rs;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public static ResultSet Fetchdata(String sql,String id)
	{
		Connection con=DB.Create("majorproject");
		try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs!=null)
		return rs;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
